package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_getSecurity, R.id.btn_register, R.id.btn_register_useAccount, R.id.register_Agreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_getSecurity:
                break;
            case R.id.btn_register:
                break;
            case R.id.btn_register_useAccount:
                break;
            case R.id.register_Agreement:
                break;
        }
    }
}
