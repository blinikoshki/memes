package com.snapchat.kit.sdk.core.metrics;

import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.p042a.C4410a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.k */
public final class C4434k implements Factory<MetricQueue<OpMetric>> {

    /* renamed from: a */
    private final Provider<C4410a> f1201a;

    /* renamed from: b */
    private final Provider<ScheduledExecutorService> f1202b;

    /* renamed from: c */
    private final Provider<C4413b> f1203c;

    private C4434k(Provider<C4410a> provider, Provider<ScheduledExecutorService> provider2, Provider<C4413b> provider3) {
        this.f1201a = provider;
        this.f1202b = provider2;
        this.f1203c = provider3;
    }

    /* renamed from: a */
    public static Factory<MetricQueue<OpMetric>> m890a(Provider<C4410a> provider, Provider<ScheduledExecutorService> provider2, Provider<C4413b> provider3) {
        return new C4434k(provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        C4402a aVar = new C4402a(this.f1201a.get(), this.f1202b.get(), this.f1203c.get(), 10);
        aVar.mo61333a();
        return (MetricQueue) Preconditions.checkNotNull(aVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
