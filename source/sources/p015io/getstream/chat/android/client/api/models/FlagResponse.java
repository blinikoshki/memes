package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Flag;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/FlagResponse;", "", "flag", "Lio/getstream/chat/android/client/models/Flag;", "(Lio/getstream/chat/android/client/models/Flag;)V", "getFlag", "()Lio/getstream/chat/android/client/models/Flag;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.FlagResponse */
/* compiled from: FlagResponse.kt */
public final class FlagResponse {
    private final Flag flag;

    public static /* synthetic */ FlagResponse copy$default(FlagResponse flagResponse, Flag flag2, int i, Object obj) {
        if ((i & 1) != 0) {
            flag2 = flagResponse.flag;
        }
        return flagResponse.copy(flag2);
    }

    public final Flag component1() {
        return this.flag;
    }

    public final FlagResponse copy(Flag flag2) {
        Intrinsics.checkNotNullParameter(flag2, "flag");
        return new FlagResponse(flag2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FlagResponse) && Intrinsics.areEqual((Object) this.flag, (Object) ((FlagResponse) obj).flag);
        }
        return true;
    }

    public int hashCode() {
        Flag flag2 = this.flag;
        if (flag2 != null) {
            return flag2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "FlagResponse(flag=" + this.flag + ")";
    }

    public FlagResponse(Flag flag2) {
        Intrinsics.checkNotNullParameter(flag2, "flag");
        this.flag = flag2;
    }

    public final Flag getFlag() {
        return this.flag;
    }
}
