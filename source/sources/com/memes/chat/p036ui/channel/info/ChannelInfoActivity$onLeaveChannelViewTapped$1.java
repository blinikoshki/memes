package com.memes.chat.p036ui.channel.info;

import android.content.DialogInterface;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$onLeaveChannelViewTapped$1 */
/* compiled from: ChannelInfoActivity.kt */
final class ChannelInfoActivity$onLeaveChannelViewTapped$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ ChannelInfoActivity this$0;

    ChannelInfoActivity$onLeaveChannelViewTapped$1(ChannelInfoActivity channelInfoActivity) {
        this.this$0 = channelInfoActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.getChannelInfoViewModel().leaveChannel();
    }
}
