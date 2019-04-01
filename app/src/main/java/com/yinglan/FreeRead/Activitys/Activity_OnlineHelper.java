package com.yinglan.FreeRead.Activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.yinglan.FreeRead.BaseActivity;
import com.yinglan.FreeRead.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_OnlineHelper extends BaseActivity {

    @BindView(R.id.onlineHelper_titleBar)
    TitleBar onlineHelperTitleBar;
    @BindView(R.id.onlineHelp_record)
    RecyclerView onlineHelpRecord;
    @BindView(R.id.onlineHelp_yuyin)
    ImageView onlineHelpYuyin;
    @BindView(R.id.onlineHelp_textInput)
    EditText onlineHelpTextInput;
    @BindView(R.id.onlineHelp_faceInput)
    ImageView onlineHelpFaceInput;
    @BindView(R.id.onlineHelp_addInput)
    ImageView onlineHelpAddInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__online_helper);
        ButterKnife.bind(this);
        initView();

    }


    @SuppressLint("ResourceAsColor")
    public void initView() {
        onlineHelperTitleBar.setTitle("在线客服");
        onlineHelperTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        onlineHelperTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        onlineHelperTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        onlineHelperTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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


        onlineHelpTextInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    if (!(onlineHelpTextInput.getText().length() == 0)){
                        onlineHelpTextInput.setText("");
                        Toast.makeText(getApplicationContext(),"消息已发送",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"输入框不能为空",Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });

    }

    @OnClick({R.id.onlineHelp_yuyin, R.id.onlineHelp_faceInput, R.id.onlineHelp_addInput})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.onlineHelp_yuyin:
                Toast.makeText(this,"语音输入",Toast.LENGTH_SHORT).show();
                break;
            case R.id.onlineHelp_faceInput:
                Toast.makeText(this,"添加表情",Toast.LENGTH_SHORT).show();
                break;
            case R.id.onlineHelp_addInput:
                Toast.makeText(this,"添加文件",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
