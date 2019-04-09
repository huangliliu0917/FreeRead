package com.yinglan.FreeRead.Fragments;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;
import com.yinglan.FreeRead.Activitys.Activity_Home_NewsInfo;
import com.yinglan.FreeRead.Activitys.Activity_QianDao;
import com.yinglan.FreeRead.Activitys.Activity_Task;
import com.yinglan.FreeRead.Activitys.Activity_TaskInfo;
import com.yinglan.FreeRead.Activitys.Activity_TiXian;
import com.yinglan.FreeRead.Activitys.MainActivity;
import com.yinglan.FreeRead.Base.QuBase;
import com.yinglan.FreeRead.Imp.OnPagerSelectLister;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.CheckSoftWare;
import com.yinglan.FreeRead.Utils.NoScrollViewPager;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by ${AUTHOR} on 2019/3/23 0023
 * Function: ${Function}
 */
@SuppressLint("ValidFragment")
public class Fragment_Home_makeMoney extends BaseFragment {

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
    private Intent intent;
    private NoScrollViewPager mViewPager;
    private Context context;

    /*懒加载处理*/
    private boolean mHasLoadedOnce = false;
    private boolean isPrepared = false;

    boolean running = false;
    SharedPreferences.Editor editor;
    /*趣头条*/
    int qu_dayInput = 0;//今日收益
    int qu_totalInput = 0;//总收益
    int qu_readSeconds = 0;//今日阅读（秒）


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){

                //自动赚钱服务正在开启
                case 1:
                    btnHomeStartMakeMoney.setText("服务开启中。。。");
                    btnHomeStartMakeMoney.setTextColor(getResources().getColor(R.color.colorWhite));
                    btnHomeStartMakeMoney.setClickable(false);
                    break;

                //自动赚钱服务开启失败
                case 2:
                    btnHomeStartMakeMoney.setClickable(true);
                    Toast.makeText(context,"服务开启失败",Toast.LENGTH_SHORT).show();
                    break;

                //自动赚钱服务正在成功
                case 3:

                    running = true;
                    MakeData();
                    btnHomeStartMakeMoney.setText("已开启自动赚钱");
                    btnHomeStartMakeMoney.setBackgroundColor(getResources().getColor(R.color.colorGray1));
                    btnHomeStartMakeMoney.setTextColor(getResources().getColor(R.color.colorWhite));
                    btnHomeStartMakeMoney.setClickable(false);

                    MyApplication.editor.putBoolean("isStartRead",true);
                    MyApplication.editor.commit();

                    break;
            }
        }
    };


    @SuppressLint("ValidFragment")
    public Fragment_Home_makeMoney(NoScrollViewPager mViewPager){
        this.mViewPager = mViewPager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home_make_money, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        isPrepared = true;
//        lazyLoad();

        if (MyApplication.sharedPreferences.getBoolean("isStartRead",false)){
            handler.sendEmptyMessage(3);
        }

        return view;
    }

    @OnClick({R.id.btn_home_makeMoney_tixian, R.id.btn_home_startMakeMoney, R.id.btn_home_qiandao, R.id.btn_home_lingjiangli, R.id.btn_home_yueduzhuanqian, R.id.btn_home_yaoqingzhuanqian, R.id.btn_home_weixinduokai, R.id.btn_home_qianghongbao, R.id.btn_home_kuaisutixian, R.id.btn_home_jinrushangcheng})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            /*进入提现页面*/
            case R.id.btn_home_makeMoney_tixian:
//                Toast.makeText(getActivity(),"提现",Toast.LENGTH_SHORT).show();

                break;

            /*开始赚钱*/
            case R.id.btn_home_startMakeMoney:

//                if (CheckSoftWare.isAvilible(context,"com.coohua.xinwenzhuan") &&
//                        CheckSoftWare.isAvilible(context,"com.jifen.qukan") &&
//                        CheckSoftWare.isAvilible(context,"com.sohu.infonews")){



                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            handler.sendEmptyMessage(1);

//                            Intent intent = new Intent(context,StartMakeMoney.class);
//                            context.startService(intent);
//                            MyApplication.editor.putBoolean("isStartRead",true);
//                            MyApplication.editor.commit();

                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            handler.sendEmptyMessage(2);
                            e.printStackTrace();
                        }

                        handler.sendEmptyMessage(3);

                    }
                }).start();

//                }else{
//                    final NormalDialog normalDialog = new NormalDialog(context);
//                    normalDialog.isTitleShow(false)//
//                            .bgColor(Color.parseColor("#ffffff"))//
//                            .btnNum(1)
//                            .btnText("确定")
//                            .btnTextColor(getResources().getColor(R.color.colorGray))
//                            .cornerRadius(5)//
//                            .content("本机暂未安装阅读类软件，请前往应用商城下载")//
//                            .contentGravity(Gravity.CENTER)//
//                            .contentTextColor(Color.parseColor("#454545"))//
//                            .dividerColor(Color.parseColor("#222222"))//
//                            .btnTextSize(15.5f, 15.5f)//
//                            .btnTextColor(Color.parseColor("#3b9cf2"), Color.parseColor("#3b9cf2"))//
//                            .widthScale(0.85f)//
//                            .show();
//
//                    normalDialog.setOnBtnClickL(
//                            new OnBtnClickL() {
//                                @Override
//                                public void onBtnClick() {
//                                    normalDialog.dismiss();
//                                }
//                            });
//                }

                break;

            /*进入签到页面*/
            case R.id.btn_home_qiandao:
                intent = new Intent();
                intent.setClass(getContext(),Activity_QianDao.class);
                startActivity(intent);
//                Toast.makeText(getContext(),"签到",Toast.LENGTH_SHORT).show();
                break;

            /*进入领任务页面*/
            case R.id.btn_home_lingjiangli:
                intent = new Intent();
                intent.setClass(getContext(),Activity_Task.class);
                startActivity(intent);
//                Toast.makeText(getContext(),"领任务",Toast.LENGTH_SHORT).show();
                break;

            /*进入新闻阅读页面*/
            case R.id.btn_home_yueduzhuanqian:
                mViewPager.setCurrentItem(1);
//                Toast.makeText(getContext(),"阅读赚钱",Toast.LENGTH_SHORT).show();
                break;

            /*进入分享页面*/
            case R.id.btn_home_yaoqingzhuanqian:
                Toast.makeText(getContext(),"邀请赚钱",Toast.LENGTH_SHORT).show();
                break;

            /*进入微信助手页面*/
            case R.id.btn_home_weixinduokai:
                mViewPager.setCurrentItem(2);
//                Toast.makeText(getContext(),"微信多开",Toast.LENGTH_SHORT).show();
                break;


            case R.id.btn_home_qianghongbao:
                Toast.makeText(getContext(),"抢红包",Toast.LENGTH_SHORT).show();
                break;


                /*进入提现页面*/
            case R.id.btn_home_kuaisutixian:
                intent = new Intent();
                intent.setClass(getContext(),Activity_TiXian.class);
                startActivity(intent);
//                Toast.makeText(getContext(),"快速提现",Toast.LENGTH_SHORT).show();
                break;


                /*进入商城页面*/
            case R.id.btn_home_jinrushangcheng:
                Toast.makeText(getContext(),"商城",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void MakeData(){

        new Thread() {
            @Override
            public void run() {
                while (running) {

                    Random random = new Random();
                    editor = MyApplication.editor;

                    qu_dayInput = random.nextInt(10)+1;
                    qu_totalInput = random.nextInt(10)+1;
                    qu_readSeconds = random.nextInt(1000)+1;

                    int dayInput = MyApplication.sharedPreferences.getInt("qu_dayInput",0);
                    int totalInput = MyApplication.sharedPreferences.getInt("qu_totalInput",0);
                    int readSeconds = MyApplication.sharedPreferences.getInt("qu_readSeconds",0);

                    editor.putInt("qu_dayInput",dayInput+1);
                    editor.putInt("qu_totalInput",totalInput+1);
                    editor.putInt("qu_readSeconds",qu_readSeconds+(readSeconds%100));

                    editor.commit();

                    QuBase quBase = new QuBase();
                    quBase.setDayInput(qu_dayInput+dayInput);
                    quBase.setTotalInput(qu_totalInput+qu_dayInput+totalInput);
                    quBase.setReadSeconds(qu_readSeconds+readSeconds);
                    showResponse(quBase);

                    Log.d("TAG","开始生成数据");

                    SystemClock.sleep(30000);
                }
            }
        }.start();


    }


    public void showResponse(final QuBase quBase){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                try{
                    if (quBase != null){
                        homeInputMoneyToday.setText(String.valueOf(quBase.getDayInput()));
                        homeInputMoneyAll.setText(String.valueOf(quBase.getTotalInput()));
                    }
                }catch(NullPointerException exception){
                    exception.printStackTrace();
                }

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mHasLoadedOnce = false;
        isPrepared = false;
    }

    @Override
    protected void lazyLoad() {
        if (mHasLoadedOnce || !isPrepared)
            return;
        mHasLoadedOnce = true;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
    }



}
