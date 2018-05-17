package com.example.zll.jingdongrxjava.ui.login;

import com.example.zll.jingdongrxjava.bean.LoginBean;
import com.example.zll.jingdongrxjava.net.login1.LoginApi;
import com.example.zll.jingdongrxjava.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zll on 2018/5/17.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    LoginApi loginApi;

    @Inject
    public LoginPresenter(LoginApi loginApi) {
        this.loginApi = loginApi;
    }

    @Override
    public void getLoginPresenter(String mobile, String password) {
       loginApi.getLogin(mobile,password)
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
               .subscribe(new Observer<LoginBean>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(LoginBean loginBean) {
                     mView.Loginview(loginBean);
                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }
}
