package com.memes.chat.p036ui.channel.messages;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.p036ui.channel.ChannelAccessValidator;
import com.memes.chat.util.extensions.ChannelExtKt;
import com.memes.commons.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.api.models.QueryUsersRequest;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Filters;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/messages/ChannelMessagesViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "channelId", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Ljava/lang/String;Lio/getstream/chat/android/client/ChatClient;)V", "_otherUser", "Landroidx/lifecycle/MutableLiveData;", "Lio/getstream/chat/android/client/models/User;", "channelAccessValidator", "Lcom/memes/chat/ui/channel/ChannelAccessValidator;", "getChannelAccessValidator", "()Lcom/memes/chat/ui/channel/ChannelAccessValidator;", "isWatchingUser", "", "otherUser", "Landroidx/lifecycle/LiveData;", "watchUserIfDirectMessaging", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesViewModel */
/* compiled from: ChannelMessagesViewModel.kt */
public final class ChannelMessagesViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<User> _otherUser = new MutableLiveData<>();
    private final ChannelAccessValidator channelAccessValidator;
    private final String channelId;
    private final ChatClient chatClient;
    private boolean isWatchingUser;

    public ChannelMessagesViewModel(String str, ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.channelId = str;
        this.chatClient = chatClient2;
        this.channelAccessValidator = new ChannelAccessValidator(ViewModelKt.getViewModelScope(this), chatClient2);
    }

    public final ChannelAccessValidator getChannelAccessValidator() {
        return this.channelAccessValidator;
    }

    public final LiveData<User> otherUser() {
        return this._otherUser;
    }

    public final void watchUserIfDirectMessaging(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (ChannelExtKt.isDirectMessagingScope(channel) && !channel.getMembers().isEmpty() && !this.isWatchingUser) {
            List users$default = ChannelExtKt.getUsers$default(channel, false, 1, (Object) null);
            if (users$default.size() == 1) {
                this.isWatchingUser = true;
                QueryUsersRequest queryUsersRequest = new QueryUsersRequest(Filters.m1008in("id", (List<?>) CollectionsKt.listOf(((User) CollectionsKt.first(users$default)).getId())), 0, 1, (QuerySort) null, false, 24, (DefaultConstructorMarker) null);
                queryUsersRequest.setPresence(true);
                this.chatClient.queryUsers(queryUsersRequest).enqueue(new ChannelMessagesViewModel$watchUserIfDirectMessaging$1(this));
            }
        }
    }
}
