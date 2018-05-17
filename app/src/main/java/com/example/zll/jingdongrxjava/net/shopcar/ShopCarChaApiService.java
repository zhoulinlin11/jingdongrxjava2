package com.example.zll.jingdongrxjava.net.shopcar;

import com.example.zll.jingdongrxjava.bean.GetCartsBean;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zll on 2018/5/17.
 */

public interface ShopCarChaApiService {
    @FormUrlEncoded
    @POST("product/getCarts")
    Observable<GetCartsBean> getCart(@Field("Uid") String uid, @Field("Token") String token);
}
