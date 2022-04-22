package p015io.getstream.chat.android.client.api2.model.dto;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/UserDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "mapOfStringAnyAdapter", "", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.UserDtoJsonAdapter */
/* compiled from: UserDtoJsonAdapter.kt */
public final class UserDtoJsonAdapter extends JsonAdapter<UserDto> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Map<String, Object>> mapOfStringAnyAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public UserDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.m1002of("banned", "id", "invisible", "role", "extraData");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"b…     \"role\", \"extraData\")");
        this.options = of;
        JsonAdapter<Boolean> adapter = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "banned");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Boolean::c…ptySet(),\n      \"banned\")");
        this.booleanAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter2;
        JsonAdapter<Map<String, Object>> adapter3 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), "extraData");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP… emptySet(), \"extraData\")");
        this.mapOfStringAnyAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        sb.append("GeneratedJsonAdapter(");
        sb.append("UserDto");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public UserDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Boolean bool = null;
        jsonReader.beginObject();
        Map map = null;
        Boolean bool2 = bool;
        String str = null;
        String str2 = str;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                Boolean fromJson = this.booleanAdapter.fromJson(jsonReader);
                if (fromJson != null) {
                    bool = Boolean.valueOf(fromJson.booleanValue());
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("banned", "banned", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"ban…        \"banned\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                String fromJson2 = this.stringAdapter.fromJson(jsonReader);
                if (fromJson2 != null) {
                    str = fromJson2;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("id", "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                Boolean fromJson3 = this.booleanAdapter.fromJson(jsonReader);
                if (fromJson3 != null) {
                    bool2 = Boolean.valueOf(fromJson3.booleanValue());
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("invisible", "invisible", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"inv…     \"invisible\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                String fromJson4 = this.stringAdapter.fromJson(jsonReader);
                if (fromJson4 != null) {
                    str2 = fromJson4;
                } else {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("role", "role", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"rol…ole\",\n            reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4) {
                Map fromJson5 = this.mapOfStringAnyAdapter.fromJson(jsonReader);
                if (fromJson5 != null) {
                    map = fromJson5;
                } else {
                    JsonDataException unexpectedNull5 = Util.unexpectedNull("extraData", "extraData", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"ext…ta\", \"extraData\", reader)");
                    throw unexpectedNull5;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (str == null) {
                JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"id\", \"id\", reader)");
                throw missingProperty;
            } else if (bool2 != null) {
                boolean booleanValue2 = bool2.booleanValue();
                if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("role", "role", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"role\", \"role\", reader)");
                    throw missingProperty2;
                } else if (map != null) {
                    return new UserDto(booleanValue, str, booleanValue2, str2, map);
                } else {
                    JsonDataException missingProperty3 = Util.missingProperty("extraData", "extraData", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"ex…ta\", \"extraData\", reader)");
                    throw missingProperty3;
                }
            } else {
                JsonDataException missingProperty4 = Util.missingProperty("invisible", "invisible", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"in…le\", \"invisible\", reader)");
                throw missingProperty4;
            }
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("banned", "banned", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"banned\", \"banned\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, UserDto userDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (userDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("banned");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(userDto.getBanned()));
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, userDto.getId());
            jsonWriter.name("invisible");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(userDto.getInvisible()));
            jsonWriter.name("role");
            this.stringAdapter.toJson(jsonWriter, userDto.getRole());
            jsonWriter.name("extraData");
            this.mapOfStringAnyAdapter.toJson(jsonWriter, userDto.getExtraData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
