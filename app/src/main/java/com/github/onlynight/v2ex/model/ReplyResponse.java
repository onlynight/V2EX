package com.github.onlynight.v2ex.model;

public class ReplyResponse extends BaseResponse {
    /**
     * id : 1
     * thanks : 5
     * content : 很高兴看到 v2ex 又回来了，等了你半天发第一贴了，憋死我了。

     nice work~
     * content_rendered : 很高兴看到 v2ex 又回来了，等了你半天发第一贴了，憋死我了。<br /><br />nice work~
     * member : {"id":4,"username":"Jay","tagline":"","avatar_mini":"//cdn.v2ex.com/avatar/a87f/f679/4_mini.png?m=1325831331","avatar_normal":"//cdn.v2ex.com/avatar/a87f/f679/4_normal.png?m=1325831331","avatar_large":"//cdn.v2ex.com/avatar/a87f/f679/4_large.png?m=1325831331"}
     * created : 1272207477
     * last_modified : 1335092176
     */

    private int id;
    private int thanks;
    private String content;
    private String content_rendered;
    private MemberBean member;
    private int created;
    private int last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThanks() {
        return thanks;
    }

    public void setThanks(int thanks) {
        this.thanks = thanks;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(int last_modified) {
        this.last_modified = last_modified;
    }

    public static class MemberBean {
        /**
         * id : 4
         * username : Jay
         * tagline :
         * avatar_mini : //cdn.v2ex.com/avatar/a87f/f679/4_mini.png?m=1325831331
         * avatar_normal : //cdn.v2ex.com/avatar/a87f/f679/4_normal.png?m=1325831331
         * avatar_large : //cdn.v2ex.com/avatar/a87f/f679/4_large.png?m=1325831331
         */

        private int id;
        private String username;
        private String tagline;
        private String avatar_mini;
        private String avatar_normal;
        private String avatar_large;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
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
    }
}
