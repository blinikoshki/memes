package com.memes.chat.p035db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p008db.SupportSQLiteDatabase;
import androidx.sqlite.p008db.SupportSQLiteOpenHelper;
import com.memes.chat.p035db.mutedchannels.MutedChannelsDao;
import com.memes.chat.p035db.mutedchannels.MutedChannelsDao_Impl;
import com.memes.chat.p035db.mutedusers.MutedUsersDao;
import com.memes.chat.p035db.mutedusers.MutedUsersDao_Impl;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.memes.chat.db.ChatDatabase_Impl */
public final class ChatDatabase_Impl extends ChatDatabase {
    private volatile MutedChannelsDao _mutedChannelsDao;
    private volatile MutedUsersDao _mutedUsersDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(3) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `muted_users` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `image` TEXT NOT NULL, `mutedBy` TEXT NOT NULL, `mutedAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `muted_channels` (`cid` TEXT NOT NULL, `id` TEXT NOT NULL, `type` TEXT NOT NULL, `name` TEXT NOT NULL, `image` TEXT NOT NULL, `mutedBy` TEXT NOT NULL, `mutedAt` INTEGER NOT NULL, PRIMARY KEY(`cid`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a2c9e80c4592707fd100b3ee5dd2f564')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `muted_users`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `muted_channels`");
                if (ChatDatabase_Impl.this.mCallbacks != null) {
                    int size = ChatDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ChatDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (ChatDatabase_Impl.this.mCallbacks != null) {
                    int size = ChatDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ChatDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = ChatDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                ChatDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (ChatDatabase_Impl.this.mCallbacks != null) {
                    int size = ChatDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ChatDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(6);
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap.put("image", new TableInfo.Column("image", "TEXT", true, 0, (String) null, 1));
                hashMap.put("mutedBy", new TableInfo.Column("mutedBy", "TEXT", true, 0, (String) null, 1));
                hashMap.put("mutedAt", new TableInfo.Column("mutedAt", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("muted_users", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "muted_users");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "muted_users(com.memes.chat.db.mutedusers.MutedUserEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(7);
                hashMap2.put("cid", new TableInfo.Column("cid", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("type", new TableInfo.Column("type", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("image", new TableInfo.Column("image", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("mutedBy", new TableInfo.Column("mutedBy", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("mutedAt", new TableInfo.Column("mutedAt", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("muted_channels", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "muted_channels");
                if (tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "muted_channels(com.memes.chat.db.mutedchannels.MutedChannelEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
        }, "a2c9e80c4592707fd100b3ee5dd2f564", "206d74a9f6f8081c921a0968687c1fd7")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "muted_users", "muted_channels");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `muted_users`");
            writableDatabase.execSQL("DELETE FROM `muted_channels`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public MutedUsersDao getMutedUsersDao() {
        MutedUsersDao mutedUsersDao;
        if (this._mutedUsersDao != null) {
            return this._mutedUsersDao;
        }
        synchronized (this) {
            if (this._mutedUsersDao == null) {
                this._mutedUsersDao = new MutedUsersDao_Impl(this);
            }
            mutedUsersDao = this._mutedUsersDao;
        }
        return mutedUsersDao;
    }

    public MutedChannelsDao getMutedChannelsDao() {
        MutedChannelsDao mutedChannelsDao;
        if (this._mutedChannelsDao != null) {
            return this._mutedChannelsDao;
        }
        synchronized (this) {
            if (this._mutedChannelsDao == null) {
                this._mutedChannelsDao = new MutedChannelsDao_Impl(this);
            }
            mutedChannelsDao = this._mutedChannelsDao;
        }
        return mutedChannelsDao;
    }
}
