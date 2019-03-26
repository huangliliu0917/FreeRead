package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_AskQuestion extends AppCompatActivity {

    @BindView(R.id.askQuestion_titleBar)
    TitleBar askQuestionTitleBar;
    @BindView(R.id.askQuestion_askWrong)
    RadioButton askQuestionAskWrong;
    @BindView(R.id.askQuestion_askSuggest)
    RadioButton askQuestionAskSuggest;
    @BindView(R.id.askQuestion_askOther)
    RadioButton askQuestionAskOther;
    @BindView(R.id.askQuestion_askType)
    RadioGroup askQuestionAskType;
    @BindView(R.id.askQuestion_askInfo)
    EditText askQuestionAskInfo;
    @BindView(R.id.askQuestion_askConnect)
    EditText askQuestionAskConnect;
    @BindView(R.id.askQuestion_askCommit)
    TextView askQuestionAskCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ask_question);
        ButterKnife.bind(this);

        initView();
    }


    public void initView() {

        askQuestionTitleBar.setTitle("问题反馈");
        askQuestionTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        askQuestionTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        askQuestionTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        askQuestionTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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


        askQuestionAskType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                }
            }
        });


    }

    @OnClick({R.id.askQuestion_askWrong, R.id.askQuestion_askSuggest, R.id.askQuestion_askOther, R.id.askQuestion_askCommit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.askQuestion_askWrong:
                break;
            case R.id.askQuestion_askSuggest:
                break;
            case R.id.askQuestion_askOther:
                break;
            case R.id.askQuestion_askCommit:
                Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
