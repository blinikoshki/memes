package com.memes.chat.p036ui.channel.list.pages;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.chat.p036ui.channel.options.ChannelOptionsViewModel;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/options/ChannelOptionsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.pages.ChannelsFragment$channelOptionsViewModel$2 */
/* compiled from: ChannelsFragment.kt */
final class ChannelsFragment$channelOptionsViewModel$2 extends Lambda implements Function0<ChannelOptionsViewModel> {
    final /* synthetic */ ChannelsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsFragment$channelOptionsViewModel$2(ChannelsFragment channelsFragment) {
        super(0);
        this.this$0 = channelsFragment;
    }

    public final ChannelOptionsViewModel invoke() {
        ViewModel viewModel;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Function0 function0 = C41071.INSTANCE;
        if (function0 == null) {
            viewModel = new ViewModelProvider(requireActivity).get(ChannelOptionsViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(T::class.java)");
        } else {
            viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(ChannelOptionsViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        }
        return (ChannelOptionsViewModel) viewModel;
    }
}
