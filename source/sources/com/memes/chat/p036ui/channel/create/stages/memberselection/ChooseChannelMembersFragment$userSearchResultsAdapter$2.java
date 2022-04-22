package com.memes.chat.p036ui.channel.create.stages.memberselection;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersFragment$userSearchResultsAdapter$2 */
/* compiled from: ChooseChannelMembersFragment.kt */
final class ChooseChannelMembersFragment$userSearchResultsAdapter$2 extends Lambda implements Function0<UserSearchResultsAdapter> {
    final /* synthetic */ ChooseChannelMembersFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseChannelMembersFragment$userSearchResultsAdapter$2(ChooseChannelMembersFragment chooseChannelMembersFragment) {
        super(0);
        this.this$0 = chooseChannelMembersFragment;
    }

    public final UserSearchResultsAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new UserSearchResultsAdapter(requireContext, this.this$0.getChooseChannelMembersViewModel());
    }
}
