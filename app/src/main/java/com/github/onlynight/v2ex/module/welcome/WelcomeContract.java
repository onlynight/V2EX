package com.github.onlynight.v2ex.module.welcome;

import com.github.onlynight.rxmvvm.IModel;
import com.github.onlynight.rxmvvm.IView;
import com.github.onlynight.rxmvvm.IViewModel;

public interface WelcomeContract {

    interface View extends IView {

        void testFunction(String args);

    }

    interface Model extends IModel {
    }

    interface ViewModel extends IViewModel<WelcomeContract.View, WelcomeContract.Model> {
    }

}
