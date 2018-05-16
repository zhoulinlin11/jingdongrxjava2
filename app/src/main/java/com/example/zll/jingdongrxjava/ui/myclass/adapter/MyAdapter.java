package com.example.zll.jingdongrxjava.ui.myclass.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zll.jingdongrxjava.R;
import com.example.zll.jingdongrxjava.bean.MyRightBean;
import com.example.zll.jingdongrxjava.ibase.OnItemClickListener;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zll on 2018/5/4.
 */

public class MyAdapter extends RecyclerView.Adapter<TextViewHolder> {
    private List<MyRightBean.DataBean.ListBean> list=new ArrayList<>();
    private Context context;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(Context context) {
        this.context = context;
    }
    public void addData(List<MyRightBean.DataBean.ListBean> data){
        this.list.addAll(data);
        notifyDataSetChanged();
    }
    public void setOnIteamClienListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getName());
        String icon = list.get(position).getIcon();
        holder.img.setImageURI(icon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
