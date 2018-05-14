package com.github.onlynight.v2ex.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SiteInfoResponse extends BaseResponse implements Parcelable {

    /**
     * title : V2EX
     * slogan : way to explore
     * description : 创意工作者们的社区
     * domain : www.v2ex.com
     */

    private String title;
    private String slogan;
    private String description;
    private String domain;

    public SiteInfoResponse() {
    }

    protected SiteInfoResponse(Parcel in) {
        title = in.readString();
        slogan = in.readString();
        description = in.readString();
        domain = in.readString();
    }

    public static final Creator<SiteInfoResponse> CREATOR = new Creator<SiteInfoResponse>() {
        @Override
        public SiteInfoResponse createFromParcel(Parcel in) {
            return new SiteInfoResponse(in);
        }

        @Override
        public SiteInfoResponse[] newArray(int size) {
            return new SiteInfoResponse[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(slogan);
        dest.writeString(description);
        dest.writeString(domain);
    }
}
