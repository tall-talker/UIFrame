package com.oridway.www.uiframe.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsTopic;

import java.util.List;

public class TopicListAdapter extends BaseAdapter {

    private List<ClsTopic> mClsTopicList;
    private LayoutInflater mLayoutInflater;

    public TopicListAdapter(List<ClsTopic> mClsTopicList, Context mContext) {
        this.mClsTopicList = mClsTopicList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mClsTopicList.size();
    }

    @Override
    public ClsTopic getItem(int position) {
        return mClsTopicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        ClsTopic clsTopic = getItem(position);

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_topic_list, null);
            holder = new ViewHolder();
            holder.desc = convertView.findViewById(R.id.topic_desc);
            holder.title = convertView.findViewById(R.id.topic_title);
            holder.date = convertView.findViewById(R.id.topic_date);
            holder.checkbox = convertView.findViewById(R.id.topic_checkbox);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (clsTopic.getIsCheckBoxVisible()) {
            holder.checkbox.setVisibility(View.VISIBLE);
        } else {
            holder.checkbox.setVisibility(View.GONE);
        }

        if (clsTopic.getIsChecked()) {
            holder.checkbox.setImageResource(R.drawable.ic_check_box_black_24dp);
        } else {
            holder.checkbox.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }

        holder.title.setText(clsTopic.getTitle());
        holder.desc.setText(clsTopic.getTopicDesc());
        holder.date.setText(clsTopic.getCreateDate());
        return convertView;
    }

    private class ViewHolder {
        ImageView checkbox;
        TextView desc;
        TextView title;
        TextView date;
    }
}