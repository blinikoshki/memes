package com.memes.chat.p036ui.channel.messages;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/messages/ChannelMessagesViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesActivity$channelMessagesViewModel$2 */
/* compiled from: ChannelMessagesActivity.kt */
final class ChannelMessagesActivity$channelMessagesViewModel$2 extends Lambda implements Function0<ChannelMessagesViewModel> {
    final /* synthetic */ ChannelMessagesActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelMessagesActivity$channelMessagesViewModel$2(ChannelMessagesActivity channelMessagesActivity) {
        super(0);
        this.this$0 = channelMessagesActivity;
    }

    public final ChannelMessagesViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<ChannelMessagesViewModel>(this) {
            final /* synthetic */ ChannelMessagesActivity$channelMessagesViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ChannelMessagesViewModel invoke() {
                return new ChannelMessagesViewModel(this.this$0.this$0.getChannelId(), ChatClient.Companion.instance());
            }
        })).get(ChannelMessagesViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (ChannelMessagesViewModel) viewModel;
    }
}
