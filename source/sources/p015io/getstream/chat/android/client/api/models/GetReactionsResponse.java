package p015io.getstream.chat.android.client.api.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/GetReactionsResponse;", "", "reactions", "", "Lio/getstream/chat/android/client/models/Reaction;", "(Ljava/util/List;)V", "getReactions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.GetReactionsResponse */
/* compiled from: GetReactionsResponse.kt */
public final class GetReactionsResponse {
    private final List<Reaction> reactions;

    public GetReactionsResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetReactionsResponse copy$default(GetReactionsResponse getReactionsResponse, List<Reaction> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = getReactionsResponse.reactions;
        }
        return getReactionsResponse.copy(list);
    }

    public final List<Reaction> component1() {
        return this.reactions;
    }

    public final GetReactionsResponse copy(List<Reaction> list) {
        Intrinsics.checkNotNullParameter(list, "reactions");
        return new GetReactionsResponse(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof GetReactionsResponse) && Intrinsics.areEqual((Object) this.reactions, (Object) ((GetReactionsResponse) obj).reactions);
        }
        return true;
    }

    public int hashCode() {
        List<Reaction> list = this.reactions;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "GetReactionsResponse(reactions=" + this.reactions + ")";
    }

    public GetReactionsResponse(List<Reaction> list) {
        Intrinsics.checkNotNullParameter(list, "reactions");
        this.reactions = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetReactionsResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Reaction> getReactions() {
        return this.reactions;
    }
}
