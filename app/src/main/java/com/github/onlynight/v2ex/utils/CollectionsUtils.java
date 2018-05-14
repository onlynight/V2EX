package com.github.onlynight.v2ex.utils;

import java.util.List;

public class CollectionsUtils {

    public static <T> T getFirstItem(List<T> data) {
        if (data != null && data.size() > 0) {
            return data.get(0);
        }

        return null;
    }

}
