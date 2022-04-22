package com.memes.plus.data.storage.subscription;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/data/storage/subscription/SubscriptionDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getSubscriptionDetailDao", "Lcom/memes/plus/data/storage/subscription/SubscriptionDetailDao;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SubscriptionDatabase.kt */
public abstract class SubscriptionDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public abstract SubscriptionDetailDao getSubscriptionDetailDao();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/data/storage/subscription/SubscriptionDatabase$Companion;", "", "()V", "create", "Lcom/memes/plus/data/storage/subscription/SubscriptionDatabase;", "applicationContext", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: SubscriptionDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionDatabase create(Context context) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            SubscriptionDatabase build = Room.databaseBuilder(context, SubscriptionDatabase.class, "odb").fallbackToDestructiveMigration().build();
            Intrinsics.checkNotNullExpressionValue(build, "Room.databaseBuilder(\n\t\t…uctiveMigration().build()");
            return build;
        }
    }
}
