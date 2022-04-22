package p015io.getstream.chat.android.client.api.models;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\rHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR-\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006!"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/SearchMessagesRequest;", "", "offset", "", "limit", "channelFilter", "Lio/getstream/chat/android/client/utils/FilterObject;", "messageFilter", "(IILio/getstream/chat/android/client/utils/FilterObject;Lio/getstream/chat/android/client/utils/FilterObject;)V", "getChannelFilter", "()Lio/getstream/chat/android/client/utils/FilterObject;", "filter_conditions", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getFilter_conditions", "()Ljava/util/HashMap;", "getLimit", "()I", "getMessageFilter", "message_filter_conditions", "getMessage_filter_conditions", "getOffset", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.SearchMessagesRequest */
/* compiled from: SearchMessagesRequest.kt */
public final class SearchMessagesRequest {
    @IgnoreSerialisation
    private final FilterObject channelFilter;
    private final HashMap<String, Object> filter_conditions;
    private final int limit;
    @IgnoreSerialisation
    private final FilterObject messageFilter;
    private final HashMap<String, Object> message_filter_conditions;
    private final int offset;

    public static /* synthetic */ SearchMessagesRequest copy$default(SearchMessagesRequest searchMessagesRequest, int i, int i2, FilterObject filterObject, FilterObject filterObject2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = searchMessagesRequest.offset;
        }
        if ((i3 & 2) != 0) {
            i2 = searchMessagesRequest.limit;
        }
        if ((i3 & 4) != 0) {
            filterObject = searchMessagesRequest.channelFilter;
        }
        if ((i3 & 8) != 0) {
            filterObject2 = searchMessagesRequest.messageFilter;
        }
        return searchMessagesRequest.copy(i, i2, filterObject, filterObject2);
    }

    public final int component1() {
        return this.offset;
    }

    public final int component2() {
        return this.limit;
    }

    public final FilterObject component3() {
        return this.channelFilter;
    }

    public final FilterObject component4() {
        return this.messageFilter;
    }

    public final SearchMessagesRequest copy(int i, int i2, FilterObject filterObject, FilterObject filterObject2) {
        Intrinsics.checkNotNullParameter(filterObject, "channelFilter");
        Intrinsics.checkNotNullParameter(filterObject2, "messageFilter");
        return new SearchMessagesRequest(i, i2, filterObject, filterObject2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchMessagesRequest)) {
            return false;
        }
        SearchMessagesRequest searchMessagesRequest = (SearchMessagesRequest) obj;
        return this.offset == searchMessagesRequest.offset && this.limit == searchMessagesRequest.limit && Intrinsics.areEqual((Object) this.channelFilter, (Object) searchMessagesRequest.channelFilter) && Intrinsics.areEqual((Object) this.messageFilter, (Object) searchMessagesRequest.messageFilter);
    }

    public int hashCode() {
        int i = ((this.offset * 31) + this.limit) * 31;
        FilterObject filterObject = this.channelFilter;
        int i2 = 0;
        int hashCode = (i + (filterObject != null ? filterObject.hashCode() : 0)) * 31;
        FilterObject filterObject2 = this.messageFilter;
        if (filterObject2 != null) {
            i2 = filterObject2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "SearchMessagesRequest(offset=" + this.offset + ", limit=" + this.limit + ", channelFilter=" + this.channelFilter + ", messageFilter=" + this.messageFilter + ")";
    }

    public SearchMessagesRequest(int i, int i2, FilterObject filterObject, FilterObject filterObject2) {
        Intrinsics.checkNotNullParameter(filterObject, "channelFilter");
        Intrinsics.checkNotNullParameter(filterObject2, "messageFilter");
        this.offset = i;
        this.limit = i2;
        this.channelFilter = filterObject;
        this.messageFilter = filterObject2;
        this.filter_conditions = filterObject.toMap();
        this.message_filter_conditions = filterObject2.toMap();
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final FilterObject getChannelFilter() {
        return this.channelFilter;
    }

    public final FilterObject getMessageFilter() {
        return this.messageFilter;
    }

    public final HashMap<String, Object> getFilter_conditions() {
        return this.filter_conditions;
    }

    public final HashMap<String, Object> getMessage_filter_conditions() {
        return this.message_filter_conditions;
    }
}
