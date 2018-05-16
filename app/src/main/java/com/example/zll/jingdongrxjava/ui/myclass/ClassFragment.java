package com.example.zll.jingdongrxjava.ui.myclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zll.jingdongrxjava.MainActivity;
import com.example.zll.jingdongrxjava.R;
import com.example.zll.jingdongrxjava.bean.MyClassLeft;
import com.example.zll.jingdongrxjava.bean.MyRightBean;
import com.example.zll.jingdongrxjava.component.DaggerHttpComponent;
import com.example.zll.jingdongrxjava.module.HttpModule;
import com.example.zll.jingdongrxjava.ui.base.BaseFragment;
import com.example.zll.jingdongrxjava.ui.myclass.adapter.GroupAdapter;
import com.example.zll.jingdongrxjava.ui.myclass.adapter.LeftAdapter;
import com.example.zll.jingdongrxjava.ui.myclass.adapter.OnItemClickListner;

import java.util.List;

/**
 * Created by zll on 2018/5/10.
 */

public class ClassFragment extends BaseFragment<MyRightPresenter> implements ClassCrenct.View {
    private RecyclerView leftList,rightList;
    private LeftAdapter adapter;
    private GroupAdapter groupAdapter;

    @Override
    public int getcoutentLayout() {
        return R.layout.myclass;
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
        leftList = (RecyclerView) view.findViewById(R.id.left_list);
        rightList = (RecyclerView)view. findViewById(R.id.right_list);
        leftList.setLayoutManager(new LinearLayoutManager(getContext()));
        rightList.setLayoutManager(new LinearLayoutManager(getContext()));
        groupAdapter = new GroupAdapter(getContext());
        rightList.setAdapter(groupAdapter);
        mPresenter.getleft();

    }

    @Override
    public void getMyleft(MyClassLeft myClassLeft) {
        List<MyClassLeft.DataBean> data = myClassLeft.getData();
        adapter = new LeftAdapter(getContext(),data);
        leftList.setAdapter(adapter);
        int cid = myClassLeft.getData().get(0).getCid();
        mPresenter.getright(cid+"");
        adapter.setClick(new OnItemClickListner() {
            @Override
            public void onItemClick(View view, int cid) {
                mPresenter.getright(cid+"");
            }
        });



    }

    @Override
    public void getMyRight(MyRightBean rightBean) {
       List<MyRightBean.DataBean> data = rightBean.getData();
      groupAdapter.updateData(data);
        //rightBean.getMsg();

    }



}
