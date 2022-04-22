package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public class SkuDetailsParams {
    /* access modifiers changed from: private */
    public String zza;
    /* access modifiers changed from: private */
    public String zzb;
    /* access modifiers changed from: private */
    public List<String> zzc;
    /* access modifiers changed from: private */
    public List<zzap> zzd;

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public static class Builder {
        private String zza;
        private List<String> zzb;

        private Builder() {
        }

        public Builder setSkusList(List<String> list) {
            this.zzb = new ArrayList(list);
            return this;
        }

        public Builder setType(String str) {
            this.zza = str;
            return this;
        }

        public SkuDetailsParams build() {
            if (this.zza == null) {
                throw new IllegalArgumentException("SKU type must be set");
            } else if (this.zzb != null) {
                SkuDetailsParams skuDetailsParams = new SkuDetailsParams();
                String unused = skuDetailsParams.zza = this.zza;
                List unused2 = skuDetailsParams.zzc = this.zzb;
                List unused3 = skuDetailsParams.zzd = null;
                String unused4 = skuDetailsParams.zzb = null;
                return skuDetailsParams;
            } else {
                throw new IllegalArgumentException("SKU list or SkuWithOffer list must be set");
            }
        }
    }

    public String getSkuType() {
        return this.zza;
    }

    public List<String> getSkusList() {
        return this.zzc;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
