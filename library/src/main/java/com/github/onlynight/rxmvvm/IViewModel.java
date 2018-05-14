package com.github.onlynight.rxmvvm;

public interface IViewModel<Model extends IModel> extends Lifecycle {

    void setModel(Model model);

    Model createModel();

}
