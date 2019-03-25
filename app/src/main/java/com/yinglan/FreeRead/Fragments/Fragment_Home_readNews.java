package com.yinglan.FreeRead.Fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yinglan.FreeRead.Adapters.MyPagerAdapter;
import com.yinglan.FreeRead.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${AUTHOR} on 2019/3/23 0023
 * Function: ${Function}
 */
public class Fragment_Home_readNews extends Fragment {

    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.home_tabs)
    TabLayout homeTabs;
    @BindView(R.id.home_tabs_content)
    ViewPager homeTabsContent;
    @BindView(R.id.home_readnews_main)
    LinearLayout homeReadnewsMain;
    Unbinder unbinder;

    private View view;
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_read_news, null);
        unbinder = ButterKnife.bind(this, view);
        initTitles();
        initFragments();

        homeTabsContent.setAdapter(new MyPagerAdapter(getFragmentManager(), mFragmentList, mTitleList));
        //将tablayout与fragment关联
        homeTabs.setupWithViewPager(homeTabsContent);

        return view;
    }

    public void initTitles(){
        mTitleList = new ArrayList<>();
        mTitleList.add("推荐");
        mTitleList.add("热点");
        mTitleList.add("娱乐");
        mTitleList.add("体育");
        mTitleList.add("视频");
        //设置tablayout模式
        homeTabs.setTabMode(TabLayout.MODE_FIXED);
        //tablayout获取集合中的名称
        //homeTabs.addTab(homeTabs.newTab().setText(mTitleList.get(0)));
        //homeTabs.addTab(homeTabs.newTab().setText(mTitleList.get(1)));
        //homeTabs.addTab(homeTabs.newTab().setText(mTitleList.get(2)));
        //homeTabs.addTab(homeTabs.newTab().setText(mTitleList.get(3)));
        //homeTabs.addTab(homeTabs.newTab().setText(mTitleList.get(4)));

        for (int i = 0 ; i < mTitleList.size() ; i++){
            homeTabs.addTab(homeTabs.newTab().setText(mTitleList.get(i)));
        }

    }

    public void initFragments(){
        mFragmentList = new ArrayList<>();
//        mFragmentList.add(TextFragment.newInstance("推荐"));
//        mFragmentList.add(TextFragment.newInstance("热点"));
//        mFragmentList.add(TextFragment.newInstance("娱乐"));
//        mFragmentList.add(TextFragment.newInstance("体育"));
//        mFragmentList.add(TextFragment.newInstance("视频"));

        for (int i = 0 ; i < mTitleList.size() ; i++){
            mFragmentList.add(new Fragment_Home_news());
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
