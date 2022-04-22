package p015io.getstream.chat.android.client.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.RetrofitCall;
import p015io.getstream.chat.android.client.parser.ChatParser;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J8\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/RetrofitCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "chatParser", "Lio/getstream/chat/android/client/parser/ChatParser;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "(Lio/getstream/chat/android/client/parser/ChatParser;Ljava/util/concurrent/Executor;)V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.RetrofitCallAdapterFactory */
/* compiled from: RetrofitCallAdapterFactory.kt */
public final class RetrofitCallAdapterFactory extends CallAdapter.Factory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Executor mainThreadExecutor = new RetrofitCallAdapterFactory$Companion$mainThreadExecutor$1();
    private final Executor callbackExecutor;
    private final ChatParser chatParser;

    public /* synthetic */ RetrofitCallAdapterFactory(ChatParser chatParser2, Executor executor, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatParser2, executor);
    }

    private RetrofitCallAdapterFactory(ChatParser chatParser2, Executor executor) {
        this.chatParser = chatParser2;
        this.callbackExecutor = executor;
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "returnType");
        Intrinsics.checkNotNullParameter(annotationArr, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (!Intrinsics.areEqual((Object) CallAdapter.Factory.getRawType(type), (Object) RetrofitCall.class)) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type access$getParameterUpperBound$s572770538 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            Intrinsics.checkNotNullExpressionValue(access$getParameterUpperBound$s572770538, "getParameterUpperBound(0, returnType)");
            return new RetrofitCallAdapter<>(access$getParameterUpperBound$s572770538, this.chatParser, this.callbackExecutor);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo>");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/RetrofitCallAdapterFactory$Companion;", "", "()V", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "getMainThreadExecutor", "()Ljava/util/concurrent/Executor;", "create", "Lio/getstream/chat/android/client/api/RetrofitCallAdapterFactory;", "chatParser", "Lio/getstream/chat/android/client/parser/ChatParser;", "callbackExecutor", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.RetrofitCallAdapterFactory$Companion */
    /* compiled from: RetrofitCallAdapterFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Executor getMainThreadExecutor() {
            return RetrofitCallAdapterFactory.mainThreadExecutor;
        }

        public static /* synthetic */ RetrofitCallAdapterFactory create$default(Companion companion, ChatParser chatParser, Executor executor, int i, Object obj) {
            if ((i & 2) != 0) {
                executor = companion.getMainThreadExecutor();
            }
            return companion.create(chatParser, executor);
        }

        public final RetrofitCallAdapterFactory create(ChatParser chatParser, Executor executor) {
            Intrinsics.checkNotNullParameter(chatParser, "chatParser");
            Intrinsics.checkNotNullParameter(executor, "callbackExecutor");
            return new RetrofitCallAdapterFactory(chatParser, executor, (DefaultConstructorMarker) null);
        }
    }
}
