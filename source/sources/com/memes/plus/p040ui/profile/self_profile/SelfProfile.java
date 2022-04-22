package com.memes.plus.p040ui.profile.self_profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.ApiRouting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00100\u001a\u0004\u0018\u00010\u0004J\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u00102\u001a\u0004\u0018\u00010\u0004J\b\u00103\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR \u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u0016\u0010\u001a\u001a\u00020\u001b8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u0014\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR \u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR \u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00064"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "", "()V", "age", "", "getAge", "()Ljava/lang/String;", "setAge", "(Ljava/lang/String;)V", "coverImage", "coverImageThumb", "email", "getEmail", "setEmail", "follower", "getFollower", "setFollower", "following", "getFollowing", "setFollowing", "fullName", "getFullName", "setFullName", "id", "getId", "setId", "isProUser", "", "()Z", "location", "getLocation", "setLocation", "profileImage", "profileImageThumb", "totalPosts", "getTotalPosts", "setTotalPosts", "totallikes", "getTotallikes", "setTotallikes", "userBio", "getUserBio", "setUserBio", "userId", "getUserId", "username", "getUsername", "setUsername", "getCoverImage", "getCoverImageThumb", "getProfileImage", "getProfileImageThumb", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfile */
/* compiled from: SelfProfile.kt */
public final class SelfProfile {
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;
    @SerializedName("coverImageThumb")
    @Expose
    private String coverImageThumb;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("follower")
    @Expose
    private String follower;
    @SerializedName("following")
    @Expose
    private String following;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private String f1032id;
    @SerializedName("pro_user")
    @Expose
    private final boolean isProUser;
    @SerializedName("user_location")
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
    private final String userId;
    @SerializedName("username")
    @Expose
    private String username;

    public final String getId() {
        return this.f1032id;
    }

    public final void setId(String str) {
        this.f1032id = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
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

    public final String getAge() {
        return this.age;
    }

    public final void setAge(String str) {
        this.age = str;
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

    public final String getFollower() {
        return this.follower;
    }

    public final void setFollower(String str) {
        this.follower = str;
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
