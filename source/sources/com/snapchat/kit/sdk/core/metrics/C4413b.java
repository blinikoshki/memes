package com.snapchat.kit.sdk.core.metrics;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.snapchat.kit.sdk.core.metrics.b */
final class C4413b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private WeakReference<Activity> f1159a;

    /* renamed from: b */
    private final ScheduledExecutorService f1160b;

    /* renamed from: c */
    private final List<C4402a> f1161c = new ArrayList();

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    C4413b(ScheduledExecutorService scheduledExecutorService) {
        this.f1160b = scheduledExecutorService;
    }

    public final void onActivityStarted(Activity activity) {
        this.f1159a = new WeakReference<>(activity);
    }

    public final void onActivityStopped(Activity activity) {
        WeakReference<Activity> weakReference = this.f1159a;
        if (weakReference != null && activity == weakReference.get()) {
            for (C4402a c : this.f1161c) {
                this.f1160b.execute(c.mo61335c());
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        WeakReference<Activity> weakReference = this.f1159a;
        if (weakReference != null && activity == weakReference.get()) {
            this.f1159a = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo61342a(C4402a aVar) {
        this.f1161c.add(aVar);
    }
}
