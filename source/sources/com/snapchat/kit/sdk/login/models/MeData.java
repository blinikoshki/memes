package com.snapchat.kit.sdk.login.models;

import com.google.gson.annotations.SerializedName;

public class MeData {
    @SerializedName("displayName")
    private String displayName;
    @SerializedName("externalId")
    private String externalId;
    @SerializedName("bitmoji")
    private UserBitmojiData mBitmojiData;
    @SerializedName("profileLink")
    private String profileLink;

    public UserBitmojiData getBitmojiData() {
        return this.mBitmojiData;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getProfileLink() {
        return this.profileLink;
    }
}
