package com.yinglan.FreeRead;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.BounceEnter.BounceTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;
import com.yinglan.FreeRead.Utils.MyActivityManager;
import com.yinglan.FreeRead.wxapi.WXUtils;

/**
 * Created by ${AUTHOR} on 2019/3/31 0031
 * Function: ${Function}
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyActivityManager.getAppManager().addActivity(this);
    }

}
