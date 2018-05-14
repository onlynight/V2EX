package com.github.onlynight.v2ex.base;

import java.util.List;

public interface AdapterDataOperator<T> {

    List<T> getData();

    void setData(List<T> data);

    void clearData();

    void addData(List<T> data);

}
