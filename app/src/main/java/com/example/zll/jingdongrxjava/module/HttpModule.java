package com.example.zll.jingdongrxjava.module;

import com.example.zll.jingdongrxjava.net.Api;
import com.example.zll.jingdongrxjava.net.class1.LeftApi;
import com.example.zll.jingdongrxjava.net.class1.LeftService;
import com.example.zll.jingdongrxjava.net.class1.ListApi;
import com.example.zll.jingdongrxjava.net.class1.ListApiService;
import com.example.zll.jingdongrxjava.net.class1.RightApi;
import com.example.zll.jingdongrxjava.net.class1.RightService;
import com.example.zll.jingdongrxjava.net.home.HomeApi;
import com.example.zll.jingdongrxjava.net.home.HomepagerService;
import com.example.zll.jingdongrxjava.net.login1.LoginApi;
import com.example.zll.jingdongrxjava.net.login1.LoginApiService;
import com.example.zll.jingdongrxjava.net.shopcar.DeleteCartApi;
import com.example.zll.jingdongrxjava.net.shopcar.DeleteCartApiService;
import com.example.zll.jingdongrxjava.net.shopcar.ShopCarChaApi;
import com.example.zll.jingdongrxjava.net.shopcar.ShopCarChaApiService;
import com.example.zll.jingdongrxjava.net.shopcar.UpdateCartApi;
import com.example.zll.jingdongrxjava.net.shopcar.UpdateCartApiService;
import com.example.zll.jingdongrxjava.net.xiangqing.XiangqingApi;
import com.example.zll.jingdongrxjava.net.xiangqing.XiangqingApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zll on 2018/5/10.
 */
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS);
    }
    @Provides
    HomeApi provideHomeApi(OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(Api.BASEURL)
                     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        HomepagerService homepagerService=retrofit.create(HomepagerService.class);
        return HomeApi.getHomeApi(homepagerService);
    }
    @Provides
    LeftApi provideLeftApi(OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                  .baseUrl(Api.BASEURL)
                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                  .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        LeftService leftService=retrofit.create(LeftService.class);
        return  LeftApi.getLeftApi(leftService);
    }
    @Provides
    RightApi provideRightApi(OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        RightService rightService = retrofit.create(RightService.class);
        return RightApi.getRightApi(rightService);

    }
    @Provides
    ListApi provideListApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ListApiService listApiService = retrofit.create(ListApiService.class);
        return ListApi.getListApi(listApiService);
    }
    @Provides
    XiangqingApi provideXiangqingApi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        XiangqingApiService xiangqingApiService = retrofit.create(XiangqingApiService.class);
        return XiangqingApi.getGetXingqing(xiangqingApiService);
    }
    @Provides
    LoginApi provideLoginApi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        LoginApiService loginApiApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiApiService);
    }
    @Provides
    ShopCarChaApi provideShopCarChaApi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ShopCarChaApiService shopCarChaApiService= retrofit.create(ShopCarChaApiService.class);
        return ShopCarChaApi.getGetCartApi(shopCarChaApiService);
    }
    @Provides
    UpdateCartApi provideUpdateCartApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        UpdateCartApiService updateCartApiService = retrofit.create(UpdateCartApiService.class);
        return UpdateCartApi.getUpdateCartApi(updateCartApiService);
    }

    @Provides
    DeleteCartApi provideDeleteCartApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        DeleteCartApiService deleteCartApiService = retrofit.create(DeleteCartApiService.class);
        return DeleteCartApi.getDeleteCartApi(deleteCartApiService);
    }



}
