package com.memes.chat.p036ui.channel.create.stages.memberselection;

import android.widget.ProgressBar;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "loading", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersFragment$onViewCreated$4 */
/* compiled from: ChooseChannelMembersFragment.kt */
final class ChooseChannelMembersFragment$onViewCreated$4<T> implements Observer<Boolean> {
    final /* synthetic */ ChooseChannelMembersFragment this$0;

    ChooseChannelMembersFragment$onViewCreated$4(ChooseChannelMembersFragment chooseChannelMembersFragment) {
        this.this$0 = chooseChannelMembersFragment;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "loading");
        if (bool.booleanValue()) {
            ProgressBar progressBar = ChooseChannelMembersFragment.access$getBinding$p(this.this$0).loadingNextPageProgressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingNextPageProgressBar");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = ChooseChannelMembersFragment.access$getBinding$p(this.this$0).loadingNextPageProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.loadingNextPageProgressBar");
        progressBar2.setVisibility(8);
    }
}
