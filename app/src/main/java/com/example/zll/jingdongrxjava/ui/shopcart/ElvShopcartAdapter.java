package com.example.zll.jingdongrxjava.ui.shopcart;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zll.jingdongrxjava.R;
import com.example.zll.jingdongrxjava.bean.GetCartsBean;
import com.example.zll.jingdongrxjava.bean.SellerBean;
import com.example.zll.jingdongrxjava.ui.shopcart.widget.AddSubView;
import com.example.zll.jingdongrxjava.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

public class ElvShopcartAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<SellerBean> groupList;
    private List<List<GetCartsBean.DataBean.ListBean>> childList;
    private LayoutInflater inflater;
    private final String uid;
    private final String token;
    private ProgressDialog progressDialog;
    private int productIndex;
    private int groupPosition;
    private boolean checked;
    private static final int GETCARTS = 0;//查询购物车
    private static final int UPDATE_PRODUCT = 1; //更新商品
    private static final int UPDATE_SELLER = 2; //更新卖家
    private static int state = GETCARTS;
    private boolean allSelected;
    private ShopcartPresenter shopcartPresenter;

    public ElvShopcartAdapter(Context context, List<SellerBean> groupList, List<List<GetCartsBean.DataBean.ListBean>>
            childList, ShopcartPresenter shopcartPresenter, ProgressDialog progressDialog) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
        inflater = LayoutInflater.from(context);
        this.shopcartPresenter = shopcartPresenter;

        uid = (String) SharedPreferencesUtils.getParam(context, "uid", "");
        token = (String) SharedPreferencesUtils.getParam(context, "token", "");
        //初始化进度对话框
        this.progressDialog = progressDialog;


    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final GroupViewHolder groupViewHolder;
        if (convertView == null) {
            groupViewHolder = new GroupViewHolder();
            convertView = inflater.inflate(R.layout.shopcart_seller_item, null);
            groupViewHolder.cbSeller = convertView.findViewById(R.id.cbSeller);
            groupViewHolder.tvSeller = convertView.findViewById(R.id.tvSeller);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        //设置值
        SellerBean sellerBean = groupList.get(groupPosition);
        groupViewHolder.tvSeller.setText(sellerBean.getSellerName());
        groupViewHolder.cbSeller.setChecked(sellerBean.isSelected());

        //给商家checkbox设置点击事件
        groupViewHolder.cbSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置当前的更新状态
                state = UPDATE_PRODUCT;
                //显示进度条
                progressDialog.show();
                //默认从第一个商品开始更新购物车状态
                productIndex = 0;
                //全局记录一下当前更新的商家
                ElvShopcartAdapter.this.groupPosition = groupPosition;
                //该商家是否选中
                checked = groupViewHolder.cbSeller.isChecked();
                //更新商家下的商品状态
                updateProductInSeller();
            }

        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView,
                             ViewGroup
                                     parent) {

        final ChildViewHolder childViewHolder;
        if (convertView == null) {
            childViewHolder = new ChildViewHolder();
            convertView = inflater.inflate(R.layout.shopcart_seller_product_item, null);
            childViewHolder.cbProduct = convertView.findViewById(R.id.cbProduct);
            childViewHolder.iv = convertView.findViewById(R.id.iv);
            childViewHolder.tvTitle = convertView.findViewById(R.id.tvTitle);
            childViewHolder.tvPrice = convertView.findViewById(R.id.tvPrice);
            childViewHolder.tvDel = convertView.findViewById(R.id.tvDel);
            childViewHolder.addSubView = convertView.findViewById(R.id.addSubCard);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        final GetCartsBean.DataBean.ListBean listBean = childList.get(groupPosition).get(childPosition);
        //根据服务器返回的select值，给checkBox设置是否选中
        childViewHolder.cbProduct.setChecked(listBean.getSelected() == 1 ? true : false);
        childViewHolder.tvTitle.setText(listBean.getTitle());
        childViewHolder.tvPrice.setText(listBean.getPrice() + "");
        Glide.with(context).load(listBean.getImages().split("\\|")[0]).into(childViewHolder.iv);
        childViewHolder.addSubView.setNum(listBean.getNum() + "");
        //给二级列表的checkbox设置点击事件
        childViewHolder.cbProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = GETCARTS;
                //显示进度条
                progressDialog.show();
                ElvShopcartAdapter.this.groupPosition = groupPosition;
                //调用更新购物车接口，改变购物车的状态
                //获取卖家id
                String sellerid = groupList.get(groupPosition).getSellerid();
                //获取pid
                String pid = listBean.getPid() + "";
                //是否选中
                boolean childChecked = childViewHolder.cbProduct.isChecked();

                shopcartPresenter.updateCarts(uid, sellerid, pid, "1", childChecked ? "1" : "0", token);
            }
        });

        //给加号设置点击事件
        childViewHolder.addSubView.setAddOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                state = GETCARTS;
                //获取sellerId
                String sellerid = groupList.get(groupPosition).getSellerid();
                //获取pid
                int pid = listBean.getPid();
                //获取数量
                int num = listBean.getNum();
                num += 1;
                //是否选中
                String isChecked = childViewHolder.cbProduct.isChecked() ? "1" : "0";
                //调用更新购物车的接口即可
                shopcartPresenter.updateCarts(uid, sellerid, pid + "", num + "", isChecked, token);
            }
        });

        //给减号设置点击事件
        childViewHolder.addSubView.setSubOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                state = GETCARTS;
                //获取当前商品的数量
                int num = listBean.getNum();
                if (num <= 1) {
                    progressDialog.dismiss();
                    Toast.makeText(context, "数量不能小于1", Toast.LENGTH_SHORT).show();
                    return;
                }
                num -= 1;

                //获取sellerId
                String sellerid = groupList.get(groupPosition).getSellerid();
                //获取pid
                int pid = listBean.getPid();
                //是否选中
                String isChecked = childViewHolder.cbProduct.isChecked() ? "1" : "0";
                //更新购物车
                shopcartPresenter.updateCarts(uid, sellerid, pid + "", num + "", isChecked, token);
            }
        });

        //给删除设置点击事件
        childViewHolder.tvDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                state = GETCARTS;
                //获取pid
                int pid = listBean.getPid();
                //删除购物车里的选项
                shopcartPresenter.deleteCart(uid, pid + "", token);

            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    //删除成功回调接口
    public void delSuccess() {
        shopcartPresenter.getCarts(uid, token);
    }


    class GroupViewHolder {
        CheckBox cbSeller;
        TextView tvSeller;
    }

    class ChildViewHolder {
        CheckBox cbProduct;
        ImageView iv;
        TextView tvTitle;
        TextView tvPrice;
        TextView tvDel;
        AddSubView addSubView;
    }

    //更新购物车成功回调的方法
    public void updataSuccess() {
        switch (state) {
            case GETCARTS:
                //更新成功以后调用查询购物车接口
                productIndex = 0;
                groupPosition = 0;
                shopcartPresenter.getCarts(uid, token);
                break;
            case UPDATE_PRODUCT:
                //更新成功一个商品以后，再接着更新该商家下面的其它商品，直到没有商品为止
                productIndex++;
                //下标是否越界
                if (productIndex < childList.get(groupPosition).size()) {
                    //可以继续跟新商品
                    updateProductInSeller();
                } else {
                    //商品已经全部更新完成，请查询购物车
                    state = GETCARTS;
                    updataSuccess();
                }
                break;
            case UPDATE_SELLER:
                //遍历所有商家下的商品，并更新状态
                productIndex++;
                //下标是否越界
                if (productIndex < childList.get(groupPosition).size()) {
                    //可以继续跟新商品
                    updateProductInSeller(allSelected);
                } else {
                    //商品已经全部更新完成，请查询购物车
                    productIndex = 0;
                    groupPosition++;
                    if (groupPosition < groupList.size()) {
                        //可以继续跟新商品
                        updateProductInSeller(allSelected);
                    } else {
                        //商品已经全部更新完成，请查询购物车
                        state = GETCARTS;
                        updataSuccess();
                    }
                }
                break;
        }

    }


    private void updateProductInSeller() {
        //获取SellerId
        SellerBean sellerBean = groupList.get(groupPosition);
        String sellerid = sellerBean.getSellerid();
        //获取pid
        GetCartsBean.DataBean.ListBean listBean = childList.get(groupPosition).get(productIndex);
        int num = listBean.getNum();
        int pid = listBean.getPid();
        shopcartPresenter.updateCarts(uid, sellerid, pid + "", num + "", checked ? "1" : "0", token);
    }

    private void updateProductInSeller(boolean bool) {
        //获取SellerId
        SellerBean sellerBean = groupList.get(groupPosition);
        String sellerid = sellerBean.getSellerid();
        //获取pid
        GetCartsBean.DataBean.ListBean listBean = childList.get(groupPosition).get(productIndex);
        int pid = listBean.getPid();
        int num = listBean.getNum();
        shopcartPresenter.updateCarts(uid, sellerid, pid + "", num + "", bool ? "1" : "0", token);
    }

    /**
     * 计算数量和价钱
     *
     * @return
     */
    public String[] computeMoneyAndNum() {
        double sum = 0;
        int num = 0;
        for (int i = 0; i < groupList.size(); i++) {
            for (int j = 0; j < childList.get(i).size(); j++) {
                //判断商品是否选中
                GetCartsBean.DataBean.ListBean listBean = childList.get(i).get(j);
                if (listBean.getSelected() == 1) {
                    //该商品为选中状态
                    sum += listBean.getPrice() * listBean.getNum();
                    num += listBean.getNum();
                }
            }
        }
        return new String[]{sum + "", num + ""};
    }

    public void changeAllState(boolean bool) {
        this.allSelected = bool;
        state = UPDATE_SELLER;
        //遍历商家下的商品，修改状态
        updateProductInSeller(bool);

    }

    public List<SellerBean> getGroupList() {
        //先创建一个集合
        List<SellerBean> gList = new ArrayList<>();
        //遍历原先的groupList
        for (int i = 0; i < groupList.size(); i++) {
            for (int j = 0;j<childList.get(i).size();j++){
                if (childList.get(i).get(j).getSelected() == 1) {
                    if (!gList.contains(groupList.get(i))){
                        gList.add(groupList.get(i));
                    }

                }
            }
        }
        return gList;
    }

    public List<List<GetCartsBean.DataBean.ListBean>> getchildList() {
        List<List<GetCartsBean.DataBean.ListBean>> cList = new ArrayList<>();
        for (int i = 0; i < groupList.size(); i++) {
            List<GetCartsBean.DataBean.ListBean> l = new ArrayList<>();
            for (int j = 0; j < childList.get(i).size(); j++) {
                if (childList.get(i).get(j).getSelected() == 1) {
                    l.add(childList.get(i).get(j));
                }
            }
            if (l.size()>0){
                cList.add(l);
            }

        }
        return cList;
    }
}