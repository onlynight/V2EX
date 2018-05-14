package com.github.onlynight.rxmvvm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.github.onlynight.rxmvvm.IViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

public abstract class BaseMvvmActivity<ViewModel extends IViewModel> extends AppCompatActivity {

    protected ViewModel viewModel;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected abstract ViewModel createViewModel();

    protected <T> void bindData(Subject<T> subject, Consumer<? super T> onNext) {
        bindData(subject, onNext, this::commonError);
    }

    protected <T> void bindData(Subject<T> subject, Consumer<? super T> onNext, Consumer<? super Throwable> onError) {
        bindData(subject, onNext, onError, Functions.EMPTY_ACTION);
    }

    protected <T> void bindData(Subject<T> subject, Consumer<? super T> onNext, Consumer<? super Throwable> onError, Action onComplete) {
        compositeDisposable.add(subject.
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(onNext, onError, onComplete));
    }

    protected void commonError(Throwable throwable) {
    }

    protected void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel();
        viewModel.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
            compositeDisposable = null;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        viewModel.onRestart();
    }

}
