package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_UserAgreement extends BaseActivity {

    @BindView(R.id.userAgreement_titleBar)
    TitleBar userAgreementTitleBar;


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__user_agreement);
        ButterKnife.bind(this);
        intent = new Intent();
        initView();
    }


    @SuppressLint("ResourceAsColor")
    public void initView(){
        userAgreementTitleBar.setTitle("用户协议");
        userAgreementTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        userAgreementTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        userAgreementTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        userAgreementTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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

}
