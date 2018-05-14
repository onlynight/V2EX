package com.github.onlynight.rxmvvm;

import android.content.Intent;

public interface IViewModel<Model extends IModel> extends Lifecycle {

    void setModel(Model model);

    void setIntent(Intent intent);

    Model createModel();

}
