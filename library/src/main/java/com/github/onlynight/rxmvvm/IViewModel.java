package com.github.onlynight.rxmvvm;

public interface IViewModel<View extends IView, Model extends IModel> extends Lifecycle {

    void setView(View view);

    void setModel(Model model);

    Model createModel();

}
