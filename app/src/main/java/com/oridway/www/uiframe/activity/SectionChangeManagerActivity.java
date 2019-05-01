package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 更换版主页面
 *
 * @author cgl
 * @since 2019/04/11
 */
public class SectionChangeManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SectionChangeManagerAct";
    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView back;
    @BindView(R.id.edit_tv)
    TextView edit;
    @BindView(R.id.filter_tv)
    TextView filter;
    @BindView(R.id.section_edit_logo)
    ImageView sectionLogo;
    @BindView(R.id.section_edit_manager)
    TextView sectionManager;
    @BindView(R.id.section_edit_title)
    TextView sectionTitle;
    @BindView(R.id.section_edit_desc)
    TextView sectionDesc;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_edit);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    protected void initData() {
        mContext = this;

    }

    protected void initView() {

        title.setText("更换版主");
        Drawable deleteMenu = getResources().getDrawable(R.drawable.ic_delete_black_24dp);
        filter.setCompoundDrawablesWithIntrinsicBounds(deleteMenu, null, null, null);

        Drawable submitMenu = getResources().getDrawable(R.drawable.ic_send_black_24dp);
        edit.setCompoundDrawablesWithIntrinsicBounds(submitMenu, null, null, null);
    }

    protected void initListener() {
        back.setOnClickListener(this);
        sectionTitle.setEnabled(false);
        sectionDesc.setEnabled(false);
        sectionManager.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.title_left) {
            finish();
        }

        if (v.getId() == R.id.section_edit_manager) {
            Intent intent = new Intent(mContext, UserSelectActivity.class);
            intent.putExtra("isMultipleEnable", false);
            startActivity(intent);
        }
    }
}
