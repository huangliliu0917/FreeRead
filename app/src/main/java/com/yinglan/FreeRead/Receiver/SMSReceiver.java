package com.yinglan.FreeRead.Receiver;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ${AUTHOR} on 2019/3/29 0029
 * Function: ${Function}
 */
public class SMSReceiver extends BroadcastReceiver {

    private static final String TAG = "SMSReceiver";
    private SharedPreferences.Editor editor;


    @Override
    public void onReceive(Context context, Intent intent) {
        //进行获取短信的操作

        getMsg(context, intent);

        editor = context.getSharedPreferences("UserData",Context.MODE_PRIVATE).edit();
    }


    private void getMsg(Context context, Intent intent){
        //pdus短信单位pdu

        //解析短信内容

        Object[] pdus = (Object[]) intent.getExtras().get("pdus");

        assert pdus != null;

        for (Object pdu : pdus){

            //封装短信参数的对象
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);

            String number = sms.getOriginatingAddress();

            String body = sms.getMessageBody();

            getCode(context, body);

        }
    }


    private void getCode(Context context, String body){
        //获取剪贴板管理器：

        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

        Pattern pattern1 = Pattern.compile("(\\d{6})");//提取六位数字

        Matcher matcher1 = pattern1.matcher(body);//进行匹配

        Pattern pattern2 = Pattern.compile("(\\d{4})");//提取四位数字

        Matcher matcher2 = pattern2.matcher(body);//进行匹配

        if (matcher1.find()) {//匹配成功

            String code = matcher1.group(0);

            editor.putString("SMSCode",code);
            editor.apply();

            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText("Label", code);
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            Toast.makeText(context, "验证码复制成功", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onReceive: " + code);

        }else if(matcher2.find()){

            String code = matcher2.group(0);
            editor.putString("SMSCode",code);
            editor.apply();

            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText("Label", code);
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            Toast.makeText(context, "验证码复制成功", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onReceive: " + code);

        }else{
            Toast.makeText(context, "未检测到验证码", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onReceive: " + "未检测到验证码");
        }

    }

}
