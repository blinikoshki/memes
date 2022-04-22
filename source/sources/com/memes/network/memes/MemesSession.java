package com.memes.network.memes;

import com.memes.network.memes.api.model.core.AuthenticationRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u0004J\u0006\u0010%\u001a\u00020&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006'"}, mo26107d2 = {"Lcom/memes/network/memes/MemesSession;", "", "()V", "firebaseToken", "", "getFirebaseToken", "()Ljava/lang/String;", "setFirebaseToken", "(Ljava/lang/String;)V", "id", "getId", "setId", "jwtToken", "getJwtToken", "setJwtToken", "messagingId", "", "getMessagingId", "()Ljava/lang/Integer;", "setMessagingId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "token", "getToken", "setToken", "userId", "getUserId", "setUserId", "userName", "getUserName", "setUserName", "clear", "", "isEmpty", "", "isOf", "targetUserIdOrName", "obtainAuthenticationRequest", "Lcom/memes/network/memes/api/model/core/AuthenticationRequest;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesSession.kt */
public final class MemesSession {
    public static final MemesSession INSTANCE = new MemesSession();
    private static String firebaseToken;

    /* renamed from: id */
    private static String f990id;
    private static String jwtToken;
    private static Integer messagingId;
    private static String token;
    private static String userId;
    private static String userName;

    private MemesSession() {
    }

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(String str) {
        userId = str;
    }

    public final String getUserName() {
        return userName;
    }

    public final void setUserName(String str) {
        userName = str;
    }

    public final String getToken() {
        return token;
    }

    public final void setToken(String str) {
        token = str;
    }

    public final String getFirebaseToken() {
        return firebaseToken;
    }

    public final void setFirebaseToken(String str) {
        firebaseToken = str;
    }

    public final String getId() {
        return f990id;
    }

    public final void setId(String str) {
        f990id = str;
    }

    public final String getJwtToken() {
        return jwtToken;
    }

    public final void setJwtToken(String str) {
        jwtToken = str;
    }

    public final Integer getMessagingId() {
        return messagingId;
    }

    public final void setMessagingId(Integer num) {
        messagingId = num;
    }

    public final boolean isEmpty() {
        CharSequence charSequence = userId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = token;
            return charSequence2 == null || StringsKt.isBlank(charSequence2);
        }
    }

    public final boolean isOf(String str) {
        return !isEmpty() && str != null && (Intrinsics.areEqual((Object) userId, (Object) str) || Intrinsics.areEqual((Object) userName, (Object) str) || Intrinsics.areEqual((Object) f990id, (Object) str));
    }

    public final AuthenticationRequest obtainAuthenticationRequest() {
        return new AuthenticationRequest(userId, token);
    }

    public final void clear() {
        String str = null;
        userId = str;
        userName = str;
        token = str;
        firebaseToken = str;
        f990id = str;
        jwtToken = str;
        messagingId = null;
    }
}
