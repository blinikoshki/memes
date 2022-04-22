package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/ReactionRequest;", "", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "enforceUnique", "", "(Lio/getstream/chat/android/client/models/Reaction;Z)V", "getEnforceUnique", "()Z", "getReaction", "()Lio/getstream/chat/android/client/models/Reaction;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.ReactionRequest */
/* compiled from: ReactionRequest.kt */
public final class ReactionRequest {
    @SerializedName("enforce_unique")
    private final boolean enforceUnique;
    private final Reaction reaction;

    public static /* synthetic */ ReactionRequest copy$default(ReactionRequest reactionRequest, Reaction reaction2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            reaction2 = reactionRequest.reaction;
        }
        if ((i & 2) != 0) {
            z = reactionRequest.enforceUnique;
        }
        return reactionRequest.copy(reaction2, z);
    }

    public final Reaction component1() {
        return this.reaction;
    }

    public final boolean component2() {
        return this.enforceUnique;
    }

    public final ReactionRequest copy(Reaction reaction2, boolean z) {
        Intrinsics.checkNotNullParameter(reaction2, "reaction");
        return new ReactionRequest(reaction2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactionRequest)) {
            return false;
        }
        ReactionRequest reactionRequest = (ReactionRequest) obj;
        return Intrinsics.areEqual((Object) this.reaction, (Object) reactionRequest.reaction) && this.enforceUnique == reactionRequest.enforceUnique;
    }

    public int hashCode() {
        Reaction reaction2 = this.reaction;
        int hashCode = (reaction2 != null ? reaction2.hashCode() : 0) * 31;
        boolean z = this.enforceUnique;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "ReactionRequest(reaction=" + this.reaction + ", enforceUnique=" + this.enforceUnique + ")";
    }

    public ReactionRequest(Reaction reaction2, boolean z) {
        Intrinsics.checkNotNullParameter(reaction2, "reaction");
        this.reaction = reaction2;
        this.enforceUnique = z;
    }

    public final Reaction getReaction() {
        return this.reaction;
    }

    public final boolean getEnforceUnique() {
        return this.enforceUnique;
    }
}
