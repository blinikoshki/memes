package com.memes.chat.p036ui.channel.create.stages.memberselection;

import androidx.lifecycle.Observer;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchResult;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "adapterUpdate", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersFragment$onViewCreated$2 */
/* compiled from: ChooseChannelMembersFragment.kt */
final class ChooseChannelMembersFragment$onViewCreated$2<T> implements Observer<AdapterUpdate<UserSearchResult>> {
    final /* synthetic */ ChooseChannelMembersFragment this$0;

    ChooseChannelMembersFragment$onViewCreated$2(ChooseChannelMembersFragment chooseChannelMembersFragment) {
        this.this$0 = chooseChannelMembersFragment;
    }

    public final void onChanged(AdapterUpdate<UserSearchResult> adapterUpdate) {
        this.this$0.getUserSearchResultsAdapter().applyAdapterUpdate(adapterUpdate);
        if (adapterUpdate == null || adapterUpdate.getPage() < 1) {
            ChooseChannelMembersFragment.access$getBinding$p(this.this$0).searchResultsRecyclerView.post(new Runnable(this) {
                final /* synthetic */ ChooseChannelMembersFragment$onViewCreated$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    ChooseChannelMembersFragment.access$getBinding$p(this.this$0.this$0).searchResultsRecyclerView.smoothScrollToPosition(0);
                }
            });
        }
    }
}
