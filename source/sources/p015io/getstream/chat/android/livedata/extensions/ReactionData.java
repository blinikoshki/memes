package p015io.getstream.chat.android.livedata.extensions;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BI\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JU\u0010\u0016\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/extensions/ReactionData;", "", "reactionCounts", "", "", "", "reactionScores", "latestReactions", "", "Lio/getstream/chat/android/client/models/Reaction;", "ownReactions", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)V", "getLatestReactions", "()Ljava/util/List;", "getOwnReactions", "getReactionCounts", "()Ljava/util/Map;", "getReactionScores", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.extensions.ReactionData */
/* compiled from: MessageReactionExtensions.kt */
final class ReactionData {
    private final List<Reaction> latestReactions;
    private final List<Reaction> ownReactions;
    private final Map<String, Integer> reactionCounts;
    private final Map<String, Integer> reactionScores;

    public static /* synthetic */ ReactionData copy$default(ReactionData reactionData, Map<String, Integer> map, Map<String, Integer> map2, List<Reaction> list, List<Reaction> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = reactionData.reactionCounts;
        }
        if ((i & 2) != 0) {
            map2 = reactionData.reactionScores;
        }
        if ((i & 4) != 0) {
            list = reactionData.latestReactions;
        }
        if ((i & 8) != 0) {
            list2 = reactionData.ownReactions;
        }
        return reactionData.copy(map, map2, list, list2);
    }

    public final Map<String, Integer> component1() {
        return this.reactionCounts;
    }

    public final Map<String, Integer> component2() {
        return this.reactionScores;
    }

    public final List<Reaction> component3() {
        return this.latestReactions;
    }

    public final List<Reaction> component4() {
        return this.ownReactions;
    }

    public final ReactionData copy(Map<String, Integer> map, Map<String, Integer> map2, List<Reaction> list, List<Reaction> list2) {
        Intrinsics.checkNotNullParameter(map, "reactionCounts");
        Intrinsics.checkNotNullParameter(map2, "reactionScores");
        Intrinsics.checkNotNullParameter(list, "latestReactions");
        Intrinsics.checkNotNullParameter(list2, "ownReactions");
        return new ReactionData(map, map2, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactionData)) {
            return false;
        }
        ReactionData reactionData = (ReactionData) obj;
        return Intrinsics.areEqual((Object) this.reactionCounts, (Object) reactionData.reactionCounts) && Intrinsics.areEqual((Object) this.reactionScores, (Object) reactionData.reactionScores) && Intrinsics.areEqual((Object) this.latestReactions, (Object) reactionData.latestReactions) && Intrinsics.areEqual((Object) this.ownReactions, (Object) reactionData.ownReactions);
    }

    public int hashCode() {
        Map<String, Integer> map = this.reactionCounts;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, Integer> map2 = this.reactionScores;
        int hashCode2 = (hashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        List<Reaction> list = this.latestReactions;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Reaction> list2 = this.ownReactions;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ReactionData(reactionCounts=" + this.reactionCounts + ", reactionScores=" + this.reactionScores + ", latestReactions=" + this.latestReactions + ", ownReactions=" + this.ownReactions + ")";
    }

    public ReactionData(Map<String, Integer> map, Map<String, Integer> map2, List<Reaction> list, List<Reaction> list2) {
        Intrinsics.checkNotNullParameter(map, "reactionCounts");
        Intrinsics.checkNotNullParameter(map2, "reactionScores");
        Intrinsics.checkNotNullParameter(list, "latestReactions");
        Intrinsics.checkNotNullParameter(list2, "ownReactions");
        this.reactionCounts = map;
        this.reactionScores = map2;
        this.latestReactions = list;
        this.ownReactions = list2;
    }

    public final Map<String, Integer> getReactionCounts() {
        return this.reactionCounts;
    }

    public final Map<String, Integer> getReactionScores() {
        return this.reactionScores;
    }

    public final List<Reaction> getLatestReactions() {
        return this.latestReactions;
    }

    public final List<Reaction> getOwnReactions() {
        return this.ownReactions;
    }
}
