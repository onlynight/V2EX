package com.github.onlynight.v2ex.module.topic_list;

import com.github.onlynight.rxmvvm.BaseModel;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.services.TopicService;

import java.util.List;

import io.reactivex.Flowable;

public class TopicListModel extends BaseModel implements TopicListContract.Model {

    @Override
    public Flowable<List<TopicResponse>> getLatestTopic() {
        return getService(TopicService.class).getLatestTopic();
    }

    @Override
    public Flowable<List<TopicResponse>> getHotTopic() {
        return getService(TopicService.class).getHotTopic();
    }

}
