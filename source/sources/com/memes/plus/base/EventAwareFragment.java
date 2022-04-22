package com.memes.plus.base;

import androidx.fragment.app.Fragment;
import com.memes.plus.events.NotifiableEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0003\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/base/EventAwareFragment;", "Landroidx/fragment/app/Fragment;", "()V", "enableEventBus", "", "fragmentId", "", "getFragmentId", "()Ljava/lang/String;", "fragmentId$delegate", "Lkotlin/Lazy;", "disableEventBus", "", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onPause", "onResume", "virtualId", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EventAwareFragment.kt */
public class EventAwareFragment extends Fragment {
    private boolean enableEventBus;
    private final Lazy fragmentId$delegate = LazyKt.lazy(EventAwareFragment$fragmentId$2.INSTANCE);

    private final String getFragmentId() {
        return (String) this.fragmentId$delegate.getValue();
    }

    public final String virtualId() {
        String fragmentId = getFragmentId();
        Intrinsics.checkNotNullExpressionValue(fragmentId, "fragmentId");
        return fragmentId;
    }

    public void onPause() {
        super.onPause();
        if (!this.enableEventBus) {
            return;
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
            return;
        }
        Timber.m303e("EventBus was not registered to " + this + ", yet we wanted to unregister it.", new Object[0]);
    }

    public void onResume() {
        super.onResume();
        if (!this.enableEventBus) {
            return;
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
            return;
        }
        Timber.m303e("EventBus was already registered to " + this + ", yet we wanted to register it.", new Object[0]);
    }

    public final void enableEventBus() {
        this.enableEventBus = true;
    }

    public final void disableEventBus() {
        this.enableEventBus = false;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventReceived(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        Timber.m303e("Unhandled event received for " + getFragmentId() + ": " + notifiableEvent, new Object[0]);
    }
}
