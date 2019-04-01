package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.IResponseHandler;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.Constant.HttpConstant;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.LogUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_AboutUs extends BaseActivity {

    @BindView(R.id.aboutUs_titleBar)
    TitleBar aboutUsTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__about_us);
        ButterKnife.bind(this);
        initView();

        initNet();

    }


    public void initView(){
        aboutUsTitleBar.setTitle("关于我们");
        aboutUsTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        aboutUsTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        aboutUsTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        aboutUsTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
    }


    public void initNet(){
        Map<String, String> params = new HashMap<String, String>();

        MyOkHttp.get().post(HttpConstant.URL, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {
                LogUtils.d("网络请求状态码：------》成功"+statusCode);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                LogUtils.d("网络请求状态码：------》失败"+statusCode+","+error_msg);
            }
        });
    }


}
