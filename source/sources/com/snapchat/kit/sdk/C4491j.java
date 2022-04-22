package com.snapchat.kit.sdk;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.snapchat.kit.sdk.j */
public final class C4491j implements Factory<Context> {

    /* renamed from: a */
    private final C4488g f1348a;

    private C4491j(C4488g gVar) {
        this.f1348a = gVar;
    }

    /* renamed from: a */
    public static Factory<Context> m970a(C4488g gVar) {
        return new C4491j(gVar);
    }

    public final /* synthetic */ Object get() {
        return (Context) Preconditions.checkNotNull(this.f1348a.mo61801b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
