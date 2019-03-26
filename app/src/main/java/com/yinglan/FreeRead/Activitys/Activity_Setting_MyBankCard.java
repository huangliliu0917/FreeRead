package com.yinglan.FreeRead.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Setting_MyBankCard extends AppCompatActivity {

    @BindView(R.id.setting_myBankCard_titleBar)
    TitleBar settingMyBankCardTitleBar;
    @BindView(R.id.setting_myBankCard_cardInfo)
    RecyclerView settingMyBankCardCardInfo;
    @BindView(R.id.setting_myBankCard_toubao)
    LinearLayout settingMyBankCardToubao;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__setting__my_bank_card);
        ButterKnife.bind(this);
        intent = new Intent();
        initView();
    }

    public void initView(){
        settingMyBankCardTitleBar.setTitle("我的银行卡");
        settingMyBankCardTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        settingMyBankCardTitleBar.setRightIcon(this.getResources().getDrawable(R.drawable.ic_add_black_24dp));
        settingMyBankCardTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        settingMyBankCardTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        settingMyBankCardTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                intent.setClass(getApplicationContext(),Activity_Setting_BindBankCard.class);
                startActivity(intent);
            }
        });
    }


    @OnClick(R.id.setting_myBankCard_toubao)
    public void onViewClicked() {
        Toast.makeText(this,"点击投保",Toast.LENGTH_SHORT).show();
    }
}
