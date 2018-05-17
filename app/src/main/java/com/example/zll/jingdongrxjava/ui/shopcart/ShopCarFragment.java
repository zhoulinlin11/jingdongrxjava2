package com.example.zll.jingdongrxjava.ui.shopcart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zll.jingdongrxjava.R;
import com.example.zll.jingdongrxjava.bean.GetCartsBean;
import com.example.zll.jingdongrxjava.bean.SellerBean;
import com.example.zll.jingdongrxjava.ui.base.BaseFragment;

import java.util.List;

/**
 * Created by zll on 2018/5/10.
 */

public class ShopCarFragment extends BaseFragment<ShopCarContract.Presenter> implements ShopCarContract.View {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.shopcar, container, false);
        return inflate;
    }

    @Override
    public int getcoutentLayout() {
        return 0;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void showCartList(List<SellerBean> groupList, List<List<GetCartsBean.DataBean.ListBean>> childList) {

    }
}
