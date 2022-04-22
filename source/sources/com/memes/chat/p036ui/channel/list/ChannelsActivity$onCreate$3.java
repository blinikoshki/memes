package com.memes.chat.p036ui.channel.list;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "count", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.ChannelsActivity$onCreate$3 */
/* compiled from: ChannelsActivity.kt */
final class ChannelsActivity$onCreate$3<T> implements Observer<Integer> {
    final /* synthetic */ ChannelsActivity this$0;

    ChannelsActivity$onCreate$3(ChannelsActivity channelsActivity) {
        this.this$0 = channelsActivity;
    }

    public final void onChanged(Integer num) {
        ChannelsActivity channelsActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(num, "count");
        channelsActivity.updateChatBadgeCount(num.intValue());
    }
}
