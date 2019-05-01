package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import com.yanzhenjie.album.Album;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 论坛新建板块页面
 *
 * @author cgl
 * @since 2019/04/10
 */

public class SectionNewActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SectionNewActivity";
    @BindView(R.id.tv_title_middle)
    TextView title;
    @BindView(R.id.title_left)
    ImageView back;
    @BindView(R.id.edit_tv)
    TextView edit;
    @BindView(R.id.filter_tv)
    TextView filter;
    @BindView(R.id.section_new_logo)
    ImageView sectionLogo;
    @BindView(R.id.section_new_manager)
    TextView sectionManager;
    @BindView(R.id.section_new_title)
    TextView sectionTitle;
    @BindView(R.id.section_new_desc)
    TextView sectionDesc;

    private Context mContext;
    private String path;
    private File tagFile;
    private File srcFile;
    private String userID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_new);
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
        title.setText("新建板块");

        filter.setVisibility(View.VISIBLE);
        Drawable deleteMenu = getResources().getDrawable(R.drawable.ic_delete_black_24dp);
        filter.setCompoundDrawablesWithIntrinsicBounds(deleteMenu, null, null, null);

        edit.setVisibility(View.VISIBLE);
        Drawable submitMenu = getResources().getDrawable(R.drawable.ic_send_black_24dp);
        edit.setCompoundDrawablesWithIntrinsicBounds(submitMenu, null, null, null);
    }

    protected void initListener() {

        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        filter.setOnClickListener(this);
        sectionLogo.setOnClickListener(this);
        sectionManager.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.title_left) {
            finish();
        }
        if (v.getId() == R.id.filter_tv) {
            finish();
        }
        if (v.getId() == R.id.edit_tv) {
        }
        if (v.getId() == R.id.section_new_logo) {
            selectPicture(path);
        }
        if (v.getId() == R.id.section_new_manager) {
            Intent intent = new Intent(mContext, UserSelectActivity.class);
            intent.putExtra("isMultipleEnable", false);
            startActivity(intent);
        }
    }

    private void selectPicture(String path) {
        Album.image(this)
                .multipleChoice()
                .camera(true)
                .columnCount(4)
                .selectCount(1)
                .afterFilterVisibility(true)
                .onResult(result -> {
                    srcFile = new File(result.get(0).getPath());
                    tagFile = new File(path + "/" + srcFile.getName());
                    Log.e(TAG, "tagFile delete: " + tagFile.delete());

                    UCrop.of(Uri.fromFile(srcFile), Uri.fromFile(tagFile))
                            .start(SectionNewActivity.this, 666);
                }).start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 666 && resultCode == RESULT_OK) {
            Glide.with(mContext).load(tagFile).into(sectionLogo);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
