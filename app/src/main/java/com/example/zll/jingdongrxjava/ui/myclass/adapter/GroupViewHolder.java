package com.example.zll.jingdongrxjava.ui.myclass.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zll.jingdongrxjava.R;


/**
 * Created by zll on 2018/5/4.
 */

public class GroupViewHolder  extends RecyclerView.ViewHolder {
    public TextView textView;
    public RecyclerView recyclerView;

    public GroupViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.item_title);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.item_list);
    }
}
