package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public final class ConsumeParams {
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

        public final ConsumeParams build() {
            if (this.zza != null) {
                ConsumeParams consumeParams = new ConsumeParams();
                String unused = consumeParams.zza = this.zza;
                return consumeParams;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }
    }

    private ConsumeParams() {
    }

    public final String getPurchaseToken() {
        return this.zza;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
