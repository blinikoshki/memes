package com.snapchat.kit.sdk.core.metrics.business;

import android.content.SharedPreferences;

/* renamed from: com.snapchat.kit.sdk.core.metrics.business.h */
public final class C4425h {

    /* renamed from: a */
    private final SharedPreferences f1184a;

    /* renamed from: b */
    private long f1185b = 0;

    public C4425h(SharedPreferences sharedPreferences) {
        this.f1184a = sharedPreferences;
    }

    /* renamed from: a */
    public final void mo61357a() {
        this.f1185b = this.f1184a.getLong("sequence_id_max", 0);
    }

    /* renamed from: b */
    public final long mo61358b() {
        long j = this.f1185b + 1;
        this.f1185b = j;
        this.f1184a.edit().putLong("sequence_id_max", this.f1185b).apply();
        return j;
    }

    /* renamed from: c */
    public final long mo61359c() {
        return this.f1185b;
    }
}
