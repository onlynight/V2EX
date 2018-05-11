package com.github.onlynight.v2ex.view.combinerecyclerview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by zhangwenda on 2018/3/15.
 */

public class LoadMoreRecyclerView extends RecyclerView {

    private ILoadMore mLoadMorable;

    private int mIsFirstTimes = 0;

    private CombineRecyclerView.OnLoadMoreListener mOnLoadMoreListener;

    private AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {//设置空view原理都一样，没有数据显示空view，有数据隐藏空view
//            Adapter adapter = getAdapter();
//            ViewParent parent = LoadMoreRecyclerView.this.getParent();
//            if (parent instanceof RefreshLayout) {
//                if (mIsFirstTimes >= 1) {
//                    if (adapter.getItemCount() == 0) {
//                        ((RefreshLayout) parent).setEmptyViewVisible(true);
//                        LoadMoreRecyclerView.this.setVisibility(GONE);
//                    } else {
//                        ((RefreshLayout) parent).setEmptyViewVisible(false);
//                        LoadMoreRecyclerView.this.setVisibility(VISIBLE);
//                    }
//                }
//                mIsFirstTimes++;
//            }
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            onChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            onChanged();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            onChanged();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            onChanged();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            onChanged();
        }
    };

    private int mLastVisibleItem = -1;
    private int[] mLastPositions;
    private boolean mIsShowFooter;
    private int mEmptyViewRes = -1;

    public LoadMoreRecyclerView(Context context) {
        super(context);
        initView();
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public void setEmptyView(@LayoutRes int emptyView) {
        this.mEmptyViewRes = emptyView;
    }

    private void initView() {
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                /**
                 * scrollState有三种状态，分别是SCROLL_STATE_IDLE、SCROLL_STATE_TOUCH_SCROLL、SCROLL_STATE_FLING
                 * SCROLL_STATE_IDLE是当屏幕停止滚动时
                 * SCROLL_STATE_TOUCH_SCROLL是当用户在以触屏方式滚动屏幕并且手指仍然还在屏幕上时
                 * SCROLL_STATE_FLING是当用户由于之前划动屏幕并抬起手指，屏幕产生惯性滑动时
                 */
                if (mLoadMorable != null) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE
                            && mLastVisibleItem + 1 == getAdapter().getItemCount()
                            && mIsShowFooter) {

                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadMore();
                        }
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 给lastVisibleItem赋值
                // findLastVisibleItemPosition()是返回最后一个item的位置
                LayoutManager layoutManager = getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    mLastVisibleItem = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                }

                if (layoutManager instanceof GridLayoutManager) {
                    mLastVisibleItem = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                }

                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    if (mLastPositions == null) {
                        mLastPositions = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                    }
                    ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(mLastPositions);
                    mLastVisibleItem = findMaxPosition(mLastPositions);
                }
            }
        });

//        setEmptyView(R.layout.part_no_data);
    }

    private int findMaxPosition(int[] position) {
        if (position == null) {
            return -1;
        }

        int max = -1;
        for (int value : position) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof ILoadMore) {
            mLoadMorable = (ILoadMore) adapter;
        } else {
            throw new RuntimeException("your adapter must implements {@ILoadMore} interface");
        }
        super.setAdapter(adapter);
        adapter.registerAdapterDataObserver(observer);
        observer.onChanged();
    }

    public void setLoadMoreEnable(boolean show) {
        this.mIsShowFooter = show;
        if (mLoadMorable != null) {
            mLoadMorable.showLoadMore(show);
        }
    }

    public void setOnLoadMoreListener(CombineRecyclerView.OnLoadMoreListener onLoadMoreListener) {
        this.mOnLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {

        void onLoadMore();

    }

}
