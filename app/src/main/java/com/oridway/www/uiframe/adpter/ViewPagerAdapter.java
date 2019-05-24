package com.oridway.www.uiframe.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oridway.www.uiframe.R;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter implements View.OnClickListener {

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
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        ImageView imageView = (ImageView) inflater.inflate(R.layout.item_image_pager, null);
        int realPosition = position % mList.size();
        imageView.setImageResource(mList.get(realPosition));
        imageView.setOnClickListener(this);
        imageView.setTag(realPosition);

        return imageView;
    }

    @Override
    public void onClick(View v) {
        mCallback.onClick(v, (int) v.getTag());
    }
}
