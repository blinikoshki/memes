package com.memes.chat.p036ui.channel.list;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/memes/chat/ui/channel/list/ChannelsActivity$initViewPager$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.ChannelsActivity$initViewPager$1 */
/* compiled from: ChannelsActivity.kt */
public final class ChannelsActivity$initViewPager$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ ChannelsActivity this$0;

    ChannelsActivity$initViewPager$1(ChannelsActivity channelsActivity) {
        this.this$0 = channelsActivity;
    }

    public void onPageSelected(int i) {
        Integer value = this.this$0.getChatEventsViewModel().chatBadgeCount().getValue();
        if (value == null) {
            value = 0;
        }
        Intrinsics.checkNotNullExpressionValue(value, "chatEventsViewModel.chatBadgeCount().value ?: 0");
        this.this$0.updateChatBadgeCount(value.intValue());
    }
}
