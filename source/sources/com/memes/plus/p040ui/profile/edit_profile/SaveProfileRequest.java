package com.memes.plus.p040ui.profile.edit_profile;

import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/SaveProfileRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "age", "", "getAge", "()Ljava/lang/String;", "setAge", "(Ljava/lang/String;)V", "bio", "getBio", "setBio", "coverPic", "getCoverPic", "setCoverPic", "location", "getLocation", "setLocation", "name", "getName", "setName", "profilePic", "getProfilePic", "setProfilePic", "userName", "getUserName", "setUserName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.SaveProfileRequest */
/* compiled from: SaveProfileRequest.kt */
public final class SaveProfileRequest extends AuthenticatedContentRequest {
    private String age;
    private String bio;
    private String coverPic;
    private String location;
    private String name;
    private String profilePic;
    private String userName;

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String str) {
        this.location = str;
    }

    public final String getBio() {
        return this.bio;
    }

    public final void setBio(String str) {
        this.bio = str;
    }

    public final String getAge() {
        return this.age;
    }

    public final void setAge(String str) {
        this.age = str;
    }

    public final String getProfilePic() {
        return this.profilePic;
    }

    public final void setProfilePic(String str) {
        this.profilePic = str;
    }

    public final String getCoverPic() {
        return this.coverPic;
    }

    public final void setCoverPic(String str) {
        this.coverPic = str;
    }
}
