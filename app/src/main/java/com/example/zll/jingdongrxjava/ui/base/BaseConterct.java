package com.example.zll.jingdongrxjava.ui.base;

/**
 * Created by zll on 2018/5/10.
 */

public interface BaseConterct {
    //抽取所有Presenter共性，比如显示进度条和关闭进度条
    interface baseview{
        void opendialog();
        void disLoding();
    }
    //抽取所有Presenter共性，比如绑定，解绑
     interface basePresenter<T extends baseview>{

        //绑定
        void attasuccess(T view);
        //解绑
        void disbundle();
    }

}
