package com.example.zll.jingdongrxjava.net.shopcar;

import com.example.zll.jingdongrxjava.bean.GetCartsBean;

import io.reactivex.Observable;

/**
 * Created by zll on 2018/5/17.
 */

public class ShopCarChaApi {
    private static ShopCarChaApi getShopCarChaApi;
    private ShopCarChaApiService getShopCarChaApiService;

    private ShopCarChaApi(ShopCarChaApiService getShopCarChaApiService) {
        this.getShopCarChaApiService = getShopCarChaApiService;
    }

    public static ShopCarChaApi getGetCartApi(ShopCarChaApiService getShopCarChaApiService) {
        if (getShopCarChaApi== null) {
            getShopCarChaApi = new ShopCarChaApi(getShopCarChaApiService);
        }
        return getShopCarChaApi;
    }

    public Observable<GetCartsBean> getCatagory(String uid, String token) {
        return getShopCarChaApiService.getCart(uid, token);
    }
}
