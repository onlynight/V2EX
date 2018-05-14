package com.github.onlynight.v2ex.module.main;

import com.github.onlynight.rxmvvm.BaseViewModel;
import com.github.onlynight.v2ex.model.SiteInfoResponse;

import io.reactivex.subjects.PublishSubject;

public class MainViewModel extends BaseViewModel<MainContract.Model>
        implements MainContract.ViewModel {

    private PublishSubject<SiteInfoResponse> updateWebsiteInfo;

    public MainViewModel() {
        updateWebsiteInfo = PublishSubject.create();
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
        bindData(model.getWebsiteInfo(), updateWebsiteInfo::onNext, updateWebsiteInfo::onError);
    }

    public PublishSubject<SiteInfoResponse> getUpdateWebsiteInfo() {
        return updateWebsiteInfo;
    }

}
