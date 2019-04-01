package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.Constant.HttpConnect;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_Task extends BaseActivity {


    @BindView(R.id.task_titleBar)
    TitleBar taskTitleBar;
    @BindView(R.id.task_finishNum)
    TextView taskFinishNum;
    @BindView(R.id.task_jiangliNum)
    TextView taskJiangliNum;
    @BindView(R.id.task_list)
    RecyclerView taskList;

    private Context context;
    private Intent intent;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

                //刷新数据
                case 1:

                    initNet_Data();
                    break;

                //设置数据
                case 2:

                    Bundle bundle = msg.getData();
                    String taskedcount = bundle.getString("taskedcount");
                    String totalincome = bundle.getString("totalincome");

                    ToastUtils.showShort(context,"已完成"+taskedcount+",累计"+totalincome);

                    taskFinishNum.setText(taskedcount);
                    taskJiangliNum.setText(totalincome);


                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__task);
        ButterKnife.bind(this);

        context = this;

        initView();
        initNet_Data();
    }

    public void initNet_Data() {

        Map<String, String> params = new HashMap<>();
        params.put("userId", MyApplication.sharedPreferences.getString("user_id", ""));
        HttpConnect.getTaskListOfStarting(context, params, taskList, handler);
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
}
