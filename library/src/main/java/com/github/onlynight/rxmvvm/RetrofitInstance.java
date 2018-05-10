package com.github.onlynight.rxmvvm;

import retrofit2.Retrofit;

public class RetrofitInstance {

    private Retrofit retrofit;

    private RetrofitConfig config;

    private static RetrofitInstance instance;

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }

    public RetrofitInstance config(RetrofitConfig config) {
        this.config = config;
        checkConfig();
        Retrofit.Builder builder = new Retrofit.Builder();
        config.config(builder);
        retrofit = builder.build();
        return this;
    }

    public Retrofit getRetrofit() {
        checkConfig();
        return retrofit;
    }

    private void checkConfig() {
        if (config == null) {
            throw new RuntimeException("you should config RetrofitInstance");
        }
    }

    public interface RetrofitConfig {

        void config(Retrofit.Builder builder);

    }

}
