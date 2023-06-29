package com.esun.socialmedia.Bean;

public class Comment {
    private String userID = "";
    private String content = "";
    private String createAt = "";

    public Comment(String userID, String content) {
        this.userID = userID;
        this.content = content;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
