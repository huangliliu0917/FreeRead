package com.yinglan.FreeRead.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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

public class Activity_Setting_BindBankCard extends BaseActivity {

    @BindView(R.id.BindBankCard_titleBar)
    TitleBar BindBankCardTitleBar;
    @BindView(R.id.BindBankCard_bindCommit)
    TextView BindBankCardBindCommit;
    @BindView(R.id.BindBankCard_userName)
    EditText BindBankCardUserName;
    @BindView(R.id.BindBankCard_CardId)
    EditText BindBankCardCardId;
    @BindView(R.id.BindBankCard_clearCardNum)
    ImageView BindBankCardClearCardNum;
    @BindView(R.id.BindBankCard_userPhone)
    EditText BindBankCardUserPhone;
    @BindView(R.id.BindBankCard_checkNum)
    EditText BindBankCardCheckNum;
    @BindView(R.id.BindBankCard_getCheckNum)
    TextView BindBankCardGetCheckNum;
    @BindView(R.id.BindBankCard_notReceiveCheckNum)
    TextView BindBankCardNotReceiveCheckNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__setting__bind_bank_card);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        BindBankCardTitleBar.setTitle("添加银行卡");
        BindBankCardTitleBar.setLeftIcon(this.getResources().getDrawable(R.mipmap.icon_fanghuijian));
        BindBankCardTitleBar.setTitleColor(this.getResources().getColor(R.color.colorWhite));
        BindBankCardTitleBar.setBackgroundColor(this.getResources().getColor(R.color.textSelect));
        BindBankCardTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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


        BindBankCardCardId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (BindBankCardCardId.getText().length() != 0) {
                    BindBankCardClearCardNum.setVisibility(View.VISIBLE);
                } else {
                    BindBankCardClearCardNum.setVisibility(View.GONE);
                }
            }
        });


    }

    @OnClick({R.id.BindBankCard_clearCardNum, R.id.BindBankCard_getCheckNum, R.id.BindBankCard_bindCommit,
            R.id.BindBankCard_notReceiveCheckNum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BindBankCard_clearCardNum:

                if (BindBankCardCardId.getText().length() != 0) {
                    BindBankCardCardId.setText("");
                }

                break;
            case R.id.BindBankCard_getCheckNum:
                if (BindBankCardCheckNum.getText().length() == 0) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.BindBankCard_bindCommit:

                if (BindBankCardUserName.getText().length() == 0 && BindBankCardCardId.getText().length() == 0
                        && BindBankCardUserPhone.getText().length() == 0 && BindBankCardCheckNum.getText().length() == 0){
                    Toast.makeText(this, "请填写完表单", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.BindBankCard_notReceiveCheckNum:
                Toast.makeText(this, "收不到验证码", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
