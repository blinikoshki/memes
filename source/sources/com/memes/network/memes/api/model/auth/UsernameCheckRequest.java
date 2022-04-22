package com.memes.network.memes.api.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;", "", "userName", "", "(Ljava/lang/String;)V", "getUserName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UsernameCheckRequest.kt */
public final class UsernameCheckRequest {
    @SerializedName("username")
    @Expose
    private final String userName;

    public static /* synthetic */ UsernameCheckRequest copy$default(UsernameCheckRequest usernameCheckRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = usernameCheckRequest.userName;
        }
        return usernameCheckRequest.copy(str);
    }

    public final String component1() {
        return this.userName;
    }

    public final UsernameCheckRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_NAME);
        return new UsernameCheckRequest(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UsernameCheckRequest) && Intrinsics.areEqual((Object) this.userName, (Object) ((UsernameCheckRequest) obj).userName);
        }
        return true;
    }

    public int hashCode() {
        String str = this.userName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "UsernameCheckRequest(userName=" + this.userName + ")";
    }

    public UsernameCheckRequest(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_NAME);
        this.userName = str;
    }

    public final String getUserName() {
        return this.userName;
    }
}
