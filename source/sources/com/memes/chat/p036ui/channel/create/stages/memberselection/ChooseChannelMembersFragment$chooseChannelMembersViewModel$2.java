package com.memes.chat.p036ui.channel.create.stages.memberselection;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.network.NetworkProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChooseChannelMembersViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersFragment$chooseChannelMembersViewModel$2 */
/* compiled from: ChooseChannelMembersFragment.kt */
final class ChooseChannelMembersFragment$chooseChannelMembersViewModel$2 extends Lambda implements Function0<ChooseChannelMembersViewModel> {
    final /* synthetic */ ChooseChannelMembersFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseChannelMembersFragment$chooseChannelMembersViewModel$2(ChooseChannelMembersFragment chooseChannelMembersFragment) {
        super(0);
        this.this$0 = chooseChannelMembersFragment;
    }

    public final ChooseChannelMembersViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<ChooseChannelMembersViewModel>(this) {
            final /* synthetic */ ChooseChannelMembersFragment$chooseChannelMembersViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ChooseChannelMembersViewModel invoke() {
                return new ChooseChannelMembersViewModel(ChatClient.Companion.instance(), NetworkProxy.INSTANCE.fromMemes(), this.this$0.this$0.getUserSearchResultsPaginator());
            }
        })).get(ChooseChannelMembersViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (ChooseChannelMembersViewModel) viewModel;
    }
}
