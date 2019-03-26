package com.yinglan.FreeRead.Activitys;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.Adapters.Adapter_selectBankCard;
import com.yinglan.FreeRead.Base.CardBean;
import com.yinglan.FreeRead.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_TiXian extends AppCompatActivity implements View.OnClickListener, Adapter_selectBankCard.OnItemClickListener {

    @BindView(R.id.TiXian_titleBar)
    TitleBar TiXianTitleBar;
    @BindView(R.id.tixian_CanTiXianNum)
    TextView tixianCanTiXianNum;
    @BindView(R.id.tixian_WantTiXianNum)
    EditText tixianWantTiXianNum;
    @BindView(R.id.tixian_toBank)
    TextView tixianToBank;
    @BindView(R.id.tixian_selectBank)
    LinearLayout tixianSelectBank;
    @BindView(R.id.tixian_commit)
    TextView tixianCommit;
    @BindView(R.id.tixian_main)
    RelativeLayout tixianMain;


    private PopupWindow popCard;
    private Adapter_selectBankCard adapter;
    private View view;
    private List<CardBean> cardBeans;
    private int tag = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ti_xian);
        ButterKnife.bind(this);
        initView();

        initData();

        initPopView();

    }

    public void initView() {
        TiXianTitleBar.setTitle("提现");
        TiXianTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        TiXianTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        TiXianTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        TiXianTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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


    public void initData() {
        adapter = new Adapter_selectBankCard(getApplicationContext());
        adapter.setOnItemClickListener(this);

        cardBeans = new ArrayList<>();


        cardBeans.add(new CardBean(this.getResources().getDrawable(R.mipmap.icon_zhaoshangyinhang),"储蓄卡","招商银行","545441515854351658343"));
        cardBeans.add(new CardBean(this.getResources().getDrawable(R.mipmap.icon_zhaoshangyinhang),"金卡","农业银行","545441515854351658343"));
        cardBeans.add(new CardBean(this.getResources().getDrawable(R.mipmap.icon_zhaoshangyinhang),"银卡","招商银行","545441515854351658343"));
        cardBeans.add(new CardBean(this.getResources().getDrawable(R.mipmap.icon_zhaoshangyinhang),"储蓄卡","建设银行","545441515854351658343"));
        cardBeans.add(new CardBean(this.getResources().getDrawable(R.mipmap.icon_zhaoshangyinhang),"储蓄卡","中国银行","545441515854351658343"));
        cardBeans.add(new CardBean(this.getResources().getDrawable(R.mipmap.icon_zhaoshangyinhang),"储蓄卡","人民银行","545441515854351658343"));

    }

    private void initPopView() {
        view = getLayoutInflater().inflate(R.layout.select_bankcard, null, false);
        FrameLayout flPop = view.findViewById(R.id.fl_pop);
        RecyclerView rlvPop = view.findViewById(R.id.rlv_pop);

        rlvPop.setLayoutManager(new LinearLayoutManager(this));
        rlvPop.setAdapter(adapter);
        flPop.setOnClickListener(this);
    }

    private void showPop() {
        if (popCard == null) {
            popCard = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        }
        popCard.setBackgroundDrawable(new ColorDrawable());
        popCard.showAtLocation(tixianMain, Gravity.CENTER, 0, 0);
        adapter.setData(cardBeans);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(this);
    }


    @OnClick({R.id.tixian_selectBank, R.id.tixian_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tixian_selectBank:
                showPop();
                break;
            case R.id.tixian_commit:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_pop:
                popCard.dismiss();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (popCard != null) {
            popCard.dismiss();
        }
    }

    @Override
    public void onSelectClick(View view, int pos) {
        Toast.makeText(this, "选择第 " + (pos + 1) + " 条数据成功", Toast.LENGTH_LONG).show();
        popCard.dismiss();
    }

}
