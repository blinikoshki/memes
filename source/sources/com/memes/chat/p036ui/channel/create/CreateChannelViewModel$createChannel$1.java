package com.memes.chat.p036ui.channel.create;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.CreateChannelViewModel$createChannel$1 */
/* compiled from: CreateChannelViewModel.kt */
final /* synthetic */ class CreateChannelViewModel$createChannel$1 extends MutablePropertyReference0Impl {
    CreateChannelViewModel$createChannel$1(CreateChannelViewModel createChannelViewModel) {
        super(createChannelViewModel, CreateChannelViewModel.class, "createChannelJob", "getCreateChannelJob()Lkotlinx/coroutines/Job;", 0);
    }

    public Object get() {
        return CreateChannelViewModel.access$getCreateChannelJob$p((CreateChannelViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((CreateChannelViewModel) this.receiver).createChannelJob = (Job) obj;
    }
}
