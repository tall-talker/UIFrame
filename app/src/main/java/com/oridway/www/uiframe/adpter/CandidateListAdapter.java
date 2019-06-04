package com.oridway.www.uiframe.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.oridway.www.uiframe.R;
import com.oridway.www.uiframe.bean.Candidate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CandidateListAdapter extends BaseAdapter {

    private List<Candidate> mList;
    public CandidateListAdapter(List<Candidate> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Candidate getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        Candidate candidate = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_candidate_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(candidate.getName());
        viewHolder.info.setText(candidate.getInfo());
        viewHolder.trait.setText(candidate.getTrait());

        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.trait)
        TextView trait;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
