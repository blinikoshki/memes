package com.snapchat.kit.sdk.core.metrics.skate;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import java.util.Random;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.skate.e */
public final class C4447e implements Factory<C4446d> {

    /* renamed from: a */
    private final Provider<SharedPreferences> f1240a;

    /* renamed from: b */
    private final Provider<Random> f1241b;

    private C4447e(Provider<SharedPreferences> provider, Provider<Random> provider2) {
        this.f1240a = provider;
        this.f1241b = provider2;
    }

    /* renamed from: a */
    public static Factory<C4446d> m907a(Provider<SharedPreferences> provider, Provider<Random> provider2) {
        return new C4447e(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new C4446d(this.f1240a.get(), this.f1241b.get());
    }
}
