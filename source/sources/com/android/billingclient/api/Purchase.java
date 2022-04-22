package com.android.billingclient.api;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public class Purchase {
    private final String zza;
    private final String zzb;
    private final JSONObject zzc;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public @interface PurchaseState {
        public static final int PENDING = 2;
        public static final int PURCHASED = 1;
        public static final int UNSPECIFIED_STATE = 0;
    }

    public Purchase(String str, String str2) throws JSONException {
        this.zza = str;
        this.zzb = str2;
        this.zzc = new JSONObject(str);
    }

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    public static class PurchasesResult {
        private final List<Purchase> zza;
        private final BillingResult zzb;

        public PurchasesResult(BillingResult billingResult, List<Purchase> list) {
            this.zza = list;
            this.zzb = billingResult;
        }

        public BillingResult getBillingResult() {
            return this.zzb;
        }

        public int getResponseCode() {
            return getBillingResult().getResponseCode();
        }

        public List<Purchase> getPurchasesList() {
            return this.zza;
        }
    }

    public String getOrderId() {
        return this.zzc.optString("orderId");
    }

    public String getPackageName() {
        return this.zzc.optString("packageName");
    }

    public String getSku() {
        return this.zzc.optString("productId");
    }

    public long getPurchaseTime() {
        return this.zzc.optLong("purchaseTime");
    }

    public String getPurchaseToken() {
        JSONObject jSONObject = this.zzc;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public int getPurchaseState() {
        return this.zzc.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public String getDeveloperPayload() {
        return this.zzc.optString("developerPayload");
    }

    public boolean isAcknowledged() {
        return this.zzc.optBoolean("acknowledged", true);
    }

    public boolean isAutoRenewing() {
        return this.zzc.optBoolean("autoRenewing");
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getSignature() {
        return this.zzb;
    }

    public AccountIdentifiers getAccountIdentifiers() {
        String optString = this.zzc.optString("obfuscatedAccountId");
        String optString2 = this.zzc.optString("obfuscatedProfileId");
        if (optString == null && optString2 == null) {
            return null;
        }
        return new AccountIdentifiers(optString, optString2);
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "Purchase. Json: ".concat(valueOf) : new String("Purchase. Json: ");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.zza, purchase.getOriginalJson()) && TextUtils.equals(this.zzb, purchase.getSignature());
    }

    public int hashCode() {
        return this.zza.hashCode();
    }
}
