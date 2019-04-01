package com.yinglan.FreeRead.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yinglan.FreeRead.Activitys.Activity_Home_NewsInfo;
import com.yinglan.FreeRead.Base.ArticlePagerNewsBean;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.LogUtils;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Frank on 2019/3/25
 * Introduce : ${Text}
 */
public class Adapter_Fragment_Read extends RecyclerView.Adapter{

    private Context context;
    private Intent intent;

    private ArticlePagerNewsBean listBean;



    public Adapter_Fragment_Read(Context context,ArticlePagerNewsBean listBean){
        this.context = context;
        this.listBean = listBean;
    }


    /*第一种布局*/
    static class Read_item_one extends RecyclerView.ViewHolder{

        TextView news_item1_title,news_item1_author,news_item1_haoping;
        ImageView news_item1_img1,news_item1_img2,news_item1_img3;
        LinearLayout news_item1_layout1;

        public Read_item_one(@NonNull View itemView) {
            super(itemView);
            news_item1_title = itemView.findViewById(R.id.news_item1_title);
            news_item1_author = itemView.findViewById(R.id.news_item1_author);
            news_item1_haoping = itemView.findViewById(R.id.news_item1_haoping);
            news_item1_img1 = itemView.findViewById(R.id.news_item1_img1);
            news_item1_img2 = itemView.findViewById(R.id.news_item1_img2);
            news_item1_img3 = itemView.findViewById(R.id.news_item1_img3);
            news_item1_layout1 = itemView.findViewById(R.id.news_item1_layout1);
        }
    }
    /*第一种布局*/


    /*第二种布局*/
    static class Read_item_two extends RecyclerView.ViewHolder{

        TextView news_item2_title,news_item2_author,news_item2_haoping;
        ImageView news_item2_img;
        LinearLayout news_item2_layout2;

        public Read_item_two(@NonNull View itemView) {
            super(itemView);

            news_item2_title = itemView.findViewById(R.id.news_item2_title);
            news_item2_author = itemView.findViewById(R.id.news_item2_author);
            news_item2_haoping = itemView.findViewById(R.id.news_item2_haoping);
            news_item2_img = itemView.findViewById(R.id.news_item2_img);
            news_item2_layout2 = itemView.findViewById(R.id.news_item2_layout2);
        }
    }
    /*第二种布局*/


    /*第三种布局*/
    static class Read_item_three extends RecyclerView.ViewHolder{

        TextView tv_video_userName,tv_video_pinglun;
        JZVideoPlayerStandard jzPlayer;
        LinearLayout img_video_main;
        ImageView img_video_icon,tv_video_fenxiang,tv_video_more;

        public Read_item_three(@NonNull View itemView) {
            super(itemView);

            tv_video_userName = itemView.findViewById(R.id.tv_video_userName);
            tv_video_pinglun = itemView.findViewById(R.id.tv_video_pinglun);
            jzPlayer = itemView.findViewById(R.id.jzPlayer);
            img_video_main = itemView.findViewById(R.id.img_video_main);
            img_video_icon = itemView.findViewById(R.id.img_video_icon);
            tv_video_fenxiang = itemView.findViewById(R.id.tv_video_fenxiang);
            tv_video_more = itemView.findViewById(R.id.tv_video_more);
        }
    }
    /*第三种布局*/


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = null;

        if (i == 1){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_news_item1,viewGroup,false);
            Read_item_one read_item_one = new Read_item_one(view);
            return read_item_one;
        }else if(i == 2){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_news_item2,viewGroup,false);
            Read_item_two read_item_two = new Read_item_two(view);
            return read_item_two;
        }else{
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video,viewGroup,false);
            Read_item_three read_item_three = new Read_item_three(view);
            return read_item_three;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,final int i) {

        String [] images = listBean.getList().get(i).getImgUrls().split(";");

        switch (getItemViewType(i)){

            case 1:
                    Read_item_one read_item_one = (Read_item_one) viewHolder;
                    read_item_one.news_item1_title.setText(listBean.getList().get(i).getTitle());
                    read_item_one.news_item1_author.setText(listBean.getList().get(i).getAuthor());
                    read_item_one.news_item1_haoping.setText(listBean.getList().get(i).getFromSource());

                    Glide.with(context).load(images[0]).into(read_item_one.news_item1_img1);
                    Glide.with(context).load(images[1]).into(read_item_one.news_item1_img1);
                    Glide.with(context).load(images[2]).into(read_item_one.news_item1_img1);

                    read_item_one.news_item1_layout1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (listBean.getList().get(i).getUrl() != "") {
                                Intent intent = new Intent(context, Activity_Home_NewsInfo.class);
                                intent.putExtra("url", listBean.getList().get(i).getUrl());
                                context.startActivity(intent);
                            }
                        }
                    });

                break;



            case 2:
                Read_item_two read_item_two = (Read_item_two) viewHolder;
                read_item_two.news_item2_title.setText(listBean.getList().get(i).getTitle());
                read_item_two.news_item2_author.setText(listBean.getList().get(i).getAuthor());
                read_item_two.news_item2_haoping.setText(listBean.getList().get(i).getFromSource());
                Glide.with(context).load(images[0]).into(read_item_two.news_item2_img);

                read_item_two.news_item2_layout2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Activity_Home_NewsInfo.class);
                        intent.putExtra("url", listBean.getList().get(i).getUrl());
                        context.startActivity(intent);
                    }
                });

                break;


            case 3:
                Read_item_three read_item_three = (Read_item_three) viewHolder;

                read_item_three.tv_video_userName.setText(listBean.getList().get(i).getAuthor());


                if (listBean.getList().get(i).getVideoUrl() != ""){
                    read_item_three.jzPlayer.setUp(listBean.getList().get(i).getVideoUrl(),JZVideoPlayer.SCREEN_WINDOW_NORMAL,listBean.getList().get(i).getTitle());
                    Glide.with(context).load(listBean.getList().get(i).getImgUrls())
                            .into(read_item_three.jzPlayer.thumbImageView);
                }

                read_item_three.img_video_main.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Activity_Home_NewsInfo.class);
                        intent.putExtra("url", listBean.getList().get(i).getUrl());
                        context.startActivity(intent);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listBean.getList().size();
    }


    @Override
    public int getItemViewType(int position) {

        String [] images = listBean.getList().get(position).getImgUrls().split(";");

        if (listBean.getList().get(position).getCategoryId() == 1 || listBean.getList().get(position).getCategoryId() == 2 ||
                listBean.getList().get(position).getCategoryId() == 3 || listBean.getList().get(position).getCategoryId() == 4){
            if (images.length >= 3){
                return 1;
            }else{
                return 2;
            }
        }else{
            return 3;
        }
    }


}
