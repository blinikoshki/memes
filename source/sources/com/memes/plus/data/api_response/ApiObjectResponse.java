package com.memes.plus.data.api_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/data/api_response/ApiObjectResponse;", "T", "Lcom/memes/plus/data/api_response/ApiMessageResponse;", "()V", "data", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ApiObjectResponse.kt */
public class ApiObjectResponse<T> extends ApiMessageResponse {
    @SerializedName("data")
    @Expose
    private final T data;

    public final T getData() {
        return this.data;
    }
}
