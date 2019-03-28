package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.channguyen.rsv.RangeSliderView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_QianDao extends AppCompatActivity {

    @BindView(R.id.qiandao_titleBar)
    TitleBar qiandaoTitleBar;
    @BindView(R.id.qiandao_integral)
    TextView qiandaoIntegral;
    @BindView(R.id.qiandao_alreadySignIn)
    TextView qiandaoAlreadySignIn;
    @BindView(R.id.rsv_small)
    RangeSliderView rsvSmall;
    @BindView(R.id.qiandao_lookTashHistory)
    TextView qiandaoLookTashHistory;
    @BindView(R.id.qiandao_zengsong_title)
    TextView qiandaoZengsongTitle;
    @BindView(R.id.qiandao_zengsong_num)
    TextView qiandaoZengsongNum;
    @BindView(R.id.qiandao_zengsong_time)
    TextView qiandaoZengsongTime;
    @BindView(R.id.qiandao_zengsonged_progress)
    ProgressBar qiandaoZengsongedProgress;
    @BindView(R.id.qiandao_zengsonged_shengyu)
    TextView qiandaoZengsongedShengyu;
    @BindView(R.id.btn_qiandao_zengsong_go)
    TextView btnQiandaoZengsongGo;
    @BindView(R.id.qiandao_shouji_title)
    TextView qiandaoShoujiTitle;
    @BindView(R.id.qiandao_shouji_num)
    TextView qiandaoShoujiNum;
    @BindView(R.id.btn_qiandao_shouji_go)
    TextView btnQiandaoShoujiGo;
    @BindView(R.id.qiandao_canyu_title)
    TextView qiandaoCanyuTitle;
    @BindView(R.id.qiandao_canyu_num)
    TextView qiandaoCanyuNum;
    @BindView(R.id.btn_qiandao_canyu_go)
    TextView btnQiandaoCanyuGo;
    @BindView(R.id.qiandao_shoujiWeatherCard_title)
    TextView qiandaoShoujiWeatherCardTitle;
    @BindView(R.id.qiandao_shoujiWeatherCard_num)
    TextView qiandaoShoujiWeatherCardNum;
    @BindView(R.id.btn_qiandao_shoujiWeatherCard_go)
    TextView btnQiandaoShoujiWeatherCardGo;
    @BindView(R.id.qiandao_zengsong)
    LinearLayout qiandaoZengsong;
    @BindView(R.id.qiandao_shouji_dati)
    LinearLayout qiandaoShoujiDati;
    @BindView(R.id.qiandao_canyu)
    LinearLayout qiandaoCanyu;
    @BindView(R.id.qiandao_shouji_WeatherCard)
    LinearLayout qiandaoShoujiWeatherCard;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__qian_dao);
        ButterKnife.bind(this);

        context = getApplicationContext();

        initView();
    }

    @SuppressLint("ResourceAsColor")
    public void initView() {
        qiandaoTitleBar.setTitle("签到");
        qiandaoTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        qiandaoTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        qiandaoTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        qiandaoTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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


    @OnClick({R.id.btn_qiandao_zengsong_go, R.id.btn_qiandao_shouji_go, R.id.btn_qiandao_canyu_go, R.id.btn_qiandao_shoujiWeatherCard_go})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_qiandao_zengsong_go:
                break;
            case R.id.btn_qiandao_shouji_go:
                break;
            case R.id.btn_qiandao_canyu_go:
                break;
            case R.id.btn_qiandao_shoujiWeatherCard_go:
                break;
        }
    }
}
