package com.memes.chat.p036ui.channel.create.stages.memberselection;

import android.content.Context;
import com.memes.chat.p036ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersFragment$addedChannelMembersAdapter$2 */
/* compiled from: ChooseChannelMembersFragment.kt */
final class ChooseChannelMembersFragment$addedChannelMembersAdapter$2 extends Lambda implements Function0<ChosenChannelMembersAdapter> {
    final /* synthetic */ ChooseChannelMembersFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseChannelMembersFragment$addedChannelMembersAdapter$2(ChooseChannelMembersFragment chooseChannelMembersFragment) {
        super(0);
        this.this$0 = chooseChannelMembersFragment;
    }

    public final ChosenChannelMembersAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ChosenChannelMembersAdapter(requireContext, new ChosenChannelMembersAdapter.Callback(this) {
            final /* synthetic */ ChooseChannelMembersFragment$addedChannelMembersAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onChannelMemberRemoved(User user) {
                Intrinsics.checkNotNullParameter(user, "removedChannelMember");
                this.this$0.this$0.getUserSearchResultsAdapter().removeItemSelectionById(user.getId());
                this.this$0.this$0.getChooseChannelMembersViewModel().onChannelMemberRemoved(user);
            }
        });
    }
}
