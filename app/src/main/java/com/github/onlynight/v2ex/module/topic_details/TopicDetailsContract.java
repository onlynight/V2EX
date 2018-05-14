package com.github.onlynight.v2ex.module.topic_details;

import com.github.onlynight.rxmvvm.IModel;
import com.github.onlynight.rxmvvm.IViewModel;
import com.github.onlynight.v2ex.model.ReplyResponse;
import com.github.onlynight.v2ex.model.TopicResponse;

import java.util.List;

import io.reactivex.Flowable;

public interface TopicDetailsContract {

    interface Model extends IModel {

        Flowable<List<TopicResponse>> getTopic(int id);

        Flowable<List<ReplyResponse>> getReplies(int topicId);

    }

    interface ViewModel extends IViewModel<Model> {

        void getTopic();

        void getReplies();

    }

}
