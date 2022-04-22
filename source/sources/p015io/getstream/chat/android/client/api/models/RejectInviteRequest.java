package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/RejectInviteRequest;", "", "rejectInvite", "", "(Z)V", "getRejectInvite", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.RejectInviteRequest */
/* compiled from: RejectInviteRequest.kt */
public final class RejectInviteRequest {
    @SerializedName("reject_invite")
    private final boolean rejectInvite;

    public RejectInviteRequest() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RejectInviteRequest copy$default(RejectInviteRequest rejectInviteRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = rejectInviteRequest.rejectInvite;
        }
        return rejectInviteRequest.copy(z);
    }

    public final boolean component1() {
        return this.rejectInvite;
    }

    public final RejectInviteRequest copy(boolean z) {
        return new RejectInviteRequest(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RejectInviteRequest) && this.rejectInvite == ((RejectInviteRequest) obj).rejectInvite;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.rejectInvite;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "RejectInviteRequest(rejectInvite=" + this.rejectInvite + ")";
    }

    public RejectInviteRequest(boolean z) {
        this.rejectInvite = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RejectInviteRequest(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final boolean getRejectInvite() {
        return this.rejectInvite;
    }
}
