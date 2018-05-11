package com.github.onlynight.v2ex.base;

import android.databinding.ViewDataBinding;

import com.github.onlynight.rxmvvm.IViewModel;
import com.github.onlynight.rxmvvm.base.BaseVDBMvvmFragment;

public abstract class BaseFragment<VDB extends ViewDataBinding, ViewModel extends IViewModel>
        extends BaseVDBMvvmFragment<VDB, ViewModel> {

    public String getFragmentTitle() {
        return "";
    }

}
