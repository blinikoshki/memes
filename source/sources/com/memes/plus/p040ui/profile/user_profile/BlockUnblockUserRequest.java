package com.memes.plus.p040ui.profile.user_profile;

import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "targetUserId", "", "(Ljava/lang/String;)V", "getTargetUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.BlockUnblockUserRequest */
/* compiled from: BlockUnblockUserRequest.kt */
public final class BlockUnblockUserRequest extends AuthenticatedContentRequest {
    @SerializedName("block_user")
    private final String targetUserId;

    public static /* synthetic */ BlockUnblockUserRequest copy$default(BlockUnblockUserRequest blockUnblockUserRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blockUnblockUserRequest.targetUserId;
        }
        return blockUnblockUserRequest.copy(str);
    }

    public final String component1() {
        return this.targetUserId;
    }

    public final BlockUnblockUserRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, "targetUserId");
        return new BlockUnblockUserRequest(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BlockUnblockUserRequest) && Intrinsics.areEqual((Object) this.targetUserId, (Object) ((BlockUnblockUserRequest) obj).targetUserId);
        }
        return true;
    }

    public int hashCode() {
        String str = this.targetUserId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "BlockUnblockUserRequest(targetUserId=" + this.targetUserId + ")";
    }

    public final String getTargetUserId() {
        return this.targetUserId;
    }

    public BlockUnblockUserRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "targetUserId");
        this.targetUserId = str;
    }
}
