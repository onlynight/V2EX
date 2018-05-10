package com.github.onlynight.rxmvvm;

public interface Lifecycle {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onRestart();

    void onCreateView();

    void onDestroyView();

}
