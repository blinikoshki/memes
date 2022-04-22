package com.snapchat.kit.sdk.login.p046a;

import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.login.a.b */
public final class C4508b implements Factory<C4507a> {

    /* renamed from: a */
    private final Provider<MetricQueue<OpMetric>> f1377a;

    private C4508b(Provider<MetricQueue<OpMetric>> provider) {
        this.f1377a = provider;
    }

    /* renamed from: a */
    public static Factory<C4507a> m981a(Provider<MetricQueue<OpMetric>> provider) {
        return new C4508b(provider);
    }

    public final /* synthetic */ Object get() {
        return new C4507a(this.f1377a.get());
    }
}
