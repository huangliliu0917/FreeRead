package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_AboutUs extends AppCompatActivity {

    @BindView(R.id.aboutUs_titleBar)
    TitleBar aboutUsTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__about_us);
        ButterKnife.bind(this);
        initView();
    }


    public void initView(){
        aboutUsTitleBar.setTitle("关于我们");
        aboutUsTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        aboutUsTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        aboutUsTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        aboutUsTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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
