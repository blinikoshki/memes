package com.snapchat.kit.sdk.login.p047b;

import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import com.snapchat.kit.sdk.login.p046a.C4507a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.login.b.b */
public final class C4511b implements Factory<C4510a> {

    /* renamed from: a */
    private final Provider<AuthTokenManager> f1385a;

    /* renamed from: b */
    private final Provider<LoginStateController> f1386b;

    /* renamed from: c */
    private final Provider<C4507a> f1387c;

    private C4511b(Provider<AuthTokenManager> provider, Provider<LoginStateController> provider2, Provider<C4507a> provider3) {
        this.f1385a = provider;
        this.f1386b = provider2;
        this.f1387c = provider3;
    }

    /* renamed from: a */
    public static Factory<C4510a> m984a(Provider<AuthTokenManager> provider, Provider<LoginStateController> provider2, Provider<C4507a> provider3) {
        return new C4511b(provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return new C4510a(this.f1385a.get(), this.f1386b.get(), this.f1387c.get());
    }
}
