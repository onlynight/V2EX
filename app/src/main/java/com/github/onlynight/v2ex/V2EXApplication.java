package com.github.onlynight.v2ex;

import android.app.Application;

import com.github.onlynight.rxmvvm.RetrofitInstance;
import com.github.onlynight.v2ex.config.V2EXRetrofitConfig;

public class V2EXApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitInstance.getInstance().config(new V2EXRetrofitConfig());
    }

}
