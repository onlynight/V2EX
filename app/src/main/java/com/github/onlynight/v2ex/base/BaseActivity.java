package com.github.onlynight.v2ex.base;

import android.databinding.ViewDataBinding;

import com.github.onlynight.rxmvvm.base.BaseVDBMvvmActivity;
import com.github.onlynight.rxmvvm.IViewModel;

public abstract class BaseActivity<VDB extends ViewDataBinding, ViewModel extends IViewModel> extends
        BaseVDBMvvmActivity<VDB, ViewModel> {
}
