package com.yinglan.FreeRead.wxapi;

import android.content.Context;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.yinglan.FreeRead.MyApplication;
import com.yinglan.FreeRead.Utils.ToastUtils;

/**
 * Created by ${AUTHOR} on 2019/3/30 0030
 * Function: ${Function}
 */
public class WXUtils {


    /**
     * 微信登录，检测本地是否含有微信客户端
     * @param context
     */
    public static void wxLogin(Context context) {
        if (!MyApplication.mWXapi.isWXAppInstalled()) {
            ToastUtils.showShort(context,"您还未安装微信客户端");
            return;
        }

        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "skit_wx_login";//这个字段可以任意更改
        MyApplication.mWXapi.sendReq(req);

    }

}
