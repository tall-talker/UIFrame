package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oridway.www.uiframe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "UserDetailActivity";
    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView back;
    @BindView(R.id.tv_orgname)
    TextView orgName;
    @BindView(R.id.tv_orgcode)
    TextView orgId;
    @BindView(R.id.tv_userid)
    TextView userId;
    @BindView(R.id.tv_username)
    TextView userName;
    @BindView(R.id.tv_sex)
    TextView userSex;
    @BindView(R.id.tv_type)
    TextView userType;
    @BindView(R.id.tv_cardid)
    TextView userCardcode;
    @BindView(R.id.tv_birthday)
    TextView userBirthday;
    @BindView(R.id.tv_phone)
    TextView userPhone;
    @BindView(R.id.tv_tel)
    TextView userTel;
    @BindView(R.id.tv_email)
    TextView userEmail;
    @BindView(R.id.tv_sysname)
    TextView sysUsername;
    @BindView(R.id.tv_sysdesc)
    TextView sysDesc;
    @BindView(R.id.tv_sysrole)
    TextView sysRole;
    @BindView(R.id.tv_sysstatus)
    TextView sysStatus;
    @BindView(R.id.tv_start_date)
    TextView startDate;
    @BindView(R.id.edit_tv)
    TextView edit;
    @BindView(R.id.filter_tv)
    TextView filter;
    @BindView(R.id.normal_user_toolbar)
    LinearLayout toolBar;
    @BindView(R.id.user_delete)
    TextView deleteUser;
    @BindView(R.id.user_edit)
    TextView editUser;
    @BindView(R.id.user_close)
    TextView closeUser;
    @BindView(R.id.user_open)
    TextView openUser;

    private Context mContext;
    private String userID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    private void initData() {

        mContext = this;
        Intent intent = getIntent();
        userID = intent.getStringExtra("userID");
        getUserInfo(userID);
    }

    private void getUserInfo(String userID) {
        Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        title.setText("详情");
    }

    private void initListener() {
        back.setOnClickListener(this);
        deleteUser.setOnClickListener(this);
        editUser.setOnClickListener(this);
        closeUser.setOnClickListener(this);
        openUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.title_left) {
            finish();
        }

        switch (v.getId()){
            case R.id.user_close:
            case R.id.user_open:
            case R.id.user_edit:
            case R.id.user_delete:
                Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
        }
    }
}
