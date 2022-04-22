package p015io.getstream.chat.android.livedata.repository.domain.syncState;

import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.livedata.repository.database.converter.DateConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.ListConverter;

/* renamed from: io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl */
public final class SyncStateDao_Impl implements SyncStateDao {
    /* access modifiers changed from: private */
    public final DateConverter __dateConverter = new DateConverter();
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<SyncStateEntity> __insertionAdapterOfSyncStateEntity;
    /* access modifiers changed from: private */
    public final ListConverter __listConverter = new ListConverter();

    public SyncStateDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSyncStateEntity = new EntityInsertionAdapter<SyncStateEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `stream_sync_state` (`userId`,`activeChannelIds`,`activeQueryIds`,`lastSyncedAt`,`markedAllReadAt`) VALUES (?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncStateEntity syncStateEntity) {
                if (syncStateEntity.getUserId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncStateEntity.getUserId());
                }
                String stringListToString = SyncStateDao_Impl.this.__listConverter.stringListToString(syncStateEntity.getActiveChannelIds());
                if (stringListToString == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, stringListToString);
                }
                String stringListToString2 = SyncStateDao_Impl.this.__listConverter.stringListToString(syncStateEntity.getActiveQueryIds());
                if (stringListToString2 == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, stringListToString2);
                }
                Long dateToTimestamp = SyncStateDao_Impl.this.__dateConverter.dateToTimestamp(syncStateEntity.getLastSyncedAt());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, dateToTimestamp.longValue());
                }
                Long dateToTimestamp2 = SyncStateDao_Impl.this.__dateConverter.dateToTimestamp(syncStateEntity.getMarkedAllReadAt());
                if (dateToTimestamp2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, dateToTimestamp2.longValue());
                }
            }
        };
    }

    public Object insert(final SyncStateEntity syncStateEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SyncStateDao_Impl.this.__db.beginTransaction();
                try {
                    SyncStateDao_Impl.this.__insertionAdapterOfSyncStateEntity.insert(syncStateEntity);
                    SyncStateDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    SyncStateDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object select(String str, Continuation<? super SyncStateEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_sync_state WHERE stream_sync_state.userId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, new Callable<SyncStateEntity>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Long} */
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r8v1, types: [io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity] */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity call() throws java.lang.Exception {
                /*
                    r14 = this;
                    io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r1 = r0
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.query(r0, r1, r2, r3)
                    java.lang.String r1 = "userId"
                    int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r1)     // Catch:{ all -> 0x0094 }
                    java.lang.String r2 = "activeChannelIds"
                    int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r2)     // Catch:{ all -> 0x0094 }
                    java.lang.String r4 = "activeQueryIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r4)     // Catch:{ all -> 0x0094 }
                    java.lang.String r5 = "lastSyncedAt"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r5)     // Catch:{ all -> 0x0094 }
                    java.lang.String r6 = "markedAllReadAt"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r6)     // Catch:{ all -> 0x0094 }
                    boolean r7 = r0.moveToFirst()     // Catch:{ all -> 0x0094 }
                    if (r7 == 0) goto L_0x008b
                    java.lang.String r9 = r0.getString(r1)     // Catch:{ all -> 0x0094 }
                    java.lang.String r1 = r0.getString(r2)     // Catch:{ all -> 0x0094 }
                    io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl.this     // Catch:{ all -> 0x0094 }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r2 = r2.__listConverter     // Catch:{ all -> 0x0094 }
                    java.util.List r10 = r2.stringToStringList(r1)     // Catch:{ all -> 0x0094 }
                    java.lang.String r1 = r0.getString(r4)     // Catch:{ all -> 0x0094 }
                    io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl.this     // Catch:{ all -> 0x0094 }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r2 = r2.__listConverter     // Catch:{ all -> 0x0094 }
                    java.util.List r11 = r2.stringToStringList(r1)     // Catch:{ all -> 0x0094 }
                    boolean r1 = r0.isNull(r5)     // Catch:{ all -> 0x0094 }
                    if (r1 == 0) goto L_0x005a
                    r1 = r3
                    goto L_0x0062
                L_0x005a:
                    long r1 = r0.getLong(r5)     // Catch:{ all -> 0x0094 }
                    java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0094 }
                L_0x0062:
                    io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl.this     // Catch:{ all -> 0x0094 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r2 = r2.__dateConverter     // Catch:{ all -> 0x0094 }
                    java.util.Date r12 = r2.fromTimestamp(r1)     // Catch:{ all -> 0x0094 }
                    boolean r1 = r0.isNull(r6)     // Catch:{ all -> 0x0094 }
                    if (r1 == 0) goto L_0x0073
                    goto L_0x007b
                L_0x0073:
                    long r1 = r0.getLong(r6)     // Catch:{ all -> 0x0094 }
                    java.lang.Long r3 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0094 }
                L_0x007b:
                    io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl r1 = p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl.this     // Catch:{ all -> 0x0094 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r1 = r1.__dateConverter     // Catch:{ all -> 0x0094 }
                    java.util.Date r13 = r1.fromTimestamp(r3)     // Catch:{ all -> 0x0094 }
                    io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity r3 = new io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity     // Catch:{ all -> 0x0094 }
                    r8 = r3
                    r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0094 }
                L_0x008b:
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    return r3
                L_0x0094:
                    r1 = move-exception
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl.C50513.call():io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity");
            }
        }, continuation);
    }
}
