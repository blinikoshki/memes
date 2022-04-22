package p015io.getstream.chat.android.livedata.service.sync;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/service/sync/OfflineSyncFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "pushDataSyncHandler", "Lio/getstream/chat/android/livedata/service/sync/PushMessageSyncHandler;", "onMessageReceived", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.service.sync.OfflineSyncFirebaseMessagingService */
/* compiled from: OfflineSyncFirebaseMessagingService.kt */
public final class OfflineSyncFirebaseMessagingService extends FirebaseMessagingService {
    private final PushMessageSyncHandler pushDataSyncHandler = new PushMessageSyncHandler(this);

    public void onNewToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.pushDataSyncHandler.onNewToken(str);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.pushDataSyncHandler.onMessageReceived(remoteMessage);
        stopSelf();
    }
}
