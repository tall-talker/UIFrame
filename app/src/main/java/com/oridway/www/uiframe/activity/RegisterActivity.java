package com.oridway.www.uiframe.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.adpter.RoleCardAdapter;
import com.oridway.www.uiframe.bean.ClsRole;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 新建用户的页面
 * 1.包含一个标题栏和ScrollView
 * 2.ScrollView中包含一个定高的ListView
 * 3.需要实现RoleCardAdapter.Callback以删除列表中的条目
 * 4.提交数据之后需要刷新列表
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "RegisterActivity";

    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView backButton;
    @BindView(R.id.lv_user_role)
    ListView mListView;
    @BindView(R.id.sl_user_new)
    ScrollView mScrollView;
    @BindView(R.id.tv_add_role)
    TextView addRole;
    @BindView(R.id.clear_roles)
    TextView clearRole;
    @BindView(R.id.edit_tv)
    TextView edit;


    private Context mContext;
    private RoleCardAdapter mAdapter;
    private List<ClsRole> mClsRoleList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    private void initView() {
        title.setText("新建用户");
        edit.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_send_black_24dp, 0, 0, 0);
        edit.setVisibility(View.VISIBLE);
    }

    private void initData() {
        mContext = this;

        mClsRoleList = new ArrayList<>();
        mAdapter = new RoleCardAdapter(mContext, mClsRoleList);
        mListView.setAdapter(mAdapter);
        mClsRoleList.addAll(getOfflineData(10));
        mAdapter.notifyDataSetChanged();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initListener() {
        backButton.setOnClickListener(this);
        addRole.setOnClickListener(this);
        clearRole.setOnClickListener(this);
        edit.setOnClickListener(this);

        mAdapter.setmCallback((view, position) -> {
            if (mClsRoleList.size() == 1) {
                Toast.makeText(mContext, "至少保留一个角色", Toast.LENGTH_LONG).show();
            } else {
                mClsRoleList.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });

        mListView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                mScrollView.requestDisallowInterceptTouchEvent(false);
            } else {
                mScrollView.requestDisallowInterceptTouchEvent(true);
            }
            return false;
        });
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.title_left) {
            setResult(111);
            finish();
        }

        if (v.getId() == R.id.tv_add_role) {
            Intent intent = new Intent(mContext, RoleSelectActivity.class);
            startActivityForResult(intent, 123);
        }

        if (v.getId() == R.id.clear_roles) {
            mClsRoleList.clear();
            mClsRoleList.addAll(getOfflineData(1));
            mAdapter.notifyDataSetChanged();
        }

        if (v.getId() == R.id.edit_tv) {
            submit();
        }
    }

    private void submit() {
        Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
        finish();
    }


    private List<ClsRole> getOfflineData(int num) {

        List<ClsRole> clsNormalUsers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            ClsRole clsRole = new ClsRole();
            clsRole.setRowID("RowID:" + i);
            clsRole.setSysRoleID("sysRoleID:" + i);
            clsRole.setSysRoleName("sysRoleName:" + i);
            clsRole.setSysRoleDesc("sysRoleDesc:" + i);
            clsRole.setSysRoleType("sysRoleType:" + i);
            clsRole.setSysRoleTypeName("sysRoleTypeName:" + i);
            clsRole.setOrgID("orgID:" + i);
            clsRole.setOrgName("orgName:" + i);
            clsRole.setIsOff("isOff:" + i);
            clsRole.setSetOffDate("setOffDate:" + i);
            clsRole.setCreaterID("createrID:" + i);
            clsRole.setCreater("creater:" + i);
            clsRole.setModiManID("modiManID:" + i);
            clsRole.setModiManName("modiManName:" + i);
            clsNormalUsers.add(clsRole);
        }

        return clsNormalUsers;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 123 && resultCode == 321) {
            assert data != null;
            mClsRoleList.addAll(data.getParcelableArrayListExtra("checkedList"));
            mAdapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
