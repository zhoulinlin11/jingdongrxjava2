package com.example.zll.jingdongrxjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zll.jingdongrxjava.bean.ProductsBean;
import com.example.zll.jingdongrxjava.component.DaggerHttpComponent;
import com.example.zll.jingdongrxjava.module.HttpModule;
import com.example.zll.jingdongrxjava.ui.Xiangqing.XiangCrentent;
import com.example.zll.jingdongrxjava.ui.Xiangqing.XiangqingPresenter;
import com.example.zll.jingdongrxjava.ui.base.BaseActivity;
import com.example.zll.jingdongrxjava.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.io.Serializable;
import java.util.Arrays;

import javax.inject.Inject;


public class ListDetailsActivity extends BaseActivity<XiangqingPresenter> implements XiangCrentent.View, View.OnClickListener {

    private ProductsBean.DataBean bean;
    private ImageView ivShare;
    private Banner banner;
    private TextView tvTitle;
    private TextView tvPrice;
    private TextView tvVipPrice;
    /**
     * 购物车
     */
    private TextView tvShopCard;
    /**
     * 加入购物车
     */
    private TextView tvAddCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);
        initView();
        Intent intent=getIntent();
        bean = (ProductsBean.DataBean) intent.getSerializableExtra("bean");
        setData();
    }

    private void setData() {
        if (bean==null){
            return;
        }
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        String[] imgs = bean.getImages().split("\\|");
        //设置图片结合
        banner.setImages(Arrays.asList(imgs));
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        tvTitle.setText(bean.getTitle());
        //给原价加横线
        SpannableString spannableString = new SpannableString("原价" + bean.getSalenum());
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
       spannableString.setSpan(strikethroughSpan,0,spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
       tvPrice.setText(spannableString);
       banner.setOnBannerListener(new OnBannerListener() {
           @Override
           public void OnBannerClick(int position) {
                Intent intent=new Intent(ListDetailsActivity.this,BannerDetailsActivity.class);
                intent.putExtra("bean",bean);
                intent.putExtra("position",position);
                startActivity(intent);
           }
       });
       tvVipPrice.setText("现价:"+bean.getPrice());
    }

    @Override
    public int getcoutentLayout() {
        return R.layout.activity_list_details;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }


    @Override
    public void getxiangmu(String str) {
        Toast.makeText(ListDetailsActivity.this,str,Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        ivShare = (ImageView) findViewById(R.id.ivShare);
        banner = (Banner) findViewById(R.id.banner);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvVipPrice = (TextView) findViewById(R.id.tvVipPrice);
        tvShopCard = (TextView) findViewById(R.id.tvShopCard);
        tvAddCard = (TextView) findViewById(R.id.tvAddCard);
        ivShare.setOnClickListener(this);
        tvVipPrice.setOnClickListener(this);
        tvAddCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.tvAddCard:
              break;
          case R.id.tvShopCard:
              break;
      }
    }
}
