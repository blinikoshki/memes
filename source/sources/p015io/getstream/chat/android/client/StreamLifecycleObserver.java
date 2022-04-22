package p015io.getstream.chat.android.client;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/client/StreamLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "handler", "Lio/getstream/chat/android/client/LifecycleHandler;", "(Lio/getstream/chat/android/client/LifecycleHandler;)V", "isObserving", "", "recurringResumeEvent", "dispose", "", "observe", "onResume", "onStopped", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.StreamLifecycleObserver */
/* compiled from: StreamLifecycleObserver.kt */
public final class StreamLifecycleObserver implements LifecycleObserver {
    private final LifecycleHandler handler;
    private volatile boolean isObserving;
    private boolean recurringResumeEvent;

    public StreamLifecycleObserver(LifecycleHandler lifecycleHandler) {
        Intrinsics.checkNotNullParameter(lifecycleHandler, "handler");
        this.handler = lifecycleHandler;
    }

    public final void observe() {
        if (!this.isObserving) {
            this.isObserving = true;
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, DispatcherProvider.INSTANCE.getMain(), (CoroutineStart) null, new StreamLifecycleObserver$observe$1(this, (Continuation) null), 2, (Object) null);
        }
    }

    public final void dispose() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, DispatcherProvider.INSTANCE.getMain(), (CoroutineStart) null, new StreamLifecycleObserver$dispose$1(this, (Continuation) null), 2, (Object) null);
        this.isObserving = false;
        this.recurringResumeEvent = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.recurringResumeEvent) {
            this.handler.resume();
        }
        this.recurringResumeEvent = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStopped() {
        this.handler.stopped();
    }
}
