package com.github.onlynight.v2ex.services;

import com.github.onlynight.v2ex.model.SiteInfoResponse;
import com.github.onlynight.v2ex.model.SiteUserInfoResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface SiteService {

    @GET("api/site/info.json")
    Flowable<SiteInfoResponse> getWebsiteInfo();

    @GET("/api/site/stats.json")
    Flowable<SiteUserInfoResponse> getWebsiteStats();

}
