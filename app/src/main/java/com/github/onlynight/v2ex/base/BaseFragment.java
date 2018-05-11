package com.github.onlynight.v2ex.base;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.github.onlynight.rxmvvm.IViewModel;
import com.github.onlynight.rxmvvm.base.BaseVDBMvvmFragment;

public abstract class BaseFragment<VDB extends ViewDataBinding, ViewModel extends IViewModel>
        extends BaseVDBMvvmFragment<VDB, ViewModel> implements
        View.OnClickListener {

    public String getFragmentTitle() {
        return "";
    }

    @Override
    public void onClick(View v) {
    }
}
