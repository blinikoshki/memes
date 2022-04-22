package editor.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import com.appsflyer.ServerParameters;
import editor.database.converters.FrameStyleConverter;
import editor.database.converters.MediaStyleConverter;
import editor.database.converters.TextStyleConverter;
import editor.editor.dashboard.drafts.EditorDraft;
import java.util.ArrayList;
import java.util.List;

public final class EditorDraftsDao_Impl implements EditorDraftsDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<EditorDraft> __deletionAdapterOfEditorDraft;
    /* access modifiers changed from: private */
    public final FrameStyleConverter __frameStyleConverter = new FrameStyleConverter();
    private final EntityInsertionAdapter<EditorDraft> __insertionAdapterOfEditorDraft;
    /* access modifiers changed from: private */
    public final MediaStyleConverter __mediaStyleConverter = new MediaStyleConverter();
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    /* access modifiers changed from: private */
    public final TextStyleConverter __textStyleConverter = new TextStyleConverter();

    public EditorDraftsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfEditorDraft = new EntityInsertionAdapter<EditorDraft>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `drafts` (`uid`,`thumbnail`,`frame_width`,`frame_height`,`timestamp`,`text_styles`,`media_styles`,`frame_style`) VALUES (?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, EditorDraft editorDraft) {
                if (editorDraft.getUid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, editorDraft.getUid());
                }
                if (editorDraft.getThumbnailPath() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, editorDraft.getThumbnailPath());
                }
                supportSQLiteStatement.bindLong(3, (long) editorDraft.getFrameWidth());
                supportSQLiteStatement.bindLong(4, (long) editorDraft.getFrameHeight());
                supportSQLiteStatement.bindLong(5, editorDraft.getTimestamp());
                String json = EditorDraftsDao_Impl.this.__textStyleConverter.toJson(editorDraft.getTextStyles());
                if (json == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, json);
                }
                String json2 = EditorDraftsDao_Impl.this.__mediaStyleConverter.toJson(editorDraft.getMediaStyles());
                if (json2 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, json2);
                }
                String json3 = EditorDraftsDao_Impl.this.__frameStyleConverter.toJson(editorDraft.getFrameStyle());
                if (json3 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, json3);
                }
            }
        };
        this.__deletionAdapterOfEditorDraft = new EntityDeletionOrUpdateAdapter<EditorDraft>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `drafts` WHERE `uid` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, EditorDraft editorDraft) {
                if (editorDraft.getUid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, editorDraft.getUid());
                }
            }
        };
        this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM drafts where uid = ?";
            }
        };
    }

    public void insertAll(EditorDraft... editorDraftArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEditorDraft.insert((T[]) editorDraftArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void delete(EditorDraft editorDraft) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfEditorDraft.handle(editorDraft);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteById(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteById.acquire();
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
            this.__preparedStmtOfDeleteById.release(acquire);
        }
    }

    public List<EditorDraft> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM drafts ORDER BY timestamp DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, ServerParameters.AF_USER_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "thumbnail");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "frame_width");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "frame_height");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "text_styles");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "media_styles");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "frame_style");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new EditorDraft(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), this.__textStyleConverter.toStyles(query.getString(columnIndexOrThrow6)), this.__mediaStyleConverter.toStyles(query.getString(columnIndexOrThrow7)), this.__frameStyleConverter.toStyle(query.getString(columnIndexOrThrow8))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public EditorDraft get(String str) {
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM drafts where uid = ?", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        EditorDraft editorDraft = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, ServerParameters.AF_USER_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "thumbnail");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "frame_width");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "frame_height");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "text_styles");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "media_styles");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "frame_style");
            if (query.moveToFirst()) {
                editorDraft = new EditorDraft(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), this.__textStyleConverter.toStyles(query.getString(columnIndexOrThrow6)), this.__mediaStyleConverter.toStyles(query.getString(columnIndexOrThrow7)), this.__frameStyleConverter.toStyle(query.getString(columnIndexOrThrow8)));
            }
            return editorDraft;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
