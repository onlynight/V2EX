package com.github.onlynight.v2ex.module.main;

import com.github.onlynight.rxmvvm.IModel;
import com.github.onlynight.rxmvvm.IViewModel;
import com.github.onlynight.v2ex.model.NodeInfoResponse;
import com.github.onlynight.v2ex.model.SiteInfoResponse;

import java.util.List;

import io.reactivex.Flowable;

public interface MainContract {

    interface Model extends IModel {

        Flowable<List<NodeInfoResponse>> getAllNode();

        Flowable<SiteInfoResponse> getWebsiteInfo();

    }

    interface ViewModel extends IViewModel<Model> {

        void getAllNode();

        void getWebsiteInfo();

    }

}
