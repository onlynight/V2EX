package com.github.onlynight.v2ex.services;

import com.github.onlynight.v2ex.model.ReplyResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ReplyService {

    @GET("/api/replies/show.json")
    Flowable<List<ReplyResponse>> getReplies(@Query("topic_id") int topicId);

    @GET("/api/replies/show.json")
    Flowable<List<ReplyResponse>> getReplies(@Query("topic_id") int topicId,
                                             @Query("page") int page,
                                             @Query("page_size") int pageSize);

}
