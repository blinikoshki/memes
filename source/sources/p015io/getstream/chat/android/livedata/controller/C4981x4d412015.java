package p015io.getstream.chat.android.livedata.controller;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$messagesTransformation$$inlined$map$1;
import p015io.getstream.chat.android.livedata.extensions.MessageExtensionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/models/Message;", "invoke", "io/getstream/chat/android/livedata/controller/ChannelControllerImpl$messagesTransformation$1$3"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$messagesTransformation$$inlined$map$1$2$lambda$2 */
/* compiled from: ChannelControllerImpl.kt */
final class C4981x4d412015 extends Lambda implements Function1<Message, Boolean> {
    final /* synthetic */ ChannelControllerImpl$messagesTransformation$$inlined$map$1.C49782 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C4981x4d412015(ChannelControllerImpl$messagesTransformation$$inlined$map$1.C49782 r1) {
        super(1);
        this.this$0 = r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Message) obj));
    }

    public final boolean invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, "it");
        return this.this$0.getHideMessagesBefore$stream_chat_android_offline_release() == null || MessageExtensionsKt.wasCreatedAfter(message, this.this$0.getHideMessagesBefore$stream_chat_android_offline_release());
    }
}
