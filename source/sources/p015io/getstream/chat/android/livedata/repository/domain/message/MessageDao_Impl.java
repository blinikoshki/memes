package p015io.getstream.chat.android.livedata.repository.domain.message;

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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.livedata.repository.database.converter.DateConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.ListConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.MapConverter;
import p015io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter;
import p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity;
import p015io.getstream.chat.android.livedata.repository.domain.message.attachment.UploadStateEntity;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity;

/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl */
public final class MessageDao_Impl extends MessageDao {
    /* access modifiers changed from: private */
    public final DateConverter __dateConverter = new DateConverter();
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final ExtraDataConverter __extraDataConverter = new ExtraDataConverter();
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<AttachmentEntity> __insertionAdapterOfAttachmentEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<MessageInnerEntity> __insertionAdapterOfMessageInnerEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<ReactionEntity> __insertionAdapterOfReactionEntity;
    /* access modifiers changed from: private */
    public final ListConverter __listConverter = new ListConverter();
    /* access modifiers changed from: private */
    public final MapConverter __mapConverter = new MapConverter();
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteChannelMessagesBefore;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteMessage;
    /* access modifiers changed from: private */
    public final SyncStatusConverter __syncStatusConverter = new SyncStatusConverter();

    public MessageDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMessageInnerEntity = new EntityInsertionAdapter<MessageInnerEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `stream_chat_message` (`id`,`cid`,`userId`,`text`,`type`,`syncStatus`,`replyCount`,`createdAt`,`createdLocallyAt`,`updatedAt`,`updatedLocallyAt`,`deletedAt`,`mentionedUsersId`,`reactionCounts`,`reactionScores`,`parentId`,`command`,`shadowed`,`extraData`,`replyToId`,`threadParticipantsIds`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageInnerEntity messageInnerEntity) {
                if (messageInnerEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, messageInnerEntity.getId());
                }
                if (messageInnerEntity.getCid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, messageInnerEntity.getCid());
                }
                if (messageInnerEntity.getUserId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, messageInnerEntity.getUserId());
                }
                if (messageInnerEntity.getText() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, messageInnerEntity.getText());
                }
                if (messageInnerEntity.getType() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, messageInnerEntity.getType());
                }
                supportSQLiteStatement.bindLong(6, (long) MessageDao_Impl.this.__syncStatusConverter.syncStatusToString(messageInnerEntity.getSyncStatus()));
                supportSQLiteStatement.bindLong(7, (long) messageInnerEntity.getReplyCount());
                Long dateToTimestamp = MessageDao_Impl.this.__dateConverter.dateToTimestamp(messageInnerEntity.getCreatedAt());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, dateToTimestamp.longValue());
                }
                Long dateToTimestamp2 = MessageDao_Impl.this.__dateConverter.dateToTimestamp(messageInnerEntity.getCreatedLocallyAt());
                if (dateToTimestamp2 == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, dateToTimestamp2.longValue());
                }
                Long dateToTimestamp3 = MessageDao_Impl.this.__dateConverter.dateToTimestamp(messageInnerEntity.getUpdatedAt());
                if (dateToTimestamp3 == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, dateToTimestamp3.longValue());
                }
                Long dateToTimestamp4 = MessageDao_Impl.this.__dateConverter.dateToTimestamp(messageInnerEntity.getUpdatedLocallyAt());
                if (dateToTimestamp4 == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, dateToTimestamp4.longValue());
                }
                Long dateToTimestamp5 = MessageDao_Impl.this.__dateConverter.dateToTimestamp(messageInnerEntity.getDeletedAt());
                if (dateToTimestamp5 == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, dateToTimestamp5.longValue());
                }
                String stringListToString = MessageDao_Impl.this.__listConverter.stringListToString(messageInnerEntity.getMentionedUsersId());
                if (stringListToString == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, stringListToString);
                }
                String mapToString = MessageDao_Impl.this.__mapConverter.mapToString(messageInnerEntity.getReactionCounts());
                if (mapToString == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, mapToString);
                }
                String mapToString2 = MessageDao_Impl.this.__mapConverter.mapToString(messageInnerEntity.getReactionScores());
                if (mapToString2 == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, mapToString2);
                }
                if (messageInnerEntity.getParentId() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, messageInnerEntity.getParentId());
                }
                if (messageInnerEntity.getCommand() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, messageInnerEntity.getCommand());
                }
                supportSQLiteStatement.bindLong(18, messageInnerEntity.getShadowed() ? 1 : 0);
                String mapToString3 = MessageDao_Impl.this.__extraDataConverter.mapToString(messageInnerEntity.getExtraData());
                if (mapToString3 == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, mapToString3);
                }
                if (messageInnerEntity.getReplyToId() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, messageInnerEntity.getReplyToId());
                }
                String stringListToString2 = MessageDao_Impl.this.__listConverter.stringListToString(messageInnerEntity.getThreadParticipantsIds());
                if (stringListToString2 == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, stringListToString2);
                }
            }
        };
        this.__insertionAdapterOfAttachmentEntity = new EntityInsertionAdapter<AttachmentEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `attachment_inner_entity` (`id`,`messageId`,`authorName`,`titleLink`,`thumbUrl`,`imageUrl`,`assetUrl`,`ogUrl`,`mimeType`,`fileSize`,`title`,`text`,`type`,`image`,`url`,`name`,`fallback`,`uploadFilePath`,`extraData`,`statusCode`,`errorMessage`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, AttachmentEntity attachmentEntity) {
                supportSQLiteStatement.bindLong(1, (long) attachmentEntity.getId());
                if (attachmentEntity.getMessageId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, attachmentEntity.getMessageId());
                }
                if (attachmentEntity.getAuthorName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, attachmentEntity.getAuthorName());
                }
                if (attachmentEntity.getTitleLink() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, attachmentEntity.getTitleLink());
                }
                if (attachmentEntity.getThumbUrl() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, attachmentEntity.getThumbUrl());
                }
                if (attachmentEntity.getImageUrl() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, attachmentEntity.getImageUrl());
                }
                if (attachmentEntity.getAssetUrl() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, attachmentEntity.getAssetUrl());
                }
                if (attachmentEntity.getOgUrl() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, attachmentEntity.getOgUrl());
                }
                if (attachmentEntity.getMimeType() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, attachmentEntity.getMimeType());
                }
                supportSQLiteStatement.bindLong(10, (long) attachmentEntity.getFileSize());
                if (attachmentEntity.getTitle() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, attachmentEntity.getTitle());
                }
                if (attachmentEntity.getText() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, attachmentEntity.getText());
                }
                if (attachmentEntity.getType() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, attachmentEntity.getType());
                }
                if (attachmentEntity.getImage() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, attachmentEntity.getImage());
                }
                if (attachmentEntity.getUrl() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, attachmentEntity.getUrl());
                }
                if (attachmentEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, attachmentEntity.getName());
                }
                if (attachmentEntity.getFallback() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, attachmentEntity.getFallback());
                }
                if (attachmentEntity.getUploadFilePath() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, attachmentEntity.getUploadFilePath());
                }
                String mapToString = MessageDao_Impl.this.__extraDataConverter.mapToString(attachmentEntity.getExtraData());
                if (mapToString == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, mapToString);
                }
                UploadStateEntity uploadState = attachmentEntity.getUploadState();
                if (uploadState != null) {
                    supportSQLiteStatement.bindLong(20, (long) uploadState.getStatusCode());
                    if (uploadState.getErrorMessage() == null) {
                        supportSQLiteStatement.bindNull(21);
                    } else {
                        supportSQLiteStatement.bindString(21, uploadState.getErrorMessage());
                    }
                } else {
                    supportSQLiteStatement.bindNull(20);
                    supportSQLiteStatement.bindNull(21);
                }
            }
        };
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
                Long dateToTimestamp = MessageDao_Impl.this.__dateConverter.dateToTimestamp(reactionEntity.getCreatedAt());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, dateToTimestamp.longValue());
                }
                Long dateToTimestamp2 = MessageDao_Impl.this.__dateConverter.dateToTimestamp(reactionEntity.getUpdatedAt());
                if (dateToTimestamp2 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, dateToTimestamp2.longValue());
                }
                Long dateToTimestamp3 = MessageDao_Impl.this.__dateConverter.dateToTimestamp(reactionEntity.getDeletedAt());
                if (dateToTimestamp3 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, dateToTimestamp3.longValue());
                }
                supportSQLiteStatement.bindLong(9, reactionEntity.getEnforceUnique() ? 1 : 0);
                String mapToString = MessageDao_Impl.this.__extraDataConverter.mapToString(reactionEntity.getExtraData());
                if (mapToString == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, mapToString);
                }
                supportSQLiteStatement.bindLong(11, (long) MessageDao_Impl.this.__syncStatusConverter.syncStatusToString(reactionEntity.getSyncStatus()));
            }
        };
        this.__preparedStmtOfDeleteChannelMessagesBefore = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE from stream_chat_message WHERE cid = ? AND createdAt < ?";
            }
        };
        this.__preparedStmtOfDeleteMessage = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE from stream_chat_message WHERE cid = ? AND id = ?";
            }
        };
    }

    /* access modifiers changed from: protected */
    public Object insertMessageInnerEntity(final MessageInnerEntity messageInnerEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    MessageDao_Impl.this.__insertionAdapterOfMessageInnerEntity.insert(messageInnerEntity);
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* access modifiers changed from: protected */
    public Object insertMessageInnerEntities(final List<MessageInnerEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    MessageDao_Impl.this.__insertionAdapterOfMessageInnerEntity.insert(list);
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* access modifiers changed from: protected */
    public Object insertAttachments(final List<AttachmentEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    MessageDao_Impl.this.__insertionAdapterOfAttachmentEntity.insert(list);
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* access modifiers changed from: protected */
    public Object insertReactions(final List<ReactionEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    MessageDao_Impl.this.__insertionAdapterOfReactionEntity.insert(list);
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object insert(final List<MessageEntity> list, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1<Continuation<? super Unit>, Object>() {
            public Object invoke(Continuation<? super Unit> continuation) {
                return MessageDao_Impl.super.insert((List<MessageEntity>) list, continuation);
            }
        }, continuation);
    }

    public Object insert(final MessageEntity messageEntity, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1<Continuation<? super Unit>, Object>() {
            public Object invoke(Continuation<? super Unit> continuation) {
                return MessageDao_Impl.super.insert(messageEntity, continuation);
            }
        }, continuation);
    }

    public Object deleteChannelMessagesBefore(final String str, final Date date, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = MessageDao_Impl.this.__preparedStmtOfDeleteChannelMessagesBefore.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                Long dateToTimestamp = MessageDao_Impl.this.__dateConverter.dateToTimestamp(date);
                if (dateToTimestamp == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindLong(2, dateToTimestamp.longValue());
                }
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                    MessageDao_Impl.this.__preparedStmtOfDeleteChannelMessagesBefore.release(acquire);
                }
            }
        }, continuation);
    }

    public Object deleteMessage(final String str, final String str2, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = MessageDao_Impl.this.__preparedStmtOfDeleteMessage.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                String str2 = str2;
                if (str2 == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str2);
                }
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                    MessageDao_Impl.this.__preparedStmtOfDeleteMessage.release(acquire);
                }
            }
        }, continuation);
    }

    public Object messagesForChannelNewerThan(String str, int i, Date date, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from stream_chat_message WHERE cid = ? AND createdAt > ? ORDER BY createdAt ASC LIMIT ?", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        Long dateToTimestamp = this.__dateConverter.dateToTimestamp(date);
        if (dateToTimestamp == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, dateToTimestamp.longValue());
        }
        acquire.bindLong(3, (long) i);
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<MessageEntity>>() {
            /* JADX WARNING: Removed duplicated region for block: B:101:0x0303 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x030c A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0353 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x036a A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x0381 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x0386 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x023f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0241 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0259 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x025b A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0273 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0275 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x028d A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x028f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02a7 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x02a9 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity> call() throws java.lang.Exception {
                /*
                    r52 = this;
                    r1 = r52
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x03d7 }
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = "cid"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r6 = "userId"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r7 = "text"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r8 = "type"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x03cd }
                    java.lang.String r9 = "syncStatus"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x03cd }
                    java.lang.String r10 = "replyCount"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x03cd }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x03cd }
                    java.lang.String r12 = "createdLocallyAt"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x03cd }
                    java.lang.String r13 = "updatedAt"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x03cd }
                    java.lang.String r14 = "updatedLocallyAt"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x03cd }
                    java.lang.String r15 = "deletedAt"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x03cd }
                    java.lang.String r3 = "mentionedUsersId"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r4 = "reactionCounts"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r16 = r4
                    java.lang.String r4 = "reactionScores"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r17 = r4
                    java.lang.String r4 = "parentId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r18 = r4
                    java.lang.String r4 = "command"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r19 = r4
                    java.lang.String r4 = "shadowed"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r20 = r4
                    java.lang.String r4 = "extraData"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r21 = r4
                    java.lang.String r4 = "replyToId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r22 = r4
                    java.lang.String r4 = "threadParticipantsIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r23 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                    r24 = r3
                    androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r3.<init>()     // Catch:{ all -> 0x03cd }
                    r25 = r15
                    androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r15.<init>()     // Catch:{ all -> 0x03cd }
                L_0x00ba:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0108
                    r26 = r14
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r27 = r4.get(r14)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x03cd }
                    if (r27 != 0) goto L_0x00d9
                    r27 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r13.<init>()     // Catch:{ all -> 0x03cd }
                    r4.put(r14, r13)     // Catch:{ all -> 0x03cd }
                    goto L_0x00db
                L_0x00d9:
                    r27 = r13
                L_0x00db:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r3.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x00ef
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r3.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x00ef:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r15.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x0103
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r15.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x0103:
                    r14 = r26
                    r13 = r27
                    goto L_0x00ba
                L_0x0108:
                    r27 = r13
                    r26 = r14
                    r13 = -1
                    r2.moveToPosition(r13)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1018x6508f06f(r4)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r15)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x03cd }
                    r13.<init>(r14)     // Catch:{ all -> 0x03cd }
                L_0x0128:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x03b1
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r7)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r8)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r9)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r10)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    r14 = r27
                    boolean r27 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r27 == 0) goto L_0x01ff
                    r27 = r13
                    r13 = r26
                    boolean r26 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0203
                    r26 = r15
                    r15 = r25
                    boolean r25 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r25 == 0) goto L_0x0207
                    r25 = r3
                    r3 = r24
                    boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x03cd }
                    if (r24 == 0) goto L_0x020b
                    r24 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r16 == 0) goto L_0x01fa
                    r16 = r4
                    r4 = r17
                    boolean r17 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r17 == 0) goto L_0x01f7
                    r17 = r4
                    r4 = r18
                    boolean r18 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r18 == 0) goto L_0x01f4
                    r18 = r4
                    r4 = r19
                    boolean r19 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x01f1
                    r19 = r4
                    r4 = r20
                    boolean r20 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r20 == 0) goto L_0x01ee
                    r20 = r4
                    r4 = r21
                    boolean r21 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r21 == 0) goto L_0x01eb
                    r21 = r4
                    r4 = r22
                    boolean r22 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r22 == 0) goto L_0x01e8
                    r22 = r4
                    r4 = r23
                    boolean r23 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r23 != 0) goto L_0x01db
                    goto L_0x020f
                L_0x01db:
                    r23 = r5
                    r50 = r6
                    r6 = r19
                    r19 = r16
                    r16 = r3
                    r3 = 0
                    goto L_0x0343
                L_0x01e8:
                    r22 = r4
                    goto L_0x020d
                L_0x01eb:
                    r21 = r4
                    goto L_0x020d
                L_0x01ee:
                    r20 = r4
                    goto L_0x020d
                L_0x01f1:
                    r19 = r4
                    goto L_0x020d
                L_0x01f4:
                    r18 = r4
                    goto L_0x020d
                L_0x01f7:
                    r17 = r4
                    goto L_0x020d
                L_0x01fa:
                    r16 = r4
                    goto L_0x020d
                L_0x01fd:
                    r14 = r27
                L_0x01ff:
                    r27 = r13
                    r13 = r26
                L_0x0203:
                    r26 = r15
                    r15 = r25
                L_0x0207:
                    r25 = r3
                    r3 = r24
                L_0x020b:
                    r24 = r4
                L_0x020d:
                    r4 = r23
                L_0x020f:
                    java.lang.String r29 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r30 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r31 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r32 = r2.getString(r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r33 = r2.getString(r8)     // Catch:{ all -> 0x03cd }
                    r23 = r5
                    int r5 = r2.getInt(r9)     // Catch:{ all -> 0x03cd }
                    r50 = r6
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter r6 = r6.__syncStatusConverter     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.client.utils.SyncStatus r34 = r6.stringToSyncStatus(r5)     // Catch:{ all -> 0x03cd }
                    int r35 = r2.getInt(r10)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0241
                    r5 = 0
                    goto L_0x0249
                L_0x0241:
                    long r5 = r2.getLong(r11)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0249:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r36 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x025b
                    r5 = 0
                    goto L_0x0263
                L_0x025b:
                    long r5 = r2.getLong(r12)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0263:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r37 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0275
                    r5 = 0
                    goto L_0x027d
                L_0x0275:
                    long r5 = r2.getLong(r14)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x027d:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r38 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x028f
                    r5 = 0
                    goto L_0x0297
                L_0x028f:
                    long r5 = r2.getLong(r13)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0297:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r39 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x02a9
                    r5 = 0
                    goto L_0x02b1
                L_0x02a9:
                    long r5 = r2.getLong(r15)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x02b1:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r40 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r6 = r6.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r41 = r6.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    r5 = r16
                    java.lang.String r6 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    r16 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r42 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r17
                    java.lang.String r6 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r17 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r43 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r18
                    java.lang.String r44 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r6 = r19
                    java.lang.String r45 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    r18 = r3
                    r3 = r20
                    int r19 = r2.getInt(r3)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x030c
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 1
                    goto L_0x0316
                L_0x030c:
                    r19 = 0
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 0
                L_0x0316:
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r21 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r3 = r3.__extraDataConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r47 = r3.stringToMap(r5)     // Catch:{ all -> 0x03cd }
                    r3 = r22
                    java.lang.String r48 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r4)     // Catch:{ all -> 0x03cd }
                    r22 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r3 = r3.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r49 = r3.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r3 = new io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity     // Catch:{ all -> 0x03cd }
                    r28 = r3
                    r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ all -> 0x03cd }
                L_0x0343:
                    java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r28 = r4
                    r4 = r24
                    java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x03cd }
                    if (r5 != 0) goto L_0x0358
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r5.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0358:
                    r24 = r4
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r29 = r6
                    r6 = r25
                    java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x03cd }
                    if (r4 != 0) goto L_0x036f
                    java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                L_0x036f:
                    r25 = r6
                    java.lang.String r6 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r30 = r0
                    r0 = r26
                    java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x03cd }
                    if (r6 != 0) goto L_0x0386
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r6.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0386:
                    r26 = r0
                    io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageEntity     // Catch:{ all -> 0x03cd }
                    r0.<init>(r3, r5, r4, r6)     // Catch:{ all -> 0x03cd }
                    r3 = r27
                    r3.add(r0)     // Catch:{ all -> 0x03cd }
                    r27 = r14
                    r5 = r23
                    r4 = r24
                    r23 = r28
                    r0 = r30
                    r6 = r50
                    r24 = r16
                    r16 = r19
                    r19 = r29
                    r51 = r13
                    r13 = r3
                    r3 = r25
                    r25 = r15
                    r15 = r26
                    r26 = r51
                    goto L_0x0128
                L_0x03b1:
                    r3 = r13
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03cd }
                    r0.setTransactionSuccessful()     // Catch:{ all -> 0x03cd }
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x03d7 }
                    r0.release()     // Catch:{ all -> 0x03d7 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r3
                L_0x03cd:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r2.release()     // Catch:{ all -> 0x03d7 }
                    throw r0     // Catch:{ all -> 0x03d7 }
                L_0x03d7:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.C501814.call():java.util.List");
            }
        }, continuation);
    }

    public Object messagesForChannelEqualOrNewerThan(String str, int i, Date date, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from stream_chat_message WHERE cid = ? AND createdAt >= ? ORDER BY createdAt ASC LIMIT ?", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        Long dateToTimestamp = this.__dateConverter.dateToTimestamp(date);
        if (dateToTimestamp == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, dateToTimestamp.longValue());
        }
        acquire.bindLong(3, (long) i);
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<MessageEntity>>() {
            /* JADX WARNING: Removed duplicated region for block: B:101:0x0303 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x030c A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0353 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x036a A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x0381 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x0386 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x023f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0241 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0259 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x025b A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0273 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0275 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x028d A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x028f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02a7 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x02a9 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity> call() throws java.lang.Exception {
                /*
                    r52 = this;
                    r1 = r52
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x03d7 }
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = "cid"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r6 = "userId"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r7 = "text"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r8 = "type"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x03cd }
                    java.lang.String r9 = "syncStatus"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x03cd }
                    java.lang.String r10 = "replyCount"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x03cd }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x03cd }
                    java.lang.String r12 = "createdLocallyAt"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x03cd }
                    java.lang.String r13 = "updatedAt"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x03cd }
                    java.lang.String r14 = "updatedLocallyAt"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x03cd }
                    java.lang.String r15 = "deletedAt"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x03cd }
                    java.lang.String r3 = "mentionedUsersId"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r4 = "reactionCounts"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r16 = r4
                    java.lang.String r4 = "reactionScores"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r17 = r4
                    java.lang.String r4 = "parentId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r18 = r4
                    java.lang.String r4 = "command"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r19 = r4
                    java.lang.String r4 = "shadowed"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r20 = r4
                    java.lang.String r4 = "extraData"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r21 = r4
                    java.lang.String r4 = "replyToId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r22 = r4
                    java.lang.String r4 = "threadParticipantsIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r23 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                    r24 = r3
                    androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r3.<init>()     // Catch:{ all -> 0x03cd }
                    r25 = r15
                    androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r15.<init>()     // Catch:{ all -> 0x03cd }
                L_0x00ba:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0108
                    r26 = r14
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r27 = r4.get(r14)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x03cd }
                    if (r27 != 0) goto L_0x00d9
                    r27 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r13.<init>()     // Catch:{ all -> 0x03cd }
                    r4.put(r14, r13)     // Catch:{ all -> 0x03cd }
                    goto L_0x00db
                L_0x00d9:
                    r27 = r13
                L_0x00db:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r3.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x00ef
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r3.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x00ef:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r15.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x0103
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r15.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x0103:
                    r14 = r26
                    r13 = r27
                    goto L_0x00ba
                L_0x0108:
                    r27 = r13
                    r26 = r14
                    r13 = -1
                    r2.moveToPosition(r13)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1018x6508f06f(r4)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r15)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x03cd }
                    r13.<init>(r14)     // Catch:{ all -> 0x03cd }
                L_0x0128:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x03b1
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r7)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r8)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r9)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r10)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    r14 = r27
                    boolean r27 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r27 == 0) goto L_0x01ff
                    r27 = r13
                    r13 = r26
                    boolean r26 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0203
                    r26 = r15
                    r15 = r25
                    boolean r25 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r25 == 0) goto L_0x0207
                    r25 = r3
                    r3 = r24
                    boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x03cd }
                    if (r24 == 0) goto L_0x020b
                    r24 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r16 == 0) goto L_0x01fa
                    r16 = r4
                    r4 = r17
                    boolean r17 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r17 == 0) goto L_0x01f7
                    r17 = r4
                    r4 = r18
                    boolean r18 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r18 == 0) goto L_0x01f4
                    r18 = r4
                    r4 = r19
                    boolean r19 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x01f1
                    r19 = r4
                    r4 = r20
                    boolean r20 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r20 == 0) goto L_0x01ee
                    r20 = r4
                    r4 = r21
                    boolean r21 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r21 == 0) goto L_0x01eb
                    r21 = r4
                    r4 = r22
                    boolean r22 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r22 == 0) goto L_0x01e8
                    r22 = r4
                    r4 = r23
                    boolean r23 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r23 != 0) goto L_0x01db
                    goto L_0x020f
                L_0x01db:
                    r23 = r5
                    r50 = r6
                    r6 = r19
                    r19 = r16
                    r16 = r3
                    r3 = 0
                    goto L_0x0343
                L_0x01e8:
                    r22 = r4
                    goto L_0x020d
                L_0x01eb:
                    r21 = r4
                    goto L_0x020d
                L_0x01ee:
                    r20 = r4
                    goto L_0x020d
                L_0x01f1:
                    r19 = r4
                    goto L_0x020d
                L_0x01f4:
                    r18 = r4
                    goto L_0x020d
                L_0x01f7:
                    r17 = r4
                    goto L_0x020d
                L_0x01fa:
                    r16 = r4
                    goto L_0x020d
                L_0x01fd:
                    r14 = r27
                L_0x01ff:
                    r27 = r13
                    r13 = r26
                L_0x0203:
                    r26 = r15
                    r15 = r25
                L_0x0207:
                    r25 = r3
                    r3 = r24
                L_0x020b:
                    r24 = r4
                L_0x020d:
                    r4 = r23
                L_0x020f:
                    java.lang.String r29 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r30 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r31 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r32 = r2.getString(r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r33 = r2.getString(r8)     // Catch:{ all -> 0x03cd }
                    r23 = r5
                    int r5 = r2.getInt(r9)     // Catch:{ all -> 0x03cd }
                    r50 = r6
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter r6 = r6.__syncStatusConverter     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.client.utils.SyncStatus r34 = r6.stringToSyncStatus(r5)     // Catch:{ all -> 0x03cd }
                    int r35 = r2.getInt(r10)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0241
                    r5 = 0
                    goto L_0x0249
                L_0x0241:
                    long r5 = r2.getLong(r11)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0249:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r36 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x025b
                    r5 = 0
                    goto L_0x0263
                L_0x025b:
                    long r5 = r2.getLong(r12)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0263:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r37 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0275
                    r5 = 0
                    goto L_0x027d
                L_0x0275:
                    long r5 = r2.getLong(r14)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x027d:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r38 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x028f
                    r5 = 0
                    goto L_0x0297
                L_0x028f:
                    long r5 = r2.getLong(r13)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0297:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r39 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x02a9
                    r5 = 0
                    goto L_0x02b1
                L_0x02a9:
                    long r5 = r2.getLong(r15)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x02b1:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r40 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r6 = r6.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r41 = r6.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    r5 = r16
                    java.lang.String r6 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    r16 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r42 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r17
                    java.lang.String r6 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r17 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r43 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r18
                    java.lang.String r44 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r6 = r19
                    java.lang.String r45 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    r18 = r3
                    r3 = r20
                    int r19 = r2.getInt(r3)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x030c
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 1
                    goto L_0x0316
                L_0x030c:
                    r19 = 0
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 0
                L_0x0316:
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r21 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r3 = r3.__extraDataConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r47 = r3.stringToMap(r5)     // Catch:{ all -> 0x03cd }
                    r3 = r22
                    java.lang.String r48 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r4)     // Catch:{ all -> 0x03cd }
                    r22 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r3 = r3.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r49 = r3.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r3 = new io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity     // Catch:{ all -> 0x03cd }
                    r28 = r3
                    r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ all -> 0x03cd }
                L_0x0343:
                    java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r28 = r4
                    r4 = r24
                    java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x03cd }
                    if (r5 != 0) goto L_0x0358
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r5.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0358:
                    r24 = r4
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r29 = r6
                    r6 = r25
                    java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x03cd }
                    if (r4 != 0) goto L_0x036f
                    java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                L_0x036f:
                    r25 = r6
                    java.lang.String r6 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r30 = r0
                    r0 = r26
                    java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x03cd }
                    if (r6 != 0) goto L_0x0386
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r6.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0386:
                    r26 = r0
                    io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageEntity     // Catch:{ all -> 0x03cd }
                    r0.<init>(r3, r5, r4, r6)     // Catch:{ all -> 0x03cd }
                    r3 = r27
                    r3.add(r0)     // Catch:{ all -> 0x03cd }
                    r27 = r14
                    r5 = r23
                    r4 = r24
                    r23 = r28
                    r0 = r30
                    r6 = r50
                    r24 = r16
                    r16 = r19
                    r19 = r29
                    r51 = r13
                    r13 = r3
                    r3 = r25
                    r25 = r15
                    r15 = r26
                    r26 = r51
                    goto L_0x0128
                L_0x03b1:
                    r3 = r13
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03cd }
                    r0.setTransactionSuccessful()     // Catch:{ all -> 0x03cd }
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x03d7 }
                    r0.release()     // Catch:{ all -> 0x03d7 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r3
                L_0x03cd:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r2.release()     // Catch:{ all -> 0x03d7 }
                    throw r0     // Catch:{ all -> 0x03d7 }
                L_0x03d7:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.C501915.call():java.util.List");
            }
        }, continuation);
    }

    public Object messagesForChannelOlderThan(String str, int i, Date date, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from stream_chat_message WHERE cid = ? AND createdAt < ? ORDER BY createdAt DESC LIMIT ?", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        Long dateToTimestamp = this.__dateConverter.dateToTimestamp(date);
        if (dateToTimestamp == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, dateToTimestamp.longValue());
        }
        acquire.bindLong(3, (long) i);
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<MessageEntity>>() {
            /* JADX WARNING: Removed duplicated region for block: B:101:0x0303 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x030c A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0353 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x036a A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x0381 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x0386 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x023f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0241 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0259 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x025b A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0273 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0275 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x028d A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x028f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02a7 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x02a9 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity> call() throws java.lang.Exception {
                /*
                    r52 = this;
                    r1 = r52
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x03d7 }
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = "cid"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r6 = "userId"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r7 = "text"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r8 = "type"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x03cd }
                    java.lang.String r9 = "syncStatus"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x03cd }
                    java.lang.String r10 = "replyCount"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x03cd }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x03cd }
                    java.lang.String r12 = "createdLocallyAt"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x03cd }
                    java.lang.String r13 = "updatedAt"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x03cd }
                    java.lang.String r14 = "updatedLocallyAt"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x03cd }
                    java.lang.String r15 = "deletedAt"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x03cd }
                    java.lang.String r3 = "mentionedUsersId"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r4 = "reactionCounts"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r16 = r4
                    java.lang.String r4 = "reactionScores"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r17 = r4
                    java.lang.String r4 = "parentId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r18 = r4
                    java.lang.String r4 = "command"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r19 = r4
                    java.lang.String r4 = "shadowed"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r20 = r4
                    java.lang.String r4 = "extraData"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r21 = r4
                    java.lang.String r4 = "replyToId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r22 = r4
                    java.lang.String r4 = "threadParticipantsIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r23 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                    r24 = r3
                    androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r3.<init>()     // Catch:{ all -> 0x03cd }
                    r25 = r15
                    androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r15.<init>()     // Catch:{ all -> 0x03cd }
                L_0x00ba:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0108
                    r26 = r14
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r27 = r4.get(r14)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x03cd }
                    if (r27 != 0) goto L_0x00d9
                    r27 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r13.<init>()     // Catch:{ all -> 0x03cd }
                    r4.put(r14, r13)     // Catch:{ all -> 0x03cd }
                    goto L_0x00db
                L_0x00d9:
                    r27 = r13
                L_0x00db:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r3.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x00ef
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r3.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x00ef:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r15.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x0103
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r15.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x0103:
                    r14 = r26
                    r13 = r27
                    goto L_0x00ba
                L_0x0108:
                    r27 = r13
                    r26 = r14
                    r13 = -1
                    r2.moveToPosition(r13)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1018x6508f06f(r4)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r15)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x03cd }
                    r13.<init>(r14)     // Catch:{ all -> 0x03cd }
                L_0x0128:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x03b1
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r7)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r8)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r9)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r10)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    r14 = r27
                    boolean r27 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r27 == 0) goto L_0x01ff
                    r27 = r13
                    r13 = r26
                    boolean r26 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0203
                    r26 = r15
                    r15 = r25
                    boolean r25 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r25 == 0) goto L_0x0207
                    r25 = r3
                    r3 = r24
                    boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x03cd }
                    if (r24 == 0) goto L_0x020b
                    r24 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r16 == 0) goto L_0x01fa
                    r16 = r4
                    r4 = r17
                    boolean r17 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r17 == 0) goto L_0x01f7
                    r17 = r4
                    r4 = r18
                    boolean r18 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r18 == 0) goto L_0x01f4
                    r18 = r4
                    r4 = r19
                    boolean r19 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x01f1
                    r19 = r4
                    r4 = r20
                    boolean r20 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r20 == 0) goto L_0x01ee
                    r20 = r4
                    r4 = r21
                    boolean r21 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r21 == 0) goto L_0x01eb
                    r21 = r4
                    r4 = r22
                    boolean r22 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r22 == 0) goto L_0x01e8
                    r22 = r4
                    r4 = r23
                    boolean r23 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r23 != 0) goto L_0x01db
                    goto L_0x020f
                L_0x01db:
                    r23 = r5
                    r50 = r6
                    r6 = r19
                    r19 = r16
                    r16 = r3
                    r3 = 0
                    goto L_0x0343
                L_0x01e8:
                    r22 = r4
                    goto L_0x020d
                L_0x01eb:
                    r21 = r4
                    goto L_0x020d
                L_0x01ee:
                    r20 = r4
                    goto L_0x020d
                L_0x01f1:
                    r19 = r4
                    goto L_0x020d
                L_0x01f4:
                    r18 = r4
                    goto L_0x020d
                L_0x01f7:
                    r17 = r4
                    goto L_0x020d
                L_0x01fa:
                    r16 = r4
                    goto L_0x020d
                L_0x01fd:
                    r14 = r27
                L_0x01ff:
                    r27 = r13
                    r13 = r26
                L_0x0203:
                    r26 = r15
                    r15 = r25
                L_0x0207:
                    r25 = r3
                    r3 = r24
                L_0x020b:
                    r24 = r4
                L_0x020d:
                    r4 = r23
                L_0x020f:
                    java.lang.String r29 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r30 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r31 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r32 = r2.getString(r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r33 = r2.getString(r8)     // Catch:{ all -> 0x03cd }
                    r23 = r5
                    int r5 = r2.getInt(r9)     // Catch:{ all -> 0x03cd }
                    r50 = r6
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter r6 = r6.__syncStatusConverter     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.client.utils.SyncStatus r34 = r6.stringToSyncStatus(r5)     // Catch:{ all -> 0x03cd }
                    int r35 = r2.getInt(r10)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0241
                    r5 = 0
                    goto L_0x0249
                L_0x0241:
                    long r5 = r2.getLong(r11)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0249:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r36 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x025b
                    r5 = 0
                    goto L_0x0263
                L_0x025b:
                    long r5 = r2.getLong(r12)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0263:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r37 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0275
                    r5 = 0
                    goto L_0x027d
                L_0x0275:
                    long r5 = r2.getLong(r14)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x027d:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r38 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x028f
                    r5 = 0
                    goto L_0x0297
                L_0x028f:
                    long r5 = r2.getLong(r13)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0297:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r39 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x02a9
                    r5 = 0
                    goto L_0x02b1
                L_0x02a9:
                    long r5 = r2.getLong(r15)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x02b1:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r40 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r6 = r6.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r41 = r6.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    r5 = r16
                    java.lang.String r6 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    r16 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r42 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r17
                    java.lang.String r6 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r17 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r43 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r18
                    java.lang.String r44 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r6 = r19
                    java.lang.String r45 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    r18 = r3
                    r3 = r20
                    int r19 = r2.getInt(r3)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x030c
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 1
                    goto L_0x0316
                L_0x030c:
                    r19 = 0
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 0
                L_0x0316:
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r21 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r3 = r3.__extraDataConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r47 = r3.stringToMap(r5)     // Catch:{ all -> 0x03cd }
                    r3 = r22
                    java.lang.String r48 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r4)     // Catch:{ all -> 0x03cd }
                    r22 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r3 = r3.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r49 = r3.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r3 = new io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity     // Catch:{ all -> 0x03cd }
                    r28 = r3
                    r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ all -> 0x03cd }
                L_0x0343:
                    java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r28 = r4
                    r4 = r24
                    java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x03cd }
                    if (r5 != 0) goto L_0x0358
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r5.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0358:
                    r24 = r4
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r29 = r6
                    r6 = r25
                    java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x03cd }
                    if (r4 != 0) goto L_0x036f
                    java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                L_0x036f:
                    r25 = r6
                    java.lang.String r6 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r30 = r0
                    r0 = r26
                    java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x03cd }
                    if (r6 != 0) goto L_0x0386
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r6.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0386:
                    r26 = r0
                    io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageEntity     // Catch:{ all -> 0x03cd }
                    r0.<init>(r3, r5, r4, r6)     // Catch:{ all -> 0x03cd }
                    r3 = r27
                    r3.add(r0)     // Catch:{ all -> 0x03cd }
                    r27 = r14
                    r5 = r23
                    r4 = r24
                    r23 = r28
                    r0 = r30
                    r6 = r50
                    r24 = r16
                    r16 = r19
                    r19 = r29
                    r51 = r13
                    r13 = r3
                    r3 = r25
                    r25 = r15
                    r15 = r26
                    r26 = r51
                    goto L_0x0128
                L_0x03b1:
                    r3 = r13
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03cd }
                    r0.setTransactionSuccessful()     // Catch:{ all -> 0x03cd }
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x03d7 }
                    r0.release()     // Catch:{ all -> 0x03d7 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r3
                L_0x03cd:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r2.release()     // Catch:{ all -> 0x03d7 }
                    throw r0     // Catch:{ all -> 0x03d7 }
                L_0x03d7:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.C502016.call():java.util.List");
            }
        }, continuation);
    }

    public Object messagesForChannelEqualOrOlderThan(String str, int i, Date date, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from stream_chat_message WHERE cid = ? AND createdAt <= ? ORDER BY createdAt DESC LIMIT ?", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        Long dateToTimestamp = this.__dateConverter.dateToTimestamp(date);
        if (dateToTimestamp == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, dateToTimestamp.longValue());
        }
        acquire.bindLong(3, (long) i);
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<MessageEntity>>() {
            /* JADX WARNING: Removed duplicated region for block: B:101:0x0303 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x030c A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0353 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x036a A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x0381 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x0386 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x023f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0241 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0259 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x025b A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0273 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0275 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x028d A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x028f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02a7 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x02a9 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity> call() throws java.lang.Exception {
                /*
                    r52 = this;
                    r1 = r52
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x03d7 }
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = "cid"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r6 = "userId"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r7 = "text"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r8 = "type"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x03cd }
                    java.lang.String r9 = "syncStatus"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x03cd }
                    java.lang.String r10 = "replyCount"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x03cd }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x03cd }
                    java.lang.String r12 = "createdLocallyAt"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x03cd }
                    java.lang.String r13 = "updatedAt"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x03cd }
                    java.lang.String r14 = "updatedLocallyAt"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x03cd }
                    java.lang.String r15 = "deletedAt"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x03cd }
                    java.lang.String r3 = "mentionedUsersId"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r4 = "reactionCounts"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r16 = r4
                    java.lang.String r4 = "reactionScores"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r17 = r4
                    java.lang.String r4 = "parentId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r18 = r4
                    java.lang.String r4 = "command"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r19 = r4
                    java.lang.String r4 = "shadowed"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r20 = r4
                    java.lang.String r4 = "extraData"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r21 = r4
                    java.lang.String r4 = "replyToId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r22 = r4
                    java.lang.String r4 = "threadParticipantsIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r23 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                    r24 = r3
                    androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r3.<init>()     // Catch:{ all -> 0x03cd }
                    r25 = r15
                    androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r15.<init>()     // Catch:{ all -> 0x03cd }
                L_0x00ba:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0108
                    r26 = r14
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r27 = r4.get(r14)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x03cd }
                    if (r27 != 0) goto L_0x00d9
                    r27 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r13.<init>()     // Catch:{ all -> 0x03cd }
                    r4.put(r14, r13)     // Catch:{ all -> 0x03cd }
                    goto L_0x00db
                L_0x00d9:
                    r27 = r13
                L_0x00db:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r3.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x00ef
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r3.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x00ef:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r15.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x0103
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r15.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x0103:
                    r14 = r26
                    r13 = r27
                    goto L_0x00ba
                L_0x0108:
                    r27 = r13
                    r26 = r14
                    r13 = -1
                    r2.moveToPosition(r13)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1018x6508f06f(r4)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r15)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x03cd }
                    r13.<init>(r14)     // Catch:{ all -> 0x03cd }
                L_0x0128:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x03b1
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r7)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r8)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r9)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r10)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    r14 = r27
                    boolean r27 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r27 == 0) goto L_0x01ff
                    r27 = r13
                    r13 = r26
                    boolean r26 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0203
                    r26 = r15
                    r15 = r25
                    boolean r25 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r25 == 0) goto L_0x0207
                    r25 = r3
                    r3 = r24
                    boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x03cd }
                    if (r24 == 0) goto L_0x020b
                    r24 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r16 == 0) goto L_0x01fa
                    r16 = r4
                    r4 = r17
                    boolean r17 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r17 == 0) goto L_0x01f7
                    r17 = r4
                    r4 = r18
                    boolean r18 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r18 == 0) goto L_0x01f4
                    r18 = r4
                    r4 = r19
                    boolean r19 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x01f1
                    r19 = r4
                    r4 = r20
                    boolean r20 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r20 == 0) goto L_0x01ee
                    r20 = r4
                    r4 = r21
                    boolean r21 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r21 == 0) goto L_0x01eb
                    r21 = r4
                    r4 = r22
                    boolean r22 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r22 == 0) goto L_0x01e8
                    r22 = r4
                    r4 = r23
                    boolean r23 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r23 != 0) goto L_0x01db
                    goto L_0x020f
                L_0x01db:
                    r23 = r5
                    r50 = r6
                    r6 = r19
                    r19 = r16
                    r16 = r3
                    r3 = 0
                    goto L_0x0343
                L_0x01e8:
                    r22 = r4
                    goto L_0x020d
                L_0x01eb:
                    r21 = r4
                    goto L_0x020d
                L_0x01ee:
                    r20 = r4
                    goto L_0x020d
                L_0x01f1:
                    r19 = r4
                    goto L_0x020d
                L_0x01f4:
                    r18 = r4
                    goto L_0x020d
                L_0x01f7:
                    r17 = r4
                    goto L_0x020d
                L_0x01fa:
                    r16 = r4
                    goto L_0x020d
                L_0x01fd:
                    r14 = r27
                L_0x01ff:
                    r27 = r13
                    r13 = r26
                L_0x0203:
                    r26 = r15
                    r15 = r25
                L_0x0207:
                    r25 = r3
                    r3 = r24
                L_0x020b:
                    r24 = r4
                L_0x020d:
                    r4 = r23
                L_0x020f:
                    java.lang.String r29 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r30 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r31 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r32 = r2.getString(r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r33 = r2.getString(r8)     // Catch:{ all -> 0x03cd }
                    r23 = r5
                    int r5 = r2.getInt(r9)     // Catch:{ all -> 0x03cd }
                    r50 = r6
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter r6 = r6.__syncStatusConverter     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.client.utils.SyncStatus r34 = r6.stringToSyncStatus(r5)     // Catch:{ all -> 0x03cd }
                    int r35 = r2.getInt(r10)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0241
                    r5 = 0
                    goto L_0x0249
                L_0x0241:
                    long r5 = r2.getLong(r11)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0249:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r36 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x025b
                    r5 = 0
                    goto L_0x0263
                L_0x025b:
                    long r5 = r2.getLong(r12)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0263:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r37 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0275
                    r5 = 0
                    goto L_0x027d
                L_0x0275:
                    long r5 = r2.getLong(r14)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x027d:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r38 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x028f
                    r5 = 0
                    goto L_0x0297
                L_0x028f:
                    long r5 = r2.getLong(r13)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0297:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r39 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x02a9
                    r5 = 0
                    goto L_0x02b1
                L_0x02a9:
                    long r5 = r2.getLong(r15)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x02b1:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r40 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r6 = r6.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r41 = r6.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    r5 = r16
                    java.lang.String r6 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    r16 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r42 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r17
                    java.lang.String r6 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r17 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r43 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r18
                    java.lang.String r44 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r6 = r19
                    java.lang.String r45 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    r18 = r3
                    r3 = r20
                    int r19 = r2.getInt(r3)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x030c
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 1
                    goto L_0x0316
                L_0x030c:
                    r19 = 0
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 0
                L_0x0316:
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r21 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r3 = r3.__extraDataConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r47 = r3.stringToMap(r5)     // Catch:{ all -> 0x03cd }
                    r3 = r22
                    java.lang.String r48 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r4)     // Catch:{ all -> 0x03cd }
                    r22 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r3 = r3.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r49 = r3.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r3 = new io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity     // Catch:{ all -> 0x03cd }
                    r28 = r3
                    r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ all -> 0x03cd }
                L_0x0343:
                    java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r28 = r4
                    r4 = r24
                    java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x03cd }
                    if (r5 != 0) goto L_0x0358
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r5.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0358:
                    r24 = r4
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r29 = r6
                    r6 = r25
                    java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x03cd }
                    if (r4 != 0) goto L_0x036f
                    java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                L_0x036f:
                    r25 = r6
                    java.lang.String r6 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r30 = r0
                    r0 = r26
                    java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x03cd }
                    if (r6 != 0) goto L_0x0386
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r6.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0386:
                    r26 = r0
                    io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageEntity     // Catch:{ all -> 0x03cd }
                    r0.<init>(r3, r5, r4, r6)     // Catch:{ all -> 0x03cd }
                    r3 = r27
                    r3.add(r0)     // Catch:{ all -> 0x03cd }
                    r27 = r14
                    r5 = r23
                    r4 = r24
                    r23 = r28
                    r0 = r30
                    r6 = r50
                    r24 = r16
                    r16 = r19
                    r19 = r29
                    r51 = r13
                    r13 = r3
                    r3 = r25
                    r25 = r15
                    r15 = r26
                    r26 = r51
                    goto L_0x0128
                L_0x03b1:
                    r3 = r13
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03cd }
                    r0.setTransactionSuccessful()     // Catch:{ all -> 0x03cd }
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x03d7 }
                    r0.release()     // Catch:{ all -> 0x03d7 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r3
                L_0x03cd:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r2.release()     // Catch:{ all -> 0x03d7 }
                    throw r0     // Catch:{ all -> 0x03d7 }
                L_0x03d7:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.C502117.call():java.util.List");
            }
        }, continuation);
    }

    public Object messagesForChannel(String str, int i, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from stream_chat_message WHERE cid = ? ORDER BY createdAt DESC LIMIT ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, (long) i);
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<MessageEntity>>() {
            /* JADX WARNING: Removed duplicated region for block: B:101:0x0303 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x030c A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0353 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x036a A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x0381 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x0386 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x023f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0241 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0259 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x025b A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0273 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0275 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x028d A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x028f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02a7 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x02a9 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity> call() throws java.lang.Exception {
                /*
                    r52 = this;
                    r1 = r52
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x03d7 }
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = "cid"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r6 = "userId"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r7 = "text"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r8 = "type"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x03cd }
                    java.lang.String r9 = "syncStatus"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x03cd }
                    java.lang.String r10 = "replyCount"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x03cd }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x03cd }
                    java.lang.String r12 = "createdLocallyAt"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x03cd }
                    java.lang.String r13 = "updatedAt"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x03cd }
                    java.lang.String r14 = "updatedLocallyAt"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x03cd }
                    java.lang.String r15 = "deletedAt"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x03cd }
                    java.lang.String r3 = "mentionedUsersId"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r4 = "reactionCounts"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r16 = r4
                    java.lang.String r4 = "reactionScores"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r17 = r4
                    java.lang.String r4 = "parentId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r18 = r4
                    java.lang.String r4 = "command"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r19 = r4
                    java.lang.String r4 = "shadowed"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r20 = r4
                    java.lang.String r4 = "extraData"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r21 = r4
                    java.lang.String r4 = "replyToId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r22 = r4
                    java.lang.String r4 = "threadParticipantsIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r23 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                    r24 = r3
                    androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r3.<init>()     // Catch:{ all -> 0x03cd }
                    r25 = r15
                    androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r15.<init>()     // Catch:{ all -> 0x03cd }
                L_0x00ba:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0108
                    r26 = r14
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r27 = r4.get(r14)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x03cd }
                    if (r27 != 0) goto L_0x00d9
                    r27 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r13.<init>()     // Catch:{ all -> 0x03cd }
                    r4.put(r14, r13)     // Catch:{ all -> 0x03cd }
                    goto L_0x00db
                L_0x00d9:
                    r27 = r13
                L_0x00db:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r3.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x00ef
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r3.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x00ef:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r15.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x0103
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r15.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x0103:
                    r14 = r26
                    r13 = r27
                    goto L_0x00ba
                L_0x0108:
                    r27 = r13
                    r26 = r14
                    r13 = -1
                    r2.moveToPosition(r13)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1018x6508f06f(r4)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r15)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x03cd }
                    r13.<init>(r14)     // Catch:{ all -> 0x03cd }
                L_0x0128:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x03b1
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r7)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r8)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r9)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r10)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    r14 = r27
                    boolean r27 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r27 == 0) goto L_0x01ff
                    r27 = r13
                    r13 = r26
                    boolean r26 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0203
                    r26 = r15
                    r15 = r25
                    boolean r25 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r25 == 0) goto L_0x0207
                    r25 = r3
                    r3 = r24
                    boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x03cd }
                    if (r24 == 0) goto L_0x020b
                    r24 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r16 == 0) goto L_0x01fa
                    r16 = r4
                    r4 = r17
                    boolean r17 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r17 == 0) goto L_0x01f7
                    r17 = r4
                    r4 = r18
                    boolean r18 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r18 == 0) goto L_0x01f4
                    r18 = r4
                    r4 = r19
                    boolean r19 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x01f1
                    r19 = r4
                    r4 = r20
                    boolean r20 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r20 == 0) goto L_0x01ee
                    r20 = r4
                    r4 = r21
                    boolean r21 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r21 == 0) goto L_0x01eb
                    r21 = r4
                    r4 = r22
                    boolean r22 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r22 == 0) goto L_0x01e8
                    r22 = r4
                    r4 = r23
                    boolean r23 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r23 != 0) goto L_0x01db
                    goto L_0x020f
                L_0x01db:
                    r23 = r5
                    r50 = r6
                    r6 = r19
                    r19 = r16
                    r16 = r3
                    r3 = 0
                    goto L_0x0343
                L_0x01e8:
                    r22 = r4
                    goto L_0x020d
                L_0x01eb:
                    r21 = r4
                    goto L_0x020d
                L_0x01ee:
                    r20 = r4
                    goto L_0x020d
                L_0x01f1:
                    r19 = r4
                    goto L_0x020d
                L_0x01f4:
                    r18 = r4
                    goto L_0x020d
                L_0x01f7:
                    r17 = r4
                    goto L_0x020d
                L_0x01fa:
                    r16 = r4
                    goto L_0x020d
                L_0x01fd:
                    r14 = r27
                L_0x01ff:
                    r27 = r13
                    r13 = r26
                L_0x0203:
                    r26 = r15
                    r15 = r25
                L_0x0207:
                    r25 = r3
                    r3 = r24
                L_0x020b:
                    r24 = r4
                L_0x020d:
                    r4 = r23
                L_0x020f:
                    java.lang.String r29 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r30 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r31 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r32 = r2.getString(r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r33 = r2.getString(r8)     // Catch:{ all -> 0x03cd }
                    r23 = r5
                    int r5 = r2.getInt(r9)     // Catch:{ all -> 0x03cd }
                    r50 = r6
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter r6 = r6.__syncStatusConverter     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.client.utils.SyncStatus r34 = r6.stringToSyncStatus(r5)     // Catch:{ all -> 0x03cd }
                    int r35 = r2.getInt(r10)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0241
                    r5 = 0
                    goto L_0x0249
                L_0x0241:
                    long r5 = r2.getLong(r11)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0249:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r36 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x025b
                    r5 = 0
                    goto L_0x0263
                L_0x025b:
                    long r5 = r2.getLong(r12)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0263:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r37 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0275
                    r5 = 0
                    goto L_0x027d
                L_0x0275:
                    long r5 = r2.getLong(r14)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x027d:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r38 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x028f
                    r5 = 0
                    goto L_0x0297
                L_0x028f:
                    long r5 = r2.getLong(r13)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0297:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r39 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x02a9
                    r5 = 0
                    goto L_0x02b1
                L_0x02a9:
                    long r5 = r2.getLong(r15)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x02b1:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r40 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r6 = r6.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r41 = r6.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    r5 = r16
                    java.lang.String r6 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    r16 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r42 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r17
                    java.lang.String r6 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r17 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r43 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r18
                    java.lang.String r44 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r6 = r19
                    java.lang.String r45 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    r18 = r3
                    r3 = r20
                    int r19 = r2.getInt(r3)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x030c
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 1
                    goto L_0x0316
                L_0x030c:
                    r19 = 0
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 0
                L_0x0316:
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r21 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r3 = r3.__extraDataConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r47 = r3.stringToMap(r5)     // Catch:{ all -> 0x03cd }
                    r3 = r22
                    java.lang.String r48 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r4)     // Catch:{ all -> 0x03cd }
                    r22 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r3 = r3.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r49 = r3.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r3 = new io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity     // Catch:{ all -> 0x03cd }
                    r28 = r3
                    r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ all -> 0x03cd }
                L_0x0343:
                    java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r28 = r4
                    r4 = r24
                    java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x03cd }
                    if (r5 != 0) goto L_0x0358
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r5.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0358:
                    r24 = r4
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r29 = r6
                    r6 = r25
                    java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x03cd }
                    if (r4 != 0) goto L_0x036f
                    java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                L_0x036f:
                    r25 = r6
                    java.lang.String r6 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r30 = r0
                    r0 = r26
                    java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x03cd }
                    if (r6 != 0) goto L_0x0386
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r6.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0386:
                    r26 = r0
                    io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageEntity     // Catch:{ all -> 0x03cd }
                    r0.<init>(r3, r5, r4, r6)     // Catch:{ all -> 0x03cd }
                    r3 = r27
                    r3.add(r0)     // Catch:{ all -> 0x03cd }
                    r27 = r14
                    r5 = r23
                    r4 = r24
                    r23 = r28
                    r0 = r30
                    r6 = r50
                    r24 = r16
                    r16 = r19
                    r19 = r29
                    r51 = r13
                    r13 = r3
                    r3 = r25
                    r25 = r15
                    r15 = r26
                    r26 = r51
                    goto L_0x0128
                L_0x03b1:
                    r3 = r13
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03cd }
                    r0.setTransactionSuccessful()     // Catch:{ all -> 0x03cd }
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x03d7 }
                    r0.release()     // Catch:{ all -> 0x03d7 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r3
                L_0x03cd:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r2.release()     // Catch:{ all -> 0x03d7 }
                    throw r0     // Catch:{ all -> 0x03d7 }
                L_0x03d7:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.C502218.call():java.util.List");
            }
        }, continuation);
    }

    public Object select(List<String> list, Continuation<? super List<MessageEntity>> continuation) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM stream_chat_message WHERE stream_chat_message.id IN (");
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
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<MessageEntity>>() {
            /* JADX WARNING: Removed duplicated region for block: B:101:0x0303 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x030c A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0353 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x036a A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x0381 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x0386 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x023f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0241 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0259 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x025b A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0273 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0275 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x028d A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x028f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02a7 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x02a9 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity> call() throws java.lang.Exception {
                /*
                    r52 = this;
                    r1 = r52
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x03d7 }
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = "cid"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r6 = "userId"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r7 = "text"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r8 = "type"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x03cd }
                    java.lang.String r9 = "syncStatus"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x03cd }
                    java.lang.String r10 = "replyCount"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x03cd }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x03cd }
                    java.lang.String r12 = "createdLocallyAt"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x03cd }
                    java.lang.String r13 = "updatedAt"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x03cd }
                    java.lang.String r14 = "updatedLocallyAt"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x03cd }
                    java.lang.String r15 = "deletedAt"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x03cd }
                    java.lang.String r3 = "mentionedUsersId"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r4 = "reactionCounts"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r16 = r4
                    java.lang.String r4 = "reactionScores"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r17 = r4
                    java.lang.String r4 = "parentId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r18 = r4
                    java.lang.String r4 = "command"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r19 = r4
                    java.lang.String r4 = "shadowed"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r20 = r4
                    java.lang.String r4 = "extraData"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r21 = r4
                    java.lang.String r4 = "replyToId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r22 = r4
                    java.lang.String r4 = "threadParticipantsIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r23 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                    r24 = r3
                    androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r3.<init>()     // Catch:{ all -> 0x03cd }
                    r25 = r15
                    androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r15.<init>()     // Catch:{ all -> 0x03cd }
                L_0x00ba:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0108
                    r26 = r14
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r27 = r4.get(r14)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x03cd }
                    if (r27 != 0) goto L_0x00d9
                    r27 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r13.<init>()     // Catch:{ all -> 0x03cd }
                    r4.put(r14, r13)     // Catch:{ all -> 0x03cd }
                    goto L_0x00db
                L_0x00d9:
                    r27 = r13
                L_0x00db:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r3.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x00ef
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r3.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x00ef:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r15.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x0103
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r15.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x0103:
                    r14 = r26
                    r13 = r27
                    goto L_0x00ba
                L_0x0108:
                    r27 = r13
                    r26 = r14
                    r13 = -1
                    r2.moveToPosition(r13)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1018x6508f06f(r4)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r15)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x03cd }
                    r13.<init>(r14)     // Catch:{ all -> 0x03cd }
                L_0x0128:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x03b1
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r7)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r8)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r9)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r10)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    r14 = r27
                    boolean r27 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r27 == 0) goto L_0x01ff
                    r27 = r13
                    r13 = r26
                    boolean r26 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0203
                    r26 = r15
                    r15 = r25
                    boolean r25 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r25 == 0) goto L_0x0207
                    r25 = r3
                    r3 = r24
                    boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x03cd }
                    if (r24 == 0) goto L_0x020b
                    r24 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r16 == 0) goto L_0x01fa
                    r16 = r4
                    r4 = r17
                    boolean r17 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r17 == 0) goto L_0x01f7
                    r17 = r4
                    r4 = r18
                    boolean r18 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r18 == 0) goto L_0x01f4
                    r18 = r4
                    r4 = r19
                    boolean r19 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x01f1
                    r19 = r4
                    r4 = r20
                    boolean r20 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r20 == 0) goto L_0x01ee
                    r20 = r4
                    r4 = r21
                    boolean r21 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r21 == 0) goto L_0x01eb
                    r21 = r4
                    r4 = r22
                    boolean r22 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r22 == 0) goto L_0x01e8
                    r22 = r4
                    r4 = r23
                    boolean r23 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r23 != 0) goto L_0x01db
                    goto L_0x020f
                L_0x01db:
                    r23 = r5
                    r50 = r6
                    r6 = r19
                    r19 = r16
                    r16 = r3
                    r3 = 0
                    goto L_0x0343
                L_0x01e8:
                    r22 = r4
                    goto L_0x020d
                L_0x01eb:
                    r21 = r4
                    goto L_0x020d
                L_0x01ee:
                    r20 = r4
                    goto L_0x020d
                L_0x01f1:
                    r19 = r4
                    goto L_0x020d
                L_0x01f4:
                    r18 = r4
                    goto L_0x020d
                L_0x01f7:
                    r17 = r4
                    goto L_0x020d
                L_0x01fa:
                    r16 = r4
                    goto L_0x020d
                L_0x01fd:
                    r14 = r27
                L_0x01ff:
                    r27 = r13
                    r13 = r26
                L_0x0203:
                    r26 = r15
                    r15 = r25
                L_0x0207:
                    r25 = r3
                    r3 = r24
                L_0x020b:
                    r24 = r4
                L_0x020d:
                    r4 = r23
                L_0x020f:
                    java.lang.String r29 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r30 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r31 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r32 = r2.getString(r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r33 = r2.getString(r8)     // Catch:{ all -> 0x03cd }
                    r23 = r5
                    int r5 = r2.getInt(r9)     // Catch:{ all -> 0x03cd }
                    r50 = r6
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter r6 = r6.__syncStatusConverter     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.client.utils.SyncStatus r34 = r6.stringToSyncStatus(r5)     // Catch:{ all -> 0x03cd }
                    int r35 = r2.getInt(r10)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0241
                    r5 = 0
                    goto L_0x0249
                L_0x0241:
                    long r5 = r2.getLong(r11)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0249:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r36 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x025b
                    r5 = 0
                    goto L_0x0263
                L_0x025b:
                    long r5 = r2.getLong(r12)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0263:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r37 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0275
                    r5 = 0
                    goto L_0x027d
                L_0x0275:
                    long r5 = r2.getLong(r14)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x027d:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r38 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x028f
                    r5 = 0
                    goto L_0x0297
                L_0x028f:
                    long r5 = r2.getLong(r13)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0297:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r39 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x02a9
                    r5 = 0
                    goto L_0x02b1
                L_0x02a9:
                    long r5 = r2.getLong(r15)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x02b1:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r40 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r6 = r6.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r41 = r6.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    r5 = r16
                    java.lang.String r6 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    r16 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r42 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r17
                    java.lang.String r6 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r17 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r43 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r18
                    java.lang.String r44 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r6 = r19
                    java.lang.String r45 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    r18 = r3
                    r3 = r20
                    int r19 = r2.getInt(r3)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x030c
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 1
                    goto L_0x0316
                L_0x030c:
                    r19 = 0
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 0
                L_0x0316:
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r21 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r3 = r3.__extraDataConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r47 = r3.stringToMap(r5)     // Catch:{ all -> 0x03cd }
                    r3 = r22
                    java.lang.String r48 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r4)     // Catch:{ all -> 0x03cd }
                    r22 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r3 = r3.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r49 = r3.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r3 = new io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity     // Catch:{ all -> 0x03cd }
                    r28 = r3
                    r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ all -> 0x03cd }
                L_0x0343:
                    java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r28 = r4
                    r4 = r24
                    java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x03cd }
                    if (r5 != 0) goto L_0x0358
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r5.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0358:
                    r24 = r4
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r29 = r6
                    r6 = r25
                    java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x03cd }
                    if (r4 != 0) goto L_0x036f
                    java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                L_0x036f:
                    r25 = r6
                    java.lang.String r6 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r30 = r0
                    r0 = r26
                    java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x03cd }
                    if (r6 != 0) goto L_0x0386
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r6.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0386:
                    r26 = r0
                    io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageEntity     // Catch:{ all -> 0x03cd }
                    r0.<init>(r3, r5, r4, r6)     // Catch:{ all -> 0x03cd }
                    r3 = r27
                    r3.add(r0)     // Catch:{ all -> 0x03cd }
                    r27 = r14
                    r5 = r23
                    r4 = r24
                    r23 = r28
                    r0 = r30
                    r6 = r50
                    r24 = r16
                    r16 = r19
                    r19 = r29
                    r51 = r13
                    r13 = r3
                    r3 = r25
                    r25 = r15
                    r15 = r26
                    r26 = r51
                    goto L_0x0128
                L_0x03b1:
                    r3 = r13
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03cd }
                    r0.setTransactionSuccessful()     // Catch:{ all -> 0x03cd }
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x03d7 }
                    r0.release()     // Catch:{ all -> 0x03d7 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r3
                L_0x03cd:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r2.release()     // Catch:{ all -> 0x03d7 }
                    throw r0     // Catch:{ all -> 0x03d7 }
                L_0x03d7:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.C502319.call():java.util.List");
            }
        }, continuation);
    }

    public Object select(String str, Continuation<? super MessageEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_message WHERE stream_chat_message.id IN (?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, true, new Callable<MessageEntity>() {
            /* JADX WARNING: Removed duplicated region for block: B:100:0x02e5 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:101:0x02ea A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x0326 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:108:0x0339 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x034c A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x0227 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x0229 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x0241 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0243 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x025b A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x025d A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x0275 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x0277 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:96:0x028f A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x0291 A[Catch:{ all -> 0x0374, all -> 0x037e }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity call() throws java.lang.Exception {
                /*
                    r49 = this;
                    r1 = r49
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x037e }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x037e }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x037e }
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x037e }
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x0374 }
                    java.lang.String r5 = "cid"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x0374 }
                    java.lang.String r6 = "userId"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x0374 }
                    java.lang.String r7 = "text"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x0374 }
                    java.lang.String r8 = "type"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x0374 }
                    java.lang.String r9 = "syncStatus"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x0374 }
                    java.lang.String r10 = "replyCount"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x0374 }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x0374 }
                    java.lang.String r12 = "createdLocallyAt"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x0374 }
                    java.lang.String r13 = "updatedAt"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x0374 }
                    java.lang.String r14 = "updatedLocallyAt"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x0374 }
                    java.lang.String r15 = "deletedAt"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x0374 }
                    java.lang.String r3 = "mentionedUsersId"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x0374 }
                    java.lang.String r4 = "reactionCounts"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x0374 }
                    r16 = r4
                    java.lang.String r4 = "reactionScores"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x0374 }
                    r17 = r4
                    java.lang.String r4 = "parentId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x0374 }
                    r18 = r4
                    java.lang.String r4 = "command"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x0374 }
                    r19 = r4
                    java.lang.String r4 = "shadowed"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x0374 }
                    r20 = r4
                    java.lang.String r4 = "extraData"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x0374 }
                    r21 = r4
                    java.lang.String r4 = "replyToId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x0374 }
                    r22 = r4
                    java.lang.String r4 = "threadParticipantsIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x0374 }
                    r23 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0374 }
                    r4.<init>()     // Catch:{ all -> 0x0374 }
                    r24 = r3
                    androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0374 }
                    r3.<init>()     // Catch:{ all -> 0x0374 }
                    r25 = r15
                    androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0374 }
                    r15.<init>()     // Catch:{ all -> 0x0374 }
                L_0x00ba:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x0374 }
                    if (r26 == 0) goto L_0x0108
                    r26 = r14
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x0374 }
                    java.lang.Object r27 = r4.get(r14)     // Catch:{ all -> 0x0374 }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x0374 }
                    if (r27 != 0) goto L_0x00d9
                    r27 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x0374 }
                    r13.<init>()     // Catch:{ all -> 0x0374 }
                    r4.put(r14, r13)     // Catch:{ all -> 0x0374 }
                    goto L_0x00db
                L_0x00d9:
                    r27 = r13
                L_0x00db:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x0374 }
                    java.lang.Object r14 = r3.get(r13)     // Catch:{ all -> 0x0374 }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x0374 }
                    if (r14 != 0) goto L_0x00ef
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0374 }
                    r14.<init>()     // Catch:{ all -> 0x0374 }
                    r3.put(r13, r14)     // Catch:{ all -> 0x0374 }
                L_0x00ef:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x0374 }
                    java.lang.Object r14 = r15.get(r13)     // Catch:{ all -> 0x0374 }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x0374 }
                    if (r14 != 0) goto L_0x0103
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0374 }
                    r14.<init>()     // Catch:{ all -> 0x0374 }
                    r15.put(r13, r14)     // Catch:{ all -> 0x0374 }
                L_0x0103:
                    r14 = r26
                    r13 = r27
                    goto L_0x00ba
                L_0x0108:
                    r27 = r13
                    r26 = r14
                    r13 = -1
                    r2.moveToPosition(r13)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    r13.m1018x6508f06f(r4)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    r13.m1019x19d065(r3)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    r13.m1019x19d065(r15)     // Catch:{ all -> 0x0374 }
                    boolean r13 = r2.moveToFirst()     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x0358
                    boolean r13 = r2.isNull(r0)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    boolean r13 = r2.isNull(r5)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    boolean r13 = r2.isNull(r6)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    boolean r13 = r2.isNull(r7)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    boolean r13 = r2.isNull(r8)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    boolean r13 = r2.isNull(r9)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    boolean r13 = r2.isNull(r10)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    boolean r13 = r2.isNull(r11)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    boolean r13 = r2.isNull(r12)     // Catch:{ all -> 0x0374 }
                    if (r13 == 0) goto L_0x01eb
                    r13 = r27
                    boolean r14 = r2.isNull(r13)     // Catch:{ all -> 0x0374 }
                    if (r14 == 0) goto L_0x01e8
                    r14 = r26
                    boolean r26 = r2.isNull(r14)     // Catch:{ all -> 0x0374 }
                    if (r26 == 0) goto L_0x01ef
                    r26 = r15
                    r15 = r25
                    boolean r25 = r2.isNull(r15)     // Catch:{ all -> 0x0374 }
                    if (r25 == 0) goto L_0x01f3
                    r25 = r3
                    r3 = r24
                    boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x0374 }
                    if (r24 == 0) goto L_0x01f7
                    r24 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x0374 }
                    if (r16 == 0) goto L_0x01e5
                    r16 = r4
                    r4 = r17
                    boolean r17 = r2.isNull(r4)     // Catch:{ all -> 0x0374 }
                    if (r17 == 0) goto L_0x01e2
                    r17 = r4
                    r4 = r18
                    boolean r18 = r2.isNull(r4)     // Catch:{ all -> 0x0374 }
                    if (r18 == 0) goto L_0x01df
                    r18 = r4
                    r4 = r19
                    boolean r19 = r2.isNull(r4)     // Catch:{ all -> 0x0374 }
                    if (r19 == 0) goto L_0x01dc
                    r19 = r4
                    r4 = r20
                    boolean r20 = r2.isNull(r4)     // Catch:{ all -> 0x0374 }
                    if (r20 == 0) goto L_0x01d9
                    r20 = r4
                    r4 = r21
                    boolean r21 = r2.isNull(r4)     // Catch:{ all -> 0x0374 }
                    if (r21 == 0) goto L_0x01d6
                    r21 = r4
                    r4 = r22
                    boolean r22 = r2.isNull(r4)     // Catch:{ all -> 0x0374 }
                    if (r22 == 0) goto L_0x01d3
                    r22 = r4
                    r4 = r23
                    boolean r23 = r2.isNull(r4)     // Catch:{ all -> 0x0374 }
                    if (r23 != 0) goto L_0x01d0
                    goto L_0x01fb
                L_0x01d0:
                    r4 = 0
                    goto L_0x0318
                L_0x01d3:
                    r22 = r4
                    goto L_0x01f9
                L_0x01d6:
                    r21 = r4
                    goto L_0x01f9
                L_0x01d9:
                    r20 = r4
                    goto L_0x01f9
                L_0x01dc:
                    r19 = r4
                    goto L_0x01f9
                L_0x01df:
                    r18 = r4
                    goto L_0x01f9
                L_0x01e2:
                    r17 = r4
                    goto L_0x01f9
                L_0x01e5:
                    r16 = r4
                    goto L_0x01f9
                L_0x01e8:
                    r14 = r26
                    goto L_0x01ef
                L_0x01eb:
                    r14 = r26
                    r13 = r27
                L_0x01ef:
                    r26 = r15
                    r15 = r25
                L_0x01f3:
                    r25 = r3
                    r3 = r24
                L_0x01f7:
                    r24 = r4
                L_0x01f9:
                    r4 = r23
                L_0x01fb:
                    java.lang.String r28 = r2.getString(r0)     // Catch:{ all -> 0x0374 }
                    java.lang.String r29 = r2.getString(r5)     // Catch:{ all -> 0x0374 }
                    java.lang.String r30 = r2.getString(r6)     // Catch:{ all -> 0x0374 }
                    java.lang.String r31 = r2.getString(r7)     // Catch:{ all -> 0x0374 }
                    java.lang.String r32 = r2.getString(r8)     // Catch:{ all -> 0x0374 }
                    int r5 = r2.getInt(r9)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter r6 = r6.__syncStatusConverter     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.client.utils.SyncStatus r33 = r6.stringToSyncStatus(r5)     // Catch:{ all -> 0x0374 }
                    int r34 = r2.getInt(r10)     // Catch:{ all -> 0x0374 }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x0374 }
                    if (r5 == 0) goto L_0x0229
                    r5 = 0
                    goto L_0x0231
                L_0x0229:
                    long r5 = r2.getLong(r11)     // Catch:{ all -> 0x0374 }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0374 }
                L_0x0231:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x0374 }
                    java.util.Date r35 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x0374 }
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x0374 }
                    if (r5 == 0) goto L_0x0243
                    r5 = 0
                    goto L_0x024b
                L_0x0243:
                    long r5 = r2.getLong(r12)     // Catch:{ all -> 0x0374 }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0374 }
                L_0x024b:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x0374 }
                    java.util.Date r36 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x0374 }
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x0374 }
                    if (r5 == 0) goto L_0x025d
                    r5 = 0
                    goto L_0x0265
                L_0x025d:
                    long r5 = r2.getLong(r13)     // Catch:{ all -> 0x0374 }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0374 }
                L_0x0265:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x0374 }
                    java.util.Date r37 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x0374 }
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x0374 }
                    if (r5 == 0) goto L_0x0277
                    r5 = 0
                    goto L_0x027f
                L_0x0277:
                    long r5 = r2.getLong(r14)     // Catch:{ all -> 0x0374 }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0374 }
                L_0x027f:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x0374 }
                    java.util.Date r38 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x0374 }
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x0374 }
                    if (r5 == 0) goto L_0x0291
                    r5 = 0
                    goto L_0x0299
                L_0x0291:
                    long r5 = r2.getLong(r15)     // Catch:{ all -> 0x0374 }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0374 }
                L_0x0299:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x0374 }
                    java.util.Date r39 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x0374 }
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r5 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r5 = r5.__listConverter     // Catch:{ all -> 0x0374 }
                    java.util.List r40 = r5.stringToStringList(r3)     // Catch:{ all -> 0x0374 }
                    r3 = r16
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r5 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r5 = r5.__mapConverter     // Catch:{ all -> 0x0374 }
                    java.util.Map r41 = r5.stringToMap(r3)     // Catch:{ all -> 0x0374 }
                    r3 = r17
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r5 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r5 = r5.__mapConverter     // Catch:{ all -> 0x0374 }
                    java.util.Map r42 = r5.stringToMap(r3)     // Catch:{ all -> 0x0374 }
                    r3 = r18
                    java.lang.String r43 = r2.getString(r3)     // Catch:{ all -> 0x0374 }
                    r3 = r19
                    java.lang.String r44 = r2.getString(r3)     // Catch:{ all -> 0x0374 }
                    r3 = r20
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x0374 }
                    if (r3 == 0) goto L_0x02ea
                    r3 = r21
                    r45 = 1
                    goto L_0x02ef
                L_0x02ea:
                    r3 = 0
                    r3 = r21
                    r45 = 0
                L_0x02ef:
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r5 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r5 = r5.__extraDataConverter     // Catch:{ all -> 0x0374 }
                    java.util.Map r46 = r5.stringToMap(r3)     // Catch:{ all -> 0x0374 }
                    r3 = r22
                    java.lang.String r47 = r2.getString(r3)     // Catch:{ all -> 0x0374 }
                    java.lang.String r3 = r2.getString(r4)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r4 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r4 = r4.__listConverter     // Catch:{ all -> 0x0374 }
                    java.util.List r48 = r4.stringToStringList(r3)     // Catch:{ all -> 0x0374 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r4 = new io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity     // Catch:{ all -> 0x0374 }
                    r27 = r4
                    r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48)     // Catch:{ all -> 0x0374 }
                L_0x0318:
                    java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x0374 }
                    r5 = r24
                    java.lang.Object r3 = r5.get(r3)     // Catch:{ all -> 0x0374 }
                    java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x0374 }
                    if (r3 != 0) goto L_0x032b
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0374 }
                    r3.<init>()     // Catch:{ all -> 0x0374 }
                L_0x032b:
                    java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x0374 }
                    r6 = r25
                    java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x0374 }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0374 }
                    if (r5 != 0) goto L_0x033e
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0374 }
                    r5.<init>()     // Catch:{ all -> 0x0374 }
                L_0x033e:
                    java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x0374 }
                    r6 = r26
                    java.lang.Object r0 = r6.get(r0)     // Catch:{ all -> 0x0374 }
                    java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0374 }
                    if (r0 != 0) goto L_0x0351
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0374 }
                    r0.<init>()     // Catch:{ all -> 0x0374 }
                L_0x0351:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r6 = new io.getstream.chat.android.livedata.repository.domain.message.MessageEntity     // Catch:{ all -> 0x0374 }
                    r6.<init>(r4, r3, r5, r0)     // Catch:{ all -> 0x0374 }
                    r4 = r6
                    goto L_0x0359
                L_0x0358:
                    r4 = 0
                L_0x0359:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x0374 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x0374 }
                    r0.setTransactionSuccessful()     // Catch:{ all -> 0x0374 }
                    r2.close()     // Catch:{ all -> 0x037e }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x037e }
                    r0.release()     // Catch:{ all -> 0x037e }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r4
                L_0x0374:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x037e }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x037e }
                    r2.release()     // Catch:{ all -> 0x037e }
                    throw r0     // Catch:{ all -> 0x037e }
                L_0x037e:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.C502520.call():io.getstream.chat.android.livedata.repository.domain.message.MessageEntity");
            }
        }, continuation);
    }

    public Object selectSyncNeeded(SyncStatus syncStatus, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stream_chat_message WHERE stream_chat_message.syncStatus IN (?) ORDER BY createdAt ASC", 1);
        acquire.bindLong(1, (long) this.__syncStatusConverter.syncStatusToString(syncStatus));
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<MessageEntity>>() {
            /* JADX WARNING: Removed duplicated region for block: B:101:0x0303 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x030c A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0353 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x036a A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x0381 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x0386 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x023f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0241 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0259 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x025b A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0273 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0275 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x028d A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x028f A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02a7 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x02a9 A[Catch:{ all -> 0x03cd, all -> 0x03d7 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity> call() throws java.lang.Exception {
                /*
                    r52 = this;
                    r1 = r52
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.beginTransaction()
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x03d7 }
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = "cid"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r6 = "userId"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r7 = "text"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r8 = "type"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x03cd }
                    java.lang.String r9 = "syncStatus"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x03cd }
                    java.lang.String r10 = "replyCount"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x03cd }
                    java.lang.String r11 = "createdAt"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x03cd }
                    java.lang.String r12 = "createdLocallyAt"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r12)     // Catch:{ all -> 0x03cd }
                    java.lang.String r13 = "updatedAt"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r13)     // Catch:{ all -> 0x03cd }
                    java.lang.String r14 = "updatedLocallyAt"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r14)     // Catch:{ all -> 0x03cd }
                    java.lang.String r15 = "deletedAt"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r15)     // Catch:{ all -> 0x03cd }
                    java.lang.String r3 = "mentionedUsersId"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r4 = "reactionCounts"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r16 = r4
                    java.lang.String r4 = "reactionScores"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r17 = r4
                    java.lang.String r4 = "parentId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r18 = r4
                    java.lang.String r4 = "command"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r19 = r4
                    java.lang.String r4 = "shadowed"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r20 = r4
                    java.lang.String r4 = "extraData"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r21 = r4
                    java.lang.String r4 = "replyToId"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r22 = r4
                    java.lang.String r4 = "threadParticipantsIds"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x03cd }
                    r23 = r4
                    androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                    r24 = r3
                    androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r3.<init>()     // Catch:{ all -> 0x03cd }
                    r25 = r15
                    androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x03cd }
                    r15.<init>()     // Catch:{ all -> 0x03cd }
                L_0x00ba:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0108
                    r26 = r14
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r27 = r4.get(r14)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x03cd }
                    if (r27 != 0) goto L_0x00d9
                    r27 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r13.<init>()     // Catch:{ all -> 0x03cd }
                    r4.put(r14, r13)     // Catch:{ all -> 0x03cd }
                    goto L_0x00db
                L_0x00d9:
                    r27 = r13
                L_0x00db:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r3.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x00ef
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r3.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x00ef:
                    java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.Object r14 = r15.get(r13)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03cd }
                    if (r14 != 0) goto L_0x0103
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r14.<init>()     // Catch:{ all -> 0x03cd }
                    r15.put(r13, r14)     // Catch:{ all -> 0x03cd }
                L_0x0103:
                    r14 = r26
                    r13 = r27
                    goto L_0x00ba
                L_0x0108:
                    r27 = r13
                    r26 = r14
                    r13 = -1
                    r2.moveToPosition(r13)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1018x6508f06f(r4)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r13 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    r13.m1019x19d065(r15)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x03cd }
                    r13.<init>(r14)     // Catch:{ all -> 0x03cd }
                L_0x0128:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x03b1
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r7)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r8)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r9)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r10)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    boolean r14 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r14 == 0) goto L_0x01fd
                    r14 = r27
                    boolean r27 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r27 == 0) goto L_0x01ff
                    r27 = r13
                    r13 = r26
                    boolean r26 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r26 == 0) goto L_0x0203
                    r26 = r15
                    r15 = r25
                    boolean r25 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r25 == 0) goto L_0x0207
                    r25 = r3
                    r3 = r24
                    boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x03cd }
                    if (r24 == 0) goto L_0x020b
                    r24 = r4
                    r4 = r16
                    boolean r16 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r16 == 0) goto L_0x01fa
                    r16 = r4
                    r4 = r17
                    boolean r17 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r17 == 0) goto L_0x01f7
                    r17 = r4
                    r4 = r18
                    boolean r18 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r18 == 0) goto L_0x01f4
                    r18 = r4
                    r4 = r19
                    boolean r19 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x01f1
                    r19 = r4
                    r4 = r20
                    boolean r20 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r20 == 0) goto L_0x01ee
                    r20 = r4
                    r4 = r21
                    boolean r21 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r21 == 0) goto L_0x01eb
                    r21 = r4
                    r4 = r22
                    boolean r22 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r22 == 0) goto L_0x01e8
                    r22 = r4
                    r4 = r23
                    boolean r23 = r2.isNull(r4)     // Catch:{ all -> 0x03cd }
                    if (r23 != 0) goto L_0x01db
                    goto L_0x020f
                L_0x01db:
                    r23 = r5
                    r50 = r6
                    r6 = r19
                    r19 = r16
                    r16 = r3
                    r3 = 0
                    goto L_0x0343
                L_0x01e8:
                    r22 = r4
                    goto L_0x020d
                L_0x01eb:
                    r21 = r4
                    goto L_0x020d
                L_0x01ee:
                    r20 = r4
                    goto L_0x020d
                L_0x01f1:
                    r19 = r4
                    goto L_0x020d
                L_0x01f4:
                    r18 = r4
                    goto L_0x020d
                L_0x01f7:
                    r17 = r4
                    goto L_0x020d
                L_0x01fa:
                    r16 = r4
                    goto L_0x020d
                L_0x01fd:
                    r14 = r27
                L_0x01ff:
                    r27 = r13
                    r13 = r26
                L_0x0203:
                    r26 = r15
                    r15 = r25
                L_0x0207:
                    r25 = r3
                    r3 = r24
                L_0x020b:
                    r24 = r4
                L_0x020d:
                    r4 = r23
                L_0x020f:
                    java.lang.String r29 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    java.lang.String r30 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r31 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    java.lang.String r32 = r2.getString(r7)     // Catch:{ all -> 0x03cd }
                    java.lang.String r33 = r2.getString(r8)     // Catch:{ all -> 0x03cd }
                    r23 = r5
                    int r5 = r2.getInt(r9)     // Catch:{ all -> 0x03cd }
                    r50 = r6
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.SyncStatusConverter r6 = r6.__syncStatusConverter     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.client.utils.SyncStatus r34 = r6.stringToSyncStatus(r5)     // Catch:{ all -> 0x03cd }
                    int r35 = r2.getInt(r10)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0241
                    r5 = 0
                    goto L_0x0249
                L_0x0241:
                    long r5 = r2.getLong(r11)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0249:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r36 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r12)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x025b
                    r5 = 0
                    goto L_0x0263
                L_0x025b:
                    long r5 = r2.getLong(r12)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0263:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r37 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r14)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x0275
                    r5 = 0
                    goto L_0x027d
                L_0x0275:
                    long r5 = r2.getLong(r14)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x027d:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r38 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r13)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x028f
                    r5 = 0
                    goto L_0x0297
                L_0x028f:
                    long r5 = r2.getLong(r13)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x0297:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r39 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    boolean r5 = r2.isNull(r15)     // Catch:{ all -> 0x03cd }
                    if (r5 == 0) goto L_0x02a9
                    r5 = 0
                    goto L_0x02b1
                L_0x02a9:
                    long r5 = r2.getLong(r15)     // Catch:{ all -> 0x03cd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x03cd }
                L_0x02b1:
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.DateConverter r6 = r6.__dateConverter     // Catch:{ all -> 0x03cd }
                    java.util.Date r40 = r6.fromTimestamp(r5)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r6 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r6 = r6.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r41 = r6.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    r5 = r16
                    java.lang.String r6 = r2.getString(r5)     // Catch:{ all -> 0x03cd }
                    r16 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r42 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r17
                    java.lang.String r6 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r17 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.MapConverter r3 = r3.__mapConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r43 = r3.stringToMap(r6)     // Catch:{ all -> 0x03cd }
                    r3 = r18
                    java.lang.String r44 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r6 = r19
                    java.lang.String r45 = r2.getString(r6)     // Catch:{ all -> 0x03cd }
                    r18 = r3
                    r3 = r20
                    int r19 = r2.getInt(r3)     // Catch:{ all -> 0x03cd }
                    if (r19 == 0) goto L_0x030c
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 1
                    goto L_0x0316
                L_0x030c:
                    r19 = 0
                    r20 = r3
                    r19 = r5
                    r3 = r21
                    r46 = 0
                L_0x0316:
                    java.lang.String r5 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    r21 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r3 = r3.__extraDataConverter     // Catch:{ all -> 0x03cd }
                    java.util.Map r47 = r3.stringToMap(r5)     // Catch:{ all -> 0x03cd }
                    r3 = r22
                    java.lang.String r48 = r2.getString(r3)     // Catch:{ all -> 0x03cd }
                    java.lang.String r5 = r2.getString(r4)     // Catch:{ all -> 0x03cd }
                    r22 = r3
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.database.converter.ListConverter r3 = r3.__listConverter     // Catch:{ all -> 0x03cd }
                    java.util.List r49 = r3.stringToStringList(r5)     // Catch:{ all -> 0x03cd }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r3 = new io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity     // Catch:{ all -> 0x03cd }
                    r28 = r3
                    r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ all -> 0x03cd }
                L_0x0343:
                    java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r28 = r4
                    r4 = r24
                    java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x03cd }
                    if (r5 != 0) goto L_0x0358
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r5.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0358:
                    r24 = r4
                    java.lang.String r4 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r29 = r6
                    r6 = r25
                    java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x03cd }
                    if (r4 != 0) goto L_0x036f
                    java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r4.<init>()     // Catch:{ all -> 0x03cd }
                L_0x036f:
                    r25 = r6
                    java.lang.String r6 = r2.getString(r0)     // Catch:{ all -> 0x03cd }
                    r30 = r0
                    r0 = r26
                    java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x03cd }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x03cd }
                    if (r6 != 0) goto L_0x0386
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x03cd }
                    r6.<init>()     // Catch:{ all -> 0x03cd }
                L_0x0386:
                    r26 = r0
                    io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageEntity     // Catch:{ all -> 0x03cd }
                    r0.<init>(r3, r5, r4, r6)     // Catch:{ all -> 0x03cd }
                    r3 = r27
                    r3.add(r0)     // Catch:{ all -> 0x03cd }
                    r27 = r14
                    r5 = r23
                    r4 = r24
                    r23 = r28
                    r0 = r30
                    r6 = r50
                    r24 = r16
                    r16 = r19
                    r19 = r29
                    r51 = r13
                    r13 = r3
                    r3 = r25
                    r25 = r15
                    r15 = r26
                    r26 = r51
                    goto L_0x0128
                L_0x03b1:
                    r3 = r13
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this     // Catch:{ all -> 0x03cd }
                    androidx.room.RoomDatabase r0 = r0.__db     // Catch:{ all -> 0x03cd }
                    r0.setTransactionSuccessful()     // Catch:{ all -> 0x03cd }
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r0 = r0     // Catch:{ all -> 0x03d7 }
                    r0.release()     // Catch:{ all -> 0x03d7 }
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r0 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    r0.endTransaction()
                    return r3
                L_0x03cd:
                    r0 = move-exception
                    r2.close()     // Catch:{ all -> 0x03d7 }
                    androidx.room.RoomSQLiteQuery r2 = r0     // Catch:{ all -> 0x03d7 }
                    r2.release()     // Catch:{ all -> 0x03d7 }
                    throw r0     // Catch:{ all -> 0x03d7 }
                L_0x03d7:
                    r0 = move-exception
                    io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.this
                    androidx.room.RoomDatabase r2 = r2.__db
                    r2.endTransaction()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.C502621.call():java.util.List");
            }
        }, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0255 A[Catch:{ all -> 0x02c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0259 A[Catch:{ all -> 0x02c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0263 A[Catch:{ all -> 0x02c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0267 A[Catch:{ all -> 0x02c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0287 A[Catch:{ all -> 0x02c0 }] */
    /* renamed from: __fetchRelationshipattachmentInnerEntityAsioGetstreamChatAndroidLivedataRepositoryDomainMessageAttachmentAttachmentEntity */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1018x6508f06f(androidx.collection.ArrayMap<java.lang.String, java.util.ArrayList<p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity>> r50) {
        /*
            r49 = this;
            r1 = r49
            r0 = r50
            java.lang.String r2 = "messageId"
            java.util.Set r3 = r50.keySet()
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0011
            return
        L_0x0011:
            int r4 = r50.size()
            r5 = 999(0x3e7, float:1.4E-42)
            r6 = 0
            if (r4 <= r5) goto L_0x0047
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>((int) r5)
            int r3 = r50.size()
            r4 = 0
        L_0x0024:
            r7 = 0
        L_0x0025:
            if (r4 >= r3) goto L_0x0041
            java.lang.Object r8 = r0.keyAt(r4)
            java.lang.Object r9 = r0.valueAt(r4)
            r2.put(r8, r9)
            int r4 = r4 + 1
            int r7 = r7 + 1
            if (r7 != r5) goto L_0x0025
            r1.m1018x6508f06f(r2)
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>((int) r5)
            goto L_0x0024
        L_0x0041:
            if (r7 <= 0) goto L_0x0046
            r1.m1018x6508f06f(r2)
        L_0x0046:
            return
        L_0x0047:
            java.lang.StringBuilder r4 = androidx.room.util.StringUtil.newStringBuilder()
            java.lang.String r5 = "SELECT `id`,`messageId`,`authorName`,`titleLink`,`thumbUrl`,`imageUrl`,`assetUrl`,`ogUrl`,`mimeType`,`fileSize`,`title`,`text`,`type`,`image`,`url`,`name`,`fallback`,`uploadFilePath`,`extraData`,`statusCode`,`errorMessage` FROM `attachment_inner_entity` WHERE `messageId` IN ("
            r4.append(r5)
            int r5 = r3.size()
            androidx.room.util.StringUtil.appendPlaceholders(r4, r5)
            java.lang.String r7 = ")"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            int r5 = r5 + r6
            androidx.room.RoomSQLiteQuery r4 = androidx.room.RoomSQLiteQuery.acquire(r4, r5)
            java.util.Iterator r3 = r3.iterator()
            r5 = 1
        L_0x006a:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0082
            java.lang.Object r7 = r3.next()
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L_0x007c
            r4.bindNull(r5)
            goto L_0x007f
        L_0x007c:
            r4.bindString(r5, r7)
        L_0x007f:
            int r5 = r5 + 1
            goto L_0x006a
        L_0x0082:
            androidx.room.RoomDatabase r3 = r1.__db
            r5 = 0
            android.database.Cursor r3 = androidx.room.util.DBUtil.query(r3, r4, r6, r5)
            int r4 = androidx.room.util.CursorUtil.getColumnIndex(r3, r2)     // Catch:{ all -> 0x02c0 }
            r7 = -1
            if (r4 != r7) goto L_0x0094
            r3.close()
            return
        L_0x0094:
            java.lang.String r8 = "id"
            int r8 = androidx.room.util.CursorUtil.getColumnIndex(r3, r8)     // Catch:{ all -> 0x02c0 }
            int r2 = androidx.room.util.CursorUtil.getColumnIndex(r3, r2)     // Catch:{ all -> 0x02c0 }
            java.lang.String r9 = "authorName"
            int r9 = androidx.room.util.CursorUtil.getColumnIndex(r3, r9)     // Catch:{ all -> 0x02c0 }
            java.lang.String r10 = "titleLink"
            int r10 = androidx.room.util.CursorUtil.getColumnIndex(r3, r10)     // Catch:{ all -> 0x02c0 }
            java.lang.String r11 = "thumbUrl"
            int r11 = androidx.room.util.CursorUtil.getColumnIndex(r3, r11)     // Catch:{ all -> 0x02c0 }
            java.lang.String r12 = "imageUrl"
            int r12 = androidx.room.util.CursorUtil.getColumnIndex(r3, r12)     // Catch:{ all -> 0x02c0 }
            java.lang.String r13 = "assetUrl"
            int r13 = androidx.room.util.CursorUtil.getColumnIndex(r3, r13)     // Catch:{ all -> 0x02c0 }
            java.lang.String r14 = "ogUrl"
            int r14 = androidx.room.util.CursorUtil.getColumnIndex(r3, r14)     // Catch:{ all -> 0x02c0 }
            java.lang.String r15 = "mimeType"
            int r15 = androidx.room.util.CursorUtil.getColumnIndex(r3, r15)     // Catch:{ all -> 0x02c0 }
            java.lang.String r5 = "fileSize"
            int r5 = androidx.room.util.CursorUtil.getColumnIndex(r3, r5)     // Catch:{ all -> 0x02c0 }
            java.lang.String r6 = "title"
            int r6 = androidx.room.util.CursorUtil.getColumnIndex(r3, r6)     // Catch:{ all -> 0x02c0 }
            java.lang.String r7 = "text"
            int r7 = androidx.room.util.CursorUtil.getColumnIndex(r3, r7)     // Catch:{ all -> 0x02c0 }
            r17 = r8
            java.lang.String r8 = "type"
            int r8 = androidx.room.util.CursorUtil.getColumnIndex(r3, r8)     // Catch:{ all -> 0x02c0 }
            java.lang.String r1 = "image"
            int r1 = androidx.room.util.CursorUtil.getColumnIndex(r3, r1)     // Catch:{ all -> 0x02c0 }
            r18 = r1
            java.lang.String r1 = "url"
            int r1 = androidx.room.util.CursorUtil.getColumnIndex(r3, r1)     // Catch:{ all -> 0x02c0 }
            r19 = r1
            java.lang.String r1 = "name"
            int r1 = androidx.room.util.CursorUtil.getColumnIndex(r3, r1)     // Catch:{ all -> 0x02c0 }
            r20 = r1
            java.lang.String r1 = "fallback"
            int r1 = androidx.room.util.CursorUtil.getColumnIndex(r3, r1)     // Catch:{ all -> 0x02c0 }
            r21 = r1
            java.lang.String r1 = "uploadFilePath"
            int r1 = androidx.room.util.CursorUtil.getColumnIndex(r3, r1)     // Catch:{ all -> 0x02c0 }
            r22 = r1
            java.lang.String r1 = "extraData"
            int r1 = androidx.room.util.CursorUtil.getColumnIndex(r3, r1)     // Catch:{ all -> 0x02c0 }
            r23 = r1
            java.lang.String r1 = "statusCode"
            int r1 = androidx.room.util.CursorUtil.getColumnIndex(r3, r1)     // Catch:{ all -> 0x02c0 }
            r24 = r1
            java.lang.String r1 = "errorMessage"
            int r1 = androidx.room.util.CursorUtil.getColumnIndex(r3, r1)     // Catch:{ all -> 0x02c0 }
        L_0x0120:
            boolean r25 = r3.moveToNext()     // Catch:{ all -> 0x02c0 }
            if (r25 == 0) goto L_0x02bc
            r25 = r1
            java.lang.String r1 = r3.getString(r4)     // Catch:{ all -> 0x02c0 }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x02c0 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x02c0 }
            if (r1 == 0) goto L_0x0292
            r0 = -1
            if (r2 != r0) goto L_0x013a
            r27 = 0
            goto L_0x0140
        L_0x013a:
            java.lang.String r16 = r3.getString(r2)     // Catch:{ all -> 0x02c0 }
            r27 = r16
        L_0x0140:
            if (r9 != r0) goto L_0x0145
            r28 = 0
            goto L_0x014b
        L_0x0145:
            java.lang.String r16 = r3.getString(r9)     // Catch:{ all -> 0x02c0 }
            r28 = r16
        L_0x014b:
            if (r10 != r0) goto L_0x0150
            r29 = 0
            goto L_0x0156
        L_0x0150:
            java.lang.String r16 = r3.getString(r10)     // Catch:{ all -> 0x02c0 }
            r29 = r16
        L_0x0156:
            if (r11 != r0) goto L_0x015b
            r30 = 0
            goto L_0x0161
        L_0x015b:
            java.lang.String r16 = r3.getString(r11)     // Catch:{ all -> 0x02c0 }
            r30 = r16
        L_0x0161:
            if (r12 != r0) goto L_0x0166
            r31 = 0
            goto L_0x016c
        L_0x0166:
            java.lang.String r16 = r3.getString(r12)     // Catch:{ all -> 0x02c0 }
            r31 = r16
        L_0x016c:
            if (r13 != r0) goto L_0x0171
            r32 = 0
            goto L_0x0177
        L_0x0171:
            java.lang.String r16 = r3.getString(r13)     // Catch:{ all -> 0x02c0 }
            r32 = r16
        L_0x0177:
            if (r14 != r0) goto L_0x017c
            r33 = 0
            goto L_0x0182
        L_0x017c:
            java.lang.String r16 = r3.getString(r14)     // Catch:{ all -> 0x02c0 }
            r33 = r16
        L_0x0182:
            if (r15 != r0) goto L_0x0187
            r34 = 0
            goto L_0x018d
        L_0x0187:
            java.lang.String r16 = r3.getString(r15)     // Catch:{ all -> 0x02c0 }
            r34 = r16
        L_0x018d:
            if (r5 != r0) goto L_0x0192
            r35 = 0
            goto L_0x0198
        L_0x0192:
            int r16 = r3.getInt(r5)     // Catch:{ all -> 0x02c0 }
            r35 = r16
        L_0x0198:
            if (r6 != r0) goto L_0x019d
            r36 = 0
            goto L_0x01a3
        L_0x019d:
            java.lang.String r16 = r3.getString(r6)     // Catch:{ all -> 0x02c0 }
            r36 = r16
        L_0x01a3:
            if (r7 != r0) goto L_0x01a8
            r37 = 0
            goto L_0x01ae
        L_0x01a8:
            java.lang.String r16 = r3.getString(r7)     // Catch:{ all -> 0x02c0 }
            r37 = r16
        L_0x01ae:
            if (r8 != r0) goto L_0x01b9
            r38 = 0
        L_0x01b2:
            r48 = r18
            r18 = r2
            r2 = r48
            goto L_0x01c0
        L_0x01b9:
            java.lang.String r16 = r3.getString(r8)     // Catch:{ all -> 0x02c0 }
            r38 = r16
            goto L_0x01b2
        L_0x01c0:
            if (r2 != r0) goto L_0x01cb
            r39 = 0
        L_0x01c4:
            r48 = r19
            r19 = r2
            r2 = r48
            goto L_0x01d2
        L_0x01cb:
            java.lang.String r16 = r3.getString(r2)     // Catch:{ all -> 0x02c0 }
            r39 = r16
            goto L_0x01c4
        L_0x01d2:
            if (r2 != r0) goto L_0x01dd
            r40 = 0
        L_0x01d6:
            r48 = r20
            r20 = r2
            r2 = r48
            goto L_0x01e4
        L_0x01dd:
            java.lang.String r16 = r3.getString(r2)     // Catch:{ all -> 0x02c0 }
            r40 = r16
            goto L_0x01d6
        L_0x01e4:
            if (r2 != r0) goto L_0x01ef
            r41 = 0
        L_0x01e8:
            r48 = r21
            r21 = r2
            r2 = r48
            goto L_0x01f6
        L_0x01ef:
            java.lang.String r16 = r3.getString(r2)     // Catch:{ all -> 0x02c0 }
            r41 = r16
            goto L_0x01e8
        L_0x01f6:
            if (r2 != r0) goto L_0x0201
            r42 = 0
        L_0x01fa:
            r48 = r22
            r22 = r2
            r2 = r48
            goto L_0x0208
        L_0x0201:
            java.lang.String r16 = r3.getString(r2)     // Catch:{ all -> 0x02c0 }
            r42 = r16
            goto L_0x01fa
        L_0x0208:
            if (r2 != r0) goto L_0x0213
            r43 = 0
        L_0x020c:
            r48 = r23
            r23 = r2
            r2 = r48
            goto L_0x021a
        L_0x0213:
            java.lang.String r16 = r3.getString(r2)     // Catch:{ all -> 0x02c0 }
            r43 = r16
            goto L_0x020c
        L_0x021a:
            if (r2 != r0) goto L_0x0228
            r46 = r2
            r47 = r4
            r0 = r24
            r4 = -1
            r45 = 0
            r2 = r49
            goto L_0x023d
        L_0x0228:
            java.lang.String r0 = r3.getString(r2)     // Catch:{ all -> 0x02c0 }
            r46 = r2
            r47 = r4
            r2 = r49
            io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter r4 = r2.__extraDataConverter     // Catch:{ all -> 0x02c0 }
            java.util.Map r0 = r4.stringToMap(r0)     // Catch:{ all -> 0x02c0 }
            r45 = r0
            r0 = r24
            r4 = -1
        L_0x023d:
            if (r0 == r4) goto L_0x0249
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x02c0 }
            if (r16 == 0) goto L_0x0246
            goto L_0x0249
        L_0x0246:
            r2 = r25
            goto L_0x0253
        L_0x0249:
            r2 = r25
            if (r2 == r4) goto L_0x0275
            boolean r16 = r3.isNull(r2)     // Catch:{ all -> 0x02c0 }
            if (r16 != 0) goto L_0x0275
        L_0x0253:
            if (r0 != r4) goto L_0x0259
            r24 = r0
            r0 = 0
            goto L_0x0261
        L_0x0259:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x02c0 }
            r24 = r0
            r0 = r16
        L_0x0261:
            if (r2 != r4) goto L_0x0267
            r25 = r2
            r4 = 0
            goto L_0x026d
        L_0x0267:
            java.lang.String r4 = r3.getString(r2)     // Catch:{ all -> 0x02c0 }
            r25 = r2
        L_0x026d:
            io.getstream.chat.android.livedata.repository.domain.message.attachment.UploadStateEntity r2 = new io.getstream.chat.android.livedata.repository.domain.message.attachment.UploadStateEntity     // Catch:{ all -> 0x02c0 }
            r2.<init>(r0, r4)     // Catch:{ all -> 0x02c0 }
            r44 = r2
            goto L_0x027b
        L_0x0275:
            r24 = r0
            r25 = r2
            r44 = 0
        L_0x027b:
            io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity r0 = new io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity     // Catch:{ all -> 0x02c0 }
            r26 = r0
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45)     // Catch:{ all -> 0x02c0 }
            r2 = r17
            r4 = -1
            if (r2 == r4) goto L_0x028e
            int r4 = r3.getInt(r2)     // Catch:{ all -> 0x02c0 }
            r0.setId(r4)     // Catch:{ all -> 0x02c0 }
        L_0x028e:
            r1.add(r0)     // Catch:{ all -> 0x02c0 }
            goto L_0x02a4
        L_0x0292:
            r47 = r4
            r46 = r23
            r23 = r22
            r22 = r21
            r21 = r20
            r20 = r19
            r19 = r18
            r18 = r2
            r2 = r17
        L_0x02a4:
            r0 = r50
            r17 = r2
            r2 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r1 = r25
            r23 = r46
            r4 = r47
            goto L_0x0120
        L_0x02bc:
            r3.close()
            return
        L_0x02c0:
            r0 = move-exception
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl.m1018x6508f06f(androidx.collection.ArrayMap):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: __fetchRelationshipstreamChatReactionAsioGetstreamChatAndroidLivedataRepositoryDomainReactionReactionEntity */
    public void m1019x19d065(ArrayMap<String, ArrayList<ReactionEntity>> arrayMap) {
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        Date date;
        Date date2;
        Date date3;
        boolean z;
        Map<String, Object> map;
        SyncStatus syncStatus;
        Long l;
        Long l2;
        Long l3;
        int i3;
        ArrayMap<String, ArrayList<ReactionEntity>> arrayMap2 = arrayMap;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap3 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = arrayMap.size();
                int i4 = 0;
                loop0:
                while (true) {
                    i3 = 0;
                    while (i4 < size) {
                        arrayMap3.put(arrayMap2.keyAt(i4), arrayMap2.valueAt(i4));
                        i4++;
                        i3++;
                        if (i3 == 999) {
                            m1019x19d065(arrayMap3);
                            arrayMap3 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        }
                    }
                    break loop0;
                }
                if (i3 > 0) {
                    m1019x19d065(arrayMap3);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `id`,`messageId`,`userId`,`type`,`score`,`createdAt`,`updatedAt`,`deletedAt`,`enforceUnique`,`extraData`,`syncStatus` FROM `stream_chat_reaction` WHERE `messageId` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i5 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i5);
                } else {
                    acquire.bindString(i5, next);
                }
                i5++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
                if (columnIndex != -1) {
                    int columnIndex2 = CursorUtil.getColumnIndex(query, "id");
                    int columnIndex3 = CursorUtil.getColumnIndex(query, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
                    int columnIndex4 = CursorUtil.getColumnIndex(query, TagPeopleActivity.USER_ID);
                    int columnIndex5 = CursorUtil.getColumnIndex(query, "type");
                    int columnIndex6 = CursorUtil.getColumnIndex(query, FirebaseAnalytics.Param.SCORE);
                    int columnIndex7 = CursorUtil.getColumnIndex(query, "createdAt");
                    int columnIndex8 = CursorUtil.getColumnIndex(query, "updatedAt");
                    int columnIndex9 = CursorUtil.getColumnIndex(query, "deletedAt");
                    int columnIndex10 = CursorUtil.getColumnIndex(query, "enforceUnique");
                    int columnIndex11 = CursorUtil.getColumnIndex(query, "extraData");
                    int columnIndex12 = CursorUtil.getColumnIndex(query, "syncStatus");
                    while (query.moveToNext()) {
                        ArrayList arrayList = arrayMap2.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            int i6 = -1;
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
                                i2 = 0;
                            } else {
                                i2 = query.getInt(columnIndex6);
                            }
                            if (columnIndex7 == -1) {
                                i = columnIndex3;
                                date = null;
                            } else {
                                if (query.isNull(columnIndex7)) {
                                    i = columnIndex3;
                                    l3 = null;
                                } else {
                                    l3 = Long.valueOf(query.getLong(columnIndex7));
                                    i = columnIndex3;
                                }
                                date = this.__dateConverter.fromTimestamp(l3);
                                i6 = -1;
                            }
                            if (columnIndex8 == i6) {
                                date2 = null;
                            } else {
                                if (query.isNull(columnIndex8)) {
                                    l2 = null;
                                } else {
                                    l2 = Long.valueOf(query.getLong(columnIndex8));
                                }
                                date2 = this.__dateConverter.fromTimestamp(l2);
                                i6 = -1;
                            }
                            if (columnIndex9 == i6) {
                                date3 = null;
                            } else {
                                if (query.isNull(columnIndex9)) {
                                    l = null;
                                } else {
                                    l = Long.valueOf(query.getLong(columnIndex9));
                                }
                                date3 = this.__dateConverter.fromTimestamp(l);
                                i6 = -1;
                            }
                            if (columnIndex10 == i6) {
                                z = false;
                            } else {
                                z = query.getInt(columnIndex10) != 0;
                            }
                            if (columnIndex11 == i6) {
                                map = null;
                            } else {
                                map = this.__extraDataConverter.stringToMap(query.getString(columnIndex11));
                                i6 = -1;
                            }
                            if (columnIndex12 == i6) {
                                syncStatus = null;
                            } else {
                                syncStatus = this.__syncStatusConverter.stringToSyncStatus(query.getInt(columnIndex12));
                            }
                            ReactionEntity reactionEntity = new ReactionEntity(str, str2, str3, i2, date, date2, date3, z, map, syncStatus);
                            if (columnIndex2 != -1) {
                                reactionEntity.setId(query.getInt(columnIndex2));
                            }
                            arrayList.add(reactionEntity);
                        } else {
                            i = columnIndex3;
                        }
                        arrayMap2 = arrayMap;
                        columnIndex3 = i;
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }
}
