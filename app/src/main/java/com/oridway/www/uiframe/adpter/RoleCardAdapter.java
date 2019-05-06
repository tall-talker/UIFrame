package com.oridway.www.uiframe.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsRole;

import java.util.List;

public class RoleCardAdapter extends BaseAdapter implements View.OnClickListener {

    private List<ClsRole> mClsRoleList;
    private LayoutInflater mInflater;
    private Callback mCallback;

    @Override
    public void onClick(View view) {

        mCallback.onClick(view, (int) view.getTag());
    }

    public interface Callback {

        void onClick(View view, int position);
    }

    public void setmCallback(Callback mCallback) {
        this.mCallback = mCallback;
    }

    public RoleCardAdapter(Context mContext, List<ClsRole> mClsRoleList) {
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
            convertView = mInflater.inflate(R.layout.item_role_card, null);
            holder = new ItemHolder();
            holder.name = convertView.findViewById(R.id.tv_role_name);
            holder.desc = convertView.findViewById(R.id.tv_role_desc);
            holder.delete = convertView.findViewById(R.id.tv_role_delete);
            convertView.setTag(holder);
        } else {
            holder = (ItemHolder) convertView.getTag();
        }

        holder.name.setText(clsRole.getSysRoleName());
        holder.desc.setText(clsRole.getSysRoleTypeName());
        holder.delete.setOnClickListener(this);
        holder.delete.setTag(position);

        return convertView;
    }

    private class ItemHolder {
        TextView name;
        TextView desc;
        TextView delete;
    }
}
