package p015io.getstream.chat.android.client.parser2;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import p015io.getstream.chat.android.client.parser.ChatParser;
import p015io.getstream.chat.android.client.utils.Result;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J-\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\r0\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J#\u0010\u0016\u001a\u00020\u0017\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\r0\u0019H\bR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser2/MoshiChatParser;", "Lio/getstream/chat/android/client/parser/ChatParser;", "()V", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "Lkotlin/Lazy;", "configRetrofit", "Lretrofit2/Retrofit$Builder;", "builder", "fromJson", "T", "", "raw", "", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJson", "any", "addAdapter", "Lcom/squareup/moshi/Moshi$Builder;", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser2.MoshiChatParser */
/* compiled from: MoshiChatParser.kt */
public final class MoshiChatParser implements ChatParser {
    private final Lazy moshi$delegate = LazyKt.lazy(new MoshiChatParser$moshi$2(this));

    private final Moshi getMoshi() {
        return (Moshi) this.moshi$delegate.getValue();
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

    public String toJson(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "any");
        String json = getMoshi().adapter(obj.getClass()).toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "adapter.toJson(any)");
        return json;
    }

    public <T> T fromJson(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "raw");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        T fromJson = getMoshi().adapter(cls).fromJson(str);
        Intrinsics.checkNotNull(fromJson);
        return fromJson;
    }

    public Retrofit.Builder configRetrofit(Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Retrofit.Builder addConverterFactory = builder.addConverterFactory(MoshiConverterFactory.create(getMoshi()));
        Intrinsics.checkNotNullExpressionValue(addConverterFactory, "builder.addConverterFact…terFactory.create(moshi))");
        return addConverterFactory;
    }

    /* access modifiers changed from: private */
    public final /* synthetic */ <T> Moshi.Builder addAdapter(Moshi.Builder builder, JsonAdapter<T> jsonAdapter) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        builder.add(Object.class, jsonAdapter);
        return builder;
    }
}
