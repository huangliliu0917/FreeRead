package com.yinglan.FreeRead.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.kyleduo.switchbutton.SwitchButton;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${AUTHOR} on 2019/3/26 0026
 * Function: ${Function}
 */
public class Fragment_ReadSet_functionSet extends Fragment {

    @BindView(R.id.setFunction_souhu_back)
    EditText setFunctionSouhuBack;
    @BindView(R.id.setFunction_souhu_fresh)
    EditText setFunctionSouhuFresh;
    @BindView(R.id.setFunction_taoNews_back)
    EditText setFunctionTaoNewsBack;
    @BindView(R.id.setFunction_taoNews_fresh)
    EditText setFunctionTaoNewsFresh;
    @BindView(R.id.setFunction_quTitle_back)
    EditText setFunctionQuTitleBack;
    @BindView(R.id.setFunction_quTitle_fresh)
    EditText setFunctionQuTitleFresh;
    @BindView(R.id.readset_setfunction_isOpen)
    SwitchButton readsetSetfunctionIsOpen;
    Unbinder unbinder;
    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_readset_setfuntion, null);

        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }


    public void initView(){

        readsetSetfunctionIsOpen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getContext(),"打开自动赚钱功能",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(),"关闭自动赚钱功能",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
