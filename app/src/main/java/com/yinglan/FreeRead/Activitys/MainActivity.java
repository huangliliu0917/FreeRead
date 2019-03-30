package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yinglan.FreeRead.Fragments.Fragment_Home_chatHelp;
import com.yinglan.FreeRead.Fragments.Fragment_Home_makeMoney;
import com.yinglan.FreeRead.Fragments.Fragment_Home_personal;
import com.yinglan.FreeRead.Fragments.Fragment_Home_readNews;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.NoScrollViewPager;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mViewPager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator alphaIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mainAdapter);
        mViewPager.addOnPageChangeListener(mainAdapter);
        mViewPager.setNoScroll(true);

        alphaIndicator.setViewPager(mViewPager);
    }


    public class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles = {"自动赚钱", "新闻阅读", "微信助手", "个人中心"};

        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(new Fragment_Home_makeMoney(mViewPager));
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
                alphaIndicator.getTabView(0).showNumber(alphaIndicator.getTabView(0).getBadgeNumber() - 1);
            } else if (2 == position) {
                alphaIndicator.getCurrentItemView().removeShow();
            } else if (3 == position) {
                alphaIndicator.removeAllBadge();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }


}
