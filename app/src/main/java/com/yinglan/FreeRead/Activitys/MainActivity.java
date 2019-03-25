package com.yinglan.FreeRead.Activitys;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yinglan.FreeRead.Fragments.Fragment_Home_chatHelp;
import com.yinglan.FreeRead.Fragments.Fragment_Home_makeMoney;
import com.yinglan.FreeRead.Fragments.Fragment_Home_personal;
import com.yinglan.FreeRead.Fragments.Fragment_Home_readNews;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Fragments.TextFragment;
import com.yinglan.FreeRead.Utils.NoScrollViewPager;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AlphaTabsIndicator alphaTabsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoScrollViewPager mViewPger = (NoScrollViewPager) findViewById(R.id.mViewPager);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPger.setAdapter(mainAdapter);
        mViewPger.addOnPageChangeListener(mainAdapter);
        mViewPger.setNoScroll(true);

        alphaTabsIndicator = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator);
        alphaTabsIndicator.setViewPager(mViewPger);
    }


    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles = {"自动赚钱", "新闻阅读", "微信助手", "个人中心"};

        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(new Fragment_Home_makeMoney());
            fragments.add(new Fragment_Home_readNews());
            fragments.add(new Fragment_Home_chatHelp());
            fragments.add(new Fragment_Home_personal());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (0 == position) {
                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
            } else if (2 == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            } else if (3 == position) {
                alphaTabsIndicator.removeAllBadge();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
