package com.oridway.www.uiframe.activity;

import android.content.Context;
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
import com.oridway.www.uiframe.adpter.ReplyListAdapter;
import com.oridway.www.uiframe.bean.ClsReply;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReplyListActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ReplyListActivity";
    @BindView(R.id.reply_list_view)
    ListView mListView;
    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView back;
    @BindView(R.id.edit_tv)
    TextView edit;
    @BindView(R.id.filter_tv)
    TextView filter;
    @BindView(R.id.btn_delete_reply)
    LinearLayout btnDelete;

    private Context mContext;
    private List<ClsReply> mClsReplyList;
    private ReplyListAdapter mAdapter;
    private boolean isEditable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }


    protected void initData() {

        mContext = this;
        String topicID = getIntent().getStringExtra("topicID");
        requestData(topicID);

        mClsReplyList = new ArrayList<>();
        mAdapter = new ReplyListAdapter(mClsReplyList, mContext);
        mListView.setAdapter(mAdapter);

        getOfflineData(20);
        setIsEditable(false);
    }

    private void requestData(String topicID) {
        Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
    }

    private void getOfflineData(int num) {

        List<ClsReply> clsReplyLists = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            ClsReply clsReply = new ClsReply();
            clsReply.setRowNum("rowNum" + i);
            clsReply.setTopicID("topicID" + i);
            clsReply.setReplyID("replyID" + i);
            clsReply.setReplyContent("replyContent" + i);
            clsReply.setReplyTime("replyTime" + i);
            clsReply.setReplyBoutiqueNum("replyBoutiqueNum" + i);
            clsReply.setReplyTopicNum("replyTopicNum" + i);
            clsReply.setReplyManID("replyManID" + i);
            clsReply.setReplyManName("replyManName" + i);
            clsReplyLists.add(clsReply);
        }

        mClsReplyList.addAll(clsReplyLists);
        mAdapter.notifyDataSetChanged();
    }

    protected void initView() {
        title.setText("三级列表");
        filter.setVisibility(View.GONE);
        btnDelete.setVisibility(View.GONE);
        edit.setVisibility(View.VISIBLE);
    }

    protected void initListener() {

        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        mListView.setOnItemClickListener((parent, view, position, id) -> {
            ClsReply clsReply = mClsReplyList.get(position);
            if (getIsEditable()) {
                if (clsReply.getIsCheckBoxVisible()) {
                    clsReply.setIsChecked(!clsReply.getIsChecked());
                    mAdapter.notifyDataSetChanged();
                }
                for (int i = 0; i < mClsReplyList.size(); i++) {
                    ClsReply reply = mClsReplyList.get(i);
                    if (reply.getIsChecked()) {
                        btnDelete.setVisibility(View.VISIBLE);
                        break;
                    }
                    if (i == mClsReplyList.size() - 1) {
                        btnDelete.setVisibility(View.GONE);
                    }
                }
            } else {
                String topicID = clsReply.getTopicID();
                Toast.makeText(mContext, topicID, Toast.LENGTH_LONG).show();
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

        if (v.getId() == R.id.btn_delete_topic) {
            Toast.makeText(mContext, "在此处调用接口", Toast.LENGTH_SHORT).show();
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


    private void switchEditable() {
        setIsEditable(!getIsEditable());

        for (ClsReply clsReply : mClsReplyList) {
            clsReply.setIsCheckBoxVisible(getIsEditable());
            clsReply.setIsChecked(false);
        }
        mAdapter.notifyDataSetChanged();
        btnDelete.setVisibility(View.GONE);
    }

    public boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(boolean editable) {
        isEditable = editable;
    }
}