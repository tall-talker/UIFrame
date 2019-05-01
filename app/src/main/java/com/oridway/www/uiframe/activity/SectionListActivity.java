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
    @BindView(R.id.discuss_edit)
    TextView btnEdit;
    @BindView(R.id.discuss_change_logo)
    TextView btnChangeLogo;
    @BindView(R.id.discuss_change_owner)
    TextView btnChangeOwner;
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

    protected void initData() {
        mContext = this;
        isEditable = false;
        initOffonlineData(20);

    }

    private void initOffonlineData(int num) {
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
            clsSection.setCreateDate("createDate" + i);
            clsSection.setTopics("topics" + i);
            clsSection.setReplys("replys" + i);
            clsSection.setTopicID("topicID" + i);
            clsSection.setReplyID("replyID" + i);
            clsSection.setReplyContent("replyContent" + i);
            clsSection.setReplyTime("replyTime" + i);
            clsSection.setAuthorID("authorID" + i);
            clsSection.setAuthorName("authorName" + i);
            clsSection.setdCount("dCount" + i);
            clsSectionList.add(clsSection);
        }

        mClsSectionList = clsSectionList;
        mAdapter = new SectionListAdapter(mClsSectionList, mContext);
        mListView.setAdapter(mAdapter);
    }

    protected void initView() {
        title.setText("一级列表");
        mToolbar.setVisibility(View.GONE);

        Drawable drawable = getResources().getDrawable(R.drawable.ic_add_black_24dp);
        filter.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);

        edit.setVisibility(View.VISIBLE);
        filter.setVisibility(View.VISIBLE);
    }

    protected void initListener() {
        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        btnChangeLogo.setOnClickListener(this);
        btnChangeOwner.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnOpen.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
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
            finish();
        }
        if (v.getId() == R.id.edit_tv) {
            switchEditable();
        }
        if (v.getId() == R.id.discuss_edit) {
            checkOperation(SectionEditActivity.class);
        }

        if (v.getId() == R.id.discuss_change_owner) {
            checkOperation(SectionChangeManagerActivity.class);
        }

        if (v.getId() == R.id.discuss_change_logo) {
            checkOperation(SectionChangeLogoActivity.class);
        }

        if (v.getId() == R.id.filter_tv) {
            startActivity(new Intent(mContext, SectionNewActivity.class));
        }

        if (v.getId() == R.id.discuss_delete) {
            for (ClsSection clsSection : mClsSectionList) {
                if (clsSection.getIsChecked()) {
                    mClsSectionList.remove(clsSection);
                    mAdapter.notifyDataSetChanged();
                }
            }
            switchEditable();
        }
        if (v.getId() == R.id.discuss_close) {
            Toast.makeText(mContext, "所选板块已关闭！", Toast.LENGTH_LONG).show();
        }
        if (v.getId() == R.id.discuss_open) {
            Toast.makeText(mContext, "所选板块已开放！", Toast.LENGTH_LONG).show();
        }
    }

    private void checkOperation(Class targetActivity) {
        int checkedNum = 0;
        ClsSection checkedItem = null;
        for (int i = 0; i < mClsSectionList.size(); i++) {
            ClsSection clsSection = mClsSectionList.get(i);
            if (clsSection.getIsChecked()) {
                checkedItem = clsSection;
                checkedNum = checkedNum + 1;
                if (checkedNum > 1) {
                    Toast.makeText(mContext, "只支持单项编辑！", Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
        if (checkedNum == 1) {
            Intent intent = new Intent(mContext, targetActivity);
            intent.putExtra("sectionParcelable", checkedItem);
            startActivity(intent);
        }
    }

    public boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(boolean editable) {
        isEditable = editable;
    }

    private void switchEditable() {
        for (ClsSection clsSection : mClsSectionList) {
            clsSection.setIsCheckBoxVisible(!clsSection.getIsCheckBoxVisible());
            clsSection.setIsChecked(false);
        }
        mAdapter.notifyDataSetChanged();
        mToolbar.setVisibility(View.GONE);
        setIsEditable(!getIsEditable());
    }
}
