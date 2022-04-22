package editor.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p008db.SupportSQLiteDatabase;
import androidx.sqlite.p008db.SupportSQLiteOpenHelper;
import com.appsflyer.ServerParameters;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import editor.database.dao.EditorDraftsDao;
import editor.database.dao.EditorDraftsDao_Impl;
import editor.database.dao.RecentFontsDao;
import editor.database.dao.RecentFontsDao_Impl;
import editor.database.dao.SavedWatermarksDao;
import editor.database.dao.SavedWatermarksDao_Impl;
import java.util.HashMap;
import java.util.HashSet;

public final class EditorDatabase_Impl extends EditorDatabase {
    private volatile EditorDraftsDao _editorDraftsDao;
    private volatile RecentFontsDao _recentFontsDao;
    private volatile SavedWatermarksDao _savedWatermarksDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(6) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `text_watermark` (`text_style` TEXT NOT NULL, `uid` TEXT NOT NULL, `thumbnail` TEXT, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`uid`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `photo_watermark` (`source` INTEGER NOT NULL, `media_style` TEXT NOT NULL, `uid` TEXT NOT NULL, `thumbnail` TEXT, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`uid`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `drafts` (`uid` TEXT NOT NULL, `thumbnail` TEXT, `frame_width` INTEGER NOT NULL, `frame_height` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `text_styles` TEXT, `media_styles` TEXT, `frame_style` TEXT, PRIMARY KEY(`uid`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `text_fonts` (`id` TEXT NOT NULL, `display_name` TEXT NOT NULL, `type` TEXT NOT NULL, `file_name` TEXT NOT NULL, `premium` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8293cacc4ab6212c010a3733c2ce7303')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `text_watermark`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `photo_watermark`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `drafts`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `text_fonts`");
                if (EditorDatabase_Impl.this.mCallbacks != null) {
                    int size = EditorDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) EditorDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (EditorDatabase_Impl.this.mCallbacks != null) {
                    int size = EditorDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) EditorDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = EditorDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                EditorDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (EditorDatabase_Impl.this.mCallbacks != null) {
                    int size = EditorDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) EditorDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(4);
                hashMap.put(ViewHierarchyConstants.TEXT_STYLE, new TableInfo.Column(ViewHierarchyConstants.TEXT_STYLE, "TEXT", true, 0, (String) null, 1));
                hashMap.put(ServerParameters.AF_USER_ID, new TableInfo.Column(ServerParameters.AF_USER_ID, "TEXT", true, 1, (String) null, 1));
                hashMap.put("thumbnail", new TableInfo.Column("thumbnail", "TEXT", false, 0, (String) null, 1));
                hashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("text_watermark", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "text_watermark");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "text_watermark(editor.optionsui.watermark.TextWatermark).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(5);
                hashMap2.put("source", new TableInfo.Column("source", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("media_style", new TableInfo.Column("media_style", "TEXT", true, 0, (String) null, 1));
                hashMap2.put(ServerParameters.AF_USER_ID, new TableInfo.Column(ServerParameters.AF_USER_ID, "TEXT", true, 1, (String) null, 1));
                hashMap2.put("thumbnail", new TableInfo.Column("thumbnail", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("photo_watermark", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "photo_watermark");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "photo_watermark(editor.optionsui.watermark.PhotoWatermark).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(8);
                hashMap3.put(ServerParameters.AF_USER_ID, new TableInfo.Column(ServerParameters.AF_USER_ID, "TEXT", true, 1, (String) null, 1));
                hashMap3.put("thumbnail", new TableInfo.Column("thumbnail", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("frame_width", new TableInfo.Column("frame_width", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("frame_height", new TableInfo.Column("frame_height", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("text_styles", new TableInfo.Column("text_styles", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("media_styles", new TableInfo.Column("media_styles", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("frame_style", new TableInfo.Column("frame_style", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("drafts", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "drafts");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "drafts(editor.editor.dashboard.drafts.EditorDraft).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(5);
                hashMap4.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("display_name", new TableInfo.Column("display_name", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("type", new TableInfo.Column("type", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("file_name", new TableInfo.Column("file_name", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("premium", new TableInfo.Column("premium", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo4 = new TableInfo("text_fonts", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "text_fonts");
                if (tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "text_fonts(editor.optionsui.text.textfont.TextFont).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
        }, "8293cacc4ab6212c010a3733c2ce7303", "8cdf39ef84ae93dfd9ac6f69fec4dedd")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "text_watermark", "photo_watermark", "drafts", "text_fonts");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `text_watermark`");
            writableDatabase.execSQL("DELETE FROM `photo_watermark`");
            writableDatabase.execSQL("DELETE FROM `drafts`");
            writableDatabase.execSQL("DELETE FROM `text_fonts`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public SavedWatermarksDao getSavedWatermarksDao() {
        SavedWatermarksDao savedWatermarksDao;
        if (this._savedWatermarksDao != null) {
            return this._savedWatermarksDao;
        }
        synchronized (this) {
            if (this._savedWatermarksDao == null) {
                this._savedWatermarksDao = new SavedWatermarksDao_Impl(this);
            }
            savedWatermarksDao = this._savedWatermarksDao;
        }
        return savedWatermarksDao;
    }

    public EditorDraftsDao getEditorDraftsDao() {
        EditorDraftsDao editorDraftsDao;
        if (this._editorDraftsDao != null) {
            return this._editorDraftsDao;
        }
        synchronized (this) {
            if (this._editorDraftsDao == null) {
                this._editorDraftsDao = new EditorDraftsDao_Impl(this);
            }
            editorDraftsDao = this._editorDraftsDao;
        }
        return editorDraftsDao;
    }

    public RecentFontsDao getRecentFontsDao() {
        RecentFontsDao recentFontsDao;
        if (this._recentFontsDao != null) {
            return this._recentFontsDao;
        }
        synchronized (this) {
            if (this._recentFontsDao == null) {
                this._recentFontsDao = new RecentFontsDao_Impl(this);
            }
            recentFontsDao = this._recentFontsDao;
        }
        return recentFontsDao;
    }
}
