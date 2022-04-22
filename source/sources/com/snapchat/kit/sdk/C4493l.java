package com.snapchat.kit.sdk;

import com.google.gson.Gson;
import com.snapchat.kit.sdk.core.controller.C4396a;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.business.C4422e;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.security.SecureSharedPreferences;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* renamed from: com.snapchat.kit.sdk.l */
public final class C4493l implements Factory<C4475d> {

    /* renamed from: a */
    private final C4488g f1350a;

    /* renamed from: b */
    private final Provider<SecureSharedPreferences> f1351b;

    /* renamed from: c */
    private final Provider<C4396a> f1352c;

    /* renamed from: d */
    private final Provider<OkHttpClient> f1353d;

    /* renamed from: e */
    private final Provider<Gson> f1354e;

    /* renamed from: f */
    private final Provider<MetricQueue<ServerEvent>> f1355f;

    /* renamed from: g */
    private final Provider<C4422e> f1356g;

    /* renamed from: h */
    private final Provider<MetricQueue<OpMetric>> f1357h;

    private C4493l(C4488g gVar, Provider<SecureSharedPreferences> provider, Provider<C4396a> provider2, Provider<OkHttpClient> provider3, Provider<Gson> provider4, Provider<MetricQueue<ServerEvent>> provider5, Provider<C4422e> provider6, Provider<MetricQueue<OpMetric>> provider7) {
        this.f1350a = gVar;
        this.f1351b = provider;
        this.f1352c = provider2;
        this.f1353d = provider3;
        this.f1354e = provider4;
        this.f1355f = provider5;
        this.f1356g = provider6;
        this.f1357h = provider7;
    }

    /* renamed from: a */
    public static Factory<C4475d> m972a(C4488g gVar, Provider<SecureSharedPreferences> provider, Provider<C4396a> provider2, Provider<OkHttpClient> provider3, Provider<Gson> provider4, Provider<MetricQueue<ServerEvent>> provider5, Provider<C4422e> provider6, Provider<MetricQueue<OpMetric>> provider7) {
        return new C4493l(gVar, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public final /* synthetic */ Object get() {
        return (C4475d) Preconditions.checkNotNull(this.f1350a.mo61800a(this.f1351b.get(), this.f1352c.get(), this.f1353d.get(), this.f1354e.get(), DoubleCheck.lazy(this.f1355f), this.f1356g.get(), DoubleCheck.lazy(this.f1357h)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
