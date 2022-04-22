package p015io.getstream.chat.android.livedata.repository.database.converter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/database/converter/SyncStatusConverter;", "", "()V", "stringToSyncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "data", "", "syncStatusToString", "syncStatus", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter */
/* compiled from: SyncStatusConverter.kt */
public final class SyncStatusConverter {
    public final SyncStatus stringToSyncStatus(int i) {
        SyncStatus fromInt = SyncStatus.Companion.fromInt(i);
        Intrinsics.checkNotNull(fromInt);
        return fromInt;
    }

    public final int syncStatusToString(SyncStatus syncStatus) {
        Intrinsics.checkNotNullParameter(syncStatus, "syncStatus");
        return syncStatus.getStatus();
    }
}
