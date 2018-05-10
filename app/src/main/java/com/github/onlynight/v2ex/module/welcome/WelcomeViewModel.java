package com.github.onlynight.v2ex.module.welcome;

import com.github.onlynight.rxmvvm.BaseViewModel;

public class WelcomeViewModel extends BaseViewModel<WelcomeContract.View, WelcomeContract.Model>
        implements WelcomeContract.ViewModel {

    public WelcomeViewModel(WelcomeContract.View view) {
        super(view);
    }

    @Override
    public WelcomeContract.Model createModel() {
        return new WelcomeModel();
    }

    public void testFunction() {
        view.testFunction("Hello world");
    }

}
