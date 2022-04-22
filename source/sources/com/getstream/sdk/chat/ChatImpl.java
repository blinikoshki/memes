package com.getstream.sdk.chat;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.getstream.sdk.chat.ChatUI;
import com.getstream.sdk.chat.enums.OnlineStatus;
import com.getstream.sdk.chat.navigation.ChatNavigationHandler;
import com.getstream.sdk.chat.navigation.ChatNavigator;
import com.getstream.sdk.chat.navigation.ChatNavigatorImpl;
import com.getstream.sdk.chat.style.ChatFonts;
import com.getstream.sdk.chat.utils.strings.ChatStrings;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.logger.ChatLogLevel;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.ChatLoggerHandler;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler;
import p015io.getstream.chat.android.client.socket.InitConnectionListener;
import p015io.getstream.chat.android.client.uploader.FileUploader;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Deprecated
class ChatImpl implements Chat {
    private final String apiKey;
    private final ChatFonts chatFonts;
    private final ChatNotificationHandler chatNotificationHandler;
    private final ChatStrings chatStrings;
    private final Context context;
    private MutableLiveData<User> currentUser = new MutableLiveData<>();
    private final ChatMarkdown markdown;
    private final ChatNavigationHandler navigationHandler;
    private final ChatNavigator navigator;
    private final boolean offlineEnabled;
    private MutableLiveData<OnlineStatus> onlineStatus = new MutableLiveData<>(OnlineStatus.NOT_INITIALIZED);
    private MutableLiveData<Number> unreadChannels = new MutableLiveData<>();
    private MutableLiveData<Number> unreadMessages = new MutableLiveData<>();
    private final UrlSigner urlSigner;

    public String getVersion() {
        return "4.6.0-release";
    }

    ChatImpl(ChatFonts chatFonts2, ChatStrings chatStrings2, ChatNavigationHandler chatNavigationHandler, UrlSigner urlSigner2, ChatMarkdown chatMarkdown, String str, Context context2, boolean z, ChatNotificationHandler chatNotificationHandler2, ChatLogLevel chatLogLevel, ChatLoggerHandler chatLoggerHandler, FileUploader fileUploader) {
        this.chatStrings = chatStrings2;
        this.chatFonts = chatFonts2;
        this.navigationHandler = chatNavigationHandler;
        this.urlSigner = urlSigner2;
        this.markdown = chatMarkdown;
        this.apiKey = str;
        this.context = context2;
        this.offlineEnabled = z;
        this.chatNotificationHandler = chatNotificationHandler2;
        this.navigator = new ChatNavigatorImpl(chatNavigationHandler == null ? ChatNavigatorImpl.EMPTY_HANDLER : chatNavigationHandler);
        ChatClient.Builder logLevel = new ChatClient.Builder(str, context2).notifications(chatNotificationHandler2).logLevel(chatLogLevel);
        if (chatLoggerHandler != null) {
            logLevel.loggerHandler(chatLoggerHandler);
        }
        if (fileUploader != null) {
            logLevel.fileUploader(fileUploader);
        }
        logLevel.build();
        ChatLogger instance = ChatLogger.Companion.getInstance();
        instance.logI("Chat", "Initialized: " + getVersion());
    }

    public ChatNavigator getNavigator() {
        return this.navigator;
    }

    public LiveData<OnlineStatus> getOnlineStatus() {
        return this.onlineStatus;
    }

    public LiveData<Number> getUnreadMessages() {
        return this.unreadMessages;
    }

    public LiveData<Number> getUnreadChannels() {
        return this.unreadChannels;
    }

    public LiveData<User> getCurrentUser() {
        return this.currentUser;
    }

    public ChatStrings getStrings() {
        return this.chatStrings;
    }

    public UrlSigner urlSigner() {
        return this.urlSigner;
    }

    public ChatFonts getFonts() {
        return this.chatFonts;
    }

    public ChatMarkdown getMarkdown() {
        return this.markdown;
    }

    public void setUser(User user, String str, final InitConnectionListener initConnectionListener) {
        ChatClient instance = ChatClient.instance();
        instance.disconnect();
        disconnectChatDomainIfAlreadyInitialized();
        ChatDomain.Builder builder = new ChatDomain.Builder(this.context, instance, user);
        if (this.offlineEnabled) {
            builder.offlineEnabled();
        }
        builder.userPresenceEnabled().enableBackgroundSync().build();
        ChatUI.Builder withStrings = new ChatUI.Builder(this.context).withFonts(this.chatFonts).withMarkdown(this.markdown).withUrlSigner(this.urlSigner).withStrings(getStrings());
        ChatNavigationHandler chatNavigationHandler = this.navigationHandler;
        if (chatNavigationHandler != null) {
            withStrings.withNavigationHandler(chatNavigationHandler);
        }
        withStrings.build();
        instance.setUser(user, str, (InitConnectionListener) new InitConnectionListener() {
            public void onSuccess(InitConnectionListener.ConnectionData connectionData) {
                initConnectionListener.onSuccess(connectionData);
            }

            public void onError(ChatError chatError) {
                initConnectionListener.onError(chatError);
            }
        });
        init();
    }

    public void disconnect() {
        ChatClient.instance().disconnect();
        disconnectChatDomainIfAlreadyInitialized();
    }

    private void disconnectChatDomainIfAlreadyInitialized() {
        if (!ChatDomain.Companion.isInitialized()) {
            ChatLogger.Companion.getInstance().logD("ChatImpl", "ChatDomain was not initialized yet. No need to disconnect.");
            return;
        }
        BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getIO(), CoroutineStart.DEFAULT, new Function2() {
            public final Object invoke(Object obj, Object obj2) {
                return ChatDomain.this.disconnect((Continuation) obj2);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void init() {
        initSocketListener();
    }

    private void initSocketListener() {
        client().addSocketListener(new ChatSocketListener(new Function1() {
            public final Object invoke(Object obj) {
                return ChatImpl.this.lambda$initSocketListener$1$ChatImpl((OnlineStatus) obj);
            }
        }, new Function1() {
            public final Object invoke(Object obj) {
                return ChatImpl.this.lambda$initSocketListener$2$ChatImpl((User) obj);
            }
        }, new Function1() {
            public final Object invoke(Object obj) {
                return ChatImpl.this.lambda$initSocketListener$3$ChatImpl((Integer) obj);
            }
        }, new Function1() {
            public final Object invoke(Object obj) {
                return ChatImpl.this.lambda$initSocketListener$4$ChatImpl((Integer) obj);
            }
        }));
    }

    public /* synthetic */ Unit lambda$initSocketListener$1$ChatImpl(OnlineStatus onlineStatus2) {
        this.onlineStatus.postValue(onlineStatus2);
        return Unit.INSTANCE;
    }

    public /* synthetic */ Unit lambda$initSocketListener$2$ChatImpl(User user) {
        this.currentUser.postValue(user);
        return Unit.INSTANCE;
    }

    public /* synthetic */ Unit lambda$initSocketListener$3$ChatImpl(Integer num) {
        this.unreadMessages.postValue(num);
        return Unit.INSTANCE;
    }

    public /* synthetic */ Unit lambda$initSocketListener$4$ChatImpl(Integer num) {
        this.unreadChannels.postValue(num);
        return Unit.INSTANCE;
    }

    private ChatClient client() {
        return ChatClient.instance();
    }
}
