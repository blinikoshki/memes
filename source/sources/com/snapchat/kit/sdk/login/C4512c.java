package com.snapchat.kit.sdk.login;

import com.snapchat.kit.sdk.core.networking.ClientFactory;
import com.snapchat.kit.sdk.login.networking.LoginClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.login.c */
public final class C4512c implements Factory<LoginClient> {

    /* renamed from: a */
    private final C4509b f1388a;

    /* renamed from: b */
    private final Provider<ClientFactory> f1389b;

    private C4512c(C4509b bVar, Provider<ClientFactory> provider) {
        this.f1388a = bVar;
        this.f1389b = provider;
    }

    /* renamed from: a */
    public static Factory<LoginClient> m985a(C4509b bVar, Provider<ClientFactory> provider) {
        return new C4512c(bVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (LoginClient) Preconditions.checkNotNull((LoginClient) this.f1389b.get().generateAuthedClient(LoginClient.class), "Cannot return null from a non-@Nullable @Provides method");
    }
}
