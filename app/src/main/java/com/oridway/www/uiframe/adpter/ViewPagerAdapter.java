package com.oridway.www.uiframe.adpter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oridway.www.uiframe.R;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter implements View.OnClickListener {

    //图片的资源id列表
    private List<Integer> mList;
    private Callback mCallback;

    public ViewPagerAdapter(List<Integer> mList) {
        this.mList = mList;
    }

    public void setmCallback(Callback mCallback) {
        this.mCallback = mCallback;
    }

    public interface Callback {
        void onClick(View v, int position);
    }

    @Override
    //将适配器中的数据设为无穷大
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    //固定写法，不覆盖会报错
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    //固定写法
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        ImageView imageView = (ImageView) inflater.inflate(R.layout.item_image_pager, null);

        //将position转换成余数
        int realPosition = position % mList.size();
        imageView.setImageResource(mList.get(realPosition));
        imageView.setOnClickListener(this);
        //tag放跳转需要的数据
        imageView.setTag(realPosition);
        //将实例加入父控件
        container.addView(imageView);
        return imageView;
    }

    @Override
    //使用接口将position回传
    public void onClick(View v) {
        mCallback.onClick(v, (int) v.getTag());
    }
}
