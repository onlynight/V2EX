package com.github.onlynight.rxmvvm;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class BaseModel implements IModel {

    private Retrofit retrofit;
    private Map<String, Object> retrofitServices;

    public BaseModel() {
        retrofit = RetrofitInstance.getInstance().getRetrofit();
        retrofitServices = new HashMap<>();
    }

    public <T> T getService(Class<T> serviceClass) {
        Object service = retrofitServices.get(serviceClass.getName());
        if (service == null) {
            service = retrofit.create(serviceClass);
            retrofitServices.put(serviceClass.getName(), service);
        }

        return (T) service;
    }

    @Override
    public void release() {
        retrofitServices = null;
    }
}
