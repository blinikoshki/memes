package com.snapchat.kit.sdk.core.networking;

import com.snapchat.kit.sdk.C4475d;
import com.snapchat.kit.sdk.core.controller.C4396a;
import com.snapchat.kit.sdk.core.security.Fingerprint;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.networking.b */
public final class C4449b implements Factory<C4448a> {

    /* renamed from: a */
    private final Provider<C4475d> f1248a;

    /* renamed from: b */
    private final Provider<C4396a> f1249b;

    /* renamed from: c */
    private final Provider<String> f1250c;

    /* renamed from: d */
    private final Provider<Fingerprint> f1251d;

    private C4449b(Provider<C4475d> provider, Provider<C4396a> provider2, Provider<String> provider3, Provider<Fingerprint> provider4) {
        this.f1248a = provider;
        this.f1249b = provider2;
        this.f1250c = provider3;
        this.f1251d = provider4;
    }

    /* renamed from: a */
    public static Factory<C4448a> m910a(Provider<C4475d> provider, Provider<C4396a> provider2, Provider<String> provider3, Provider<Fingerprint> provider4) {
        return new C4449b(provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return new C4448a(this.f1248a.get(), this.f1249b.get(), this.f1250c.get(), this.f1251d.get());
    }
}
