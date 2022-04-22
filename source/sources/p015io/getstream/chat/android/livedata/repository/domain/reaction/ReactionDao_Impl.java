package p015io.getstream.chat.android.livedata.repository.domain.reaction;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.livedata.repository.database.converter.DateConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter;

/* renamed from: io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao_Impl */
public final class ReactionDao_Impl implements ReactionDao {
    /* access modifiers changed from: private */
    public final DateConverter __dateConverter = new DateConverter();
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final ExtraDataConverter __extraDataConverter = new ExtraDataConverter();
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<ReactionEntity> __insertionAdapterOfReactionEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfSetDeleteAt;
    /* access modifiers changed from: private */
    public final SyncStatusConverter __syncStatusConverter = new SyncStatusConverter();

    public ReactionDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfReactionEntity = new EntityInsertionAdapter<ReactionEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `stream_chat_reaction` (`id`,`messageId`,`userId`,`type`,`score`,`createdAt`,`updatedAt`,`deletedAt`,`enforceUnique`,`extraData`,`syncStatus`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ReactionEntity reactionEntity) {
                supportSQLiteStatement.bindLong(1, (long) reactionEntity.getId());
                if (reactionEntity.getMessageId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, reactionEntity.getMessageId());
                }
                if (reactionEntity.getUserId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, reactionEntity.getUserId());
                }
                if (reactionEntity.getType() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, reactionEntity.getType());
                }
                supportSQLiteStatement.bindLong(5, (long) reactionEntity.getScore());
                Long dateToTimestamp = ReactionDao_Impl.this.__dateConverter.dateToTimestamp(reactionEntity.getCreatedAt());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, dateToTimestamp.longValue());
                }
                Long dateToTimestamp2 = ReactionDao_Impl.this.__dateConverter.dateToTimestamp(reactionEntity.getUpdatedAt());
                if (dateToTimestamp2 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, dateToTimestamp2.longValue());
                }
                Long dateToTimestamp3 = ReactionDao_Impl.this.__dateConverter.dateToTimestamp(reactionEntity.getDeletedAt());
                if (dateToTimestamp3 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, dateToTimestamp3.longValue());
                }
                supportSQLiteStatement.bindLong(9, reactionEntity.getEnforceUnique() ? 1 : 0);
                String mapToString = ReactionDao_Impl.this.__extraDataConverter.mapToString(reactionEntity.getExtraData());
                if (mapToString == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, mapToString);
                }
                supportSQLiteStatement.bindLong(11, (long) ReactionDao_Impl.this.__syncStatusConverter.syncStatusToString(reactionEntity.getSyncStatus()));
            }
        };
        this.__preparedStmtOfSetDeleteAt = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE stream_chat_reaction SET deletedAt = ? WHERE userId = ? AND messageId = ?";
            }
        };
    }

    public Object insert(final ReactionEntity reactionEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                ReactionDao_Impl.this.__db.beginTransaction();
                try {
                    ReactionDao_Impl.this.__insertionAdapterOfReactionEntity.insert(reactionEntity);
                    ReactionDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ReactionDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object setDeleteAt(final String str, final String str2, final Date date, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = ReactionDao_Impl.this.__preparedStmtOfSetDeleteAt.acquire();
                Long dateToTimestamp = ReactionDao_Impl.this.__dateConverter.dateToTimestamp(date);
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
                String str2 = str2;
                if (str2 == null) {
                    acquire.bindNull(3);
                } else {
                    acquire.bindString(3, str2);
                }
                ReactionDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    ReactionDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ReactionDao_Impl.this.__db.endTransaction();
                    ReactionDao_Impl.this.__preparedStmtOfSetDeleteAt.release(acquire);
                }
            }
        }, continuation);
    }

    public Object selectSyncNeeded(SyncStatus syncStatus, Continuation<? super List<ReactionEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_reaction WHERE stream_chat_reaction.syncStatus IN (?)", 1);
        acquire.bindLong(1, (long) this.__syncStatusConverter.syncStatusToString(syncStatus));
        return CoroutinesRoom.execute(this.__db, false, new Callable<List<ReactionEntity>>() {
            public List<ReactionEntity> call() throws Exception {
                Long l;
                Long l2;
                Long l3;
                Long l4 = null;
                Cursor query = DBUtil.query(ReactionDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, TagPeopleActivity.USER_ID);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "type");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Param.SCORE);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "createdAt");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deletedAt");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "enforceUnique");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "extraData");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "syncStatus");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow2);
                        String string2 = query.getString(columnIndexOrThrow3);
                        String string3 = query.getString(columnIndexOrThrow4);
                        int i = query.getInt(columnIndexOrThrow5);
                        if (query.isNull(columnIndexOrThrow6)) {
                            l = l4;
                        } else {
                            l = Long.valueOf(query.getLong(columnIndexOrThrow6));
                        }
                        Date fromTimestamp = ReactionDao_Impl.this.__dateConverter.fromTimestamp(l);
                        if (query.isNull(columnIndexOrThrow7)) {
                            l2 = null;
                        } else {
                            l2 = Long.valueOf(query.getLong(columnIndexOrThrow7));
                        }
                        Date fromTimestamp2 = ReactionDao_Impl.this.__dateConverter.fromTimestamp(l2);
                        if (query.isNull(columnIndexOrThrow8)) {
                            l3 = null;
                        } else {
                            l3 = Long.valueOf(query.getLong(columnIndexOrThrow8));
                        }
                        ReactionEntity reactionEntity = new ReactionEntity(string, string2, string3, i, fromTimestamp, fromTimestamp2, ReactionDao_Impl.this.__dateConverter.fromTimestamp(l3), query.getInt(columnIndexOrThrow9) != 0, ReactionDao_Impl.this.__extraDataConverter.stringToMap(query.getString(columnIndexOrThrow10)), ReactionDao_Impl.this.__syncStatusConverter.stringToSyncStatus(query.getInt(columnIndexOrThrow11)));
                        reactionEntity.setId(query.getInt(columnIndexOrThrow));
                        arrayList.add(reactionEntity);
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

    public Object selectUserReactionsToMessage(String str, String str2, Continuation<? super List<ReactionEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_reaction WHERE stream_chat_reaction.messageid = ? AND userId = ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        return CoroutinesRoom.execute(this.__db, false, new Callable<List<ReactionEntity>>() {
            public List<ReactionEntity> call() throws Exception {
                Long l;
                Long l2;
                Long l3;
                Long l4 = null;
                Cursor query = DBUtil.query(ReactionDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, TagPeopleActivity.USER_ID);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "type");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Param.SCORE);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "createdAt");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "updatedAt");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "deletedAt");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "enforceUnique");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "extraData");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "syncStatus");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow2);
                        String string2 = query.getString(columnIndexOrThrow3);
                        String string3 = query.getString(columnIndexOrThrow4);
                        int i = query.getInt(columnIndexOrThrow5);
                        if (query.isNull(columnIndexOrThrow6)) {
                            l = l4;
                        } else {
                            l = Long.valueOf(query.getLong(columnIndexOrThrow6));
                        }
                        Date fromTimestamp = ReactionDao_Impl.this.__dateConverter.fromTimestamp(l);
                        if (query.isNull(columnIndexOrThrow7)) {
                            l2 = null;
                        } else {
                            l2 = Long.valueOf(query.getLong(columnIndexOrThrow7));
                        }
                        Date fromTimestamp2 = ReactionDao_Impl.this.__dateConverter.fromTimestamp(l2);
                        if (query.isNull(columnIndexOrThrow8)) {
                            l3 = null;
                        } else {
                            l3 = Long.valueOf(query.getLong(columnIndexOrThrow8));
                        }
                        ReactionEntity reactionEntity = new ReactionEntity(string, string2, string3, i, fromTimestamp, fromTimestamp2, ReactionDao_Impl.this.__dateConverter.fromTimestamp(l3), query.getInt(columnIndexOrThrow9) != 0, ReactionDao_Impl.this.__extraDataConverter.stringToMap(query.getString(columnIndexOrThrow10)), ReactionDao_Impl.this.__syncStatusConverter.stringToSyncStatus(query.getInt(columnIndexOrThrow11)));
                        reactionEntity.setId(query.getInt(columnIndexOrThrow));
                        arrayList.add(reactionEntity);
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
}
