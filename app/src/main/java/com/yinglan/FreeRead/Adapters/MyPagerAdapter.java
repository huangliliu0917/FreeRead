package com.yinglan.FreeRead.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ${AUTHOR} on 2019/3/23 0023
 * Function: ${Function}
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    //添加fragment的集合
    private List<Fragment> mFragmentList;
    //添加标题的集合
    private List<String> mTilteLis;

    public MyPagerAdapter(FragmentManager fm,List<Fragment> mFragmentList,List<String> mTilteLis) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.mTilteLis = mTilteLis;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTilteLis.get(position);
    }
}
