package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.Constant.HttpConnect;
import com.yinglan.FreeRead.Imp.MakeActivityDoSomething;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.CountDownTimerUtils;
import com.yinglan.FreeRead.Utils.MyActivityManager;
import com.yinglan.FreeRead.Utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册页面
 */
public class Activity_Register extends BaseActivity implements MakeActivityDoSomething {

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

        MyActivityManager.getAppManager().addActivity(this);

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

                String phoneNum = registerPhoneNumber.getText().toString();

                if (StringUtils.isEmpty(phoneNum)){
                    Toast.makeText(context,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    if(!StringUtils.isMobile(phoneNum)){
                        Toast.makeText(context,"手机号错误",Toast.LENGTH_SHORT).show();
                    }else{
                        CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(context,btnGetSecurity, phoneNum, 60000, 1000); //倒计时1分钟
                        mCountDownTimerUtils.start();
                    }
                }

                break;
            case R.id.btn_register:
                String eMail = registerEmail.getText().toString();
                String password = registerPassword.getText().toString();
                String checkPassword = registerCheckPassword.getText().toString();
                String phoneNum1 = registerPhoneNumber.getText().toString();
                String checkNum = registerCheckCode.getText().toString();


                if (StringUtils.isEmpty(eMail) || StringUtils.isEmpty(password) ||
                        StringUtils.isEmpty(checkPassword) || StringUtils.isEmpty(phoneNum1) ||
                        StringUtils.isEmpty(checkNum)){
                    Toast.makeText(context,"请填写用户信息",Toast.LENGTH_SHORT).show();
                } else if(!StringUtils.isEmail(eMail)){
                    Toast.makeText(context,"用户邮箱错误",Toast.LENGTH_SHORT).show();
                } else if(!StringUtils.isSame(password,checkPassword)){
                    Toast.makeText(context,"输入的密码不同",Toast.LENGTH_SHORT).show();
                } else if(password.length() < 6 || checkPassword.length() < 6){
                    Toast.makeText(context,"密码长度不能小于六位",Toast.LENGTH_SHORT).show();
                }else{
                    //判断手机号
                    if(!StringUtils.isMobile(phoneNum1)){
                        Toast.makeText(context,"手机号错误",Toast.LENGTH_SHORT).show();
                    }else{

                        Map<String, String> registerData = new HashMap<String, String>();
                        registerData.put("Email", eMail);
                        registerData.put("Password", password);
                        registerData.put("PhoneNumber", phoneNum1);

                        HttpConnect.register(context,registerData,this);
                    }
                }
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

    /**
    * 回调，销毁当前页面
    */
    @Override
    public void doFinish() {
        finish();
    }
}
