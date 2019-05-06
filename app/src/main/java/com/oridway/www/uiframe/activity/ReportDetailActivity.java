package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsOnlineReport;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 可拖拽列表的详情
 */
public class ReportDetailActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView backButton;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.tv8)
    TextView tv8;

    @BindView(R.id.delete)
    TextView delete;
    @BindView(R.id.edit)
    TextView edit;
    @BindView(R.id.close)
    TextView close;
    @BindView(R.id.open)
    TextView open;

    private Context mContext;
    private String bulletinID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_detail);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    private void initView() {
        title.setText("详情页");
    }

    private void initData() {
        mContext = this;
        bulletinID = getIntent().getStringExtra("bulletinID");
        getData(bulletinID);
    }

    private void getData(String bulletinID) {
        Toast.makeText(mContext, "在此处调用接口", Toast.LENGTH_SHORT).show();

        tv1.setText("此处展示数据");
        tv2.setText("此处展示数据");
        tv3.setText("此处展示数据");
        tv4.setText("此处展示数据");
        tv5.setText("此处展示数据");
        tv6.setText("此处展示数据");
        tv7.setText("此处展示数据");
        tv8.setText("此处展示数据");
    }

    private void initListener() {
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.title_left) {
            finish();
        }
    }
}
