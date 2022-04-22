package com.memes.plus.data.storage.subscription;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p008db.SupportSQLiteDatabase;
import androidx.sqlite.p008db.SupportSQLiteOpenHelper;
import java.util.HashMap;
import java.util.HashSet;

public final class SubscriptionDatabase_Impl extends SubscriptionDatabase {
    private volatile SubscriptionDetailDao _subscriptionDetailDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SubscriptionDetail` (`oid` TEXT NOT NULL, `otk` TEXT NOT NULL, `osk` TEXT NOT NULL, `ots` TEXT NOT NULL, `oqt` TEXT NOT NULL, `rowid` INTEGER NOT NULL, PRIMARY KEY(`rowid`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a585e5b36667f509b6be5982bc7d3265')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SubscriptionDetail`");
                if (SubscriptionDatabase_Impl.this.mCallbacks != null) {
                    int size = SubscriptionDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SubscriptionDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (SubscriptionDatabase_Impl.this.mCallbacks != null) {
                    int size = SubscriptionDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SubscriptionDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = SubscriptionDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                SubscriptionDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (SubscriptionDatabase_Impl.this.mCallbacks != null) {
                    int size = SubscriptionDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SubscriptionDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(6);
                hashMap.put("oid", new TableInfo.Column("oid", "TEXT", true, 0, (String) null, 1));
                hashMap.put("otk", new TableInfo.Column("otk", "TEXT", true, 0, (String) null, 1));
                hashMap.put("osk", new TableInfo.Column("osk", "TEXT", true, 0, (String) null, 1));
                hashMap.put("ots", new TableInfo.Column("ots", "TEXT", true, 0, (String) null, 1));
                hashMap.put("oqt", new TableInfo.Column("oqt", "TEXT", true, 0, (String) null, 1));
                hashMap.put("rowid", new TableInfo.Column("rowid", "INTEGER", true, 1, (String) null, 1));
                TableInfo tableInfo = new TableInfo("SubscriptionDetail", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "SubscriptionDetail");
                if (tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "SubscriptionDetail(com.memes.plus.data.storage.subscription.SubscriptionDetail).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "a585e5b36667f509b6be5982bc7d3265", "ecbd1d9aee731373d6b59847dfcaa63f")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "SubscriptionDetail");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `SubscriptionDetail`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public SubscriptionDetailDao getSubscriptionDetailDao() {
        SubscriptionDetailDao subscriptionDetailDao;
        if (this._subscriptionDetailDao != null) {
            return this._subscriptionDetailDao;
        }
        synchronized (this) {
            if (this._subscriptionDetailDao == null) {
                this._subscriptionDetailDao = new SubscriptionDetailDao_Impl(this);
            }
            subscriptionDetailDao = this._subscriptionDetailDao;
        }
        return subscriptionDetailDao;
    }
}
