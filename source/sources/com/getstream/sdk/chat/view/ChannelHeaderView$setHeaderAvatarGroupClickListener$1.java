package com.getstream.sdk.chat.view;

import android.view.View;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChannelHeaderView.kt */
final class ChannelHeaderView$setHeaderAvatarGroupClickListener$1 implements View.OnClickListener {
    final /* synthetic */ MessageListView.HeaderAvatarGroupClickListener $headerOptionsClickListener;
    final /* synthetic */ ChannelHeaderView this$0;

    ChannelHeaderView$setHeaderAvatarGroupClickListener$1(ChannelHeaderView channelHeaderView, MessageListView.HeaderAvatarGroupClickListener headerAvatarGroupClickListener) {
        this.this$0 = channelHeaderView;
        this.$headerOptionsClickListener = headerAvatarGroupClickListener;
    }

    public final void onClick(View view) {
        Channel currentChannel = this.this$0.getCurrentChannel();
        if (currentChannel != null) {
            this.$headerOptionsClickListener.onHeaderAvatarGroupClick(currentChannel);
        }
    }
}
