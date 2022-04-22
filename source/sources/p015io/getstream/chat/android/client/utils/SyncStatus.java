package p015io.getstream.chat.android.client.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/SyncStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "SYNC_NEEDED", "COMPLETED", "FAILED_PERMANENTLY", "IN_PROGRESS", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.SyncStatus */
/* compiled from: SyncStatus.kt */
public enum SyncStatus {
    SYNC_NEEDED(-1),
    COMPLETED(1),
    FAILED_PERMANENTLY(2),
    IN_PROGRESS(3);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<Integer, SyncStatus> map = null;
    private final int status;

    private SyncStatus(int i) {
        this.status = i;
    }

    public final int getStatus() {
        return this.status;
    }

    static {
        int i;
        Companion = new Companion((DefaultConstructorMarker) null);
        SyncStatus[] values = values();
        Map<Integer, SyncStatus> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (SyncStatus syncStatus : values) {
            linkedHashMap.put(Integer.valueOf(syncStatus.status), syncStatus);
        }
        map = linkedHashMap;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/SyncStatus$Companion;", "", "()V", "map", "", "", "Lio/getstream/chat/android/client/utils/SyncStatus;", "fromInt", "type", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.utils.SyncStatus$Companion */
    /* compiled from: SyncStatus.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SyncStatus fromInt(int i) {
            return (SyncStatus) SyncStatus.map.get(Integer.valueOf(i));
        }
    }
}
