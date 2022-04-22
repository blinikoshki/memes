package com.memes.plus.data.storage.subscription;

import android.content.Context;
import com.memes.plus.data.storage.subscription.SubscriptionDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/data/storage/subscription/SubscriptionDatabaseManager;", "", "()V", "database", "Lcom/memes/plus/data/storage/subscription/SubscriptionDatabase;", "db", "context", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SubscriptionDatabaseManager.kt */
public final class SubscriptionDatabaseManager {
    public static final SubscriptionDatabaseManager INSTANCE = new SubscriptionDatabaseManager();
    /* access modifiers changed from: private */
    public static SubscriptionDatabase database;

    private SubscriptionDatabaseManager() {
    }

    public static final /* synthetic */ SubscriptionDatabase access$getDatabase$p(SubscriptionDatabaseManager subscriptionDatabaseManager) {
        SubscriptionDatabase subscriptionDatabase = database;
        if (subscriptionDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        }
        return subscriptionDatabase;
    }

    /* renamed from: db */
    public final SubscriptionDatabase mo58605db(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (database == null) {
            SubscriptionDatabase.Companion companion = SubscriptionDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            database = companion.create(applicationContext);
        }
        SubscriptionDatabase subscriptionDatabase = database;
        if (subscriptionDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        }
        return subscriptionDatabase;
    }
}
