package com.example.zll.jingdongrxjava.net.class1;

import com.example.zll.jingdongrxjava.bean.MyRightBean;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/5/11.
 */

public class RightApi {
    private static RightApi rightApi;
    private RightService rightService;

    public RightApi(RightService rightService) {
        this.rightService = rightService;
    }

    public static RightApi getRightApi(RightService rightService){
        if (rightApi==null){
            rightApi=new RightApi(rightService);
        }
        return rightApi;
    }
    public Observable<MyRightBean> getRight(String cid){
        return rightService.getRight(cid);
    }

}
