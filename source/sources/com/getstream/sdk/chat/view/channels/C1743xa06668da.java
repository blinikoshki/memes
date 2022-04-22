package com.getstream.sdk.chat.view.channels;

import com.getstream.sdk.chat.view.channels.ChannelListView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.view.channels.ChannelsView$sam$com_getstream_sdk_chat_view_channels_ChannelListView_ChannelClickListener$0 */
/* compiled from: ChannelsView.kt */
final class C1743xa06668da implements ChannelListView.ChannelClickListener {
    private final /* synthetic */ Function1 function;

    C1743xa06668da(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onClick(Channel channel) {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(channel), "invoke(...)");
    }
}
