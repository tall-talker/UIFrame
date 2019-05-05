package com.oridway.www.uiframe.adpter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsRole;

import java.util.List;

import static android.graphics.Color.rgb;

public class RoleSelectAdapter extends BaseAdapter {

    private List<ClsRole> mClsRoleList;
    private LayoutInflater mInflater;

    public RoleSelectAdapter(Context mContext, List<ClsRole> mClsRoleList) {
        this.mClsRoleList = mClsRoleList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mClsRoleList.size();
    }

    @Override
    public ClsRole getItem(int position) {
        return mClsRoleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClsRole clsRole = getItem(position);
        ItemHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_role_select, null);
            holder = new ItemHolder();
            holder.name = convertView.findViewById(R.id.tv_role_name);
            holder.desc = convertView.findViewById(R.id.tv_role_desc);
            holder.creator = convertView.findViewById(R.id.tv_role_creator);
            holder.checkbox = convertView.findViewById(R.id.iv_role_checkbox);
            convertView.setTag(holder);
        } else {
            holder = (ItemHolder) convertView.getTag();
        }

        holder.name.setText(clsRole.getSysRoleName());
        holder.desc.setText(clsRole.getSysRoleDesc());
        holder.creator.setText(clsRole.getCreater());

        if (clsRole.getIsChecked()) {
            holder.checkbox.setImageResource(R.drawable.ic_check_box_black_24dp);
        } else {
            holder.checkbox.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }

        return convertView;
    }

    private class ItemHolder {
        ImageView checkbox;
        TextView name;
        TextView desc;
        TextView creator;
    }
}
