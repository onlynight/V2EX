package com.github.onlynight.v2ex.module.topic_list;

import com.github.onlynight.rxmvvm.IModel;
import com.github.onlynight.rxmvvm.IViewModel;
import com.github.onlynight.v2ex.model.TopicResponse;

import java.util.List;

import io.reactivex.Flowable;

public interface TopicListContract {

    interface Model extends IModel {

        Flowable<List<TopicResponse>> getLatestTopic();

        Flowable<List<TopicResponse>> getHotTopic();

    }

    interface ViewModel extends IViewModel<Model> {

        void getLatestTopic();

        void getHotTopic();

    }

}
