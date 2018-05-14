package com.github.onlynight.v2ex.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MemberResponse extends BaseResponse implements Parcelable {
    /**
     * id : 16147
     * url : http://www.v2ex.com/member/djyde
     * username : djyde
     * website : https://djyde.github.io
     * twitter :
     * location :
     * tagline :
     * bio : 喜欢摄影和写作的程序员。
     * avatar_mini : //cdn.v2ex.com/avatar/ed4c/1b66/16147_mini.png?m=1329639748
     * avatar_normal : //cdn.v2ex.com/avatar/ed4c/1b66/16147_normal.png?m=1329639748
     * avatar_large : //cdn.v2ex.com/avatar/ed4c/1b66/16147_large.png?m=1329639748
     * created : 1328075793
     */

    private int id;
    private String url;
    private String username;
    private String website;
    private String twitter;
    private String location;
    private String tagline;
    private String bio;
    private String avatar_mini;
    private String avatar_normal;
    private String avatar_large;
    private int created;

    public MemberResponse() {
    }

    protected MemberResponse(Parcel in) {
        id = in.readInt();
        url = in.readString();
        username = in.readString();
        website = in.readString();
        twitter = in.readString();
        location = in.readString();
        tagline = in.readString();
        bio = in.readString();
        avatar_mini = in.readString();
        avatar_normal = in.readString();
        avatar_large = in.readString();
        created = in.readInt();
    }

    public static final Creator<MemberResponse> CREATOR = new Creator<MemberResponse>() {
        @Override
        public MemberResponse createFromParcel(Parcel in) {
            return new MemberResponse(in);
        }

        @Override
        public MemberResponse[] newArray(int size) {
            return new MemberResponse[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar_mini() {
        return avatar_mini;
    }

    public void setAvatar_mini(String avatar_mini) {
        this.avatar_mini = avatar_mini;
    }

    public String getAvatar_normal() {
        return avatar_normal;
    }

    public void setAvatar_normal(String avatar_normal) {
        this.avatar_normal = avatar_normal;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(url);
        dest.writeString(username);
        dest.writeString(website);
        dest.writeString(twitter);
        dest.writeString(location);
        dest.writeString(tagline);
        dest.writeString(bio);
        dest.writeString(avatar_mini);
        dest.writeString(avatar_normal);
        dest.writeString(avatar_large);
        dest.writeInt(created);
    }
}
