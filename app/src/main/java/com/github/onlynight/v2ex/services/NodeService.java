package com.github.onlynight.v2ex.services;

import com.github.onlynight.v2ex.model.NodeInfoResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NodeService {

    @GET("/api/nodes/all.json")
    Flowable<List<NodeInfoResponse>> getAllNode();

    @GET("/api/nodes/show.json")
    Flowable<List<NodeInfoResponse>> getNodeInfo(@Query("id") int id, @Query("name") String name);

}
