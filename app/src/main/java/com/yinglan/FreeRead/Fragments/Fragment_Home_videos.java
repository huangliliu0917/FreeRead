package com.yinglan.FreeRead.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinglan.FreeRead.Adapters.Adapter_VideoList;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.JZVideoPlayer;

/**
 * Created by ${AUTHOR} on 2019/3/28 0028
 * Function: ${Function}
 */
public class Fragment_Home_videos extends BaseFragment {

    @BindView(R.id.home_videos_recycler)
    RecyclerView homeVideosRecycler;
    Unbinder unbinder;
    private View view;

    /*懒加载处理*/
    private boolean mHasLoadedOnce = false;
    private boolean isPrepared = false;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fargment_home_videos, null);
        unbinder = ButterKnife.bind(this, view);

        isPrepared = true;
        lazyLoad();

        initView();
        initData();

        return view;
    }


    public void initView() {

    }


    public void initData(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
homeVideosRecycler.setLayoutManager(linearLayoutManager);
        Adapter_VideoList adapter_videoList = new Adapter_VideoList(getContext());
        homeVideosRecycler.setAdapter(adapter_videoList);
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


    @Override
    protected void lazyLoad() {
        if (mHasLoadedOnce || !isPrepared)
            return;
        mHasLoadedOnce = true;
    }

}
