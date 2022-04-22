package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.ChannelRequest;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u00102\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R#\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001a\u0010.\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$¨\u00064"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QueryChannelsRequest;", "Lio/getstream/chat/android/client/api/models/ChannelRequest;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "offset", "", "limit", "querySort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "messageLimit", "memberLimit", "(Lio/getstream/chat/android/client/utils/FilterObject;IILio/getstream/chat/android/client/api/models/QuerySort;II)V", "getFilter", "()Lio/getstream/chat/android/client/utils/FilterObject;", "filter_conditions", "", "", "", "getFilter_conditions", "()Ljava/util/Map;", "getLimit", "()I", "setLimit", "(I)V", "getMemberLimit", "setMemberLimit", "getMessageLimit", "setMessageLimit", "getOffset", "setOffset", "presence", "", "getPresence", "()Z", "setPresence", "(Z)V", "getQuerySort", "()Lio/getstream/chat/android/client/api/models/QuerySort;", "sort", "", "getSort", "()Ljava/util/List;", "state", "getState", "setState", "watch", "getWatch", "setWatch", "withLimit", "withMessages", "withOffset", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.QueryChannelsRequest */
/* compiled from: QueryChannelsRequest.kt */
public final class QueryChannelsRequest implements ChannelRequest<QueryChannelsRequest> {
    @IgnoreSerialisation
    private final FilterObject filter;
    private final Map<String, Object> filter_conditions;
    private int limit;
    @SerializedName("member_limit")
    private int memberLimit;
    @SerializedName("message_limit")
    private int messageLimit;
    private int offset;
    private boolean presence;
    @IgnoreSerialisation
    private final QuerySort<Channel> querySort;
    private final List<Map<String, Object>> sort;
    private boolean state;
    private boolean watch;

    public QueryChannelsRequest(FilterObject filterObject, int i, int i2, QuerySort<Channel> querySort2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort2, "querySort");
        this.filter = filterObject;
        this.offset = i;
        this.limit = i2;
        this.querySort = querySort2;
        this.messageLimit = i3;
        this.memberLimit = i4;
        this.state = true;
        this.watch = true;
        this.sort = querySort2.toDto();
        this.filter_conditions = filterObject.toMap();
    }

    public QueryChannelsRequest noPresence() {
        return (QueryChannelsRequest) ChannelRequest.DefaultImpls.noPresence(this);
    }

    public QueryChannelsRequest noState() {
        return (QueryChannelsRequest) ChannelRequest.DefaultImpls.noState(this);
    }

    public QueryChannelsRequest noWatch() {
        return (QueryChannelsRequest) ChannelRequest.DefaultImpls.noWatch(this);
    }

    public QueryChannelsRequest withPresence() {
        return (QueryChannelsRequest) ChannelRequest.DefaultImpls.withPresence(this);
    }

    public QueryChannelsRequest withState() {
        return (QueryChannelsRequest) ChannelRequest.DefaultImpls.withState(this);
    }

    public QueryChannelsRequest withWatch() {
        return (QueryChannelsRequest) ChannelRequest.DefaultImpls.withWatch(this);
    }

    public final FilterObject getFilter() {
        return this.filter;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final void setOffset(int i) {
        this.offset = i;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryChannelsRequest(FilterObject filterObject, int i, int i2, QuerySort querySort2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(filterObject, i, i2, (i5 & 8) != 0 ? new QuerySort() : querySort2, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? 0 : i4);
    }

    public final QuerySort<Channel> getQuerySort() {
        return this.querySort;
    }

    public final int getMessageLimit() {
        return this.messageLimit;
    }

    public final void setMessageLimit(int i) {
        this.messageLimit = i;
    }

    public final int getMemberLimit() {
        return this.memberLimit;
    }

    public final void setMemberLimit(int i) {
        this.memberLimit = i;
    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean z) {
        this.state = z;
    }

    public boolean getWatch() {
        return this.watch;
    }

    public void setWatch(boolean z) {
        this.watch = z;
    }

    public boolean getPresence() {
        return this.presence;
    }

    public void setPresence(boolean z) {
        this.presence = z;
    }

    public final List<Map<String, Object>> getSort() {
        return this.sort;
    }

    public final Map<String, Object> getFilter_conditions() {
        return this.filter_conditions;
    }

    public final QueryChannelsRequest withMessages(int i) {
        this.messageLimit = i;
        return this;
    }

    public final QueryChannelsRequest withLimit(int i) {
        this.limit = i;
        return this;
    }

    public final QueryChannelsRequest withOffset(int i) {
        this.offset = i;
        return this;
    }
}
