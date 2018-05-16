package com.example.zll.jingdongrxjava.ui.homepage;

import com.example.zll.jingdongrxjava.bean.HomePageBean;
import com.example.zll.jingdongrxjava.bean.MyClassLeft;
import com.example.zll.jingdongrxjava.net.class1.LeftApi;
import com.example.zll.jingdongrxjava.net.home.HomeApi;
import com.example.zll.jingdongrxjava.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zll on 2018/5/10.
 */

public class HomePresenter extends BasePresenter<HomePageContract.View> implements HomePageContract.Presenter {
    private HomeApi homeApi;
    private LeftApi leftApi;

    @Inject
    public HomePresenter(HomeApi homeApi, LeftApi leftApi) {
        this.homeApi = homeApi;
        this.leftApi = leftApi;
    }

    @Override
    public void gethome() {
        homeApi.getAd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HomePageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomePageBean homePageBean) {
                     mView.getHomeage(homePageBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getleft() {
        leftApi.getleft()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MyClassLeft>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyClassLeft myClassLeft) {
                        mView.getMyleft(myClassLeft);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
