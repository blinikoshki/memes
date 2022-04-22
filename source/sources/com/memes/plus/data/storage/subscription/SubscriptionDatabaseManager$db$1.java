package com.memes.plus.data.storage.subscription;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: SubscriptionDatabaseManager.kt */
final /* synthetic */ class SubscriptionDatabaseManager$db$1 extends MutablePropertyReference0Impl {
    SubscriptionDatabaseManager$db$1(SubscriptionDatabaseManager subscriptionDatabaseManager) {
        super(subscriptionDatabaseManager, SubscriptionDatabaseManager.class, "database", "getDatabase()Lcom/memes/plus/data/storage/subscription/SubscriptionDatabase;", 0);
    }

    public Object get() {
        return SubscriptionDatabaseManager.access$getDatabase$p((SubscriptionDatabaseManager) this.receiver);
    }

    public void set(Object obj) {
        SubscriptionDatabaseManager.database = (SubscriptionDatabase) obj;
    }
}
