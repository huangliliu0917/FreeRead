package com.yinglan.FreeRead.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinglan.FreeRead.Adapters.Adapter_Fragment_Read;
import com.yinglan.FreeRead.R;

/**
 * Created by Frank on 2019/3/25
 * Introduce : ${Text}
 */
public class Fragment_Home_news extends Fragment {

    public static final String BUNDLE_TITLE = "title";
    private String mTitle = "DefaultValue";
    private View view;

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_news,null);

        initView();

        return view;
    }


    public void initView(){
        recyclerView = view.findViewById(R.id.recycler_home_news);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Adapter_Fragment_Read adapter_fragment_read = new Adapter_Fragment_Read(getContext());
        recyclerView.setAdapter(adapter_fragment_read);
    }


    public static TextFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        TextFragment fragment = new TextFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}
