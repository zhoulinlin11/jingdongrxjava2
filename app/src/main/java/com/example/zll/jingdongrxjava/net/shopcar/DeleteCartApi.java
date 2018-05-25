package com.example.zll.jingdongrxjava.net.shopcar;


import com.example.zll.jingdongrxjava.bean.XiangQingBean;

import io.reactivex.Observable;

public class DeleteCartApi {
    private static DeleteCartApi deleteCartApi;
    private DeleteCartApiService deleteCartApiService;

    private DeleteCartApi(DeleteCartApiService deleteCartApiService) {
        this.deleteCartApiService = deleteCartApiService;
    }

    public static DeleteCartApi getDeleteCartApi(DeleteCartApiService deleteCartApiService) {
        if (deleteCartApi == null) {
            deleteCartApi = new DeleteCartApi(deleteCartApiService);
        }
        return deleteCartApi;
    }

    public Observable<XiangQingBean> deleteCart(String uid, String pid,
                                                String token) {
        return deleteCartApiService.deleteCart(uid, pid, token);
    }
}
