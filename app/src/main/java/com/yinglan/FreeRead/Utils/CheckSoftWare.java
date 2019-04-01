package com.yinglan.FreeRead.Utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by ${AUTHOR} on 2019/4/1 0001
 * Function: 检测手机是否安装特定软件
 */
public class CheckSoftWare {


    /**
     * 判断是否安装某些特定软件
     * @param context
     * @param PackageName
     */
    public static boolean isAvilible(Context context, String PackageName){
        if (TextUtils.isEmpty(PackageName))
            return false;

        try {
            ApplicationInfo info = context.getPackageManager()
                    .getApplicationInfo(PackageName,
                            PackageManager.GET_UNINSTALLED_PACKAGES);
            LogUtils.d(info.toString()); // Timber 是我打印 log 用的工具，这里只是打印一下 log
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.d(e.toString()); // Timber 是我打印 log 用的工具，这里只是打印一下 log
            return false;
        }
    }


}
