package com.github.onlynight.v2ex.module.topic_list;

import com.github.onlynight.rxmvvm.BaseViewModel;
import com.github.onlynight.v2ex.model.TopicResponse;

import java.util.List;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class TopicListViewModel extends BaseViewModel<TopicListContract.Model> implements TopicListContract.ViewModel {

    private PublishSubject<List<TopicResponse>> updateLatestTopics;
    private PublishSubject<List<TopicResponse>> updateHotTopics;

    public TopicListViewModel() {
        super();
        updateLatestTopics = PublishSubject.create();
        updateHotTopics = PublishSubject.create();
    }

    @Override
    public TopicListContract.Model createModel() {
        return new TopicListModel();
    }

    @Override
    public void getLatestTopic() {
        bindData(model.getLatestTopic(), updateLatestTopics);
    }

    @Override
    public void getHotTopic() {
        bindData(model.getHotTopic(), updateHotTopics);
    }

    public PublishSubject<List<TopicResponse>> getUpdateLatestTopics() {
        return updateLatestTopics;
    }

    public PublishSubject<List<TopicResponse>> getUpdateHotTopics() {
        return updateHotTopics;
    }

}
