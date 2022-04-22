package com.memes.plus.p040ui.profile.user_profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.api_response.ApiListResponse;
import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/user_profile/UserProfileResponse;", "Lcom/memes/plus/data/api_response/ApiListResponse;", "Lcom/memes/plus/ui/posts/Post;", "()V", "userProfile", "Lcom/memes/plus/ui/profile/user_profile/UserProfile;", "getUserProfile", "()Lcom/memes/plus/ui/profile/user_profile/UserProfile;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileResponse */
/* compiled from: UserProfileResponse.kt */
public final class UserProfileResponse extends ApiListResponse<Post> {
    @SerializedName("TopData")
    @Expose
    private final UserProfile userProfile;

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }
}
