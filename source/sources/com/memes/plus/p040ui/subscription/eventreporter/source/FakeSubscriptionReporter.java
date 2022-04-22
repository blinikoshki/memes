package com.memes.plus.p040ui.subscription.eventreporter.source;

import com.memes.plus.p040ui.subscription.eventreporter.LocalPurchaseRecord;
import com.memes.plus.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.time.DateUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/eventreporter/source/FakeSubscriptionReporter;", "Lcom/memes/plus/ui/subscription/eventreporter/source/BaseSubscriptionReporter;", "()V", "currentTimeMillis", "", "localPurchaseRecord", "Lcom/memes/plus/ui/subscription/eventreporter/LocalPurchaseRecord;", "perDayMillis", "getLocalPurchaseRecord", "getSubscriptionGraceMillis", "productSku", "", "getSubscriptionMillis", "getTrialGraceMillis", "getTrialMillis", "hasLocalPurchaseRecord", "", "saveLocalPurchaseRecord", "", "setCurrentTimeMillis", "millis", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.eventreporter.source.FakeSubscriptionReporter */
/* compiled from: FakeSubscriptionReporter.kt */
public final class FakeSubscriptionReporter extends BaseSubscriptionReporter {
    private long currentTimeMillis = System.currentTimeMillis();
    /* access modifiers changed from: private */
    public LocalPurchaseRecord localPurchaseRecord;
    private final long perDayMillis = DateUtils.MILLIS_PER_DAY;

    public static final /* synthetic */ LocalPurchaseRecord access$getLocalPurchaseRecord$p(FakeSubscriptionReporter fakeSubscriptionReporter) {
        LocalPurchaseRecord localPurchaseRecord2 = fakeSubscriptionReporter.localPurchaseRecord;
        if (localPurchaseRecord2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localPurchaseRecord");
        }
        return localPurchaseRecord2;
    }

    /* access modifiers changed from: protected */
    public long getTrialMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        int hashCode = str.hashCode();
        if (hashCode == -2009567370) {
            boolean equals = str.equals(Constants.ANNUAL_SKU);
        } else if (hashCode == 709777759) {
            boolean equals2 = str.equals(Constants.MONTHLY_SKU);
        }
        return ((long) 30) * this.perDayMillis;
    }

    /* access modifiers changed from: protected */
    public long getTrialGraceMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        int hashCode = str.hashCode();
        int i = 4;
        if (hashCode != -2009567370) {
            if (hashCode == 709777759) {
                boolean equals = str.equals(Constants.MONTHLY_SKU);
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            i = 8;
        }
        return ((long) i) * this.perDayMillis;
    }

    /* access modifiers changed from: protected */
    public long getSubscriptionMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        int hashCode = str.hashCode();
        int i = 30;
        if (hashCode != -2009567370) {
            if (hashCode == 709777759) {
                boolean equals = str.equals(Constants.MONTHLY_SKU);
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            i = 365;
        }
        return ((long) i) * this.perDayMillis;
    }

    /* access modifiers changed from: protected */
    public long getSubscriptionGraceMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        int hashCode = str.hashCode();
        int i = 4;
        if (hashCode != -2009567370) {
            if (hashCode == 709777759) {
                boolean equals = str.equals(Constants.MONTHLY_SKU);
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            i = 8;
        }
        return ((long) i) * this.perDayMillis;
    }

    public LocalPurchaseRecord getLocalPurchaseRecord() {
        LocalPurchaseRecord localPurchaseRecord2 = this.localPurchaseRecord;
        if (localPurchaseRecord2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localPurchaseRecord");
        }
        return localPurchaseRecord2;
    }

    public void saveLocalPurchaseRecord(LocalPurchaseRecord localPurchaseRecord2) {
        Intrinsics.checkNotNullParameter(localPurchaseRecord2, "localPurchaseRecord");
        this.localPurchaseRecord = localPurchaseRecord2;
    }

    public boolean hasLocalPurchaseRecord() {
        return this.localPurchaseRecord != null;
    }

    public long currentTimeMillis() {
        return this.currentTimeMillis;
    }

    public final void setCurrentTimeMillis(long j) {
        this.currentTimeMillis = j;
    }
}
