package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.Adapters.MyPagerAdapter;
import com.yinglan.FreeRead.Fragments.Fragment_ReadSet_functionSet;
import com.yinglan.FreeRead.Fragments.Fragment_ReadSet_instruction;
import com.yinglan.FreeRead.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_ReadSet extends AppCompatActivity {

    @BindView(R.id.readSet_titleBar)
    TitleBar readSetTitleBar;
    @BindView(R.id.readSet_tabs)
    TabLayout readSetTabs;
    @BindView(R.id.readSet_content)
    ViewPager readSetContent;
    @BindView(R.id.readSet_main)
    LinearLayout readSetMain;

    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__read_set);
        ButterKnife.bind(this);

        initView();
        initTitles();
        initFragments();

        readSetContent.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragmentList, mTitleList));
        //将tablayout与fragment关联
        readSetTabs.setupWithViewPager(readSetContent);
    }

    public void initView(){
        readSetTitleBar.setTitle("阅读设置");
        readSetTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        readSetTitleBar.setRightTitle("确定");
        readSetTitleBar.setRightColor(this.getResources().getColor(R.color.colorWhite));
        readSetTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        readSetTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        readSetTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                Toast.makeText(getApplicationContext(),"完成设置",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void initTitles() {
        mTitleList = new ArrayList<>();
        mTitleList.add("功能设置");
        mTitleList.add("使用说明");
    }

    public void initFragments() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new Fragment_ReadSet_functionSet());
        mFragmentList.add(new Fragment_ReadSet_instruction());
    }


}
