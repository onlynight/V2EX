package com.github.onlynight.rxmvvm;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseViewModel<View extends IView, Model extends IModel>
        implements IViewModel<View, Model> {

    protected View view;
    protected Model model;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseViewModel(View view) {
        this.view = view;
        this.model = createModel();
    }

    public BaseViewModel(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    protected <T> void bindData(Flowable<T> subject, Consumer<? super T> onNext) {
        bindData(subject, onNext, this::onError);
    }

    protected void onError(Throwable throwable) {
    }

    protected <T> void bindData(Flowable<T> subject, Consumer<? super T> onNext, Consumer<? super Throwable> onError) {
        bindData(subject, onNext, onError, Functions.EMPTY_ACTION);
    }

    protected <T> void bindData(Flowable<T> subject, Consumer<? super T> onNext, Consumer<? super Throwable> onError, Action onComplete) {
        compositeDisposable.add(subject.
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(onNext, onError, onComplete));
    }

    @Override
    public void onDestroy() {

        if (compositeDisposable != null) {
            compositeDisposable.dispose();
            compositeDisposable = null;
        }

        if (model != null) {
            model.release();
        }

    }

    @Override
    public void onDestroyView() {
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onCreateView() {

    }

}
