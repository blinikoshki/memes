package com.snapchat.kit.sdk.core.networking;

import com.snapchat.kit.sdk.core.security.Fingerprint;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.networking.h */
public final class C4456h implements Factory<C4455g> {

    /* renamed from: a */
    private final Provider<String> f1265a;

    /* renamed from: b */
    private final Provider<Fingerprint> f1266b;

    private C4456h(Provider<String> provider, Provider<Fingerprint> provider2) {
        this.f1265a = provider;
        this.f1266b = provider2;
    }

    /* renamed from: a */
    public static Factory<C4455g> m915a(Provider<String> provider, Provider<Fingerprint> provider2) {
        return new C4456h(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new C4455g(this.f1265a.get(), this.f1266b.get());
    }
}
