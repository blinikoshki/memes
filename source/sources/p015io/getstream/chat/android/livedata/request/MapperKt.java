package p015io.getstream.chat.android.livedata.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, mo26107d2 = {"toAnyChannelPaginationRequest", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "Lio/getstream/chat/android/livedata/request/QueryChannelsPaginationRequest;", "toQueryChannelsRequest", "Lio/getstream/chat/android/client/api/models/QueryChannelsRequest;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "userPresence", "", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.request.MapperKt */
/* compiled from: Mapper.kt */
public final class MapperKt {
    public static final AnyChannelPaginationRequest toAnyChannelPaginationRequest(QueryChannelsPaginationRequest queryChannelsPaginationRequest) {
        Intrinsics.checkNotNullParameter(queryChannelsPaginationRequest, "$this$toAnyChannelPaginationRequest");
        AnyChannelPaginationRequest anyChannelPaginationRequest = new AnyChannelPaginationRequest(0, 1, (DefaultConstructorMarker) null);
        anyChannelPaginationRequest.setChannelLimit(queryChannelsPaginationRequest.getChannelLimit());
        anyChannelPaginationRequest.setChannelOffset(queryChannelsPaginationRequest.getChannelOffset());
        anyChannelPaginationRequest.setMessageLimit(queryChannelsPaginationRequest.getMessageLimit());
        anyChannelPaginationRequest.setSort(queryChannelsPaginationRequest.getSort());
        return anyChannelPaginationRequest;
    }

    /* JADX WARNING: type inference failed for: r8v3, types: [io.getstream.chat.android.client.api.models.ChannelRequest] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final p015io.getstream.chat.android.client.api.models.QueryChannelsRequest toQueryChannelsRequest(p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r8, p015io.getstream.chat.android.client.utils.FilterObject r9, boolean r10) {
        /*
            java.lang.String r0 = "$this$toQueryChannelsRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "filter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            io.getstream.chat.android.client.api.models.QueryChannelsRequest r0 = new io.getstream.chat.android.client.api.models.QueryChannelsRequest
            int r3 = r8.getChannelOffset()
            int r4 = r8.getChannelLimit()
            io.getstream.chat.android.client.api.models.QuerySort r5 = r8.getSort()
            int r6 = r8.getMessageLimit()
            int r7 = r8.getMemberLimit()
            r1 = r0
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            if (r10 == 0) goto L_0x002e
            io.getstream.chat.android.client.api.models.ChannelRequest r8 = r0.withPresence()
            r0 = r8
            io.getstream.chat.android.client.api.models.QueryChannelsRequest r0 = (p015io.getstream.chat.android.client.api.models.QueryChannelsRequest) r0
        L_0x002e:
            io.getstream.chat.android.client.api.models.ChannelRequest r8 = r0.withWatch()
            io.getstream.chat.android.client.api.models.QueryChannelsRequest r8 = (p015io.getstream.chat.android.client.api.models.QueryChannelsRequest) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.request.MapperKt.toQueryChannelsRequest(io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest, io.getstream.chat.android.client.utils.FilterObject, boolean):io.getstream.chat.android.client.api.models.QueryChannelsRequest");
    }
}
