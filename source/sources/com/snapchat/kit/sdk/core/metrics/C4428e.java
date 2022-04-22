package com.snapchat.kit.sdk.core.metrics;

import com.snapchat.kit.sdk.core.metrics.business.C4417a;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.e */
public final class C4428e implements Factory<C4402a<ServerEvent>> {

    /* renamed from: a */
    private final Provider<C4417a> f1188a;

    /* renamed from: b */
    private final Provider<ScheduledExecutorService> f1189b;

    /* renamed from: c */
    private final Provider<C4413b> f1190c;

    private C4428e(Provider<C4417a> provider, Provider<ScheduledExecutorService> provider2, Provider<C4413b> provider3) {
        this.f1188a = provider;
        this.f1189b = provider2;
        this.f1190c = provider3;
    }

    /* renamed from: a */
    public static Factory<C4402a<ServerEvent>> m884a(Provider<C4417a> provider, Provider<ScheduledExecutorService> provider2, Provider<C4413b> provider3) {
        return new C4428e(provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        C4402a aVar = new C4402a(this.f1188a.get(), this.f1189b.get(), this.f1190c.get(), 10);
        aVar.mo61333a();
        return (C4402a) Preconditions.checkNotNull(aVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
