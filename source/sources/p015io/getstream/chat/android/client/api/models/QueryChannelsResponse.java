package p015io.getstream.chat.android.client.api.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QueryChannelsResponse;", "", "channels", "", "Lio/getstream/chat/android/client/api/models/ChannelResponse;", "(Ljava/util/List;)V", "getChannels", "()Ljava/util/List;", "setChannels", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.QueryChannelsResponse */
/* compiled from: QueryChannelsResponse.kt */
public final class QueryChannelsResponse {
    private List<ChannelResponse> channels;

    public QueryChannelsResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QueryChannelsResponse copy$default(QueryChannelsResponse queryChannelsResponse, List<ChannelResponse> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = queryChannelsResponse.channels;
        }
        return queryChannelsResponse.copy(list);
    }

    public final List<ChannelResponse> component1() {
        return this.channels;
    }

    public final QueryChannelsResponse copy(List<ChannelResponse> list) {
        Intrinsics.checkNotNullParameter(list, "channels");
        return new QueryChannelsResponse(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof QueryChannelsResponse) && Intrinsics.areEqual((Object) this.channels, (Object) ((QueryChannelsResponse) obj).channels);
        }
        return true;
    }

    public int hashCode() {
        List<ChannelResponse> list = this.channels;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "QueryChannelsResponse(channels=" + this.channels + ")";
    }

    public QueryChannelsResponse(List<ChannelResponse> list) {
        Intrinsics.checkNotNullParameter(list, "channels");
        this.channels = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryChannelsResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<ChannelResponse> getChannels() {
        return this.channels;
    }

    public final void setChannels(List<ChannelResponse> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.channels = list;
    }
}
