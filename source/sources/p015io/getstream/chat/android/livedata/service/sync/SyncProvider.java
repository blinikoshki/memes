package p015io.getstream.chat.android.livedata.service.sync;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068@X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8@X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/service/sync/SyncProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "encryptedBackgroundSyncConfigStore", "Lio/getstream/chat/android/livedata/service/sync/EncryptedBackgroundSyncConfigStore;", "getEncryptedBackgroundSyncConfigStore$stream_chat_android_offline_release", "()Lio/getstream/chat/android/livedata/service/sync/EncryptedBackgroundSyncConfigStore;", "encryptedBackgroundSyncConfigStore$delegate", "Lkotlin/Lazy;", "notificationConfigStore", "Lio/getstream/chat/android/livedata/service/sync/NotificationConfigStore;", "getNotificationConfigStore$stream_chat_android_offline_release", "()Lio/getstream/chat/android/livedata/service/sync/NotificationConfigStore;", "notificationConfigStore$delegate", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.service.sync.SyncProvider */
/* compiled from: SyncProvider.kt */
public final class SyncProvider {
    private final Lazy encryptedBackgroundSyncConfigStore$delegate;
    private final Lazy notificationConfigStore$delegate;

    /* renamed from: getEncryptedBackgroundSyncConfigStore$stream_chat_android_offline_release */
    public final EncryptedBackgroundSyncConfigStore mo69979x9c3f7c57() {
        return (EncryptedBackgroundSyncConfigStore) this.encryptedBackgroundSyncConfigStore$delegate.getValue();
    }

    public final NotificationConfigStore getNotificationConfigStore$stream_chat_android_offline_release() {
        return (NotificationConfigStore) this.notificationConfigStore$delegate.getValue();
    }

    public SyncProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.encryptedBackgroundSyncConfigStore$delegate = LazyKt.lazy(new SyncProvider$encryptedBackgroundSyncConfigStore$2(context));
        this.notificationConfigStore$delegate = LazyKt.lazy(new SyncProvider$notificationConfigStore$2(context));
    }
}
