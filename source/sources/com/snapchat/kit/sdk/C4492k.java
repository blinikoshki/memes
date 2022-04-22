package com.snapchat.kit.sdk;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.snapchat.kit.sdk.k */
public final class C4492k implements Factory<Gson> {

    /* renamed from: a */
    private final C4488g f1349a;

    private C4492k(C4488g gVar) {
        this.f1349a = gVar;
    }

    /* renamed from: a */
    public static Factory<Gson> m971a(C4488g gVar) {
        return new C4492k(gVar);
    }

    public final /* synthetic */ Object get() {
        return (Gson) Preconditions.checkNotNull(C4488g.m956e(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
