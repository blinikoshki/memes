package com.snapchat.kit.sdk.login.models;

import com.google.gson.annotations.SerializedName;

public class UserBitmojiData {
    @SerializedName("avatar")
    private String mAvatar;
    @SerializedName("id")
    private String mId;
    @SerializedName("packs")
    private String mPacksJson;
    @SerializedName("selfie")
    private String mSelfie;

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getId() {
        return this.mId;
    }

    public String getPacksJson() {
        return this.mPacksJson;
    }

    public String getSelfie() {
        return this.mSelfie;
    }
}
