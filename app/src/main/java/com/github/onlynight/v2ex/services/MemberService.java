package com.github.onlynight.v2ex.services;

import com.github.onlynight.v2ex.model.MemberResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MemberService {

    @GET("/api/members/show.json")
    Flowable<MemberResponse> getMember(@Query("username") String username);

}
