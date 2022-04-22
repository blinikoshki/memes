package com.giphy.sdk.analytics.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0016"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/models/User;", "Landroid/os/Parcelable;", "userId", "", "loggedInUserId", "randomId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLoggedInUserId", "()Ljava/lang/String;", "setLoggedInUserId", "(Ljava/lang/String;)V", "getRandomId", "setRandomId", "getUserId", "setUserId", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: User.kt */
public final class User implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("logged_in_user_id")
    private String loggedInUserId;
    @SerializedName("random_id")
    private String randomId;
    @SerializedName("user_id")
    private String userId;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new User(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new User[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.userId);
        parcel.writeString(this.loggedInUserId);
        parcel.writeString(this.randomId);
    }

    public User(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, TagPeopleActivity.USER_ID);
        this.userId = str;
        this.loggedInUserId = str2;
        this.randomId = str3;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.userId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ User(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getLoggedInUserId() {
        return this.loggedInUserId;
    }

    public final void setLoggedInUserId(String str) {
        this.loggedInUserId = str;
    }

    public final String getRandomId() {
        return this.randomId;
    }

    public final void setRandomId(String str) {
        this.randomId = str;
    }
}
