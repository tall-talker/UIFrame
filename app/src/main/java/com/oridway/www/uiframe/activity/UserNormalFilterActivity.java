package com.oridway.www.uiframe.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.oridway.www.uiframe.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserNormalFilterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "UserFilterActivity";
    @BindView(R.id.title_left)
    ImageView titleLeft;
    @BindView(R.id.edit_tv)
    TextView editTv;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.iv_number)
    ImageView ivNumber;
    @BindView(R.id.et_work_number)
    EditText etWorkNumber;
    @BindView(R.id.iv_work_number)
    ImageView ivWorkNumber;
    @BindView(R.id.et_sys_name)
    EditText etSysName;
    @BindView(R.id.iv_sys_name)
    ImageView ivSysName;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.iv_user_name)
    ImageView ivUserName;
    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.iv_department)
    ImageView ivDepartment;
    @BindView(R.id.et_post)
    EditText etPost;
    @BindView(R.id.iv_post)
    ImageView ivPost;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.iv_mobile)
    ImageView ivMobile;
    @BindView(R.id.et_tele_phone)
    EditText etTelePhone;
    @BindView(R.id.iv_telephone)
    ImageView ivTelephone;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.iv_email)
    ImageView ivEmail;
    @BindView(R.id.tv_birth_start)
    TextView tvBirthStart;
    @BindView(R.id.iv_birth_date1)
    ImageView ivBirthDate1;
    @BindView(R.id.tv_birth_end)
    TextView tvBirthEnd;
    @BindView(R.id.iv_birth_date2)
    ImageView ivBirthDate2;
    @BindView(R.id.tv_creator)
    TextView tvCreator;
    @BindView(R.id.iv_creator)
    ImageView ivCreator;
    @BindView(R.id.rb_status_unknow)
    RadioButton rbStatusUnknow;
    @BindView(R.id.rb_status_on)
    RadioButton rbStatusOn;
    @BindView(R.id.rb_status_off)
    RadioButton rbStatusOff;
    @BindView(R.id.rg_status)
    RadioGroup rgStatus;
    @BindView(R.id.tv_off_start)
    TextView tvOffStart;
    @BindView(R.id.iv_off_start)
    ImageView ivOffStart;
    @BindView(R.id.tv_off_end)
    TextView tvOffEnd;
    @BindView(R.id.iv_off_end)
    ImageView ivOffEnd;
    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.ll_off_time)
    LinearLayout offTime;

    private List<ImageView> imageViewList;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_filter);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    protected void initData() {

        mContext = this;
        title.setText("筛选");

        imageViewList = new ArrayList<>();
        imageViewList.add(ivNumber);
        imageViewList.add(ivMobile);
        imageViewList.add(ivWorkNumber);
        imageViewList.add(ivSysName);
        imageViewList.add(ivPost);
        imageViewList.add(ivTelephone);
        imageViewList.add(ivEmail);

        for (ImageView imageView : imageViewList) {
            imageView.setTag(false);
        }
    }

    protected void initView() {
        editTv.setVisibility(View.VISIBLE);
        editTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_send_black_24dp, 0, 0, 0);
    }

    protected void initListener() {

        for (ImageView imageView : imageViewList) {
            imageView.setOnClickListener(this);
        }

        titleLeft.setOnClickListener(this);
        editTv.setOnClickListener(this);
        rgStatus.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_status_off) {
                offTime.setVisibility(View.VISIBLE);
            } else {
                offTime.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.title_left) {
            finish();
        }

        if(view.getId() == R.id.edit_tv){
            submitCondition();
        }

        switch (view.getId()) {

            case R.id.iv_number:
            case R.id.iv_work_number:
            case R.id.iv_sys_name:
            case R.id.iv_post:
            case R.id.iv_mobile:
            case R.id.iv_telephone:
            case R.id.iv_email:
                switchExact((ImageView) view);
        }
    }

    public void submitCondition() {
        StringBuilder sb = new StringBuilder("where");
        String number = etNumber.getText().toString();
        String workNumber = etWorkNumber.getText().toString();
        String sysName = etSysName.getText().toString();
        String post = etPost.getText().toString();
        String mobile = etMobile.getText().toString();
        String telePhone = etTelePhone.getText().toString();
        String email = etEmail.getText().toString();

        if (!TextUtils.isEmpty(number)) {
            String[] arr = number.split(",");
            if ((boolean) ivNumber.getTag()) {
                sb.append(" and userID in (").append(stringToString(arr)).append(")");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        sb.append(" and (left(userID, ").append(arr[i].length()).append(") = '").append(arr[i]).append("'");
                    } else {
                        sb.append(" or left(userID, ").append(arr[i].length()).append(") = '").append(arr[i]).append("'");
                    }
                }
                sb.append(")");
            }
        }

        if (!TextUtils.isEmpty(sysName)) {
            String[] arr = sysName.split(",");
            if ((boolean) ivSysName.getTag()) {
                sb.append(" and sysUserName in (").append(stringToString(arr)).append(")");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        sb.append(" and (userName like '|").append(arr[i]).append("|'");
                    } else {
                        sb.append(" or userName like '|").append(arr[i]).append("|'");
                    }
                }
                sb.append(")");
            }
        }

        if (!TextUtils.isEmpty(workNumber)) {
            String[] arr = workNumber.split(",");
            if ((boolean) ivWorkNumber.getTag()) {
                sb.append(" and workNumber in (").append(stringToString(arr)).append(")");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        sb.append(" and (workNumber like '").append(arr[0]).append("|'");
                    } else {
                        sb.append(" or workNumber like '").append(arr[i]).append("|'");
                    }
                }
                sb.append(")");
            }
        }

        if (!TextUtils.isEmpty(post)) {
            String[] arr = post.split(",");
            if ((boolean) ivPost.getTag()) {
                sb.append(" and workPos in (").append(stringToString(arr)).append(")");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        sb.append(" and (workPost like '|").append(arr[0]).append("|'");
                    } else {
                        sb.append(" or workPost like '|").append(arr[i]).append("|'");
                    }
                }
                sb.append(")");
            }
        }

        if (!TextUtils.isEmpty(mobile)) {
            String[] arr = mobile.split(",");
            if ((boolean) ivMobile.getTag()) {
                sb.append(" and mobile in (").append(stringToString(arr)).append(")");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    sb.append(" and mobile in ('").append(stringToString(arr)).append("')");
                    if (i == 0) {
                        sb.append(" and (left(mobile, ").append(arr[i].length()).append(") = '").append(arr[i]).append("'");
                    } else {
                        sb.append(" or left(mobile, ").append(arr[i].length()).append(") = '").append(arr[i]).append("'");
                    }
                }
                sb.append(")");
            }
        }

        if (!TextUtils.isEmpty(telePhone)) {
            String[] arr = telePhone.split(",");
            if ((boolean) ivTelephone.getTag()) {
                sb.append(" and officeTel in (").append(stringToString(arr)).append(")");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        sb.append(" and (left(officeTel, ").append(arr[i].length()).append(") = '").append(arr[i]).append("'");
                    } else {
                        sb.append(" or left(officeTel, ").append(arr[i].length()).append(") = '").append(arr[i]).append("'");
                    }
                }
                sb.append(")");
            }
        }

        if (!TextUtils.isEmpty(email)) {
            String[] arr = email.split(",");
            if ((boolean) ivEmail.getTag()) {
                sb.append(" and e_mail in (").append(stringToString(arr)).append(")");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        sb.append(" and (e_mail　LIKE '|").append(arr[i]).append("|'");
                    } else {
                        sb.append(" OR　e_mail LIKE '|").append(arr[i]).append("|'");
                    }
                }
                sb.append(")");
            }
        }

        Intent intent = new Intent();
        intent.putExtra("sql", sb.toString());
        setResult(123, intent);
        finish();
    }

    public void switchExact(ImageView view) {
        view.setTag(!(boolean) view.getTag());
        if ((boolean) view.getTag()) {
            view.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        } else {
            view.setImageResource(R.drawable.ic_check_box_black_24dp);
        }
    }

    private String stringToString(String[] array) {
        StringBuilder end = new StringBuilder("");
        for (String s : array) {
            end.append("'").append(s).append("',");
        }
        return end.toString().substring(0, end.length() - 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }
}
