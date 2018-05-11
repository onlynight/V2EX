package com.github.onlynight.v2ex.view.combinerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by zhangwenda on 2018/3/15.
 */

public class CombineRecyclerView extends FrameLayout {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    public LoadMoreRecyclerView mRecyclerView;

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener;
    private OnLoadMoreListener mOnLoadMoreListener;

    public CombineRecyclerView(@NonNull Context context) {
        super(context);
        initView();
    }

    public CombineRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CombineRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @RequiresApi(21)
    public CombineRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        mSwipeRefreshLayout = new SwipeRefreshLayout(getContext());
        mSwipeRefreshLayout.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        mRecyclerView = new LoadMoreRecyclerView(getContext());
        mRecyclerView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mSwipeRefreshLayout.addView(mRecyclerView);

        addView(mSwipeRefreshLayout);
    }

    public void setAdapter(LoadMoreRecyclerAdapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public void setLoadMore(boolean enable) {
        if (mRecyclerView != null) {
            mRecyclerView.setLoadMoreEnable(enable);
        }
    }

    public void setRefreshing(boolean refreshing) {
        mSwipeRefreshLayout.setRefreshing(refreshing);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        if (onRefreshListener != null) {
            mSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        if (onLoadMoreListener != null) {
            mRecyclerView.setOnLoadMoreListener(onLoadMoreListener);
        }
    }

    public interface OnLoadMoreListener {

        void onLoadMore();

    }
}
