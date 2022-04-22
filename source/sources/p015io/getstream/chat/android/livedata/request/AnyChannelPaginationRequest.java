package p015io.getstream.chat.android.livedata.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.Pagination;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\u0004R \u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\u0004R\u001a\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\u0004¨\u0006-"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "", "messageLimit", "", "(I)V", "channelLimit", "getChannelLimit", "()I", "setChannelLimit", "channelOffset", "getChannelOffset", "setChannelOffset", "memberLimit", "getMemberLimit", "setMemberLimit", "memberOffset", "getMemberOffset", "setMemberOffset", "messageFilterDirection", "Lio/getstream/chat/android/client/api/models/Pagination;", "getMessageFilterDirection", "()Lio/getstream/chat/android/client/api/models/Pagination;", "setMessageFilterDirection", "(Lio/getstream/chat/android/client/api/models/Pagination;)V", "messageFilterValue", "", "getMessageFilterValue", "()Ljava/lang/String;", "setMessageFilterValue", "(Ljava/lang/String;)V", "getMessageLimit", "setMessageLimit", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "getSort", "()Lio/getstream/chat/android/client/api/models/QuerySort;", "setSort", "(Lio/getstream/chat/android/client/api/models/QuerySort;)V", "watcherLimit", "getWatcherLimit", "setWatcherLimit", "watcherOffset", "getWatcherOffset", "setWatcherOffset", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest */
/* compiled from: AnyChannelPaginationRequest.kt */
public final class AnyChannelPaginationRequest {
    private int channelLimit;
    private int channelOffset;
    private int memberLimit;
    private int memberOffset;
    private Pagination messageFilterDirection;
    private String messageFilterValue;
    private int messageLimit;
    private QuerySort<Channel> sort;
    private int watcherLimit;
    private int watcherOffset;

    public AnyChannelPaginationRequest() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public AnyChannelPaginationRequest(int i) {
        this.messageLimit = i;
        this.messageFilterValue = "";
        this.sort = new QuerySort<>();
        this.channelLimit = 30;
        this.memberLimit = 30;
        this.watcherLimit = 30;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnyChannelPaginationRequest(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 30 : i);
    }

    public final int getMessageLimit() {
        return this.messageLimit;
    }

    public final void setMessageLimit(int i) {
        this.messageLimit = i;
    }

    public final Pagination getMessageFilterDirection() {
        return this.messageFilterDirection;
    }

    public final void setMessageFilterDirection(Pagination pagination) {
        this.messageFilterDirection = pagination;
    }

    public final String getMessageFilterValue() {
        return this.messageFilterValue;
    }

    public final void setMessageFilterValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.messageFilterValue = str;
    }

    public final QuerySort<Channel> getSort() {
        return this.sort;
    }

    public final void setSort(QuerySort<Channel> querySort) {
        Intrinsics.checkNotNullParameter(querySort, "<set-?>");
        this.sort = querySort;
    }

    public final int getChannelLimit() {
        return this.channelLimit;
    }

    public final void setChannelLimit(int i) {
        this.channelLimit = i;
    }

    public final int getChannelOffset() {
        return this.channelOffset;
    }

    public final void setChannelOffset(int i) {
        this.channelOffset = i;
    }

    public final int getMemberLimit() {
        return this.memberLimit;
    }

    public final void setMemberLimit(int i) {
        this.memberLimit = i;
    }

    public final int getMemberOffset() {
        return this.memberOffset;
    }

    public final void setMemberOffset(int i) {
        this.memberOffset = i;
    }

    public final int getWatcherLimit() {
        return this.watcherLimit;
    }

    public final void setWatcherLimit(int i) {
        this.watcherLimit = i;
    }

    public final int getWatcherOffset() {
        return this.watcherOffset;
    }

    public final void setWatcherOffset(int i) {
        this.watcherOffset = i;
    }
}
