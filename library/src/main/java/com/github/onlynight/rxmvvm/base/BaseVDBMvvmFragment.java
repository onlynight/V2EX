package com.github.onlynight.rxmvvm.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.onlynight.rxmvvm.IViewModel;

public abstract class BaseVDBMvvmFragment<VDB extends ViewDataBinding, ViewModel extends IViewModel>
        extends BaseMvvmFragment<ViewModel> {

    protected VDB viewDataBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil
                .inflate(inflater, getLayoutResId(), container, false);
        onBind(viewDataBinding);
        return viewDataBinding.getRoot();
    }

    protected abstract void onBind(VDB viewDataBinding);

    @LayoutRes
    protected abstract int getLayoutResId();

}
