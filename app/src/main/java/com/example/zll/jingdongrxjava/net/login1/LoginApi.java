package com.example.zll.jingdongrxjava.net.login1;

import com.example.zll.jingdongrxjava.bean.LoginBean;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/5/17.
 */

public class LoginApi {
  private static   LoginApi loginApi;
   private LoginApiService loginApiService;

    public LoginApi(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    public static LoginApi getLoginApi(LoginApiService loginApiService){
        if (loginApi==null){
            loginApi=new LoginApi(loginApiService);
        }
        return loginApi;
    }
    public Observable<LoginBean> getLogin(String mobile,String password){
        return loginApiService.getlogin(mobile, password);
    }
}
