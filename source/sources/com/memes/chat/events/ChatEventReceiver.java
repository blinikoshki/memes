package com.memes.chat.events;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0017J\b\u0010\f\u001a\u00020\tH\u0017¨\u0006\r"}, mo26107d2 = {"Lcom/memes/chat/events/ChatEventReceiver;", "T", "", "Landroidx/lifecycle/LifecycleObserver;", "onChatEventReceived", "", "event", "(Ljava/lang/Object;)Z", "onEvent", "", "(Ljava/lang/Object;)V", "onLifecycleStart", "onLifecycleStop", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatEventReceiver.kt */
public interface ChatEventReceiver<T> extends LifecycleObserver {
    boolean onChatEventReceived(T t);

    @Subscribe(threadMode = ThreadMode.MAIN)
    void onEvent(T t);

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onLifecycleStart();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onLifecycleStop();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: ChatEventReceiver.kt */
    public static final class DefaultImpls {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public static <T> void onLifecycleStart(ChatEventReceiver<T> chatEventReceiver) {
            ChatEventCourier.INSTANCE.startReceiving(chatEventReceiver);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public static <T> void onLifecycleStop(ChatEventReceiver<T> chatEventReceiver) {
            ChatEventCourier.INSTANCE.stopReceiving(chatEventReceiver);
        }

        @Subscribe(threadMode = ThreadMode.MAIN)
        public static <T> void onEvent(ChatEventReceiver<T> chatEventReceiver, T t) {
            Intrinsics.checkNotNullParameter(t, "event");
            if (chatEventReceiver.onChatEventReceived(t)) {
                ChatEventCourier.INSTANCE.onEventConsumed(t);
                return;
            }
            Timber.m303e("~> unhandled chat-event: " + t.getClass().getSimpleName(), new Object[0]);
        }
    }
}
