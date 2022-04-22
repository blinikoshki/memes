package com.snapchat.kit.sdk.creative.p045b;

import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.creative.b.d */
public final class C4473d implements Factory<C4472c> {

    /* renamed from: a */
    private final Provider<MetricQueue<OpMetric>> f1280a;

    private C4473d(Provider<MetricQueue<OpMetric>> provider) {
        this.f1280a = provider;
    }

    /* renamed from: a */
    public static Factory<C4472c> m929a(Provider<MetricQueue<OpMetric>> provider) {
        return new C4473d(provider);
    }

    public final /* synthetic */ Object get() {
        return new C4472c(this.f1280a.get());
    }
}
