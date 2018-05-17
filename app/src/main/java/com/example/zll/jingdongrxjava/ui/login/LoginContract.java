package com.example.zll.jingdongrxjava.ui.login;

import com.example.zll.jingdongrxjava.bean.LoginBean;
import com.example.zll.jingdongrxjava.ui.base.BaseConterct;

/**
 * Created by zll on 2018/5/17.
 */

public interface LoginContract {
    interface View extends BaseConterct.baseview{
            void Loginview(LoginBean loginBean);
    }
    interface Presenter extends BaseConterct.basePresenter<View>{
             void getLoginPresenter(String mobile,String password);
    }
}
