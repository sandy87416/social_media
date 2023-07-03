package com.esun.socialmedia.Bean;

public class User {
    private String userID = "";
    private String userName = "";
    private String email = "";
    private String password = "";
    private String coverImage = "";
    private String biography = "";

    public User(String userID, String userName, String email, String password, String coverImage, String biography) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.coverImage = coverImage;
        this.biography = biography;
    }

    public User(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getUserID() {
        return userID;
    }
}