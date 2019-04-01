package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_TaskInfo extends BaseActivity {

    @BindView(R.id.taskInfo_titleBar)
    TitleBar taskInfoTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__task_info);
        ButterKnife.bind(this);

        initView();
    }


    @SuppressLint("ResourceAsColor")
    public void initView() {
        taskInfoTitleBar.setTitle("任务说明");
        taskInfoTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        taskInfoTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        taskInfoTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        taskInfoTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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

}
