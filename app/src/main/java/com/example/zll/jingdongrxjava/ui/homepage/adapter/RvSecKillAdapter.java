package com.example.zll.jingdongrxjava.ui.homepage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.zll.jingdongrxjava.R;
import com.example.zll.jingdongrxjava.bean.HomePageBean;
import com.example.zll.jingdongrxjava.ibase.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RvSecKillAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HomePageBean.MiaoshaBean.ListBeanX> list;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public RvSecKillAdapter(Context context, List<HomePageBean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_miaosao_iteam, parent, false);
        SecKillViewHolder secKillViewHolder = new SecKillViewHolder(view);
        return secKillViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        SecKillViewHolder secKillViewHolder = (SecKillViewHolder) holder;
        HomePageBean.MiaoshaBean.ListBeanX listBeanX = list.get(position);
        String url = listBeanX.getImages().split("\\|")[0];
        secKillViewHolder.iv.setImageURI(url);
        secKillViewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SecKillViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView iv;

        public SecKillViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
