package com.snapchat.kit.sdk.core.metrics.business;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.business.f */
public final class C4423f implements Factory<C4422e> {

    /* renamed from: a */
    private final Provider<KitEventBaseFactory> f1182a;

    private C4423f(Provider<KitEventBaseFactory> provider) {
        this.f1182a = provider;
    }

    /* renamed from: a */
    public static Factory<C4422e> m874a(Provider<KitEventBaseFactory> provider) {
        return new C4423f(provider);
    }

    public final /* synthetic */ Object get() {
        return new C4422e(this.f1182a.get());
    }
}
