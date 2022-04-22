package p015io.getstream.chat.android.client.api;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.RetrofitCall;
import p015io.getstream.chat.android.client.parser.ChatParser;
import retrofit2.CallAdapter;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/RetrofitCallAdapter;", "T", "", "Lretrofit2/CallAdapter;", "Lio/getstream/chat/android/client/call/Call;", "responseType", "Ljava/lang/reflect/Type;", "parser", "Lio/getstream/chat/android/client/parser/ChatParser;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "(Ljava/lang/reflect/Type;Lio/getstream/chat/android/client/parser/ChatParser;Ljava/util/concurrent/Executor;)V", "adapt", "call", "Lretrofit2/Call;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.RetrofitCallAdapter */
/* compiled from: RetrofitCallAdapterFactory.kt */
public final class RetrofitCallAdapter<T> implements CallAdapter<T, Call<T>> {
    private final Executor callbackExecutor;
    private final ChatParser parser;
    private final Type responseType;

    public RetrofitCallAdapter(Type type, ChatParser chatParser, Executor executor) {
        Intrinsics.checkNotNullParameter(type, "responseType");
        Intrinsics.checkNotNullParameter(chatParser, "parser");
        Intrinsics.checkNotNullParameter(executor, "callbackExecutor");
        this.responseType = type;
        this.parser = chatParser;
        this.callbackExecutor = executor;
    }

    public Call<T> adapt(retrofit2.Call<T> call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        return new RetrofitCall<>(call, this.parser, this.callbackExecutor);
    }

    public Type responseType() {
        return this.responseType;
    }
}
