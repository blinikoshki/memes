package com.memes.plus.p040ui.user_listing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.ApiRouting;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\b\u0010#\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u0016\u0010\u0012\u001a\u00020\n8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006$"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/ListedUser;", "", "()V", "fullName", "", "getFullName", "()Ljava/lang/String;", "setFullName", "(Ljava/lang/String;)V", "iamfollowing", "", "getIamfollowing", "()Z", "setIamfollowing", "(Z)V", "id", "getId", "setId", "isProUser", "profileImage", "getProfileImage", "setProfileImage", "profileImageThumb", "getProfileImageThumb", "setProfileImageThumb", "shouldShowCloseButton", "getShouldShowCloseButton", "setShouldShowCloseButton", "userId", "getUserId", "setUserId", "username", "getUsername", "setUsername", "getProfileImageThumbnailUrl", "getProfileImageUrl", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.ListedUser */
/* compiled from: ListedUser.kt */
public class ListedUser {
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("iamfollowing")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean iamfollowing;
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private String f1035id;
    @SerializedName("pro_user")
    @Expose
    private final boolean isProUser;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;
    @SerializedName("profileImageThumb")
    @Expose
    private String profileImageThumb;
    private boolean shouldShowCloseButton;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;

    public final boolean getIamfollowing() {
        return this.iamfollowing;
    }

    public final void setIamfollowing(boolean z) {
        this.iamfollowing = z;
    }

    public final String getProfileImage() {
        return this.profileImage;
    }

    public final void setProfileImage(String str) {
        this.profileImage = str;
    }

    public final String getProfileImageThumb() {
        return this.profileImageThumb;
    }

    public final void setProfileImageThumb(String str) {
        this.profileImageThumb = str;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final void setFullName(String str) {
        this.fullName = str;
    }

    public final String getId() {
        return this.f1035id;
    }

    public final void setId(String str) {
        this.f1035id = str;
    }

    public final boolean getShouldShowCloseButton() {
        return this.shouldShowCloseButton;
    }

    public final void setShouldShowCloseButton(boolean z) {
        this.shouldShowCloseButton = z;
    }

    public final String getProfileImageUrl() {
        if (Intrinsics.areEqual((Object) this.profileImage, (Object) ApiRouting.MEMES_CDN)) {
            return null;
        }
        return this.profileImage;
    }

    public final String getProfileImageThumbnailUrl() {
        if (Intrinsics.areEqual((Object) this.profileImageThumb, (Object) ApiRouting.MEMES_CDN)) {
            return null;
        }
        return this.profileImageThumb;
    }
}
