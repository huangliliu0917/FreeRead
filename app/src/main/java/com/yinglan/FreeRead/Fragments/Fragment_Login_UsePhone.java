package com.yinglan.FreeRead.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.BounceEnter.BounceTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.yinglan.FreeRead.Activitys.Activity_FindPassword;
import com.yinglan.FreeRead.Activitys.Activity_Register;
import com.yinglan.FreeRead.Activitys.Activity_UserAgreement;
import com.yinglan.FreeRead.Activitys.MainActivity;
import com.yinglan.FreeRead.Constant.HttpConstant;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.CountDownTimerUtils;
import com.yinglan.FreeRead.Utils.StringUtils;
import com.yinglan.FreeRead.wxapi.WXUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Frank on 2019/3/28
 * Introduce : ${Text}
 */
public class Fragment_Login_UsePhone extends Fragment {


    @BindView(R.id.login_usephone_phoneNumber)
    EditText loginUsephonePhoneNumber;
    @BindView(R.id.login_usephone_getCheckNum)
    EditText loginUsephoneGetCheckNum;
    @BindView(R.id.login_usephone_btnGetCheckNum)
    TextView loginUsephoneBtnGetCheckNum;
    @BindView(R.id.select_login_usephone_ZiDong)
    CheckBox selectLoginUsephoneZiDong;
    @BindView(R.id.btn_login_usephone_forgetPassword)
    TextView btnLoginUsephoneForgetPassword;
    @BindView(R.id.btn_login_usephone)
    TextView btnLoginUsephone;
    @BindView(R.id.btn_login_usephone_fromWeChat)
    ImageView btnLoginUsephoneFromWeChat;
    @BindView(R.id.btn_login_usephone_fromQQ)
    ImageView btnLoginUsephoneFromQQ;
    @BindView(R.id.btn_login_usephone_register)
    TextView btnLoginUsephoneRegister;
    @BindView(R.id.btn_login_usephone_userAgreement)
    TextView btnLoginUsephoneUserAgreement;
    Unbinder unbinder;
    private View view;
    private Context context;
    private Intent intent;

    private NormalDialog normalDialog;
    private BaseAnimatorSet nBasIn,mBasOut;
    private SharedPreferences sharedPreferences;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login_usephone, null);

        unbinder = ButterKnife.bind(this, view);

        context = getContext();
        sharedPreferences = context.getSharedPreferences("UserData",Context.MODE_PRIVATE);
        nBasIn = new BounceTopEnter();
        mBasOut = new SlideBottomExit();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.login_usephone_btnGetCheckNum, R.id.btn_login_usephone_forgetPassword, R.id.btn_login_usephone,
            R.id.btn_login_usephone_fromWeChat, R.id.btn_login_usephone_fromQQ, R.id.btn_login_usephone_register,
            R.id.btn_login_usephone_userAgreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_usephone_btnGetCheckNum:
                String phoneNum = loginUsephonePhoneNumber.getText().toString();

                if (StringUtils.isEmpty(phoneNum)){
                    Toast.makeText(context,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    if(!StringUtils.isMobile(phoneNum)){
                        Toast.makeText(context,"手机号错误",Toast.LENGTH_SHORT).show();
                    }else{
                        CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(context,loginUsephoneBtnGetCheckNum, phoneNum, 60000, 1000); //倒计时1分钟
                        mCountDownTimerUtils.start();
                    }
                }

                break;
            case R.id.btn_login_usephone_forgetPassword:
                intent = new Intent(context,Activity_FindPassword.class);
                startActivity(intent);
                break;
            case R.id.btn_login_usephone:

                String phoneNum1 = loginUsephonePhoneNumber.getText().toString();
                String checkNum = loginUsephoneGetCheckNum.getText().toString();

                if (StringUtils.isEmpty(phoneNum1) || StringUtils.isEmpty(checkNum)){
                    Toast.makeText(context,"请填写用户信息",Toast.LENGTH_SHORT).show();
                }else{
                    //判断手机号
                    if(!StringUtils.isMobile(phoneNum1)){
                        Toast.makeText(context,"手机号错误",Toast.LENGTH_SHORT).show();
                    }else if(StringUtils.isSame(checkNum,sharedPreferences.getString("SMSCode",""))){
                        Toast.makeText(context,"验证码错误",Toast.LENGTH_SHORT).show();
                    }else if(loginWithPhoneNum(phoneNum1,checkNum)){
                            intent = new Intent(context,MainActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                    }
                }

                break;
            case R.id.btn_login_usephone_fromWeChat:

                normalDialog = new NormalDialog(getContext());
                normalDialog.isTitleShow(false)//
                        .bgColor(Color.parseColor("#ffffff"))//
                        .cornerRadius(5)//
                        .content("自动阅读想要打开微信")//
                        .contentGravity(Gravity.CENTER)//
                        .contentTextColor(Color.parseColor("#454545"))//
                        .dividerColor(Color.parseColor("#222222"))//
                        .btnTextSize(15.5f, 15.5f)//
                        .btnTextColor(Color.parseColor("#3b9cf2"), Color.parseColor("#3b9cf2"))//
                        .widthScale(0.85f)//
                        .showAnim(nBasIn)//
                        .dismissAnim(mBasOut)//
                        .show();

                normalDialog.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                normalDialog.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                WXUtils.wxLogin(context);
                            }
                        });

                break;
            case R.id.btn_login_usephone_fromQQ:

                normalDialog = new NormalDialog(getContext());
                normalDialog.isTitleShow(false)//
                        .bgColor(Color.parseColor("#ffffff"))//
                        .cornerRadius(5)//
                        .content("自动阅读想要打开QQ")//
                        .contentGravity(Gravity.CENTER)//
                        .contentTextColor(Color.parseColor("#454545"))//
                        .dividerColor(Color.parseColor("#222222"))//
                        .btnTextSize(15.5f, 15.5f)//
                        .btnTextColor(Color.parseColor("#3b9cf2"), Color.parseColor("#3b9cf2"))//
                        .widthScale(0.85f)//
                        .showAnim(nBasIn)//
                        .dismissAnim(mBasOut)//
                        .show();

                normalDialog.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                normalDialog.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                normalDialog.dismiss();
                            }
                        });

                break;
            case R.id.btn_login_usephone_register:
                intent = new Intent(context,Activity_Register.class);
                startActivity(intent);
                break;
            case R.id.btn_login_usephone_userAgreement:
                intent = new Intent(context,Activity_UserAgreement.class);
                startActivity(intent);
                break;
        }
    }


    /**
     * @param phoneNum 手机号
     * @param checkNum 验证码
     * @return
     */
    public boolean loginWithPhoneNum(String phoneNum, String checkNum){
        Map<String, String> params = new HashMap<String, String>();
        params.put("phoneNum", phoneNum);
        params.put("checkNum", checkNum);

        MyOkHttp.get().post(context, HttpConstant.login_with_phoneNum, params, new JsonResponseHandler() {
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
