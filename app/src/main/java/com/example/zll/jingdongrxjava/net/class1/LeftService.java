package com.example.zll.jingdongrxjava.net.class1;

import com.example.zll.jingdongrxjava.bean.MyClassLeft;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zll on 2018/5/10.
 */

public interface LeftService {
    @GET("product/getCatagory")
    Observable<MyClassLeft> getleft();
}
