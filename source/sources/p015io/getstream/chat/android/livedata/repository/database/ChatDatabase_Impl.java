package p015io.getstream.chat.android.livedata.repository.database;

import android.os.Build;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p008db.SupportSQLiteDatabase;
import androidx.sqlite.p008db.SupportSQLiteOpenHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao;
import p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao_Impl;
import p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao;
import p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao_Impl;
import p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao;
import p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao_Impl;
import p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao;
import p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao_Impl;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao_Impl;
import p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao;
import p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao_Impl;
import p015io.getstream.chat.android.livedata.repository.domain.user.UserDao;
import p015io.getstream.chat.android.livedata.repository.domain.user.UserDao_Impl;

/* renamed from: io.getstream.chat.android.livedata.repository.database.ChatDatabase_Impl */
public final class ChatDatabase_Impl extends ChatDatabase {
    private volatile ChannelConfigDao _channelConfigDao;
    private volatile ChannelDao _channelDao;
    private volatile MessageDao _messageDao;
    private volatile QueryChannelsDao _queryChannelsDao;
    private volatile ReactionDao _reactionDao;
    private volatile SyncStateDao _syncStateDao;
    private volatile UserDao _userDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(38) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stream_channel_query` (`id` TEXT NOT NULL, `filter` TEXT NOT NULL, `cids` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `channel_sort_inner_entity` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `direction` INTEGER NOT NULL, `queryId` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stream_chat_message` (`id` TEXT NOT NULL, `cid` TEXT NOT NULL, `userId` TEXT NOT NULL, `text` TEXT NOT NULL, `type` TEXT NOT NULL, `syncStatus` INTEGER NOT NULL, `replyCount` INTEGER NOT NULL, `createdAt` INTEGER, `createdLocallyAt` INTEGER, `updatedAt` INTEGER, `updatedLocallyAt` INTEGER, `deletedAt` INTEGER, `mentionedUsersId` TEXT NOT NULL, `reactionCounts` TEXT NOT NULL, `reactionScores` TEXT NOT NULL, `parentId` TEXT, `command` TEXT, `shadowed` INTEGER NOT NULL, `extraData` TEXT NOT NULL, `replyToId` TEXT, `threadParticipantsIds` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_stream_chat_message_cid_createdAt` ON `stream_chat_message` (`cid`, `createdAt`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_stream_chat_message_syncStatus` ON `stream_chat_message` (`syncStatus`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `attachment_inner_entity` (`id` INTEGER NOT NULL, `messageId` TEXT NOT NULL, `authorName` TEXT, `titleLink` TEXT, `thumbUrl` TEXT, `imageUrl` TEXT, `assetUrl` TEXT, `ogUrl` TEXT, `mimeType` TEXT, `fileSize` INTEGER NOT NULL, `title` TEXT, `text` TEXT, `type` TEXT, `image` TEXT, `url` TEXT, `name` TEXT, `fallback` TEXT, `uploadFilePath` TEXT, `extraData` TEXT NOT NULL, `statusCode` INTEGER, `errorMessage` TEXT, PRIMARY KEY(`id`), FOREIGN KEY(`messageId`) REFERENCES `stream_chat_message`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_attachment_inner_entity_messageId` ON `attachment_inner_entity` (`messageId`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stream_chat_user` (`id` TEXT NOT NULL, `originalId` TEXT NOT NULL, `name` TEXT NOT NULL, `role` TEXT NOT NULL, `createdAt` INTEGER, `updatedAt` INTEGER, `lastActive` INTEGER, `invisible` INTEGER NOT NULL, `banned` INTEGER NOT NULL, `mutes` TEXT NOT NULL, `extraData` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_stream_chat_user_name` ON `stream_chat_user` (`name`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stream_chat_reaction` (`id` INTEGER NOT NULL, `messageId` TEXT NOT NULL, `userId` TEXT NOT NULL, `type` TEXT NOT NULL, `score` INTEGER NOT NULL, `createdAt` INTEGER, `updatedAt` INTEGER, `deletedAt` INTEGER, `enforceUnique` INTEGER NOT NULL, `extraData` TEXT NOT NULL, `syncStatus` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`messageId`) REFERENCES `stream_chat_message`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_stream_chat_reaction_messageId_userId_type` ON `stream_chat_reaction` (`messageId`, `userId`, `type`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_stream_chat_reaction_syncStatus` ON `stream_chat_reaction` (`syncStatus`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_stream_chat_reaction_messageId` ON `stream_chat_reaction` (`messageId`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stream_chat_channel_state` (`cid` TEXT NOT NULL, `type` TEXT NOT NULL, `channelId` TEXT NOT NULL, `cooldown` INTEGER NOT NULL, `createdByUserId` TEXT NOT NULL, `frozen` INTEGER NOT NULL, `hidden` INTEGER, `hideMessagesBefore` INTEGER, `members` TEXT NOT NULL, `reads` TEXT NOT NULL, `lastMessageAt` INTEGER, `lastMessageId` TEXT, `createdAt` INTEGER, `updatedAt` INTEGER, `deletedAt` INTEGER, `extraData` TEXT NOT NULL, `syncStatus` INTEGER NOT NULL, PRIMARY KEY(`cid`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_stream_chat_channel_state_syncStatus` ON `stream_chat_channel_state` (`syncStatus`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stream_chat_channel_config` (`channelType` TEXT NOT NULL, `createdAt` INTEGER, `updatedAt` INTEGER, `isTypingEvents` INTEGER NOT NULL, `isReadEvents` INTEGER NOT NULL, `isConnectEvents` INTEGER NOT NULL, `isSearch` INTEGER NOT NULL, `isReactionsEnabled` INTEGER NOT NULL, `isRepliesEnabled` INTEGER NOT NULL, `isMutes` INTEGER NOT NULL, `maxMessageLength` INTEGER NOT NULL, `automod` TEXT NOT NULL, `infinite` TEXT NOT NULL, `name` TEXT NOT NULL, PRIMARY KEY(`channelType`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `command_inner_entity` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `args` TEXT NOT NULL, `set` TEXT NOT NULL, `channelType` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`channelType`) REFERENCES `stream_chat_channel_config`(`channelType`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_command_inner_entity_channelType` ON `command_inner_entity` (`channelType`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stream_sync_state` (`userId` TEXT NOT NULL, `activeChannelIds` TEXT NOT NULL, `activeQueryIds` TEXT NOT NULL, `lastSyncedAt` INTEGER, `markedAllReadAt` INTEGER, PRIMARY KEY(`userId`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '597d61564f67f799a1d44f67551b916f')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stream_channel_query`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `channel_sort_inner_entity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stream_chat_message`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `attachment_inner_entity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stream_chat_user`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stream_chat_reaction`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stream_chat_channel_state`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stream_chat_channel_config`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `command_inner_entity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stream_sync_state`");
                if (ChatDatabase_Impl.this.mCallbacks != null) {
                    int size = ChatDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ChatDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (ChatDatabase_Impl.this.mCallbacks != null) {
                    int size = ChatDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ChatDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = ChatDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                ChatDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (ChatDatabase_Impl.this.mCallbacks != null) {
                    int size = ChatDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ChatDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(3);
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("filter", new TableInfo.Column("filter", "TEXT", true, 0, (String) null, 1));
                hashMap.put("cids", new TableInfo.Column("cids", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("stream_channel_query", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "stream_channel_query");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "stream_channel_query(io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap2.put(QuerySort.KEY_DIRECTION, new TableInfo.Column(QuerySort.KEY_DIRECTION, "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("queryId", new TableInfo.Column("queryId", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("channel_sort_inner_entity", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "channel_sort_inner_entity");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "channel_sort_inner_entity(io.getstream.chat.android.livedata.repository.domain.queryChannels.ChannelSortInnerEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(21);
                hashMap3.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("cid", new TableInfo.Column("cid", "TEXT", true, 0, (String) null, 1));
                hashMap3.put(TagPeopleActivity.USER_ID, new TableInfo.Column(TagPeopleActivity.USER_ID, "TEXT", true, 0, (String) null, 1));
                hashMap3.put("text", new TableInfo.Column("text", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("type", new TableInfo.Column("type", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("syncStatus", new TableInfo.Column("syncStatus", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("replyCount", new TableInfo.Column("replyCount", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("createdLocallyAt", new TableInfo.Column("createdLocallyAt", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("updatedLocallyAt", new TableInfo.Column("updatedLocallyAt", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("deletedAt", new TableInfo.Column("deletedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("mentionedUsersId", new TableInfo.Column("mentionedUsersId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("reactionCounts", new TableInfo.Column("reactionCounts", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("reactionScores", new TableInfo.Column("reactionScores", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("parentId", new TableInfo.Column("parentId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("command", new TableInfo.Column("command", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("shadowed", new TableInfo.Column("shadowed", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("extraData", new TableInfo.Column("extraData", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("replyToId", new TableInfo.Column("replyToId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("threadParticipantsIds", new TableInfo.Column("threadParticipantsIds", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet = new HashSet(0);
                Object obj = "deletedAt";
                HashSet hashSet2 = new HashSet(2);
                Object obj2 = "cid";
                List asList = Arrays.asList(new String[]{"cid", "createdAt"});
                String str = TagPeopleActivity.USER_ID;
                Object obj3 = "updatedAt";
                hashSet2.add(new TableInfo.Index("index_stream_chat_message_cid_createdAt", false, asList));
                hashSet2.add(new TableInfo.Index("index_stream_chat_message_syncStatus", false, Arrays.asList(new String[]{"syncStatus"})));
                TableInfo tableInfo3 = new TableInfo("stream_chat_message", hashMap3, hashSet, hashSet2);
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "stream_chat_message");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "stream_chat_message(io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(21);
                hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap4.put(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, new TableInfo.Column(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "TEXT", true, 0, (String) null, 1));
                hashMap4.put("authorName", new TableInfo.Column("authorName", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("titleLink", new TableInfo.Column("titleLink", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("thumbUrl", new TableInfo.Column("thumbUrl", "TEXT", false, 0, (String) null, 1));
                hashMap4.put(TagPeopleActivity.IMAGE_URL, new TableInfo.Column(TagPeopleActivity.IMAGE_URL, "TEXT", false, 0, (String) null, 1));
                hashMap4.put("assetUrl", new TableInfo.Column("assetUrl", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("ogUrl", new TableInfo.Column("ogUrl", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("mimeType", new TableInfo.Column("mimeType", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("title", new TableInfo.Column("title", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("text", new TableInfo.Column("text", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("type", new TableInfo.Column("type", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("image", new TableInfo.Column("image", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("url", new TableInfo.Column("url", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("fallback", new TableInfo.Column("fallback", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("uploadFilePath", new TableInfo.Column("uploadFilePath", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("extraData", new TableInfo.Column("extraData", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("statusCode", new TableInfo.Column("statusCode", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("errorMessage", new TableInfo.Column("errorMessage", "TEXT", false, 0, (String) null, 1));
                HashSet hashSet3 = new HashSet(1);
                hashSet3.add(new TableInfo.ForeignKey("stream_chat_message", "CASCADE", "NO ACTION", Arrays.asList(new String[]{Constants.FirelogAnalytics.PARAM_MESSAGE_ID}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_attachment_inner_entity_messageId", false, Arrays.asList(new String[]{Constants.FirelogAnalytics.PARAM_MESSAGE_ID})));
                TableInfo tableInfo4 = new TableInfo("attachment_inner_entity", hashMap4, hashSet3, hashSet4);
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "attachment_inner_entity");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "attachment_inner_entity(io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(11);
                hashMap5.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap5.put("originalId", new TableInfo.Column("originalId", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("role", new TableInfo.Column("role", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0, (String) null, 1));
                Object obj4 = obj3;
                hashMap5.put(obj4, new TableInfo.Column("updatedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("lastActive", new TableInfo.Column("lastActive", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("invisible", new TableInfo.Column("invisible", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("banned", new TableInfo.Column("banned", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("mutes", new TableInfo.Column("mutes", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("extraData", new TableInfo.Column("extraData", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet5 = new HashSet(0);
                HashSet hashSet6 = new HashSet(1);
                Object obj5 = "name";
                hashSet6.add(new TableInfo.Index("index_stream_chat_user_name", false, Arrays.asList(new String[]{"name"})));
                TableInfo tableInfo5 = new TableInfo("stream_chat_user", hashMap5, hashSet5, hashSet6);
                TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, "stream_chat_user");
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "stream_chat_user(io.getstream.chat.android.livedata.repository.domain.user.UserEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(11);
                hashMap6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap6.put(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, new TableInfo.Column(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "TEXT", true, 0, (String) null, 1));
                String str2 = str;
                hashMap6.put(str2, new TableInfo.Column(TagPeopleActivity.USER_ID, "TEXT", true, 0, (String) null, 1));
                hashMap6.put("type", new TableInfo.Column("type", "TEXT", true, 0, (String) null, 1));
                hashMap6.put(FirebaseAnalytics.Param.SCORE, new TableInfo.Column(FirebaseAnalytics.Param.SCORE, "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put(obj4, new TableInfo.Column("updatedAt", "INTEGER", false, 0, (String) null, 1));
                Object obj6 = obj;
                hashMap6.put(obj6, new TableInfo.Column("deletedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("enforceUnique", new TableInfo.Column("enforceUnique", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("extraData", new TableInfo.Column("extraData", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("syncStatus", new TableInfo.Column("syncStatus", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.ForeignKey("stream_chat_message", "CASCADE", "NO ACTION", Arrays.asList(new String[]{Constants.FirelogAnalytics.PARAM_MESSAGE_ID}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet8 = new HashSet(3);
                Object obj7 = "id";
                hashSet8.add(new TableInfo.Index("index_stream_chat_reaction_messageId_userId_type", true, Arrays.asList(new String[]{Constants.FirelogAnalytics.PARAM_MESSAGE_ID, str2, "type"})));
                hashSet8.add(new TableInfo.Index("index_stream_chat_reaction_syncStatus", false, Arrays.asList(new String[]{"syncStatus"})));
                hashSet8.add(new TableInfo.Index("index_stream_chat_reaction_messageId", false, Arrays.asList(new String[]{Constants.FirelogAnalytics.PARAM_MESSAGE_ID})));
                TableInfo tableInfo6 = new TableInfo("stream_chat_reaction", hashMap6, hashSet7, hashSet8);
                TableInfo read6 = TableInfo.read(supportSQLiteDatabase2, "stream_chat_reaction");
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "stream_chat_reaction(io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(17);
                hashMap7.put(obj2, new TableInfo.Column("cid", "TEXT", true, 1, (String) null, 1));
                hashMap7.put("type", new TableInfo.Column("type", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("channelId", new TableInfo.Column("channelId", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("cooldown", new TableInfo.Column("cooldown", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put("createdByUserId", new TableInfo.Column("createdByUserId", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("frozen", new TableInfo.Column("frozen", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put("hidden", new TableInfo.Column("hidden", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put("hideMessagesBefore", new TableInfo.Column("hideMessagesBefore", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put(ModelFields.MEMBERS, new TableInfo.Column(ModelFields.MEMBERS, "TEXT", true, 0, (String) null, 1));
                hashMap7.put("reads", new TableInfo.Column("reads", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("lastMessageAt", new TableInfo.Column("lastMessageAt", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put("lastMessageId", new TableInfo.Column("lastMessageId", "TEXT", false, 0, (String) null, 1));
                hashMap7.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put(obj4, new TableInfo.Column("updatedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put(obj6, new TableInfo.Column("deletedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put("extraData", new TableInfo.Column("extraData", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("syncStatus", new TableInfo.Column("syncStatus", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet9 = new HashSet(0);
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.Index("index_stream_chat_channel_state_syncStatus", false, Arrays.asList(new String[]{"syncStatus"})));
                TableInfo tableInfo7 = new TableInfo("stream_chat_channel_state", hashMap7, hashSet9, hashSet10);
                TableInfo read7 = TableInfo.read(supportSQLiteDatabase2, "stream_chat_channel_state");
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "stream_chat_channel_state(io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                HashMap hashMap8 = new HashMap(14);
                hashMap8.put("channelType", new TableInfo.Column("channelType", "TEXT", true, 1, (String) null, 1));
                hashMap8.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0, (String) null, 1));
                hashMap8.put(obj4, new TableInfo.Column("updatedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap8.put("isTypingEvents", new TableInfo.Column("isTypingEvents", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("isReadEvents", new TableInfo.Column("isReadEvents", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("isConnectEvents", new TableInfo.Column("isConnectEvents", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("isSearch", new TableInfo.Column("isSearch", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("isReactionsEnabled", new TableInfo.Column("isReactionsEnabled", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("isRepliesEnabled", new TableInfo.Column("isRepliesEnabled", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("isMutes", new TableInfo.Column("isMutes", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("maxMessageLength", new TableInfo.Column("maxMessageLength", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("automod", new TableInfo.Column("automod", "TEXT", true, 0, (String) null, 1));
                hashMap8.put("infinite", new TableInfo.Column("infinite", "TEXT", true, 0, (String) null, 1));
                Object obj8 = obj5;
                hashMap8.put(obj8, new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo8 = new TableInfo("stream_chat_channel_config", hashMap8, new HashSet(0), new HashSet(0));
                TableInfo read8 = TableInfo.read(supportSQLiteDatabase2, "stream_chat_channel_config");
                if (!tableInfo8.equals(read8)) {
                    return new RoomOpenHelper.ValidationResult(false, "stream_chat_channel_config(io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigInnerEntity).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
                }
                HashMap hashMap9 = new HashMap(6);
                hashMap9.put(obj7, new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap9.put(obj8, new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap9.put("description", new TableInfo.Column("description", "TEXT", true, 0, (String) null, 1));
                hashMap9.put("args", new TableInfo.Column("args", "TEXT", true, 0, (String) null, 1));
                hashMap9.put("set", new TableInfo.Column("set", "TEXT", true, 0, (String) null, 1));
                hashMap9.put("channelType", new TableInfo.Column("channelType", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet11 = new HashSet(1);
                hashSet11.add(new TableInfo.ForeignKey("stream_chat_channel_config", "CASCADE", "CASCADE", Arrays.asList(new String[]{"channelType"}), Arrays.asList(new String[]{"channelType"})));
                HashSet hashSet12 = new HashSet(1);
                hashSet12.add(new TableInfo.Index("index_command_inner_entity_channelType", false, Arrays.asList(new String[]{"channelType"})));
                TableInfo tableInfo9 = new TableInfo("command_inner_entity", hashMap9, hashSet11, hashSet12);
                TableInfo read9 = TableInfo.read(supportSQLiteDatabase2, "command_inner_entity");
                if (!tableInfo9.equals(read9)) {
                    return new RoomOpenHelper.ValidationResult(false, "command_inner_entity(io.getstream.chat.android.livedata.repository.domain.channelconfig.CommandInnerEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
                }
                HashMap hashMap10 = new HashMap(5);
                hashMap10.put(str, new TableInfo.Column(TagPeopleActivity.USER_ID, "TEXT", true, 1, (String) null, 1));
                hashMap10.put("activeChannelIds", new TableInfo.Column("activeChannelIds", "TEXT", true, 0, (String) null, 1));
                hashMap10.put("activeQueryIds", new TableInfo.Column("activeQueryIds", "TEXT", true, 0, (String) null, 1));
                hashMap10.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", false, 0, (String) null, 1));
                hashMap10.put("markedAllReadAt", new TableInfo.Column("markedAllReadAt", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo10 = new TableInfo("stream_sync_state", hashMap10, new HashSet(0), new HashSet(0));
                TableInfo read10 = TableInfo.read(supportSQLiteDatabase2, "stream_sync_state");
                if (tableInfo10.equals(read10)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "stream_sync_state(io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read10);
            }
        }, "597d61564f67f799a1d44f67551b916f", "4bec5d86d0d6670b8e2f10405fa31cc5")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "stream_channel_query", "channel_sort_inner_entity", "stream_chat_message", "attachment_inner_entity", "stream_chat_user", "stream_chat_reaction", "stream_chat_channel_state", "stream_chat_channel_config", "command_inner_entity", "stream_sync_state");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (!z) {
            try {
                writableDatabase.execSQL("PRAGMA foreign_keys = FALSE");
            } catch (Throwable th) {
                super.endTransaction();
                if (!z) {
                    writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
                }
                writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
                if (!writableDatabase.inTransaction()) {
                    writableDatabase.execSQL("VACUUM");
                }
                throw th;
            }
        }
        super.beginTransaction();
        if (z) {
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
        }
        writableDatabase.execSQL("DELETE FROM `stream_channel_query`");
        writableDatabase.execSQL("DELETE FROM `channel_sort_inner_entity`");
        writableDatabase.execSQL("DELETE FROM `stream_chat_message`");
        writableDatabase.execSQL("DELETE FROM `attachment_inner_entity`");
        writableDatabase.execSQL("DELETE FROM `stream_chat_user`");
        writableDatabase.execSQL("DELETE FROM `stream_chat_reaction`");
        writableDatabase.execSQL("DELETE FROM `stream_chat_channel_state`");
        writableDatabase.execSQL("DELETE FROM `stream_chat_channel_config`");
        writableDatabase.execSQL("DELETE FROM `command_inner_entity`");
        writableDatabase.execSQL("DELETE FROM `stream_sync_state`");
        super.setTransactionSuccessful();
        super.endTransaction();
        if (!z) {
            writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
        }
        writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
        if (!writableDatabase.inTransaction()) {
            writableDatabase.execSQL("VACUUM");
        }
    }

    public QueryChannelsDao queryChannelsDao() {
        QueryChannelsDao queryChannelsDao;
        if (this._queryChannelsDao != null) {
            return this._queryChannelsDao;
        }
        synchronized (this) {
            if (this._queryChannelsDao == null) {
                this._queryChannelsDao = new QueryChannelsDao_Impl(this);
            }
            queryChannelsDao = this._queryChannelsDao;
        }
        return queryChannelsDao;
    }

    public UserDao userDao() {
        UserDao userDao;
        if (this._userDao != null) {
            return this._userDao;
        }
        synchronized (this) {
            if (this._userDao == null) {
                this._userDao = new UserDao_Impl(this);
            }
            userDao = this._userDao;
        }
        return userDao;
    }

    public ReactionDao reactionDao() {
        ReactionDao reactionDao;
        if (this._reactionDao != null) {
            return this._reactionDao;
        }
        synchronized (this) {
            if (this._reactionDao == null) {
                this._reactionDao = new ReactionDao_Impl(this);
            }
            reactionDao = this._reactionDao;
        }
        return reactionDao;
    }

    public MessageDao messageDao() {
        MessageDao messageDao;
        if (this._messageDao != null) {
            return this._messageDao;
        }
        synchronized (this) {
            if (this._messageDao == null) {
                this._messageDao = new MessageDao_Impl(this);
            }
            messageDao = this._messageDao;
        }
        return messageDao;
    }

    public ChannelDao channelStateDao() {
        ChannelDao channelDao;
        if (this._channelDao != null) {
            return this._channelDao;
        }
        synchronized (this) {
            if (this._channelDao == null) {
                this._channelDao = new ChannelDao_Impl(this);
            }
            channelDao = this._channelDao;
        }
        return channelDao;
    }

    public ChannelConfigDao channelConfigDao() {
        ChannelConfigDao channelConfigDao;
        if (this._channelConfigDao != null) {
            return this._channelConfigDao;
        }
        synchronized (this) {
            if (this._channelConfigDao == null) {
                this._channelConfigDao = new ChannelConfigDao_Impl(this);
            }
            channelConfigDao = this._channelConfigDao;
        }
        return channelConfigDao;
    }

    public SyncStateDao syncStateDao() {
        SyncStateDao syncStateDao;
        if (this._syncStateDao != null) {
            return this._syncStateDao;
        }
        synchronized (this) {
            if (this._syncStateDao == null) {
                this._syncStateDao = new SyncStateDao_Impl(this);
            }
            syncStateDao = this._syncStateDao;
        }
        return syncStateDao;
    }
}
