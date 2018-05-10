package com.github.onlynight.v2ex.services;

import com.github.onlynight.v2ex.model.TopicResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TopicService {

    @GET("/api/topics/latest.json")
    Flowable<List<TopicResponse>> getLatestTopic();

    @GET("/api/topics/hot.json")
    Flowable<List<TopicResponse>> getHotTopic();

    @GET("/api/topics/show.json")
    Flowable<List<TopicResponse>> getTopic(@Query("id") int id);

    @GET("/api/topics/show.json")
    Flowable<List<TopicResponse>> getTopic(@Query("username") String username,
                                           @Query("node_id") int nodeId,
                                           @Query("node_name") String nodeName);

}
