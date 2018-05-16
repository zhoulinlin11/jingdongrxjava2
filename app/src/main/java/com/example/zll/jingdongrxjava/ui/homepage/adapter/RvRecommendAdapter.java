package com.example.zll.jingdongrxjava.ui.homepage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zll.jingdongrxjava.R;
import com.example.zll.jingdongrxjava.bean.HomePageBean;
import com.example.zll.jingdongrxjava.ibase.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RvRecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HomePageBean.TuijianBean.ListBean> list;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public RvRecommendAdapter(Context context, List<HomePageBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_iteam, parent, false);
        RecommendViewHolder recommendViewHolder = new RecommendViewHolder(view);
        return recommendViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
        HomePageBean.TuijianBean.ListBean listBean = list.get(position);
        String images = listBean.getImages();
        String[] split = images.split("\\|");
        String url = split.length == 0 ? images : split[0];
        recommendViewHolder.iv.setImageURI(url);
        recommendViewHolder.tv.setText(listBean.getTitle());
        recommendViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tv;
        private final LinearLayout ll;
        public RecommendViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
