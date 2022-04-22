package com.snapchat.kit.sdk.core.metrics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.snapchat.kit.sdk.core.metrics.c */
public final class C4426c<T> {
    @SerializedName("retry_count")
    @Expose

    /* renamed from: a */
    private int f1186a;
    @SerializedName("event")
    @Expose

    /* renamed from: b */
    private T f1187b;

    public C4426c(T t) {
        this(t, 0);
    }

    public C4426c(T t, int i) {
        this.f1186a = i;
        this.f1187b = t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo61360a() {
        this.f1186a++;
    }

    /* renamed from: b */
    public final int mo61361b() {
        return this.f1186a;
    }

    /* renamed from: c */
    public final T mo61362c() {
        return this.f1187b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C4426c)) {
            return false;
        }
        C4426c cVar = (C4426c) obj;
        if (!Objects.equals(Integer.valueOf(this.f1186a), Integer.valueOf(cVar.f1186a)) || !Objects.equals(this.f1187b, cVar.f1187b)) {
            return false;
        }
        return true;
    }
}
