package com.github.onlynight.v2ex.view.combinerecyclerview;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangwenda on 2018/3/15.
 */

public abstract class LoadMoreRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements ILoadMore {

    public static final int VIEW_TYPE_FOOTER = 1;
    public static final int VIEW_TYPE_DEFAULT = 0;

    private boolean mShowLoadMore = false;

    @LayoutRes
    private int mLoadMoreView = -1;

    @Override
    public void setLoadMoreView(@LayoutRes int layout) {
        this.mLoadMoreView = layout;
    }

    @Override
    public void showLoadMore(boolean show) {
        this.mShowLoadMore = show;
    }

    @Override
    public boolean isShowLoadMore() {
        return mShowLoadMore;
    }

    @Override
    public int getItemViewType(int position) {
        if (mShowLoadMore) {
            if (isFooter(position)) {
                return VIEW_TYPE_FOOTER;
            } else {
                return getContentViewType(position);
            }
        } else {
            return getContentViewType(position);
        }
    }

    @Override
    public boolean isFooter(int position) {
        return mShowLoadMore && position + 1 == getItemCount();
    }

    @Override
    public int getContentViewType(int position) {
        return VIEW_TYPE_DEFAULT;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == VIEW_TYPE_FOOTER) {
            onBindFooter(holder, position);
        } else {
            onBindItem(holder, position);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_FOOTER) {
            return onCreateFooterViewHolder(parent, viewType);
        } else {
            return onCreateItemViewHolder(parent, viewType);
        }
    }

    protected abstract RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType);

    protected FooterViewHolder onCreateFooterViewHolder(ViewGroup parent, int viewType) {
        return new FooterViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(mLoadMoreView, parent, false));
    }

    protected abstract void onBindItem(RecyclerView.ViewHolder holder, int position);

    protected void onBindFooter(RecyclerView.ViewHolder holder, int position) {
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }

    }

    public static class DefaultViewHolder extends RecyclerView.ViewHolder {

        public DefaultViewHolder(View contentView) {
            super(contentView);
        }

    }

}
