package com.yinglan.FreeRead.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinglan.FreeRead.R;

/**
 * Created by ${AUTHOR} on 2019/3/26 0026
 * Function: ${Function}
 */
public class Fragment_ReadSet_instruction extends Fragment {


    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_readset_instruction,null);

        return view;
    }
}
