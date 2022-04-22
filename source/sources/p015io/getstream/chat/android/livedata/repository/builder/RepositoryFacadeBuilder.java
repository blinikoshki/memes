package p015io.getstream.chat.android.livedata.repository.builder;

import android.content.Context;
import androidx.room.Room;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.repository.RepositoryFacade;
import p015io.getstream.chat.android.livedata.repository.database.ChatDatabase;
import p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\fJ\b\u0010\u0015\u001a\u00020\nH\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/builder/RepositoryFacadeBuilder;", "", "()V", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "database", "Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;", "defaultConfig", "Lio/getstream/chat/android/client/models/Config;", "isOfflineEnabled", "", "build", "Lio/getstream/chat/android/livedata/repository/RepositoryFacade;", "createDatabase", "user", "offlineEnabled", "config", "getChatDatabase", "scope", "setOfflineEnabled", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.builder.RepositoryFacadeBuilder */
/* compiled from: RepositoryFacadeBuilder.kt */
public final class RepositoryFacadeBuilder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Context context;
    private CoroutineScope coroutineScope;
    private User currentUser;
    private ChatDatabase database;
    private Config defaultConfig;
    private boolean isOfflineEnabled;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0002¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/builder/RepositoryFacadeBuilder$Companion;", "", "()V", "invoke", "Lio/getstream/chat/android/livedata/repository/builder/RepositoryFacadeBuilder;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.builder.RepositoryFacadeBuilder$Companion */
    /* compiled from: RepositoryFacadeBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RepositoryFacadeBuilder invoke(Function1<? super RepositoryFacadeBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builderAction");
            RepositoryFacadeBuilder repositoryFacadeBuilder = new RepositoryFacadeBuilder();
            function1.invoke(repositoryFacadeBuilder);
            return repositoryFacadeBuilder;
        }
    }

    public final RepositoryFacadeBuilder context(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        RepositoryFacadeBuilder repositoryFacadeBuilder = this;
        repositoryFacadeBuilder.context = context2;
        return repositoryFacadeBuilder;
    }

    public final RepositoryFacadeBuilder currentUser(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        RepositoryFacadeBuilder repositoryFacadeBuilder = this;
        repositoryFacadeBuilder.currentUser = user;
        return repositoryFacadeBuilder;
    }

    public final RepositoryFacadeBuilder setOfflineEnabled(boolean z) {
        RepositoryFacadeBuilder repositoryFacadeBuilder = this;
        repositoryFacadeBuilder.isOfflineEnabled = z;
        return repositoryFacadeBuilder;
    }

    public final RepositoryFacadeBuilder database(ChatDatabase chatDatabase) {
        RepositoryFacadeBuilder repositoryFacadeBuilder = this;
        repositoryFacadeBuilder.database = chatDatabase;
        return repositoryFacadeBuilder;
    }

    public final RepositoryFacadeBuilder scope(CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "scope");
        RepositoryFacadeBuilder repositoryFacadeBuilder = this;
        repositoryFacadeBuilder.coroutineScope = coroutineScope2;
        return repositoryFacadeBuilder;
    }

    public final RepositoryFacadeBuilder defaultConfig(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        RepositoryFacadeBuilder repositoryFacadeBuilder = this;
        repositoryFacadeBuilder.defaultConfig = config;
        return repositoryFacadeBuilder;
    }

    private final ChatDatabase createDatabase(Context context2, User user, boolean z) {
        if (z) {
            return ChatDatabase.Companion.getDatabase(context2, user.getId());
        }
        ChatDatabase build = Room.inMemoryDatabaseBuilder(context2, ChatDatabase.class).build();
        Intrinsics.checkNotNullExpressionValue(build, "Room.inMemoryDatabaseBui…base::class.java).build()");
        return build;
    }

    private final ChatDatabase getChatDatabase() {
        ChatDatabase chatDatabase = this.database;
        if (chatDatabase != null) {
            return chatDatabase;
        }
        Context context2 = this.context;
        if (context2 != null) {
            User user = this.currentUser;
            if (user != null) {
                return createDatabase(context2, user, this.isOfflineEnabled);
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final RepositoryFacade build() {
        Config config = this.defaultConfig;
        if (config != null) {
            CoroutineScope coroutineScope2 = this.coroutineScope;
            if (coroutineScope2 != null) {
                User user = this.currentUser;
                if (user != null) {
                    RepositoryFactory repositoryFactory = new RepositoryFactory(getChatDatabase(), user);
                    Function2 repositoryFacadeBuilder$build$getUser$1 = new RepositoryFacadeBuilder$build$getUser$1(repositoryFactory.createUserRepository(), (Continuation) null);
                    MessageRepository createMessageRepository = repositoryFactory.createMessageRepository(repositoryFacadeBuilder$build$getUser$1);
                    return new RepositoryFacade(repositoryFactory.createUserRepository(), repositoryFactory.createChannelConfigRepository(), repositoryFactory.createChannelRepository(repositoryFacadeBuilder$build$getUser$1, new RepositoryFacadeBuilder$build$getMessage$1(createMessageRepository)), repositoryFactory.createQueryChannelsRepository(), createMessageRepository, repositoryFactory.createReactionRepository(repositoryFacadeBuilder$build$getUser$1), repositoryFactory.createSyncStateRepository(), coroutineScope2, config);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
