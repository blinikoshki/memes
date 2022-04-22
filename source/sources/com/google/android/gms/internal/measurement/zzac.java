package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzac extends zzbg {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzm zzc;
    final /* synthetic */ zzbr zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzac(zzbr zzbr, String str, String str2, zzm zzm) {
        super(zzbr, true);
        this.zzd = zzbr;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzm;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzk.getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zzb((Bundle) null);
    }
}
