package com.snapchat.kit.sdk.core.config;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.config.g */
public final class C4395g implements Factory<C4391f> {

    /* renamed from: a */
    private final Provider<ConfigClient> f1121a;

    /* renamed from: b */
    private final Provider<SharedPreferences> f1122b;

    private C4395g(Provider<ConfigClient> provider, Provider<SharedPreferences> provider2) {
        this.f1121a = provider;
        this.f1122b = provider2;
    }

    /* renamed from: a */
    public static Factory<C4391f> m840a(Provider<ConfigClient> provider, Provider<SharedPreferences> provider2) {
        return new C4395g(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new C4391f(this.f1121a.get(), this.f1122b.get());
    }
}
