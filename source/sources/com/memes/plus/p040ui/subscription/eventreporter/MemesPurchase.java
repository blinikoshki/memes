package com.memes.plus.p040ui.subscription.eventreporter;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/eventreporter/MemesPurchase;", "", "orderId", "", "productSku", "purchaseTime", "", "priceValue", "", "priceCurrency", "isAutoRenewing", "", "(Ljava/lang/String;Ljava/lang/String;JDLjava/lang/String;Z)V", "()Z", "getOrderId", "()Ljava/lang/String;", "getPriceCurrency", "getPriceValue", "()D", "getProductSku", "getPurchaseTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "priceValueStr", "toString", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.eventreporter.MemesPurchase */
/* compiled from: MemesPurchase.kt */
public final class MemesPurchase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean isAutoRenewing;
    private final String orderId;
    private final String priceCurrency;
    private final double priceValue;
    private final String productSku;
    private final long purchaseTime;

    public static /* synthetic */ MemesPurchase copy$default(MemesPurchase memesPurchase, String str, String str2, long j, double d, String str3, boolean z, int i, Object obj) {
        MemesPurchase memesPurchase2 = memesPurchase;
        return memesPurchase.copy((i & 1) != 0 ? memesPurchase2.orderId : str, (i & 2) != 0 ? memesPurchase2.productSku : str2, (i & 4) != 0 ? memesPurchase2.purchaseTime : j, (i & 8) != 0 ? memesPurchase2.priceValue : d, (i & 16) != 0 ? memesPurchase2.priceCurrency : str3, (i & 32) != 0 ? memesPurchase2.isAutoRenewing : z);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.productSku;
    }

    public final long component3() {
        return this.purchaseTime;
    }

    public final double component4() {
        return this.priceValue;
    }

    public final String component5() {
        return this.priceCurrency;
    }

    public final boolean component6() {
        return this.isAutoRenewing;
    }

    public final MemesPurchase copy(String str, String str2, long j, double d, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "productSku");
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "priceCurrency");
        return new MemesPurchase(str, str2, j, d, str4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemesPurchase)) {
            return false;
        }
        MemesPurchase memesPurchase = (MemesPurchase) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) memesPurchase.orderId) && Intrinsics.areEqual((Object) this.productSku, (Object) memesPurchase.productSku) && this.purchaseTime == memesPurchase.purchaseTime && Double.compare(this.priceValue, memesPurchase.priceValue) == 0 && Intrinsics.areEqual((Object) this.priceCurrency, (Object) memesPurchase.priceCurrency) && this.isAutoRenewing == memesPurchase.isAutoRenewing;
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.productSku;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.purchaseTime)) * 31) + Double.doubleToLongBits(this.priceValue)) * 31;
        String str3 = this.priceCurrency;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.isAutoRenewing;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "MemesPurchase(orderId=" + this.orderId + ", productSku=" + this.productSku + ", purchaseTime=" + this.purchaseTime + ", priceValue=" + this.priceValue + ", priceCurrency=" + this.priceCurrency + ", isAutoRenewing=" + this.isAutoRenewing + ")";
    }

    public MemesPurchase(String str, String str2, long j, double d, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "productSku");
        Intrinsics.checkNotNullParameter(str3, "priceCurrency");
        this.orderId = str;
        this.productSku = str2;
        this.purchaseTime = j;
        this.priceValue = d;
        this.priceCurrency = str3;
        this.isAutoRenewing = z;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getProductSku() {
        return this.productSku;
    }

    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final double getPriceValue() {
        return this.priceValue;
    }

    public final String getPriceCurrency() {
        return this.priceCurrency;
    }

    public final boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/eventreporter/MemesPurchase$Companion;", "", "()V", "from", "Lcom/memes/plus/ui/subscription/eventreporter/MemesPurchase;", "purchase", "Lcom/android/billingclient/api/Purchase;", "skuDetails", "Lcom/android/billingclient/api/SkuDetails;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.subscription.eventreporter.MemesPurchase$Companion */
    /* compiled from: MemesPurchase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemesPurchase from(Purchase purchase, SkuDetails skuDetails) {
            Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
            Intrinsics.checkNotNullParameter(skuDetails, "skuDetails");
            String orderId = purchase.getOrderId();
            Intrinsics.checkNotNullExpressionValue(orderId, "purchase.orderId");
            String sku = purchase.getSku();
            Intrinsics.checkNotNullExpressionValue(sku, "purchase.sku");
            long purchaseTime = purchase.getPurchaseTime();
            double originalPriceValue = SkuDetailsExtKt.originalPriceValue(skuDetails);
            String priceCurrencyCode = skuDetails.getPriceCurrencyCode();
            Intrinsics.checkNotNullExpressionValue(priceCurrencyCode, "skuDetails.priceCurrencyCode");
            return new MemesPurchase(orderId, sku, purchaseTime, originalPriceValue, priceCurrencyCode, purchase.isAutoRenewing());
        }
    }

    public final String priceValueStr() {
        return String.valueOf(this.priceValue);
    }
}
