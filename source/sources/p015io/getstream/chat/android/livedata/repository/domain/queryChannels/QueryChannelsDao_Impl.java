package p015io.getstream.chat.android.livedata.repository.domain.queryChannels;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.ArrayMap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.livedata.repository.database.converter.FilterObjectConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.ListConverter;
import p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao;

/* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl */
public final class QueryChannelsDao_Impl implements QueryChannelsDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final FilterObjectConverter __filterObjectConverter = new FilterObjectConverter();
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<ChannelSortInnerEntity> __insertionAdapterOfChannelSortInnerEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<QueryChannelsEntity> __insertionAdapterOfQueryChannelsEntity;
    /* access modifiers changed from: private */
    public final ListConverter __listConverter = new ListConverter();
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteSortEntitiesFor;

    public QueryChannelsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfQueryChannelsEntity = new EntityInsertionAdapter<QueryChannelsEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `stream_channel_query` (`id`,`filter`,`cids`) VALUES (?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, QueryChannelsEntity queryChannelsEntity) {
                if (queryChannelsEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, queryChannelsEntity.getId());
                }
                String objectToString = QueryChannelsDao_Impl.this.__filterObjectConverter.objectToString(queryChannelsEntity.getFilter());
                if (objectToString == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, objectToString);
                }
                String stringListToString = QueryChannelsDao_Impl.this.__listConverter.stringListToString(queryChannelsEntity.getCids());
                if (stringListToString == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, stringListToString);
                }
            }
        };
        this.__insertionAdapterOfChannelSortInnerEntity = new EntityInsertionAdapter<ChannelSortInnerEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `channel_sort_inner_entity` (`id`,`name`,`direction`,`queryId`) VALUES (?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ChannelSortInnerEntity channelSortInnerEntity) {
                if (channelSortInnerEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, channelSortInnerEntity.getId());
                }
                if (channelSortInnerEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, channelSortInnerEntity.getName());
                }
                supportSQLiteStatement.bindLong(3, (long) channelSortInnerEntity.getDirection());
                if (channelSortInnerEntity.getQueryId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, channelSortInnerEntity.getQueryId());
                }
            }
        };
        this.__preparedStmtOfDeleteSortEntitiesFor = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM channel_sort_inner_entity WHERE queryId = ?";
            }
        };
    }

    public Object insert(final QueryChannelsEntity queryChannelsEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                QueryChannelsDao_Impl.this.__db.beginTransaction();
                try {
                    QueryChannelsDao_Impl.this.__insertionAdapterOfQueryChannelsEntity.insert(queryChannelsEntity);
                    QueryChannelsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    QueryChannelsDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object insert(final List<ChannelSortInnerEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                QueryChannelsDao_Impl.this.__db.beginTransaction();
                try {
                    QueryChannelsDao_Impl.this.__insertionAdapterOfChannelSortInnerEntity.insert(list);
                    QueryChannelsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    QueryChannelsDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object insert(final QueryChannelsWithSorts queryChannelsWithSorts, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1<Continuation<? super Unit>, Object>() {
            public Object invoke(Continuation<? super Unit> continuation) {
                return QueryChannelsDao.DefaultImpls.insert(QueryChannelsDao_Impl.this, queryChannelsWithSorts, continuation);
            }
        }, continuation);
    }

    public Object deleteSortEntitiesFor(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = QueryChannelsDao_Impl.this.__preparedStmtOfDeleteSortEntitiesFor.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                QueryChannelsDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    QueryChannelsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    QueryChannelsDao_Impl.this.__db.endTransaction();
                    QueryChannelsDao_Impl.this.__preparedStmtOfDeleteSortEntitiesFor.release(acquire);
                }
            }
        }, continuation);
    }

    public Object select(String str, Continuation<? super QueryChannelsWithSorts> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_channel_query WHERE stream_channel_query.id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, true, new Callable<QueryChannelsWithSorts>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity} */
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r3v3 */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts call() throws java.lang.Exception {
                /*
                    r8 = this;
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00cc }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x00cc }
                    androidx.room.RoomSQLiteQuery r1 = r0     // Catch:{ all -> 0x00cc }
                    r2 = 1
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.query(r0, r1, r2, r3)     // Catch:{ all -> 0x00cc }
                    java.lang.String r1 = "id"
                    int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r1)     // Catch:{ all -> 0x00c2 }
                    java.lang.String r2 = "filter"
                    int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r2)     // Catch:{ all -> 0x00c2 }
                    java.lang.String r4 = "cids"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r4)     // Catch:{ all -> 0x00c2 }
                    androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00c2 }
                    r5.<init>()     // Catch:{ all -> 0x00c2 }
                L_0x002e:
                    boolean r6 = r0.moveToNext()     // Catch:{ all -> 0x00c2 }
                    if (r6 == 0) goto L_0x0049
                    java.lang.String r6 = r0.getString(r1)     // Catch:{ all -> 0x00c2 }
                    java.lang.Object r7 = r5.get(r6)     // Catch:{ all -> 0x00c2 }
                    java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x00c2 }
                    if (r7 != 0) goto L_0x002e
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00c2 }
                    r7.<init>()     // Catch:{ all -> 0x00c2 }
                    r5.put(r6, r7)     // Catch:{ all -> 0x00c2 }
                    goto L_0x002e
                L_0x0049:
                    r6 = -1
                    r0.moveToPosition(r6)     // Catch:{ all -> 0x00c2 }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00c2 }
                    r6.m1020x7bf9f349(r5)     // Catch:{ all -> 0x00c2 }
                    boolean r6 = r0.moveToFirst()     // Catch:{ all -> 0x00c2 }
                    if (r6 == 0) goto L_0x00a7
                    boolean r6 = r0.isNull(r1)     // Catch:{ all -> 0x00c2 }
                    if (r6 == 0) goto L_0x006a
                    boolean r6 = r0.isNull(r2)     // Catch:{ all -> 0x00c2 }
                    if (r6 == 0) goto L_0x006a
                    boolean r6 = r0.isNull(r4)     // Catch:{ all -> 0x00c2 }
                    if (r6 != 0) goto L_0x0090
                L_0x006a:
                    java.lang.String r3 = r0.getString(r1)     // Catch:{ all -> 0x00c2 }
                    java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x00c2 }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00c2 }
                    io.getstream.chat.android.livedata.repository.database.converter.FilterObjectConverter r6 = r6.__filterObjectConverter     // Catch:{ all -> 0x00c2 }
                    io.getstream.chat.android.client.utils.FilterObject r2 = r6.stringToObject(r2)     // Catch:{ all -> 0x00c2 }
                    java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x00c2 }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00c2 }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r6 = r6.__listConverter     // Catch:{ all -> 0x00c2 }
                    java.util.List r4 = r6.stringToStringList(r4)     // Catch:{ all -> 0x00c2 }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity r6 = new io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity     // Catch:{ all -> 0x00c2 }
                    r6.<init>(r3, r2, r4)     // Catch:{ all -> 0x00c2 }
                    r3 = r6
                L_0x0090:
                    java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x00c2 }
                    java.lang.Object r1 = r5.get(r1)     // Catch:{ all -> 0x00c2 }
                    java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x00c2 }
                    if (r1 != 0) goto L_0x00a1
                    java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00c2 }
                    r1.<init>()     // Catch:{ all -> 0x00c2 }
                L_0x00a1:
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts r2 = new io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts     // Catch:{ all -> 0x00c2 }
                    r2.<init>(r3, r1)     // Catch:{ all -> 0x00c2 }
                    r3 = r2
                L_0x00a7:
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r1 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00c2 }
                    androidx.room.RoomDatabase r1 = r1.__db     // Catch:{ all -> 0x00c2 }
                    r1.setTransactionSuccessful()     // Catch:{ all -> 0x00c2 }
                    r0.close()     // Catch:{ all -> 0x00cc }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x00cc }
                    r0.release()     // Catch:{ all -> 0x00cc }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r3
                L_0x00c2:
                    r1 = move-exception
                    r0.close()     // Catch:{ all -> 0x00cc }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x00cc }
                    r0.release()     // Catch:{ all -> 0x00cc }
                    throw r1     // Catch:{ all -> 0x00cc }
                L_0x00cc:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r1 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this
                    androidx.room.RoomDatabase r1 = r1.__db
                    r1.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.C50418.call():io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts");
            }
        }, continuation);
    }

    public Object select(List<String> list, Continuation<? super List<QueryChannelsWithSorts>> continuation) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM stream_channel_query WHERE stream_channel_query.id IN (");
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
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<QueryChannelsWithSorts>>() {
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00a7 A[Catch:{ all -> 0x00d0, all -> 0x00da }] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x00ac A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts> call() throws java.lang.Exception {
                /*
                    r11 = this;
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00da }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x00da }
                    androidx.room.RoomSQLiteQuery r1 = r0     // Catch:{ all -> 0x00da }
                    r2 = 1
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.query(r0, r1, r2, r3)     // Catch:{ all -> 0x00da }
                    java.lang.String r1 = "id"
                    int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r1)     // Catch:{ all -> 0x00d0 }
                    java.lang.String r2 = "filter"
                    int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r2)     // Catch:{ all -> 0x00d0 }
                    java.lang.String r4 = "cids"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r4)     // Catch:{ all -> 0x00d0 }
                    androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00d0 }
                    r5.<init>()     // Catch:{ all -> 0x00d0 }
                L_0x002e:
                    boolean r6 = r0.moveToNext()     // Catch:{ all -> 0x00d0 }
                    if (r6 == 0) goto L_0x0049
                    java.lang.String r6 = r0.getString(r1)     // Catch:{ all -> 0x00d0 }
                    java.lang.Object r7 = r5.get(r6)     // Catch:{ all -> 0x00d0 }
                    java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x00d0 }
                    if (r7 != 0) goto L_0x002e
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00d0 }
                    r7.<init>()     // Catch:{ all -> 0x00d0 }
                    r5.put(r6, r7)     // Catch:{ all -> 0x00d0 }
                    goto L_0x002e
                L_0x0049:
                    r6 = -1
                    r0.moveToPosition(r6)     // Catch:{ all -> 0x00d0 }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00d0 }
                    r6.m1020x7bf9f349(r5)     // Catch:{ all -> 0x00d0 }
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00d0 }
                    int r7 = r0.getCount()     // Catch:{ all -> 0x00d0 }
                    r6.<init>(r7)     // Catch:{ all -> 0x00d0 }
                L_0x005b:
                    boolean r7 = r0.moveToNext()     // Catch:{ all -> 0x00d0 }
                    if (r7 == 0) goto L_0x00b5
                    boolean r7 = r0.isNull(r1)     // Catch:{ all -> 0x00d0 }
                    if (r7 == 0) goto L_0x0076
                    boolean r7 = r0.isNull(r2)     // Catch:{ all -> 0x00d0 }
                    if (r7 == 0) goto L_0x0076
                    boolean r7 = r0.isNull(r4)     // Catch:{ all -> 0x00d0 }
                    if (r7 != 0) goto L_0x0074
                    goto L_0x0076
                L_0x0074:
                    r10 = r3
                    goto L_0x009b
                L_0x0076:
                    java.lang.String r7 = r0.getString(r1)     // Catch:{ all -> 0x00d0 }
                    java.lang.String r8 = r0.getString(r2)     // Catch:{ all -> 0x00d0 }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r9 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00d0 }
                    io.getstream.chat.android.livedata.repository.database.converter.FilterObjectConverter r9 = r9.__filterObjectConverter     // Catch:{ all -> 0x00d0 }
                    io.getstream.chat.android.client.utils.FilterObject r8 = r9.stringToObject(r8)     // Catch:{ all -> 0x00d0 }
                    java.lang.String r9 = r0.getString(r4)     // Catch:{ all -> 0x00d0 }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r10 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00d0 }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r10 = r10.__listConverter     // Catch:{ all -> 0x00d0 }
                    java.util.List r9 = r10.stringToStringList(r9)     // Catch:{ all -> 0x00d0 }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity r10 = new io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity     // Catch:{ all -> 0x00d0 }
                    r10.<init>(r7, r8, r9)     // Catch:{ all -> 0x00d0 }
                L_0x009b:
                    java.lang.String r7 = r0.getString(r1)     // Catch:{ all -> 0x00d0 }
                    java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x00d0 }
                    java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x00d0 }
                    if (r7 != 0) goto L_0x00ac
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00d0 }
                    r7.<init>()     // Catch:{ all -> 0x00d0 }
                L_0x00ac:
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts r8 = new io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts     // Catch:{ all -> 0x00d0 }
                    r8.<init>(r10, r7)     // Catch:{ all -> 0x00d0 }
                    r6.add(r8)     // Catch:{ all -> 0x00d0 }
                    goto L_0x005b
                L_0x00b5:
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r1 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this     // Catch:{ all -> 0x00d0 }
                    androidx.room.RoomDatabase r1 = r1.__db     // Catch:{ all -> 0x00d0 }
                    r1.setTransactionSuccessful()     // Catch:{ all -> 0x00d0 }
                    r0.close()     // Catch:{ all -> 0x00da }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x00da }
                    r0.release()     // Catch:{ all -> 0x00da }
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r6
                L_0x00d0:
                    r1 = move-exception
                    r0.close()     // Catch:{ all -> 0x00da }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x00da }
                    r0.release()     // Catch:{ all -> 0x00da }
                    throw r1     // Catch:{ all -> 0x00da }
                L_0x00da:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl r1 = p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.this
                    androidx.room.RoomDatabase r1 = r1.__db
                    r1.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl.C50429.call():java.util.List");
            }
        }, continuation);
    }

    /* access modifiers changed from: private */
    /* renamed from: __fetchRelationshipchannelSortInnerEntityAsioGetstreamChatAndroidLivedataRepositoryDomainQueryChannelsChannelSortInnerEntity */
    public void m1020x7bf9f349(ArrayMap<String, ArrayList<ChannelSortInnerEntity>> arrayMap) {
        String str;
        int i;
        String str2;
        int i2;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = arrayMap.size();
                int i3 = 0;
                loop0:
                while (true) {
                    i2 = 0;
                    while (i3 < size) {
                        arrayMap2.put(arrayMap.keyAt(i3), arrayMap.valueAt(i3));
                        i3++;
                        i2++;
                        if (i2 == 999) {
                            m1020x7bf9f349(arrayMap2);
                            arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        }
                    }
                    break loop0;
                }
                if (i2 > 0) {
                    m1020x7bf9f349(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `id`,`name`,`direction`,`queryId` FROM `channel_sort_inner_entity` WHERE `queryId` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i4 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i4);
                } else {
                    acquire.bindString(i4, next);
                }
                i4++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "queryId");
                if (columnIndex != -1) {
                    int columnIndex2 = CursorUtil.getColumnIndex(query, "id");
                    int columnIndex3 = CursorUtil.getColumnIndex(query, "name");
                    int columnIndex4 = CursorUtil.getColumnIndex(query, QuerySort.KEY_DIRECTION);
                    int columnIndex5 = CursorUtil.getColumnIndex(query, "queryId");
                    while (query.moveToNext()) {
                        ArrayList arrayList = arrayMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            if (columnIndex3 == -1) {
                                str = null;
                            } else {
                                str = query.getString(columnIndex3);
                            }
                            if (columnIndex4 == -1) {
                                i = 0;
                            } else {
                                i = query.getInt(columnIndex4);
                            }
                            if (columnIndex5 == -1) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndex5);
                            }
                            ChannelSortInnerEntity channelSortInnerEntity = new ChannelSortInnerEntity(str, i, str2);
                            if (columnIndex2 != -1) {
                                channelSortInnerEntity.setId(query.getString(columnIndex2));
                            }
                            arrayList.add(channelSortInnerEntity);
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
