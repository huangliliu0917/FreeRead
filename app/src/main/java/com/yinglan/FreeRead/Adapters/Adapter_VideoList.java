package com.yinglan.FreeRead.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yinglan.FreeRead.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by ${AUTHOR} on 2019/3/28 0028
 * Function: ${Function}
 */
public class Adapter_VideoList extends RecyclerView.Adapter {


    private Context context;


    public Adapter_VideoList(Context context){
            this.context = context;
    }

    static class ViewHolder_Video extends RecyclerView.ViewHolder{
        JZVideoPlayerStandard jzPlayer;
        ImageView img_video_icon,tv_video_fenxiang,tv_video_more;
        TextView tv_video_userName;

        public ViewHolder_Video(@NonNull View itemView) {
            super(itemView);
            jzPlayer = itemView.findViewById(R.id.jzPlayer);
            img_video_icon = itemView.findViewById(R.id.img_video_icon);
            tv_video_fenxiang = itemView.findViewById(R.id.tv_video_fenxiang);
            tv_video_more = itemView.findViewById(R.id.tv_video_more);
            tv_video_userName = itemView.findViewById(R.id.tv_video_userName);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_video,viewGroup,false);
        final ViewHolder_Video viewHolder_video = new ViewHolder_Video(view);
        return viewHolder_video;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder_Video viewHolder_video = (ViewHolder_Video) viewHolder;

        viewHolder_video.jzPlayer.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4",JZVideoPlayer.SCREEN_WINDOW_NORMAL);
    }

    @Override
    public int getItemCount() {
        return 10;
    }






}
