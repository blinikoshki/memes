package com.memes.network.memes.source.remote.model.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006XD¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/model/core/MemesResponse;", "", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "success", "", "getSuccess", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isSuccess", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesResponse.kt */
public class MemesResponse {
    @SerializedName("message")
    @Expose
    private final String message;
    @SerializedName("success")
    @Expose
    private final Integer success = 0;

    public final Integer getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean isSuccess() {
        Integer num = this.success;
        return num != null && num.intValue() == 1;
    }
}
