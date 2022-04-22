package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzvq extends BroadcastReceiver {
    final /* synthetic */ zzvs zza;
    private final String zzb;

    public zzvq(zzvs zzvs, String str) {
        this.zza = zzvs;
        this.zzb = str;
    }

    public final void onReceive(Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                zzvr zzvr = (zzvr) this.zza.zzd.get(this.zzb);
                if (zzvr == null) {
                    zzvs.zza.mo39950e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    zzvr.zze = zzvs.zzf(str);
                    if (zzvr.zze == null) {
                        zzvs.zza.mo39950e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzaf.zzb(zzvr.zzd)) {
                        zzvs.zzj(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
