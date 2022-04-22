package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/MarkReadRequest;", "", "message_id", "", "(Ljava/lang/String;)V", "getMessage_id", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.MarkReadRequest */
/* compiled from: MarkReadRequest.kt */
public final class MarkReadRequest {
    private final String message_id;

    public static /* synthetic */ MarkReadRequest copy$default(MarkReadRequest markReadRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = markReadRequest.message_id;
        }
        return markReadRequest.copy(str);
    }

    public final String component1() {
        return this.message_id;
    }

    public final MarkReadRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, "message_id");
        return new MarkReadRequest(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MarkReadRequest) && Intrinsics.areEqual((Object) this.message_id, (Object) ((MarkReadRequest) obj).message_id);
        }
        return true;
    }

    public int hashCode() {
        String str = this.message_id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MarkReadRequest(message_id=" + this.message_id + ")";
    }

    public MarkReadRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "message_id");
        this.message_id = str;
    }

    public final String getMessage_id() {
        return this.message_id;
    }
}
