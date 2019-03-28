package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Task extends AppCompatActivity {

    @BindView(R.id.task_titleBar)
    TitleBar taskTitleBar;
    @BindView(R.id.task_chaoji_info)
    TextView taskChaojiInfo;
    @BindView(R.id.task_chaoji_jiangli)
    TextView taskChaojiJiangli;
    @BindView(R.id.task_chaoji_receive)
    TextView taskChaojiReceive;
    @BindView(R.id.task_chaoji)
    LinearLayout taskChaoji;
    @BindView(R.id.task_yexiao_info)
    TextView taskYexiaoInfo;
    @BindView(R.id.task_yexiao_jiangli)
    TextView taskYexiaoJiangli;
    @BindView(R.id.task_yexiao_receive)
    TextView taskYexiaoReceive;
    @BindView(R.id.task_yexiao)
    LinearLayout taskYexiao;
    @BindView(R.id.task_shenmi_info)
    TextView taskShenmiInfo;
    @BindView(R.id.task_shenmi_jiangli)
    TextView taskShenmiJiangli;
    @BindView(R.id.task_shenmi_receive)
    TextView taskShenmiReceive;
    @BindView(R.id.task_shenmi)
    LinearLayout taskShenmi;
    @BindView(R.id.task_finishNum)
    TextView taskFinishNum;
    @BindView(R.id.task_jiangliNum)
    TextView taskJiangliNum;


    private Context context;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__task);
        ButterKnife.bind(this);

        context = this;

        initView();
    }


    @SuppressLint("ResourceAsColor")
    public void initView() {
        taskTitleBar.setTitle("任务");
        taskTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        taskTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        taskTitleBar.setRightTitle("任务说明");
        taskTitleBar.setRightColor(this.getResources().getColor(R.color.colorWhite));
        taskTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        taskTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                intent = new Intent(context, Activity_TaskInfo.class);
                startActivity(intent);
            }
        });

    }

    @OnClick({R.id.task_chaoji_receive, R.id.task_yexiao_receive, R.id.task_shenmi_receive})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.task_chaoji_receive:
                break;
            case R.id.task_yexiao_receive:
                break;
            case R.id.task_shenmi_receive:
                break;
        }
    }
}
