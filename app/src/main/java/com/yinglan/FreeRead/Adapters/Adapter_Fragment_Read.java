package com.yinglan.FreeRead.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yinglan.FreeRead.R;

import java.util.List;

/**
 * Created by Frank on 2019/3/25
 * Introduce : ${Text}
 */
public class Adapter_Fragment_Read extends RecyclerView.Adapter {

    private Context context;



    public Adapter_Fragment_Read(Context context){
        this.context = context;
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
        LinearLayout news_item1_layout2;

        public Read_item_two(@NonNull View itemView) {
            super(itemView);

            news_item2_title = itemView.findViewById(R.id.news_item2_title);
            news_item2_author = itemView.findViewById(R.id.news_item2_author);
            news_item2_haoping = itemView.findViewById(R.id.news_item2_haoping);
            news_item2_img = itemView.findViewById(R.id.news_item2_img);
            news_item1_layout2 = itemView.findViewById(R.id.news_item1_layout2);
        }
    }
    /*第二种布局*/


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = null;

        if (i == 1){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_news_item1,viewGroup,false);
            Read_item_one read_item_one = new Read_item_one(view);
            return read_item_one;
        }else{
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_news_item2,viewGroup,false);
            Read_item_two read_item_two = new Read_item_two(view);
            return read_item_two;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }


    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0){
            return 1;
        }else{
            return 2;
        }
    }
}
