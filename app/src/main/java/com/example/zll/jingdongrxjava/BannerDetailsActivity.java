package com.example.zll.jingdongrxjava;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zll.jingdongrxjava.bean.ProductsBean;
import com.example.zll.jingdongrxjava.ui.Xiangqing.MyAdapter1;
import com.example.zll.jingdongrxjava.widght.HackyViewPager;


import java.util.Arrays;
import java.util.List;

public class BannerDetailsActivity extends AppCompatActivity {

    private HackyViewPager mHvp;
    private TextView mTv;
    private ProductsBean.DataBean bean;
    private List<String> list;
    private int position;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_details);
        //获取JavaBean
        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);
        bean = (ProductsBean.DataBean) intent.getSerializableExtra("bean");
        String images = bean.getImages();
        String[] split = images.split("\\|");
        list = Arrays.asList(split);
        count = list.size();
        initView();

    }

    private void initView() {
     mHvp = (HackyViewPager) findViewById(R.id.hvp);
        mTv = (TextView) findViewById(R.id.tv);
        MyAdapter1 myAdapter = new MyAdapter1(this, list);
        mHvp.setAdapter(myAdapter);

        mHvp.setCurrentItem(position);

        mTv.setText((position + 1) + "/" + count);

        mHvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int p) {
                BannerDetailsActivity.this.position = p;
                mTv.setText((position + 1) + "/" + count);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
