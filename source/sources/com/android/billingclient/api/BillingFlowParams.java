package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public class BillingFlowParams {
    public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
    public static final String EXTRA_PARAM_KEY_OLD_SKUS = "skusToReplace";
    public static final String EXTRA_PARAM_KEY_OLD_SKU_PURCHASE_TOKEN = "oldSkuPurchaseToken";
    public static final String EXTRA_PARAM_KEY_REPLACE_SKUS_PRORATION_MODE = "prorationMode";
    public static final String EXTRA_PARAM_KEY_VR = "vr";
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public String zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public String zzf;
    /* access modifiers changed from: private */
    public int zzg;
    /* access modifiers changed from: private */
    public ArrayList<SkuDetails> zzh;
    /* access modifiers changed from: private */
    public boolean zzi;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public @interface ProrationMode {
        public static final int DEFERRED = 4;
        public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
        public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
        public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
        public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY = 0;
    }

    private BillingFlowParams() {
        this.zzg = 0;
    }

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public static class Builder {
        private String zza;
        private String zzb;
        private String zzc;
        private String zzd;
        private int zze;
        private ArrayList<SkuDetails> zzf;
        private boolean zzg;

        private Builder() {
            this.zze = 0;
        }

        public Builder setSkuDetails(SkuDetails skuDetails) {
            ArrayList<SkuDetails> arrayList = new ArrayList<>();
            arrayList.add(skuDetails);
            this.zzf = arrayList;
            return this;
        }

        public Builder setOldSku(String str, String str2) {
            this.zzb = str;
            this.zzc = str2;
            return this;
        }

        public Builder setReplaceSkusProrationMode(int i) {
            this.zze = i;
            return this;
        }

        public Builder setObfuscatedAccountId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setVrPurchaseFlow(boolean z) {
            this.zzg = z;
            return this;
        }

        public Builder setObfuscatedProfileId(String str) {
            this.zzd = str;
            return this;
        }

        public BillingFlowParams build() {
            ArrayList<SkuDetails> arrayList = this.zzf;
            if (arrayList == null || arrayList.isEmpty()) {
                throw new IllegalArgumentException("SkuDetails must be provided.");
            }
            ArrayList arrayList2 = this.zzf;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                if (((SkuDetails) obj) == null) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
            }
            if (this.zzf.size() > 1) {
                SkuDetails skuDetails = this.zzf.get(0);
                String type = skuDetails.getType();
                ArrayList arrayList3 = this.zzf;
                int size2 = arrayList3.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList3.get(i2);
                    i2++;
                    if (!type.equals(((SkuDetails) obj2).getType())) {
                        throw new IllegalArgumentException("SKUs should have the same type.");
                    }
                }
                String zza2 = skuDetails.zza();
                ArrayList arrayList4 = this.zzf;
                int size3 = arrayList4.size();
                int i3 = 0;
                while (i3 < size3) {
                    Object obj3 = arrayList4.get(i3);
                    i3++;
                    if (!zza2.equals(((SkuDetails) obj3).zza())) {
                        throw new IllegalArgumentException("All SKUs must have the same package name.");
                    }
                }
            }
            BillingFlowParams billingFlowParams = new BillingFlowParams();
            boolean unused = billingFlowParams.zza = true ^ this.zzf.get(0).zza().isEmpty();
            String unused2 = billingFlowParams.zzb = null;
            String unused3 = billingFlowParams.zzc = this.zza;
            String unused4 = billingFlowParams.zzf = this.zzd;
            String unused5 = billingFlowParams.zzd = this.zzb;
            String unused6 = billingFlowParams.zze = this.zzc;
            int unused7 = billingFlowParams.zzg = this.zze;
            ArrayList unused8 = billingFlowParams.zzh = this.zzf;
            boolean unused9 = billingFlowParams.zzi = this.zzg;
            return billingFlowParams;
        }
    }

    public String getSku() {
        return this.zzh.get(0).getSku();
    }

    public String getSkuType() {
        return this.zzh.get(0).getType();
    }

    public SkuDetails getSkuDetails() {
        return this.zzh.get(0);
    }

    public final ArrayList<SkuDetails> zza() {
        ArrayList<SkuDetails> arrayList = new ArrayList<>();
        arrayList.addAll(this.zzh);
        return arrayList;
    }

    public String getOldSku() {
        return this.zzd;
    }

    public String getOldSkuPurchaseToken() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzc;
    }

    public boolean getVrPurchaseFlow() {
        return this.zzi;
    }

    public int getReplaceSkusProrationMode() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return (!this.zzi && this.zzc == null && this.zzf == null && this.zzg == 0 && !this.zza) ? false : true;
    }

    public final String zzd() {
        return this.zzf;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
