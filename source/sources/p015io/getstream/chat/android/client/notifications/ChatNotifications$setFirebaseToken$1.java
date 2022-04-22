package p015io.getstream.chat.android.client.notifications;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "result", "Lio/getstream/chat/android/client/utils/Result;", "onResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.ChatNotifications$setFirebaseToken$1 */
/* compiled from: ChatNotifications.kt */
final class ChatNotifications$setFirebaseToken$1<T> implements Call.Callback<Unit> {
    final /* synthetic */ ChatNotifications this$0;

    ChatNotifications$setFirebaseToken$1(ChatNotifications chatNotifications) {
        this.this$0 = chatNotifications;
    }

    public final void onResult(Result<Unit> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isSuccess()) {
            DeviceRegisteredListener deviceRegisteredListener = this.this$0.getHandler().getDeviceRegisteredListener();
            if (deviceRegisteredListener != null) {
                deviceRegisteredListener.onDeviceRegisteredSuccess();
            }
            this.this$0.logger.logI("DeviceRegisteredSuccess");
            return;
        }
        DeviceRegisteredListener deviceRegisteredListener2 = this.this$0.getHandler().getDeviceRegisteredListener();
        if (deviceRegisteredListener2 != null) {
            deviceRegisteredListener2.onDeviceRegisteredError(result.error());
        }
        TaggedLogger access$getLogger$p = this.this$0.logger;
        access$getLogger$p.logE("Error register device " + result.error().getMessage());
    }
}
