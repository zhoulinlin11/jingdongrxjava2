package com.example.zll.jingdongrxjava;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zll.jingdongrxjava.bean.HomePageBean;
import com.example.zll.jingdongrxjava.bean.ProductsBean;
import com.example.zll.jingdongrxjava.component.DaggerHttpComponent;
import com.example.zll.jingdongrxjava.fragment.ShopCarFragment;
import com.example.zll.jingdongrxjava.module.HttpModule;
import com.example.zll.jingdongrxjava.ui.Xiangqing.XiangCrentent;
import com.example.zll.jingdongrxjava.ui.Xiangqing.XiangqingPresenter;
import com.example.zll.jingdongrxjava.ui.base.BaseActivity;
import com.example.zll.jingdongrxjava.utils.GlideImageLoader;
import com.example.zll.jingdongrxjava.utils.SharedPreferencesUtils;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


public class ListDetailsActivity extends BaseActivity<XiangqingPresenter> implements XiangCrentent.View, View.OnClickListener {

    private ProductsBean.DataBean bean;
    private ImageView ivShare;
    private Banner banner;
    private TextView tvTitle;
    private TextView tvPrice;
    private TextView tvVipPrice;
    private HomePageBean.TuijianBean.ListBean listBean;
    /**
     * 购物车
     */
    private TextView tvShopCard;
    /**
     * 加入购物车
     */
    private TextView tvAddCard;
private int flag;
private String images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);

        Intent intent=getIntent();
        flag=intent.getIntExtra("flag",-1);
        if (flag==-1){
            return;
        }
        if (flag==SousuoActivity.SOUSUOACTIVITY){
            bean= (ProductsBean.DataBean) intent.getSerializableExtra("bean");
             images=bean.getImages();
        }else{
           listBean= (HomePageBean.TuijianBean.ListBean) intent.getSerializableExtra("bean");
           images=listBean.getImages();
        }
        initView();
        setData();
    }

    private void setData() {
        int money=0;
        if (flag==SousuoActivity.SOUSUOACTIVITY){
            money=bean.getSalenum();
        }else{
            money=listBean.getSalenum();
        }

        //给原价加横线
        SpannableString spannableString = new SpannableString("原价" + bean.getSalenum());
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
       spannableString.setSpan(strikethroughSpan,0,spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
       tvPrice.setText(spannableString);
       banner.setOnBannerListener(new OnBannerListener() {
           @Override
           public void OnBannerClick(int position) {
                Intent intent=new Intent(ListDetailsActivity.this,BannerDetailsActivity.class);
                intent.putExtra("imgs",images);
                intent.putExtra("position",position);
                startActivity(intent);
           }
       });
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        String[] imgs = bean.getImages().split("\\|");

        if (flag==SousuoActivity.SOUSUOACTIVITY){
            imgs=bean.getImages().split("\\|");
           tvTitle.setText(bean.getTitle());
            tvVipPrice.setText("现价:"+bean.getPrice());
        }else {
            imgs=bean.getImages().split("\\|");
            tvTitle.setText(bean.getTitle());
            tvVipPrice.setText("现价:"+listBean.getPrice());
        }
        //设置图片结合
        banner.setImages(Arrays.asList(imgs));
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }

    @Override
    public int getcoutentLayout() {
        return R.layout.activity_list_details;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }


    @Override
    public void getxiangmu(String str) {
        Toast.makeText(ListDetailsActivity.this,str,Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        ivShare = (ImageView) findViewById(R.id.ivShare);
        banner = (Banner) findViewById(R.id.banner);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvVipPrice = (TextView) findViewById(R.id.tvVipPrice);
        tvShopCard = (TextView) findViewById(R.id.tvShopCard);
        tvAddCard = (TextView) findViewById(R.id.tvAddCard);
        ivShare.setOnClickListener(this);
        tvVipPrice.setOnClickListener(this);
        tvAddCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.tvAddCard:
              String token = (String) SharedPreferencesUtils.getParam(ListDetailsActivity.this, "token", "");
              if (TextUtils.isEmpty(token)){
                  Intent intent=new Intent(ListDetailsActivity.this,LoginActivity.class);
                  startActivity(intent);
              }else{
                  String uid = (String) SharedPreferencesUtils.getParam(ListDetailsActivity.this, "uid", "");
                 int pid=0;
                 if (flag== SousuoActivity.SOUSUOACTIVITY){
                     pid=bean.getPid();
                 }else{
                     pid=listBean.getPid();
                 }
                 mPresenter.getxiang(uid,pid+"",token);
              }
              break;
          case R.id.tvShopCard:
              Intent intent=new Intent(ListDetailsActivity.this, ShopCarFragment.class);
              startActivity(intent);
              break;
      }
    }
}
