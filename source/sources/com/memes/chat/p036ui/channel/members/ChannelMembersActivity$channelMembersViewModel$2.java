package com.memes.chat.p036ui.channel.members;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/members/ChannelMembersViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$channelMembersViewModel$2 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$channelMembersViewModel$2 extends Lambda implements Function0<ChannelMembersViewModel> {
    final /* synthetic */ ChannelMembersActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelMembersActivity$channelMembersViewModel$2(ChannelMembersActivity channelMembersActivity) {
        super(0);
        this.this$0 = channelMembersActivity;
    }

    public final ChannelMembersViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<ChannelMembersViewModel>(this) {
            final /* synthetic */ ChannelMembersActivity$channelMembersViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ChannelMembersViewModel invoke() {
                return new ChannelMembersViewModel(ChatClient.Companion.instance(), this.this$0.this$0.getMembersPaginator());
            }
        })).get(ChannelMembersViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (ChannelMembersViewModel) viewModel;
    }
}
