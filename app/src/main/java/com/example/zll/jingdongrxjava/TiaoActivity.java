package com.example.zll.jingdongrxjava;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zll on 2018/5/10.
 */

public class TiaoActivity extends AppCompatActivity {
    /**
     * 5s
     */
    private TextView mTextView;
    private Timego timego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_tiao);
        initView();
        timego = new Timego(5200,1000);
        timego.start();
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.text_view);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TiaoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private class Timego extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public Timego(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
          mTextView.setText(millisUntilFinished/1000+"s");
        }

        @Override
        public void onFinish() {
           timego.cancel();
            Intent intent=new Intent(TiaoActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
