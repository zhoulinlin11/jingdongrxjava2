package com.example.zll.jingdongrxjava.component;



import com.example.zll.jingdongrxjava.ListDetailsActivity;
import com.example.zll.jingdongrxjava.SousuoActivity;
import com.example.zll.jingdongrxjava.module.HttpModule;
import com.example.zll.jingdongrxjava.ui.homepage.HomePageFragment;
import com.example.zll.jingdongrxjava.ui.myclass.ClassFragment;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(HomePageFragment homePageFragment);

    void inject(ClassFragment classFragment);
    void inject(SousuoActivity sousuoActivity);
    void inject(ListDetailsActivity listDetailsActivity);
}
