package com.memes.plus.firebase.firebase_token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/firebase/firebase_token/FirebaseTokenRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "tokenType", "getTokenType", "setTokenType", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FirebaseTokenRequest.kt */
public final class FirebaseTokenRequest extends AuthenticatedContentRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TYPE_ANDROID = "2";
    @SerializedName("device_token")
    @Expose
    private String token;
    @SerializedName("device_type")
    @Expose
    private String tokenType = "2";

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/firebase/firebase_token/FirebaseTokenRequest$Companion;", "", "()V", "TYPE_ANDROID", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FirebaseTokenRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final void setTokenType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tokenType = str;
    }
}
