package com.memes.chat.p036ui.channel.members.add;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.add.AddChannelMembersViewModel$addSelectedMembers$1 */
/* compiled from: AddChannelMembersViewModel.kt */
final /* synthetic */ class AddChannelMembersViewModel$addSelectedMembers$1 extends MutablePropertyReference0Impl {
    AddChannelMembersViewModel$addSelectedMembers$1(AddChannelMembersViewModel addChannelMembersViewModel) {
        super(addChannelMembersViewModel, AddChannelMembersViewModel.class, "addChannelMembersJob", "getAddChannelMembersJob()Lkotlinx/coroutines/Job;", 0);
    }

    public Object get() {
        return AddChannelMembersViewModel.access$getAddChannelMembersJob$p((AddChannelMembersViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((AddChannelMembersViewModel) this.receiver).addChannelMembersJob = (Job) obj;
    }
}
