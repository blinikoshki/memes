package com.memes.plus.p040ui.subscription.eventreporter;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006`\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J%\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006`\tHÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006`\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/eventreporter/LocalPurchaseRecord;", "", "orderId", "", "productSku", "purchaseTime", "", "reportedOrders", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/HashMap;)V", "getOrderId", "()Ljava/lang/String;", "getProductSku", "getPurchaseTime", "()J", "getReportedOrders", "()Ljava/util/HashMap;", "addReportedOrder", "", "reportedAtMillis", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.eventreporter.LocalPurchaseRecord */
/* compiled from: LocalPurchaseRecord.kt */
public final class LocalPurchaseRecord {
    private final String orderId;
    private final String productSku;
    private final long purchaseTime;
    private final HashMap<String, Long> reportedOrders;

    public static /* synthetic */ LocalPurchaseRecord copy$default(LocalPurchaseRecord localPurchaseRecord, String str, String str2, long j, HashMap<String, Long> hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localPurchaseRecord.orderId;
        }
        if ((i & 2) != 0) {
            str2 = localPurchaseRecord.productSku;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = localPurchaseRecord.purchaseTime;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            hashMap = localPurchaseRecord.reportedOrders;
        }
        return localPurchaseRecord.copy(str, str3, j2, hashMap);
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

    public final HashMap<String, Long> component4() {
        return this.reportedOrders;
    }

    public final LocalPurchaseRecord copy(String str, String str2, long j, HashMap<String, Long> hashMap) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "productSku");
        Intrinsics.checkNotNullParameter(hashMap, "reportedOrders");
        return new LocalPurchaseRecord(str, str2, j, hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalPurchaseRecord)) {
            return false;
        }
        LocalPurchaseRecord localPurchaseRecord = (LocalPurchaseRecord) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) localPurchaseRecord.orderId) && Intrinsics.areEqual((Object) this.productSku, (Object) localPurchaseRecord.productSku) && this.purchaseTime == localPurchaseRecord.purchaseTime && Intrinsics.areEqual((Object) this.reportedOrders, (Object) localPurchaseRecord.reportedOrders);
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.productSku;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.purchaseTime)) * 31;
        HashMap<String, Long> hashMap = this.reportedOrders;
        if (hashMap != null) {
            i = hashMap.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "LocalPurchaseRecord(orderId=" + this.orderId + ", productSku=" + this.productSku + ", purchaseTime=" + this.purchaseTime + ", reportedOrders=" + this.reportedOrders + ")";
    }

    public LocalPurchaseRecord(String str, String str2, long j, HashMap<String, Long> hashMap) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "productSku");
        Intrinsics.checkNotNullParameter(hashMap, "reportedOrders");
        this.orderId = str;
        this.productSku = str2;
        this.purchaseTime = j;
        this.reportedOrders = hashMap;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalPurchaseRecord(String str, String str2, long j, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, (i & 8) != 0 ? new HashMap() : hashMap);
    }

    public final HashMap<String, Long> getReportedOrders() {
        return this.reportedOrders;
    }

    public final void addReportedOrder(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.reportedOrders.put(str, Long.valueOf(j));
    }
}
