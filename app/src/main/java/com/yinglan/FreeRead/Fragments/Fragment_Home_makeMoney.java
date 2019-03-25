package com.yinglan.FreeRead.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.yinglan.FreeRead.Activitys.Activity_Home_NewsInfo;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ${AUTHOR} on 2019/3/23 0023
 * Function: ${Function}
 */
public class Fragment_Home_makeMoney extends Fragment {

    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.btn_home_makeMoney_tixian)
    TextView btnHomeMakeMoneyTixian;//提现
    @BindView(R.id.home_login_sates)
    TextView homeLoginSates;//登录状态
    @BindView(R.id.home_inputMoney_today)
    TextView homeInputMoneyToday;//今日收益
    @BindView(R.id.home_inputMoney_all)
    TextView homeInputMoneyAll;//累计收益
    @BindView(R.id.btn_home_startMakeMoney)
    TextView btnHomeStartMakeMoney;//开始赚钱
    @BindView(R.id.btn_home_qiandao)
    RadioButton btnHomeQiandao;//签到
    @BindView(R.id.btn_home_lingjiangli)
    RadioButton btnHomeLingjiangli;//领奖励
    @BindView(R.id.btn_home_yueduzhuanqian)
    RadioButton btnHomeYueduzhuanqian;//阅读赚钱
    @BindView(R.id.btn_home_yaoqingzhuanqian)
    RadioButton btnHomeYaoqingzhuanqian;//邀请赚钱
    @BindView(R.id.btn_home_weixinduokai)
    RadioButton btnHomeWeixinduokai;//微信多开
    @BindView(R.id.btn_home_qianghongbao)
    RadioButton btnHomeQianghongbao;//抢红包
    @BindView(R.id.btn_home_kuaisutixian)
    RadioButton btnHomeKuaisutixian;//快速提现
    @BindView(R.id.btn_home_jinrushangcheng)
    RadioButton btnHomeJinrushangcheng;//进入商城

    private View view;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home_make_money, null);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.btn_home_makeMoney_tixian, R.id.btn_home_startMakeMoney, R.id.btn_home_qiandao, R.id.btn_home_lingjiangli, R.id.btn_home_yueduzhuanqian, R.id.btn_home_yaoqingzhuanqian, R.id.btn_home_weixinduokai, R.id.btn_home_qianghongbao, R.id.btn_home_kuaisutixian, R.id.btn_home_jinrushangcheng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_home_makeMoney_tixian:
//                Toast.makeText(getActivity(),"提现",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(getContext(),Activity_Home_NewsInfo.class);
                startActivity(intent);

                break;
            case R.id.btn_home_startMakeMoney:
                Toast.makeText(getContext(),"开始赚钱",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_home_qiandao:
                Toast.makeText(getContext(),"签到",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_home_lingjiangli:
                Toast.makeText(getContext(),"领奖励",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_home_yueduzhuanqian:
                Toast.makeText(getContext(),"阅读赚钱",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_home_yaoqingzhuanqian:
                Toast.makeText(getContext(),"邀请赚钱",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_home_weixinduokai:
                Toast.makeText(getContext(),"微信多开",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_home_qianghongbao:
                Toast.makeText(getContext(),"抢红包",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_home_kuaisutixian:
                Toast.makeText(getContext(),"快速提现",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_home_jinrushangcheng:
                Toast.makeText(getContext(),"进入商城",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
