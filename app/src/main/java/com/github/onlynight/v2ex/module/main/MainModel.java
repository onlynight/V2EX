package com.github.onlynight.v2ex.module.main;

import com.github.onlynight.rxmvvm.BaseModel;
import com.github.onlynight.v2ex.model.NodeInfoResponse;
import com.github.onlynight.v2ex.model.SiteInfoResponse;
import com.github.onlynight.v2ex.services.NodeService;
import com.github.onlynight.v2ex.services.SiteService;

import java.util.List;

import io.reactivex.Flowable;

public class MainModel extends BaseModel implements MainContract.Model {

    @Override
    public Flowable<List<NodeInfoResponse>> getAllNode() {
        return getService(NodeService.class).getAllNode();
    }

    @Override
    public Flowable<SiteInfoResponse> getWebsiteInfo() {
        return getService(SiteService.class).getWebsiteInfo();
    }
}
