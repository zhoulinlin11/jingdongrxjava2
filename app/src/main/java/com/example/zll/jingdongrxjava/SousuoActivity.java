package com.example.zll.jingdongrxjava;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.zll.jingdongrxjava.bean.ProductsBean;
import com.example.zll.jingdongrxjava.component.DaggerHttpComponent;
import com.example.zll.jingdongrxjava.module.HttpModule;
import com.example.zll.jingdongrxjava.ui.base.BaseActivity;
import com.example.zll.jingdongrxjava.ui.myclass.ListContract;
import com.example.zll.jingdongrxjava.ui.myclass.ListPresenter;
import com.example.zll.jingdongrxjava.ui.myclass.adapter.XrvListAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zll on 2018/5/15.
 */

public class SousuoActivity extends BaseActivity<ListPresenter> implements ListContract.View {

    private XRecyclerView mXrv;
    private int pscid;
    private boolean isRefresh = true;
    private XrvListAdapter adapter;
    public static final int SOUSUOACTIVITY= 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取pscid
        Intent intent = getIntent();
        pscid = intent.getIntExtra("pscid", 0);
        initView();
        mPresenter.getProducts(pscid + "");
    }

private void initView() {
    mXrv = (XRecyclerView) findViewById(R.id.xrv);
    //设置布局管理器
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    mXrv.setLayoutManager(linearLayoutManager);

    //设置刷新和加载更多监听
    mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
        @Override
        public void onRefresh() {
            //刷新
            isRefresh = true;
            mPresenter.getProducts(pscid + "");
        }

        @Override
        public void onLoadMore() {
            //加载更多
            isRefresh = false;
            mPresenter.getProducts(pscid + "");
        }
    });

}


    @Override
    public int getcoutentLayout() {
        return R.layout.activity_sousuo;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void onSuccess(List<ProductsBean.DataBean> list) {
        final List<ProductsBean.DataBean> tempList = new ArrayList<>();
        tempList.addAll(list);
        //创建适配器
        if (isRefresh) {
            adapter = new XrvListAdapter(this, list);
            mXrv.setAdapter(adapter);
            adapter.refresh(tempList);
            mXrv.refreshComplete();//设置刷新完成
        } else {
            if (adapter != null) {
                //判断适配器是否创建过
                adapter.loadMore(tempList);
                mXrv.loadMoreComplete();//设置加载更多完成
            }
        }
        if (adapter == null) {
            return;
        }
        adapter.setOnListItemClickListener(new XrvListAdapter.OnListItemClickListener() {
            @Override
            public void OnItemClick(ProductsBean.DataBean dataBean) {
                Intent intent = new Intent(SousuoActivity.this, ListDetailsActivity.class);
                intent.putExtra("bean", dataBean);
                intent.putExtra("flag",SOUSUOACTIVITY);
                startActivity(intent);
            }
        });
    }
}
