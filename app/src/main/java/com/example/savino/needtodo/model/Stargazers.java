package com.example.savino.needtodo.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class Stargazers {

    @SerializedName("id")
    String mId;

    @SerializedName("login")
    String mLogin;

    @SerializedName("avatar_url")
    String mAvatar;

    @ParcelConstructor
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
