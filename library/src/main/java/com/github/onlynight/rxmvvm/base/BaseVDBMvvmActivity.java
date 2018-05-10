package com.github.onlynight.rxmvvm.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.github.onlynight.rxmvvm.IViewModel;

public abstract class BaseVDBMvvmActivity<VDB extends ViewDataBinding, ViewModel extends IViewModel> extends
        BaseMvvmActivity<ViewModel> {

    protected VDB viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutResId(),
                null, false);
        setContentView(viewDataBinding.getRoot());
        onBind(viewDataBinding);
    }

    protected abstract void onBind(VDB viewDataBinding);

    @LayoutRes
    protected abstract int getLayoutResId();

}
