package com.github.onlynight.v2ex.module.main;

import com.github.onlynight.rxmvvm.BaseViewModel;

public class MainViewModel extends BaseViewModel<MainContract.View, MainContract.Model>
        implements MainContract.ViewModel {

    public MainViewModel(MainContract.View view) {
        super(view);
    }

    @Override
    public MainContract.Model createModel() {
        return new MainModel();
    }

    @Override
    public void getAllNode() {
        bindData(model.getAllNode(), responses -> {
        });
    }

    @Override
    public void getWebsiteInfo() {
        bindData(model.getWebsiteInfo(), view::updateWebsiteInfo);
    }

}
