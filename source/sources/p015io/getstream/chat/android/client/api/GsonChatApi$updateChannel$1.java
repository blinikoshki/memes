package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.models.ChannelResponse;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/Channel;", "it", "Lio/getstream/chat/android/client/api/models/ChannelResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$updateChannel$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$updateChannel$1 extends Lambda implements Function1<ChannelResponse, Channel> {
    final /* synthetic */ GsonChatApi this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GsonChatApi$updateChannel$1(GsonChatApi gsonChatApi) {
        super(1);
        this.this$0 = gsonChatApi;
    }

    public final Channel invoke(ChannelResponse channelResponse) {
        Intrinsics.checkNotNullParameter(channelResponse, "it");
        return this.this$0.flattenChannel(channelResponse);
    }
}
