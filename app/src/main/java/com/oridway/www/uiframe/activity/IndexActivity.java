package com.oridway.www.uiframe.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.adpter.CandidateListAdapter;
import com.oridway.www.uiframe.adpter.ViewPagerAdapter;
import com.oridway.www.uiframe.bean.Candidate;
import com.oridway.www.uiframe.utils.ListViewForScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndexActivity extends AppCompatActivity {

    @BindView(R.id.title_left)
    ImageView titleLeft;
    @BindView(R.id.tv_title_middle)
    TextView tvTitleMiddle;
    @BindView(R.id.add_tv)
    TextView addTv;
    @BindView(R.id.filter_tv)
    TextView filterTv;
    @BindView(R.id.edit_tv)
    TextView editTv;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.lvfsv)
    ListViewForScrollView lvfsv;
    @BindView(R.id.index)
    TextView index;
    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.community)
    TextView community;
    @BindView(R.id.self)
    TextView self;
    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    @BindView(R.id.sv)
    ScrollView scrollView;

    private Context mContext;
    private List<Integer> mImageList;
    private List<Candidate> mCandidateList;
    private ViewPagerAdapter mPagerAdapter;
    private CandidateListAdapter mListAdapter;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            vp.setCurrentItem(vp.getCurrentItem() + 1);
            handler.sendEmptyMessageDelayed(0x123, 2000);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this);

        initData();
        initView();
        intListener();
    }

    private void initData() {

        mContext = this;
        mImageList = new ArrayList<>();
        mCandidateList = new ArrayList<>();
        mListAdapter = new CandidateListAdapter(mCandidateList);
        mPagerAdapter = new ViewPagerAdapter(mImageList);
        lvfsv.setAdapter(mListAdapter);
        vp.setAdapter(mPagerAdapter);

        getListData(10);
        getPagerData();

        handler.sendEmptyMessageDelayed(0x123, 2000);
    }

    private void getPagerData() {

        mImageList.add(R.drawable.bm1);
        mImageList.add(R.drawable.bm2);
        mImageList.add(R.drawable.bm3);
        mImageList.add(R.drawable.bm4);
        mImageList.add(R.drawable.bm5);
        mImageList.add(R.drawable.bm6);

        mPagerAdapter.notifyDataSetChanged();
        vp.setCurrentItem(mPagerAdapter.getCount() / 2);
    }

    private void getListData(int num) {

        for (int i = 0; i < num; i++) {
            Candidate candidate = new Candidate();
            candidate.setName("name: " + 1111111111);
            candidate.setInfo("info: " + 1111111111);
            candidate.setTrait("trait: " + 1111111111);
            mCandidateList.add(candidate);
        }

        mListAdapter.notifyDataSetChanged();
    }

    private void initView() {
        tvTitleMiddle.setText("轮播列表");
        scrollView.smoothScrollTo(0, 0);
    }

    private void intListener() {

        mPagerAdapter.setmCallback((v, position) -> {
            Toast.makeText(mContext, "position: " + position, Toast.LENGTH_SHORT).show();
        });
    }
}
