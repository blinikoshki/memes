package com.memes.plus.data.source.purchase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/data/source/purchase/StoreObjectResponse;", "", "()V", "storeInfo", "Lcom/memes/plus/data/source/purchase/StoreInfo;", "getStoreInfo", "()Lcom/memes/plus/data/source/purchase/StoreInfo;", "setStoreInfo", "(Lcom/memes/plus/data/source/purchase/StoreInfo;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StoreObjectResponse.kt */
public final class StoreObjectResponse {
    @SerializedName("message")
    @Expose
    private StoreInfo storeInfo;
    @SerializedName("success")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean success;

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final StoreInfo getStoreInfo() {
        return this.storeInfo;
    }

    public final void setStoreInfo(StoreInfo storeInfo2) {
        this.storeInfo = storeInfo2;
    }
}
