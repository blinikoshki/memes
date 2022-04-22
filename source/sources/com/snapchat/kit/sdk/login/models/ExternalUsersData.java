package com.snapchat.kit.sdk.login.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ExternalUsersData {
    @SerializedName("users")
    private List<MeData> mUsers;

    public List<MeData> getUsers() {
        return this.mUsers;
    }
}
