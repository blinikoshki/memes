package p015io.getstream.chat.android.livedata.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo26107d2 = {"Lio/getstream/chat/android/livedata/request/QueryChannelsPaginationRequest;", "", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "channelOffset", "", "channelLimit", "messageLimit", "memberLimit", "(Lio/getstream/chat/android/client/api/models/QuerySort;IIII)V", "getChannelLimit", "()I", "getChannelOffset", "isFirstPage", "", "()Z", "getMemberLimit", "getMessageLimit", "getSort", "()Lio/getstream/chat/android/client/api/models/QuerySort;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest */
/* compiled from: QueryChannelsPaginationRequest.kt */
public final class QueryChannelsPaginationRequest {
    private final int channelLimit;
    private final int channelOffset;
    private final int memberLimit;
    private final int messageLimit;
    private final QuerySort<Channel> sort;

    public static /* synthetic */ QueryChannelsPaginationRequest copy$default(QueryChannelsPaginationRequest queryChannelsPaginationRequest, QuerySort<Channel> querySort, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            querySort = queryChannelsPaginationRequest.sort;
        }
        if ((i5 & 2) != 0) {
            i = queryChannelsPaginationRequest.channelOffset;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = queryChannelsPaginationRequest.channelLimit;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = queryChannelsPaginationRequest.messageLimit;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = queryChannelsPaginationRequest.memberLimit;
        }
        return queryChannelsPaginationRequest.copy(querySort, i6, i7, i8, i4);
    }

    public final QuerySort<Channel> component1() {
        return this.sort;
    }

    public final int component2() {
        return this.channelOffset;
    }

    public final int component3() {
        return this.channelLimit;
    }

    public final int component4() {
        return this.messageLimit;
    }

    public final int component5() {
        return this.memberLimit;
    }

    public final QueryChannelsPaginationRequest copy(QuerySort<Channel> querySort, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(querySort, "sort");
        return new QueryChannelsPaginationRequest(querySort, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryChannelsPaginationRequest)) {
            return false;
        }
        QueryChannelsPaginationRequest queryChannelsPaginationRequest = (QueryChannelsPaginationRequest) obj;
        return Intrinsics.areEqual((Object) this.sort, (Object) queryChannelsPaginationRequest.sort) && this.channelOffset == queryChannelsPaginationRequest.channelOffset && this.channelLimit == queryChannelsPaginationRequest.channelLimit && this.messageLimit == queryChannelsPaginationRequest.messageLimit && this.memberLimit == queryChannelsPaginationRequest.memberLimit;
    }

    public int hashCode() {
        QuerySort<Channel> querySort = this.sort;
        return ((((((((querySort != null ? querySort.hashCode() : 0) * 31) + this.channelOffset) * 31) + this.channelLimit) * 31) + this.messageLimit) * 31) + this.memberLimit;
    }

    public String toString() {
        return "QueryChannelsPaginationRequest(sort=" + this.sort + ", channelOffset=" + this.channelOffset + ", channelLimit=" + this.channelLimit + ", messageLimit=" + this.messageLimit + ", memberLimit=" + this.memberLimit + ")";
    }

    public QueryChannelsPaginationRequest(QuerySort<Channel> querySort, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(querySort, "sort");
        this.sort = querySort;
        this.channelOffset = i;
        this.channelLimit = i2;
        this.messageLimit = i3;
        this.memberLimit = i4;
    }

    public final QuerySort<Channel> getSort() {
        return this.sort;
    }

    public final int getChannelOffset() {
        return this.channelOffset;
    }

    public final int getChannelLimit() {
        return this.channelLimit;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryChannelsPaginationRequest(QuerySort querySort, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(querySort, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? 30 : i2, (i5 & 8) != 0 ? 10 : i3, i4);
    }

    public final int getMessageLimit() {
        return this.messageLimit;
    }

    public final int getMemberLimit() {
        return this.memberLimit;
    }

    public final boolean isFirstPage() {
        return this.channelOffset == 0;
    }
}
