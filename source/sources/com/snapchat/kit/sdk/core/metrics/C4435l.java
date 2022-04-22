package com.snapchat.kit.sdk.core.metrics;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.snapchat.kit.sdk.core.metrics.l */
public final class C4435l implements Factory<ScheduledExecutorService> {

    /* renamed from: a */
    private static final C4435l f1204a = new C4435l();

    /* renamed from: a */
    public static Factory<ScheduledExecutorService> m891a() {
        return f1204a;
    }

    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) Preconditions.checkNotNull(Executors.newSingleThreadScheduledExecutor(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
