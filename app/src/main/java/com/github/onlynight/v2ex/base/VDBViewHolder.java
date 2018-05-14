package com.github.onlynight.v2ex.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class VDBViewHolder<VDB extends ViewDataBinding, Data> extends RecyclerView.ViewHolder {

    public VDB viewDataBinding;

    public VDBViewHolder(VDB viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
    }

    public abstract void bindData(Data data, int position);

    public static <VDB extends ViewDataBinding> VDB createDataBinding(@LayoutRes int layoutId, ViewGroup parent) {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                layoutId, parent, false);
    }

}
