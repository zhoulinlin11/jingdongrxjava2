package com.example.zll.jingdongrxjava.ui.Xiangqing;

import com.example.zll.jingdongrxjava.bean.XiangQingBean;
import com.example.zll.jingdongrxjava.ui.base.BaseConterct;
import com.example.zll.jingdongrxjava.ui.base.BasePresenter;

/**
 * Created by zll on 2018/5/16.
 */

public interface XiangCrentent {
    interface View extends BaseConterct.baseview{
     void getxiangmu(String str);
    }
    interface Presenter extends BaseConterct.basePresenter<View>{
    void getxiang(String uid, String pid, String token);
    }
}
