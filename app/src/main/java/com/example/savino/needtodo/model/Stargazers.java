package com.example.savino.needtodo.model;

public class Stargazers {

    String mId;

    String mLogin;

    String mAvatar;

    public Stargazers(String id, String login, String avatar) {
        mId = id;
        mLogin = login;
        mAvatar = avatar;
    }

    public String getId() {
        return mId;
    }

    public String getLogin() {
        return mLogin;
    }

    public String getAvatar() {
        return mAvatar;
    }
}
