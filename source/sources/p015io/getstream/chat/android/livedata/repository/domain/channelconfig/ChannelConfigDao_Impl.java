package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.ArrayMap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import p015io.getstream.chat.android.livedata.repository.database.converter.DateConverter;

/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl */
public final class ChannelConfigDao_Impl extends ChannelConfigDao {
    /* access modifiers changed from: private */
    public final DateConverter __dateConverter = new DateConverter();
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<ChannelConfigInnerEntity> __insertionAdapterOfChannelConfigInnerEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<CommandInnerEntity> __insertionAdapterOfCommandInnerEntity;

    public ChannelConfigDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfChannelConfigInnerEntity = new EntityInsertionAdapter<ChannelConfigInnerEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `stream_chat_channel_config` (`channelType`,`createdAt`,`updatedAt`,`isTypingEvents`,`isReadEvents`,`isConnectEvents`,`isSearch`,`isReactionsEnabled`,`isRepliesEnabled`,`isMutes`,`maxMessageLength`,`automod`,`infinite`,`name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ChannelConfigInnerEntity channelConfigInnerEntity) {
                if (channelConfigInnerEntity.getChannelType() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, channelConfigInnerEntity.getChannelType());
                }
                Long dateToTimestamp = ChannelConfigDao_Impl.this.__dateConverter.dateToTimestamp(channelConfigInnerEntity.getCreatedAt());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, dateToTimestamp.longValue());
                }
                Long dateToTimestamp2 = ChannelConfigDao_Impl.this.__dateConverter.dateToTimestamp(channelConfigInnerEntity.getUpdatedAt());
                if (dateToTimestamp2 == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, dateToTimestamp2.longValue());
                }
                supportSQLiteStatement.bindLong(4, channelConfigInnerEntity.isTypingEvents() ? 1 : 0);
                supportSQLiteStatement.bindLong(5, channelConfigInnerEntity.isReadEvents() ? 1 : 0);
                supportSQLiteStatement.bindLong(6, channelConfigInnerEntity.isConnectEvents() ? 1 : 0);
                supportSQLiteStatement.bindLong(7, channelConfigInnerEntity.isSearch() ? 1 : 0);
                supportSQLiteStatement.bindLong(8, channelConfigInnerEntity.isReactionsEnabled() ? 1 : 0);
                supportSQLiteStatement.bindLong(9, channelConfigInnerEntity.isRepliesEnabled() ? 1 : 0);
                supportSQLiteStatement.bindLong(10, channelConfigInnerEntity.isMutes() ? 1 : 0);
                supportSQLiteStatement.bindLong(11, (long) channelConfigInnerEntity.getMaxMessageLength());
                if (channelConfigInnerEntity.getAutomod() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, channelConfigInnerEntity.getAutomod());
                }
                if (channelConfigInnerEntity.getInfinite() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, channelConfigInnerEntity.getInfinite());
                }
                if (channelConfigInnerEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, channelConfigInnerEntity.getName());
                }
            }
        };
        this.__insertionAdapterOfCommandInnerEntity = new EntityInsertionAdapter<CommandInnerEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `command_inner_entity` (`id`,`name`,`description`,`args`,`set`,`channelType`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, CommandInnerEntity commandInnerEntity) {
                supportSQLiteStatement.bindLong(1, (long) commandInnerEntity.getId());
                if (commandInnerEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, commandInnerEntity.getName());
                }
                if (commandInnerEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, commandInnerEntity.getDescription());
                }
                if (commandInnerEntity.getArgs() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, commandInnerEntity.getArgs());
                }
                if (commandInnerEntity.getSet() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, commandInnerEntity.getSet());
                }
                if (commandInnerEntity.getChannelType() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, commandInnerEntity.getChannelType());
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public Object insertConfig(final ChannelConfigInnerEntity channelConfigInnerEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                ChannelConfigDao_Impl.this.__db.beginTransaction();
                try {
                    ChannelConfigDao_Impl.this.__insertionAdapterOfChannelConfigInnerEntity.insert(channelConfigInnerEntity);
                    ChannelConfigDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelConfigDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* access modifiers changed from: protected */
    public Object insertConfigs(final List<ChannelConfigInnerEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                ChannelConfigDao_Impl.this.__db.beginTransaction();
                try {
                    ChannelConfigDao_Impl.this.__insertionAdapterOfChannelConfigInnerEntity.insert(list);
                    ChannelConfigDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelConfigDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* access modifiers changed from: protected */
    public Object insertCommands(final List<CommandInnerEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                ChannelConfigDao_Impl.this.__db.beginTransaction();
                try {
                    ChannelConfigDao_Impl.this.__insertionAdapterOfCommandInnerEntity.insert(list);
                    ChannelConfigDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ChannelConfigDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object insert(final ChannelConfigEntity channelConfigEntity, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1<Continuation<? super Unit>, Object>() {
            public Object invoke(Continuation<? super Unit> continuation) {
                return ChannelConfigDao_Impl.super.insert(channelConfigEntity, continuation);
            }
        }, continuation);
    }

    public Object selectAll(Continuation<? super List<ChannelConfigEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_channel_config LIMIT 100", 0);
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<ChannelConfigEntity>>() {
            /* JADX WARNING: Removed duplicated region for block: B:107:0x01e7 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0131 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x0137 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0155 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x0157 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x0170 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x0173 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x017b A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x017e A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x0186 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0189 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x0191 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0194 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x019c A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x019f A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:79:0x01a7 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x01aa A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:83:0x01b2 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x01b5 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x01e2 A[Catch:{ all -> 0x021d, all -> 0x0227 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity> call() throws java.lang.Exception {
                /*
                    r35 = this;
                    r1 = r35
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.this     // Catch:{ all -> 0x0227 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x0227 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x0227 }
                    r3 = 0
                    r4 = 1
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r4, r3)     // Catch:{ all -> 0x0227 }
                    java.lang.String r0 = "channelType"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x021d }
                    java.lang.String r5 = "createdAt"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x021d }
                    java.lang.String r6 = "updatedAt"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x021d }
                    java.lang.String r7 = "isTypingEvents"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x021d }
                    java.lang.String r8 = "isReadEvents"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x021d }
                    java.lang.String r9 = "isConnectEvents"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x021d }
                    java.lang.String r10 = "isSearch"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x021d }
                    java.lang.String r11 = "isReactionsEnabled"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x021d }
                    java.lang.String r12 = "isRepliesEnabled"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x021d }
                    java.lang.String r13 = "isMutes"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x021d }
                    java.lang.String r14 = "maxMessageLength"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x021d }
                    java.lang.String r15 = "automod"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x021d }
                    java.lang.String r3 = "infinite"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x021d }
                    java.lang.String r4 = "name"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x021d }
                    r16 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x021d }
                    r4.<init>()     // Catch:{ all -> 0x021d }
                L_0x0074:
                    boolean r17 = r2.moveToNext()     // Catch:{ all -> 0x021d }
                    if (r17 == 0) goto L_0x009a
                    r17 = r3
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x021d }
                    java.lang.Object r18 = r4.get(r3)     // Catch:{ all -> 0x021d }
                    java.util.ArrayList r18 = (java.util.ArrayList) r18     // Catch:{ all -> 0x021d }
                    if (r18 != 0) goto L_0x0093
                    r18 = r15
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x021d }
                    r15.<init>()     // Catch:{ all -> 0x021d }
                    r4.put(r3, r15)     // Catch:{ all -> 0x021d }
                    goto L_0x0095
                L_0x0093:
                    r18 = r15
                L_0x0095:
                    r3 = r17
                    r15 = r18
                    goto L_0x0074
                L_0x009a:
                    r17 = r3
                    r18 = r15
                    r3 = -1
                    r2.moveToPosition(r3)     // Catch:{ all -> 0x021d }
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.this     // Catch:{ all -> 0x021d }
                    r3.m1017x1ccbd816(r4)     // Catch:{ all -> 0x021d }
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x021d }
                    int r15 = r2.getCount()     // Catch:{ all -> 0x021d }
                    r3.<init>(r15)     // Catch:{ all -> 0x021d }
                L_0x00b0:
                    boolean r15 = r2.moveToNext()     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x0201
                    boolean r15 = r2.isNull(r0)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r5)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r6)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r7)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r8)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r9)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r10)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r11)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r12)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r13)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    boolean r15 = r2.isNull(r14)     // Catch:{ all -> 0x021d }
                    if (r15 == 0) goto L_0x011d
                    r15 = r18
                    boolean r18 = r2.isNull(r15)     // Catch:{ all -> 0x021d }
                    if (r18 == 0) goto L_0x011f
                    r18 = r3
                    r3 = r17
                    boolean r17 = r2.isNull(r3)     // Catch:{ all -> 0x021d }
                    if (r17 == 0) goto L_0x0123
                    r17 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x021d }
                    if (r16 != 0) goto L_0x0115
                    goto L_0x0127
                L_0x0115:
                    r16 = r3
                    r34 = r5
                    r5 = r0
                    r0 = 0
                    goto L_0x01d2
                L_0x011d:
                    r15 = r18
                L_0x011f:
                    r18 = r3
                    r3 = r17
                L_0x0123:
                    r17 = r4
                    r4 = r16
                L_0x0127:
                    java.lang.String r20 = r2.getString(r0)     // Catch:{ all -> 0x021d }
                    boolean r16 = r2.isNull(r5)     // Catch:{ all -> 0x021d }
                    if (r16 == 0) goto L_0x0137
                    r16 = r0
                    r34 = r5
                    r5 = 0
                    goto L_0x0145
                L_0x0137:
                    long r21 = r2.getLong(r5)     // Catch:{ all -> 0x021d }
                    java.lang.Long r16 = java.lang.Long.valueOf(r21)     // Catch:{ all -> 0x021d }
                    r34 = r5
                    r5 = r16
                    r16 = r0
                L_0x0145:
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.this     // Catch:{ all -> 0x021d }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r0 = r0.__dateConverter     // Catch:{ all -> 0x021d }
                    java.util.Date r21 = r0.fromTimestamp(r5)     // Catch:{ all -> 0x021d }
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x021d }
                    if (r0 == 0) goto L_0x0157
                    r0 = 0
                    goto L_0x015f
                L_0x0157:
                    long r22 = r2.getLong(r6)     // Catch:{ all -> 0x021d }
                    java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x021d }
                L_0x015f:
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl r5 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.this     // Catch:{ all -> 0x021d }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r5 = r5.__dateConverter     // Catch:{ all -> 0x021d }
                    java.util.Date r22 = r5.fromTimestamp(r0)     // Catch:{ all -> 0x021d }
                    int r0 = r2.getInt(r7)     // Catch:{ all -> 0x021d }
                    r5 = 0
                    if (r0 == 0) goto L_0x0173
                    r23 = 1
                    goto L_0x0175
                L_0x0173:
                    r23 = 0
                L_0x0175:
                    int r0 = r2.getInt(r8)     // Catch:{ all -> 0x021d }
                    if (r0 == 0) goto L_0x017e
                    r24 = 1
                    goto L_0x0180
                L_0x017e:
                    r24 = 0
                L_0x0180:
                    int r0 = r2.getInt(r9)     // Catch:{ all -> 0x021d }
                    if (r0 == 0) goto L_0x0189
                    r25 = 1
                    goto L_0x018b
                L_0x0189:
                    r25 = 0
                L_0x018b:
                    int r0 = r2.getInt(r10)     // Catch:{ all -> 0x021d }
                    if (r0 == 0) goto L_0x0194
                    r26 = 1
                    goto L_0x0196
                L_0x0194:
                    r26 = 0
                L_0x0196:
                    int r0 = r2.getInt(r11)     // Catch:{ all -> 0x021d }
                    if (r0 == 0) goto L_0x019f
                    r27 = 1
                    goto L_0x01a1
                L_0x019f:
                    r27 = 0
                L_0x01a1:
                    int r0 = r2.getInt(r12)     // Catch:{ all -> 0x021d }
                    if (r0 == 0) goto L_0x01aa
                    r28 = 1
                    goto L_0x01ac
                L_0x01aa:
                    r28 = 0
                L_0x01ac:
                    int r0 = r2.getInt(r13)     // Catch:{ all -> 0x021d }
                    if (r0 == 0) goto L_0x01b5
                    r29 = 1
                    goto L_0x01b7
                L_0x01b5:
                    r29 = 0
                L_0x01b7:
                    int r30 = r2.getInt(r14)     // Catch:{ all -> 0x021d }
                    java.lang.String r31 = r2.getString(r15)     // Catch:{ all -> 0x021d }
                    java.lang.String r32 = r2.getString(r3)     // Catch:{ all -> 0x021d }
                    java.lang.String r33 = r2.getString(r4)     // Catch:{ all -> 0x021d }
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigInnerEntity r0 = new io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigInnerEntity     // Catch:{ all -> 0x021d }
                    r19 = r0
                    r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x021d }
                    r5 = r16
                    r16 = r3
                L_0x01d2:
                    java.lang.String r3 = r2.getString(r5)     // Catch:{ all -> 0x021d }
                    r19 = r4
                    r4 = r17
                    java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x021d }
                    java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x021d }
                    if (r3 != 0) goto L_0x01e7
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x021d }
                    r3.<init>()     // Catch:{ all -> 0x021d }
                L_0x01e7:
                    r17 = r4
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity r4 = new io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity     // Catch:{ all -> 0x021d }
                    r4.<init>(r0, r3)     // Catch:{ all -> 0x021d }
                    r0 = r18
                    r0.add(r4)     // Catch:{ all -> 0x021d }
                    r3 = r0
                    r0 = r5
                    r18 = r15
                    r4 = r17
                    r5 = r34
                    r17 = r16
                    r16 = r19
                    goto L_0x00b0
                L_0x0201:
                    r0 = r3
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.this     // Catch:{ all -> 0x021d }
                    androidx.room.RoomDatabase r3 = r3.__db     // Catch:{ all -> 0x021d }
                    r3.setTransactionSuccessful()     // Catch:{ all -> 0x021d }
                    r2.close()     // Catch:{ all -> 0x0227 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x0227 }
                    r2.release()     // Catch:{ all -> 0x0227 }
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    return r0
                L_0x021d:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x0227 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x0227 }
                    r2.release()     // Catch:{ all -> 0x0227 }
                    throw r0     // Catch:{ all -> 0x0227 }
                L_0x0227:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl.C50127.call():java.util.List");
            }
        }, continuation);
    }

    /* access modifiers changed from: private */
    /* renamed from: __fetchRelationshipcommandInnerEntityAsioGetstreamChatAndroidLivedataRepositoryDomainChannelconfigCommandInnerEntity */
    public void m1017x1ccbd816(ArrayMap<String, ArrayList<CommandInnerEntity>> arrayMap) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        ArrayMap<String, ArrayList<CommandInnerEntity>> arrayMap2 = arrayMap;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap3 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = arrayMap.size();
                int i2 = 0;
                loop0:
                while (true) {
                    i = 0;
                    while (i2 < size) {
                        arrayMap3.put(arrayMap2.keyAt(i2), arrayMap2.valueAt(i2));
                        i2++;
                        i++;
                        if (i == 999) {
                            m1017x1ccbd816(arrayMap3);
                            arrayMap3 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        }
                    }
                    break loop0;
                }
                if (i > 0) {
                    m1017x1ccbd816(arrayMap3);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `id`,`name`,`description`,`args`,`set`,`channelType` FROM `command_inner_entity` WHERE `channelType` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, next);
                }
                i3++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "channelType");
                if (columnIndex != -1) {
                    int columnIndex2 = CursorUtil.getColumnIndex(query, "id");
                    int columnIndex3 = CursorUtil.getColumnIndex(query, "name");
                    int columnIndex4 = CursorUtil.getColumnIndex(query, "description");
                    int columnIndex5 = CursorUtil.getColumnIndex(query, "args");
                    int columnIndex6 = CursorUtil.getColumnIndex(query, "set");
                    int columnIndex7 = CursorUtil.getColumnIndex(query, "channelType");
                    while (query.moveToNext()) {
                        ArrayList arrayList = arrayMap2.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            if (columnIndex3 == -1) {
                                str = null;
                            } else {
                                str = query.getString(columnIndex3);
                            }
                            if (columnIndex4 == -1) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndex4);
                            }
                            if (columnIndex5 == -1) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndex5);
                            }
                            if (columnIndex6 == -1) {
                                str4 = null;
                            } else {
                                str4 = query.getString(columnIndex6);
                            }
                            if (columnIndex7 == -1) {
                                str5 = null;
                            } else {
                                str5 = query.getString(columnIndex7);
                            }
                            CommandInnerEntity commandInnerEntity = new CommandInnerEntity(str, str2, str3, str4, str5);
                            if (columnIndex2 != -1) {
                                commandInnerEntity.setId(query.getInt(columnIndex2));
                            }
                            arrayList.add(commandInnerEntity);
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }
}
