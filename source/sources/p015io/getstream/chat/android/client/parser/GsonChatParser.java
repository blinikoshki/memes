package p015io.getstream.chat.android.client.parser;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import p015io.getstream.chat.android.client.parser.ChatParser;
import p015io.getstream.chat.android.client.utils.Result;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J-\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/GsonChatParser;", "Lio/getstream/chat/android/client/parser/ChatParser;", "()V", "gson", "Lcom/google/gson/Gson;", "getGson$stream_chat_android_client_release$annotations", "getGson$stream_chat_android_client_release", "()Lcom/google/gson/Gson;", "configRetrofit", "Lretrofit2/Retrofit$Builder;", "builder", "fromJson", "T", "", "raw", "", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJson", "any", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.GsonChatParser */
/* compiled from: GsonChatParser.kt */
public final class GsonChatParser implements ChatParser {
    private final Gson gson = StreamGson.INSTANCE.getGson();

    public static /* synthetic */ void getGson$stream_chat_android_client_release$annotations() {
    }

    public <T> Result<T> fromJsonOrError(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "raw");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return ChatParser.DefaultImpls.fromJsonOrError(this, str, cls);
    }

    public ChatNetworkError toError(Response response) {
        Intrinsics.checkNotNullParameter(response, "okHttpResponse");
        return ChatParser.DefaultImpls.toError((ChatParser) this, response);
    }

    public final Gson getGson$stream_chat_android_client_release() {
        return this.gson;
    }

    public String toJson(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "any");
        String json = this.gson.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(any)");
        return json;
    }

    public <T> T fromJson(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "raw");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        T fromJson = this.gson.fromJson(str, cls);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(raw, clazz)");
        return fromJson;
    }

    public Retrofit.Builder configRetrofit(Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Retrofit.Builder addConverterFactory = builder.addConverterFactory(new UrlQueryPayloadFactory(this.gson)).addConverterFactory(GsonConverterFactory.create(this.gson));
        Intrinsics.checkNotNullExpressionValue(addConverterFactory, "builder\n            .add…rterFactory.create(gson))");
        return addConverterFactory;
    }
}
