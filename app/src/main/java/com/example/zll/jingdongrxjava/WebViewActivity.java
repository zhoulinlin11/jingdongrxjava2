package com.example.zll.jingdongrxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.zll.jingdongrxjava.R;

/**
 * Created by zll on 2018/5/15.
 */

public class WebViewActivity extends AppCompatActivity {
    private WebView mWv;
    private String detailUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent=getIntent();
        initView();
        //获取传过来的name
        detailUrl = intent.getStringExtra("detailUrl");
        mWv.loadUrl(detailUrl);
    }

    private void initView() {
        mWv = (WebView) findViewById(R.id.wv);
        WebSettings settings = mWv.getSettings();
        //支持js
        settings.setJavaScriptEnabled(true);
    }
}
