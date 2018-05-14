package com.github.onlynight.rxmvvm;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

public abstract class BaseViewModel<Model extends IModel>
        implements IViewModel<Model> {

    protected Model model;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseViewModel() {
        this.model = createModel();
    }

    public BaseViewModel(Model model) {
        this.model = model;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    protected void onError(Throwable throwable) {
    }

    protected <T> void bindData(Flowable<T> dataSource, Subject<T> subject) {
        bindData(dataSource, subject::onNext, subject::onError, () -> {
        });
    }

    protected <T> void bindData(Flowable<T> dataSource, Consumer<? super T> onNext) {
        bindData(dataSource, onNext, this::onError);
    }

    protected <T> void bindData(Flowable<T> dataSource, Consumer<? super T> onNext, Consumer<? super Throwable> onError) {
        bindData(dataSource, onNext, onError, Functions.EMPTY_ACTION);
    }

    protected <T> void bindData(Flowable<T> dataSource, Consumer<? super T> onNext, Consumer<? super Throwable> onError, Action onComplete) {
        compositeDisposable.add(dataSource.
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(onNext, onError, onComplete));
    }

    protected <T> void bindData(Observable<T> dataSource, Subject<T> subject) {
        bindData(dataSource, subject::onNext, subject::onError, () -> {
        });
    }

    protected <T> void bindData(Observable<T> subject, Consumer<? super T> onNext) {
        bindData(subject, onNext, this::onError);
    }

    protected <T> void bindData(Observable<T> subject, Consumer<? super T> onNext, Consumer<? super Throwable> onError) {
        bindData(subject, onNext, onError, Functions.EMPTY_ACTION);
    }

    protected <T> void bindData(Observable<T> subject, Consumer<? super T> onNext, Consumer<? super Throwable> onError, Action onComplete) {
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
