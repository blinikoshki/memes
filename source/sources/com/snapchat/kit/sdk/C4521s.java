package com.snapchat.kit.sdk;

import com.snapchat.kit.sdk.core.metrics.skate.C4444c;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.s */
public final class C4521s implements Factory<SnapKitAppLifecycleObserver> {

    /* renamed from: a */
    private final C4488g f1409a;

    /* renamed from: b */
    private final Provider<C4444c> f1410b;

    private C4521s(C4488g gVar, Provider<C4444c> provider) {
        this.f1409a = gVar;
        this.f1410b = provider;
    }

    /* renamed from: a */
    public static Factory<SnapKitAppLifecycleObserver> m995a(C4488g gVar, Provider<C4444c> provider) {
        return new C4521s(gVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (SnapKitAppLifecycleObserver) Preconditions.checkNotNull(C4488g.m952a(this.f1410b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
