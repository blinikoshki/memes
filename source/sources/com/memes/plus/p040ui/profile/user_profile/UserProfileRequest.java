package com.memes.plus.p040ui.profile.user_profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/user_profile/UserProfileRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "targetUserId", "", "getTargetUserId", "()Ljava/lang/String;", "setTargetUserId", "(Ljava/lang/String;)V", "targetUserId2", "getTargetUserId2", "setTargetUserId2", "targetUserName", "getTargetUserName", "setTargetUserName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileRequest */
/* compiled from: UserProfileRequest.kt */
public final class UserProfileRequest extends AuthenticatedContentRequest {
    @SerializedName("searchuser_id")
    @Expose
    private String targetUserId;
    @SerializedName("getuser_id")
    @Expose
    private String targetUserId2;
    @SerializedName("searchuser_name")
    @Expose
    private String targetUserName;

    public final String getTargetUserName() {
        return this.targetUserName;
    }

    public final void setTargetUserName(String str) {
        this.targetUserName = str;
    }

    public final String getTargetUserId() {
        return this.targetUserId;
    }

    public final void setTargetUserId(String str) {
        this.targetUserId = str;
    }

    public final String getTargetUserId2() {
        return this.targetUserId2;
    }

    public final void setTargetUserId2(String str) {
        this.targetUserId2 = str;
    }
}
