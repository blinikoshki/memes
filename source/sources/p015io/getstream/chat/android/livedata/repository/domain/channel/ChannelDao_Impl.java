package p015io.getstream.chat.android.livedata.repository.domain.channel;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.livedata.repository.database.converter.DateConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.MapConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter;
import p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity;
import p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity;

/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao_Impl */
public final class ChannelDao_Impl implements ChannelDao {
    /* access modifiers changed from: private */
    public final DateConverter __dateConverter = new DateConverter();
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final ExtraDataConverter __extraDataConverter = new ExtraDataConverter();
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<ChannelEntity> __insertionAdapterOfChannelEntity;
    /* access modifiers changed from: private */
    public final MapConverter __mapConverter = new MapConverter();
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDelete;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfSetDeletedAt;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfSetHidden;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfSetHidden_1;
    /* access modifiers changed from: private */
    public final SyncStatusConverter __syncStatusConverter = new SyncStatusConverter();

    public ChannelDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfChannelEntity = new EntityInsertionAdapter<ChannelEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `stream_chat_channel_state` (`cid`,`type`,`channelId`,`cooldown`,`createdByUserId`,`frozen`,`hidden`,`hideMessagesBefore`,`members`,`reads`,`lastMessageAt`,`lastMessageId`,`createdAt`,`updatedAt`,`deletedAt`,`extraData`,`syncStatus`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ChannelEntity channelEntity) {
                if (channelEntity.getCid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, channelEntity.getCid());
                }
                if (channelEntity.getType() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, channelEntity.getType());
                }
                if (channelEntity.getChannelId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, channelEntity.getChannelId());
                }
                supportSQLiteStatement.bindLong(4, (long) channelEntity.getCooldown());
                if (channelEntity.getCreatedByUserId() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, channelEntity.getCreatedByUserId());
                }
                supportSQLiteStatement.bindLong(6, channelEntity.getFrozen() ? 1 : 0);
                Integer valueOf = channelEntity.getHidden() == null ? null : Integer.valueOf(channelEntity.getHidden().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, (long) valueOf.intValue());
                }
                Long dateToTimestamp = ChannelDao_Impl.this.__dateConverter.dateToTimestamp(channelEntity.getHideMessagesBefore());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, dateToTimestamp.longValue());
                }
                String memberMapToString = ChannelDao_Impl.this.__mapConverter.memberMapToString(channelEntity.getMembers());
                if (memberMapToString == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, memberMapToString);
                }
                String readMapToString = ChannelDao_Impl.this.__mapConverter.readMapToString(channelEntity.getReads());
                if (readMapToString == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, readMapToString);
                }
                Long dateToTimestamp2 = ChannelDao_Impl.this.__dateConverter.dateToTimestamp(channelEntity.getLastMessageAt());
                if (dateToTimestamp2 == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, dateToTimestamp2.longValue());
                }
                if (channelEntity.getLastMessageId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, channelEntity.getLastMessageId());
                }
                Long dateToTimestamp3 = ChannelDao_Impl.this.__dateConverter.dateToTimestamp(channelEntity.getCreatedAt());
                if (dateToTimestamp3 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, dateToTimestamp3.longValue());
                }
                Long dateToTimestamp4 = ChannelDao_Impl.this.__dateConverter.dateToTimestamp(channelEntity.getUpdatedAt());
                if (dateToTimestamp4 == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, dateToTimestamp4.longValue());
                }
                Long dateToTimestamp5 = ChannelDao_Impl.this.__dateConverter.dateToTimestamp(channelEntity.getDeletedAt());
                if (dateToTimestamp5 == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindLong(15, dateToTimestamp5.longValue());
                }
                String mapToString = ChannelDao_Impl.this.__extraDataConverter.mapToString(channelEntity.getExtraData());
                if (mapToString == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, mapToString);
                }
                supportSQLiteStatement.bindLong(17, (long) ChannelDao_Impl.this.__syncStatusConverter.syncStatusToString(channelEntity.getSyncStatus()));
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE from stream_chat_channel_state WHERE cid = ?";
            }
        };
        this.__preparedStmtOfSetDeletedAt = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE stream_chat_channel_state SET deletedAt = ? WHERE cid = ?";
            }
        };
        this.__preparedStmtOfSetHidden = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE stream_chat_channel_state SET hidden = ?, hideMessagesBefore = ? WHERE cid = ?";
            }
        };
        this.__preparedStmtOfSetHidden_1 = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE stream_chat_channel_state SET hidden = ? WHERE cid = ?";
            }
        };
    }

    public Object insert(final ChannelEntity channelEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                ChannelDao_Impl.this.__db.beginTransaction();
                try {
                    ChannelDao_Impl.this.__insertionAdapterOfChannelEntity.insert(channelEntity);
                    ChannelDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object insertMany(final List<ChannelEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                ChannelDao_Impl.this.__db.beginTransaction();
                try {
                    ChannelDao_Impl.this.__insertionAdapterOfChannelEntity.insert(list);
                    ChannelDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object delete(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = ChannelDao_Impl.this.__preparedStmtOfDelete.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                ChannelDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    ChannelDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelDao_Impl.this.__db.endTransaction();
                    ChannelDao_Impl.this.__preparedStmtOfDelete.release(acquire);
                }
            }
        }, continuation);
    }

    public Object setDeletedAt(final String str, final Date date, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = ChannelDao_Impl.this.__preparedStmtOfSetDeletedAt.acquire();
                Long dateToTimestamp = ChannelDao_Impl.this.__dateConverter.dateToTimestamp(date);
                if (dateToTimestamp == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindLong(1, dateToTimestamp.longValue());
                }
                String str = str;
                if (str == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str);
                }
                ChannelDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    ChannelDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelDao_Impl.this.__db.endTransaction();
                    ChannelDao_Impl.this.__preparedStmtOfSetDeletedAt.release(acquire);
                }
            }
        }, continuation);
    }

    public Object setHidden(final String str, final boolean z, final Date date, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = ChannelDao_Impl.this.__preparedStmtOfSetHidden.acquire();
                acquire.bindLong(1, z ? 1 : 0);
                Long dateToTimestamp = ChannelDao_Impl.this.__dateConverter.dateToTimestamp(date);
                if (dateToTimestamp == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindLong(2, dateToTimestamp.longValue());
                }
                String str = str;
                if (str == null) {
                    acquire.bindNull(3);
                } else {
                    acquire.bindString(3, str);
                }
                ChannelDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    ChannelDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelDao_Impl.this.__db.endTransaction();
                    ChannelDao_Impl.this.__preparedStmtOfSetHidden.release(acquire);
                }
            }
        }, continuation);
    }

    public Object setHidden(final String str, final boolean z, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = ChannelDao_Impl.this.__preparedStmtOfSetHidden_1.acquire();
                acquire.bindLong(1, z ? 1 : 0);
                String str = str;
                if (str == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str);
                }
                ChannelDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    ChannelDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelDao_Impl.this.__db.endTransaction();
                    ChannelDao_Impl.this.__preparedStmtOfSetHidden_1.release(acquire);
                }
            }
        }, continuation);
    }

    public Object selectSyncNeeded(SyncStatus syncStatus, Continuation<? super List<ChannelEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_channel_state WHERE stream_chat_channel_state.syncStatus IN (?)", 1);
        acquire.bindLong(1, (long) this.__syncStatusConverter.syncStatusToString(syncStatus));
        return CoroutinesRoom.execute(this.__db, false, new Callable<List<ChannelEntity>>() {
            public List<ChannelEntity> call() throws Exception {
                Integer num;
                Boolean bool;
                int i;
                Long l;
                Long l2;
                Long l3;
                int i2;
                Long l4;
                Long l5;
                Cursor query = DBUtil.query(ChannelDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cid");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "type");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "channelId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cooldown");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "createdByUserId");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "frozen");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "hidden");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "hideMessagesBefore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ModelFields.MEMBERS);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "reads");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "lastMessageAt");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "lastMessageId");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "createdAt");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
                    int i3 = columnIndexOrThrow;
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "deletedAt");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "extraData");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "syncStatus");
                    int i4 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow2);
                        String string2 = query.getString(columnIndexOrThrow3);
                        int i5 = query.getInt(columnIndexOrThrow4);
                        String string3 = query.getString(columnIndexOrThrow5);
                        boolean z = true;
                        boolean z2 = query.getInt(columnIndexOrThrow6) != 0;
                        if (query.isNull(columnIndexOrThrow7)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                        }
                        if (num == null) {
                            bool = null;
                        } else {
                            if (num.intValue() == 0) {
                                z = false;
                            }
                            bool = Boolean.valueOf(z);
                        }
                        if (query.isNull(columnIndexOrThrow8)) {
                            i = columnIndexOrThrow2;
                            l = null;
                        } else {
                            l = Long.valueOf(query.getLong(columnIndexOrThrow8));
                            i = columnIndexOrThrow2;
                        }
                        Date fromTimestamp = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l);
                        Map<String, MemberEntity> stringToMemberMap = ChannelDao_Impl.this.__mapConverter.stringToMemberMap(query.getString(columnIndexOrThrow9));
                        Map<String, ChannelUserReadEntity> stringToReadMap = ChannelDao_Impl.this.__mapConverter.stringToReadMap(query.getString(columnIndexOrThrow10));
                        if (query.isNull(columnIndexOrThrow11)) {
                            l2 = null;
                        } else {
                            l2 = Long.valueOf(query.getLong(columnIndexOrThrow11));
                        }
                        Date fromTimestamp2 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l2);
                        String string4 = query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            l3 = null;
                        } else {
                            l3 = Long.valueOf(query.getLong(columnIndexOrThrow13));
                        }
                        Date fromTimestamp3 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l3);
                        int i6 = i4;
                        if (query.isNull(i6)) {
                            i2 = columnIndexOrThrow13;
                            l4 = null;
                        } else {
                            l4 = Long.valueOf(query.getLong(i6));
                            i2 = columnIndexOrThrow13;
                        }
                        Date fromTimestamp4 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l4);
                        int i7 = columnIndexOrThrow15;
                        if (query.isNull(i7)) {
                            columnIndexOrThrow15 = i7;
                            l5 = null;
                        } else {
                            l5 = Long.valueOf(query.getLong(i7));
                            columnIndexOrThrow15 = i7;
                        }
                        int i8 = columnIndexOrThrow16;
                        columnIndexOrThrow16 = i8;
                        int i9 = columnIndexOrThrow17;
                        columnIndexOrThrow17 = i9;
                        ChannelEntity channelEntity = new ChannelEntity(string, string2, i5, string3, z2, bool, fromTimestamp, stringToMemberMap, stringToReadMap, fromTimestamp2, string4, fromTimestamp3, fromTimestamp4, ChannelDao_Impl.this.__dateConverter.fromTimestamp(l5), ChannelDao_Impl.this.__extraDataConverter.stringToMap(query.getString(i8)), ChannelDao_Impl.this.__syncStatusConverter.stringToSyncStatus(query.getInt(i9)));
                        int i10 = i3;
                        int i11 = i6;
                        channelEntity.setCid(query.getString(i10));
                        arrayList.add(channelEntity);
                        columnIndexOrThrow13 = i2;
                        i4 = i11;
                        i3 = i10;
                        columnIndexOrThrow2 = i;
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object select(List<String> list, Continuation<? super List<ChannelEntity>> continuation) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM stream_chat_channel_state WHERE stream_chat_channel_state.cid IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        return CoroutinesRoom.execute(this.__db, false, new Callable<List<ChannelEntity>>() {
            public List<ChannelEntity> call() throws Exception {
                Integer num;
                Boolean bool;
                int i;
                Long l;
                Long l2;
                Long l3;
                int i2;
                Long l4;
                Long l5;
                Cursor query = DBUtil.query(ChannelDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cid");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "type");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "channelId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cooldown");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "createdByUserId");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "frozen");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "hidden");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "hideMessagesBefore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ModelFields.MEMBERS);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "reads");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "lastMessageAt");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "lastMessageId");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "createdAt");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
                    int i3 = columnIndexOrThrow;
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "deletedAt");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "extraData");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "syncStatus");
                    int i4 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow2);
                        String string2 = query.getString(columnIndexOrThrow3);
                        int i5 = query.getInt(columnIndexOrThrow4);
                        String string3 = query.getString(columnIndexOrThrow5);
                        boolean z = true;
                        boolean z2 = query.getInt(columnIndexOrThrow6) != 0;
                        if (query.isNull(columnIndexOrThrow7)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                        }
                        if (num == null) {
                            bool = null;
                        } else {
                            if (num.intValue() == 0) {
                                z = false;
                            }
                            bool = Boolean.valueOf(z);
                        }
                        if (query.isNull(columnIndexOrThrow8)) {
                            i = columnIndexOrThrow2;
                            l = null;
                        } else {
                            l = Long.valueOf(query.getLong(columnIndexOrThrow8));
                            i = columnIndexOrThrow2;
                        }
                        Date fromTimestamp = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l);
                        Map<String, MemberEntity> stringToMemberMap = ChannelDao_Impl.this.__mapConverter.stringToMemberMap(query.getString(columnIndexOrThrow9));
                        Map<String, ChannelUserReadEntity> stringToReadMap = ChannelDao_Impl.this.__mapConverter.stringToReadMap(query.getString(columnIndexOrThrow10));
                        if (query.isNull(columnIndexOrThrow11)) {
                            l2 = null;
                        } else {
                            l2 = Long.valueOf(query.getLong(columnIndexOrThrow11));
                        }
                        Date fromTimestamp2 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l2);
                        String string4 = query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            l3 = null;
                        } else {
                            l3 = Long.valueOf(query.getLong(columnIndexOrThrow13));
                        }
                        Date fromTimestamp3 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l3);
                        int i6 = i4;
                        if (query.isNull(i6)) {
                            i2 = columnIndexOrThrow13;
                            l4 = null;
                        } else {
                            l4 = Long.valueOf(query.getLong(i6));
                            i2 = columnIndexOrThrow13;
                        }
                        Date fromTimestamp4 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l4);
                        int i7 = columnIndexOrThrow15;
                        if (query.isNull(i7)) {
                            columnIndexOrThrow15 = i7;
                            l5 = null;
                        } else {
                            l5 = Long.valueOf(query.getLong(i7));
                            columnIndexOrThrow15 = i7;
                        }
                        int i8 = columnIndexOrThrow16;
                        columnIndexOrThrow16 = i8;
                        int i9 = columnIndexOrThrow17;
                        columnIndexOrThrow17 = i9;
                        ChannelEntity channelEntity = new ChannelEntity(string, string2, i5, string3, z2, bool, fromTimestamp, stringToMemberMap, stringToReadMap, fromTimestamp2, string4, fromTimestamp3, fromTimestamp4, ChannelDao_Impl.this.__dateConverter.fromTimestamp(l5), ChannelDao_Impl.this.__extraDataConverter.stringToMap(query.getString(i8)), ChannelDao_Impl.this.__syncStatusConverter.stringToSyncStatus(query.getInt(i9)));
                        int i10 = i3;
                        int i11 = i6;
                        channelEntity.setCid(query.getString(i10));
                        arrayList.add(channelEntity);
                        columnIndexOrThrow13 = i2;
                        i4 = i11;
                        i3 = i10;
                        columnIndexOrThrow2 = i;
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object select(String str, Continuation<? super ChannelEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_channel_state WHERE stream_chat_channel_state.cid IN (?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, new Callable<ChannelEntity>() {
            public ChannelEntity call() throws Exception {
                ChannelEntity channelEntity;
                Integer num;
                Boolean bool;
                Long l;
                Long l2;
                Long l3;
                Long l4;
                Long l5;
                Cursor query = DBUtil.query(ChannelDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cid");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "type");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "channelId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cooldown");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "createdByUserId");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "frozen");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "hidden");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "hideMessagesBefore");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ModelFields.MEMBERS);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "reads");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "lastMessageAt");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "lastMessageId");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "createdAt");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
                    int i = columnIndexOrThrow;
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "deletedAt");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "extraData");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "syncStatus");
                    if (query.moveToFirst()) {
                        String string = query.getString(columnIndexOrThrow2);
                        String string2 = query.getString(columnIndexOrThrow3);
                        int i2 = query.getInt(columnIndexOrThrow4);
                        String string3 = query.getString(columnIndexOrThrow5);
                        boolean z = query.getInt(columnIndexOrThrow6) != 0;
                        if (query.isNull(columnIndexOrThrow7)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                        }
                        if (num == null) {
                            bool = null;
                        } else {
                            bool = Boolean.valueOf(num.intValue() != 0);
                        }
                        if (query.isNull(columnIndexOrThrow8)) {
                            l = null;
                        } else {
                            l = Long.valueOf(query.getLong(columnIndexOrThrow8));
                        }
                        Date fromTimestamp = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l);
                        Map<String, MemberEntity> stringToMemberMap = ChannelDao_Impl.this.__mapConverter.stringToMemberMap(query.getString(columnIndexOrThrow9));
                        Map<String, ChannelUserReadEntity> stringToReadMap = ChannelDao_Impl.this.__mapConverter.stringToReadMap(query.getString(columnIndexOrThrow10));
                        if (query.isNull(columnIndexOrThrow11)) {
                            l2 = null;
                        } else {
                            l2 = Long.valueOf(query.getLong(columnIndexOrThrow11));
                        }
                        Date fromTimestamp2 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l2);
                        String string4 = query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            l3 = null;
                        } else {
                            l3 = Long.valueOf(query.getLong(columnIndexOrThrow13));
                        }
                        Date fromTimestamp3 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l3);
                        if (query.isNull(columnIndexOrThrow14)) {
                            l4 = null;
                        } else {
                            l4 = Long.valueOf(query.getLong(columnIndexOrThrow14));
                        }
                        Date fromTimestamp4 = ChannelDao_Impl.this.__dateConverter.fromTimestamp(l4);
                        int i3 = columnIndexOrThrow15;
                        if (query.isNull(i3)) {
                            l5 = null;
                        } else {
                            l5 = Long.valueOf(query.getLong(i3));
                        }
                        channelEntity = new ChannelEntity(string, string2, i2, string3, z, bool, fromTimestamp, stringToMemberMap, stringToReadMap, fromTimestamp2, string4, fromTimestamp3, fromTimestamp4, ChannelDao_Impl.this.__dateConverter.fromTimestamp(l5), ChannelDao_Impl.this.__extraDataConverter.stringToMap(query.getString(columnIndexOrThrow16)), ChannelDao_Impl.this.__syncStatusConverter.stringToSyncStatus(query.getInt(columnIndexOrThrow17)));
                        channelEntity.setCid(query.getString(i));
                    } else {
                        channelEntity = null;
                    }
                    return channelEntity;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }
}
