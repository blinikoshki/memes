package com.snapchat.kit.sdk;

import com.snapchat.kit.sdk.core.config.C4391f;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.model.SkateEvent;
import com.snapchat.kit.sdk.core.metrics.model.SnapKitInitType;
import com.snapchat.kit.sdk.core.metrics.skate.C4444c;
import com.snapchat.kit.sdk.core.metrics.skate.C4446d;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.q */
public final class C4520q implements Factory<C4444c> {

    /* renamed from: a */
    private final C4488g f1403a;

    /* renamed from: b */
    private final Provider<C4391f> f1404b;

    /* renamed from: c */
    private final Provider<C4446d> f1405c;

    /* renamed from: d */
    private final Provider<MetricQueue<SkateEvent>> f1406d;

    /* renamed from: e */
    private final Provider<C4475d> f1407e;

    /* renamed from: f */
    private final Provider<SnapKitInitType> f1408f;

    private C4520q(C4488g gVar, Provider<C4391f> provider, Provider<C4446d> provider2, Provider<MetricQueue<SkateEvent>> provider3, Provider<C4475d> provider4, Provider<SnapKitInitType> provider5) {
        this.f1403a = gVar;
        this.f1404b = provider;
        this.f1405c = provider2;
        this.f1406d = provider3;
        this.f1407e = provider4;
        this.f1408f = provider5;
    }

    /* renamed from: a */
    public static Factory<C4444c> m994a(C4488g gVar, Provider<C4391f> provider, Provider<C4446d> provider2, Provider<MetricQueue<SkateEvent>> provider3, Provider<C4475d> provider4, Provider<SnapKitInitType> provider5) {
        return new C4520q(gVar, provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return (C4444c) Preconditions.checkNotNull(C4488g.m954a(this.f1404b.get(), this.f1405c.get(), this.f1406d.get(), this.f1407e.get(), this.f1408f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
