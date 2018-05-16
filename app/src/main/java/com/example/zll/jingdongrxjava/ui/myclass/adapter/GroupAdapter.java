package com.example.zll.jingdongrxjava.ui.myclass.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zll.jingdongrxjava.R;
import com.example.zll.jingdongrxjava.SousuoActivity;
import com.example.zll.jingdongrxjava.WebViewActivity;
import com.example.zll.jingdongrxjava.bean.MyRightBean;
import com.example.zll.jingdongrxjava.ibase.OnItemClickListener;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zll on 2018/5/4.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupViewHolder> {
    private List<MyRightBean.DataBean> list=new ArrayList<>();
    private Context context;


    public GroupAdapter(Context context ) {
        this.context = context;
    }
    //刷新数据
    public void updateData(List<MyRightBean.DataBean> data){
        this.list.clear();
        this.list.addAll(data);
        notifyDataSetChanged();
    }
    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_item, parent,false);

        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getName());
        holder.recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        MyAdapter adapter = new MyAdapter(context);
        //为图一嵌套的recyclerview设置适配器
        holder.recyclerView.setAdapter(adapter);
        adapter.addData(list.get(position).getList());
        adapter.setOnIteamClienListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(context, SousuoActivity.class);
                intent.putExtra("pscid",list.get(position).getList().get(position).getPscid());
                context.startActivity(intent);

            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

}
