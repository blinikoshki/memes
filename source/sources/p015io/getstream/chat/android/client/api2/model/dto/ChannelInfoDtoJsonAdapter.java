package p015io.getstream.chat.android.client.api2.model.dto;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/ChannelInfoDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lio/getstream/chat/android/client/api2/model/dto/ChannelInfoDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.ChannelInfoDtoJsonAdapter */
/* compiled from: ChannelInfoDtoJsonAdapter.kt */
public final class ChannelInfoDtoJsonAdapter extends JsonAdapter<ChannelInfoDto> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public ChannelInfoDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.m1002of("cid", "id", "member_count", "name", "type");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"c…t\",\n      \"name\", \"type\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "cid");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…\n      emptySet(), \"cid\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "member_count");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…(),\n      \"member_count\")");
        this.intAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ChannelInfoDto");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ChannelInfoDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
        jsonReader.beginObject();
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                Integer fromJson = this.intAdapter.fromJson(jsonReader);
                if (fromJson != null) {
                    num = Integer.valueOf(fromJson.intValue());
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("member_count", "member_count", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"mem…  \"member_count\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 4) {
                str4 = this.nullableStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (num != null) {
            return new ChannelInfoDto(str, str2, num.intValue(), str3, str4);
        }
        JsonDataException missingProperty = Util.missingProperty("member_count", "member_count", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"me…unt\",\n            reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, ChannelInfoDto channelInfoDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (channelInfoDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("cid");
            this.nullableStringAdapter.toJson(jsonWriter, channelInfoDto.getCid());
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, channelInfoDto.getId());
            jsonWriter.name("member_count");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(channelInfoDto.getMember_count()));
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, channelInfoDto.getName());
            jsonWriter.name("type");
            this.nullableStringAdapter.toJson(jsonWriter, channelInfoDto.getType());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
