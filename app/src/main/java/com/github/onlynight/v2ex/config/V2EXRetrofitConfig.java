package com.github.onlynight.v2ex.config;

import com.github.onlynight.rxmvvm.RetrofitInstance;
import com.github.onlynight.v2ex.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class V2EXRetrofitConfig implements RetrofitInstance.RetrofitConfig {

    @Override
    public void config(Retrofit.Builder builder) {
        builder.baseUrl(Constants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    }

}
