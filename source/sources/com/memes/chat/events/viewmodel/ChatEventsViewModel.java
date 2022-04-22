package com.memes.chat.events.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.memes.chat.events.ChatEventReceiver;
import com.memes.chat.events.custom.DeclaredChatEvent;
import com.memes.chat.events.custom.TotalUnreadCountEvent;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/chat/events/viewmodel/ChatEventsViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "Lcom/memes/chat/events/ChatEventReceiver;", "Lcom/memes/chat/events/custom/DeclaredChatEvent;", "()V", "_chatBadgeCount", "Lcom/memes/commons/util/SingleLiveEvent;", "", "get_chatBadgeCount", "()Lcom/memes/commons/util/SingleLiveEvent;", "chatBadgeCount", "Landroidx/lifecycle/LiveData;", "onChatEventReceived", "", "event", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatEventsViewModel.kt */
public final class ChatEventsViewModel extends BaseViewModel implements ChatEventReceiver<DeclaredChatEvent> {
    private final SingleLiveEvent<Integer> _chatBadgeCount = new SingleLiveEvent<>();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(DeclaredChatEvent declaredChatEvent) {
        Intrinsics.checkNotNullParameter(declaredChatEvent, "event");
        ChatEventReceiver.DefaultImpls.onEvent(this, declaredChatEvent);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onLifecycleStart() {
        ChatEventReceiver.DefaultImpls.onLifecycleStart(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onLifecycleStop() {
        ChatEventReceiver.DefaultImpls.onLifecycleStop(this);
    }

    /* access modifiers changed from: protected */
    public final SingleLiveEvent<Integer> get_chatBadgeCount() {
        return this._chatBadgeCount;
    }

    public final LiveData<Integer> chatBadgeCount() {
        return this._chatBadgeCount;
    }

    public boolean onChatEventReceived(DeclaredChatEvent declaredChatEvent) {
        Intrinsics.checkNotNullParameter(declaredChatEvent, "event");
        if (!(declaredChatEvent instanceof TotalUnreadCountEvent)) {
            return false;
        }
        this._chatBadgeCount.setValue(Integer.valueOf(((TotalUnreadCountEvent) declaredChatEvent).getCount()));
        return true;
    }
}
