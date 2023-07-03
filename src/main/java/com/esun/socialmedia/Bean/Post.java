package com.esun.socialmedia.Bean;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int postID;
    private String userID = "";
    private String content = "";
    private String image = "";
    private String createAt = "";
    private List<Comment> comment = new ArrayList<Comment>();

    public Post(String userID, String content) {
        this.userID = userID;
        this.content = content;
    }

    public Post(int postID) {
        this.postID = postID;
    }

    public Post() {    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
