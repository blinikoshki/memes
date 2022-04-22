package com.snapchat.kit.sdk;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.snapchat.kit.sdk.p */
public final class C4519p implements Factory<SharedPreferences> {

    /* renamed from: a */
    private final C4488g f1402a;

    private C4519p(C4488g gVar) {
        this.f1402a = gVar;
    }

    /* renamed from: a */
    public static Factory<SharedPreferences> m993a(C4488g gVar) {
        return new C4519p(gVar);
    }

    public final /* synthetic */ Object get() {
        return (SharedPreferences) Preconditions.checkNotNull(this.f1402a.mo61804f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
