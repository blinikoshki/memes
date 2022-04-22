package com.memes.chat.p036ui.channel.members;

import android.widget.ProgressBar;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "isLoadingNextMembers", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$setupChannelMembers$6 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$setupChannelMembers$6<T> implements Observer<Boolean> {
    final /* synthetic */ ChannelMembersActivity this$0;

    ChannelMembersActivity$setupChannelMembers$6(ChannelMembersActivity channelMembersActivity) {
        this.this$0 = channelMembersActivity;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "isLoadingNextMembers");
        if (bool.booleanValue()) {
            ProgressBar progressBar = this.this$0.getBinding().loadingNextPageProgressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingNextPageProgressBar");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = this.this$0.getBinding().loadingNextPageProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.loadingNextPageProgressBar");
        progressBar2.setVisibility(8);
    }
}
