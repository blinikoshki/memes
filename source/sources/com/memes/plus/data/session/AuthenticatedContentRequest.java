package com.memes.plus.data.session;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "", "()V", "loginToken", "", "getLoginToken", "()Ljava/lang/String;", "setLoginToken", "(Ljava/lang/String;)V", "page", "", "getPage", "()I", "setPage", "(I)V", "userId", "getUserId", "setUserId", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AuthenticatedContentRequest.kt */
public class AuthenticatedContentRequest {
    @SerializedName("login_token")
    @Expose
    private String loginToken;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getLoginToken() {
        return this.loginToken;
    }

    public final void setLoginToken(String str) {
        this.loginToken = str;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }
}
