package com.yinglan.FreeRead.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinglan.FreeRead.R;

/**
 * Created by ${AUTHOR} on 2019/3/23 0023
 * Function: ${Function}
 */
public class Fragment_Home_personal extends Fragment {

    public static final String BUNDLE_TITLE = "title";
    private String mTitle = "DefaultValue";
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_personal,null);

        return view;
    }

    public static TextFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        TextFragment fragment = new TextFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}
