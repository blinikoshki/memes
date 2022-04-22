package com.getstream.sdk.chat.viewmodel.factory;

import androidx.lifecycle.ViewModel;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChannelViewModelFactory.kt */
final class ChannelViewModelFactory$factories$3 extends Lambda implements Function0<ViewModel> {
    final /* synthetic */ ChannelViewModelFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelViewModelFactory$factories$3(ChannelViewModelFactory channelViewModelFactory) {
        super(0);
        this.this$0 = channelViewModelFactory;
    }

    public final ViewModel invoke() {
        return new MessageListViewModel(this.this$0.cid, this.this$0.messageId, (ChatDomain) null, (ChatClient) null, 12, (DefaultConstructorMarker) null);
    }
}
