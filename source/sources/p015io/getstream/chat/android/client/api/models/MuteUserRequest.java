package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/MuteUserRequest;", "", "targetId", "", "userId", "(Ljava/lang/String;Ljava/lang/String;)V", "getTargetId", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.MuteUserRequest */
/* compiled from: MuteUserRequest.kt */
public final class MuteUserRequest {
    @SerializedName("target_id")
    private final String targetId;
    @SerializedName("user_id")
    private final String userId;

    public static /* synthetic */ MuteUserRequest copy$default(MuteUserRequest muteUserRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = muteUserRequest.targetId;
        }
        if ((i & 2) != 0) {
            str2 = muteUserRequest.userId;
        }
        return muteUserRequest.copy(str, str2);
    }

    public final String component1() {
        return this.targetId;
    }

    public final String component2() {
        return this.userId;
    }

    public final MuteUserRequest copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_ID);
        return new MuteUserRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MuteUserRequest)) {
            return false;
        }
        MuteUserRequest muteUserRequest = (MuteUserRequest) obj;
        return Intrinsics.areEqual((Object) this.targetId, (Object) muteUserRequest.targetId) && Intrinsics.areEqual((Object) this.userId, (Object) muteUserRequest.userId);
    }

    public int hashCode() {
        String str = this.targetId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MuteUserRequest(targetId=" + this.targetId + ", userId=" + this.userId + ")";
    }

    public MuteUserRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_ID);
        this.targetId = str;
        this.userId = str2;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final String getUserId() {
        return this.userId;
    }
}
