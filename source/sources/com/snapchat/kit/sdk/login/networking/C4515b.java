package com.snapchat.kit.sdk.login.networking;

import com.snapchat.kit.sdk.login.p046a.C4507a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.login.networking.b */
public final class C4515b implements Factory<C4513a> {

    /* renamed from: a */
    private final Provider<LoginClient> f1395a;

    /* renamed from: b */
    private final Provider<C4507a> f1396b;

    private C4515b(Provider<LoginClient> provider, Provider<C4507a> provider2) {
        this.f1395a = provider;
        this.f1396b = provider2;
    }

    /* renamed from: a */
    public static Factory<C4513a> m989a(Provider<LoginClient> provider, Provider<C4507a> provider2) {
        return new C4515b(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new C4513a(this.f1395a.get(), this.f1396b.get());
    }
}
