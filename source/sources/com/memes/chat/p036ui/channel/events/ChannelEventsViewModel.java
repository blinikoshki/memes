package com.memes.chat.p036ui.channel.events;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.memes.chat.events.ChatEventReceiver;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.events.ChannelDeletedEvent;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.CidEvent;
import p015io.getstream.chat.android.client.events.MemberAddedEvent;
import p015io.getstream.chat.android.client.events.MemberRemovedEvent;
import p015io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/events/ChannelEventsViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "Lcom/memes/chat/events/ChatEventReceiver;", "Lio/getstream/chat/android/client/events/ChatEvent;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "_addedChannelMemberEvent", "Lcom/memes/commons/util/SingleLiveEvent;", "Lio/getstream/chat/android/client/models/Member;", "_channelDeletedEvent", "", "_removedChannelMemberEvent", "_removedCurrentUserFromChannelEvent", "channelId", "addedChannelMemberEvent", "Landroidx/lifecycle/LiveData;", "channelDeletedEvent", "onChatEventReceived", "", "event", "removedChannelMemberEvent", "removedCurrentUserFromChannelEvent", "setChannelId", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.events.ChannelEventsViewModel */
/* compiled from: ChannelEventsViewModel.kt */
public final class ChannelEventsViewModel extends BaseViewModel implements ChatEventReceiver<ChatEvent> {
    private final SingleLiveEvent<Member> _addedChannelMemberEvent = new SingleLiveEvent<>();
    private final SingleLiveEvent<String> _channelDeletedEvent = new SingleLiveEvent<>();
    private final SingleLiveEvent<String> _removedChannelMemberEvent = new SingleLiveEvent<>();
    private final SingleLiveEvent<String> _removedCurrentUserFromChannelEvent = new SingleLiveEvent<>();
    private String channelId;
    private final ChatClient chatClient;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        ChatEventReceiver.DefaultImpls.onEvent(this, chatEvent);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onLifecycleStart() {
        ChatEventReceiver.DefaultImpls.onLifecycleStart(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onLifecycleStop() {
        ChatEventReceiver.DefaultImpls.onLifecycleStop(this);
    }

    public ChannelEventsViewModel(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    public final void setChannelId(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        this.channelId = str;
    }

    public final LiveData<Member> addedChannelMemberEvent() {
        return this._addedChannelMemberEvent;
    }

    public final LiveData<String> removedChannelMemberEvent() {
        return this._removedChannelMemberEvent;
    }

    public final LiveData<String> removedCurrentUserFromChannelEvent() {
        return this._removedCurrentUserFromChannelEvent;
    }

    public final LiveData<String> channelDeletedEvent() {
        return this._channelDeletedEvent;
    }

    public boolean onChatEventReceived(ChatEvent chatEvent) {
        ChatEvent chatEvent2 = chatEvent;
        Intrinsics.checkNotNullParameter(chatEvent2, "event");
        String str = this.channelId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        if ((chatEvent2 instanceof CidEvent) && (!Intrinsics.areEqual((Object) str, (Object) ((CidEvent) chatEvent2).getCid()))) {
            return false;
        }
        if (chatEvent2 instanceof MemberAddedEvent) {
            this._addedChannelMemberEvent.setValue(new Member(((MemberAddedEvent) chatEvent2).getUser(), (String) null, (Date) null, (Date) null, (Boolean) null, (Date) null, (Date) null, false, 254, (DefaultConstructorMarker) null));
            return true;
        } else if (chatEvent2 instanceof MemberRemovedEvent) {
            this._removedChannelMemberEvent.setValue(((MemberRemovedEvent) chatEvent2).getUser().getId());
            return true;
        } else if (chatEvent2 instanceof NotificationRemovedFromChannelEvent) {
            SingleLiveEvent<String> singleLiveEvent = this._removedCurrentUserFromChannelEvent;
            User user = ((NotificationRemovedFromChannelEvent) chatEvent2).getUser();
            singleLiveEvent.setValue(user != null ? user.getId() : null);
            return true;
        } else if (!(chatEvent2 instanceof ChannelDeletedEvent)) {
            return false;
        } else {
            this._channelDeletedEvent.setValue(((ChannelDeletedEvent) chatEvent2).getCid());
            return true;
        }
    }
}
