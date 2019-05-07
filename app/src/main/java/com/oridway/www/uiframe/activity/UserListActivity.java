package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.adpter.UserListAdapter;
import com.oridway.www.uiframe.bean.ClsNormalUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "UserListActivity";

    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView back;
    @BindView(R.id.normal_user_listview)
    ListView mListView;
    @BindView(R.id.add_tv)
    TextView add;
    @BindView(R.id.edit_tv)
    TextView edit;
    @BindView(R.id.filter_tv)
    TextView filter;
    @BindView(R.id.normal_user_toolbar)
    LinearLayout mToolbar;
    @BindView(R.id.user_delete)
    TextView deleteUser;
    @BindView(R.id.user_edit)
    TextView editUser;
    @BindView(R.id.user_close)
    TextView closeUser;
    @BindView(R.id.user_open)
    TextView openUser;

    private Context mContext;
    private UserListAdapter mAdapter;
    private boolean isEditable;
    private List<ClsNormalUser> mClsNormalUserList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }


    private void initData() {
        mContext = this;
        isEditable = false;

        mClsNormalUserList = new ArrayList<>();
        mAdapter = new UserListAdapter(mClsNormalUserList, mContext);
        mListView.setAdapter(mAdapter);

        getOfflineData(20);
    }

    private void getOfflineData(int num) {

        List<ClsNormalUser> clsNormalUserList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            ClsNormalUser clsNormalUser = new ClsNormalUser();

            clsNormalUser.setRowID("RowID " + i);
            clsNormalUser.setUserID("userID " + i);
            clsNormalUser.setWorkNumber("workNumber " + i);
            clsNormalUser.setUserType("userType " + i);
            clsNormalUser.setOrgName("orgName " + i);
            clsNormalUser.setCName("cName " + i);
            clsNormalUser.setSysUserName("sysUserName " + i);
            clsNormalUser.setOrgID("orgID " + i);
            clsNormalUser.setWorkPos("workPos " + i);
            clsNormalUser.setOfficeTel("officeTel " + i);
            clsNormalUser.setMobile("mobile " + i);
            clsNormalUser.setE_mail("e_mail " + i);
            clsNormalUser.setIsOff("isOff " + i);
            clsNormalUser.setSetOffDate("setOffDate " + i);
            clsNormalUser.setSysUserDesc("sysUserDesc " + i);
            clsNormalUser.setCmdEnable("cmdEnable " + i);
            clsNormalUser.setModiManID("modiManID " + i);
            clsNormalUser.setModiManName("modiManName " + i);
            clsNormalUser.setModiTime("modiTime " + i);

            clsNormalUserList.add(clsNormalUser);
        }

        mClsNormalUserList.addAll(clsNormalUserList);
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        title.setText("用户列表");
        filter.setVisibility(View.VISIBLE);
        edit.setVisibility(View.VISIBLE);
        add.setVisibility(View.VISIBLE);
    }

    private void initListener() {
        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        filter.setOnClickListener(this);
        deleteUser.setOnClickListener(this);
        editUser.setOnClickListener(this);
        closeUser.setOnClickListener(this);
        openUser.setOnClickListener(this);
        add.setOnClickListener(this);

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            ClsNormalUser clsNormalUser = mClsNormalUserList.get(position);

            if (getIsEditable()) {
                if (clsNormalUser.getIsCheckBoxVisible()) {
                    clsNormalUser.setIsChecked(!clsNormalUser.getIsChecked());
                    mAdapter.notifyDataSetChanged();
                }
                for (int i = 0; i < mClsNormalUserList.size(); i++) {
                    ClsNormalUser user = mClsNormalUserList.get(i);
                    if (user.getIsChecked()) {
                        mToolbar.setVisibility(View.VISIBLE);
                        break;
                    }
                    if (i == mClsNormalUserList.size() - 1) {
                        mToolbar.setVisibility(View.GONE);
                    }
                }
            } else {
                String userID = clsNormalUser.getUserID();
                Intent intent = new Intent(mContext, UserDetailActivity.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.title_left) {

            if (getIsEditable()) {
                switchEditable();
            } else {
                finish();
            }
        }

        if (v.getId() == R.id.edit_tv) {
            switchEditable();
        }

        if (v.getId() == R.id.add_tv) {
            Intent intent = new Intent(mContext, RegisterActivity.class);
            startActivityForResult(intent, 16542);
        }

        if (v.getId() == R.id.filter_tv) {
            Intent intent = new Intent(mContext, UserFilterActivity.class);
            startActivityForResult(intent, 17452);
        }

    }

    @Override
    public void onBackPressed() {

        if (getIsEditable()) {
            switchEditable();
        } else {
            finish();
        }
    }

    public boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(boolean editable) {
        isEditable = editable;
    }

    private void switchEditable() {
        for (ClsNormalUser clsNormalUser : mClsNormalUserList) {
            clsNormalUser.setIsCheckBoxVisible(!clsNormalUser.getIsCheckBoxVisible());
            clsNormalUser.setIsChecked(false);
        }
        mAdapter.notifyDataSetChanged();
        mToolbar.setVisibility(View.GONE);
        setIsEditable(!getIsEditable());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }
}
