package com.example.zll.jingdongrxjava.net.login1;

import com.example.zll.jingdongrxjava.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zll on 2018/5/17.
 */

public interface LoginApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> getlogin(@Field("mobile") String mobile, @Field("password") String password);
}
