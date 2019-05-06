package com.oridway.www.uiframe.adpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsAttachMent;

import java.util.List;


public class AttachmentListAdapter extends BaseAdapter {

    private List<ClsAttachMent> mList;
    private LayoutInflater mInflater;
    private Callback mCallback;

    public interface Callback {

        void onClick(View view, int position);
    }

    public AttachmentListAdapter(List<ClsAttachMent> attachments, Context mContext) {
        this.mList = attachments;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setmCallback(Callback mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public ClsAttachMent getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClsAttachMent clsAttachMent = mList.get(position);
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_attchment_list, null);
            holder.delete = convertView.findViewById(R.id.attachment_delete);
            holder.name = convertView.findViewById(R.id.attachment_name);
            holder.size = convertView.findViewById(R.id.attachment_size);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(clsAttachMent.getFilename());
        long length = Long.parseLong(clsAttachMent.getSize());
        holder.size.setText(length / 1024 + "KB");
        holder.delete.setTag(position);

        holder.delete.setOnClickListener(v -> {
            mCallback.onClick(v, (Integer) v.getTag());
        });
        return convertView;
    }

    private class ViewHolder {

        TextView name;
        TextView size;
        TextView delete;
    }
}
