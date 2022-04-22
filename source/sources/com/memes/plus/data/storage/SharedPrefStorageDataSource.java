package com.memes.plus.data.storage;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\"\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010#\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010$\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020%H\u0016J\u000f\u0010&\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010'J\u0017\u0010&\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010)J\n\u0010*\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010*\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010+\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010,\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010,\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010-\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010-\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\fH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\fH\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\fH\u0016J\u0010\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\fH\u0016J\u0012\u00106\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001a\u00106\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010!\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\n\u00107\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u00107\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010\tH\u0016J\n\u00108\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u00108\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, mo26107d2 = {"Lcom/memes/plus/data/storage/SharedPrefStorageDataSource;", "Lcom/memes/plus/data/storage/StorageDataSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "age", "", "", "appRatingConfirmed", "", "appUpdateConfig", "config", "autoSavePost", "bio", "booleanPref", "key", "value", "booleanPrefWithDefault", "default", "clear", "clearUser", "coverPic", "coverPicThumbnail", "email", "firebaseToken", "intPref", "", "isPlaybackSoundMuted", "isWelcomed", "jwtToken", "token", "location", "loginSource", "longPref", "", "messagingId", "()Ljava/lang/Integer;", "id", "(Ljava/lang/Integer;)V", "name", "profilePic", "profilePicThumbnail", "realUserId", "setAppRatingConfirmed", "confirmed", "setAutoSavePost", "autoSave", "setPlaybackSoundMuted", "isMuted", "setWelcomed", "seen", "stringPref", "userId", "userName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SharedPrefStorageDataSource.kt */
public final class SharedPrefStorageDataSource implements StorageDataSource {
    private final SharedPreferences sharedPreferences;

    public void messagingId(Integer num) {
    }

    public SharedPrefStorageDataSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPreferences = context.getSharedPreferences("storage", 0);
    }

    public boolean isWelcomed() {
        if (booleanPrefWithDefault("s_welcomed", false) || userId() != null) {
            return true;
        }
        return false;
    }

    public void setWelcomed(boolean z) {
        booleanPref("s_welcomed", z);
    }

    public String appUpdateConfig() {
        return stringPref("s_app_update_remote_config");
    }

    public void appUpdateConfig(String str) {
        Intrinsics.checkNotNullParameter(str, "config");
        stringPref("s_app_update_remote_config", str);
    }

    public String userId() {
        return stringPref("s_user_id");
    }

    public void userId(String str) {
        stringPref("s_user_id", str);
    }

    public String realUserId() {
        return stringPref("s_real_user_id");
    }

    public void realUserId(String str) {
        stringPref("s_real_user_id", str);
    }

    public String userName() {
        return stringPref("s_user_name");
    }

    public void userName(String str) {
        stringPref("s_user_name", str);
    }

    public String token() {
        return stringPref("s_token");
    }

    public void token(String str) {
        stringPref("s_token", str);
    }

    public String firebaseToken() {
        return stringPref("s_firebase_token");
    }

    public void firebaseToken(String str) {
        stringPref("s_firebase_token", str);
    }

    public String loginSource() {
        return stringPref("s_login_source");
    }

    public void loginSource(String str) {
        stringPref("s_login_source", str);
    }

    public String name() {
        return stringPref("s_name");
    }

    public void name(String str) {
        stringPref("s_name", str);
    }

    public String profilePic() {
        return stringPref("s_profile_pic");
    }

    public void profilePic(String str) {
        stringPref("s_profile_pic", str);
    }

    public String profilePicThumbnail() {
        return stringPref("s_profile_pic_thumbnail");
    }

    public void profilePicThumbnail(String str) {
        stringPref("s_profile_pic_thumbnail", str);
    }

    public String coverPic() {
        return stringPref("s_cover_pic");
    }

    public void coverPic(String str) {
        stringPref("s_cover_pic", str);
    }

    public String coverPicThumbnail() {
        return stringPref("s_cover_pic_thumbnail");
    }

    public void coverPicThumbnail(String str) {
        stringPref("s_cover_pic_thumbnail", str);
    }

    public String email() {
        return stringPref("s_email");
    }

    public void email(String str) {
        stringPref("s_email", str);
    }

    public String age() {
        return stringPref("s_age");
    }

    public void age(String str) {
        stringPref("s_age", str);
    }

    public String bio() {
        return stringPref("s_bio");
    }

    public void bio(String str) {
        stringPref("s_bio", str);
    }

    public String location() {
        return stringPref("s_location");
    }

    public void location(String str) {
        stringPref("s_location", str);
    }

    public boolean appRatingConfirmed() {
        return booleanPref("s_app_rating_confirmed");
    }

    public void setAppRatingConfirmed(boolean z) {
        booleanPref("s_app_rating_confirmed", z);
    }

    public String jwtToken() {
        return stringPref("s_jwt_token");
    }

    public void jwtToken(String str) {
        stringPref("s_jwt_token", str);
    }

    public Integer messagingId() {
        String realUserId = realUserId();
        if (realUserId != null) {
            return StringsKt.toIntOrNull(realUserId);
        }
        return null;
    }

    public boolean autoSavePost() {
        return booleanPrefWithDefault("s_auto_save_post", true);
    }

    public void setAutoSavePost(boolean z) {
        booleanPref("s_auto_save_post", z);
    }

    public boolean isPlaybackSoundMuted() {
        return booleanPrefWithDefault("s_post_sound_muted", true);
    }

    public void setPlaybackSoundMuted(boolean z) {
        booleanPref("s_post_sound_muted", z);
    }

    public void clear() {
        this.sharedPreferences.edit().clear().commit();
    }

    public void clearUser() {
        clear();
    }

    public String stringPref(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String string = this.sharedPreferences.getString(str, (String) null);
        Timber.m300d("<-- stringPref(" + str + ") = " + string, new Object[0]);
        return string;
    }

    public void stringPref(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Timber.m300d("--> stringPref(" + str + ", " + str2 + ')', new Object[0]);
        this.sharedPreferences.edit().putString(str, str2).commit();
    }

    public boolean booleanPref(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return booleanPrefWithDefault(str, false);
    }

    public boolean booleanPrefWithDefault(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        boolean z2 = this.sharedPreferences.getBoolean(str, z);
        Timber.m300d("<-- booleanPref(" + str + ", default=" + z + ") = " + z2, new Object[0]);
        return z2;
    }

    public void booleanPref(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        Timber.m300d("--> booleanPref(" + str + ", " + z + ')', new Object[0]);
        this.sharedPreferences.edit().putBoolean(str, z).commit();
    }

    public int intPref(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        int i = this.sharedPreferences.getInt(str, -1);
        Timber.m300d("<-- intPref(" + str + ") = " + i, new Object[0]);
        return i;
    }

    public void intPref(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Timber.m300d("--> intPref(" + str + ", " + i + ')', new Object[0]);
        this.sharedPreferences.edit().putInt(str, i).commit();
    }

    public long longPref(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        long j = this.sharedPreferences.getLong(str, -1);
        Timber.m300d("<-- longPref(" + str + ") = " + j, new Object[0]);
        return j;
    }

    public void longPref(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        Timber.m300d("--> intPref(" + str + ", " + j + ')', new Object[0]);
        this.sharedPreferences.edit().putLong(str, j).commit();
    }
}
