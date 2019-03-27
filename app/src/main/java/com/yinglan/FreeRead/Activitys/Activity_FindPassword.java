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

public class Activity_FindPassword extends AppCompatActivity {

    @BindView(R.id.findPassword_titleBar)
    TitleBar findPasswordTitleBar;
    @BindView(R.id.findPassword_phoneNumber)
    EditText findPasswordPhoneNumber;
    @BindView(R.id.findPassword_checkCode)
    EditText findPasswordCheckCode;
    @BindView(R.id.btn_findPassword_getSecurity)
    TextView btnFindPasswordGetSecurity;
    @BindView(R.id.findPassword_changePasword)
    EditText findPasswordChangePasword;
    @BindView(R.id.btn_findPassword_login)
    TextView btnFindPasswordLogin;


    private Context context;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__find_password);
        ButterKnife.bind(this);

        context = getApplicationContext();
        initView();

    }


    @SuppressLint("ResourceAsColor")
    public void initView() {
        findPasswordTitleBar.setTitle("找回密码");
        findPasswordTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        findPasswordTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        findPasswordTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        findPasswordTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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


    @OnClick({R.id.btn_findPassword_getSecurity, R.id.btn_findPassword_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_findPassword_getSecurity:
                break;
            case R.id.btn_findPassword_login:
                break;
        }
    }
}
