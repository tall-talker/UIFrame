package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.adpter.RecyclerAdapter;
import com.oridway.www.uiframe.bean.ClsOnlineReport;
import com.oridway.www.uiframe.utils.OnlineReportListCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 编辑状态下长按拖动条目
 * 1.通过ItemTouchHelper.Callback实现长按拖动
 * 2.通过isEditable的值判断是否编辑状态，初值是false
 * 3.切换编辑状态要把isEditable的值取反，并改变复选框图标状态
 * 4.在编辑状态下，按返回键回到非编辑状态
 * 5.RecyclerView的点击事件通过RecyclerAdapter.Callback实现
 */

public class ReportListActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ReportListActivity";

    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView backButton;
    @BindView(R.id.online_report_listview)
    RecyclerView mRecyclerView;
    @BindView(R.id.edit_tv)
    TextView edit;
    @BindView(R.id.filter_tv)
    TextView filter;
    @BindView(R.id.btn_delete)
    TextView delete;
    @BindView(R.id.btn_release)
    TextView release;
    @BindView(R.id.btn_close)
    TextView close;
    @BindView(R.id.btn_top)
    TextView top;
    @BindView(R.id.toolbar)
    LinearLayout mToolbar;

    private Context mContext;
    private boolean isEditable;
    private RecyclerAdapter mAdapter;
    private List<ClsOnlineReport> mClsOnlineReportList;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_report);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    private void initData() {
        mContext = this;

        mClsOnlineReportList = new ArrayList<>();
        mAdapter = new RecyclerAdapter(mClsOnlineReportList);
        mRecyclerView.setAdapter(mAdapter);

        getOfflineData(20);

        //初始状态为非编辑模式
        setIsEditable(false);
        //初始化拖动接口
        OnlineReportListCallback callback = new OnlineReportListCallback(mAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);

        //初始状态为不可拖动
        setRecyclerViewDraggable(false);
    }

    //生成模拟数据
    private void getOfflineData(int num) {
        List<ClsOnlineReport> clsOnlineReportList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            ClsOnlineReport onlineReport = new ClsOnlineReport();
            onlineReport.setActiveDate("activeDate " + i);
            onlineReport.setAutoCloseDate("autoCloseDate " + i);
            onlineReport.setBulletinID("bulletinID " + i);
            onlineReport.setBulletinTime("bulletinTime " + i);
            onlineReport.setBulletinTitle("bulletinTitle " + i);
            onlineReport.setCreater("creater " + i);
            clsOnlineReportList.add(onlineReport);
        }

        mClsOnlineReportList.addAll(clsOnlineReportList);
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        title.setText("可拖拽列表");
        edit.setVisibility(View.VISIBLE);

        mToolbar.setVisibility(View.GONE);
        //设置RecyclerView的布局
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void initListener() {
        filter.setOnClickListener(this);
        backButton.setOnClickListener(this);
        edit.setOnClickListener(this);
        delete.setOnClickListener(this);
        release.setOnClickListener(this);
        close.setOnClickListener(this);
        top.setOnClickListener(this);


        mAdapter.setmCallback((v, position) -> {
            switch (v.getId()) {
                case R.id.view_parent_1:
                case R.id.view_parent_2:
                    ClsOnlineReport clsOnlineReport = mClsOnlineReportList.get(position);

                    //在编辑模式下，点击条目切换显示checkbox，并且判断选中条目的数量，
                    if (getIsEditable()) {
                        if (clsOnlineReport.getIsCheckBoxVisible()) {
                            clsOnlineReport.setIsChecked(!clsOnlineReport.getIsChecked());
                            mAdapter.notifyDataSetChanged();
                        }

                        for (int i = 0; i < mClsOnlineReportList.size(); i++) {
                            //数量等于0，隐藏工具条，否则显示工具条
                            ClsOnlineReport onlineReport = mClsOnlineReportList.get(i);
                            if (onlineReport.getIsChecked()) {
                             mToolbar.setVisibility(View.VISIBLE);
                                break;
                            }
                            if (i == mClsOnlineReportList.size() - 1) {
                                mToolbar.setVisibility(View.GONE);
                            }
                        }
                    } else {
                        //在非编辑模式下，点击条目直接跳转详情页，并把bulletinID传过去
                        Intent intent = new Intent(mContext, ReportDetailActivity.class);
                        intent.putExtra("bulletinID", clsOnlineReport.getBulletinID());
                        startActivityForResult(intent, 16371);
                    }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //编辑状态下，按返回键回到非编辑状态，否则退出
        if (getIsEditable()) {
            switchEditable();
        } else {
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        //编辑状态下，按返回键回到非编辑状态，否则退出
        if (v.getId() == R.id.title_left) {
            if (getIsEditable()) {
                switchEditable();
            } else {
                finish();
            }
        }
        //点击编辑按钮切换编辑状态
        if (v.getId() == R.id.edit_tv) {
            switchEditable();
        }

        //工具条的按钮对应不同的接口
        switch (v.getId()) {
            case R.id.btn_top:
            case R.id.btn_close:
            case R.id.btn_release:
            case R.id.btn_delete:
                Toast.makeText(mContext, "在此处调用接口", Toast.LENGTH_SHORT).show();
        }

    }

    private void switchEditable() {

        //将属性取反
        setIsEditable(!getIsEditable());

        //遍历列表并赋值
        for (ClsOnlineReport clsOnlineReport : mClsOnlineReportList) {
            clsOnlineReport.setIsCheckBoxVisible(getIsEditable());
            clsOnlineReport.setIsChecked(false);
        }

        //通知适配器刷新
        mAdapter.notifyDataSetChanged();
        //隐藏工具条
        mToolbar.setVisibility(View.GONE);
        //切换拖动状态
        setRecyclerViewDraggable(getIsEditable());
    }

    public boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    //设置能否拖动
    private void setRecyclerViewDraggable(boolean draggable) {
        if (draggable) {
            itemTouchHelper.attachToRecyclerView(mRecyclerView);
        } else {
            itemTouchHelper.attachToRecyclerView(null);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        //当详情页的数据有变动则刷新列表
        if (requestCode == 16371 && resultCode == RESULT_OK) {
            refreshData();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void refreshData() {
        Toast.makeText(mContext, "在此处调用接口", Toast.LENGTH_SHORT).show();
    }
}
