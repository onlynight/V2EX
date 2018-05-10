package com.github.onlynight.v2ex.model;

public class SiteUserInfoResponse extends BaseResponse {

    /**
     * topic_max : 453834
     * member_max : 315553
     */

    private int topic_max;
    private int member_max;

    public int getTopic_max() {
        return topic_max;
    }

    public void setTopic_max(int topic_max) {
        this.topic_max = topic_max;
    }

    public int getMember_max() {
        return member_max;
    }

    public void setMember_max(int member_max) {
        this.member_max = member_max;
    }

}
