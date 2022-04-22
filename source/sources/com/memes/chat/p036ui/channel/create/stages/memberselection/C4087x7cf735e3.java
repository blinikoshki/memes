package com.memes.chat.p036ui.channel.create.stages.memberselection;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersFragment$handleChannelMemberSelectionChanged$1 */
/* compiled from: ChooseChannelMembersFragment.kt */
final class C4087x7cf735e3 implements Runnable {
    final /* synthetic */ ChooseChannelMembersFragment this$0;

    C4087x7cf735e3(ChooseChannelMembersFragment chooseChannelMembersFragment) {
        this.this$0 = chooseChannelMembersFragment;
    }

    public final void run() {
        ChooseChannelMembersFragment.access$getBinding$p(this.this$0).channelMembersRecyclerView.smoothScrollToPosition(this.this$0.getAddedChannelMembersAdapter().getItemCount());
    }
}
