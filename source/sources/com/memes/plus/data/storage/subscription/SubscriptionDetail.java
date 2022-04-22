package com.memes.plus.data.storage.subscription;

import com.android.billingclient.api.Purchase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.plus.util.SimpleTimestampObfuscator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0000J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\t\u0010!\u001a\u00020\tHÖ\u0001J\u0006\u0010\"\u001a\u00020\u001cJ\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, mo26107d2 = {"Lcom/memes/plus/data/storage/subscription/SubscriptionDetail;", "", "orderId", "", "orderToken", "productSku", "encodedOrderTimestamp", "encodedRecentQueryTimestamp", "staticId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEncodedOrderTimestamp", "()Ljava/lang/String;", "getEncodedRecentQueryTimestamp", "getOrderId", "getOrderToken", "getProductSku", "getStaticId", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "createNowAccessedCopy", "equals", "", "other", "getOrderTimestamp", "", "getRecentQueryTimestamp", "hashCode", "isQueryableTimestampExpired", "toString", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SubscriptionDetail.kt */
public final class SubscriptionDetail {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long QUERY_BUFFER_MILLIS = 28800000;
    public static final int ROW_ID = 997;
    private final String encodedOrderTimestamp;
    private final String encodedRecentQueryTimestamp;
    private final String orderId;
    private final String orderToken;
    private final String productSku;
    private final int staticId;

    public static /* synthetic */ SubscriptionDetail copy$default(SubscriptionDetail subscriptionDetail, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subscriptionDetail.orderId;
        }
        if ((i2 & 2) != 0) {
            str2 = subscriptionDetail.orderToken;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = subscriptionDetail.productSku;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = subscriptionDetail.encodedOrderTimestamp;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = subscriptionDetail.encodedRecentQueryTimestamp;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            i = subscriptionDetail.staticId;
        }
        return subscriptionDetail.copy(str, str6, str7, str8, str9, i);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.orderToken;
    }

    public final String component3() {
        return this.productSku;
    }

    public final String component4() {
        return this.encodedOrderTimestamp;
    }

    public final String component5() {
        return this.encodedRecentQueryTimestamp;
    }

    public final int component6() {
        return this.staticId;
    }

    public final SubscriptionDetail copy(String str, String str2, String str3, String str4, String str5, int i) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "orderToken");
        Intrinsics.checkNotNullParameter(str3, "productSku");
        Intrinsics.checkNotNullParameter(str4, "encodedOrderTimestamp");
        Intrinsics.checkNotNullParameter(str5, "encodedRecentQueryTimestamp");
        return new SubscriptionDetail(str, str2, str3, str4, str5, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionDetail)) {
            return false;
        }
        SubscriptionDetail subscriptionDetail = (SubscriptionDetail) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) subscriptionDetail.orderId) && Intrinsics.areEqual((Object) this.orderToken, (Object) subscriptionDetail.orderToken) && Intrinsics.areEqual((Object) this.productSku, (Object) subscriptionDetail.productSku) && Intrinsics.areEqual((Object) this.encodedOrderTimestamp, (Object) subscriptionDetail.encodedOrderTimestamp) && Intrinsics.areEqual((Object) this.encodedRecentQueryTimestamp, (Object) subscriptionDetail.encodedRecentQueryTimestamp) && this.staticId == subscriptionDetail.staticId;
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderToken;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.productSku;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.encodedOrderTimestamp;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.encodedRecentQueryTimestamp;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((hashCode4 + i) * 31) + this.staticId;
    }

    public String toString() {
        return "SubscriptionDetail(orderId=" + this.orderId + ", orderToken=" + this.orderToken + ", productSku=" + this.productSku + ", encodedOrderTimestamp=" + this.encodedOrderTimestamp + ", encodedRecentQueryTimestamp=" + this.encodedRecentQueryTimestamp + ", staticId=" + this.staticId + ")";
    }

    public SubscriptionDetail(String str, String str2, String str3, String str4, String str5, int i) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "orderToken");
        Intrinsics.checkNotNullParameter(str3, "productSku");
        Intrinsics.checkNotNullParameter(str4, "encodedOrderTimestamp");
        Intrinsics.checkNotNullParameter(str5, "encodedRecentQueryTimestamp");
        this.orderId = str;
        this.orderToken = str2;
        this.productSku = str3;
        this.encodedOrderTimestamp = str4;
        this.encodedRecentQueryTimestamp = str5;
        this.staticId = i;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getOrderToken() {
        return this.orderToken;
    }

    public final String getProductSku() {
        return this.productSku;
    }

    public final String getEncodedOrderTimestamp() {
        return this.encodedOrderTimestamp;
    }

    public final String getEncodedRecentQueryTimestamp() {
        return this.encodedRecentQueryTimestamp;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionDetail(String str, String str2, String str3, String str4, String str5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i2 & 16) != 0 ? SimpleTimestampObfuscator.INSTANCE.encode(System.currentTimeMillis()) : str5, (i2 & 32) != 0 ? ROW_ID : i);
    }

    public final int getStaticId() {
        return this.staticId;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/data/storage/subscription/SubscriptionDetail$Companion;", "", "()V", "QUERY_BUFFER_MILLIS", "", "ROW_ID", "", "fromPurchase", "Lcom/memes/plus/data/storage/subscription/SubscriptionDetail;", "purchase", "Lcom/android/billingclient/api/Purchase;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: SubscriptionDetail.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionDetail fromPurchase(Purchase purchase) {
            Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
            String orderId = purchase.getOrderId();
            Intrinsics.checkNotNullExpressionValue(orderId, "purchase.orderId");
            String purchaseToken = purchase.getPurchaseToken();
            Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
            String sku = purchase.getSku();
            Intrinsics.checkNotNullExpressionValue(sku, "purchase.sku");
            return new SubscriptionDetail(orderId, purchaseToken, sku, SimpleTimestampObfuscator.INSTANCE.encode(purchase.getPurchaseTime()), (String) null, 0, 48, (DefaultConstructorMarker) null);
        }
    }

    public final long getOrderTimestamp() {
        return SimpleTimestampObfuscator.INSTANCE.decode(this.encodedOrderTimestamp);
    }

    public final long getRecentQueryTimestamp() {
        return SimpleTimestampObfuscator.INSTANCE.decode(this.encodedRecentQueryTimestamp);
    }

    public final boolean isQueryableTimestampExpired() {
        return getRecentQueryTimestamp() <= System.currentTimeMillis() - QUERY_BUFFER_MILLIS;
    }

    public final SubscriptionDetail createNowAccessedCopy() {
        return copy$default(this, (String) null, (String) null, (String) null, (String) null, SimpleTimestampObfuscator.INSTANCE.encode(System.currentTimeMillis()), 0, 47, (Object) null);
    }
}
