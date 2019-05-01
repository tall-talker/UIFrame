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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.oridway.www.uiframe.R;
import com.yalantis.ucrop.UCrop;
import com.yanzhenjie.album.Album;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 更换Logo页面
 *
 * @author cgl
 * @since 2019/04/11
 */
public class SectionChangeLogoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SectionChangeLogoActiv";
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
    private String path;
    private File tagFile;
    private File srcFile;
    private String sectionLogoUrl;

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
//        Glide.with(mContext).load(sectionParcelable.getSectionLogo()).into(uploadLogo);
    }

    protected void initView() {
        title.setText("更换板块logo");
        Drawable deleteMenu = getResources().getDrawable(R.drawable.ic_delete_black_24dp);
        filter.setCompoundDrawablesWithIntrinsicBounds(deleteMenu, null, null, null);

        Drawable submitMenu = getResources().getDrawable(R.drawable.ic_send_black_24dp);
        edit.setCompoundDrawablesWithIntrinsicBounds(submitMenu, null, null, null);
    }

    protected void initListener() {
        sectionLogo.setOnClickListener(this);
        sectionDesc.setEnabled(false);
        sectionManager.setEnabled(false);
        sectionTitle.setEnabled(false);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.title_left) {
            finish();
        }

        if (v.getId() == R.id.section_edit_logo) {
            selectPicture(path);
        }

        if (v.getId() == R.id.edit_tv) {
            Toast.makeText(mContext, "logo已更换！", Toast.LENGTH_LONG).show();
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
                            .start(SectionChangeLogoActivity.this, 666);
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
