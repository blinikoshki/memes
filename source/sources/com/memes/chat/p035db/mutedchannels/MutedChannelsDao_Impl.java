package com.memes.chat.p035db.mutedchannels;

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
import com.memes.chat.p035db.mutedchannels.MutedChannelsDao;
import java.util.ArrayList;
import java.util.List;
import p015io.getstream.chat.android.client.models.ChannelMute;

/* renamed from: com.memes.chat.db.mutedchannels.MutedChannelsDao_Impl */
public final class MutedChannelsDao_Impl implements MutedChannelsDao {
    /* access modifiers changed from: private */
    public final DateConverter __dateConverter = new DateConverter();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MutedChannelEntity> __deletionAdapterOfMutedChannelEntity;
    private final EntityInsertionAdapter<MutedChannelEntity> __insertionAdapterOfMutedChannelEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;

    public MutedChannelsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMutedChannelEntity = new EntityInsertionAdapter<MutedChannelEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `muted_channels` (`cid`,`id`,`type`,`name`,`image`,`mutedBy`,`mutedAt`) VALUES (?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MutedChannelEntity mutedChannelEntity) {
                if (mutedChannelEntity.getCid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, mutedChannelEntity.getCid());
                }
                if (mutedChannelEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, mutedChannelEntity.getId());
                }
                if (mutedChannelEntity.getType() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, mutedChannelEntity.getType());
                }
                if (mutedChannelEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, mutedChannelEntity.getName());
                }
                if (mutedChannelEntity.getImage() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, mutedChannelEntity.getImage());
                }
                if (mutedChannelEntity.getMutedBy() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, mutedChannelEntity.getMutedBy());
                }
                supportSQLiteStatement.bindLong(7, MutedChannelsDao_Impl.this.__dateConverter.toTimestamp(mutedChannelEntity.getMutedAt()));
            }
        };
        this.__deletionAdapterOfMutedChannelEntity = new EntityDeletionOrUpdateAdapter<MutedChannelEntity>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `muted_channels` WHERE `cid` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MutedChannelEntity mutedChannelEntity) {
                if (mutedChannelEntity.getCid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, mutedChannelEntity.getCid());
                }
            }
        };
        this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM muted_channels where cid = ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM muted_channels";
            }
        };
    }

    public void insertAll(List<MutedChannelEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMutedChannelEntity.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void delete(MutedChannelEntity mutedChannelEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfMutedChannelEntity.handle(mutedChannelEntity);
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

    public List<MutedChannelEntity> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM muted_channels", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "image");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mutedBy");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mutedAt");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = columnIndexOrThrow;
                arrayList.add(new MutedChannelEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getString(columnIndexOrThrow6), this.__dateConverter.toDate(query.getLong(columnIndexOrThrow7))));
                columnIndexOrThrow = i;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public MutedChannelEntity getByChannelId(String str) {
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM muted_channels where cid = ? LIMIT 1", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        MutedChannelEntity mutedChannelEntity = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "image");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mutedBy");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mutedAt");
            if (query.moveToFirst()) {
                mutedChannelEntity = new MutedChannelEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getString(columnIndexOrThrow6), this.__dateConverter.toDate(query.getLong(columnIndexOrThrow7)));
            }
            return mutedChannelEntity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void replaceChannelMutes(List<ChannelMute> list) {
        MutedChannelsDao.DefaultImpls.replaceChannelMutes(this, list);
    }

    public List<ChannelMute> getAllMutes() {
        return MutedChannelsDao.DefaultImpls.getAllMutes(this);
    }

    public ChannelMute getMuteByChannelId(String str) {
        return MutedChannelsDao.DefaultImpls.getMuteByChannelId(this, str);
    }
}
