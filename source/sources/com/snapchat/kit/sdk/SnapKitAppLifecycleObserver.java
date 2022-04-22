package com.snapchat.kit.sdk;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.skate.C4444c;
import java.util.Date;
import javax.inject.Inject;

@SnapConnectScope
public class SnapKitAppLifecycleObserver implements LifecycleObserver {

    /* renamed from: a */
    private C4444c f1056a;

    @Inject
    SnapKitAppLifecycleObserver(C4444c cVar) {
        this.f1056a = cVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onEnterForeground() {
        this.f1056a.mo61661a(new Date());
    }
}
