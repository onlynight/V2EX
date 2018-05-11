package com.github.onlynight.v2ex.view.combinerecyclerview;

import android.support.annotation.LayoutRes;

public interface ILoadMore {

    void setLoadMoreView(@LayoutRes int layout);

    void showLoadMore(boolean show);

    boolean isShowLoadMore();

    int getContentViewType(int position);

    boolean isFooter(int position);

}
