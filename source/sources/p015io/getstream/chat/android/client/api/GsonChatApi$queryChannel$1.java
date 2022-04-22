package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.ChannelResponse;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/Channel;", "p1", "Lio/getstream/chat/android/client/api/models/ChannelResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$queryChannel$1 */
/* compiled from: GsonChatApi.kt */
final /* synthetic */ class GsonChatApi$queryChannel$1 extends FunctionReferenceImpl implements Function1<ChannelResponse, Channel> {
    GsonChatApi$queryChannel$1(GsonChatApi gsonChatApi) {
        super(1, gsonChatApi, GsonChatApi.class, "flattenChannel", "flattenChannel(Lio/getstream/chat/android/client/api/models/ChannelResponse;)Lio/getstream/chat/android/client/models/Channel;", 0);
    }

    public final Channel invoke(ChannelResponse channelResponse) {
        Intrinsics.checkNotNullParameter(channelResponse, "p1");
        return ((GsonChatApi) this.receiver).flattenChannel(channelResponse);
    }
}
