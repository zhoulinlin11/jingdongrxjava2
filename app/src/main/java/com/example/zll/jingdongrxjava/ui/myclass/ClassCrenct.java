package com.example.zll.jingdongrxjava.ui.myclass;

import com.example.zll.jingdongrxjava.bean.MyClassLeft;
import com.example.zll.jingdongrxjava.bean.MyRightBean;
import com.example.zll.jingdongrxjava.ui.base.BaseConterct;

/**
 * Created by zll on 2018/5/11.
 */

public interface ClassCrenct {
    interface View extends BaseConterct.baseview {
        void getMyleft(MyClassLeft myClassLeft);
        void getMyRight(MyRightBean rightBean);
    }
    interface Presenter extends BaseConterct.basePresenter<View>{
        void getleft();
        void getright(String cid);
    }

}
