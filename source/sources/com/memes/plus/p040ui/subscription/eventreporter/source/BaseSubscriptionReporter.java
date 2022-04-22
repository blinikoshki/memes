package com.memes.plus.p040ui.subscription.eventreporter.source;

import com.memes.plus.App;
import com.memes.plus.p040ui.subscription.eventreporter.LocalPurchaseRecord;
import com.memes.plus.p040ui.subscription.eventreporter.MemesPurchase;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH$J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH$J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH$J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH$J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000bJ\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\bH&R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/eventreporter/source/BaseSubscriptionReporter;", "", "()V", "lastOldPurchaseReportedAt", "", "oldPurchaseReportingFrequencyMillis", "currentTimeMillis", "getLocalPurchaseRecord", "Lcom/memes/plus/ui/subscription/eventreporter/LocalPurchaseRecord;", "getProductTimeMillis", "purchase", "Lcom/memes/plus/ui/subscription/eventreporter/MemesPurchase;", "getSubscriptionGraceMillis", "productSku", "", "getSubscriptionMillis", "getTrialGraceMillis", "getTrialMillis", "getTrialTimeMillis", "hasLocalPurchaseRecord", "", "notifyPossibleUnreportedSubscription", "", "purchaseRecord", "notifySubscription", "notifySubscriptionTrial", "registerNewProductPurchase", "newPurchase", "registerOldProductPurchase", "oldPurchase", "reportCurrentPurchaseIsActiveTrial", "reportInvalidDeviceTime", "saveLocalPurchaseRecord", "localPurchaseRecord", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.eventreporter.source.BaseSubscriptionReporter */
/* compiled from: BaseSubscriptionReporter.kt */
public abstract class BaseSubscriptionReporter {
    private long lastOldPurchaseReportedAt;
    private final long oldPurchaseReportingFrequencyMillis = 8000;

    public abstract LocalPurchaseRecord getLocalPurchaseRecord();

    /* access modifiers changed from: protected */
    public abstract long getSubscriptionGraceMillis(String str);

    /* access modifiers changed from: protected */
    public abstract long getSubscriptionMillis(String str);

    /* access modifiers changed from: protected */
    public abstract long getTrialGraceMillis(String str);

    /* access modifiers changed from: protected */
    public abstract long getTrialMillis(String str);

    public abstract boolean hasLocalPurchaseRecord();

    public abstract void saveLocalPurchaseRecord(LocalPurchaseRecord localPurchaseRecord);

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    private final long getTrialTimeMillis(MemesPurchase memesPurchase) {
        long trialMillis = getTrialMillis(memesPurchase.getProductSku());
        long trialGraceMillis = getTrialGraceMillis(memesPurchase.getProductSku());
        if (memesPurchase.isAutoRenewing()) {
            return trialMillis;
        }
        Timber.m300d("* Using " + trialGraceMillis + " grace-millis for trial-period", new Object[0]);
        return trialMillis + trialGraceMillis;
    }

    private final long getProductTimeMillis(MemesPurchase memesPurchase) {
        long subscriptionMillis = getSubscriptionMillis(memesPurchase.getProductSku());
        long subscriptionGraceMillis = getSubscriptionGraceMillis(memesPurchase.getProductSku());
        if (memesPurchase.isAutoRenewing()) {
            return subscriptionMillis;
        }
        Timber.m300d("* Using " + subscriptionGraceMillis + " grace-millis for cancelled trial-period or subscription", new Object[0]);
        return subscriptionMillis + subscriptionGraceMillis;
    }

    public final void registerNewProductPurchase(MemesPurchase memesPurchase) {
        Intrinsics.checkNotNullParameter(memesPurchase, "newPurchase");
        if (hasLocalPurchaseRecord()) {
            notifyPossibleUnreportedSubscription(getLocalPurchaseRecord(), memesPurchase);
            return;
        }
        saveLocalPurchaseRecord(new LocalPurchaseRecord(memesPurchase.getOrderId(), memesPurchase.getProductSku(), memesPurchase.getPurchaseTime(), (HashMap) null, 8, (DefaultConstructorMarker) null));
        notifySubscriptionTrial(memesPurchase);
    }

    public final void registerOldProductPurchase(MemesPurchase memesPurchase) {
        Intrinsics.checkNotNullParameter(memesPurchase, "oldPurchase");
        if (currentTimeMillis() - this.lastOldPurchaseReportedAt < this.oldPurchaseReportingFrequencyMillis) {
            Timber.m303e("old-purchase-reported-too-fast; returning", new Object[0]);
            return;
        }
        this.lastOldPurchaseReportedAt = currentTimeMillis();
        long currentTimeMillis = currentTimeMillis() - memesPurchase.getPurchaseTime();
        if (currentTimeMillis <= 0) {
            reportInvalidDeviceTime(memesPurchase);
        } else if (currentTimeMillis - getTrialTimeMillis(memesPurchase) <= 0) {
            if (hasLocalPurchaseRecord()) {
                LocalPurchaseRecord localPurchaseRecord = getLocalPurchaseRecord();
                if (Intrinsics.areEqual((Object) localPurchaseRecord.getOrderId(), (Object) memesPurchase.getOrderId())) {
                    reportCurrentPurchaseIsActiveTrial(memesPurchase);
                } else {
                    notifyPossibleUnreportedSubscription(localPurchaseRecord, memesPurchase);
                }
            } else {
                saveLocalPurchaseRecord(new LocalPurchaseRecord(memesPurchase.getOrderId(), memesPurchase.getProductSku(), memesPurchase.getPurchaseTime(), (HashMap) null, 8, (DefaultConstructorMarker) null));
            }
        } else if (hasLocalPurchaseRecord()) {
            notifyPossibleUnreportedSubscription(getLocalPurchaseRecord(), memesPurchase);
        } else {
            LocalPurchaseRecord localPurchaseRecord2 = new LocalPurchaseRecord(memesPurchase.getOrderId(), memesPurchase.getProductSku(), memesPurchase.getPurchaseTime(), (HashMap) null, 8, (DefaultConstructorMarker) null);
            localPurchaseRecord2.addReportedOrder(memesPurchase.getOrderId(), currentTimeMillis());
            saveLocalPurchaseRecord(localPurchaseRecord2);
        }
    }

    private final void reportInvalidDeviceTime(MemesPurchase memesPurchase) {
        Timber.m303e("reportInvalidDeviceTime(" + memesPurchase.getOrderId() + ')', new Object[0]);
    }

    private final void reportCurrentPurchaseIsActiveTrial(MemesPurchase memesPurchase) {
        Timber.m303e("trial-period is active for " + memesPurchase.getOrderId(), new Object[0]);
    }

    private final void notifySubscriptionTrial(MemesPurchase memesPurchase) {
        Timber.m300d("notify-subscription-trial: " + memesPurchase.getOrderId(), new Object[0]);
        App.Companion.trackingManager().onSubscriptionTrialStarted(memesPurchase.getOrderId(), memesPurchase.priceValueStr(), memesPurchase.getPriceCurrency());
    }

    private final void notifyPossibleUnreportedSubscription(LocalPurchaseRecord localPurchaseRecord, MemesPurchase memesPurchase) {
        if (localPurchaseRecord.getReportedOrders().containsKey(memesPurchase.getOrderId())) {
            Long l = localPurchaseRecord.getReportedOrders().get(memesPurchase.getOrderId());
            if (l == null) {
                l = Long.valueOf(currentTimeMillis());
            }
            Intrinsics.checkNotNullExpressionValue(l, "purchaseRecord.reportedO…d] ?: currentTimeMillis()");
            long longValue = l.longValue();
            long productTimeMillis = getProductTimeMillis(memesPurchase);
            int currentTimeMillis = (int) ((currentTimeMillis() - longValue) / productTimeMillis);
            if (currentTimeMillis == 0) {
                Timber.m303e("already reported subscription; " + memesPurchase.getOrderId(), new Object[0]);
                return;
            }
            Timber.m300d("* reporting " + currentTimeMillis + " renewal(s) for " + memesPurchase.getOrderId(), new Object[0]);
            int i = 0;
            while (i < currentTimeMillis) {
                i++;
                localPurchaseRecord.addReportedOrder(memesPurchase.getOrderId(), (((long) i) * productTimeMillis) + longValue);
                notifySubscription(memesPurchase);
            }
            saveLocalPurchaseRecord(localPurchaseRecord);
            Timber.m300d("--> saved purchase-record=" + localPurchaseRecord, new Object[0]);
            return;
        }
        localPurchaseRecord.addReportedOrder(memesPurchase.getOrderId(), currentTimeMillis());
        saveLocalPurchaseRecord(localPurchaseRecord);
        notifySubscription(memesPurchase);
    }

    private final void notifySubscription(MemesPurchase memesPurchase) {
        Timber.m300d("notify-subscription: " + memesPurchase.getOrderId(), new Object[0]);
        App.Companion.trackingManager().onSubscriptionStarted(memesPurchase.getOrderId(), memesPurchase.priceValueStr(), memesPurchase.getPriceCurrency());
    }
}
