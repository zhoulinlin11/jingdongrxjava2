package com.example.zll.jingdongrxjava.net.home;

import com.example.zll.jingdongrxjava.bean.HomePageBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zll on 2018/5/10.
 */

public interface HomepagerService {
@GET("ad/getAd")
    Observable<HomePageBean> getAd();
}
