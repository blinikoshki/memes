package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/HideChannelRequest;", "", "clearHistory", "", "(Z)V", "getClearHistory", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.HideChannelRequest */
/* compiled from: HideChannelRequest.kt */
public final class HideChannelRequest {
    private final boolean clearHistory;

    public HideChannelRequest() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HideChannelRequest copy$default(HideChannelRequest hideChannelRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hideChannelRequest.clearHistory;
        }
        return hideChannelRequest.copy(z);
    }

    public final boolean component1() {
        return this.clearHistory;
    }

    public final HideChannelRequest copy(boolean z) {
        return new HideChannelRequest(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof HideChannelRequest) && this.clearHistory == ((HideChannelRequest) obj).clearHistory;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.clearHistory;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "HideChannelRequest(clearHistory=" + this.clearHistory + ")";
    }

    public HideChannelRequest(boolean z) {
        this.clearHistory = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HideChannelRequest(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getClearHistory() {
        return this.clearHistory;
    }
}
