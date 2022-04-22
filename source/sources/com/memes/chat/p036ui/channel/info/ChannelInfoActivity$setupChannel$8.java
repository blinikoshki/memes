package com.memes.chat.p036ui.channel.info;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "available", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$setupChannel$8 */
/* compiled from: ChannelInfoActivity.kt */
final class ChannelInfoActivity$setupChannel$8<T> implements Observer<Boolean> {
    final /* synthetic */ ChannelInfoActivity this$0;

    ChannelInfoActivity$setupChannel$8(ChannelInfoActivity channelInfoActivity) {
        this.this$0 = channelInfoActivity;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "available");
        if (bool.booleanValue()) {
            TextView textView = this.this$0.getBinding().saveChannelInfoTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.saveChannelInfoTextView");
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = this.this$0.getBinding().saveChannelInfoTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.saveChannelInfoTextView");
        textView2.setVisibility(8);
    }
}
