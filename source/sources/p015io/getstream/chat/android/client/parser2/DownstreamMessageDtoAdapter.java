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
import p015io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0007¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser2/DownstreamMessageDtoAdapter;", "Lio/getstream/chat/android/client/parser2/CustomObjectDtoAdapter;", "Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;", "()V", "fromJson", "jsonReader", "Lcom/squareup/moshi/JsonReader;", "mapAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "", "messageAdapter", "toJson", "", "jsonWriter", "Lcom/squareup/moshi/JsonWriter;", "value", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser2.DownstreamMessageDtoAdapter */
/* compiled from: MessageDtoAdapters.kt */
public final class DownstreamMessageDtoAdapter extends CustomObjectDtoAdapter<DownstreamMessageDto> {
    public static final DownstreamMessageDtoAdapter INSTANCE = new DownstreamMessageDtoAdapter();

    private DownstreamMessageDtoAdapter() {
        super(Reflection.getOrCreateKotlinClass(DownstreamMessageDto.class));
    }

    @FromJson
    public final DownstreamMessageDto fromJson(JsonReader jsonReader, JsonAdapter<Map<String, Object>> jsonAdapter, JsonAdapter<DownstreamMessageDto> jsonAdapter2) {
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        Intrinsics.checkNotNullParameter(jsonAdapter, "mapAdapter");
        Intrinsics.checkNotNullParameter(jsonAdapter2, "messageAdapter");
        return (DownstreamMessageDto) parseWithExtraData(jsonReader, jsonAdapter, jsonAdapter2);
    }

    @ToJson
    public final void toJson(JsonWriter jsonWriter, DownstreamMessageDto downstreamMessageDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        Intrinsics.checkNotNullParameter(downstreamMessageDto, "value");
        throw new IllegalStateException("Can't convert this to Json".toString());
    }
}
