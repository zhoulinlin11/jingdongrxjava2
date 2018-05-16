package com.example.zll.jingdongrxjava.net.class1;

import com.example.zll.jingdongrxjava.bean.MyClassLeft;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/5/10.
 */

public class LeftApi {
    //单例模式
    private static LeftApi leftApi;
    private LeftService leftService;

    public LeftApi(LeftService leftService) {
        this.leftService = leftService;
    }
    public static LeftApi getLeftApi(LeftService leftService){
        if (leftApi==null){
            leftApi=new LeftApi(leftService);
        }
        return leftApi;
    }
    public Observable<MyClassLeft> getleft(){
        return leftService.getleft();
    }
}
