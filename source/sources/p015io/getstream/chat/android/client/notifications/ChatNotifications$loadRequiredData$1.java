package p015io.getstream.chat.android.client.notifications;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "result", "Lio/getstream/chat/android/client/utils/Result;", "Lkotlin/Pair;", "Lio/getstream/chat/android/client/models/Channel;", "Lio/getstream/chat/android/client/models/Message;", "onResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.ChatNotifications$loadRequiredData$1 */
/* compiled from: ChatNotifications.kt */
final class ChatNotifications$loadRequiredData$1<T> implements Call.Callback<Pair<? extends Channel, ? extends Message>> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ ChatNotifications this$0;

    ChatNotifications$loadRequiredData$1(ChatNotifications chatNotifications, String str) {
        this.this$0 = chatNotifications;
        this.$messageId = str;
    }

    public final void onResult(Result<Pair<Channel, Message>> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isSuccess()) {
            Pair data = result.data();
            Channel channel = (Channel) data.component1();
            Message message = (Message) data.component2();
            NotificationLoadDataListener dataLoadListener = this.this$0.getHandler().getDataLoadListener();
            if (dataLoadListener != null) {
                dataLoadListener.onLoadSuccess(channel, message);
            }
            this.this$0.onRequiredDataLoaded(channel, message);
            return;
        }
        TaggedLogger access$getLogger$p = this.this$0.logger;
        access$getLogger$p.logE("Error loading required data: " + result.error().getMessage(), result.error());
        NotificationLoadDataListener dataLoadListener2 = this.this$0.getHandler().getDataLoadListener();
        if (dataLoadListener2 != null) {
            dataLoadListener2.onLoadFail(this.$messageId, result.error());
        }
        this.this$0.showErrorCaseNotification();
    }
}
