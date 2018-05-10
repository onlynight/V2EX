package com.github.onlynight.v2ex.module.main;

import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.base.BaseActivity;
import com.github.onlynight.v2ex.databinding.ActivityMainBinding;
import com.github.onlynight.v2ex.model.SiteInfoResponse;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainContract.View {

    @Override
    protected void onBind(ActivityMainBinding viewDataBinding) {
        viewModel.getWebsiteInfo();
        viewModel.getAllNode();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainViewModel createViewModel() {
        return new MainViewModel(this);
    }

    @Override
    public void updateWebsiteInfo(SiteInfoResponse t) {
        viewDataBinding.textContent.setText(t.getDescription());
    }

}
