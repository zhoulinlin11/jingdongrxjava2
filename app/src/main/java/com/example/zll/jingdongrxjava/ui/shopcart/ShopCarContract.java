package com.example.zll.jingdongrxjava.ui.shopcart;



import com.example.zll.jingdongrxjava.bean.GetCartsBean;
import com.example.zll.jingdongrxjava.bean.SellerBean;
import com.example.zll.jingdongrxjava.ui.base.BaseConterct;

import java.util.List;

/**
 * Created by zll on 2018/5/17.
 */

public interface ShopCarContract {
    interface View extends BaseConterct.baseview{
        void showCartList(List<SellerBean> groupList, List<List<GetCartsBean.DataBean.ListBean>> childList);

        void updateCartsSuccess(String msg);

        void deleteCartSuccess(String msg);
    }

    interface Presenter extends BaseConterct.basePresenter<View>

    {
        void getCarts(String uid, String token);

        void updateCarts(String uid, String sellerid, String pid, String num, String selected, String token);

        void deleteCart(String uid, String pid, String token);
    }
}
