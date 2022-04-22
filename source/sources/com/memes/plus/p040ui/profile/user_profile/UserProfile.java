package com.memes.plus.p040ui.profile.user_profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.ApiRouting;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00102\u001a\u0004\u0018\u00010\nJ\b\u00103\u001a\u0004\u0018\u00010\nJ\b\u00104\u001a\u0004\u0018\u00010\nJ\b\u00105\u001a\u0004\u0018\u00010\nJ\b\u00106\u001a\u0004\u0018\u00010\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R \u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R \u0010&\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R \u0010)\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R \u0010,\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R \u0010/\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019¨\u00067"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/user_profile/UserProfile;", "", "()V", "blocked", "", "getBlocked", "()Z", "setBlocked", "(Z)V", "coverImage", "", "coverImageThumb", "followed", "getFollowed", "setFollowed", "follower", "", "getFollower", "()J", "setFollower", "(J)V", "following", "getFollowing", "()Ljava/lang/String;", "setFollowing", "(Ljava/lang/String;)V", "id", "getId", "setId", "isProUser", "location", "getLocation", "setLocation", "profileImage", "profileImageThumb", "totalPosts", "getTotalPosts", "setTotalPosts", "totallikes", "getTotallikes", "setTotallikes", "userBio", "getUserBio", "setUserBio", "userId", "getUserId", "setUserId", "username", "getUsername", "setUsername", "getCoverImage", "getCoverImageThumb", "getMessagingId", "getProfileImage", "getProfileImageThumb", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfile */
/* compiled from: UserProfile.kt */
public final class UserProfile {
    @SerializedName("blocked")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean blocked;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;
    @SerializedName("coverImageThumb")
    @Expose
    private String coverImageThumb;
    @SerializedName("iamfollowing")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean followed;
    @SerializedName("follower")
    @Expose
    private long follower;
    @SerializedName("following")
    @Expose
    private String following;
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private String f1033id;
    @SerializedName("pro_user")
    private final boolean isProUser;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;
    @SerializedName("profileImageThumb")
    @Expose
    private String profileImageThumb;
    @SerializedName("totalPosts")
    @Expose
    private String totalPosts;
    @SerializedName("totalLikes")
    @Expose
    private String totallikes;
    @SerializedName("user_bio")
    @Expose
    private String userBio;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;

    public final String getId() {
        return this.f1033id;
    }

    public final void setId(String str) {
        this.f1033id = str;
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

    public final String getTotalPosts() {
        return this.totalPosts;
    }

    public final void setTotalPosts(String str) {
        this.totalPosts = str;
    }

    public final String getTotallikes() {
        return this.totallikes;
    }

    public final void setTotallikes(String str) {
        this.totallikes = str;
    }

    public final String getFollowing() {
        return this.following;
    }

    public final void setFollowing(String str) {
        this.following = str;
    }

    public final long getFollower() {
        return this.follower;
    }

    public final void setFollower(long j) {
        this.follower = j;
    }

    public final boolean getFollowed() {
        return this.followed;
    }

    public final void setFollowed(boolean z) {
        this.followed = z;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String str) {
        this.location = str;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    public final String getUserBio() {
        return this.userBio;
    }

    public final void setUserBio(String str) {
        this.userBio = str;
    }

    public final boolean getBlocked() {
        return this.blocked;
    }

    public final void setBlocked(boolean z) {
        this.blocked = z;
    }

    public final String getMessagingId() {
        return this.f1033id;
    }

    public final String getProfileImage() {
        if (Intrinsics.areEqual((Object) this.profileImage, (Object) ApiRouting.MEMES_CDN)) {
            return null;
        }
        return this.profileImage;
    }

    public final String getProfileImageThumb() {
        if (Intrinsics.areEqual((Object) this.profileImageThumb, (Object) ApiRouting.MEMES_CDN)) {
            return null;
        }
        return this.profileImageThumb;
    }

    public final String getCoverImage() {
        if (Intrinsics.areEqual((Object) this.coverImage, (Object) ApiRouting.MEMES_CDN)) {
            return null;
        }
        return this.coverImage;
    }

    public final String getCoverImageThumb() {
        if (Intrinsics.areEqual((Object) this.coverImageThumb, (Object) ApiRouting.MEMES_CDN)) {
            return null;
        }
        return this.coverImageThumb;
    }
}
