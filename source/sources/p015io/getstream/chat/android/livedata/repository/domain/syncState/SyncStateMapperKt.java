package p015io.getstream.chat.android.livedata.repository.domain.syncState;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.model.SyncState;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, mo26107d2 = {"toEntity", "Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateEntity;", "Lio/getstream/chat/android/livedata/model/SyncState;", "toModel", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateMapperKt */
/* compiled from: SyncStateMapper.kt */
public final class SyncStateMapperKt {
    public static final SyncState toModel(SyncStateEntity syncStateEntity) {
        Intrinsics.checkNotNullParameter(syncStateEntity, "$this$toModel");
        return new SyncState(syncStateEntity.getUserId(), syncStateEntity.getActiveChannelIds(), syncStateEntity.getActiveQueryIds(), syncStateEntity.getLastSyncedAt(), syncStateEntity.getMarkedAllReadAt());
    }

    public static final SyncStateEntity toEntity(SyncState syncState) {
        Intrinsics.checkNotNullParameter(syncState, "$this$toEntity");
        return new SyncStateEntity(syncState.getUserId(), syncState.getActiveChannelIds(), syncState.getActiveQueryIds(), syncState.getLastSyncedAt(), syncState.getMarkedAllReadAt());
    }
}
