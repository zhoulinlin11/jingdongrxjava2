package com.example.zll.jingdongrxjava.ui.myclass;


import com.example.zll.jingdongrxjava.bean.ProductsBean;
import com.example.zll.jingdongrxjava.ui.base.BaseConterct;

import java.util.List;

public interface ListContract {
    interface View extends BaseConterct.baseview{
        void onSuccess(List<ProductsBean.DataBean> list);
    }

    interface Presenter extends BaseConterct.basePresenter<View> {
        void getProducts(String pscid);
    }
}
