package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.adpter.SectionListAdapter;
import com.oridway.www.uiframe.bean.ClsSection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 第一级列表
 * 1.编辑状态下选中一个条目，会弹出底部操作栏
 * 2.非编辑状态下选中条目会跳转到下一级
 * 3.复选框使用ImageView而不是CheckBox
 * 4.编辑状态下，按返回键回到非编辑状态
 */
public class SectionListActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SectionListActivity";

    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView back;
    @BindView(R.id.discuss_list_view)
    ListView mListView;
    @BindView(R.id.edit_tv)
    TextView edit;
    @BindView(R.id.filter_tv)
    TextView filter;
    @BindView(R.id.discuss_toolbar)
    LinearLayout mToolbar;
    @BindView(R.id.discuss_close)
    TextView btnClose;
    @BindView(R.id.discuss_open)
    TextView btnOpen;
    @BindView(R.id.discuss_delete)
    TextView btnDelete;

    private Context mContext;
    private boolean isEditable;
    private List<ClsSection> mClsSectionList;
    private SectionListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_list);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    private void initData() {
        mContext = this;
        setIsEditable(false);

        mClsSectionList = new ArrayList<>();
        mAdapter = new SectionListAdapter(mClsSectionList, mContext);
        mListView.setAdapter(mAdapter);

        initOfflineData(10);
    }

    private void initOfflineData(int num) {
        List<ClsSection> clsSectionList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            ClsSection clsSection = new ClsSection();
            clsSection.setIsClosed("isClosed" + i);
            clsSection.setCloseDate("closeDate" + i);
            clsSection.setSectionID("sectionID" + i);
            clsSection.setSectionName("sectionName" + i);
            clsSection.setSectionType("sectionType" + i);
            clsSection.setSectionDesc("sectionDesc" + i);
            clsSection.setSectionLogo("sectionLogo" + i);
            clsSection.setSectionManagerID("sectionManagerID" + i);
            clsSection.setSectionManager("sectionManager" + i);
            clsSectionList.add(clsSection);
        }

        mClsSectionList.addAll(clsSectionList);
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        title.setText("一级列表");
        mToolbar.setVisibility(View.GONE);

        filter.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_add_black_24dp, 0, 0, 0);

        edit.setVisibility(View.VISIBLE);
        filter.setVisibility(View.VISIBLE);
    }

    private void initListener() {
        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnOpen.setOnClickListener(this);
        filter.setOnClickListener(this);

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            ClsSection clsSection = mClsSectionList.get(position);

            if (getIsEditable()) {
                if (clsSection.getIsCheckBoxVisible()) {
                    clsSection.setIsChecked(!clsSection.getIsChecked());
                    mAdapter.notifyDataSetChanged();
                }
                for (int i = 0; i < mClsSectionList.size(); i++) {
                    ClsSection section = mClsSectionList.get(i);
                    if (section.getIsChecked()) {
                        mToolbar.setVisibility(View.VISIBLE);
                        break;
                    }
                    if (i == mClsSectionList.size() - 1) {
                        mToolbar.setVisibility(View.GONE);
                    }
                }
            } else {
                String sectionID = clsSection.getSectionID();
                Intent intent = new Intent(mContext, TopicListActivity.class);
                intent.putExtra("sectionID", sectionID);
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

        if (v.getId() == R.id.filter_tv) {
            Intent intent = new Intent(mContext, SectionNewActivity.class);
            startActivityForResult(intent, 15874);
        }

        switch (v.getId()) {
            case R.id.discuss_delete:
            case R.id.discuss_close:
            case R.id.discuss_open:
                Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
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
        setIsEditable(!getIsEditable());

        for (ClsSection clsSection : mClsSectionList) {
            clsSection.setIsCheckBoxVisible(getIsEditable());
            clsSection.setIsChecked(false);
        }
        mAdapter.notifyDataSetChanged();
        mToolbar.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 15874 && resultCode == RESULT_OK) {
            refreshData();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void refreshData() {
        Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
    }
}
