package com.memes.chat.p036ui.channel.list.pages;

import com.memes.chat.p036ui.channel.options.ChannelOption;
import com.memes.chat.p036ui.channel.options.ChannelOptionsBottomSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "selectedChannelOption", "Lcom/memes/chat/ui/channel/options/ChannelOption;", "onChannelOptionSelected"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.pages.ChannelsFragment$showChannelOptions$1 */
/* compiled from: ChannelsFragment.kt */
final class ChannelsFragment$showChannelOptions$1 implements ChannelOptionsBottomSheet.Callback {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ ChannelsFragment this$0;

    ChannelsFragment$showChannelOptions$1(ChannelsFragment channelsFragment, Channel channel) {
        this.this$0 = channelsFragment;
        this.$channel = channel;
    }

    public final void onChannelOptionSelected(ChannelOption channelOption) {
        Intrinsics.checkNotNullParameter(channelOption, "selectedChannelOption");
        this.this$0.onChannelOptionSelected(this.$channel, channelOption);
    }
}
