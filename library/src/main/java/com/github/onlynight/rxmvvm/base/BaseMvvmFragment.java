package com.github.onlynight.rxmvvm.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.onlynight.rxmvvm.IViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

public abstract class BaseMvvmFragment<ViewModel extends IViewModel> extends Fragment {

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel();
        viewModel.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel.onCreateView();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        viewModel.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
            compositeDisposable = null;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.onDestroyView();
    }
}
