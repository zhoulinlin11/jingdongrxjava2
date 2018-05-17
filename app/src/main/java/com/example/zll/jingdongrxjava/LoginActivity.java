package com.example.zll.jingdongrxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zll.jingdongrxjava.bean.LoginBean;
import com.example.zll.jingdongrxjava.component.DaggerHttpComponent;
import com.example.zll.jingdongrxjava.module.HttpModule;
import com.example.zll.jingdongrxjava.ui.base.BaseActivity;
import com.example.zll.jingdongrxjava.ui.login.LoginContract;
import com.example.zll.jingdongrxjava.ui.login.LoginPresenter;
import com.example.zll.jingdongrxjava.utils.SharedPreferencesUtils;

/**
 * Created by zll on 2018/5/17.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View, View.OnClickListener {

    /**
     * 请输入用户名或邮箱
     */
    private EditText mEtname;
    /**
     * 请输入密码
     */
    private EditText mEtpassword;
    /**
     * 登录
     */
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    @Override
    public int getcoutentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void Loginview(LoginBean loginBean) {
        Toast.makeText(LoginActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.getParam(LoginActivity.this,"uid",loginBean.getData().getUid()+"");
        SharedPreferencesUtils.getParam(LoginActivity.this,"name",loginBean.getData().getUsername()+"");
        SharedPreferencesUtils.getParam(LoginActivity.this,"iconUrl",loginBean.getData().getIcon()+"");
        SharedPreferencesUtils.getParam(LoginActivity.this,"token",loginBean.getData().getToken());
     LoginActivity.this.finish();
    }

    private void initView() {
        mEtname = (EditText) findViewById(R.id.etname);
        mEtpassword = (EditText) findViewById(R.id.etpassword);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                String mobile = mEtname.getText().toString();
                String password = mEtpassword.getText().toString();
                mPresenter.getLoginPresenter(mobile,password);
                break;
        }
    }
}
