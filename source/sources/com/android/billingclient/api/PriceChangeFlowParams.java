package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public class PriceChangeFlowParams {
    /* access modifiers changed from: private */
    public SkuDetails zza;

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public static class Builder {
        private SkuDetails zza;

        public Builder setSkuDetails(SkuDetails skuDetails) {
            this.zza = skuDetails;
            return this;
        }

        public PriceChangeFlowParams build() {
            if (this.zza != null) {
                PriceChangeFlowParams priceChangeFlowParams = new PriceChangeFlowParams();
                SkuDetails unused = priceChangeFlowParams.zza = this.zza;
                return priceChangeFlowParams;
            }
            throw new IllegalArgumentException("SkuDetails must be set");
        }
    }

    public SkuDetails getSkuDetails() {
        return this.zza;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
