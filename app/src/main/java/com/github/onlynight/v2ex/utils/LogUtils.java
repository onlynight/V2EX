package com.github.onlynight.v2ex.utils;

import com.github.onlynight.v2ex.constants.Constants;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class LogUtils {

    static {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static void d(Object content) {
        if (Constants.SHOW_LOG) {
            Logger.d(content);
        }
    }

}
