package com.example.zll.jingdongrxjava.net.shopcar;


import com.example.zll.jingdongrxjava.bean.XiangQingBean;

import io.reactivex.Observable;

public class UpdateCartApi {
    private static UpdateCartApi updateCartApi;
    private UpdateCartApiService updateCartApiService;

    private UpdateCartApi(UpdateCartApiService updateCartApiService) {
        this.updateCartApiService = updateCartApiService;
    }

    public static UpdateCartApi getUpdateCartApi(UpdateCartApiService updateCartApiService) {
        if (updateCartApi == null) {
            updateCartApi = new UpdateCartApi(updateCartApiService);
        }
        return updateCartApi;
    }

    public Observable<XiangQingBean> updateCarts(String uid, String sellerid, String pid, String num, String selected,
                                                 String token) {
        return updateCartApiService.updateCarts(uid, sellerid, pid, num, selected, token);
    }
}
