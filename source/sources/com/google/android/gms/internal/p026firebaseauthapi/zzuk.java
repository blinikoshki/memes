package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuk */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzuk extends zzqa implements Api.ApiOptions.HasOptions {
    private final String zzb;

    /* synthetic */ zzuk(String str, zzui zzui) {
        this.zzb = Preconditions.checkNotEmpty(str, "A valid API key must be provided");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzuk)) {
            return false;
        }
        zzuk zzuk = (zzuk) obj;
        return Objects.equal(this.zzb, zzuk.zzb) && this.zza == zzuk.zza;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb) + (true ^ this.zza ? 1 : 0);
    }

    public final String zzb() {
        return this.zzb;
    }

    /* renamed from: zzc */
    public final zzuk zza() {
        return new zzuk(Preconditions.checkNotEmpty(this.zzb), (zzui) null);
    }
}
