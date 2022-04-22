package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvp */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzvp extends zztq {
    final /* synthetic */ zzvs zza;
    private final String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzvp(zzvs zzvs, zztq zztq, String str) {
        super(zztq);
        this.zza = zzvs;
        this.zzb = str;
    }

    public final void zzh(String str) {
        zzvs.zza.mo39948d("onCodeSent", new Object[0]);
        zzvr zzvr = (zzvr) this.zza.zzd.get(this.zzb);
        if (zzvr != null) {
            for (zztq zzh : zzvr.zzb) {
                zzh.zzh(str);
            }
            zzvr.zzg = true;
            zzvr.zzd = str;
            if (zzvr.zza <= 0) {
                this.zza.zzg(this.zzb);
            } else if (!zzvr.zzc) {
                this.zza.zzo(this.zzb);
            } else if (!zzaf.zzb(zzvr.zze)) {
                zzvs.zzj(this.zza, this.zzb);
            }
        }
    }

    public final void zzk(Status status) {
        Logger zzh = zzvs.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        String statusMessage = status.getStatusMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(statusCodeString).length() + 39 + String.valueOf(statusMessage).length());
        sb.append("SMS verification code request failed: ");
        sb.append(statusCodeString);
        sb.append(StringUtils.SPACE);
        sb.append(statusMessage);
        zzh.mo39950e(sb.toString(), new Object[0]);
        zzvr zzvr = (zzvr) this.zza.zzd.get(this.zzb);
        if (zzvr != null) {
            for (zztq zzk : zzvr.zzb) {
                zzk.zzk(status);
            }
            this.zza.zze(this.zzb);
        }
    }
}
