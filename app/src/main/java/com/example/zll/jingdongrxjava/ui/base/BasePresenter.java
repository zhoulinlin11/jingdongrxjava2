package com.example.zll.jingdongrxjava.ui.base;

/**
 * Created by zll on 2018/5/10.
 */

public class BasePresenter<T extends BaseConterct.baseview> implements BaseConterct.basePresenter<T> {

    protected T mView;
    @Override
    public void attasuccess(T view) {
       this.mView=view;
    }

    @Override
    public void disbundle() {
        if (mView!=null){
            mView=null;
        }

    }
}
