package com.example.zll.jingdongrxjava.ui.Xiangqing;

import com.example.zll.jingdongrxjava.bean.XiangQingBean;
import com.example.zll.jingdongrxjava.net.xiangqing.XiangqingApi;
import com.example.zll.jingdongrxjava.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zll on 2018/5/16.
 */

public class XiangqingPresenter extends BasePresenter<XiangCrentent.View> implements XiangCrentent.Presenter {
    XiangqingApi xiangqingApi;
     @Inject
    public XiangqingPresenter(XiangqingApi xiangqingApi) {
        this.xiangqingApi = xiangqingApi;
    }

    @Override
    public void getxiang(String uid,String pid,String token) {
         xiangqingApi.getXiang(pid,pid,token)
                 .observeOn(Schedulers.newThread())
                 .subscribeOn(Schedulers.io())
                 .map(new Function<XiangQingBean, String>() {
                     @Override
                     public String apply(XiangQingBean xiangQingBean) throws Exception {
                         return xiangQingBean.getMsg();
                     }
                 })
                 .subscribe(new Consumer<String>() {
                     @Override
                     public void accept(String s) throws Exception {
                      if (mView!=null){
                          mView.getxiangmu(s);
                      }
                     }
                 });

}
}
