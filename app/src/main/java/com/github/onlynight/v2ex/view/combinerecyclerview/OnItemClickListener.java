package com.github.onlynight.v2ex.view.combinerecyclerview;

import android.view.View;

public interface OnItemClickListener<T> {

    void onItemClick(View view, T data, int position);

}
