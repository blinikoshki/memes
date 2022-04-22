package p015io.getstream.chat.android.client.parser;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Converter;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/UrlQueryPayloadConverted;", "Lretrofit2/Converter;", "", "", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "getGson", "()Lcom/google/gson/Gson;", "convert", "value", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.UrlQueryPayloadConverted */
/* compiled from: UrlQueryPayloadFactory.kt */
final class UrlQueryPayloadConverted implements Converter<Object, String> {
    private final Gson gson;

    public UrlQueryPayloadConverted(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    public final Gson getGson() {
        return this.gson;
    }

    public String convert(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        String json = this.gson.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(value)");
        return json;
    }
}
