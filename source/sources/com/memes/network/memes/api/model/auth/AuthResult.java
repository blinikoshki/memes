package com.memes.network.memes.api.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b,\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00060"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/auth/AuthResult;", "", "()V", "age", "", "getAge", "()Ljava/lang/String;", "setAge", "(Ljava/lang/String;)V", "coverImage", "getCoverImage", "setCoverImage", "coverImageThumb", "getCoverImageThumb", "setCoverImageThumb", "email", "getEmail", "setEmail", "fullName", "getFullName", "setFullName", "id", "getId", "setId", "location", "getLocation", "setLocation", "loginToken", "getLoginToken", "setLoginToken", "profileImage", "getProfileImage", "setProfileImage", "profileImageThumb", "getProfileImageThumb", "setProfileImageThumb", "userBio", "getUserBio", "setUserBio", "userId", "getUserId", "setUserId", "userType", "getUserType", "setUserType", "username", "getUsername", "setUsername", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AuthResult.kt */
public final class AuthResult {
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
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private String f991id;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("loginToken")
    @Expose
    private String loginToken;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;
    @SerializedName("profileImageThumb")
    @Expose
    private String profileImageThumb;
    @SerializedName("user_bio")
    @Expose
    private String userBio;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("userType")
    @Expose
    private String userType;
    @SerializedName("username")
    @Expose
    private String username;

    public final String getId() {
        return this.f991id;
    }

    public final void setId(String str) {
        this.f991id = str;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final void setUserType(String str) {
        this.userType = str;
    }

    public final String getProfileImageThumb() {
        return this.profileImageThumb;
    }

    public final void setProfileImageThumb(String str) {
        this.profileImageThumb = str;
    }

    public final String getCoverImage() {
        return this.coverImage;
    }

    public final void setCoverImage(String str) {
        this.coverImage = str;
    }

    public final String getCoverImageThumb() {
        return this.coverImageThumb;
    }

    public final void setCoverImageThumb(String str) {
        this.coverImageThumb = str;
    }

    public final String getProfileImage() {
        return this.profileImage;
    }

    public final void setProfileImage(String str) {
        this.profileImage = str;
    }

    public final String getLoginToken() {
        return this.loginToken;
    }

    public final void setLoginToken(String str) {
        this.loginToken = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getUserBio() {
        return this.userBio;
    }

    public final void setUserBio(String str) {
        this.userBio = str;
    }

    public final String getAge() {
        return this.age;
    }

    public final void setAge(String str) {
        this.age = str;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String str) {
        this.location = str;
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

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }
}
