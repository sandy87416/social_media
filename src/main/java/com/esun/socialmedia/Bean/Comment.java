package com.esun.socialmedia.Bean;

public class Comment {
    private int commentId;
    private String userID = "";
    private int postID;
    private String content = "";
    private String createAt = "";

    public Comment(int postID, String userID, String content) {
        this.postID = postID;
        this.userID = userID;
        this.content = content;
    }

    public Comment(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
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
