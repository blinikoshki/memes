package com.memes.chat.p036ui.channel.members;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersViewModel$fetchChannelMembers$1 */
/* compiled from: ChannelMembersViewModel.kt */
final /* synthetic */ class ChannelMembersViewModel$fetchChannelMembers$1 extends MutablePropertyReference0Impl {
    ChannelMembersViewModel$fetchChannelMembers$1(ChannelMembersViewModel channelMembersViewModel) {
        super(channelMembersViewModel, ChannelMembersViewModel.class, "membersJob", "getMembersJob()Lkotlinx/coroutines/Job;", 0);
    }

    public Object get() {
        return ChannelMembersViewModel.access$getMembersJob$p((ChannelMembersViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((ChannelMembersViewModel) this.receiver).membersJob = (Job) obj;
    }
}
