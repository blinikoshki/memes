package com.memes.chat.p036ui.startup;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u0004\u0018\u00010\tJ\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u001a\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ\b\u0010\u0014\u001a\u0004\u0018\u00010\tJ\b\u0010\u0015\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "firebaseToken", "", "getChatToken", "name", "profilePic", "realUserId", "setChatToken", "", "token", "stringPref", "key", "value", "userId", "userName", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.startup.ChatCredentialsSharedPref */
/* compiled from: ChatCredentialsSharedPref.kt */
public final class ChatCredentialsSharedPref {
    private final SharedPreferences sharedPreferences;

    public ChatCredentialsSharedPref(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPreferences = context.getSharedPreferences("storage", 0);
    }

    public final String userId() {
        return stringPref("s_user_id");
    }

    public final String realUserId() {
        return stringPref("s_real_user_id");
    }

    public final String userName() {
        return stringPref("s_user_name");
    }

    public final String token() {
        return stringPref("s_token");
    }

    public final String firebaseToken() {
        return stringPref("s_firebase_token");
    }

    public final String name() {
        return stringPref("s_name");
    }

    public final String profilePic() {
        return stringPref("s_profile_pic");
    }

    public final String getChatToken() {
        return stringPref("chat:chat_token");
    }

    public final void setChatToken(String str) {
        stringPref("chat:chat_token", str);
    }

    private final String stringPref(String str) {
        String string = this.sharedPreferences.getString(str, (String) null);
        Timber.m300d("<-- stringPref(" + str + ") = " + string, new Object[0]);
        return string;
    }

    private final void stringPref(String str, String str2) {
        Timber.m300d("--> stringPref(" + str + ", " + str2 + ')', new Object[0]);
        this.sharedPreferences.edit().putString(str, str2).apply();
    }
}
