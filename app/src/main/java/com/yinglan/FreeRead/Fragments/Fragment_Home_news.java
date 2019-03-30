package com.yinglan.FreeRead.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinglan.FreeRead.Adapters.Adapter_Fragment_Read;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Frank on 2019/3/25
 * Introduce : ${Text}
 */
public class Fragment_Home_news extends BaseFragment {

    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.recycler_home_news)
    RecyclerView recyclerHomeNews;
    Unbinder unbinder;
    private String mTitle = "DefaultValue";
    private View view;

    /*懒加载处理*/
    private boolean mHasLoadedOnce = false;
    private boolean isPrepared = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_news, null);
        unbinder = ButterKnife.bind(this, view);
        isPrepared = true;
        lazyLoad();

        initView();


        return view;
    }


    public void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerHomeNews.setLayoutManager(linearLayoutManager);
        Adapter_Fragment_Read adapter_fragment_read = new Adapter_Fragment_Read(getContext());
        recyclerHomeNews.setAdapter(adapter_fragment_read);
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
