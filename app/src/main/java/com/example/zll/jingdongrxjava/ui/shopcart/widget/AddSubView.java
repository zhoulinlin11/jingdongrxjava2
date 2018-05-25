package com.example.zll.jingdongrxjava.ui.shopcart.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zll.jingdongrxjava.R;


public class AddSubView extends LinearLayout {

    private TextView sub;
    private TextView num;
    private TextView add;

    public AddSubView(Context context) {
        this(context, null);
    }

    public AddSubView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.add_sub_view, this);
        sub = findViewById(R.id.child_text_jian);
        num = findViewById(R.id.child_text_num);
        add = findViewById(R.id.child_text_add);
    }

    /**
     * 设置数量
     * @param str
     */
    public void setNum(String str) {
        num.setText(str);
    }

    /**
     * 获取数量
     *
     * @return
     */
    public String getNum() {
        return num.getText().toString();
    }

    /**
     * 给加号设置点击事件
     *
     * @param onclickListener
     */
    public void setAddOnclickListener(OnClickListener onclickListener) {
        add.setOnClickListener(onclickListener);
    }

    /**
     * 给减号设置点击事件
     *
     * @param onclickListener
     */
    public void setSubOnclickListener(OnClickListener onclickListener) {
        sub.setOnClickListener(onclickListener);
    }
}
