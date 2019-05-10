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
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    private void initData() {
        mContext = this;
        isMultipleEnable = getIntent().getBooleanExtra("isMultipleEnable", false);

        mClsNormalUserList = new ArrayList<>();
        mAdapter = new UserSelectAdapter(mClsNormalUserList, mContext);
        mListView.setAdapter(mAdapter);

        getOfflineData(20);

        if (isMultipleEnable) {
            edit.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_send_black_24dp, 0, 0, 0);
            edit.setVisibility(View.VISIBLE);

            for (ClsNormalUser user : mClsNormalUserList) {
                user.setIsCheckBoxVisible(true);
            }
        }
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
        title.setText("选择用户");
    }

    private void initListener() {
        edit.setOnClickListener(this);

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            ClsNormalUser clsNormalUser = mClsNormalUserList.get(position);
            if (isMultipleEnable) {
                if (clsNormalUser.getIsCheckBoxVisible()) {
                    clsNormalUser.setIsChecked(!clsNormalUser.getIsChecked());
                    mAdapter.notifyDataSetChanged();
                }
            } else {
                Intent intent = new Intent();
                intent.putExtra("user", clsNormalUser);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.edit_tv) {
            ArrayList<ClsNormalUser> normalUserList = new ArrayList<>();
            for (ClsNormalUser normalUser : mClsNormalUserList) {
                if (normalUser.getIsChecked()) {
                    normalUserList.add(normalUser);
                }
            }
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("users", normalUserList);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
