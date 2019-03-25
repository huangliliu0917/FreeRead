package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.Adapters.Adapter_NewsList;
import com.yinglan.FreeRead.Base.BaseNews;
import com.yinglan.FreeRead.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_News extends AppCompatActivity {

    @BindView(R.id.news_titleBar)
    TitleBar newsTitleBar;
    @BindView(R.id.news_newslist)
    RecyclerView newsNewslist;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    private List<BaseNews> traceList = new ArrayList<>(10);
    private Adapter_NewsList adapterNewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__news);
        ButterKnife.bind(this);

        initView();
        initData();

    }

    public void initView(){

        newsTitleBar.setTitle("消息");
        newsTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        newsTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        newsTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        newsTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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

    public void initData(){
        // 模拟一些假的数据
        traceList.add(new BaseNews("已签收", "[沈阳市] [沈阳和平五部]的派件已签收 感谢使用中通快递,期待再次为您服务!","2016-05-25 17:48:00"));
        traceList.add(new BaseNews("正在派件", "[沈阳市] [沈阳和平五部]的东北大学代理点正在派件 电话:18040xxxxxx 请保持电话畅通、耐心等待","2016-05-25 14:13:00"));
        traceList.add(new BaseNews("快件到达", "[沈阳市] 快件到达 [沈阳和平五部]","2016-05-25 13:01:04"));
        traceList.add(new BaseNews("快件离开", "[沈阳市] 快件离开 [沈阳中转]已发往[沈阳和平五部]","2016-05-25 12:19:47"));
        traceList.add(new BaseNews("快件到达", "[沈阳市] 快件到达 [沈阳中转]","2016-05-25 11:12:44"));
        traceList.add(new BaseNews("快件离开", "[嘉兴市] 快件离开 [杭州中转部]已发往[沈阳中转]","2016-05-24 03:12:12"));
        traceList.add(new BaseNews("快件到达", "[杭州市] 快件到达 [杭州汽运部]","2016-05-23 21:06:46"));
        traceList.add(new BaseNews("[杭州乔司区]已发往[沈阳]", "[杭州市] 快件离开 [杭州乔司区]已发往[沈阳]","2016-05-23 18:59:41"));
        traceList.add(new BaseNews("[杭州乔司区]的市场部已收件", "[杭州市] [杭州乔司区]的市场部已收件 电话:18358xxxxxx","2016-05-23 18:35:32"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newsNewslist.setLayoutManager(linearLayoutManager);
        adapterNewsList = new Adapter_NewsList(this, traceList);
        newsNewslist.setAdapter(adapterNewsList);
    }

}
