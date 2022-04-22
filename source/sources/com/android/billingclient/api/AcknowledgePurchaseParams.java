package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public final class AcknowledgePurchaseParams {
    /* access modifiers changed from: private */
    public String zza;

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public static final class Builder {
        private String zza;

        private Builder() {
        }

        public final Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }

        public final AcknowledgePurchaseParams build() {
            if (this.zza != null) {
                AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams();
                String unused = acknowledgePurchaseParams.zza = this.zza;
                return acknowledgePurchaseParams;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }
    }

    private AcknowledgePurchaseParams() {
    }

    public final String getPurchaseToken() {
        return this.zza;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
