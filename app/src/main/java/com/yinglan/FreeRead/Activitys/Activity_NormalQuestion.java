package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_NormalQuestion extends BaseActivity {

    @BindView(R.id.normalQuestion_titleBar)
    TitleBar normalQuestionTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__normal_question);
        ButterKnife.bind(this);initView();
        initView();
    }


    @SuppressLint("ResourceAsColor")
    public void initView() {
        normalQuestionTitleBar.setTitle("常见问题");
        normalQuestionTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        normalQuestionTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        normalQuestionTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        normalQuestionTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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


}
