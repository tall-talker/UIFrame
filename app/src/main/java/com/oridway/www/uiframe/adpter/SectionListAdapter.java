package com.oridway.www.uiframe.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsSection;

import java.util.List;

public class SectionListAdapter extends BaseAdapter {

    private static final String TAG = "SectionListAdapter";

    private List<ClsSection> mList;
    private LayoutInflater mInflater;

    public SectionListAdapter(List<ClsSection> mList, Context mContext) {
        this.mList = mList;
        mInflater = LayoutInflater.from(mContext);
    }

    public interface Callback {
        void onClick(View v);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public ClsSection getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClsSection clsSection = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_section_list, null);
            holder = new ViewHolder();
            holder.logo = convertView.findViewById(R.id.img_section_item);
            holder.desc = convertView.findViewById(R.id.txt_section_desc);

            holder.name = convertView.findViewById(R.id.txt_section_name);
            holder.owner = convertView.findViewById(R.id.section_owner);
            holder.replyNum = convertView.findViewById(R.id.reply_num);
            holder.themeNum = convertView.findViewById(R.id.theme_num);

            holder.checkBox = convertView.findViewById(R.id.section_check_box);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.logo.setImageResource(R.drawable.logo);
        holder.name.setText("名称：" + clsSection.getSectionName());
        holder.owner.setText("版主：" + clsSection.getSectionManager());
        holder.themeNum.setText("主题：10");
        holder.replyNum.setText("回复：10");

        holder.desc.setText("内容：" + clsSection.getSectionDesc());
        holder.checkBox.setTag(position);

        if (clsSection.getIsCheckBoxVisible()) {
            holder.checkBox.setVisibility(View.VISIBLE);
        } else {
            holder.checkBox.setVisibility(View.GONE);
        }

        if (clsSection.getIsChecked()) {
            holder.checkBox.setImageResource(R.drawable.ic_check_box_black_24dp);
        } else {
            holder.checkBox.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }

        return convertView;
    }

    private class ViewHolder {
        ImageView logo;
        TextView desc;
        ImageView checkBox;
        TextView themeNum;
        TextView replyNum;
        TextView owner;
        TextView name;
    }
}