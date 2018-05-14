package com.github.onlynight.v2ex.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SiteUserInfoResponse extends BaseResponse implements Parcelable {

    /**
     * topic_max : 453834
     * member_max : 315553
     */

    private int topic_max;
    private int member_max;

    public SiteUserInfoResponse() {
    }

    protected SiteUserInfoResponse(Parcel in) {
        topic_max = in.readInt();
        member_max = in.readInt();
    }

    public static final Creator<SiteUserInfoResponse> CREATOR = new Creator<SiteUserInfoResponse>() {
        @Override
        public SiteUserInfoResponse createFromParcel(Parcel in) {
            return new SiteUserInfoResponse(in);
        }

        @Override
        public SiteUserInfoResponse[] newArray(int size) {
            return new SiteUserInfoResponse[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(topic_max);
        dest.writeInt(member_max);
    }
}
