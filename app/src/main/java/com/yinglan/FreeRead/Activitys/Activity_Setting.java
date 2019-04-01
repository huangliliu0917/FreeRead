package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.BounceEnter.BounceTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.MaterialDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.MyActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Setting extends BaseActivity {

    @BindView(R.id.setting_titleBar)
    TitleBar settingTitleBar;
    @BindView(R.id.person_read_set)
    LinearLayout personReadSet;
    @BindView(R.id.person_MyBankCard)
    LinearLayout personMyBankCard;
    @BindView(R.id.setting_version)
    TextView settingVersion;
    @BindView(R.id.person_updateVersion)
    LinearLayout personUpdateVersion;
    @BindView(R.id.person_quitLogin)
    LinearLayout personQuitLogin;


    private MaterialDialog materialDialog;
    private NormalDialog normalDialog;
    private BaseAnimatorSet nBasIn,mBasOut;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        intent = new Intent();
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


        nBasIn = new BounceTopEnter();
        mBasOut = new SlideBottomExit();
    }

    @OnClick({R.id.person_read_set, R.id.person_MyBankCard, R.id.person_updateVersion, R.id.person_quitLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.person_read_set:
                intent.setClass(this,Activity_ReadSet.class);
                startActivity(intent);
                break;
            case R.id.person_MyBankCard:
                intent.setClass(this,Activity_Setting_MyBankCard.class);
                startActivity(intent);
                break;
            case R.id.person_updateVersion:

                materialDialog = new MaterialDialog(this);
                materialDialog.content("已是最新版本！")
                        .btnNum(1)
                        .btnText("确定")
                        .title("提示")
                        .show();
                materialDialog.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        materialDialog.dismiss();
                    }
                });

                break;
            case R.id.person_quitLogin:

                normalDialog = new NormalDialog(this);
                normalDialog.isTitleShow(false)//
                        .bgColor(Color.parseColor("#ffffff"))//
                        .cornerRadius(5)//
                        .content("是否确定退出程序?")//
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
                                MyApplication.editor.putBoolean("user_Logined",false);
                                MyApplication.editor.apply();
                                MyActivityManager.getAppManager().finishAllActivity();
                                normalDialog.dismiss();
                            }
                        });

                break;
        }
    }
}
