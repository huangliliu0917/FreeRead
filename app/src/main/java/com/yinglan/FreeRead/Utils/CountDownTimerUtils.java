package com.yinglan.FreeRead.Utils;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.yinglan.FreeRead.Constant.HttpConstant;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.R;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${AUTHOR} on 2019/3/29 0029
 * Function: ${Function}
 */
public class CountDownTimerUtils extends CountDownTimer {

    private Context context;
    private TextView mTextView; //显示倒计时的文字
    private String phoneNum;

    /**
     * @param textView          The TextView
     * @param millisInFuture     millisInFuture  从开始调用start()到倒计时完成
     *                           并onFinish()方法被调用的毫秒数。（译者注：倒计时时间，单位毫秒）
     * @param countDownInterval 接收onTick(long)回调的间隔时间。（译者注：单位毫秒）
     */
    public CountDownTimerUtils(Context context, TextView textView, String phoneNum, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.context = context;
        this.mTextView = textView;
        this.phoneNum = phoneNum;

        sendNote(phoneNum);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击
        mTextView.setText(millisUntilFinished / 1000 + "秒后重新获取");  //设置倒计时时间
        mTextView.setBackgroundResource(R.drawable.shape_button4); //设置按钮为灰色，这时是不能点击的

        /**
         * 超链接 URLSpan
         * 文字背景颜色 BackgroundColorSpan
         * 文字颜色 ForegroundColorSpan
         * 字体大小 AbsoluteSizeSpan
         * 粗体、斜体 StyleSpan
         * 删除线 StrikethroughSpan
         * 下划线 UnderlineSpan
         * 图片 ImageSpan
         * http://blog.csdn.net/ah200614435/article/details/7914459
         */
        SpannableString spannableString = new SpannableString(mTextView.getText().toString());  //获取按钮上的文字
        ForegroundColorSpan span = new ForegroundColorSpan(Color.WHITE);
        /**
         * public void setSpan(Object what, int start, int end, int flags) {
         * 主要是start跟end，start是起始位置,无论中英文，都算一个。
         * 从0开始计算起。end是结束位置，所以处理的文字，包含开始位置，但不包含结束位置。
         */
        spannableString.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时的时间设置为红色
        mTextView.setText(spannableString);
    }

    @Override
    public void onFinish() {
        mTextView.setText("获取验证码");
        mTextView.setClickable(true);//重新获得点击
        mTextView.setBackgroundResource(R.drawable.shape_button2);  //还原背景色
    }

    /**
     * @param phoneNum 用户手机号
     */
    public void sendNote(String phoneNum){

        URL url = null;
        String send_content= null;//发送内容
        try {
            send_content = URLEncoder.encode((MyApplication.sendContent+StringUtils.suiJiShu()+MyApplication.sendContent1).replaceAll("<br/>", " "), "GBK");
            url = new URL(HttpConstant.sendNote+"?CorpID="+MyApplication.CorpID+"&Pwd="+MyApplication.Pwd+"&Mobile="+phoneNum+"&Content="+send_content+"&Cell=&SendTime="+"");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        MyOkHttp.get().post(context, String.valueOf(url), null, new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                LogUtils.d("短信发送成功-------》"+response);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                LogUtils.d("短信发送失败-------》"+error_msg);
            }
        });
    }


    /**
     * 将UTF-8转换成GBK2312
     * @param str
     * @return
     */
    public static String utf8Togb2312(String str){

        StringBuffer sb = new StringBuffer();

        for ( int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+' :
                    sb.append( ' ' );
                    break ;
                case '%' :
                    try {
                        sb.append(( char )Integer.parseInt (
                                str.substring(i+1,i+3),16));
                    }
                    catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                    i += 2;
                    break ;
                default :
                    sb.append(c);
                    break ;
            }
        }

        String result = sb.toString();
        String res= null ;

        try {

            byte [] inputBytes = result.getBytes( "8859_1" );
            res= new String(inputBytes, "UTF-8" );

        }catch (Exception e){

        }
        return res;
    }
}
