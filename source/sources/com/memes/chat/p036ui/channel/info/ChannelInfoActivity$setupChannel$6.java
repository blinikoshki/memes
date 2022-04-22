package com.memes.chat.p036ui.channel.info;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.memes.chat.routing.ChatRouting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "hasLeft", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$setupChannel$6 */
/* compiled from: ChannelInfoActivity.kt */
final class ChannelInfoActivity$setupChannel$6<T> implements Observer<Boolean> {
    final /* synthetic */ ChannelInfoActivity this$0;

    ChannelInfoActivity$setupChannel$6(ChannelInfoActivity channelInfoActivity) {
        this.this$0 = channelInfoActivity;
    }

    public final void onChanged(Boolean bool) {
        Intent access$getResultIntent$p = this.this$0.resultIntent;
        Intrinsics.checkNotNullExpressionValue(bool, "hasLeft");
        access$getResultIntent$p.putExtra(ChatRouting.EXTRA_CHANNEL_LEFT, bool.booleanValue());
        ChannelInfoActivity channelInfoActivity = this.this$0;
        channelInfoActivity.setResult(-1, channelInfoActivity.resultIntent);
        this.this$0.finish();
    }
}
