package com.snapchat.kit.sdk.login.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class GraphQLResponse<T> {
    @SerializedName("data")
    private T mData;
    @SerializedName("errors")
    private List<UserDataError> mErrors;

    public T getData() {
        return this.mData;
    }

    public List<UserDataError> getErrors() {
        if (this.mErrors == null) {
            this.mErrors = new ArrayList();
        }
        return this.mErrors;
    }

    public boolean hasError() {
        return !getErrors().isEmpty();
    }
}
