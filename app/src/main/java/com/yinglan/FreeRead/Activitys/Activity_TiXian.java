package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_TiXian extends AppCompatActivity {

    @BindView(R.id.TiXian_titleBar)
    TitleBar TiXianTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ti_xian);
        ButterKnife.bind(this);
        initView();
    }

    public void initView(){
        TiXianTitleBar.setTitle("提现");
        TiXianTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        TiXianTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        TiXianTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        TiXianTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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
