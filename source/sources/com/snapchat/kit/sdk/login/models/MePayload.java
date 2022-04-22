package com.snapchat.kit.sdk.login.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class MePayload implements Serializable {
    @SerializedName("query")
    private final String mQuery;
    @SerializedName("variables")
    private final Map<String, Object> mVariables;

    public MePayload(String str, Map<String, Object> map) {
        this.mQuery = str;
        this.mVariables = map;
    }
}
