package p015io.getstream.chat.android.livedata;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import com.facebook.appevents.UserDataStore;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.TypingEvent;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsController;
import p015io.getstream.chat.android.livedata.repository.database.ChatDatabase;
import p015io.getstream.chat.android.livedata.service.sync.NotificationConfigStore;
import p015io.getstream.chat.android.livedata.service.sync.SyncProvider;
import p015io.getstream.chat.android.livedata.usecase.UseCaseHelper;
import p015io.getstream.chat.android.livedata.utils.Event;
import p015io.getstream.chat.android.livedata.utils.RetryPolicy;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u0000 B2\u00020\u0001:\u0002ABJ\b\u00103\u001a\u000204H&J\u0011\u00105\u001a\u000204H¦@ø\u0001\u0000¢\u0006\u0002\u00106J\u000e\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0017H&J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H&J\b\u0010=\u001a\u00020<H&J\b\u0010>\u001a\u00020\u0004H&J\b\u0010?\u001a\u00020\u0004H&J\b\u0010@\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u001e\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0006R\u0018\u0010!\u001a\u00020\"X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0006R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0006R\u0012\u0010,\u001a\u00020-X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/ChatDomain;", "", "banned", "Landroidx/lifecycle/LiveData;", "", "getBanned", "()Landroidx/lifecycle/LiveData;", "channelUnreadCount", "", "getChannelUnreadCount", "currentUser", "Lio/getstream/chat/android/client/models/User;", "getCurrentUser", "()Lio/getstream/chat/android/client/models/User;", "setCurrentUser", "(Lio/getstream/chat/android/client/models/User;)V", "errorEvents", "Lio/getstream/chat/android/livedata/utils/Event;", "Lio/getstream/chat/android/client/errors/ChatError;", "getErrorEvents", "initialized", "getInitialized", "muted", "", "Lio/getstream/chat/android/client/models/Mute;", "getMuted", "offlineEnabled", "getOfflineEnabled", "()Z", "setOfflineEnabled", "(Z)V", "online", "getOnline", "retryPolicy", "Lio/getstream/chat/android/livedata/utils/RetryPolicy;", "getRetryPolicy", "()Lio/getstream/chat/android/livedata/utils/RetryPolicy;", "setRetryPolicy", "(Lio/getstream/chat/android/livedata/utils/RetryPolicy;)V", "totalUnreadCount", "getTotalUnreadCount", "typingUpdates", "Lio/getstream/chat/android/client/models/TypingEvent;", "getTypingUpdates", "useCases", "Lio/getstream/chat/android/livedata/usecase/UseCaseHelper;", "getUseCases", "()Lio/getstream/chat/android/livedata/usecase/UseCaseHelper;", "userPresence", "getUserPresence", "setUserPresence", "clean", "", "disconnect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveQueries", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController;", "getChannelConfig", "Lio/getstream/chat/android/client/models/Config;", "channelType", "", "getVersion", "isInitialized", "isOffline", "isOnline", "Builder", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomain */
/* compiled from: ChatDomain.kt */
public interface ChatDomain {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: io.getstream.chat.android.livedata.ChatDomain$-CC  reason: invalid class name */
    /* compiled from: ChatDomain.kt */
    public final /* synthetic */ class CC {
        @JvmStatic
        public static ChatDomain instance() {
            return ChatDomain.Companion.instance();
        }
    }

    void clean();

    Object disconnect(Continuation<? super Unit> continuation);

    List<QueryChannelsController> getActiveQueries();

    LiveData<Boolean> getBanned();

    Config getChannelConfig(String str);

    LiveData<Integer> getChannelUnreadCount();

    User getCurrentUser();

    LiveData<Event<ChatError>> getErrorEvents();

    LiveData<Boolean> getInitialized();

    LiveData<List<Mute>> getMuted();

    boolean getOfflineEnabled();

    LiveData<Boolean> getOnline();

    RetryPolicy getRetryPolicy();

    LiveData<Integer> getTotalUnreadCount();

    LiveData<TypingEvent> getTypingUpdates();

    UseCaseHelper getUseCases();

    boolean getUserPresence();

    String getVersion();

    boolean isInitialized();

    boolean isOffline();

    boolean isOnline();

    void setCurrentUser(User user);

    void setOfflineEnabled(boolean z);

    void setRetryPolicy(RetryPolicy retryPolicy);

    void setUserPresence(boolean z);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\t\u0010\u001d\u001a\u00020\u0005HÂ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÂ\u0003J)\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\"J\u0006\u0010#\u001a\u00020\u0000J\u0006\u0010$\u001a\u00020\u0000J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0007J\u0006\u0010+\u001a\u00020\u0000J\u0006\u0010,\u001a\u00020\u0000J\u0006\u0010-\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u0010\u0010.\u001a\u00020/2\u0006\u0010)\u001a\u00020*H\u0002J\t\u00100\u001a\u000201HÖ\u0001J\u0006\u00102\u001a\u00020\u0000J\u0006\u00103\u001a\u00020\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/ChatDomain$Builder;", "", "client", "Lio/getstream/chat/android/client/ChatClient;", "appContext", "Landroid/content/Context;", "(Lio/getstream/chat/android/client/ChatClient;Landroid/content/Context;)V", "user", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/client/ChatClient;Lio/getstream/chat/android/client/models/User;Landroid/content/Context;)V", "(Landroid/content/Context;Lio/getstream/chat/android/client/ChatClient;Lio/getstream/chat/android/client/models/User;)V", "backgroundSyncEnabled", "", "database", "Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;", "recoveryEnabled", "storageEnabled", "syncModule", "Lio/getstream/chat/android/livedata/service/sync/SyncProvider;", "getSyncModule", "()Lio/getstream/chat/android/livedata/service/sync/SyncProvider;", "syncModule$delegate", "Lkotlin/Lazy;", "userPresence", "build", "Lio/getstream/chat/android/livedata/ChatDomain;", "buildImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "buildImpl$stream_chat_android_offline_release", "component1", "component2", "component3", "copy", "db", "database$stream_chat_android_offline_release", "disableBackgroundSync", "enableBackgroundSync", "equals", "other", "hashCode", "", "notificationConfig", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "offlineDisabled", "offlineEnabled", "recoveryDisabled", "storeNotificationConfig", "", "toString", "", "userPresenceDisabled", "userPresenceEnabled", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.ChatDomain$Builder */
    /* compiled from: ChatDomain.kt */
    public static final class Builder {
        /* access modifiers changed from: private */
        public Context appContext;
        private boolean backgroundSyncEnabled;
        private ChatClient client;
        private ChatDatabase database;
        private boolean recoveryEnabled;
        private boolean storageEnabled;
        private final Lazy syncModule$delegate;
        private User user;
        private boolean userPresence;

        private final Context component1() {
            return this.appContext;
        }

        private final ChatClient component2() {
            return this.client;
        }

        private final User component3() {
            return this.user;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, Context context, ChatClient chatClient, User user2, int i, Object obj) {
            if ((i & 1) != 0) {
                context = builder.appContext;
            }
            if ((i & 2) != 0) {
                chatClient = builder.client;
            }
            if ((i & 4) != 0) {
                user2 = builder.user;
            }
            return builder.copy(context, chatClient, user2);
        }

        private final SyncProvider getSyncModule() {
            return (SyncProvider) this.syncModule$delegate.getValue();
        }

        public final Builder copy(Context context, ChatClient chatClient, User user2) {
            Intrinsics.checkNotNullParameter(context, "appContext");
            Intrinsics.checkNotNullParameter(chatClient, "client");
            return new Builder(context, chatClient, user2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual((Object) this.appContext, (Object) builder.appContext) && Intrinsics.areEqual((Object) this.client, (Object) builder.client) && Intrinsics.areEqual((Object) this.user, (Object) builder.user);
        }

        public int hashCode() {
            Context context = this.appContext;
            int i = 0;
            int hashCode = (context != null ? context.hashCode() : 0) * 31;
            ChatClient chatClient = this.client;
            int hashCode2 = (hashCode + (chatClient != null ? chatClient.hashCode() : 0)) * 31;
            User user2 = this.user;
            if (user2 != null) {
                i = user2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Builder(appContext=" + this.appContext + ", client=" + this.client + ", user=" + this.user + ")";
        }

        public Builder(Context context, ChatClient chatClient, User user2) {
            Intrinsics.checkNotNullParameter(context, "appContext");
            Intrinsics.checkNotNullParameter(chatClient, "client");
            this.appContext = context;
            this.client = chatClient;
            this.user = user2;
            this.storageEnabled = true;
            this.recoveryEnabled = true;
            this.backgroundSyncEnabled = true;
            this.syncModule$delegate = LazyKt.lazy(new ChatDomain$Builder$syncModule$2(this));
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(Context context, ChatClient chatClient, User user2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, chatClient, (i & 4) != 0 ? null : user2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ChatClient chatClient, Context context) {
            this(context, chatClient, (User) null);
            Intrinsics.checkNotNullParameter(chatClient, "client");
            Intrinsics.checkNotNullParameter(context, "appContext");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ChatClient chatClient, User user2, Context context) {
            this(context, chatClient, user2);
            Intrinsics.checkNotNullParameter(chatClient, "client");
            Intrinsics.checkNotNullParameter(context, "appContext");
        }

        public final Builder database$stream_chat_android_offline_release(ChatDatabase chatDatabase) {
            Intrinsics.checkNotNullParameter(chatDatabase, UserDataStore.DATE_OF_BIRTH);
            this.database = chatDatabase;
            return this;
        }

        public final Builder enableBackgroundSync() {
            this.backgroundSyncEnabled = true;
            return this;
        }

        public final Builder disableBackgroundSync() {
            this.backgroundSyncEnabled = false;
            return this;
        }

        public final Builder offlineEnabled() {
            this.storageEnabled = true;
            return this;
        }

        public final Builder offlineDisabled() {
            this.storageEnabled = false;
            return this;
        }

        public final Builder recoveryEnabled() {
            this.recoveryEnabled = true;
            return this;
        }

        public final Builder recoveryDisabled() {
            this.recoveryEnabled = false;
            return this;
        }

        public final Builder userPresenceEnabled() {
            this.userPresence = true;
            return this;
        }

        public final Builder userPresenceDisabled() {
            this.userPresence = false;
            return this;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "This method is deprecated, you should configure it into the ChatClient")
        public final Builder notificationConfig(NotificationConfig notificationConfig) {
            Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
            throw new IllegalStateException("This method is deprecated, you should configure it into the ChatClient");
        }

        public final ChatDomain build() {
            storeNotificationConfig(this.client.getNotificationHandler().getConfig());
            Companion.instance = buildImpl$stream_chat_android_offline_release();
            return ChatDomain.Companion.instance();
        }

        public final ChatDomainImpl buildImpl$stream_chat_android_offline_release() {
            return new ChatDomainImpl(this.client, this.user, this.database, new Handler(Looper.getMainLooper()), this.storageEnabled, this.recoveryEnabled, this.userPresence, this.backgroundSyncEnabled, this.appContext);
        }

        private final void storeNotificationConfig(NotificationConfig notificationConfig) {
            if (!Intrinsics.areEqual((Object) NotificationConfigStore.Companion.getNotificationConfigUnavailable(), (Object) notificationConfig)) {
                getSyncModule().getNotificationConfigStore$stream_chat_android_offline_release().put(notificationConfig);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/ChatDomain$Companion;", "", "()V", "instance", "Lio/getstream/chat/android/livedata/ChatDomain;", "isInitialized", "", "()Z", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.ChatDomain$Companion */
    /* compiled from: ChatDomain.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        /* access modifiers changed from: private */
        public static ChatDomain instance;

        private Companion() {
        }

        @JvmStatic
        public final ChatDomain instance() {
            ChatDomain chatDomain = instance;
            if (chatDomain != null) {
                return chatDomain;
            }
            throw new IllegalStateException("ChatDomain.Builder::build() must be called before obtaining ChatDomain instance");
        }

        public final boolean isInitialized() {
            return instance != null;
        }
    }
}
