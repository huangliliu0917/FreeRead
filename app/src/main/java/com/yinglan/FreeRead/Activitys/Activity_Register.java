package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册页面
 */
public class Activity_Register extends AppCompatActivity {

    @BindView(R.id.register_email)
    EditText registerEmail;
    @BindView(R.id.register_password)
    EditText registerPassword;
    @BindView(R.id.register_check_password)
    EditText registerCheckPassword;
    @BindView(R.id.register_phoneNumber)
    EditText registerPhoneNumber;
    @BindView(R.id.register_checkCode)
    EditText registerCheckCode;
    @BindView(R.id.btn_getSecurity)
    TextView btnGetSecurity;
    @BindView(R.id.btn_register)
    TextView btnRegister;
    @BindView(R.id.btn_register_useAccount)
    TextView btnRegisterUseAccount;
    @BindView(R.id.register_Agreement)
    TextView registerAgreement;
    @BindView(R.id.register_titleBar)
    TitleBar registerTitleBar;


    private Context context;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register);
        ButterKnife.bind(this);
        context = getApplicationContext();
        initView();
    }


    @SuppressLint("ResourceAsColor")
    public void initView() {
        registerTitleBar.setTitle("注册");
        registerTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        registerTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        registerTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        registerTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
    }



    @OnClick({R.id.btn_getSecurity, R.id.btn_register, R.id.btn_register_useAccount, R.id.register_Agreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_getSecurity:
                break;
            case R.id.btn_register:
                break;
            case R.id.btn_register_useAccount:
                intent = new Intent(context, Activity_Login.class);
                startActivity(intent);
                break;
            case R.id.register_Agreement:
                intent = new Intent(context, Activity_UserAgreement.class);
                startActivity(intent);
                break;
        }
    }
}
