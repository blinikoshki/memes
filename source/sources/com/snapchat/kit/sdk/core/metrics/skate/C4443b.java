package com.snapchat.kit.sdk.core.metrics.skate;

import android.content.SharedPreferences;
import com.snapchat.kit.sdk.core.config.C4391f;
import com.snapchat.kit.sdk.core.metrics.business.C4425h;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.skate.b */
public final class C4443b implements Factory<C4441a> {

    /* renamed from: a */
    private final Provider<C4391f> f1224a;

    /* renamed from: b */
    private final Provider<SharedPreferences> f1225b;

    /* renamed from: c */
    private final Provider<C4425h> f1226c;

    /* renamed from: d */
    private final Provider<SkateClient> f1227d;

    /* renamed from: e */
    private final Provider<C4414a> f1228e;

    private C4443b(Provider<C4391f> provider, Provider<SharedPreferences> provider2, Provider<C4425h> provider3, Provider<SkateClient> provider4, Provider<C4414a> provider5) {
        this.f1224a = provider;
        this.f1225b = provider2;
        this.f1226c = provider3;
        this.f1227d = provider4;
        this.f1228e = provider5;
    }

    /* renamed from: a */
    public static Factory<C4441a> m896a(Provider<C4391f> provider, Provider<SharedPreferences> provider2, Provider<C4425h> provider3, Provider<SkateClient> provider4, Provider<C4414a> provider5) {
        return new C4443b(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new C4441a(this.f1224a.get(), this.f1225b.get(), this.f1226c.get(), this.f1227d.get(), this.f1228e.get());
    }
}
