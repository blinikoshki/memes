package com.getstream.sdk.chat.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/ChannelHeaderViewModel;", "Lcom/getstream/sdk/chat/viewmodel/BaseMessageListHeaderViewModel;", "cid", "", "chatDomain", "Lio/getstream/chat/android/livedata/ChatDomain;", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/ChatDomain;)V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelHeaderViewModel.kt */
public final class ChannelHeaderViewModel extends BaseMessageListHeaderViewModel {
    private final ChatDomain chatDomain;

    public ChannelHeaderViewModel(String str) {
        this(str, (ChatDomain) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelHeaderViewModel(String str, ChatDomain chatDomain2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? ChatDomain.Companion.instance() : chatDomain2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelHeaderViewModel(String str, ChatDomain chatDomain2) {
        super(str, chatDomain2);
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(chatDomain2, "chatDomain");
        this.chatDomain = chatDomain2;
    }
}
