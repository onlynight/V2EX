package com.github.onlynight.v2ex.utils;

public class TimeBase {

    private long timestamp;

    public TimeBase() {
    }

    public TimeBase(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getShowTime() {
        return getStandardDate(timestamp);
    }

    public String getShowTime(long timestamp) {
        return getStandardDate(timestamp);
    }

    private static String getStandardDate(long timestamp) {
        String temp = "";
        try {
            long now = System.currentTimeMillis() / 1000;
            long diff = now - timestamp;
            long months = diff / (60 * 60 * 24 * 30);
            long days = diff / (60 * 60 * 24);
            long hours = (diff - days * (60 * 60 * 24)) / (60 * 60);
            long minutes = (diff - days * (60 * 60 * 24) - hours * (60 * 60)) / 60;
            if (months > 0) {
                temp = months + "月前";
            } else if (days > 0) {
                temp = days + "天前";
            } else if (hours > 0) {
                temp = hours + "小时前";
            } else {
                temp = minutes + "分钟前";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

}
