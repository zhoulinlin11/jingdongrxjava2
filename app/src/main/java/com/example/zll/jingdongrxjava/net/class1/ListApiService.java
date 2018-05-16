package com.example.zll.jingdongrxjava.net.class1;



import com.example.zll.jingdongrxjava.bean.ProductsBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ListApiService {
    @FormUrlEncoded
    @POST("product/getProducts")
    Observable<ProductsBean> getProduct(@Field("pscid") String pscid);
}
