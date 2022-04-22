package com.snapchat.kit.sdk.core.controller;

import android.os.Handler;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.controller.b */
public final class C4401b implements Factory<C4396a> {

    /* renamed from: a */
    private final Provider<Handler> f1130a;

    private C4401b(Provider<Handler> provider) {
        this.f1130a = provider;
    }

    /* renamed from: a */
    public static Factory<C4396a> m847a(Provider<Handler> provider) {
        return new C4401b(provider);
    }

    public final /* synthetic */ Object get() {
        return new C4396a(this.f1130a.get());
    }
}
