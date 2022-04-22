package p015io.getstream.chat.android.livedata.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.Pagination;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\b"}, mo26107d2 = {"hasFilter", "", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "isFilteringNewerMessages", "isFilteringOlderMessages", "isFirstPage", "isNotFirstPage", "isRequestingMoreThanLastMessage", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.request.AnyChannelPaginationRequestKt */
/* compiled from: AnyChannelPaginationRequest.kt */
public final class AnyChannelPaginationRequestKt {
    public static final boolean hasFilter(AnyChannelPaginationRequest anyChannelPaginationRequest) {
        Intrinsics.checkNotNullParameter(anyChannelPaginationRequest, "$this$hasFilter");
        return anyChannelPaginationRequest.getMessageFilterDirection() != null;
    }

    public static final boolean isFirstPage(AnyChannelPaginationRequest anyChannelPaginationRequest) {
        Intrinsics.checkNotNullParameter(anyChannelPaginationRequest, "$this$isFirstPage");
        return anyChannelPaginationRequest.getMessageFilterDirection() == null;
    }

    public static final boolean isRequestingMoreThanLastMessage(AnyChannelPaginationRequest anyChannelPaginationRequest) {
        Intrinsics.checkNotNullParameter(anyChannelPaginationRequest, "$this$isRequestingMoreThanLastMessage");
        if (!isFirstPage(anyChannelPaginationRequest) || anyChannelPaginationRequest.getMessageLimit() <= 1) {
            return isNotFirstPage(anyChannelPaginationRequest) && anyChannelPaginationRequest.getMessageLimit() > 0;
        }
        return true;
    }

    public static final boolean isNotFirstPage(AnyChannelPaginationRequest anyChannelPaginationRequest) {
        Intrinsics.checkNotNullParameter(anyChannelPaginationRequest, "$this$isNotFirstPage");
        return !isFirstPage(anyChannelPaginationRequest);
    }

    public static final boolean isFilteringNewerMessages(AnyChannelPaginationRequest anyChannelPaginationRequest) {
        Intrinsics.checkNotNullParameter(anyChannelPaginationRequest, "$this$isFilteringNewerMessages");
        return anyChannelPaginationRequest.getMessageFilterDirection() != null && (anyChannelPaginationRequest.getMessageFilterDirection() == Pagination.GREATER_THAN_OR_EQUAL || anyChannelPaginationRequest.getMessageFilterDirection() == Pagination.GREATER_THAN);
    }

    public static final boolean isFilteringOlderMessages(AnyChannelPaginationRequest anyChannelPaginationRequest) {
        Intrinsics.checkNotNullParameter(anyChannelPaginationRequest, "$this$isFilteringOlderMessages");
        return anyChannelPaginationRequest.getMessageFilterDirection() != null && (anyChannelPaginationRequest.getMessageFilterDirection() == Pagination.LESS_THAN || anyChannelPaginationRequest.getMessageFilterDirection() == Pagination.LESS_THAN_OR_EQUAL);
    }
}
