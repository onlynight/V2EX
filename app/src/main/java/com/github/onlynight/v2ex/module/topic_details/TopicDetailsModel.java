package com.github.onlynight.v2ex.module.topic_details;

import com.github.onlynight.rxmvvm.BaseModel;
import com.github.onlynight.v2ex.model.ReplyResponse;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.services.ReplyService;
import com.github.onlynight.v2ex.services.TopicService;

import java.util.List;

import io.reactivex.Flowable;

public class TopicDetailsModel extends BaseModel implements TopicDetailsContract.Model {

    @Override
    public Flowable<List<TopicResponse>> getTopic(int id) {
        return getService(TopicService.class).getTopic(id);
    }

    @Override
    public Flowable<List<ReplyResponse>> getReplies(int topicId) {
        return getService(ReplyService.class).getReplies(topicId);
    }

}
