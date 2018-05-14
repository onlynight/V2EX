package com.github.onlynight.v2ex.module.topic_details;

import com.github.onlynight.rxmvvm.BaseViewModel;

public class TopicDetailsViewModel extends BaseViewModel<TopicDetailsContract.Model> implements
        TopicDetailsContract.ViewModel {

    public TopicDetailsViewModel() {
        super();
    }

    @Override
    public TopicDetailsContract.Model createModel() {
        return new TopicDetailsModel();
    }

}
