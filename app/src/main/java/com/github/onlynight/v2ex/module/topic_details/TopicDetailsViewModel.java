package com.github.onlynight.v2ex.module.topic_details;

import android.content.Intent;

import com.github.onlynight.rxmvvm.BaseViewModel;
import com.github.onlynight.v2ex.constants.Constants;
import com.github.onlynight.v2ex.model.ReplyResponse;
import com.github.onlynight.v2ex.model.TopicResponse;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class TopicDetailsViewModel extends BaseViewModel<TopicDetailsContract.Model> implements
        TopicDetailsContract.ViewModel {

    private TopicResponse topic;
    private PublishSubject<List<TopicResponse>> updateTopic;
    private PublishSubject<List<ReplyResponse>> updateReplies;

    public TopicDetailsViewModel() {
        super();
        updateTopic = PublishSubject.create();
        updateReplies = PublishSubject.create();
    }

    @Override
    public TopicDetailsContract.Model createModel() {
        return new TopicDetailsModel();
    }

    @Override
    public void getTopic() {
        if (topic == null) {
            return;
        }
        bindData(model.getTopic(topic.getId()), updateTopic);
    }

    @Override
    public void getReplies() {
        if (topic == null) {
            return;
        }

        bindData(model.getReplies(topic.getId()), updateReplies);
    }

    public PublishSubject<List<TopicResponse>> getUpdateTopic() {
        return updateTopic;
    }

    public PublishSubject<List<ReplyResponse>> getUpdateReplies() {
        return updateReplies;
    }

    @Override
    public void setIntent(Intent intent) {
        super.setIntent(intent);
        topic = intent.getParcelableExtra(Constants.INTENT_KEY_PARAMS_TOPIC_LIST_ITEM);
    }

}
