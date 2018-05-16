package com.example.zll.jingdongrxjava.ui.homepage;

import com.example.zll.jingdongrxjava.bean.HomePageBean;
import com.example.zll.jingdongrxjava.bean.MyClassLeft;
import com.example.zll.jingdongrxjava.ui.base.BaseConterct;

/**
 * Created by zll on 2018/5/10.
 */

public interface HomePageContract {
    interface View extends BaseConterct.baseview {
        void getHomeage(HomePageBean homePageBean);
        void getMyleft(MyClassLeft myClassLeft);

    }
    interface Presenter extends BaseConterct.basePresenter<View>{
      void gethome();
      void getleft();
    }
}
