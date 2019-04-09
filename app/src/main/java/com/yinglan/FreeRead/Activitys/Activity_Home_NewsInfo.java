package com.yinglan.FreeRead.Activitys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;
import com.yinglan.FreeRead.Utils.StringUtils;
import com.yinglan.FreeRead.Utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_Home_NewsInfo extends Activity {


    @BindView(R.id.NewsInfo_titleBar)
    TitleBar NewsInfoTitleBar;
    @BindView(R.id.home_newsInfo_web)
    WebView homeNewsInfoWeb;
    @BindView(R.id.home_newsInfo_progress)
    ProgressBar homeNewsInfoProgress;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_news_info);
        ButterKnife.bind(this);

        String str = getIntent().getStringExtra("url");

        context = getApplicationContext();

        initView(str);
    }

    public void initView(String str) {

        NewsInfoTitleBar.setTitle("新闻详情");
        NewsInfoTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        NewsInfoTitleBar.setRightIcon(this.getResources().getDrawable(R.mipmap.icon_fenxiang));
        NewsInfoTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        NewsInfoTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        NewsInfoTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                ToastUtils.showShort(context, "进入分享");
            }
        });


        WebSettings ws = homeNewsInfoWeb.getSettings();
        // 适配屏幕
        ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);
        ws.setDomStorageEnabled(true);// 启用dom存储(关键就是这句)，貌似网上twitter显示有问题也是这个属性没有设置的原因
        ws.setJavaScriptEnabled(true); // 设置JavaScript是否可用，（是否允许视频的播放）

        ws.setJavaScriptCanOpenWindowsAutomatically(true);
        ws.setPluginState(WebSettings.PluginState.ON);
        // settings.setPluginsEnabled(true);
        ws.setAllowFileAccess(true);
        ws.setBuiltInZoomControls(true);// 隐藏缩放按钮
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 排版适应屏幕
        ws.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。
        ws.setSavePassword(true);
        ws.setSaveFormData(true);// 保存表单数据
        homeNewsInfoWeb.setSaveEnabled(false);
        ws.setSaveFormData(false);
        // 下面的一句话是必须的，必须要打开javaScript不然所做一切都是徒劳的
        ws.setSupportZoom(false);

        homeNewsInfoWeb.setWebChromeClient(new WebChromeClient()); // 允许弹窗作用
        homeNewsInfoWeb.setWebViewClient(new WebViewClient() { // 不允许UC调到浏览器上面去
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,
                                                    String url) {
                return false;
            }
        });
        if (StringUtils.isEmpty(str)) {
            homeNewsInfoWeb.loadUrl(str);
        }

        homeNewsInfoWeb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

//                try {
//                    if (pd != null) {
//                        pd.dismiss();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                super.onPageStarted(view, url, favicon);
//                if (pd == null) {
//                    pd = ProgressDialog.show(Activity_Home_NewsInfo.this, null,
//                            "正在加载...", true, false);
//                    pd.setCancelable(true);
//                } else {
//                    if (!pd.isShowing()){
//                        pd.show();
//                    }
//                }
            }

        });

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (homeNewsInfoWeb != null && homeNewsInfoWeb.canGoBack()) {
                homeNewsInfoWeb.goBack();
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }

        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (homeNewsInfoWeb != null) {
            homeNewsInfoWeb.destroy();
        }
    }
}
