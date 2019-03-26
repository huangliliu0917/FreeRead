package com.yinglan.FreeRead.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yinglan.FreeRead.Base.CardBean;
import com.yinglan.FreeRead.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ${AUTHOR} on 2019/3/26 0026
 * Function: ${Function}
 */
public class Adapter_selectBankCard extends RecyclerView.Adapter<Adapter_selectBankCard.MyViewHolder> {

    private Context mContext;
    private List<CardBean> cards;
    private OnItemClickListener mOnItemClickListener;

    private HashMap<Integer, Boolean> map;


    @SuppressLint("UseSparseArrays")
    public Adapter_selectBankCard(Context mContext) {
        this.mContext = mContext;
        map = new HashMap<>();
        cards = new ArrayList<>();
    }


    public void setData(List<CardBean> cardBeans) {
        this.cards.clear();
        this.cards.addAll(cardBeans);

        map.clear();
        for (int i = 0; i < this.cards.size(); i++) {
            map.put(i, false);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_selectcard, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        CardBean card = cards.get(i);

        Glide.with(mContext).load(mContext.getResources().getDrawable(R.mipmap.icon_zhaoshangyinhang)).into(myViewHolder.bankCard_icon);
        myViewHolder.bankCard_Name.setText(card.getCardName());
        myViewHolder.bankCard_type.setText(card.getCardType());
        myViewHolder.bankCard_id.setText(card.getCardId());

    }


    //设置单选
    private void singleSelect(int pos) {
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(false);
        }
        map.put(pos, true);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return cards.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView bankCard_icon;
        private TextView bankCard_Name,bankCard_type,bankCard_id;
        private LinearLayout bankCard_one;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bankCard_icon = itemView.findViewById(R.id.bankCard_icon);
            bankCard_Name = itemView.findViewById(R.id.bankCard_Name);
            bankCard_type = itemView.findViewById(R.id.bankCard_type);
            bankCard_id = itemView.findViewById(R.id.bankCard_id);
            bankCard_one = itemView.findViewById(R.id.bankCard_one);

        }
    }

    public interface OnItemClickListener {

        void onSelectClick(View view, int pos);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
