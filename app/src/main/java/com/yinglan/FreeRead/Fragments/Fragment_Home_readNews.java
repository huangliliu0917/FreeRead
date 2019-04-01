package com.yinglan.FreeRead.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yinglan.FreeRead.Adapters.MyPagerAdapter;
import com.yinglan.FreeRead.Base.CategoryBean;
import com.yinglan.FreeRead.Constant.HttpConnect;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.JZVideoPlayer;

/**
 * Created by ${AUTHOR} on 2019/3/23 0023
 * Function: ${Function}
 */
public class Fragment_Home_readNews extends BaseFragment {

    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.home_tabs)
    TabLayout homeTabs;
    @BindView(R.id.home_tabs_content)
    ViewPager homeTabsContent;
    @BindView(R.id.home_readnews_main)
    LinearLayout homeReadnewsMain;
    Unbinder unbinder;

    private Context context;
    private View view;
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    /*懒加载处理*/
    private boolean mHasLoadedOnce = false;
    private boolean isPrepared = false;
    private CategoryBean categoryBean;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:

                    mTitleList = new ArrayList<>();
                    mFragmentList = new ArrayList<>();
                    categoryBean = (CategoryBean) msg.getData().getSerializable("allCategory");

                    //设置tablayout模式
                    homeTabs.setTabMode(TabLayout.MODE_FIXED);

                    for (int i = 0 ; i < categoryBean.getList().size() ; i++){
                        mTitleList.add(i,categoryBean.getList().get(i).getName());
                        homeTabs.addTab(homeTabs.newTab().setText(categoryBean.getList().get(i).getName()));


                        Bundle bundle = new Bundle();
                        bundle.putInt("typeId",categoryBean.getList().get(i).getId());

                        Fragment_Home_news fragment_home_news = new Fragment_Home_news();
                        fragment_home_news.setArguments(bundle);

                        mFragmentList.add(fragment_home_news);

                    }

                    homeTabsContent.setAdapter(new MyPagerAdapter(getFragmentManager(), mFragmentList, mTitleList));
                    //将tablayout与fragment关联
                    homeTabs.setupWithViewPager(homeTabsContent);

                    break;
            }
        }
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_read_news, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();

        isPrepared = true;
        lazyLoad();

        initTitles();

        return view;
    }

    public void initTitles(){

        Map<String, String> params = new HashMap<>();
        HttpConnect.allNewsCategory(context, params, handler);

    }


    @Override
    protected void lazyLoad() {
        if (mHasLoadedOnce || !isPrepared)
            return;
        mHasLoadedOnce = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mHasLoadedOnce = false;
        isPrepared = false;
    }


    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }



}
