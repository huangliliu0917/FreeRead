package com.yinglan.FreeRead.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login_usephone, null);

        unbinder = ButterKnife.bind(this, view);

        context = getContext();

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
                if (loginUsephonePhoneNumber.getText().length() == 0){
                    Toast.makeText(context,"请输入手机号",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"验证码已发送，请注意查收",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_login_usephone_forgetPassword:
                intent = new Intent(context,Activity_FindPassword.class);
                startActivity(intent);
                break;
            case R.id.btn_login_usephone:
                intent = new Intent(context,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login_usephone_fromWeChat:
                break;
            case R.id.btn_login_usephone_fromQQ:
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

}
