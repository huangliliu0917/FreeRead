package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.Constant.HttpConnect;
import com.yinglan.FreeRead.Imp.MakeActivityDoSomething;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.MutiProgress;
import com.yinglan.FreeRead.Utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_QianDao extends AppCompatActivity{
    @BindView(R.id.qiandao_titleBar)
    TitleBar qiandaoTitleBar;
    @BindView(R.id.qiandao_integral)
    TextView qiandaoIntegral;
    @BindView(R.id.qiandao_alreadySignIn)
    TextView qiandaoAlreadySignIn;
    @BindView(R.id.rsv_small)
    MutiProgress rsvSmall;
    @BindView(R.id.qiandao_lookTashHistory)
    TextView qiandaoLookTashHistory;
    @BindView(R.id.qiandao_recycler)
    RecyclerView qiandaoRecycler;
    @BindView(R.id.qiandao_btn)
    LinearLayout qiandaoBtn;
    @BindView(R.id.qiandao_btn_bg)
    LinearLayout qiandaoBtnBg;
    private Context context;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                    //刷新签到界面
                case 1:
                    checkIsSign();
                    break;
                    //刷新签到界面数据
                case 2:
                    qiandaoAlreadySignIn.setText(MyApplication.sharedPreferences.getString("user_SeriesSignDays","")+"天");
                    break;
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__qian_dao);
        ButterKnife.bind(this);
        context = getApplicationContext();

        initView();

        checkIsSign();

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


    //判断用户是否已经签到
    public void checkIsSign(){

        if (MyApplication.sharedPreferences.getBoolean("user_IsSign", false)) {
            qiandaoBtnBg.setVisibility(View.GONE);
        } else {
            qiandaoBtnBg.setVisibility(View.VISIBLE);
        }
    }

    public void initNet_Qiandao() {
        ToastUtils.showShort(context,"签到");

        Map<String, String> params = new HashMap<>();
        params.put("userId", MyApplication.sharedPreferences.getString("user_id", ""));
        HttpConnect.signIn(context, params, handler);
    }

    @OnClick({R.id.qiandao_lookTashHistory, R.id.qiandao_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qiandao_lookTashHistory:
                break;
            case R.id.qiandao_btn:
                initNet_Qiandao();
                break;
        }
    }
}
