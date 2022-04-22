package com.memes.chat.p036ui.channel.info;

import android.widget.CompoundButton;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$onCreate$7 */
/* compiled from: ChannelInfoActivity.kt */
final class ChannelInfoActivity$onCreate$7 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ChannelInfoActivity this$0;

    ChannelInfoActivity$onCreate$7(ChannelInfoActivity channelInfoActivity) {
        this.this$0 = channelInfoActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.this$0.getChannelInfoViewModel().changeChannelMuteStatus(z);
    }
}
