package com.memes.plus.p040ui.explore_search.people_search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR \u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006 "}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "()V", "followersCount", "", "getFollowersCount", "()Ljava/lang/String;", "setFollowersCount", "(Ljava/lang/String;)V", "fullName", "getFullName", "setFullName", "id", "getId", "setId", "isProUser", "", "()Z", "setProUser", "(Z)V", "newId", "getNewId", "setNewId", "profileImageThumbUrl", "getProfileImageThumbUrl", "setProfileImageThumbUrl", "profileImageUrl", "getProfileImageUrl", "setProfileImageUrl", "userName", "getUserName", "setUserName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResult */
/* compiled from: PeopleSearchResult.kt */
public class PeopleSearchResult extends CatalogueSearchResult {
    @SerializedName("followers")
    @Expose
    private String followersCount;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("user_id")
    @Expose

    /* renamed from: id */
    private String f1029id;
    @SerializedName("pro_user")
    @Expose
    private boolean isProUser;
    @SerializedName("id")
    @Expose
    private String newId;
    @SerializedName("profileImageThumb")
    @Expose
    private String profileImageThumbUrl;
    @SerializedName("profileImage")
    @Expose
    private String profileImageUrl;
    @SerializedName("username")
    @Expose
    private String userName;

    public final String getId() {
        return this.f1029id;
    }

    public final void setId(String str) {
        this.f1029id = str;
    }

    public final String getNewId() {
        return this.newId;
    }

    public final void setNewId(String str) {
        this.newId = str;
    }

    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public final void setProfileImageUrl(String str) {
        this.profileImageUrl = str;
    }

    public final String getProfileImageThumbUrl() {
        return this.profileImageThumbUrl;
    }

    public final void setProfileImageThumbUrl(String str) {
        this.profileImageThumbUrl = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final void setFullName(String str) {
        this.fullName = str;
    }

    public final String getFollowersCount() {
        return this.followersCount;
    }

    public final void setFollowersCount(String str) {
        this.followersCount = str;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    public final void setProUser(boolean z) {
        this.isProUser = z;
    }
}
