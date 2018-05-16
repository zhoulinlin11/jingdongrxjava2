package com.example.zll.jingdongrxjava.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zll.jingdongrxjava.ibase.IBase;

import javax.inject.Inject;

/**
 * Created by zll on 2018/5/10.
 */

public abstract class BaseFragment<T extends BaseConterct.basePresenter> extends Fragment implements IBase,BaseConterct.baseview {
   @Inject
   protected T mPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        mPresenter.attasuccess(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.disbundle();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(getcoutentLayout(),null);
       initView(view);
        return view;
    }

    @Override
    public void opendialog() {

    }

    @Override
    public void disLoding() {

    }
}
