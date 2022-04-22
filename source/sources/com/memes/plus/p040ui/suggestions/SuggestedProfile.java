package com.memes.plus.p040ui.suggestions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.user_listing.ListedUser;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\r8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000b¨\u0006!"}, mo26107d2 = {"Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "", "()V", "followers", "", "getFollowers", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "fullName", "", "getFullName", "()Ljava/lang/String;", "iamFollowing", "", "getIamFollowing", "()Z", "setIamFollowing", "(Z)V", "id", "getId", "isProUser", "profileImage", "getProfileImage", "profileImageThumb", "getProfileImageThumb", "userId", "getUserId", "username", "getUsername", "requireUserId", "requireUserName", "toListUser", "Lcom/memes/plus/ui/user_listing/ListedUser;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.suggestions.SuggestedProfile */
/* compiled from: SuggestedProfile.kt */
public final class SuggestedProfile {
    @SerializedName("followers")
    @Expose
    private final Integer followers;
    @SerializedName("full_name")
    @Expose
    private final String fullName;
    private boolean iamFollowing;
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private final String f1034id;
    @SerializedName("pro_user")
    @Expose
    private final boolean isProUser;
    @SerializedName("profileImage")
    @Expose
    private final String profileImage;
    @SerializedName("profileImageThumb")
    @Expose
    private final String profileImageThumb;
    @SerializedName("user_id")
    @Expose
    private final String userId;
    @SerializedName("username")
    @Expose
    private final String username;

    public final String getUserId() {
        return this.userId;
    }

    public final String getId() {
        return this.f1034id;
    }

    public final String getUsername() {
        return this.username;
    }

    public final Integer getFollowers() {
        return this.followers;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getProfileImageThumb() {
        return this.profileImageThumb;
    }

    public final String getProfileImage() {
        return this.profileImage;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    public final boolean getIamFollowing() {
        return this.iamFollowing;
    }

    public final void setIamFollowing(boolean z) {
        this.iamFollowing = z;
    }

    public final ListedUser toListUser() {
        ListedUser listedUser = new ListedUser();
        listedUser.setFullName(this.username);
        listedUser.setIamfollowing(this.iamFollowing);
        listedUser.setId(this.f1034id);
        listedUser.setProfileImage(this.profileImage);
        listedUser.setProfileImageThumb(this.profileImageThumb);
        listedUser.setUsername("Suggested for You");
        listedUser.setUserId(this.userId);
        listedUser.setShouldShowCloseButton(true);
        return listedUser;
    }

    public final String requireUserId() {
        String str = this.userId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String requireUserName() {
        String str = this.username;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
