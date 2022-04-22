package com.memes.chat.p036ui.channel.list.pages;

import android.widget.ProgressBar;
import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.viewmodel.channels.ChannelsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "state", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$PaginationState;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.pages.ChannelsFragment$onViewCreated$1 */
/* compiled from: ChannelsFragment.kt */
final class ChannelsFragment$onViewCreated$1<T> implements Observer<ChannelsViewModel.PaginationState> {
    final /* synthetic */ ChannelsFragment this$0;

    ChannelsFragment$onViewCreated$1(ChannelsFragment channelsFragment) {
        this.this$0 = channelsFragment;
    }

    public final void onChanged(ChannelsViewModel.PaginationState paginationState) {
        if (paginationState.getLoadingMore()) {
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
