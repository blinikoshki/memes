package com.snapchat.kit.sdk.core.metrics;

import com.snap.kit.sdk.model.SnapKitStorySnapView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.h */
public final class C4431h implements Factory<MetricQueue<SnapKitStorySnapView>> {

    /* renamed from: a */
    private final Provider<C4438o> f1195a;

    /* renamed from: b */
    private final Provider<ScheduledExecutorService> f1196b;

    /* renamed from: c */
    private final Provider<C4413b> f1197c;

    /* renamed from: a */
    public static MetricQueue<SnapKitStorySnapView> m887a(C4438o oVar, ScheduledExecutorService scheduledExecutorService, Object obj) {
        return C4427d.m883a(oVar, scheduledExecutorService, (C4413b) obj);
    }

    public final /* synthetic */ Object get() {
        return (MetricQueue) Preconditions.checkNotNull(C4427d.m883a(this.f1195a.get(), this.f1196b.get(), this.f1197c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
