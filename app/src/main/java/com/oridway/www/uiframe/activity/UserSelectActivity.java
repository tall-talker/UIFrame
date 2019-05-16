package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.adpter.UserSelectAdapter;
import com.oridway.www.uiframe.bean.ClsNormalUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 根据上一个页面传过来的isMultipleEnable判断是否可以多选
 * 1.单选页面选中一个条目直接结束并回传
 * 2.多选页面选中之后需要提交
 * 3.提交数据之后需要刷新列表
 */
public class UserSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "UserSelectActivity";

    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView back;
    @BindView(R.id.normal_user_listview)
    ListView mListView;
    @BindView(R.id.edit_tv)
    TextView edit;
    @BindView(R.id.filter_tv)
    TextView filter;

    private Context mContext;
    private boolean isMultipleEnable;
    private UserSelectAdapter mAdapter;
    private List<ClsNormalUser> mClsNormalUserList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_user_list);
        //初始化ButterKnife
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    private void initData() {
        mContext = this;

        //通过源页面传过来的值来生成对应的视图，默认是单选
        isMultipleEnable = getIntent().getBooleanExtra("isMultipleEnable", false);

        //初始化数据源
        mClsNormalUserList = new ArrayList<>();
        mAdapter = new UserSelectAdapter(mClsNormalUserList, mContext);
        mListView.setAdapter(mAdapter);

        getOfflineData(20);

        //多选页面要显示提交按钮和checkbox
        if (isMultipleEnable) {
            edit.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_send_black_24dp, 0, 0, 0);
            edit.setVisibility(View.VISIBLE);

            for (ClsNormalUser user : mClsNormalUserList) {
                user.setIsCheckBoxVisible(true);
            }
        }
    }

    //生成模拟数据
    private void getOfflineData(int num) {
        List<ClsNormalUser> clsNormalUserList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            ClsNormalUser clsNormalUser = new ClsNormalUser();
            clsNormalUser.setUserID("userID " + i);
            clsNormalUser.setWorkNumber("workNumber " + i);
            clsNormalUser.setUserType("userType " + i);
            clsNormalUser.setOrgName("orgName " + i);
            clsNormalUser.setCName("cName " + i);
            clsNormalUser.setSysUserName("sysUserName " + i);
            clsNormalUser.setOrgID("orgID " + i);
            clsNormalUser.setWorkPos("workPos " + i);
            clsNormalUserList.add(clsNormalUser);
        }
        //数据填充后要同时适配器刷新视图
        mClsNormalUserList.addAll(clsNormalUserList);
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        title.setText("选择用户");
    }

    private void initListener() {
        edit.setOnClickListener(this);

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            ClsNormalUser clsNormalUser = mClsNormalUserList.get(position);
            if (isMultipleEnable) {
                //多选状态下点击选中当前条目
                if (clsNormalUser.getIsCheckBoxVisible()) {
                    clsNormalUser.setIsChecked(!clsNormalUser.getIsChecked());
                    mAdapter.notifyDataSetChanged();
                }
            } else {
                //单选状态下点击结束当前页并回传值
                Intent intent = new Intent();
                //实体类要实现序列化接口Parcelable
                intent.putExtra("user", clsNormalUser);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {

        //点击提交按钮将选中的值回传并结束当前页
        if (v.getId() == R.id.edit_tv) {
            ArrayList<ClsNormalUser> normalUserList = new ArrayList<>();
            for (ClsNormalUser normalUser : mClsNormalUserList) {
                if (normalUser.getIsChecked()) {
                    normalUserList.add(normalUser);
                }
            }
            Intent intent = new Intent();
            //实体类要实现序列化接口Parcelable
            intent.putParcelableArrayListExtra("users", normalUserList);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
