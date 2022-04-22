package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public final class AccountIdentifiers {
    private final String zza;
    private final String zzb;

    AccountIdentifiers(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final String getObfuscatedAccountId() {
        return this.zza;
    }

    public final String getObfuscatedProfileId() {
        return this.zzb;
    }
}
