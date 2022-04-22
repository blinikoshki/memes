package p015io.getstream.chat.android.client.parser2;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import p015io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0007JD\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0007¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser2/UpstreamMessageDtoAdapter;", "Lio/getstream/chat/android/client/parser2/CustomObjectDtoAdapter;", "Lio/getstream/chat/android/client/api2/model/dto/UpstreamMessageDto;", "()V", "fromJson", "jsonReader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "jsonWriter", "Lcom/squareup/moshi/JsonWriter;", "message", "mapAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "", "messageAdapter", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser2.UpstreamMessageDtoAdapter */
/* compiled from: MessageDtoAdapters.kt */
public final class UpstreamMessageDtoAdapter extends CustomObjectDtoAdapter<UpstreamMessageDto> {
    public static final UpstreamMessageDtoAdapter INSTANCE = new UpstreamMessageDtoAdapter();

    private UpstreamMessageDtoAdapter() {
        super(Reflection.getOrCreateKotlinClass(UpstreamMessageDto.class));
    }

    @FromJson
    public final UpstreamMessageDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        throw new IllegalStateException("Can't parse this from Json".toString());
    }

    @ToJson
    public final void toJson(JsonWriter jsonWriter, UpstreamMessageDto upstreamMessageDto, JsonAdapter<Map<String, Object>> jsonAdapter, JsonAdapter<UpstreamMessageDto> jsonAdapter2) {
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        Intrinsics.checkNotNullParameter(jsonAdapter, "mapAdapter");
        Intrinsics.checkNotNullParameter(jsonAdapter2, "messageAdapter");
        serializeWithExtraData(jsonWriter, upstreamMessageDto, jsonAdapter, jsonAdapter2);
    }
}
