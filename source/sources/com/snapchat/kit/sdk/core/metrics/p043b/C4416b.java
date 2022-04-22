package com.snapchat.kit.sdk.core.metrics.p043b;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.b.b */
public final class C4416b implements Factory<C4414a> {

    /* renamed from: a */
    private final Provider<Gson> f1164a;

    private C4416b(Provider<Gson> provider) {
        this.f1164a = provider;
    }

    /* renamed from: a */
    public static Factory<C4414a> m867a(Provider<Gson> provider) {
        return new C4416b(provider);
    }

    public final /* synthetic */ Object get() {
        return new C4414a(this.f1164a.get());
    }
}
