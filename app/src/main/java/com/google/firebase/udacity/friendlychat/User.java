package com.google.firebase.udacity.friendlychat;

import android.net.Uri;

import java.util.List;

/**
 * Created by animo on 30/9/17.
 */

public class User {
    private String userId;
    private String userName;
    private String emailId;
    private String avtar_url;
    private List<String> chattedWith;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAvtar_url() {
        return avtar_url;
    }

    public void setAvtar_url(String avtar_url) {
        this.avtar_url = avtar_url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getChattedWith() {
        return chattedWith;
    }

    public void setChattedWith(List<String> chattedWith) {
        this.chattedWith = chattedWith;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
