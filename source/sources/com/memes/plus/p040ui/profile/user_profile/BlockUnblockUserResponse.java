package com.memes.plus.p040ui.profile.user_profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserResponse;", "", "()V", "isBlocked", "", "()Z", "setBlocked", "(Z)V", "success", "getSuccess", "setSuccess", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.BlockUnblockUserResponse */
/* compiled from: BlockUnblockUserResponse.kt */
public final class BlockUnblockUserResponse {
    @SerializedName("blocked")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean isBlocked;
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

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final void setBlocked(boolean z) {
        this.isBlocked = z;
    }
}
