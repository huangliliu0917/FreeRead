package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.yinglan.FreeRead.Constant.HttpConstant;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.CountDownTimerUtils;
import com.yinglan.FreeRead.Utils.StringUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__find_password);
        ButterKnife.bind(this);

        context = getApplicationContext();
        sharedPreferences = context.getSharedPreferences("UserData",Context.MODE_PRIVATE);
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

                String phoneNum = findPasswordPhoneNumber.getText().toString();

                if (StringUtils.isEmpty(phoneNum)){
                    Toast.makeText(context,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    if(!StringUtils.isMobile(phoneNum)){
                        Toast.makeText(context,"手机号错误",Toast.LENGTH_SHORT).show();
                    }else{
                        CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(context,btnFindPasswordGetSecurity, phoneNum, 60000, 1000); //倒计时1分钟
                        mCountDownTimerUtils.start();
                    }
                }

                break;
            case R.id.btn_findPassword_login:

                String phoneNum1 = findPasswordPhoneNumber.getText().toString();
                String checkNum = findPasswordCheckCode.getText().toString();
                String password = findPasswordChangePasword.getText().toString();

                if (StringUtils.isEmpty(phoneNum1) || StringUtils.isEmpty(checkNum) || StringUtils.isEmpty(password)){
                    Toast.makeText(context,"请填写用户信息",Toast.LENGTH_SHORT).show();
                }else{
                    //判断手机号
                    if(!StringUtils.isMobile(phoneNum1)){
                        Toast.makeText(context,"手机号错误",Toast.LENGTH_SHORT).show();
                    }else if(StringUtils.isSame(checkNum,sharedPreferences.getString("SMSCode",""))){
                        Toast.makeText(context,"验证码错误",Toast.LENGTH_SHORT).show();
                    }else if(updateLoginPassword(phoneNum1,checkNum,password)){
                        intent = new Intent(context,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
                break;
        }
    }


    /**
     * 忘记密码
     * @param phoneNum1
     * @param checkNum
     * @param password
     * @return
     */
    public boolean updateLoginPassword(String phoneNum1, String checkNum, String password){

        Map<String, String> params = new HashMap<String, String>();
        params.put("phoneNum1", phoneNum1);
        params.put("checkNum", checkNum);
        params.put("password", password);

        MyOkHttp.get().post(context, HttpConstant.forgetPassword, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {

            }
        });

        return true;
    }


}
