package com.snapchat.kit.sdk;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;

/* renamed from: com.snapchat.kit.sdk.m */
public final class C4516m implements Factory<OkHttpClient> {

    /* renamed from: a */
    private final C4488g f1397a;

    private C4516m(C4488g gVar) {
        this.f1397a = gVar;
    }

    /* renamed from: a */
    public static Factory<OkHttpClient> m990a(C4488g gVar) {
        return new C4516m(gVar);
    }

    public final /* synthetic */ Object get() {
        return (OkHttpClient) Preconditions.checkNotNull(C4488g.m957h(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
