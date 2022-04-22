package com.memes.chat.p036ui.channel.create.stages.memberselection;

import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.recycleradapter.AdapterItemCountChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "count", "", "onItemCountChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersFragment$onViewCreated$1 */
/* compiled from: ChooseChannelMembersFragment.kt */
final class ChooseChannelMembersFragment$onViewCreated$1 implements AdapterItemCountChangeListener {
    final /* synthetic */ ChooseChannelMembersFragment this$0;

    ChooseChannelMembersFragment$onViewCreated$1(ChooseChannelMembersFragment chooseChannelMembersFragment) {
        this.this$0 = chooseChannelMembersFragment;
    }

    public final void onItemCountChanged(final int i) {
        ChooseChannelMembersFragment.access$getBinding$p(this.this$0).channelMembersRecyclerView.post(new Runnable(this) {
            final /* synthetic */ ChooseChannelMembersFragment$onViewCreated$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                RecyclerView recyclerView = ChooseChannelMembersFragment.access$getBinding$p(this.this$0.this$0).channelMembersRecyclerView;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.channelMembersRecyclerView");
                recyclerView.setVisibility(i > 0 ? 0 : 8);
            }
        });
    }
}
