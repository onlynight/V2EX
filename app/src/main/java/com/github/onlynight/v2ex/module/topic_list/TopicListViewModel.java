package com.github.onlynight.v2ex.module.topic_list;

import com.github.onlynight.rxmvvm.BaseViewModel;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.utils.LogUtils;

import java.util.List;

import io.reactivex.functions.Consumer;

public class TopicListViewModel extends BaseViewModel<TopicListContract.View,
        TopicListContract.Model> implements TopicListContract.ViewModel {

    public TopicListViewModel(TopicListContract.View view) {
        super(view);
    }

    @Override
    public TopicListContract.Model createModel() {
        return new TopicListModel();
    }

    @Override
    public void getLatestTopic() {
        bindData(model.getLatestTopic(),view::updateTopics);
    }

    @Override
    public void getHotTopic() {
        bindData(model.getHotTopic(), view::updateTopics);
    }

}
