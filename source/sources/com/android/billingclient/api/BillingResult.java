package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public final class BillingResult {
    /* access modifiers changed from: private */
    public int zza;
    /* access modifiers changed from: private */
    public String zzb;

    public final int getResponseCode() {
        return this.zza;
    }

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public static class Builder {
        private int zza;
        private String zzb;

        private Builder() {
            this.zzb = "";
        }

        public Builder setResponseCode(int i) {
            this.zza = i;
            return this;
        }

        public Builder setDebugMessage(String str) {
            this.zzb = str;
            return this;
        }

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            int unused = billingResult.zza = this.zza;
            String unused2 = billingResult.zzb = this.zzb;
            return billingResult;
        }
    }

    public final String getDebugMessage() {
        return this.zzb;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
