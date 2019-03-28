package com.yinglan.FreeRead.Fragments;

import android.content.Context;
import android.content.Intent;
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

import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.BounceEnter.BounceTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;
import com.yinglan.FreeRead.Activitys.Activity_FindPassword;
import com.yinglan.FreeRead.Activitys.Activity_Register;
import com.yinglan.FreeRead.Activitys.Activity_UserAgreement;
import com.yinglan.FreeRead.Activitys.MainActivity;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Frank on 2019/3/28
 * Introduce : ${Text}
 */
public class Fragment_Login_UsePassword extends Fragment {


    @BindView(R.id.login_usepassword_phoneNumber)
    EditText loginUsepasswordPhoneNumber;
    @BindView(R.id.login_usepassword_getCheckNum)
    EditText loginUsepasswordGetCheckNum;
    @BindView(R.id.select_login_usepassword_ZiDong)
    CheckBox selectLoginUsepasswordZiDong;
    @BindView(R.id.btn_login_usepassword_forgetPassword)
    TextView btnLoginUsepasswordForgetPassword;
    @BindView(R.id.btn_login_usepassword)
    TextView btnLoginUsepassword;
    @BindView(R.id.btn_login_usepassword_fromWeChat)
    ImageView btnLoginUsepasswordFromWeChat;
    @BindView(R.id.btn_login_usepassword_fromQQ)
    ImageView btnLoginUsepasswordFromQQ;
    @BindView(R.id.btn_login_usepassword_register)
    TextView btnLoginUsepasswordRegister;
    @BindView(R.id.btn_login_usepassword_userAgreement)
    TextView btnLoginUsepasswordUserAgreement;
    Unbinder unbinder;
    private View view;
    private Context context;
    private Intent intent;
    private NormalDialog normalDialog;
    private BaseAnimatorSet nBasIn,mBasOut;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login_usepassword, null);
        unbinder = ButterKnife.bind(this, view);

        context = getContext();
        nBasIn = new BounceTopEnter();
        mBasOut = new SlideBottomExit();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_login_usepassword_forgetPassword, R.id.btn_login_usepassword, R.id.btn_login_usepassword_fromWeChat,
            R.id.btn_login_usepassword_fromQQ, R.id.btn_login_usepassword_register, R.id.btn_login_usepassword_userAgreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login_usepassword_forgetPassword:
                intent = new Intent(context,Activity_FindPassword.class);
                startActivity(intent);
                break;
            case R.id.btn_login_usepassword:
                intent = new Intent(context,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login_usepassword_fromWeChat:
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
                                normalDialog.dismiss();
                            }
                        });

                break;
            case R.id.btn_login_usepassword_fromQQ:

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
            case R.id.btn_login_usepassword_register:
                intent = new Intent(context,Activity_Register.class);
                startActivity(intent);
                break;
            case R.id.btn_login_usepassword_userAgreement:
                intent = new Intent(context,Activity_UserAgreement.class);
                startActivity(intent);
                break;
        }
    }
}
