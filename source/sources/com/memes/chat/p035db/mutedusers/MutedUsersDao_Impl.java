package com.memes.chat.p035db.mutedusers;

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
import com.memes.chat.p035db.common.DateConverter;
import com.memes.chat.p035db.mutedusers.MutedUsersDao;
import java.util.ArrayList;
import java.util.List;
import p015io.getstream.chat.android.client.models.Mute;

/* renamed from: com.memes.chat.db.mutedusers.MutedUsersDao_Impl */
public final class MutedUsersDao_Impl implements MutedUsersDao {
    /* access modifiers changed from: private */
    public final DateConverter __dateConverter = new DateConverter();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MutedUserEntity> __deletionAdapterOfMutedUserEntity;
    private final EntityInsertionAdapter<MutedUserEntity> __insertionAdapterOfMutedUserEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;

    public MutedUsersDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMutedUserEntity = new EntityInsertionAdapter<MutedUserEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `muted_users` (`id`,`name`,`image`,`mutedBy`,`mutedAt`,`updatedAt`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MutedUserEntity mutedUserEntity) {
                if (mutedUserEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, mutedUserEntity.getId());
                }
                if (mutedUserEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, mutedUserEntity.getName());
                }
                if (mutedUserEntity.getImage() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, mutedUserEntity.getImage());
                }
                if (mutedUserEntity.getMutedBy() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, mutedUserEntity.getMutedBy());
                }
                supportSQLiteStatement.bindLong(5, MutedUsersDao_Impl.this.__dateConverter.toTimestamp(mutedUserEntity.getMutedAt()));
                supportSQLiteStatement.bindLong(6, MutedUsersDao_Impl.this.__dateConverter.toTimestamp(mutedUserEntity.getUpdatedAt()));
            }
        };
        this.__deletionAdapterOfMutedUserEntity = new EntityDeletionOrUpdateAdapter<MutedUserEntity>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `muted_users` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MutedUserEntity mutedUserEntity) {
                if (mutedUserEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, mutedUserEntity.getId());
                }
            }
        };
        this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM muted_users where id = ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM muted_users";
            }
        };
    }

    public void insertAll(List<MutedUserEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMutedUserEntity.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void delete(MutedUserEntity mutedUserEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfMutedUserEntity.handle(mutedUserEntity);
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

    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    public List<MutedUserEntity> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM muted_users", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "image");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mutedBy");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mutedAt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = columnIndexOrThrow;
                arrayList.add(new MutedUserEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), this.__dateConverter.toDate(query.getLong(columnIndexOrThrow5)), this.__dateConverter.toDate(query.getLong(columnIndexOrThrow6))));
                columnIndexOrThrow = i;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public MutedUserEntity getByUserId(String str) {
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM muted_users where id = ? LIMIT 1", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        MutedUserEntity mutedUserEntity = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "image");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mutedBy");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mutedAt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
            if (query.moveToFirst()) {
                mutedUserEntity = new MutedUserEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), this.__dateConverter.toDate(query.getLong(columnIndexOrThrow5)), this.__dateConverter.toDate(query.getLong(columnIndexOrThrow6)));
            }
            return mutedUserEntity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void replaceMutes(List<Mute> list) {
        MutedUsersDao.DefaultImpls.replaceMutes(this, list);
    }

    public List<Mute> getAllMutes() {
        return MutedUsersDao.DefaultImpls.getAllMutes(this);
    }

    public Mute getMuteByUserId(String str) {
        return MutedUsersDao.DefaultImpls.getMuteByUserId(this, str);
    }
}
