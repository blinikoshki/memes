package com.memes.chat.p036ui.directmessaging;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.directmessaging.DirectMessagingViewModel$createChannel$1 */
/* compiled from: DirectMessagingViewModel.kt */
final /* synthetic */ class DirectMessagingViewModel$createChannel$1 extends MutablePropertyReference0Impl {
    DirectMessagingViewModel$createChannel$1(DirectMessagingViewModel directMessagingViewModel) {
        super(directMessagingViewModel, DirectMessagingViewModel.class, "createChannelJob", "getCreateChannelJob()Lkotlinx/coroutines/Job;", 0);
    }

    public Object get() {
        return DirectMessagingViewModel.access$getCreateChannelJob$p((DirectMessagingViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((DirectMessagingViewModel) this.receiver).createChannelJob = (Job) obj;
    }
}
