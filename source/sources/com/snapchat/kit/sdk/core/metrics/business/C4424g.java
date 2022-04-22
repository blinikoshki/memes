package com.snapchat.kit.sdk.core.metrics.business;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.business.g */
public final class C4424g implements Factory<KitEventBaseFactory> {

    /* renamed from: a */
    private final Provider<String> f1183a;

    private C4424g(Provider<String> provider) {
        this.f1183a = provider;
    }

    /* renamed from: a */
    public static Factory<KitEventBaseFactory> m876a(Provider<String> provider) {
        return new C4424g(provider);
    }

    /* renamed from: a */
    public static KitEventBaseFactory m875a(String str) {
        return new KitEventBaseFactory(str);
    }

    public final /* synthetic */ Object get() {
        return new KitEventBaseFactory(this.f1183a.get());
    }
}
