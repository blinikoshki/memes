package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/CompletableResponse;", "", "duration", "", "(Ljava/lang/String;)V", "getDuration", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.CompletableResponse */
/* compiled from: CompletableResponse.kt */
public final class CompletableResponse {
    private final String duration;

    public CompletableResponse() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CompletableResponse copy$default(CompletableResponse completableResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = completableResponse.duration;
        }
        return completableResponse.copy(str);
    }

    public final String component1() {
        return this.duration;
    }

    public final CompletableResponse copy(String str) {
        Intrinsics.checkNotNullParameter(str, "duration");
        return new CompletableResponse(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CompletableResponse) && Intrinsics.areEqual((Object) this.duration, (Object) ((CompletableResponse) obj).duration);
        }
        return true;
    }

    public int hashCode() {
        String str = this.duration;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CompletableResponse(duration=" + this.duration + ")";
    }

    public CompletableResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "duration");
        this.duration = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompletableResponse(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getDuration() {
        return this.duration;
    }
}
