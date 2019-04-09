package com.yinglan.FreeRead.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;

import com.flyco.dialog.listener.OnBtnClickL;
import com.google.gson.Gson;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.yinglan.FreeRead.Activitys.Activity_Login;
import com.yinglan.FreeRead.Activitys.Activity_Register;
import com.yinglan.FreeRead.Activitys.MainActivity;
import com.yinglan.FreeRead.Adapters.Adapter_Fragment_Read;
import com.yinglan.FreeRead.Adapters.Adapter_UserTask;
import com.yinglan.FreeRead.Base.ArticlePagerNewsBean;
import com.yinglan.FreeRead.Base.BaseBean;
import com.yinglan.FreeRead.Base.CategoryBean;
import com.yinglan.FreeRead.Base.QuBase;
import com.yinglan.FreeRead.Base.UserLoginBean;
import com.yinglan.FreeRead.Base.UserTaskBean;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.Fragments.Fragment_Home_personal;
import com.yinglan.FreeRead.Imp.DataRefresh;
import com.yinglan.FreeRead.Imp.MakeActivityDoSomething;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.Utils.BitmapUtils;
import com.yinglan.FreeRead.Utils.LogUtils;
import com.yinglan.FreeRead.Utils.MyActivityManager;
import com.yinglan.FreeRead.Utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${AUTHOR} on 2019/3/30 0030
 * Function: 调用网络接口
 */
public class HttpConnect {

    private static Intent intent;


    /**
     * 接口测试
     *
     * @param context
     */
    public static void test1(Context context, Map<String, String> params) {

        LogUtils.d("测试请求的地址：----->" + HttpConstant.test);

        MyOkHttp.get().get1(context, HttpConstant.test, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {
                LogUtils.d("测试顺畅：----->" + response);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                LogUtils.d("测试受阻：----->" + error_msg);
            }
        });
    }


    /**
     * 用户注册
     *
     * @param params 用户注册基本信息
     * @return
     */
    public static void register(final Context context, Map<String, String> params, final MakeActivityDoSomething makeActivityDoSomething) {

        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.register + postDataInfo);

        MyOkHttp.get().post(context, HttpConstant.register, postDataInfo, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("用户注册成功--------》" + response.toString());

                try {
                    int code = response.getInt("code");
                    String msg = response.getString("msg");
                    if (code == 200) {
                        intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                        makeActivityDoSomething.doFinish();

//                        MyActivityManager.getAppManager().finishActivity(Activity_Login.class);
//                        MyActivityManager.getAppManager().finishActivity((Activity) context);


                    } else {
                        ToastUtils.showShort(context, msg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });

    }


    /**
     * 忘记密码
     *
     * @param context
     * @param params
     * @param makeActivityDoSomething
     */
    public static void forgetPassword(final Context context, Map<String, String> params, final MakeActivityDoSomething makeActivityDoSomething) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.forgetPassword + postDataInfo);

        MyOkHttp.get().post(context, HttpConstant.forgetPassword, postDataInfo, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("用户注册成功--------》" + response.toString());

                try {
                    int code = response.getInt("code");
                    String msg = response.getString("msg");
                    if (code == 200) {
                        ToastUtils.showShort(context, msg);
                        makeActivityDoSomething.doFinish();
                    } else {
                        ToastUtils.showShort(context, msg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 账号密码登录
     *
     * @param context
     * @param params
     * @param makeActivityDoSomething
     */
    public static void loginWithPassword(final Context context, Map<String, String> params, final MakeActivityDoSomething makeActivityDoSomething) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.forgetPassword + postDataInfo);


        MyOkHttp.get().post(context, HttpConstant.login_with_password, postDataInfo, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("用户密码登录成功--------》" + response.toString());

                UserLoginBean userLoginBean;

                try {
                    int code = response.getInt("code");
                    String msg = response.getString("msg");

                    userLoginBean = new Gson().fromJson(response.toString(), UserLoginBean.class);

                    if (userLoginBean.getCode() == 200 && userLoginBean.getUser() != null) {

                        MyApplication.editor.putString("user_id", String.valueOf(userLoginBean.getUser().getUserId()));
                        MyApplication.editor.putString("user_NickName", userLoginBean.getUser().getNickName());
                        MyApplication.editor.putString("user_Avatar", userLoginBean.getUser().getAvatar());
                        MyApplication.editor.putString("user_FullName", userLoginBean.getUser().getFullName());
                        MyApplication.editor.putString("user_PhoneNumber", userLoginBean.getUser().getPhoneNumber());
                        MyApplication.editor.putString("user_Email", userLoginBean.getUser().getEmail());
                        MyApplication.editor.putString("user_PassWord", userLoginBean.getUser().getPassword());
                        MyApplication.editor.putString("user_Balance", String.valueOf(userLoginBean.getUser().getBalance()));
                        MyApplication.editor.putBoolean("user_IsSign", userLoginBean.getSign().getisIsSign());
                        MyApplication.editor.putString("user_SeriesSignDays", String.valueOf(userLoginBean.getSign().getSeriesSignDays()));
                        MyApplication.editor.putString("user_TotalSignDays", String.valueOf(userLoginBean.getSign().getTotalSignDays()));
                        MyApplication.editor.putBoolean("user_Logined", true);
                        MyApplication.editor.putInt("qu_dayInput", 0);//趣头条——今日收益
                        MyApplication.editor.putInt("qu_totalInput", 0);//趣头条——总收益
                        MyApplication.editor.putInt("qu_readSeconds", 0);//趣头条——今日阅读时间
                        MyApplication.editor.putBoolean("isStartRead", false);//是否开启自动赚钱
                        MyApplication.editor.apply();
                        MyApplication.editor.commit();

                        intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                        makeActivityDoSomething.doFinish();
                    } else {
                        ToastUtils.showShort(context, userLoginBean.getMsg());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 验证码登录
     *
     * @param context
     * @param params
     * @param makeActivityDoSomething
     */
    public static void loginWithSMS(final Context context, Map<String, String> params, final MakeActivityDoSomething makeActivityDoSomething) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.forgetPassword + postDataInfo);

        MyOkHttp.get().post(context, HttpConstant.login_with_SMS, postDataInfo, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("用户验证码登录成功--------》" + response.toString());

                UserLoginBean userLoginBean;

                try {

                    userLoginBean = new Gson().fromJson(response.toString(), UserLoginBean.class);

                    if (userLoginBean.getCode() == 200) {

                        if (userLoginBean.getUser().getUserId() <= 0) {

                            ToastUtils.showShort(context, "您暂未注册该应用，请先进行注册");

                            intent = new Intent(context, Activity_Register.class);
                            context.startActivity(intent);

                        } else {
                            MyApplication.editor.putString("user_id", String.valueOf(userLoginBean.getUser().getUserId()));
                            MyApplication.editor.putString("user_NickName", userLoginBean.getUser().getNickName());
                            MyApplication.editor.putString("user_Avatar", userLoginBean.getUser().getAvatar());
                            MyApplication.editor.putString("user_FullName", userLoginBean.getUser().getFullName());
                            MyApplication.editor.putString("user_PhoneNumber", userLoginBean.getUser().getPhoneNumber());
                            MyApplication.editor.putString("user_Email", userLoginBean.getUser().getEmail());
                            MyApplication.editor.putString("user_PassWord", userLoginBean.getUser().getPassword());
                            MyApplication.editor.putString("user_Balance", String.valueOf(userLoginBean.getUser().getBalance()));
                            MyApplication.editor.putBoolean("user_IsSign", userLoginBean.getSign().getisIsSign());
                            MyApplication.editor.putString("user_SeriesSignDays", String.valueOf(userLoginBean.getSign().getSeriesSignDays()));
                            MyApplication.editor.putString("user_TotalSignDays", String.valueOf(userLoginBean.getSign().getTotalSignDays()));
                            MyApplication.editor.putBoolean("user_Logined", true);
                            MyApplication.editor.putInt("qu_dayInput", 0);//趣头条——今日收益
                            MyApplication.editor.putInt("qu_totalInput", 0);//趣头条——总收益
                            MyApplication.editor.putInt("qu_readSeconds", 0);//趣头条——今日阅读时间
                            MyApplication.editor.putBoolean("isStartRead", false);//是否开启自动赚钱
                            MyApplication.editor.apply();
                            MyApplication.editor.commit();

                            intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                            makeActivityDoSomething.doFinish();
                        }

                    } else {
                        ToastUtils.showShort(context, userLoginBean.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 用户签到
     *
     * @param context
     * @param params
     */
    public static void signIn(final Context context, Map<String, String> params, final Handler handler) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.signIn + postDataInfo);

        MyOkHttp.get().post(context, HttpConstant.signIn, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                BaseBean baseBean;

                try {
                    baseBean = new Gson().fromJson(String.valueOf(response), BaseBean.class);
                    if (baseBean.getCode() == 200) {
                        MyApplication.sharedPreferences.edit().putBoolean("user_IsSign", true);
                        handler.sendEmptyMessage(1);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                LogUtils.d("用户签到成功--------》" + response.toString());

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 用户正在执行的任务
     *
     * @param context
     * @param params
     * @param qiandaoRecycler
     */
    public static void getTaskListOfStarting(final Context context, Map<String, String> params, final RecyclerView qiandaoRecycler, final Handler handler) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.getTaskListOfStarting + postDataInfo);

        MyOkHttp.get().get(context, HttpConstant.getTaskListOfStarting, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("用户任务记录查询成功--------》" + response.toString());

                UserTaskBean userTaskBean;

                try {

                    userTaskBean = new Gson().fromJson(response.toString(), UserTaskBean.class);

                    if (userTaskBean.getCode() == 200) {
                        Message message = new Message();
                        message.what = 2;
                        Bundle bundle = new Bundle();
                        bundle.putString("taskedcount", String.valueOf(userTaskBean.getTaskedcount()));
                        bundle.putString("totalincome", String.valueOf(userTaskBean.getTotalincome()));
                        message.setData(bundle);
                        handler.sendMessage(message);

                        if (userTaskBean.getList().size() > 0) {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                            Adapter_UserTask adapter_userTask = new Adapter_UserTask(context, userTaskBean, handler);

                            qiandaoRecycler.setLayoutManager(linearLayoutManager);
                            qiandaoRecycler.setAdapter(adapter_userTask);

                        } else {
                            ToastUtils.showShort(context, "当前暂无任务");
                        }

                    } else {
                        ToastUtils.showShort(context, userTaskBean.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 领取任务
     *
     * @param context
     * @param params
     */
    public static void drawTask(final Context context, Map<String, String> params) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.signIn + postDataInfo);

        MyOkHttp.get().post(context, HttpConstant.drawTask, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("用户领取任务成功--------》" + response.toString());

                BaseBean baseBean;

                try {

                    baseBean = new Gson().fromJson(response.toString(), BaseBean.class);

                    if (baseBean.getCode() == 200) {

                        ToastUtils.showShort(context, baseBean.getMsg());

                    } else {
                        ToastUtils.showShort(context, baseBean.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 新闻栏目
     *
     * @param context
     * @param params
     */
    public static void allNewsCategory(final Context context, Map<String, String> params, final Handler handler) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.allNewsCategory + postDataInfo);

        MyOkHttp.get().get(context, HttpConstant.allNewsCategory, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("新闻栏目查询成功--------》" + response.toString());

                CategoryBean categoryBean;

                try {

                    categoryBean = new Gson().fromJson(response.toString(), CategoryBean.class);

                    if (categoryBean.getCode() == 200) {

                        Message message = new Message();
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("allCategory", categoryBean);
                        message.setData(bundle);
                        handler.sendMessage(message);

                    } else {
                        ToastUtils.showShort(context, categoryBean.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 新闻单个栏目内容加载
     *
     * @param context
     * @param params
     */
    public static void readNewsArticlePager(final Context context, Map<String, String> params, final Handler handler, final RecyclerView recyclerView) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.readNewsArticlePager + postDataInfo);

        MyOkHttp.get().post(context, HttpConstant.readNewsArticlePager, postDataInfo, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("单个新闻栏目查询成功--------》" + response.toString());


                ArticlePagerNewsBean articlePagerNewsBean;

                try {
                    articlePagerNewsBean = new Gson().fromJson(response.toString(), ArticlePagerNewsBean.class);
                    if (articlePagerNewsBean.getCode() == 200) {

                        if (articlePagerNewsBean.getList().size() > 0) {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            Adapter_Fragment_Read adapter_fragment_read = new Adapter_Fragment_Read(context, (ArticlePagerNewsBean) articlePagerNewsBean);
                            recyclerView.setAdapter(adapter_fragment_read);
                        } else {
                            ToastUtils.showShort(context, "暂无数据");
                        }

                    } else {
                        ToastUtils.showShort(context, articlePagerNewsBean.getMsg());
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

//                try {
//
//                    categoryBean = new Gson().fromJson(response.toString(),CategoryBean.class);
//
//                    if (categoryBean.getCode() == 200){
//
//                        Message message = new Message();
//                        message.what = 1;
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable("allCategory",categoryBean);
//                        message.setData(bundle);
//                        handler.sendMessage(message);
//
//                    }else{
//                        ToastUtils.showShort(context,categoryBean.getMsg());
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 各平台收益
     *
     * @param context
     * @param params
     */
    public static void getProfileIncomeOfMediaPlatform(final Context context, Map<String, String> params, final Handler handler) {
        String postDataInfo = new Gson().toJson(params);

        LogUtils.d("请求的地址：----->" + HttpConstant.readNewsArticlePager + postDataInfo);

        MyOkHttp.get().get(context, HttpConstant.getProfileIncomeOfMediaPlatform, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {

                LogUtils.d("各平台收益查询成功--------》" + response.toString());

            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                ToastUtils.showShort(context, error_msg);
            }
        });
    }


    /**
     * 写入趣头条收益
     *
     * @param context
     * @param quBase
     */
    public static void writeToIncomeRecord(final Context context, final QuBase quBase) {


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
//                        if (callback != null) {
//                            callback.onDataChange(quBase);//返回查询的数据
//                        }

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

}
