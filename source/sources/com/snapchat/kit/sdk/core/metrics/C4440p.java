package com.snapchat.kit.sdk.core.metrics;

import android.content.SharedPreferences;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.p */
public final class C4440p implements Factory<C4438o> {

    /* renamed from: a */
    private final Provider<SharedPreferences> f1213a;

    /* renamed from: b */
    private final Provider<MetricsClient> f1214b;

    /* renamed from: c */
    private final Provider<C4414a> f1215c;

    /* renamed from: d */
    private final Provider<String> f1216d;

    private C4440p(Provider<SharedPreferences> provider, Provider<MetricsClient> provider2, Provider<C4414a> provider3, Provider<String> provider4) {
        this.f1213a = provider;
        this.f1214b = provider2;
        this.f1215c = provider3;
        this.f1216d = provider4;
    }

    /* renamed from: a */
    public static Factory<C4438o> m894a(Provider<SharedPreferences> provider, Provider<MetricsClient> provider2, Provider<C4414a> provider3, Provider<String> provider4) {
        return new C4440p(provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return new C4438o(this.f1213a.get(), this.f1214b.get(), this.f1215c.get(), this.f1216d.get());
    }
}
