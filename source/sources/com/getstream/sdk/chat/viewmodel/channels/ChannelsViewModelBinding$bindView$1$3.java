package com.getstream.sdk.chat.viewmodel.channels;

import com.getstream.sdk.chat.viewmodel.channels.ChannelsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChannelsViewModelBinding.kt */
final class ChannelsViewModelBinding$bindView$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ChannelsViewModel $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsViewModelBinding$bindView$1$3(ChannelsViewModel channelsViewModel) {
        super(0);
        this.$this_apply = channelsViewModel;
    }

    public final void invoke() {
        this.$this_apply.onEvent(ChannelsViewModel.Event.ReachedEndOfList.INSTANCE);
    }
}
