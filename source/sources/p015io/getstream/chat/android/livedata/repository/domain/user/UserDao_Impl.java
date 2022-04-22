package p015io.getstream.chat.android.livedata.repository.domain.user;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.livedata.repository.database.converter.DateConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.ListConverter;

/* renamed from: io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl */
public final class UserDao_Impl implements UserDao {
    /* access modifiers changed from: private */
    public final DateConverter __dateConverter = new DateConverter();
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final ExtraDataConverter __extraDataConverter = new ExtraDataConverter();
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;
    /* access modifiers changed from: private */
    public final ListConverter __listConverter = new ListConverter();

    public UserDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `stream_chat_user` (`id`,`originalId`,`name`,`role`,`createdAt`,`updatedAt`,`lastActive`,`invisible`,`banned`,`mutes`,`extraData`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UserEntity userEntity) {
                if (userEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, userEntity.getId());
                }
                if (userEntity.getOriginalId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, userEntity.getOriginalId());
                }
                if (userEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, userEntity.getName());
                }
                if (userEntity.getRole() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, userEntity.getRole());
                }
                Long dateToTimestamp = UserDao_Impl.this.__dateConverter.dateToTimestamp(userEntity.getCreatedAt());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, dateToTimestamp.longValue());
                }
                Long dateToTimestamp2 = UserDao_Impl.this.__dateConverter.dateToTimestamp(userEntity.getUpdatedAt());
                if (dateToTimestamp2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, dateToTimestamp2.longValue());
                }
                Long dateToTimestamp3 = UserDao_Impl.this.__dateConverter.dateToTimestamp(userEntity.getLastActive());
                if (dateToTimestamp3 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, dateToTimestamp3.longValue());
                }
                supportSQLiteStatement.bindLong(8, userEntity.getInvisible() ? 1 : 0);
                supportSQLiteStatement.bindLong(9, userEntity.getBanned() ? 1 : 0);
                String stringListToString = UserDao_Impl.this.__listConverter.stringListToString(userEntity.getMutes());
                if (stringListToString == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, stringListToString);
                }
                String mapToString = UserDao_Impl.this.__extraDataConverter.mapToString(userEntity.getExtraData());
                if (mapToString == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, mapToString);
                }
            }
        };
    }

    public Object insertMany(final List<UserEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                UserDao_Impl.this.__db.beginTransaction();
                try {
                    UserDao_Impl.this.__insertionAdapterOfUserEntity.insert(list);
                    UserDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    UserDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object insert(final UserEntity userEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                UserDao_Impl.this.__db.beginTransaction();
                try {
                    UserDao_Impl.this.__insertionAdapterOfUserEntity.insert(userEntity);
                    UserDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    UserDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object select(List<String> list, Continuation<? super List<UserEntity>> continuation) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM stream_chat_user WHERE stream_chat_user.id IN (");
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
        return CoroutinesRoom.execute(this.__db, false, new Callable<List<UserEntity>>() {
            public List<UserEntity> call() throws Exception {
                Long l;
                Long l2;
                Long l3;
                Long l4 = null;
                Cursor query = DBUtil.query(UserDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "originalId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "role");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "createdAt");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "lastActive");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "invisible");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "banned");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mutes");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "extraData");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow);
                        String string2 = query.getString(columnIndexOrThrow2);
                        String string3 = query.getString(columnIndexOrThrow3);
                        String string4 = query.getString(columnIndexOrThrow4);
                        if (query.isNull(columnIndexOrThrow5)) {
                            l = l4;
                        } else {
                            l = Long.valueOf(query.getLong(columnIndexOrThrow5));
                        }
                        Date fromTimestamp = UserDao_Impl.this.__dateConverter.fromTimestamp(l);
                        if (query.isNull(columnIndexOrThrow6)) {
                            l2 = null;
                        } else {
                            l2 = Long.valueOf(query.getLong(columnIndexOrThrow6));
                        }
                        Date fromTimestamp2 = UserDao_Impl.this.__dateConverter.fromTimestamp(l2);
                        if (query.isNull(columnIndexOrThrow7)) {
                            l3 = null;
                        } else {
                            l3 = Long.valueOf(query.getLong(columnIndexOrThrow7));
                        }
                        arrayList.add(new UserEntity(string, string2, string3, string4, fromTimestamp, fromTimestamp2, UserDao_Impl.this.__dateConverter.fromTimestamp(l3), query.getInt(columnIndexOrThrow8) != 0, query.getInt(columnIndexOrThrow9) != 0, UserDao_Impl.this.__listConverter.stringToStringList(query.getString(columnIndexOrThrow10)), UserDao_Impl.this.__extraDataConverter.stringToMap(query.getString(columnIndexOrThrow11))));
                        l4 = null;
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object select(String str, Continuation<? super UserEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_user WHERE stream_chat_user.id IN (?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, new Callable<UserEntity>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: io.getstream.chat.android.livedata.repository.domain.user.UserEntity} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Long} */
            /* JADX WARNING: type inference failed for: r4v0 */
            /* JADX WARNING: type inference failed for: r16v1, types: [io.getstream.chat.android.livedata.repository.domain.user.UserEntity] */
            /* JADX WARNING: type inference failed for: r4v7 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public p015io.getstream.chat.android.livedata.repository.domain.user.UserEntity call() throws java.lang.Exception {
                /*
                    r28 = this;
                    r1 = r28
                    io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r2 = r0
                    r3 = 0
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r5 = "originalId"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r6 = "name"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r7 = "role"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r8 = "createdAt"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r9 = "updatedAt"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r10 = "lastActive"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r11 = "invisible"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r12 = "banned"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r13 = "mutes"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r14 = "extraData"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x00f8 }
                    boolean r15 = r2.moveToFirst()     // Catch:{ all -> 0x00f8 }
                    if (r15 == 0) goto L_0x00ef
                    java.lang.String r17 = r2.getString(r0)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r18 = r2.getString(r5)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r19 = r2.getString(r6)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r20 = r2.getString(r7)     // Catch:{ all -> 0x00f8 }
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x00f8 }
                    if (r0 == 0) goto L_0x0070
                    r0 = r4
                    goto L_0x0078
                L_0x0070:
                    long r5 = r2.getLong(r8)     // Catch:{ all -> 0x00f8 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00f8 }
                L_0x0078:
                    io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl r5 = p015io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl.this     // Catch:{ all -> 0x00f8 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r5 = r5.__dateConverter     // Catch:{ all -> 0x00f8 }
                    java.util.Date r21 = r5.fromTimestamp(r0)     // Catch:{ all -> 0x00f8 }
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x00f8 }
                    if (r0 == 0) goto L_0x008a
                    r0 = r4
                    goto L_0x0092
                L_0x008a:
                    long r5 = r2.getLong(r9)     // Catch:{ all -> 0x00f8 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00f8 }
                L_0x0092:
                    io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl r5 = p015io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl.this     // Catch:{ all -> 0x00f8 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r5 = r5.__dateConverter     // Catch:{ all -> 0x00f8 }
                    java.util.Date r22 = r5.fromTimestamp(r0)     // Catch:{ all -> 0x00f8 }
                    boolean r0 = r2.isNull(r10)     // Catch:{ all -> 0x00f8 }
                    if (r0 == 0) goto L_0x00a3
                    goto L_0x00ab
                L_0x00a3:
                    long r4 = r2.getLong(r10)     // Catch:{ all -> 0x00f8 }
                    java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00f8 }
                L_0x00ab:
                    io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl.this     // Catch:{ all -> 0x00f8 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r0 = r0.__dateConverter     // Catch:{ all -> 0x00f8 }
                    java.util.Date r23 = r0.fromTimestamp(r4)     // Catch:{ all -> 0x00f8 }
                    int r0 = r2.getInt(r11)     // Catch:{ all -> 0x00f8 }
                    r4 = 1
                    if (r0 == 0) goto L_0x00bf
                    r24 = 1
                    goto L_0x00c1
                L_0x00bf:
                    r24 = 0
                L_0x00c1:
                    int r0 = r2.getInt(r12)     // Catch:{ all -> 0x00f8 }
                    if (r0 == 0) goto L_0x00ca
                    r25 = 1
                    goto L_0x00cc
                L_0x00ca:
                    r25 = 0
                L_0x00cc:
                    java.lang.String r0 = r2.getString(r13)     // Catch:{ all -> 0x00f8 }
                    io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl.this     // Catch:{ all -> 0x00f8 }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r3 = r3.__listConverter     // Catch:{ all -> 0x00f8 }
                    java.util.List r26 = r3.stringToStringList(r0)     // Catch:{ all -> 0x00f8 }
                    java.lang.String r0 = r2.getString(r14)     // Catch:{ all -> 0x00f8 }
                    io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl.this     // Catch:{ all -> 0x00f8 }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r3 = r3.__extraDataConverter     // Catch:{ all -> 0x00f8 }
                    java.util.Map r27 = r3.stringToMap(r0)     // Catch:{ all -> 0x00f8 }
                    io.getstream.chat.android.livedata.repository.domain.user.UserEntity r4 = new io.getstream.chat.android.livedata.repository.domain.user.UserEntity     // Catch:{ all -> 0x00f8 }
                    r16 = r4
                    r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x00f8 }
                L_0x00ef:
                    r2.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    return r4
                L_0x00f8:
                    r0 = move-exception
                    r2.close()
                    androidx.room.RoomSQLiteQuery r2 = r0
                    r2.release()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl.C50565.call():io.getstream.chat.android.livedata.repository.domain.user.UserEntity");
            }
        }, continuation);
    }

    public List<UserEntity> selectAllUser(int i, int i2) {
        int i3;
        Long l;
        Long l2;
        Long l3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_user ORDER BY name ASC LIMIT ? OFFSET ?", 2);
        acquire.bindLong(1, (long) i);
        acquire.bindLong(2, (long) i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "originalId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "role");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "createdAt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "lastActive");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "invisible");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "banned");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mutes");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "extraData");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow);
                String string2 = query.getString(columnIndexOrThrow2);
                String string3 = query.getString(columnIndexOrThrow3);
                String string4 = query.getString(columnIndexOrThrow4);
                if (query.isNull(columnIndexOrThrow5)) {
                    i3 = columnIndexOrThrow;
                    l = null;
                } else {
                    l = Long.valueOf(query.getLong(columnIndexOrThrow5));
                    i3 = columnIndexOrThrow;
                }
                Date fromTimestamp = this.__dateConverter.fromTimestamp(l);
                if (query.isNull(columnIndexOrThrow6)) {
                    l2 = null;
                } else {
                    l2 = Long.valueOf(query.getLong(columnIndexOrThrow6));
                }
                Date fromTimestamp2 = this.__dateConverter.fromTimestamp(l2);
                if (query.isNull(columnIndexOrThrow7)) {
                    l3 = null;
                } else {
                    l3 = Long.valueOf(query.getLong(columnIndexOrThrow7));
                }
                arrayList.add(new UserEntity(string, string2, string3, string4, fromTimestamp, fromTimestamp2, this.__dateConverter.fromTimestamp(l3), query.getInt(columnIndexOrThrow8) != 0, query.getInt(columnIndexOrThrow9) != 0, this.__listConverter.stringToStringList(query.getString(columnIndexOrThrow10)), this.__extraDataConverter.stringToMap(query.getString(columnIndexOrThrow11))));
                columnIndexOrThrow = i3;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<UserEntity> selectUsersLikeName(String str, int i, int i2) {
        int i3;
        Long l;
        Long l2;
        Long l3;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_user WHERE name LIKE ? ORDER BY name ASC LIMIT ? OFFSET ?", 3);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        acquire.bindLong(2, (long) i);
        acquire.bindLong(3, (long) i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "originalId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "role");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "createdAt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "lastActive");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "invisible");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "banned");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mutes");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "extraData");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow);
                String string2 = query.getString(columnIndexOrThrow2);
                String string3 = query.getString(columnIndexOrThrow3);
                String string4 = query.getString(columnIndexOrThrow4);
                if (query.isNull(columnIndexOrThrow5)) {
                    i3 = columnIndexOrThrow;
                    l = null;
                } else {
                    l = Long.valueOf(query.getLong(columnIndexOrThrow5));
                    i3 = columnIndexOrThrow;
                }
                Date fromTimestamp = this.__dateConverter.fromTimestamp(l);
                if (query.isNull(columnIndexOrThrow6)) {
                    l2 = null;
                } else {
                    l2 = Long.valueOf(query.getLong(columnIndexOrThrow6));
                }
                Date fromTimestamp2 = this.__dateConverter.fromTimestamp(l2);
                if (query.isNull(columnIndexOrThrow7)) {
                    l3 = null;
                } else {
                    l3 = Long.valueOf(query.getLong(columnIndexOrThrow7));
                }
                arrayList.add(new UserEntity(string, string2, string3, string4, fromTimestamp, fromTimestamp2, this.__dateConverter.fromTimestamp(l3), query.getInt(columnIndexOrThrow8) != 0, query.getInt(columnIndexOrThrow9) != 0, this.__listConverter.stringToStringList(query.getString(columnIndexOrThrow10)), this.__extraDataConverter.stringToMap(query.getString(columnIndexOrThrow11))));
                columnIndexOrThrow = i3;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
