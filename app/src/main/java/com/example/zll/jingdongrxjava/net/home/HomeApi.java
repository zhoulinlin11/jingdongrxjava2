package com.example.zll.jingdongrxjava.net.home;

import com.example.zll.jingdongrxjava.bean.HomePageBean;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/5/10.
 */

public class HomeApi {
    private static HomeApi homeApi;
    private HomepagerService homepagerService;

    private HomeApi(HomepagerService homepagerService) {
        this.homepagerService = homepagerService;
    }
    public static HomeApi getHomeApi(HomepagerService homepagerService){
        if (homeApi==null){
            homeApi=new HomeApi(homepagerService);
        }
        return homeApi;
    }
    public Observable<HomePageBean> getAd(){
        return homepagerService.getAd();
    }
}
