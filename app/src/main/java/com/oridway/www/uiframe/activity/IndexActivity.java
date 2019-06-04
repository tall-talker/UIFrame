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
import android.widget.AdapterView;
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

public class IndexActivity extends AppCompatActivity implements View.OnClickListener{

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
    @BindView(R.id.ivs)
    LinearLayout ivs;

    private Context mContext;
    private List<Integer> mImageList;
    private List<Candidate> mCandidateList;
    private ViewPagerAdapter mPagerAdapter;
    private CandidateListAdapter mListAdapter;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //每次将当前的位置加1，也就是向右滑动一次
            vp.setCurrentItem(vp.getCurrentItem() + 1);
            //递归无限循环调用
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

    //初始化数据源，固定写法 1.实例化容器 2.实例化适配器 3.设置适配器
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

        //间隔2秒发送一次信息
        handler.sendEmptyMessageDelayed(0x123, 2000);
    }

    //生成ViewPager数据源
    private void getPagerData() {
        mImageList.add(R.drawable.bm1);
        mImageList.add(R.drawable.bm2);
        mImageList.add(R.drawable.bm3);
        mImageList.add(R.drawable.bm4);
        mImageList.add(R.drawable.bm5);
        mImageList.add(R.drawable.bm6);

        mPagerAdapter.notifyDataSetChanged();
        //初始的位置在正中间
        vp.setCurrentItem(mPagerAdapter.getCount() / 2);
    }

    //生成ListView数据源
    private void getListData(int num) {
        for (int i = 0; i < num; i++) {
            Candidate candidate = new Candidate();
            candidate.setName("姓名:尼尔斯·亨利克·戴维·玻尔");
            candidate.setInfo("职业:学者,物理学家,足球运动员");
            candidate.setTrait("成就:哥本哈根学派的创始人,1922年获得诺贝尔物理学奖");
            mCandidateList.add(candidate);
        }

        mListAdapter.notifyDataSetChanged();
    }

    private void initView() {
        tvTitleMiddle.setText("轮播列表");
        scrollView.smoothScrollTo(0, 0);
    }

    //初始化监听
    private void intListener() {
        mPagerAdapter.setmCallback((v, position) -> {
            Toast.makeText(mContext, "position: " + position, Toast.LENGTH_SHORT).show();
        });

        lvfsv.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(mContext, "position: " + position, Toast.LENGTH_SHORT).show();
        });

        for (int i = 0; i < 4; i++) {
            ivs.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iv1:
            case R.id.iv2:
            case R.id.iv3:
            case R.id.iv4:
                Toast.makeText(mContext, "此处跳转", Toast.LENGTH_SHORT).show();
        }
    }
}
