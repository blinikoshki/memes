package com.getstream.sdk.chat.viewmodel.channels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.view.channels.ChannelsView;
import com.getstream.sdk.chat.viewmodel.channels.ChannelsViewModel;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$PaginationState;", "kotlin.jvm.PlatformType", "onChanged", "com/getstream/sdk/chat/viewmodel/channels/ChannelsViewModelBinding$bindView$1$2"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChannelsViewModelBinding.kt */
final class ChannelsViewModelBinding$bindView$$inlined$apply$lambda$2<T> implements Observer<ChannelsViewModel.PaginationState> {
    final /* synthetic */ LifecycleOwner $lifecycle$inlined;
    final /* synthetic */ ChannelsView $view$inlined;

    ChannelsViewModelBinding$bindView$$inlined$apply$lambda$2(LifecycleOwner lifecycleOwner, ChannelsView channelsView) {
        this.$lifecycle$inlined = lifecycleOwner;
        this.$view$inlined = channelsView;
    }

    public final void onChanged(ChannelsViewModel.PaginationState paginationState) {
        this.$view$inlined.setPaginationEnabled(!paginationState.getEndOfChannels() && !paginationState.getLoadingMore());
    }
}
