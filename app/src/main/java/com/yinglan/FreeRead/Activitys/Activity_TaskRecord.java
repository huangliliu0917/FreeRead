package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.MyExpandableListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_TaskRecord extends BaseActivity {

    @BindView(R.id.taskrecord_titleBar)
    TitleBar taskrecordTitleBar;
    @BindView(R.id.task_record_expandableListView)
    ExpandableListView taskRecordExpandableListView;


    private Context context;
     //一级列表数据源
     private String[] groups = {"本月", "1月", "2月"};
     //二级列表数据源
     private String[][] childs={{"超值特惠任务1","超值特惠任务2","超值特惠任务3","超值特惠任务4"},
             {"超值特惠任务1","超值特惠任务2","超值特惠任务3", "超值特惠任务4 "},
             {"超值特惠任务1","超值特惠任务2","超值特惠任务3"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__task_record);
        ButterKnife.bind(this);

        context = getApplicationContext();
        initView();
    }


    @SuppressLint("ResourceAsColor")
    public void initView() {
        taskrecordTitleBar.setTitle("任务记录");
        taskrecordTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        taskrecordTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        taskrecordTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        taskrecordTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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


        //#TODO 去掉自带箭头，在一级列表中动态添加
        taskRecordExpandableListView.setGroupIndicator(null);
        taskRecordExpandableListView.setAdapter(new MyExpandableListView(context,groups,childs));
        taskRecordExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                return true;
            }
        });


    }




}
