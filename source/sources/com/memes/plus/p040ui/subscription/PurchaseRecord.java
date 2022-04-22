package com.memes.plus.p040ui.subscription;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B«\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J´\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0006HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015¨\u0006="}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/PurchaseRecord;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "trialDays", "", "productId", "proUser", "", "userType", "price", "", "subscriptionDate", "subscriptionType", "subscriptionExpiryDate", "deviceToken", "realTrialDays", "realProUser", "realPrice", "realUserId", "legacyUserId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceToken", "()Ljava/lang/String;", "getLegacyUserId", "getPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getProUser", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProductId", "getRealPrice", "getRealProUser", "getRealTrialDays", "getRealUserId", "getSubscriptionDate", "getSubscriptionExpiryDate", "getSubscriptionType", "getTrialDays", "getUserType", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/memes/plus/ui/subscription/PurchaseRecord;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.PurchaseRecord */
/* compiled from: PurchaseRecord.kt */
public final class PurchaseRecord extends AuthenticatedContentRequest {
    @SerializedName("device_token")
    @Expose
    private final String deviceToken;
    @SerializedName("legacy_user_id")
    @Expose
    private final String legacyUserId;
    @SerializedName("price")
    @Expose
    private final Double price;
    @SerializedName("proUser")
    @Expose
    private final Integer proUser;
    @SerializedName("productId")
    @Expose
    private final String productId;
    @SerializedName("real_price")
    @Expose
    private final Double realPrice;
    @SerializedName("real_proUser")
    @Expose
    private final Integer realProUser;
    @SerializedName("real_trialDays")
    @Expose
    private final String realTrialDays;
    @SerializedName("real_user_id")
    @Expose
    private final String realUserId;
    @SerializedName("subscriptionDate")
    @Expose
    private final String subscriptionDate;
    @SerializedName("subscriptionExpiryDate")
    @Expose
    private final String subscriptionExpiryDate;
    @SerializedName("subscriptionType")
    @Expose
    private final String subscriptionType;
    @SerializedName("trialDays")
    @Expose
    private final String trialDays;
    @SerializedName("userType")
    @Expose
    private final String userType;

    public PurchaseRecord() {
        this((String) null, (String) null, (Integer) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Double) null, (String) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PurchaseRecord copy$default(PurchaseRecord purchaseRecord, String str, String str2, Integer num, String str3, Double d, String str4, String str5, String str6, String str7, String str8, Integer num2, Double d2, String str9, String str10, int i, Object obj) {
        PurchaseRecord purchaseRecord2 = purchaseRecord;
        int i2 = i;
        return purchaseRecord.copy((i2 & 1) != 0 ? purchaseRecord2.trialDays : str, (i2 & 2) != 0 ? purchaseRecord2.productId : str2, (i2 & 4) != 0 ? purchaseRecord2.proUser : num, (i2 & 8) != 0 ? purchaseRecord2.userType : str3, (i2 & 16) != 0 ? purchaseRecord2.price : d, (i2 & 32) != 0 ? purchaseRecord2.subscriptionDate : str4, (i2 & 64) != 0 ? purchaseRecord2.subscriptionType : str5, (i2 & 128) != 0 ? purchaseRecord2.subscriptionExpiryDate : str6, (i2 & 256) != 0 ? purchaseRecord2.deviceToken : str7, (i2 & 512) != 0 ? purchaseRecord2.realTrialDays : str8, (i2 & 1024) != 0 ? purchaseRecord2.realProUser : num2, (i2 & 2048) != 0 ? purchaseRecord2.realPrice : d2, (i2 & 4096) != 0 ? purchaseRecord2.realUserId : str9, (i2 & 8192) != 0 ? purchaseRecord2.legacyUserId : str10);
    }

    public final String component1() {
        return this.trialDays;
    }

    public final String component10() {
        return this.realTrialDays;
    }

    public final Integer component11() {
        return this.realProUser;
    }

    public final Double component12() {
        return this.realPrice;
    }

    public final String component13() {
        return this.realUserId;
    }

    public final String component14() {
        return this.legacyUserId;
    }

    public final String component2() {
        return this.productId;
    }

    public final Integer component3() {
        return this.proUser;
    }

    public final String component4() {
        return this.userType;
    }

    public final Double component5() {
        return this.price;
    }

    public final String component6() {
        return this.subscriptionDate;
    }

    public final String component7() {
        return this.subscriptionType;
    }

    public final String component8() {
        return this.subscriptionExpiryDate;
    }

    public final String component9() {
        return this.deviceToken;
    }

    public final PurchaseRecord copy(String str, String str2, Integer num, String str3, Double d, String str4, String str5, String str6, String str7, String str8, Integer num2, Double d2, String str9, String str10) {
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "subscriptionExpiryDate");
        return new PurchaseRecord(str, str2, num, str3, d, str4, str5, str11, str7, str8, num2, d2, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseRecord)) {
            return false;
        }
        PurchaseRecord purchaseRecord = (PurchaseRecord) obj;
        return Intrinsics.areEqual((Object) this.trialDays, (Object) purchaseRecord.trialDays) && Intrinsics.areEqual((Object) this.productId, (Object) purchaseRecord.productId) && Intrinsics.areEqual((Object) this.proUser, (Object) purchaseRecord.proUser) && Intrinsics.areEqual((Object) this.userType, (Object) purchaseRecord.userType) && Intrinsics.areEqual((Object) this.price, (Object) purchaseRecord.price) && Intrinsics.areEqual((Object) this.subscriptionDate, (Object) purchaseRecord.subscriptionDate) && Intrinsics.areEqual((Object) this.subscriptionType, (Object) purchaseRecord.subscriptionType) && Intrinsics.areEqual((Object) this.subscriptionExpiryDate, (Object) purchaseRecord.subscriptionExpiryDate) && Intrinsics.areEqual((Object) this.deviceToken, (Object) purchaseRecord.deviceToken) && Intrinsics.areEqual((Object) this.realTrialDays, (Object) purchaseRecord.realTrialDays) && Intrinsics.areEqual((Object) this.realProUser, (Object) purchaseRecord.realProUser) && Intrinsics.areEqual((Object) this.realPrice, (Object) purchaseRecord.realPrice) && Intrinsics.areEqual((Object) this.realUserId, (Object) purchaseRecord.realUserId) && Intrinsics.areEqual((Object) this.legacyUserId, (Object) purchaseRecord.legacyUserId);
    }

    public int hashCode() {
        String str = this.trialDays;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.productId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.proUser;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.userType;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d = this.price;
        int hashCode5 = (hashCode4 + (d != null ? d.hashCode() : 0)) * 31;
        String str4 = this.subscriptionDate;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.subscriptionType;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.subscriptionExpiryDate;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.deviceToken;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.realTrialDays;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num2 = this.realProUser;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Double d2 = this.realPrice;
        int hashCode12 = (hashCode11 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str9 = this.realUserId;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.legacyUserId;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return hashCode13 + i;
    }

    public String toString() {
        return "PurchaseRecord(trialDays=" + this.trialDays + ", productId=" + this.productId + ", proUser=" + this.proUser + ", userType=" + this.userType + ", price=" + this.price + ", subscriptionDate=" + this.subscriptionDate + ", subscriptionType=" + this.subscriptionType + ", subscriptionExpiryDate=" + this.subscriptionExpiryDate + ", deviceToken=" + this.deviceToken + ", realTrialDays=" + this.realTrialDays + ", realProUser=" + this.realProUser + ", realPrice=" + this.realPrice + ", realUserId=" + this.realUserId + ", legacyUserId=" + this.legacyUserId + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PurchaseRecord(java.lang.String r16, java.lang.String r17, java.lang.Integer r18, java.lang.String r19, java.lang.Double r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.Integer r26, java.lang.Double r27, java.lang.String r28, java.lang.String r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000d
        L_0x000b:
            r1 = r16
        L_0x000d:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0015
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0017
        L_0x0015:
            r3 = r17
        L_0x0017:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001f
            r4 = r2
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x0021
        L_0x001f:
            r4 = r18
        L_0x0021:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0029
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x002b
        L_0x0029:
            r5 = r19
        L_0x002b:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0033
            r6 = r2
            java.lang.Double r6 = (java.lang.Double) r6
            goto L_0x0035
        L_0x0033:
            r6 = r20
        L_0x0035:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003d
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x003f
        L_0x003d:
            r7 = r21
        L_0x003f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0047
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0049
        L_0x0047:
            r8 = r22
        L_0x0049:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0050
            java.lang.String r9 = ""
            goto L_0x0052
        L_0x0050:
            r9 = r23
        L_0x0052:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x005a
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x005c
        L_0x005a:
            r10 = r24
        L_0x005c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0064
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0066
        L_0x0064:
            r11 = r25
        L_0x0066:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x006e
            r12 = r2
            java.lang.Integer r12 = (java.lang.Integer) r12
            goto L_0x0070
        L_0x006e:
            r12 = r26
        L_0x0070:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0078
            r13 = r2
            java.lang.Double r13 = (java.lang.Double) r13
            goto L_0x007a
        L_0x0078:
            r13 = r27
        L_0x007a:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0082
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x0084
        L_0x0082:
            r14 = r28
        L_0x0084:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x008c
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x008e
        L_0x008c:
            r0 = r29
        L_0x008e:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.subscription.PurchaseRecord.<init>(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Double, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTrialDays() {
        return this.trialDays;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Integer getProUser() {
        return this.proUser;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final String getSubscriptionDate() {
        return this.subscriptionDate;
    }

    public final String getSubscriptionType() {
        return this.subscriptionType;
    }

    public final String getSubscriptionExpiryDate() {
        return this.subscriptionExpiryDate;
    }

    public final String getDeviceToken() {
        return this.deviceToken;
    }

    public final String getRealTrialDays() {
        return this.realTrialDays;
    }

    public final Integer getRealProUser() {
        return this.realProUser;
    }

    public final Double getRealPrice() {
        return this.realPrice;
    }

    public final String getRealUserId() {
        return this.realUserId;
    }

    public final String getLegacyUserId() {
        return this.legacyUserId;
    }

    public PurchaseRecord(String str, String str2, Integer num, String str3, Double d, String str4, String str5, String str6, String str7, String str8, Integer num2, Double d2, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str6, "subscriptionExpiryDate");
        this.trialDays = str;
        this.productId = str2;
        this.proUser = num;
        this.userType = str3;
        this.price = d;
        this.subscriptionDate = str4;
        this.subscriptionType = str5;
        this.subscriptionExpiryDate = str6;
        this.deviceToken = str7;
        this.realTrialDays = str8;
        this.realProUser = num2;
        this.realPrice = d2;
        this.realUserId = str9;
        this.legacyUserId = str10;
    }
}
