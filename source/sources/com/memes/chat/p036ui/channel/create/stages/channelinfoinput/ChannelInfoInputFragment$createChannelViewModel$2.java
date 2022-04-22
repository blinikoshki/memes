package com.memes.chat.p036ui.channel.create.stages.channelinfoinput;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.chat.p036ui.channel.create.CreateChannelViewModel;
import com.memes.chat.p036ui.startup.ChatCredentialsSharedPref;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.network.NetworkProxy;
import com.memes.network.chat.api.ChatDataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/create/CreateChannelViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.channelinfoinput.ChannelInfoInputFragment$createChannelViewModel$2 */
/* compiled from: ChannelInfoInputFragment.kt */
final class ChannelInfoInputFragment$createChannelViewModel$2 extends Lambda implements Function0<CreateChannelViewModel> {
    final /* synthetic */ ChannelInfoInputFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelInfoInputFragment$createChannelViewModel$2(ChannelInfoInputFragment channelInfoInputFragment) {
        super(0);
        this.this$0 = channelInfoInputFragment;
    }

    public final CreateChannelViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<CreateChannelViewModel>(this) {
            final /* synthetic */ ChannelInfoInputFragment$createChannelViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final CreateChannelViewModel invoke() {
                ChatClient instance = ChatClient.Companion.instance();
                ChatDataSource fromChat = NetworkProxy.INSTANCE.fromChat();
                FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return new CreateChannelViewModel(instance, fromChat, new ChatCredentialsSharedPref(requireActivity));
            }
        })).get(CreateChannelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (CreateChannelViewModel) viewModel;
    }
}
