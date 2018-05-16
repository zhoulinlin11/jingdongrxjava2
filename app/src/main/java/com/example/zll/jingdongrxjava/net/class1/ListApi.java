package com.example.zll.jingdongrxjava.net.class1;


import com.example.zll.jingdongrxjava.bean.ProductsBean;

import io.reactivex.Observable;

public class ListApi {
    private static ListApi listApi;
    private ListApiService listApiService;

    private ListApi(ListApiService listApiService) {
        this.listApiService = listApiService;
    }

    public static ListApi getListApi(ListApiService listApiService) {
        if (listApi == null) {
            listApi = new ListApi(listApiService);
        }
        return listApi;
    }

    public Observable<ProductsBean> getProduct(String pscid) {
        return listApiService.getProduct(pscid);
    }
}
