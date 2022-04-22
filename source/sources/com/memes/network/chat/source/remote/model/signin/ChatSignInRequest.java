package com.memes.network.chat.source.remote.model.signin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;", "", "userId", "", "userToken", "userName", "userImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getUserImage", "getUserName", "getUserToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatSignInRequest.kt */
public final class ChatSignInRequest {
    @SerializedName("user_id")
    @Expose
    private final String userId;
    private final transient String userImage;
    private final transient String userName;
    @SerializedName("login_token")
    @Expose
    private final String userToken;

    public static /* synthetic */ ChatSignInRequest copy$default(ChatSignInRequest chatSignInRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatSignInRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = chatSignInRequest.userToken;
        }
        if ((i & 4) != 0) {
            str3 = chatSignInRequest.userName;
        }
        if ((i & 8) != 0) {
            str4 = chatSignInRequest.userImage;
        }
        return chatSignInRequest.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final String component3() {
        return this.userName;
    }

    public final String component4() {
        return this.userImage;
    }

    public final ChatSignInRequest copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "userToken");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_NAME);
        return new ChatSignInRequest(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatSignInRequest)) {
            return false;
        }
        ChatSignInRequest chatSignInRequest = (ChatSignInRequest) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) chatSignInRequest.userId) && Intrinsics.areEqual((Object) this.userToken, (Object) chatSignInRequest.userToken) && Intrinsics.areEqual((Object) this.userName, (Object) chatSignInRequest.userName) && Intrinsics.areEqual((Object) this.userImage, (Object) chatSignInRequest.userImage);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userToken;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.userName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.userImage;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ChatSignInRequest(userId=" + this.userId + ", userToken=" + this.userToken + ", userName=" + this.userName + ", userImage=" + this.userImage + ")";
    }

    public ChatSignInRequest(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "userToken");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_NAME);
        this.userId = str;
        this.userToken = str2;
        this.userName = str3;
        this.userImage = str4;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserImage() {
        return this.userImage;
    }
}
