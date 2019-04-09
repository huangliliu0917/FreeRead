package com.yinglan.FreeRead.Fragments;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.yinglan.FreeRead.Activitys.Activity_AboutUs;
import com.yinglan.FreeRead.Activitys.Activity_AskQuestion;
import com.yinglan.FreeRead.Activitys.Activity_News;
import com.yinglan.FreeRead.Activitys.Activity_NormalQuestion;
import com.yinglan.FreeRead.Activitys.Activity_OnlineHelper;
import com.yinglan.FreeRead.Activitys.Activity_Setting;
import com.yinglan.FreeRead.Activitys.Activity_TiXian;
import com.yinglan.FreeRead.Base.QuBase;
import com.yinglan.FreeRead.Constant.HttpConnect;
import com.yinglan.FreeRead.Constant.HttpConstant;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
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
public class Fragment_Home_personal extends BaseFragment {

    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.btn_person_xiaoxi)
    ImageView btnPersonXiaoxi;
    @BindView(R.id.btn_person_kefu)
    ImageView btnPersonKefu;
    @BindView(R.id.btn_person_setting)
    ImageView btnPersonSetting;
    @BindView(R.id.person_inviteMakeMoney)
    LinearLayout personInviteMakeMoney;
    @BindView(R.id.person_tixian)
    LinearLayout personTixian;
    @BindView(R.id.person_normalProblem)
    LinearLayout personNormalProblem;
    @BindView(R.id.person_askQuestion)
    LinearLayout personAskQuestion;
    @BindView(R.id.person_about)
    LinearLayout personAbout;
    Unbinder unbinder;
    @BindView(R.id.souhu_dayInput)
    TextView souhuDayInput;
    @BindView(R.id.souhu_totalInput)
    TextView souhuTotalInput;
    @BindView(R.id.souhu_readSeconds)
    TextView souhuReadSeconds;
    @BindView(R.id.tao_dayInput)
    TextView taoDayInput;
    @BindView(R.id.tao_totalInput)
    TextView taoTotalInput;
    @BindView(R.id.tao_readSeconds)
    TextView taoReadSeconds;
    @BindView(R.id.qu_dayInput)
    TextView quDayInput;
    @BindView(R.id.qu_totalInput)
    TextView quTotalInput;
    @BindView(R.id.qu_readSeconds)
    TextView quReadSeconds;
    private String mTitle = "DefaultValue";
    private View view;
    private Context context;
    private Intent intent;
    /*懒加载处理*/
    private boolean mHasLoadedOnce = false;
    private boolean isPrepared = false;

    boolean running = false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case 1:

                    QuBase quBase = (QuBase) msg.getData().getSerializable("quBase");
                    writeToIncomeRecord(quBase);

                    break;
            }
        }
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_personal, null);
        unbinder = ButterKnife.bind(this, view);
        intent = new Intent();
        context = getContext();

        isPrepared = true;
//        lazyLoad();
        initNet();

//        if (MyApplication.sharedPreferences.getBoolean("isStartRead",false)){
//
            running = true;
            selectData();

//        }



        return view;
    }

    public void initNet() {

        Map<String, String> params = new HashMap<>();
        params.put("userId", MyApplication.sharedPreferences.getString("user_id", ""));

        HttpConnect.getProfileIncomeOfMediaPlatform(context, params, handler);
    }



    @OnClick({R.id.btn_person_xiaoxi, R.id.btn_person_kefu, R.id.btn_person_setting, R.id.person_inviteMakeMoney, R.id.person_tixian, R.id.person_normalProblem, R.id.person_askQuestion, R.id.person_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_person_xiaoxi:
                intent.setClass(getContext(), Activity_News.class);
                startActivity(intent);
                break;
            case R.id.btn_person_kefu:
                intent.setClass(getContext(), Activity_OnlineHelper.class);
                startActivity(intent);
                break;
            case R.id.btn_person_setting:
                intent.setClass(getContext(), Activity_Setting.class);
                startActivity(intent);
                break;
            case R.id.person_inviteMakeMoney:
                break;
            case R.id.person_tixian:
                intent.setClass(getContext(), Activity_TiXian.class);
                startActivity(intent);
                break;
            case R.id.person_normalProblem:
                intent.setClass(getContext(), Activity_NormalQuestion.class);
                startActivity(intent);
                break;
            case R.id.person_askQuestion:
                intent.setClass(getContext(), Activity_AskQuestion.class);
                startActivity(intent);
                break;
            case R.id.person_about:
                intent.setClass(getContext(), Activity_AboutUs.class);
                startActivity(intent);
                break;
        }
    }


    public void selectData(){

        new Thread() {
            @Override
            public void run() {
                while (running) {

                    int dayInput = MyApplication.sharedPreferences.getInt("qu_dayInput",0);
                    int totalInput = MyApplication.sharedPreferences.getInt("qu_totalInput",0);
                    int readSeconds = MyApplication.sharedPreferences.getInt("qu_readSeconds",0);


                    QuBase quBase = new QuBase();
                    quBase.setDayInput(dayInput);
                    quBase.setTotalInput(totalInput);
                    quBase.setReadSeconds(readSeconds);

//                    quDayInput.setText(String.valueOf(quBase.getDayInput()));
//                    quTotalInput.setText(String.valueOf(quBase.getTotalInput()));
//                    quReadSeconds.setText(String.valueOf(quBase.getReadSeconds()));

                    Message message = new Message();
                    message.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("quBase",quBase);
                    message.setData(bundle);
                    handler.sendMessage(message);


//                    showResponse(quBase);

//                    writeToIncomeRecord(context,quBase);

                    Log.d("TAG","开始向桌面添加数据");

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
                        quDayInput.setText(String.valueOf(quBase.getDayInput()));
                        quTotalInput.setText(String.valueOf(quBase.getTotalInput()));
                        quReadSeconds.setText(String.valueOf(quBase.getReadSeconds()));
                    }
                }catch(NullPointerException exception){
                    exception.printStackTrace();
                }

            }
        });
    }


    /**
     * 写入趣头条收益
     * @param quBase
     */
    public void writeToIncomeRecord(final QuBase quBase) {


        Map<String, String> params = new HashMap<>();
        params.put("PlatformName", "趣头条");
        params.put("PlatformId", "1");
        params.put("IncomeAmount", String.valueOf(quBase.getDayInput()));
        params.put("UserId", MyApplication.sharedPreferences.getString("user_id", ""));


        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("写入数据请求的地址：----->" + HttpConstant.writeTolnComeRecord + postDataInfo);

        MyOkHttp.get().post(context, HttpConstant.writeTolnComeRecord, postDataInfo, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {


                try {
                    if (response.getInt("code") == 200) {
                        LogUtils.d("写入收益成功--------》" + response.getString("msg"));
                        showResponse(quBase);

                    } else {
                        LogUtils.d("写入收益失败--------》" + response.getString("msg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                LogUtils.d("写入收益失败--------》" + error_msg);
//                selectQuCallback.onDataChange(quBase);
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
