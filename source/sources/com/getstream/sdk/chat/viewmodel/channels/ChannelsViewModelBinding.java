package com.getstream.sdk.chat.viewmodel.channels;

import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getstream.sdk.chat.view.channels.ChannelsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0006¨\u0006\u0007"}, mo26107d2 = {"bindView", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel;", "view", "Lcom/getstream/sdk/chat/view/channels/ChannelsView;", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "bind", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: ChannelsViewModelBinding.kt */
public final class ChannelsViewModelBinding {
    public static final ChannelsViewModel bind(ChannelsViewModel channelsViewModel, ChannelsView channelsView, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(channelsViewModel, "$this$bindView");
        Intrinsics.checkNotNullParameter(channelsView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycle");
        channelsViewModel.getState().observe(lifecycleOwner, new ChannelsViewModelBinding$bindView$$inlined$apply$lambda$1(lifecycleOwner, channelsView));
        channelsViewModel.getPaginationState().observe(lifecycleOwner, new ChannelsViewModelBinding$bindView$$inlined$apply$lambda$2(lifecycleOwner, channelsView));
        channelsView.setOnEndReachedListener(new ChannelsViewModelBinding$bindView$1$3(channelsViewModel));
        return channelsViewModel;
    }
}
