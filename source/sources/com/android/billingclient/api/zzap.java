package com.android.billingclient.api;

import android.text.TextUtils;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public class zzap {
    private final String zza;
    private final String zzb;

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public static class zza {
        private String zza;

        private zza() {
        }

        public final zza zza(String str) {
            this.zza = str;
            return this;
        }

        public final zzap zza() {
            if (!TextUtils.isEmpty(this.zza)) {
                return new zzap(this.zza);
            }
            throw new IllegalArgumentException("SKU must be set.");
        }
    }

    private zzap(String str, String str2) {
        this.zza = str;
        this.zzb = null;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
