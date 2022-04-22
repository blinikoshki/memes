package com.snapchat.kit.sdk;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.snapchat.kit.sdk.core.security.SecureSharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.o */
public final class C4518o implements Factory<SecureSharedPreferences> {

    /* renamed from: a */
    private final C4488g f1399a;

    /* renamed from: b */
    private final Provider<Gson> f1400b;

    /* renamed from: c */
    private final Provider<SharedPreferences> f1401c;

    private C4518o(C4488g gVar, Provider<Gson> provider, Provider<SharedPreferences> provider2) {
        this.f1399a = gVar;
        this.f1400b = provider;
        this.f1401c = provider2;
    }

    /* renamed from: a */
    public static Factory<SecureSharedPreferences> m992a(C4488g gVar, Provider<Gson> provider, Provider<SharedPreferences> provider2) {
        return new C4518o(gVar, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (SecureSharedPreferences) Preconditions.checkNotNull(this.f1399a.mo61799a(this.f1400b.get(), this.f1401c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
