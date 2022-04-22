package com.snapchat.kit.sdk.core.metrics;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.j */
public final class C4433j implements Factory<C4413b> {

    /* renamed from: a */
    private final Provider<Context> f1199a;

    /* renamed from: b */
    private final Provider<ScheduledExecutorService> f1200b;

    private C4433j(Provider<Context> provider, Provider<ScheduledExecutorService> provider2) {
        this.f1199a = provider;
        this.f1200b = provider2;
    }

    /* renamed from: a */
    public static Factory<C4413b> m889a(Provider<Context> provider, Provider<ScheduledExecutorService> provider2) {
        return new C4433j(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        C4413b bVar = new C4413b(this.f1200b.get());
        ((Application) this.f1199a.get().getApplicationContext()).registerActivityLifecycleCallbacks(bVar);
        return (C4413b) Preconditions.checkNotNull(bVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
