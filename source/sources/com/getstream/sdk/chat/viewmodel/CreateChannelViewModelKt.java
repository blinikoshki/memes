package com.getstream.sdk.chat.viewmodel;

import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, mo26107d2 = {"CHANNEL_NAME_REGEX", "Lkotlin/text/Regex;", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: CreateChannelViewModel.kt */
public final class CreateChannelViewModelKt {
    /* access modifiers changed from: private */
    public static final Regex CHANNEL_NAME_REGEX = new Regex("^!?[\\w-]*$");
}
