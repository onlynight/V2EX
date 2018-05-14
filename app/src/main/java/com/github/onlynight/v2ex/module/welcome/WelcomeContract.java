package com.github.onlynight.v2ex.module.welcome;

import com.github.onlynight.rxmvvm.IModel;
import com.github.onlynight.rxmvvm.IViewModel;

public interface WelcomeContract {

    interface Model extends IModel {
    }

    interface ViewModel extends IViewModel<WelcomeContract.Model> {
    }

}
