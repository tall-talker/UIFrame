package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportDetailActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView backButton;

    private Context mContext;

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
