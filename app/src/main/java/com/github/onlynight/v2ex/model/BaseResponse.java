package com.github.onlynight.v2ex.model;

public class BaseResponse {
    /**
     * status : error
     * message : Object Not Found
     * rate_limit : {"used":5,"hourly_quota":120,"hourly_remaining":115}
     */

    private String status;
    private String message;
    private RateLimitBean rate_limit;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RateLimitBean getRate_limit() {
        return rate_limit;
    }

    public void setRate_limit(RateLimitBean rate_limit) {
        this.rate_limit = rate_limit;
    }

    public static class RateLimitBean {
        /**
         * used : 5
         * hourly_quota : 120
         * hourly_remaining : 115
         */

        private int used;
        private int hourly_quota;
        private int hourly_remaining;

        public int getUsed() {
            return used;
        }

        public void setUsed(int used) {
            this.used = used;
        }

        public int getHourly_quota() {
            return hourly_quota;
        }

        public void setHourly_quota(int hourly_quota) {
            this.hourly_quota = hourly_quota;
        }

        public int getHourly_remaining() {
            return hourly_remaining;
        }

        public void setHourly_remaining(int hourly_remaining) {
            this.hourly_remaining = hourly_remaining;
        }
    }
}
