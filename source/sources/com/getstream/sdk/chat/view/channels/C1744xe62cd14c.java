package com.getstream.sdk.chat.view.channels;

import com.getstream.sdk.chat.view.channels.ChannelListView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.view.channels.ChannelsView$sam$com_getstream_sdk_chat_view_channels_ChannelListView_EndReachedListener$0 */
/* compiled from: ChannelsView.kt */
final class C1744xe62cd14c implements ChannelListView.EndReachedListener {
    private final /* synthetic */ Function0 function;

    C1744xe62cd14c(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void onEndReached() {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
