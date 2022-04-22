package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/ReactionResponse;", "", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "(Lio/getstream/chat/android/client/models/Reaction;)V", "getReaction", "()Lio/getstream/chat/android/client/models/Reaction;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.ReactionResponse */
/* compiled from: ReactionResponse.kt */
public final class ReactionResponse {
    private final Reaction reaction;

    public static /* synthetic */ ReactionResponse copy$default(ReactionResponse reactionResponse, Reaction reaction2, int i, Object obj) {
        if ((i & 1) != 0) {
            reaction2 = reactionResponse.reaction;
        }
        return reactionResponse.copy(reaction2);
    }

    public final Reaction component1() {
        return this.reaction;
    }

    public final ReactionResponse copy(Reaction reaction2) {
        Intrinsics.checkNotNullParameter(reaction2, "reaction");
        return new ReactionResponse(reaction2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ReactionResponse) && Intrinsics.areEqual((Object) this.reaction, (Object) ((ReactionResponse) obj).reaction);
        }
        return true;
    }

    public int hashCode() {
        Reaction reaction2 = this.reaction;
        if (reaction2 != null) {
            return reaction2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ReactionResponse(reaction=" + this.reaction + ")";
    }

    public ReactionResponse(Reaction reaction2) {
        Intrinsics.checkNotNullParameter(reaction2, "reaction");
        this.reaction = reaction2;
    }

    public final Reaction getReaction() {
        return this.reaction;
    }
}
