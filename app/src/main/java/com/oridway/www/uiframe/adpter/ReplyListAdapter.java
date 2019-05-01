package com.oridway.www.uiframe.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsReply;

import java.util.List;

public class ReplyListAdapter extends BaseAdapter {

    private static final String TAG = "ReplyListAdapter";

    private List<ClsReply> mList;
    private LayoutInflater mInflater;

    public ReplyListAdapter(List<ClsReply> mList, Context mContext) {
        this.mList = mList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public ClsReply getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClsReply clsReply = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_reply_list, null);
            holder = new ViewHolder();
            holder.man = convertView.findViewById(R.id.reply_man);
            holder.time = convertView.findViewById(R.id.reply_time);
            holder.content = convertView.findViewById(R.id.reply_content);
            holder.checkbox = convertView.findViewById(R.id.reply_checkbox);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (clsReply.getIsCheckBoxVisible()) {
            holder.checkbox.setVisibility(View.VISIBLE);
        } else {
            holder.checkbox.setVisibility(View.INVISIBLE);
        }

        if (clsReply.getIsChecked()) {
            holder.checkbox.setImageResource(R.drawable.ic_check_box_black_24dp);
        } else {
            holder.checkbox.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }

        holder.man.setText(clsReply.getReplyManName());
        holder.time.setText(clsReply.getReplyTime());
        holder.content.setText(clsReply.getReplyContent());

        return convertView;
    }

    private class ViewHolder {
        TextView content;
        TextView man;
        TextView time;
        ImageView checkbox;
    }
}