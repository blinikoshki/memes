package p015io.getstream.chat.android.livedata.repository.builder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.repository.database.ChatDatabase;
import p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepository;
import p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl;
import p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepository;
import p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl;
import p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository;
import p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl;
import p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepository;
import p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepository;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl;
import p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepository;
import p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl;
import p015io.getstream.chat.android.livedata.repository.domain.user.UserRepository;
import p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJv\u0010\t\u001a\u00020\n21\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f23\u0010\u0012\u001a/\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u0015JA\u0010\u0016\u001a\u00020\u001721\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJA\u0010\u001b\u001a\u00020\u001c21\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/builder/RepositoryFactory;", "", "database", "Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;Lio/getstream/chat/android/client/models/User;)V", "createChannelConfigRepository", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigRepository;", "createChannelRepository", "Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelRepository;", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "getMessage", "messageId", "Lio/getstream/chat/android/client/models/Message;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelRepository;", "createMessageRepository", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageRepository;", "(Lkotlin/jvm/functions/Function2;)Lio/getstream/chat/android/livedata/repository/domain/message/MessageRepository;", "createQueryChannelsRepository", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsRepository;", "createReactionRepository", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionRepository;", "(Lkotlin/jvm/functions/Function2;)Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionRepository;", "createSyncStateRepository", "Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateRepository;", "createUserRepository", "Lio/getstream/chat/android/livedata/repository/domain/user/UserRepository;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.builder.RepositoryFactory */
/* compiled from: RepositoryFactory.kt */
public final class RepositoryFactory {
    private final User currentUser;
    private final ChatDatabase database;

    public RepositoryFactory(ChatDatabase chatDatabase, User user) {
        Intrinsics.checkNotNullParameter(chatDatabase, "database");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        this.database = chatDatabase;
        this.currentUser = user;
    }

    public final UserRepository createUserRepository() {
        return new UserRepositoryImpl(this.database.userDao(), this.currentUser, 100);
    }

    public final ChannelConfigRepository createChannelConfigRepository() {
        return new ChannelConfigRepositoryImpl(this.database.channelConfigDao());
    }

    public final ChannelRepository createChannelRepository(Function2<? super String, ? super Continuation<? super User>, ? extends Object> function2, Function2<? super String, ? super Continuation<? super Message>, ? extends Object> function22) {
        Intrinsics.checkNotNullParameter(function2, "getUser");
        Intrinsics.checkNotNullParameter(function22, "getMessage");
        return new ChannelRepositoryImpl(this.database.channelStateDao(), function2, function22, 100);
    }

    public final QueryChannelsRepository createQueryChannelsRepository() {
        return new QueryChannelsRepositoryImpl(this.database.queryChannelsDao());
    }

    public final MessageRepository createMessageRepository(Function2<? super String, ? super Continuation<? super User>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "getUser");
        return new MessageRepositoryImpl(this.database.messageDao(), function2, 100);
    }

    public final ReactionRepository createReactionRepository(Function2<? super String, ? super Continuation<? super User>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "getUser");
        return new ReactionRepositoryImpl(this.database.reactionDao(), function2);
    }

    public final SyncStateRepository createSyncStateRepository() {
        return new SyncStateRepositoryImpl(this.database.syncStateDao());
    }
}
