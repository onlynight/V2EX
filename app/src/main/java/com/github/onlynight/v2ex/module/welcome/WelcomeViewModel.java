package com.github.onlynight.v2ex.module.welcome;

import com.github.onlynight.rxmvvm.BaseViewModel;

public class WelcomeViewModel extends BaseViewModel<WelcomeContract.Model> implements WelcomeContract.ViewModel {

    public WelcomeViewModel() {
        super();
    }

    @Override
    public WelcomeContract.Model createModel() {
        return new WelcomeModel();
    }

}
