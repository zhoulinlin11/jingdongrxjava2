package com.example.zll.jingdongrxjava.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zll on 2018/4/19.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list=new ArrayList<>();

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }



    @Override
    public Fragment getItem(int position) {
        return list.get(position) ;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
