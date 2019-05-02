package com.oridway.www.uiframe.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsNormalUser;

import java.util.List;

public class UserNormalListAdapter extends BaseAdapter {

    private List<ClsNormalUser> mList;
    private Context mContext;
    private LayoutInflater mInflater;

    public UserNormalListAdapter(List<ClsNormalUser> list, Context context) {
        mContext = context;
        mList = list;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public ClsNormalUser getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup root) {
        ItemHolder holder;
        ClsNormalUser clsNormalUser = mList.get(position);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_alluser_sys, null);
            holder = new ItemHolder();
            holder.id = convertView.findViewById(R.id.user_id);
            holder.name = convertView.findViewById(R.id.user_name);
            holder.org = convertView.findViewById(R.id.user_org);
            holder.status = convertView.findViewById(R.id.user_status);

            holder.checkBox = convertView.findViewById(R.id.user_checkbox);
            convertView.setTag(holder);
        } else {
            holder = (ItemHolder) convertView.getTag();
        }

        holder.id.setText(clsNormalUser.getUserID());
        holder.name.setText(clsNormalUser.getCName());
        holder.org.setText(clsNormalUser.getOrgName());


        if (clsNormalUser.getIsCheckBoxVisible()) {
            holder.checkBox.setVisibility(View.VISIBLE);
        } else {
            holder.checkBox.setVisibility(View.INVISIBLE);
        }

        if (clsNormalUser.getIsChecked()) {
            holder.checkBox.setImageResource(R.drawable.ic_check_box_black_24dp);
        } else {
            holder.checkBox.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }

        holder.status.setText(clsNormalUser.getIsOff());

        return convertView;
    }

    class ItemHolder {
        TextView id;
        TextView name;
        TextView org;
        TextView status;
        ImageView checkBox;
    }
}
