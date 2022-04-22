package p015io.getstream.chat.android.livedata.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.Pagination;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020!R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\u0004¨\u0006)"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/request/QueryChannelPaginationRequest;", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "messageLimit", "", "(I)V", "memberLimit", "getMemberLimit", "()I", "setMemberLimit", "memberOffset", "getMemberOffset", "setMemberOffset", "messageFilterDirection", "Lio/getstream/chat/android/client/api/models/Pagination;", "getMessageFilterDirection", "()Lio/getstream/chat/android/client/api/models/Pagination;", "setMessageFilterDirection", "(Lio/getstream/chat/android/client/api/models/Pagination;)V", "messageFilterValue", "", "getMessageFilterValue", "()Ljava/lang/String;", "setMessageFilterValue", "(Ljava/lang/String;)V", "getMessageLimit", "setMessageLimit", "watcherLimit", "getWatcherLimit", "setWatcherLimit", "watcherOffset", "getWatcherOffset", "setWatcherOffset", "hasFilter", "", "isFirstPage", "toAnyChannelPaginationRequest", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "toAnyChannelPaginationRequest$stream_chat_android_offline_release", "toQueryChannelRequest", "Lio/getstream/chat/android/client/api/models/WatchChannelRequest;", "userPresence", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest */
/* compiled from: QueryChannelPaginationRequest.kt */
public final class QueryChannelPaginationRequest extends QueryChannelRequest {
    private int memberLimit;
    private int memberOffset;
    private Pagination messageFilterDirection;
    private String messageFilterValue;
    private int messageLimit;
    private int watcherLimit;
    private int watcherOffset;

    public QueryChannelPaginationRequest() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public QueryChannelPaginationRequest(int i) {
        this.messageLimit = i;
        this.messageFilterValue = "";
        this.memberLimit = 30;
        this.watcherLimit = 30;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryChannelPaginationRequest(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final boolean hasFilter() {
        return this.messageFilterDirection != null;
    }

    public final boolean isFirstPage() {
        return this.messageFilterDirection == null;
    }

    /* renamed from: toAnyChannelPaginationRequest$stream_chat_android_offline_release */
    public final AnyChannelPaginationRequest mo69941xdf1ac592() {
        QueryChannelPaginationRequest queryChannelPaginationRequest = this;
        AnyChannelPaginationRequest anyChannelPaginationRequest = new AnyChannelPaginationRequest(0, 1, (DefaultConstructorMarker) null);
        anyChannelPaginationRequest.setMessageLimit(queryChannelPaginationRequest.messageLimit);
        anyChannelPaginationRequest.setMessageFilterDirection(queryChannelPaginationRequest.messageFilterDirection);
        anyChannelPaginationRequest.setMemberLimit(queryChannelPaginationRequest.memberLimit);
        anyChannelPaginationRequest.setMemberOffset(queryChannelPaginationRequest.memberOffset);
        anyChannelPaginationRequest.setWatcherLimit(queryChannelPaginationRequest.watcherLimit);
        anyChannelPaginationRequest.setWatcherOffset(queryChannelPaginationRequest.watcherOffset);
        anyChannelPaginationRequest.setChannelLimit(1);
        return anyChannelPaginationRequest;
    }

    /* JADX WARNING: type inference failed for: r4v3, types: [io.getstream.chat.android.client.api.models.ChannelRequest, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p015io.getstream.chat.android.client.api.models.WatchChannelRequest toQueryChannelRequest(boolean r4) {
        /*
            r3 = this;
            io.getstream.chat.android.client.api.models.WatchChannelRequest r0 = new io.getstream.chat.android.client.api.models.WatchChannelRequest
            r0.<init>()
            int r1 = r3.messageLimit
            io.getstream.chat.android.client.api.models.WatchChannelRequest r0 = r0.withMessages((int) r1)
            if (r4 == 0) goto L_0x0019
            io.getstream.chat.android.client.api.models.ChannelRequest r4 = r0.withPresence()
            java.lang.String r0 = "null cannot be cast to non-null type io.getstream.chat.android.client.api.models.WatchChannelRequest"
            java.util.Objects.requireNonNull(r4, r0)
            r0 = r4
            io.getstream.chat.android.client.api.models.WatchChannelRequest r0 = (p015io.getstream.chat.android.client.api.models.WatchChannelRequest) r0
        L_0x0019:
            boolean r4 = r3.hasFilter()
            if (r4 == 0) goto L_0x002b
            io.getstream.chat.android.client.api.models.Pagination r4 = r3.messageFilterDirection
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r1 = r3.messageFilterValue
            int r2 = r3.messageLimit
            r0.withMessages((p015io.getstream.chat.android.client.api.models.Pagination) r4, (java.lang.String) r1, (int) r2)
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest.toQueryChannelRequest(boolean):io.getstream.chat.android.client.api.models.WatchChannelRequest");
    }
}
