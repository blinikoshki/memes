package p015io.getstream.chat.android.client.notifications;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.InstanceIdResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/iid/InstanceIdResult;", "kotlin.jvm.PlatformType", "onComplete"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.ChatNotifications$onSetUser$1 */
/* compiled from: ChatNotifications.kt */
final class ChatNotifications$onSetUser$1<TResult> implements OnCompleteListener<InstanceIdResult> {
    final /* synthetic */ ChatNotifications this$0;

    ChatNotifications$onSetUser$1(ChatNotifications chatNotifications) {
        this.this$0 = chatNotifications;
    }

    public final void onComplete(Task<InstanceIdResult> task) {
        Intrinsics.checkNotNullParameter(task, "it");
        if (task.isSuccessful()) {
            this.this$0.logger.logI("FirebaseInstanceId returned token successfully");
            ChatNotifications chatNotifications = this.this$0;
            InstanceIdResult result = task.getResult();
            Intrinsics.checkNotNull(result);
            Intrinsics.checkNotNullExpressionValue(result, "it.result!!");
            String token = result.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "it.result!!.token");
            chatNotifications.setFirebaseToken(token);
            return;
        }
        this.this$0.logger.logI("Error: FirebaseInstanceId doesn't returned token");
    }
}
