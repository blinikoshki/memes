package p015io.getstream.chat.android.livedata.repository.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao;
import p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao;
import p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao;
import p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao;
import p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao;
import p015io.getstream.chat.android.livedata.repository.domain.user.UserDao;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;", "Landroidx/room/RoomDatabase;", "()V", "channelConfigDao", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigDao;", "channelStateDao", "Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelDao;", "messageDao", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageDao;", "queryChannelsDao", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsDao;", "reactionDao", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionDao;", "syncStateDao", "Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateDao;", "userDao", "Lio/getstream/chat/android/livedata/repository/domain/user/UserDao;", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.database.ChatDatabase */
/* compiled from: ChatDatabase.kt */
public abstract class ChatDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static volatile Map<String, ChatDatabase> INSTANCES = new LinkedHashMap();

    public abstract ChannelConfigDao channelConfigDao();

    public abstract ChannelDao channelStateDao();

    public abstract MessageDao messageDao();

    public abstract QueryChannelsDao queryChannelsDao();

    public abstract ReactionDao reactionDao();

    public abstract SyncStateDao syncStateDao();

    public abstract UserDao userDao();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/database/ChatDatabase$Companion;", "", "()V", "INSTANCES", "", "", "Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;", "getDatabase", "context", "Landroid/content/Context;", "userId", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.database.ChatDatabase$Companion */
    /* compiled from: ChatDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChatDatabase getDatabase(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
            if (!ChatDatabase.INSTANCES.containsKey(str)) {
                synchronized (this) {
                    ChatDatabase build = Room.databaseBuilder(context.getApplicationContext(), ChatDatabase.class, "stream_chat_database_" + str).fallbackToDestructiveMigration().addCallback(new ChatDatabase$Companion$getDatabase$1$db$1()).build();
                    Intrinsics.checkNotNullExpressionValue(build, "Room.databaseBuilder(\n  …                 .build()");
                    ChatDatabase.INSTANCES.put(str, build);
                    Unit unit = Unit.INSTANCE;
                }
            }
            ChatDatabase chatDatabase = (ChatDatabase) ChatDatabase.INSTANCES.get(str);
            if (chatDatabase != null) {
                return chatDatabase;
            }
            throw new IllegalStateException("DB not created".toString());
        }
    }
}
