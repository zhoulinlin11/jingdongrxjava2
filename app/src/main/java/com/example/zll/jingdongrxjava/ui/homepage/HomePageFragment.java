package com.example.zll.jingdongrxjava.ui.homepage;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.zll.jingdongrxjava.R;
import com.example.zll.jingdongrxjava.WebViewActivity;
import com.example.zll.jingdongrxjava.bean.HomePageBean;
import com.example.zll.jingdongrxjava.bean.MyClassLeft;
import com.example.zll.jingdongrxjava.component.DaggerHttpComponent;
import com.example.zll.jingdongrxjava.ibase.OnItemClickListener;
import com.example.zll.jingdongrxjava.module.HttpModule;
import com.example.zll.jingdongrxjava.ui.base.BaseFragment;
import com.example.zll.jingdongrxjava.ui.homepage.adapter.RvClassAdapter;
import com.example.zll.jingdongrxjava.ui.homepage.adapter.RvRecommendAdapter;
import com.example.zll.jingdongrxjava.ui.homepage.adapter.RvSecKillAdapter;
import com.example.zll.jingdongrxjava.utils.GlideImageLoader;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zll on 2018/5/10.
 */

public class HomePageFragment extends BaseFragment<HomePresenter> implements HomePageContract.View {

    private Banner banner;
    private RecyclerView rvClass;
    private MarqueeView marqueeView;
    private RecyclerView rvSecKill;
    private RecyclerView rvRecommend;
    @Override
    public int getcoutentLayout() {
        return R.layout.shouye;
    }

    @Override
    public void inject() {
      DaggerHttpComponent.builder()
              .httpModule(new HttpModule())
              .build()
              .inject(this);
    }

    @Override
    public void initView(View view) {
        marqueeView = view.findViewById(R.id.marqueeView);
        List<String> info = new ArrayList<>();
        info.add("1. 大家好，我是孙福生。");
        info.add("2. 欢迎大家关注我哦！");
        info.add("3. GitHub帐号：sfsheng0322");
        info.add("4. 新浪微博：孙福生微博");
        info.add("5. 个人博客：sunfusheng.com");
        info.add("6. 微信公众号：孙福生");
        marqueeView.startWithList(info);

        banner = (Banner) view.findViewById(R.id.banner);
        rvClass = view.findViewById(R.id.rvfenlei);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        rvClass.setLayoutManager(gridLayoutManager);

        rvSecKill = view.findViewById(R.id.rvmiaosha);
        //设置布局管理器
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        rvSecKill.setLayoutManager(gridLayoutManager1);

        //设置布局管理器
        rvRecommend = view.findViewById(R.id.rvtuijian);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        rvRecommend.setLayoutManager(gridLayoutManager2);

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //请求数据
        initData();
    }
    private void initData() {
        mPresenter.gethome();
        mPresenter.getleft();
    }
    @Override
    public void getHomeage(final HomePageBean homePageBean) {
        final List<HomePageBean.DataBean> data = homePageBean.getData();
        List<String> images = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            images.add(data.get(i).getIcon());
        }
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
         banner.setOnBannerListener(new OnBannerListener() {
             @Override
             public void OnBannerClick(int position) {
                 String detailUrl=data.get(position).getUrl();
                 if (!TextUtils.isEmpty(detailUrl)){
                     Intent intent=new Intent(getActivity(),WebViewActivity.class);
                     intent.putExtra("detailUrl",detailUrl);
                     startActivity(intent);
                 }
             }
         });

        RvSecKillAdapter rvSecKillAdapter = new RvSecKillAdapter(getActivity(), homePageBean.getMiaosha().getList());
        rvSecKill.setAdapter(rvSecKillAdapter);
        rvSecKillAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String detailUrl=homePageBean.getMiaosha().getList().get(position).getDetailUrl();
                if (!TextUtils.isEmpty(detailUrl)){
                    Intent intent=new Intent(getContext(),WebViewActivity.class);
                    intent.putExtra("detailUrl",detailUrl);
                    startActivity(intent);
                }
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });


        RvRecommendAdapter rvRecommendAdapter = new RvRecommendAdapter(getActivity(), homePageBean.getTuijian().getList());
        rvRecommend.setAdapter(rvRecommendAdapter);
        rvRecommendAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String detailUrl=homePageBean.getTuijian().getList().get(position).getDetailUrl();
                if (!TextUtils.isEmpty(detailUrl)){
                    Intent intent=new Intent(getContext(),WebViewActivity.class);
                    intent.putExtra("detailUrl",detailUrl);
                    startActivity(intent);
                }
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void getMyleft(MyClassLeft myClassLeft) {
        final List<MyClassLeft.DataBean> data = myClassLeft.getData();
        RvClassAdapter adapter = new RvClassAdapter(getActivity(), data);
        rvClass.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(),data.get(position).getName(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });

    }
}
