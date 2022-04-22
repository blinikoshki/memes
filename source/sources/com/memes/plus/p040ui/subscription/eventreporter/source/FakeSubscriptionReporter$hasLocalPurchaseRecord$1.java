package com.memes.plus.p040ui.subscription.eventreporter.source;

import com.memes.plus.p040ui.subscription.eventreporter.LocalPurchaseRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.eventreporter.source.FakeSubscriptionReporter$hasLocalPurchaseRecord$1 */
/* compiled from: FakeSubscriptionReporter.kt */
final /* synthetic */ class FakeSubscriptionReporter$hasLocalPurchaseRecord$1 extends MutablePropertyReference0Impl {
    FakeSubscriptionReporter$hasLocalPurchaseRecord$1(FakeSubscriptionReporter fakeSubscriptionReporter) {
        super(fakeSubscriptionReporter, FakeSubscriptionReporter.class, "localPurchaseRecord", "getLocalPurchaseRecord()Lcom/memes/plus/ui/subscription/eventreporter/LocalPurchaseRecord;", 0);
    }

    public Object get() {
        return FakeSubscriptionReporter.access$getLocalPurchaseRecord$p((FakeSubscriptionReporter) this.receiver);
    }

    public void set(Object obj) {
        ((FakeSubscriptionReporter) this.receiver).localPurchaseRecord = (LocalPurchaseRecord) obj;
    }
}
