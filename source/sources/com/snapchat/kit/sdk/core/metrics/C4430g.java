package com.snapchat.kit.sdk.core.metrics;

import com.snapchat.kit.sdk.core.metrics.model.SkateEvent;
import com.snapchat.kit.sdk.core.metrics.skate.C4441a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.g */
public final class C4430g implements Factory<MetricQueue<SkateEvent>> {

    /* renamed from: a */
    private final Provider<C4441a> f1192a;

    /* renamed from: b */
    private final Provider<ScheduledExecutorService> f1193b;

    /* renamed from: c */
    private final Provider<C4413b> f1194c;

    private C4430g(Provider<C4441a> provider, Provider<ScheduledExecutorService> provider2, Provider<C4413b> provider3) {
        this.f1192a = provider;
        this.f1193b = provider2;
        this.f1194c = provider3;
    }

    /* renamed from: a */
    public static Factory<MetricQueue<SkateEvent>> m886a(Provider<C4441a> provider, Provider<ScheduledExecutorService> provider2, Provider<C4413b> provider3) {
        return new C4430g(provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        C4402a aVar = new C4402a(this.f1192a.get(), this.f1193b.get(), this.f1194c.get(), 1);
        aVar.mo61333a();
        return (MetricQueue) Preconditions.checkNotNull(aVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
