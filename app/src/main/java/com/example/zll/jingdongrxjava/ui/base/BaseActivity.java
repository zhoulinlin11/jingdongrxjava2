package com.example.zll.jingdongrxjava.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zll.jingdongrxjava.ibase.IBase;

import javax.inject.Inject;

/**
 * Created by zll on 2018/5/10.
 */

public abstract class BaseActivity<T extends BaseConterct.basePresenter> extends AppCompatActivity implements IBase,BaseConterct.baseview {
    @Inject
    protected  T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getcoutentLayout());
        inject();
        //绑定
        mPresenter.attasuccess(this);
    }





    @Override
    public void initView(View view) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        mPresenter.disbundle();
    }

    @Override
    public void opendialog() {

    }

    @Override
    public void disLoding() {

    }
}
