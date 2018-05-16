package com.example.zll.jingdongrxjava.ui.myclass;

import com.example.zll.jingdongrxjava.bean.MyClassLeft;
import com.example.zll.jingdongrxjava.bean.MyRightBean;
import com.example.zll.jingdongrxjava.net.class1.LeftApi;
import com.example.zll.jingdongrxjava.net.class1.RightApi;
import com.example.zll.jingdongrxjava.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zll on 2018/5/11.
 */

public class MyRightPresenter extends BasePresenter<ClassCrenct.View> implements ClassCrenct.Presenter {

    private LeftApi leftApi;
    private RightApi rightApi;
    @Inject
    public MyRightPresenter(LeftApi leftApi, RightApi rightApi) {
        this.leftApi = leftApi;
        this.rightApi = rightApi;
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
                     if (mView!=null){
                         mView.getMyleft(myClassLeft);
                     }

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
    public void getright(String cid) {
       rightApi.getRight(cid)
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(new Observer<MyRightBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(MyRightBean rightBean) {
                         if (mView!=null){
                             mView.getMyRight(rightBean);
                         }

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
