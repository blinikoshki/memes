package com.memes.chat.p036ui.channel.info;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.chat.p036ui.channel.settings.ChannelSettingsViewModel;
import com.memes.chat.p036ui.startup.ChatCredentialsSharedPref;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.network.NetworkProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/settings/ChannelSettingsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$channelSettingsViewModel$2 */
/* compiled from: ChannelInfoActivity.kt */
final class ChannelInfoActivity$channelSettingsViewModel$2 extends Lambda implements Function0<ChannelSettingsViewModel> {
    final /* synthetic */ ChannelInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelInfoActivity$channelSettingsViewModel$2(ChannelInfoActivity channelInfoActivity) {
        super(0);
        this.this$0 = channelInfoActivity;
    }

    public final ChannelSettingsViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<ChannelSettingsViewModel>(this) {
            final /* synthetic */ ChannelInfoActivity$channelSettingsViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ChannelSettingsViewModel invoke() {
                return new ChannelSettingsViewModel(ChatClient.Companion.instance(), NetworkProxy.INSTANCE.fromChat(), new ChatCredentialsSharedPref(this.this$0.this$0));
            }
        })).get(ChannelSettingsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (ChannelSettingsViewModel) viewModel;
    }
}
