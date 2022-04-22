package editor.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import com.appsflyer.ServerParameters;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import editor.database.converters.MediaStyleConverter;
import editor.database.converters.PhotoWatermarkSourceConverter;
import editor.database.converters.TextStyleConverter;
import editor.optionsui.watermark.PhotoWatermark;
import editor.optionsui.watermark.TextWatermark;
import java.util.ArrayList;
import java.util.List;

public final class SavedWatermarksDao_Impl implements SavedWatermarksDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PhotoWatermark> __insertionAdapterOfPhotoWatermark;
    private final EntityInsertionAdapter<TextWatermark> __insertionAdapterOfTextWatermark;
    /* access modifiers changed from: private */
    public final MediaStyleConverter __mediaStyleConverter = new MediaStyleConverter();
    /* access modifiers changed from: private */
    public final PhotoWatermarkSourceConverter __photoWatermarkSourceConverter = new PhotoWatermarkSourceConverter();
    private final SharedSQLiteStatement __preparedStmtOfDeletePhotoWatermarkById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteTextWatermarkById;
    /* access modifiers changed from: private */
    public final TextStyleConverter __textStyleConverter = new TextStyleConverter();

    public SavedWatermarksDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfTextWatermark = new EntityInsertionAdapter<TextWatermark>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `text_watermark` (`text_style`,`uid`,`thumbnail`,`timestamp`) VALUES (?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TextWatermark textWatermark) {
                String json = SavedWatermarksDao_Impl.this.__textStyleConverter.toJson(textWatermark.getStyle());
                if (json == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, json);
                }
                if (textWatermark.getUid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, textWatermark.getUid());
                }
                if (textWatermark.getThumbnailPath() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, textWatermark.getThumbnailPath());
                }
                supportSQLiteStatement.bindLong(4, textWatermark.getTimestamp());
            }
        };
        this.__insertionAdapterOfPhotoWatermark = new EntityInsertionAdapter<PhotoWatermark>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `photo_watermark` (`source`,`media_style`,`uid`,`thumbnail`,`timestamp`) VALUES (?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PhotoWatermark photoWatermark) {
                supportSQLiteStatement.bindLong(1, (long) SavedWatermarksDao_Impl.this.__photoWatermarkSourceConverter.toValue(photoWatermark.getSource()));
                String json = SavedWatermarksDao_Impl.this.__mediaStyleConverter.toJson(photoWatermark.getStyle());
                if (json == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, json);
                }
                if (photoWatermark.getUid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, photoWatermark.getUid());
                }
                if (photoWatermark.getThumbnailPath() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, photoWatermark.getThumbnailPath());
                }
                supportSQLiteStatement.bindLong(5, photoWatermark.getTimestamp());
            }
        };
        this.__preparedStmtOfDeleteTextWatermarkById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM text_watermark where uid = ?";
            }
        };
        this.__preparedStmtOfDeletePhotoWatermarkById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM photo_watermark where uid = ?";
            }
        };
    }

    public void insert(TextWatermark textWatermark) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTextWatermark.insert(textWatermark);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insert(PhotoWatermark photoWatermark) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPhotoWatermark.insert(photoWatermark);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteTextWatermarkById(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteTextWatermarkById.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteTextWatermarkById.release(acquire);
        }
    }

    public void deletePhotoWatermarkById(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeletePhotoWatermarkById.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeletePhotoWatermarkById.release(acquire);
        }
    }

    public List<TextWatermark> getTextWatermarks() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM text_watermark ORDER BY timestamp DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, ViewHierarchyConstants.TEXT_STYLE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, ServerParameters.AF_USER_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "thumbnail");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new TextWatermark(query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getLong(columnIndexOrThrow4), this.__textStyleConverter.toStyle(query.getString(columnIndexOrThrow))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<PhotoWatermark> getPhotoWatermarks() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM photo_watermark ORDER BY timestamp DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "source");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "media_style");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, ServerParameters.AF_USER_ID);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "thumbnail");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new PhotoWatermark(query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), this.__photoWatermarkSourceConverter.fromValue(query.getInt(columnIndexOrThrow)), this.__mediaStyleConverter.toStyle(query.getString(columnIndexOrThrow2))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
