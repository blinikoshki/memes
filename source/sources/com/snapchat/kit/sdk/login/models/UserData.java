package com.snapchat.kit.sdk.login.models;

import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("me")
    MeData mMe;

    public MeData getMe() {
        return this.mMe;
    }
}
