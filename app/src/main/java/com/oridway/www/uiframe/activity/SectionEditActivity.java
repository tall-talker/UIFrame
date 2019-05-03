package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oridway.www.uiframe.R;
import com.yalantis.ucrop.UCrop;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionEditActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SectionEditActivity";
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
    private String sectionLogoUrl;
    private String path;
    private File tagFile;
    private File srcFile;
    private String userID;

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
        path = Environment.getExternalStorageDirectory() + "/CropPictures";
    }

    protected void initView() {
        title.setText("编辑板块");
        filter.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_delete_black_24dp, 0, 0, 0);
        edit.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_send_black_24dp, 0, 0, 0);
    }

    protected void initListener() {

        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        filter.setOnClickListener(this);
        sectionManager.setOnClickListener(this);
        sectionLogo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.title_left) {
            finish();
        }
        if (v.getId() == R.id.filter_tv) {
            finish();
        }
        if (v.getId() == R.id.section_edit_logo) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(intent, 16352);
        }
        if (v.getId() == R.id.edit_tv) {

        }
        if (v.getId() == R.id.section_edit_manager) {
            Intent intent = new Intent(mContext, UserSelectActivity.class);
            intent.putExtra("isMultipleEnable", false);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 16352 && resultCode == RESULT_OK) {
            Glide.with(mContext).load(data.getData()).into(sectionLogo);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
