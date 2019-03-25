package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.animation.BaseAnimatorSet;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.MaterialDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Setting extends AppCompatActivity {

    @BindView(R.id.setting_titleBar)
    TitleBar settingTitleBar;
    @BindView(R.id.person_read_set)
    LinearLayout personReadSet;
    @BindView(R.id.person_setBankCard)
    LinearLayout personSetBankCard;
    @BindView(R.id.setting_version)
    TextView settingVersion;
    @BindView(R.id.person_updateVersion)
    LinearLayout personUpdateVersion;
    @BindView(R.id.person_quitLogin)
    LinearLayout personQuitLogin;


    private MaterialDialog normalDialog;
    private BaseAnimatorSet nBasIn,mBasOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();

    }


    @SuppressLint("ResourceAsColor")
    public void initView(){
        settingTitleBar.setTitle("设置");
        settingTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        settingTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        settingTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        settingTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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

    @OnClick({R.id.person_read_set, R.id.person_setBankCard, R.id.person_updateVersion, R.id.person_quitLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.person_read_set:
                break;
            case R.id.person_setBankCard:
                break;
            case R.id.person_updateVersion:

                normalDialog = new MaterialDialog(this);
                normalDialog.content("已是最新版本！")
                        .btnNum(1)
                        .btnText("确定")
                        .title("提示")
                        .show();
                normalDialog.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        normalDialog.dismiss();
                    }
                });

                break;
            case R.id.person_quitLogin:
                break;
        }
    }
}
