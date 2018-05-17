package com.example.zll.jingdongrxjava;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.zll.jingdongrxjava.adapter.MyFragmentAdapter;
import com.example.zll.jingdongrxjava.ui.myclass.ClassFragment;
import com.example.zll.jingdongrxjava.fragment.FindFragment;
import com.example.zll.jingdongrxjava.ui.homepage.HomePageFragment;
import com.example.zll.jingdongrxjava.fragment.MyFragment;
import com.example.zll.jingdongrxjava.ui.shopcart.ShopCarFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private ViewPager flcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_main);
        //找到控件
        rg = findViewById(R.id.rg);
        flcontent = findViewById(R.id.flcontent);


        List<Fragment> list=new ArrayList<>();
        list.add(new HomePageFragment());
        list.add(new ClassFragment());
        list.add(new FindFragment());
        list.add(new ShopCarFragment());
        list.add(new MyFragment());
        flcontent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rg.check(R.id.rbhome);
                        break;
                    case 1:
                        rg.check(R.id.rbmyclass);
                        break;
                    case 2:
                        rg.check(R.id.rbfind);
                        break;
                    case 3:
                        rg.check(R.id.rbshopcar);
                        break;
                    case 4:
                        rg.check(R.id.rbmy);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),list);
        flcontent.setAdapter(adapter);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbhome:
                        flcontent.setCurrentItem(0);
                        break;
                    case R.id.rbmyclass:
                        flcontent.setCurrentItem(1);
                        break;
                    case R.id.rbfind:
                        flcontent.setCurrentItem(2);
                        break;
                    case R.id.rbshopcar:
                        flcontent.setCurrentItem(3);
                        break;
                    case R.id.rbmy:
                        flcontent.setCurrentItem(4);
                        break;
                }
            }
        });

    }
}
