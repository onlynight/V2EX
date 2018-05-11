package com.github.onlynight.v2ex.module.topic_details;

import com.github.onlynight.rxmvvm.IModel;
import com.github.onlynight.rxmvvm.IView;
import com.github.onlynight.rxmvvm.IViewModel;

public interface TopicDetailsContract {

    interface View extends IView {
    }

    interface Model extends IModel {
    }

    interface ViewModel extends IViewModel<View, Model> {
    }

}
