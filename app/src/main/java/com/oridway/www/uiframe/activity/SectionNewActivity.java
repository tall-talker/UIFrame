package com.oridway.www.uiframe.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yalantis.ucrop.util.FileUtils.getPath;

/**
 * 新建一个第一级列表的条目
 * 1.选择图片和附件都用Intent.ACTION_GET_CONTENT实现
 * 2.打开文件用Intent.ACTION_VIEW实现
 * 3.回传的URI需要转化成真实路径
 * 4.提交数据之后需要刷新列表
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

    private void initData() {
        mContext = this;

        mAttachList = new ArrayList<>();
        mAdapter = new AttachmentListAdapter(mAttachList, mContext);
        mListView.setAdapter(mAdapter);
    }

    private void initView() {
        title.setText("新建板块");

        edit.setVisibility(View.VISIBLE);
        edit.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_send_black_24dp, 0, 0, 0);
    }

    private void initListener() {

        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        filter.setOnClickListener(this);
        sectionLogo.setOnClickListener(this);
        sectionManager.setOnClickListener(this);
        selectAttach.setOnClickListener(this);

        //点击附件列表条目的删除按钮，删除对应附件
        mAdapter.setmCallback((view, position) -> {
            mAttachList.remove(position);
            mAdapter.notifyDataSetChanged();
        });


        //点击附件列表弹出打开方式
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
            //打开手机原生的浏览器，并且选取内容
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            //文件类型为图片
            intent.setType("image/*");
            startActivityForResult(intent, 16352);
        }
        if (v.getId() == R.id.section_new_manager) {
            Intent intent = new Intent(mContext, UserSelectActivity.class);
            startActivityForResult(intent, 12345);
        }

        if (v.getId() == R.id.tv_upload_attach) {

            //上传的附件数量不能超过4个
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
    //requestCode要对应上，resultCode都为默认值RESULT_OK
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //选择图片完成之后使用glide加载到控件上，此处有时需要把图片上传给后台
        //提交数据的时候传图片在后台的路径
        if (requestCode == 16352 && resultCode == RESULT_OK) {
            Glide.with(mContext).load(data.getData()).into(sectionLogo);
        }

        //打开选择用户的页面，根据传的参数不同页面也不同，默认是单选页面
        if (requestCode == 12345 && resultCode == RESULT_OK) {
            ClsNormalUser user = data.getParcelableExtra("user");
            sectionManager.setText(user.getCName());
        }

        //遍立已经上传的附件列表，如果已经存在就弹出提示
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
        //这里使用第三方库ucrop的getPath方法，也可以自己实现uri转换为path
        File file = new File(getPath(mContext, data.getData()));

        ClsAttachMent clsAttachMent = new ClsAttachMent();
        String name = file.getName();
        String type = name.split("\\.")[1];
        String size = file.length() + "";
        clsAttachMent.setSize(size);
        clsAttachMent.setFilename(name);
        clsAttachMent.setUri(data.getData().toString());

        //这里需要调用上传接口
        uploadFile(file.getPath());

        mAttachList.add(clsAttachMent);
        mAdapter.notifyDataSetChanged();
    }

    private void uploadFile(String path) {
        Toast.makeText(mContext, "在此处调用接口！", Toast.LENGTH_SHORT).show();
    }
}
