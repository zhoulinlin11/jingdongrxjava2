package com.example.zll.jingdongrxjava.net.xiangqing;

import com.example.zll.jingdongrxjava.bean.XiangQingBean;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/5/16.
 */

public class XiangqingApi {
    private static XiangqingApi getXingqing;
    private XiangqingApiService getXiangqingApiService;

    public XiangqingApi(XiangqingApiService getXiangqingApiService) {
        this.getXiangqingApiService = getXiangqingApiService;
    }
    public static XiangqingApi getGetXingqing(XiangqingApiService getXiangqingApiService){
       if (getXingqing==null){
           getXingqing=new XiangqingApi(getXiangqingApiService);
       }
       return getXingqing;
    }
    public Observable<XiangQingBean> getXiang(String uid, String pid, String token){
        return getXiangqingApiService.getXiang(uid,pid,token);
    }

}
