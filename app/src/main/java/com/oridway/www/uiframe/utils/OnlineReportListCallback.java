package com.oridway.www.uiframe.utils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * 用来完成RecyclerView长按拖拽的关键接口
 * 1.getMovementFlags里面表示设置为上下拖动
 * 2.onSelectedChanged里面表示拖动状态下改变背景色，拖动完成后恢复背景色
 * 3.拖动完成的时候viewHolder的值为空！！！所以要用srcHolder
 */
public class OnlineReportListCallback extends ItemTouchHelper.Callback {

    private ColorDrawable drawable;
    private RecyclerView.ViewHolder srcHolder;

    public interface ItemTouchMoveListener {
        boolean onItemMove(int fromPosition, int toPosition);
    }

    private ItemTouchMoveListener moveListener;

    public OnlineReportListCallback(ItemTouchMoveListener moveListener) {
        this.moveListener = moveListener;

        int rgb = Color.rgb(0xff, 0xff, 0xff);
        drawable = new ColorDrawable(rgb);
    }


    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        return makeMovementFlags(dragFlags, ItemTouchHelper.ACTION_STATE_IDLE);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder srcHolder, RecyclerView.ViewHolder targetHolder) {

        this.srcHolder = srcHolder;
        return srcHolder.getItemViewType() == targetHolder.getItemViewType() && moveListener.onItemMove(srcHolder.getAdapterPosition(), targetHolder.getAdapterPosition());
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {

        super.onSelectedChanged(viewHolder, actionState);

        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            viewHolder.itemView.setBackground(null);
        }

        if (actionState == ItemTouchHelper.ACTION_STATE_IDLE) {
            srcHolder.itemView.setBackground(drawable);
        }
    }
}
