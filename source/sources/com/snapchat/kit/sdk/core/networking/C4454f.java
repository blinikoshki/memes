package com.snapchat.kit.sdk.core.networking;

import com.snapchat.kit.sdk.C4475d;
import com.snapchat.kit.sdk.core.controller.C4396a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.networking.f */
public final class C4454f implements Factory<C4452e> {

    /* renamed from: a */
    private final Provider<C4475d> f1261a;

    /* renamed from: b */
    private final Provider<C4396a> f1262b;

    /* renamed from: c */
    private final Provider<String> f1263c;

    private C4454f(Provider<C4475d> provider, Provider<C4396a> provider2, Provider<String> provider3) {
        this.f1261a = provider;
        this.f1262b = provider2;
        this.f1263c = provider3;
    }

    /* renamed from: a */
    public static Factory<C4452e> m913a(Provider<C4475d> provider, Provider<C4396a> provider2, Provider<String> provider3) {
        return new C4454f(provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return new C4452e(this.f1261a.get(), this.f1262b.get(), this.f1263c.get());
    }
}
