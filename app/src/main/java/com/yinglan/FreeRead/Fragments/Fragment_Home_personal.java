package com.yinglan.FreeRead.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yinglan.FreeRead.Activitys.Activity_AboutUs;
import com.yinglan.FreeRead.Activitys.Activity_AskQuestion;
import com.yinglan.FreeRead.Activitys.Activity_News;
import com.yinglan.FreeRead.Activitys.Activity_NormalQuestion;
import com.yinglan.FreeRead.Activitys.Activity_OnlineHelper;
import com.yinglan.FreeRead.Activitys.Activity_Setting;
import com.yinglan.FreeRead.Activitys.Activity_TiXian;
import com.yinglan.FreeRead.Constant.HttpConnect;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ${AUTHOR} on 2019/3/23 0023
 * Function: ${Function}
 */
public class Fragment_Home_personal extends BaseFragment {

    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.btn_person_xiaoxi)
    ImageView btnPersonXiaoxi;
    @BindView(R.id.btn_person_kefu)
    ImageView btnPersonKefu;
    @BindView(R.id.btn_person_setting)
    ImageView btnPersonSetting;
    @BindView(R.id.person_inviteMakeMoney)
    LinearLayout personInviteMakeMoney;
    @BindView(R.id.person_tixian)
    LinearLayout personTixian;
    @BindView(R.id.person_normalProblem)
    LinearLayout personNormalProblem;
    @BindView(R.id.person_askQuestion)
    LinearLayout personAskQuestion;
    @BindView(R.id.person_about)
    LinearLayout personAbout;
    Unbinder unbinder;
    private String mTitle = "DefaultValue";
    private View view;
    private Context context;
    private Intent intent;
    /*懒加载处理*/
    private boolean mHasLoadedOnce = false;
    private boolean isPrepared = false;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_personal, null);
        unbinder = ButterKnife.bind(this, view);
        intent = new Intent();
        context = getContext();

        isPrepared = true;
        lazyLoad();

        initNet();

        return view;
    }

    public void initNet(){

        Map<String,String> params = new HashMap<>();
        params.put("userId",MyApplication.sharedPreferences.getString("user_id",""));

        HttpConnect.getProfileIncomeOfMediaPlatform(context, params, handler);
    }



    public static TextFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        TextFragment fragment = new TextFragment();
        fragment.setArguments(bundle);
        return fragment;
    }



    @OnClick({R.id.btn_person_xiaoxi, R.id.btn_person_kefu, R.id.btn_person_setting, R.id.person_inviteMakeMoney, R.id.person_tixian, R.id.person_normalProblem, R.id.person_askQuestion, R.id.person_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_person_xiaoxi:
                intent.setClass(getContext(),Activity_News.class);
                startActivity(intent);
                break;
            case R.id.btn_person_kefu:
                intent.setClass(getContext(),Activity_OnlineHelper.class);
                startActivity(intent);
                break;
            case R.id.btn_person_setting:
                intent.setClass(getContext(),Activity_Setting.class);
                startActivity(intent);
                break;
            case R.id.person_inviteMakeMoney:
                break;
            case R.id.person_tixian:
                intent.setClass(getContext(),Activity_TiXian.class);
                startActivity(intent);
                break;
            case R.id.person_normalProblem:
                intent.setClass(getContext(),Activity_NormalQuestion.class);
                startActivity(intent);
                break;
            case R.id.person_askQuestion:
                intent.setClass(getContext(),Activity_AskQuestion.class);
                startActivity(intent);
                break;
            case R.id.person_about:
                intent.setClass(getContext(),Activity_AboutUs.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mHasLoadedOnce = false;
        isPrepared = false;
    }

    @Override
    protected void lazyLoad() {
        if (mHasLoadedOnce || !isPrepared)
            return;
        mHasLoadedOnce = true;
    }
}
