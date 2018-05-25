package com.example.zll.jingdongrxjava.net.shopcar;



import com.example.zll.jingdongrxjava.bean.XiangQingBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DeleteCartApiService {
    @FormUrlEncoded
    @POST("product/deleteCart")
    Observable<XiangQingBean> deleteCart(@Field("uid") String uid,
                                         @Field("pid") String pid,
                                         @Field("token") String token);

}
