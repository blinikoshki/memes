package com.snapchat.kit.sdk.core.metrics;

import android.content.SharedPreferences;
import com.snapchat.kit.sdk.core.metrics.business.C4425h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.m */
public final class C4436m implements Factory<C4425h> {

    /* renamed from: a */
    private final Provider<SharedPreferences> f1205a;

    private C4436m(Provider<SharedPreferences> provider) {
        this.f1205a = provider;
    }

    /* renamed from: a */
    public static Factory<C4425h> m892a(Provider<SharedPreferences> provider) {
        return new C4436m(provider);
    }

    public final /* synthetic */ Object get() {
        C4425h hVar = new C4425h(this.f1205a.get());
        hVar.mo61357a();
        return (C4425h) Preconditions.checkNotNull(hVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
