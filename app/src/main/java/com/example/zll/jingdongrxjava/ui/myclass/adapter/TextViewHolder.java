package com.example.zll.jingdongrxjava.ui.myclass.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zll.jingdongrxjava.R;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by zll on 2018/5/4.
 */

public class TextViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public SimpleDraweeView img;

    public TextViewHolder(View itemView){
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.mytitle);
        img=(SimpleDraweeView) itemView.findViewById(R.id.myimg);
    }
}
