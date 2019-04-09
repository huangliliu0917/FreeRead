package com.yinglan.FreeRead.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ${AUTHOR} on 2019/3/23 0023
 * Function: ${Function}
 */
public class Fragment_Home_chatHelp extends BaseFragment {

    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.home_wechat_addWeChat)
    FrameLayout homeWechatAddWeChat;
    @BindView(R.id.home_wechat_startRobHongBao)
    TextView homeWechatStartRobHongBao;
    Unbinder unbinder;
    private String mTitle = "DefaultValue";
    private View view;

    /*懒加载处理*/
    private boolean mHasLoadedOnce = false;
    private boolean isPrepared = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_wechat_helper, null);
        unbinder = ButterKnife.bind(this, view);
        isPrepared = true;
//        lazyLoad();
        return view;
    }

    public static TextFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        TextFragment fragment = new TextFragment();
        fragment.setArguments(bundle);
        return fragment;
    }



    @OnClick({R.id.home_wechat_addWeChat, R.id.home_wechat_startRobHongBao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_wechat_addWeChat:
                break;
            case R.id.home_wechat_startRobHongBao:
                break;
        }
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

}
