package p015io.getstream.chat.android.client.p049di;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.exifinterface.media.ExifInterface;
import com.moczul.ok2curl.CurlInterceptor;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import p015io.getstream.chat.android.client.api.AnonymousApi;
import p015io.getstream.chat.android.client.api.AuthenticatedApi;
import p015io.getstream.chat.android.client.api.ChatApi;
import p015io.getstream.chat.android.client.api.ChatClientConfig;
import p015io.getstream.chat.android.client.api.GsonChatApi;
import p015io.getstream.chat.android.client.api.HeadersInterceptor;
import p015io.getstream.chat.android.client.api.HttpLoggingInterceptor;
import p015io.getstream.chat.android.client.api.RetrofitAnonymousApi;
import p015io.getstream.chat.android.client.api.RetrofitApi;
import p015io.getstream.chat.android.client.api.RetrofitCallAdapterFactory;
import p015io.getstream.chat.android.client.api.RetrofitCdnApi;
import p015io.getstream.chat.android.client.api.TokenAuthInterceptor;
import p015io.getstream.chat.android.client.api2.MessageApi;
import p015io.getstream.chat.android.client.api2.MoshiApi;
import p015io.getstream.chat.android.client.api2.MoshiChatApi;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.network.NetworkStateProvider;
import p015io.getstream.chat.android.client.notifications.ChatNotifications;
import p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler;
import p015io.getstream.chat.android.client.parser.ChatParser;
import p015io.getstream.chat.android.client.socket.ChatSocket;
import p015io.getstream.chat.android.client.socket.ChatSocketImpl;
import p015io.getstream.chat.android.client.token.TokenManager;
import p015io.getstream.chat.android.client.token.TokenManagerImpl;
import p015io.getstream.chat.android.client.uploader.FileUploader;
import p015io.getstream.chat.android.client.uploader.StreamFileUploader;
import p015io.getstream.chat.android.client.utils.UuidGenerator;
import p015io.getstream.chat.android.client.utils.UuidGeneratorImpl;
import retrofit2.Retrofit;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u00106\u001a\u00020\u0014J\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0005H\u0002J\u0018\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0014H\u0002J0\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010C\u001a\u00020*2\u0006\u00101\u001a\u000202H\u0002J\u0016\u0010D\u001a\u0002HE\"\u0006\b\u0000\u0010E\u0018\u0001H\b¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020HH\u0002J\u0018\u0010I\u001a\u00020%2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010C\u001a\u00020*H\u0002J(\u0010J\u001a\u0002082\u0006\u0010A\u001a\u00020B2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010C\u001a\u00020*2\u0006\u00101\u001a\u000202H\u0014J\u001e\u0010K\u001a\b\u0012\u0004\u0012\u0002020L2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0002J\u0006\u0010M\u001a\u00020\u001eJ\u0006\u0010N\u001a\u00020 J\u0006\u0010O\u001a\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b&\u0010'R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b0\u0010\u0012\u001a\u0004\b/\u0010,R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u000202*\u0006\u0012\u0002\b\u0003038BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00104R\u001c\u00105\u001a\u000202*\u0006\u0012\u0002\b\u0003038BX\u0004¢\u0006\u0006\u001a\u0004\b5\u00104¨\u0006P"}, mo26107d2 = {"Lio/getstream/chat/android/client/di/BaseChatModule;", "", "appContext", "Landroid/content/Context;", "config", "Lio/getstream/chat/android/client/api/ChatClientConfig;", "notificationsHandler", "Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "fileUploader", "Lio/getstream/chat/android/client/uploader/FileUploader;", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "(Landroid/content/Context;Lio/getstream/chat/android/client/api/ChatClientConfig;Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;Lio/getstream/chat/android/client/uploader/FileUploader;Lio/getstream/chat/android/client/token/TokenManager;)V", "baseClient", "Lokhttp3/OkHttpClient;", "getBaseClient", "()Lokhttp3/OkHttpClient;", "baseClient$delegate", "Lkotlin/Lazy;", "defaultApi", "Lio/getstream/chat/android/client/api/ChatApi;", "getDefaultApi", "()Lio/getstream/chat/android/client/api/ChatApi;", "defaultApi$delegate", "defaultFileUploader", "Lio/getstream/chat/android/client/uploader/StreamFileUploader;", "getDefaultFileUploader", "()Lio/getstream/chat/android/client/uploader/StreamFileUploader;", "defaultFileUploader$delegate", "defaultLogger", "Lio/getstream/chat/android/client/logger/ChatLogger;", "defaultNotifications", "Lio/getstream/chat/android/client/notifications/ChatNotifications;", "getDefaultNotifications", "()Lio/getstream/chat/android/client/notifications/ChatNotifications;", "defaultNotifications$delegate", "defaultSocket", "Lio/getstream/chat/android/client/socket/ChatSocket;", "getDefaultSocket", "()Lio/getstream/chat/android/client/socket/ChatSocket;", "defaultSocket$delegate", "gsonParser", "Lio/getstream/chat/android/client/parser/ChatParser;", "getGsonParser", "()Lio/getstream/chat/android/client/parser/ChatParser;", "gsonParser$delegate", "moshiParser", "getMoshiParser", "moshiParser$delegate", "isAnonymousApi", "", "Ljava/lang/Class;", "(Ljava/lang/Class;)Z", "isMoshiApi", "api", "baseClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "buildApi", "chatConfig", "buildNotification", "handler", "buildRetrofit", "Lretrofit2/Retrofit;", "endpoint", "", "timeout", "", "parser", "buildRetrofitApi", "T", "()Ljava/lang/Object;", "buildRetrofitCdnApi", "Lio/getstream/chat/android/client/api/RetrofitCdnApi;", "buildSocket", "clientBuilder", "getAnonymousProvider", "Lkotlin/Function0;", "logger", "notifications", "socket", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.di.BaseChatModule */
/* compiled from: BaseChatModule.kt */
public class BaseChatModule {
    private final Context appContext;
    private final Lazy baseClient$delegate;
    /* access modifiers changed from: private */
    public final ChatClientConfig config;
    private final Lazy defaultApi$delegate;
    private final Lazy defaultFileUploader$delegate;
    private final ChatLogger defaultLogger;
    private final Lazy defaultNotifications$delegate;
    private final Lazy defaultSocket$delegate;
    private final FileUploader fileUploader;
    private final Lazy gsonParser$delegate;
    private final Lazy moshiParser$delegate;
    /* access modifiers changed from: private */
    public final ChatNotificationHandler notificationsHandler;
    private final TokenManager tokenManager;

    private final OkHttpClient getBaseClient() {
        return (OkHttpClient) this.baseClient$delegate.getValue();
    }

    private final ChatApi getDefaultApi() {
        return (ChatApi) this.defaultApi$delegate.getValue();
    }

    private final StreamFileUploader getDefaultFileUploader() {
        return (StreamFileUploader) this.defaultFileUploader$delegate.getValue();
    }

    private final ChatNotifications getDefaultNotifications() {
        return (ChatNotifications) this.defaultNotifications$delegate.getValue();
    }

    private final ChatSocket getDefaultSocket() {
        return (ChatSocket) this.defaultSocket$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChatParser getGsonParser() {
        return (ChatParser) this.gsonParser$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChatParser getMoshiParser() {
        return (ChatParser) this.moshiParser$delegate.getValue();
    }

    public BaseChatModule(Context context, ChatClientConfig chatClientConfig, ChatNotificationHandler chatNotificationHandler, FileUploader fileUploader2, TokenManager tokenManager2) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(chatClientConfig, "config");
        Intrinsics.checkNotNullParameter(chatNotificationHandler, "notificationsHandler");
        Intrinsics.checkNotNullParameter(tokenManager2, "tokenManager");
        this.appContext = context;
        this.config = chatClientConfig;
        this.notificationsHandler = chatNotificationHandler;
        this.fileUploader = fileUploader2;
        this.tokenManager = tokenManager2;
        this.defaultLogger = new ChatLogger.Builder(chatClientConfig.getLoggerConfig()).build();
        this.gsonParser$delegate = LazyKt.lazy(BaseChatModule$gsonParser$2.INSTANCE);
        this.moshiParser$delegate = LazyKt.lazy(BaseChatModule$moshiParser$2.INSTANCE);
        this.defaultNotifications$delegate = LazyKt.lazy(new BaseChatModule$defaultNotifications$2(this));
        this.defaultApi$delegate = LazyKt.lazy(new BaseChatModule$defaultApi$2(this));
        this.defaultSocket$delegate = LazyKt.lazy(new BaseChatModule$defaultSocket$2(this));
        this.defaultFileUploader$delegate = LazyKt.lazy(new BaseChatModule$defaultFileUploader$2(this));
        this.baseClient$delegate = LazyKt.lazy(BaseChatModule$baseClient$2.INSTANCE);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseChatModule(Context context, ChatClientConfig chatClientConfig, ChatNotificationHandler chatNotificationHandler, FileUploader fileUploader2, TokenManager tokenManager2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, chatClientConfig, chatNotificationHandler, (i & 8) != 0 ? null : fileUploader2, (i & 16) != 0 ? new TokenManagerImpl() : tokenManager2);
    }

    public final ChatApi api() {
        return getDefaultApi();
    }

    public final ChatSocket socket() {
        return getDefaultSocket();
    }

    public final ChatLogger logger() {
        return this.defaultLogger;
    }

    public final ChatNotifications notifications() {
        return getDefaultNotifications();
    }

    /* access modifiers changed from: private */
    public final ChatNotifications buildNotification(ChatNotificationHandler chatNotificationHandler, ChatApi chatApi) {
        return ChatNotifications.Companion.create(chatNotificationHandler, chatApi, this.appContext);
    }

    /* access modifiers changed from: private */
    public final Retrofit buildRetrofit(String str, long j, ChatClientConfig chatClientConfig, ChatParser chatParser, boolean z) {
        Retrofit.Builder client = new Retrofit.Builder().baseUrl(str).client(clientBuilder(j, chatClientConfig, chatParser, z).build());
        chatParser.configRetrofit(client);
        Retrofit build = client.addCallAdapterFactory(RetrofitCallAdapterFactory.Companion.create$default(RetrofitCallAdapterFactory.Companion, chatParser, (Executor) null, 2, (Object) null)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Retrofit.Builder()\n     …er))\n            .build()");
        return build;
    }

    private final OkHttpClient.Builder baseClientBuilder() {
        return getBaseClient().newBuilder().followRedirects(false);
    }

    /* access modifiers changed from: protected */
    public OkHttpClient.Builder clientBuilder(long j, ChatClientConfig chatClientConfig, ChatParser chatParser, boolean z) {
        Intrinsics.checkNotNullParameter(chatClientConfig, "config");
        Intrinsics.checkNotNullParameter(chatParser, "parser");
        return baseClientBuilder().callTimeout(j, TimeUnit.MILLISECONDS).connectTimeout(j, TimeUnit.MILLISECONDS).writeTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.MILLISECONDS).addInterceptor(new HeadersInterceptor(getAnonymousProvider(chatClientConfig, z))).addInterceptor(new HttpLoggingInterceptor()).addInterceptor(new TokenAuthInterceptor(this.tokenManager, chatParser, getAnonymousProvider(chatClientConfig, z))).addInterceptor(new CurlInterceptor(new BaseChatModule$clientBuilder$1(this)));
    }

    private final Function0<Boolean> getAnonymousProvider(ChatClientConfig chatClientConfig, boolean z) {
        return new BaseChatModule$getAnonymousProvider$1(z, chatClientConfig);
    }

    /* access modifiers changed from: private */
    public final ChatSocket buildSocket(ChatClientConfig chatClientConfig, ChatParser chatParser) {
        String apiKey = chatClientConfig.getApiKey();
        String wssUrl = chatClientConfig.getWssUrl();
        TokenManager tokenManager2 = this.tokenManager;
        Object systemService = this.appContext.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return new ChatSocketImpl(apiKey, wssUrl, tokenManager2, chatParser, new NetworkStateProvider((ConnectivityManager) systemService));
    }

    /* access modifiers changed from: private */
    public final ChatApi buildApi(ChatClientConfig chatClientConfig) {
        String apiKey = chatClientConfig.getApiKey();
        Class cls = RetrofitApi.class;
        RetrofitApi retrofitApi = (RetrofitApi) buildRetrofit(this.config.getHttpUrl(), this.config.getBaseTimeout(), this.config, isMoshiApi(cls) ? getMoshiParser() : getGsonParser(), isAnonymousApi(cls)).create(cls);
        Class cls2 = RetrofitAnonymousApi.class;
        RetrofitAnonymousApi retrofitAnonymousApi = (RetrofitAnonymousApi) buildRetrofit(this.config.getHttpUrl(), this.config.getBaseTimeout(), this.config, isMoshiApi(cls2) ? getMoshiParser() : getGsonParser(), isAnonymousApi(cls2)).create(cls2);
        UuidGenerator uuidGeneratorImpl = new UuidGeneratorImpl();
        FileUploader fileUploader2 = this.fileUploader;
        if (fileUploader2 == null) {
            fileUploader2 = getDefaultFileUploader();
        }
        GsonChatApi gsonChatApi = new GsonChatApi(apiKey, retrofitApi, retrofitAnonymousApi, uuidGeneratorImpl, fileUploader2, (CoroutineScope) null, 32, (DefaultConstructorMarker) null);
        if (!chatClientConfig.getEnableMoshi$stream_chat_android_client_release()) {
            return gsonChatApi;
        }
        Class cls3 = MessageApi.class;
        return new MoshiChatApi(chatClientConfig.getApiKey(), gsonChatApi, (MessageApi) buildRetrofit(this.config.getHttpUrl(), this.config.getBaseTimeout(), this.config, isMoshiApi(cls3) ? getMoshiParser() : getGsonParser(), isAnonymousApi(cls3)).create(cls3));
    }

    private final /* synthetic */ <T> T buildRetrofitApi() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls = Object.class;
        return buildRetrofit(this.config.getHttpUrl(), this.config.getBaseTimeout(), this.config, isMoshiApi(cls) ? getMoshiParser() : getGsonParser(), isAnonymousApi(cls)).create(cls);
    }

    /* access modifiers changed from: private */
    public final boolean isMoshiApi(Class<?> cls) {
        Annotation[] annotations = cls.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "this.annotations");
        for (Annotation annotation : annotations) {
            if (annotation instanceof MoshiApi) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isAnonymousApi(Class<?> cls) {
        boolean z;
        boolean z2;
        Annotation[] annotations = cls.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "this.annotations");
        int length = annotations.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (annotations[i] instanceof AnonymousApi) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        Annotation[] annotations2 = cls.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations2, "this.annotations");
        int length2 = annotations2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                z2 = false;
                break;
            } else if (annotations2[i2] instanceof AuthenticatedApi) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        if (z && z2) {
            throw new IllegalStateException("Api class must be annotated with either @AnonymousApi or @AuthenticatedApi, and not both");
        } else if (z) {
            return true;
        } else {
            if (z2) {
                return false;
            }
            throw new IllegalStateException("Api class must be annotated with either @AnonymousApi or @AuthenticatedApi");
        }
    }

    /* access modifiers changed from: private */
    public final RetrofitCdnApi buildRetrofitCdnApi() {
        Class cls = RetrofitCdnApi.class;
        Object create = buildRetrofit(this.config.getCdnHttpUrl(), this.config.getCdnTimeout(), this.config, isMoshiApi(cls) ? getMoshiParser() : getGsonParser(), isAnonymousApi(cls)).create(cls);
        Intrinsics.checkNotNullExpressionValue(create, "buildRetrofit(\n         …       ).create(apiClass)");
        return (RetrofitCdnApi) create;
    }
}
