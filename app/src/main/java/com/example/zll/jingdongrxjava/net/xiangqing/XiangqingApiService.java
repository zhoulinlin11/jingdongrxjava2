package com.example.zll.jingdongrxjava.net.xiangqing;

import com.example.zll.jingdongrxjava.bean.XiangQingBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by zll on 2018/5/16.
 */

public interface XiangqingApiService {
    @FormUrlEncoded
    @POST("product/addCart")
    Observable<XiangQingBean> getXiang(@Field("Uid") String uid,
                                       @Field("Pid") String pid,
                                       @Field("Token") String token);
}
