package com.oridway.www.uiframe.adpter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.ClsOnlineReport;
import com.oridway.www.uiframe.utils.OnlineReportListCallback;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportOnlineRecyclerAdapter extends RecyclerView.Adapter implements OnlineReportListCallback.ItemTouchMoveListener, View.OnClickListener {

    private List<ClsOnlineReport> mList;
    private Callback mCallback;

    public ReportOnlineRecyclerAdapter(List<ClsOnlineReport> mList, Callback mCallback) {
        this.mList = mList;
        this.mCallback = mCallback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_report_list, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ClsOnlineReport clsOnlineReport = mList.get(position);
        ItemHolder itemHolder = (ItemHolder) holder;

        if (clsOnlineReport.getIsCheckBoxVisible()) {
            itemHolder.checkbox.setVisibility(View.VISIBLE);
            itemHolder.drag.setVisibility(View.VISIBLE);
        } else {
            itemHolder.checkbox.setVisibility(View.GONE);
            itemHolder.drag.setVisibility(View.GONE);
        }

        if (clsOnlineReport.getIsChecked()) {
            itemHolder.checkbox.setImageResource(R.drawable.ic_check_box_black_24dp);
        } else {
            itemHolder.checkbox.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }

        itemHolder.parent1.setTag(position);
        itemHolder.parent2.setTag(position);

        itemHolder.parent1.setOnClickListener(this);
        itemHolder.parent2.setOnClickListener(this);

        itemHolder.time.setText(clsOnlineReport.getBulletinTime());
        itemHolder.title.setText(clsOnlineReport.getBulletinTitle());
        itemHolder.author.setText(clsOnlineReport.getCreater());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.online_report_time)
        TextView time;
        @BindView(R.id.online_report_title)
        TextView title;
        @BindView(R.id.online_report_author)
        TextView author;
        @BindView(R.id.online_report_drag)
        ImageView drag;
        @BindView(R.id.online_report_checkbox)
        ImageView checkbox;
        @BindView(R.id.view_parent_1)
        LinearLayout parent1;
        @BindView(R.id.view_parent_2)
        LinearLayout parent2;

        ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onClick(View v) {
        mCallback.onClick(v, (int) v.getTag());
    }

    public interface Callback {
        void onClick(View v, int position);
    }
}