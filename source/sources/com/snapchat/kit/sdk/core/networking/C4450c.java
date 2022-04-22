package com.snapchat.kit.sdk.core.networking;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.Cache;

/* renamed from: com.snapchat.kit.sdk.core.networking.c */
public final class C4450c implements Factory<ClientFactory> {

    /* renamed from: a */
    private final Provider<Cache> f1252a;

    /* renamed from: b */
    private final Provider<Gson> f1253b;

    /* renamed from: c */
    private final Provider<C4448a> f1254c;

    /* renamed from: d */
    private final Provider<C4452e> f1255d;

    /* renamed from: e */
    private final Provider<C4455g> f1256e;

    private C4450c(Provider<Cache> provider, Provider<Gson> provider2, Provider<C4448a> provider3, Provider<C4452e> provider4, Provider<C4455g> provider5) {
        this.f1252a = provider;
        this.f1253b = provider2;
        this.f1254c = provider3;
        this.f1255d = provider4;
        this.f1256e = provider5;
    }

    /* renamed from: a */
    public static Factory<ClientFactory> m911a(Provider<Cache> provider, Provider<Gson> provider2, Provider<C4448a> provider3, Provider<C4452e> provider4, Provider<C4455g> provider5) {
        return new C4450c(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new ClientFactory(this.f1252a.get(), this.f1253b.get(), this.f1254c.get(), this.f1255d.get(), this.f1256e.get());
    }
}
