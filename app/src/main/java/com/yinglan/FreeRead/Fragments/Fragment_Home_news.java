package com.yinglan.FreeRead.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinglan.FreeRead.Adapters.Adapter_Fragment_Read;
import com.yinglan.FreeRead.Constant.HttpConnect;
import com.yinglan.FreeRead.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Frank on 2019/3/25
 * Introduce : ${Text}
 */
@SuppressLint("ValidFragment")
public class Fragment_Home_news extends BaseFragment {

    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.recycler_home_news)
    RecyclerView recyclerHomeNews;
    Unbinder unbinder;
    private String mTitle = "DefaultValue";
    private View view;
    private Context context;

    /*懒加载处理*/
    private boolean mHasLoadedOnce = false;
    private boolean isPrepared = false;

    private int typeId;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_news, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        isPrepared = true;
        lazyLoad();

        savedInstanceState = getArguments();
        if (savedInstanceState != null){
            typeId = savedInstanceState.getInt("typeId");
            initData(typeId);
        }

        return view;
    }

    public void initView() {

    }

    public void initData(int typeId){
        Map<String, String> params = new HashMap<>();

        params.put("TypeId",String.valueOf(typeId));
        params.put("PageIndex","2");
        params.put("PageSize","10");

        HttpConnect.readNewsArticlePager(context, params, handler,recyclerHomeNews);
    }

    public static TextFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        TextFragment fragment = new TextFragment();
        fragment.setArguments(bundle);
        return fragment;
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
