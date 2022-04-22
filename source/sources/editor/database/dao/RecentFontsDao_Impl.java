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
import editor.optionsui.text.textfont.TextFont;
import java.util.ArrayList;
import java.util.List;

public final class RecentFontsDao_Impl implements RecentFontsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<TextFont> __insertionAdapterOfTextFont;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecentFontById;

    public RecentFontsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfTextFont = new EntityInsertionAdapter<TextFont>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `text_fonts` (`id`,`display_name`,`type`,`file_name`,`premium`) VALUES (?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TextFont textFont) {
                if (textFont.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, textFont.getId());
                }
                if (textFont.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, textFont.getDisplayName());
                }
                if (textFont.getType() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, textFont.getType());
                }
                if (textFont.getFileName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, textFont.getFileName());
                }
                supportSQLiteStatement.bindLong(5, textFont.isPremiumFont() ? 1 : 0);
            }
        };
        this.__preparedStmtOfDeleteRecentFontById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM text_fonts where id = ?";
            }
        };
    }

    public void insertRecentFont(TextFont textFont) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTextFont.insert(textFont);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteRecentFontById(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteRecentFontById.acquire();
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
            this.__preparedStmtOfDeleteRecentFontById.release(acquire);
        }
    }

    public List<TextFont> getRecentFonts() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM text_fonts", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "display_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "file_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "premium");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new TextFont(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5) != 0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
