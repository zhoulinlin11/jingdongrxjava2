package com.example.zll.jingdongrxjava.net.class1;

import com.example.zll.jingdongrxjava.bean.MyRightBean;

import java.text.NumberFormat;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zll on 2018/5/11.
 */

public interface RightService {
    @FormUrlEncoded
    @POST("product/getProductCatagory")
    Observable<MyRightBean> getRight(@Field("cid") String cid);
}
