package com.yinglan.FreeRead.Adapters;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yinglan.FreeRead.Base.UserTaskBean;
import com.yinglan.FreeRead.Constant.HttpConnect;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by ${AUTHOR} on 2019/4/1 0001
 * Function: ${Function}
 */
public class Adapter_UserTask extends RecyclerView.Adapter{


    private Context context;
    private UserTaskBean userTaskBean;
    private Handler handler;


    public Adapter_UserTask(Context context, UserTaskBean userTaskBean, Handler handler){
        this.context = context;
        this.userTaskBean = userTaskBean;
        this.handler = handler;
    }

    static class ViewHolder_UserTask extends RecyclerView.ViewHolder{
        ImageView item_task_icon;
        TextView item_task_title,item_task_info,item_task_jiangli,item_task_receive;

        public ViewHolder_UserTask(@NonNull View itemView) {
            super(itemView);
            item_task_icon = itemView.findViewById(R.id.item_task_icon);
            item_task_title = itemView.findViewById(R.id.item_task_title);
            item_task_info = itemView.findViewById(R.id.item_task_info);
            item_task_jiangli = itemView.findViewById(R.id.item_task_jiangli);
            item_task_receive = itemView.findViewById(R.id.item_task_receive);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_task,viewGroup,false);
        final ViewHolder_UserTask viewHolder_userTask = new ViewHolder_UserTask(view);
        return viewHolder_userTask;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        final ViewHolder_UserTask viewHolder_userTask = (ViewHolder_UserTask) viewHolder;

        /*设置图片*/
        switch (userTaskBean.getList().get(i).getTaskIcon()){

        }

        viewHolder_userTask.item_task_title.setText(userTaskBean.getList().get(i).getTaskName());
        viewHolder_userTask.item_task_jiangli.setText(userTaskBean.getList().get(i).getRewardAmount()+userTaskBean.getList().get(i).getRewardUnit());
        viewHolder_userTask.item_task_info.setText(userTaskBean.getList().get(i).getDescription());

        if (userTaskBean.getList().get(i).isIsDraw()){
            viewHolder_userTask.item_task_receive.setText("已完成");
            viewHolder_userTask.item_task_receive.setClickable(false);
        }else{
            viewHolder_userTask.item_task_receive.setText("领任务");
            viewHolder_userTask.item_task_receive.setClickable(true);

            viewHolder_userTask.item_task_receive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Map<String, String> params = new HashMap<>();
                    params.put("UserId", MyApplication.sharedPreferences.getString("user_id", ""));
                    params.put("TaskId", String.valueOf(userTaskBean.getList().get(i).getTaskId()));
                    HttpConnect.drawTask(context, params);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return userTaskBean.getList().size();
    }

}
