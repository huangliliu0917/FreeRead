package com.yinglan.FreeRead.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yinglan.FreeRead.Base.BaseNews;
import com.yinglan.FreeRead.R;
import java.util.List;

/**
 * Created by ${AUTHOR} on 2019/3/25 0025
 * Function: 消息适配器
 */
public class Adapter_NewsList extends RecyclerView.Adapter {

    private Context context;
    private List<BaseNews> traceList;
    private static final int TYPE_TOP = 0x0000;
    private static final int TYPE_NORMAL= 0x0001;

    public Adapter_NewsList(Context context, List<BaseNews> traceList) {
        this.context = context;
        this.traceList = traceList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvAcceptTitle, tvAcceptStation, tvAccepTime;
        TextView tvTopLine, tvDot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAcceptTitle = itemView.findViewById(R.id.tvAcceptTitle);
            tvAcceptStation =  itemView.findViewById(R.id.tvAcceptStation);
            tvAccepTime = itemView.findViewById(R.id.tvAccepTime);
            tvTopLine = itemView.findViewById(R.id.tvTopLine);
            tvDot = itemView.findViewById(R.id.tvDot);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_time_line,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        ViewHolder viewHolder1 = (ViewHolder) viewHolder;

        if (viewHolder1.getItemViewType() == TYPE_TOP) {
            // 第一行头的竖线不显示
            viewHolder1.tvTopLine.setVisibility(View.INVISIBLE);

        } else if (viewHolder.getItemViewType() == TYPE_NORMAL) {
            viewHolder1.tvTopLine.setVisibility(View.VISIBLE);

        }

        if (viewHolder1.getAdapterPosition() % 2 == 0){
            viewHolder1.tvDot.setBackgroundResource(R.drawable.timelline_dot_normal1);
        }else{
            viewHolder1.tvDot.setBackgroundResource(R.drawable.timelline_dot_normal);
        }

//        viewHolder1.tvAcceptTitle.setText(traceList.get(i).getTitle());
//        viewHolder1.tvAcceptStation.setText(traceList.get(i).getInfo());
//        viewHolder1.tvAccepTime.setText(traceList.get(i).getTime());
    }

    @Override
    public int getItemViewType(int id) {
        if (id == 0) {
            return TYPE_TOP;
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return traceList.size();
    }


}
