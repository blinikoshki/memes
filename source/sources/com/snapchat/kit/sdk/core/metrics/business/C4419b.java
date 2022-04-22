package com.snapchat.kit.sdk.core.metrics.business;

import android.content.SharedPreferences;
import com.snapchat.kit.sdk.core.metrics.MetricsClient;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.business.b */
public final class C4419b implements Factory<C4417a> {

    /* renamed from: a */
    private final Provider<SharedPreferences> f1173a;

    /* renamed from: b */
    private final Provider<C4425h> f1174b;

    /* renamed from: c */
    private final Provider<MetricsClient> f1175c;

    /* renamed from: d */
    private final Provider<C4414a> f1176d;

    private C4419b(Provider<SharedPreferences> provider, Provider<C4425h> provider2, Provider<MetricsClient> provider3, Provider<C4414a> provider4) {
        this.f1173a = provider;
        this.f1174b = provider2;
        this.f1175c = provider3;
        this.f1176d = provider4;
    }

    /* renamed from: a */
    public static Factory<C4417a> m868a(Provider<SharedPreferences> provider, Provider<C4425h> provider2, Provider<MetricsClient> provider3, Provider<C4414a> provider4) {
        return new C4419b(provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return new C4417a(this.f1173a.get(), this.f1174b.get(), this.f1175c.get(), this.f1176d.get());
    }
}
