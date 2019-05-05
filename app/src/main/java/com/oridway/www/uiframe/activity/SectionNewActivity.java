package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.adpter.AttachmentListAdapter;
import com.oridway.www.uiframe.bean.ClsAttachMent;
import com.oridway.www.uiframe.bean.ClsNormalUser;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yalantis.ucrop.util.FileUtils.getPath;

/**
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
    @BindView(R.id.tv_upload_attach)
    TextView selectAttach;
    @BindView(R.id.lv_attach)
    ListView mListView;

    private Context mContext;
    private List<ClsAttachMent> mAttachList;
    private AttachmentListAdapter mAdapter;

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

        mAttachList = new ArrayList<>();
        mAdapter = new AttachmentListAdapter(mAttachList, mContext);
        mListView.setAdapter(mAdapter);
    }

    protected void initView() {
        title.setText("新建板块");

        filter.setVisibility(View.VISIBLE);
        filter.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_delete_black_24dp, 0, 0, 0);

        edit.setVisibility(View.VISIBLE);
        edit.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_send_black_24dp, 0, 0, 0);
    }

    protected void initListener() {

        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        filter.setOnClickListener(this);
        sectionLogo.setOnClickListener(this);
        sectionManager.setOnClickListener(this);
        selectAttach.setOnClickListener(this);

        mAdapter.setmCallback((view, position) -> {
            mAttachList.remove(position);
            mAdapter.notifyDataSetChanged();
        });

        mListView.setOnItemClickListener((parent, view, position, id) -> {

            ClsAttachMent clsAttachMent = mAttachList.get(position);
            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);

            intent.setDataAndType(Uri.parse(clsAttachMent.getUri()), "*/*");
            startActivity(intent);
        });
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
            submit();
        }
        if (v.getId() == R.id.section_new_logo) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(intent, 16352);
        }
        if (v.getId() == R.id.section_new_manager) {
            Intent intent = new Intent(mContext, UserSelectActivity.class);
            startActivityForResult(intent, 12345);
        }

        if (v.getId() == R.id.tv_upload_attach) {

            if (mAttachList.size() < 4) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");
                startActivityForResult(intent, 12367);

                if (mAttachList.size() == 0) {
                    Toast.makeText(mContext, R.string.upload_warning, Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(mContext, "附件数量已达上限！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void submit() {
        Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 16352 && resultCode == RESULT_OK) {
            Glide.with(mContext).load(data.getData()).into(sectionLogo);
        }

        if (requestCode == 12345 && resultCode == RESULT_OK) {
            ClsNormalUser user = data.getParcelableExtra("user");
            sectionManager.setText(user.getCName());
        }

        if (requestCode == 12367 && resultCode == RESULT_OK) {
            String uri = data.getData().toString();

            if (mAttachList.size() > 0) {
                for (int i = 0; i < mAttachList.size(); i++) {
                    if (uri.equals(mAttachList.get(i).getUri())) {
                        Toast.makeText(mContext, "请选择不同文件！", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (i == mAttachList.size() - 1) {
                        addAttach(data);
                        break;
                    }
                }
            } else {
                addAttach(data);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void addAttach(Intent data) {
        File file = new File(getPath(mContext, data.getData()));

        if (file.length() / 1024 / 1024.0 < 5.0) {
            ClsAttachMent clsAttachMent = new ClsAttachMent();
            String name = file.getName();
            String type = name.split("\\.")[1];
            String size = file.length() + "";
            clsAttachMent.setSize(size);
            clsAttachMent.setFilename(name);
            clsAttachMent.setUri(data.getData().toString());

            uploadFile(file.getPath());

            mAttachList.add(clsAttachMent);
            mAdapter.notifyDataSetChanged();
        }
    }

    private void uploadFile(String path) {
        Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
    }
}
