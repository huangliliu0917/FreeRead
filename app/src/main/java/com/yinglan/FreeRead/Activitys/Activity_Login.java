package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.Adapters.MyPagerAdapter;
import com.yinglan.FreeRead.Fragments.Fragment_Login_UsePassword;
import com.yinglan.FreeRead.Fragments.Fragment_Login_UsePhone;
import com.yinglan.FreeRead.Fragments.Fragment_ReadSet_functionSet;
import com.yinglan.FreeRead.Fragments.Fragment_ReadSet_instruction;
import com.yinglan.FreeRead.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_Login extends AppCompatActivity {

    @BindView(R.id.login_titleBar)
    TitleBar loginTitleBar;
    @BindView(R.id.login_tabs)
    TabLayout loginTabs;
    @BindView(R.id.login_content)
    ViewPager loginContent;
    @BindView(R.id.login_main)
    LinearLayout loginMain;

    private Intent intent;

    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
        ButterKnife.bind(this);
        intent = new Intent();
        initView();


        initTitles();
        initFragments();

        loginContent.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragmentList, mTitleList));
        //将tablayout与fragment关联
        loginTabs.setupWithViewPager(loginContent);

    }


    @SuppressLint("ResourceAsColor")
    public void initView() {
        loginTitleBar.setTitle("登录");
        loginTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        loginTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        loginTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {

            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
    }

    public void initTitles() {
        mTitleList = new ArrayList<>();
        mTitleList.add("账户密码登录");
        mTitleList.add("手机登录");
    }

    public void initFragments() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new Fragment_Login_UsePassword());
        mFragmentList.add(new Fragment_Login_UsePhone());
    }


}
