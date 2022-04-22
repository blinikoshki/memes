package com.snapchat.kit.sdk.core.metrics.p042a;

import android.content.SharedPreferences;
import com.snapchat.kit.sdk.core.metrics.MetricsClient;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.a.b */
public final class C4412b implements Factory<C4410a> {

    /* renamed from: a */
    private final Provider<SharedPreferences> f1156a;

    /* renamed from: b */
    private final Provider<MetricsClient> f1157b;

    /* renamed from: c */
    private final Provider<C4414a> f1158c;

    private C4412b(Provider<SharedPreferences> provider, Provider<MetricsClient> provider2, Provider<C4414a> provider3) {
        this.f1156a = provider;
        this.f1157b = provider2;
        this.f1158c = provider3;
    }

    /* renamed from: a */
    public static Factory<C4410a> m861a(Provider<SharedPreferences> provider, Provider<MetricsClient> provider2, Provider<C4414a> provider3) {
        return new C4412b(provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return new C4410a(this.f1156a.get(), this.f1157b.get(), this.f1158c.get());
    }
}
