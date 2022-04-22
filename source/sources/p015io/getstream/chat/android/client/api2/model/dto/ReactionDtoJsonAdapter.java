package p015io.getstream.chat.android.client.api2.model.dto;

import com.facebook.AccessToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/ReactionDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lio/getstream/chat/android/client/api2/model/dto/ReactionDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "mapOfStringAnyAdapter", "", "", "", "nullableDateAdapter", "Ljava/util/Date;", "nullableUserDtoAdapter", "Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.ReactionDtoJsonAdapter */
/* compiled from: ReactionDtoJsonAdapter.kt */
public final class ReactionDtoJsonAdapter extends JsonAdapter<ReactionDto> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Map<String, Object>> mapOfStringAnyAdapter;
    private final JsonAdapter<Date> nullableDateAdapter;
    private final JsonAdapter<UserDto> nullableUserDtoAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ReactionDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.m1002of("created_at", "message_id", FirebaseAnalytics.Param.SCORE, "type", "updated_at", "user", AccessToken.USER_ID_KEY, "extraData");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"c…, \"user_id\", \"extraData\")");
        this.options = of;
        JsonAdapter<Date> adapter = moshi.adapter(Date.class, SetsKt.emptySet(), "created_at");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Date::clas…et(),\n      \"created_at\")");
        this.nullableDateAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "message_id");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…et(),\n      \"message_id\")");
        this.stringAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), FirebaseAnalytics.Param.SCORE);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class…ava, emptySet(), \"score\")");
        this.intAdapter = adapter3;
        JsonAdapter<UserDto> adapter4 = moshi.adapter(UserDto.class, SetsKt.emptySet(), "user");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(UserDto::c…      emptySet(), \"user\")");
        this.nullableUserDtoAdapter = adapter4;
        JsonAdapter<Map<String, Object>> adapter5 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), "extraData");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP… emptySet(), \"extraData\")");
        this.mapOfStringAnyAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ReactionDto");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ReactionDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
        jsonReader.beginObject();
        Map map = null;
        Date date = null;
        Date date2 = date;
        String str = null;
        String str2 = str;
        String str3 = str2;
        UserDto userDto = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    date = this.nullableDateAdapter.fromJson(jsonReader);
                    break;
                case 1:
                    String fromJson = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        str = fromJson;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("message_id", "message_id", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"mes…    \"message_id\", reader)");
                        throw unexpectedNull;
                    }
                case 2:
                    Integer fromJson2 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson2 != null) {
                        num = Integer.valueOf(fromJson2.intValue());
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull(FirebaseAnalytics.Param.SCORE, FirebaseAnalytics.Param.SCORE, jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"sco…ore\",\n            reader)");
                        throw unexpectedNull2;
                    }
                case 3:
                    String fromJson3 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson3 != null) {
                        str2 = fromJson3;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("type", "type", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"typ…ype\",\n            reader)");
                        throw unexpectedNull3;
                    }
                case 4:
                    date2 = this.nullableDateAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    userDto = this.nullableUserDtoAdapter.fromJson(jsonReader);
                    break;
                case 6:
                    String fromJson4 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson4 != null) {
                        str3 = fromJson4;
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull(AccessToken.USER_ID_KEY, AccessToken.USER_ID_KEY, jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"use…       \"user_id\", reader)");
                        throw unexpectedNull4;
                    }
                case 7:
                    Map fromJson5 = this.mapOfStringAnyAdapter.fromJson(jsonReader);
                    if (fromJson5 != null) {
                        map = fromJson5;
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("extraData", "extraData", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"ext…ta\", \"extraData\", reader)");
                        throw unexpectedNull5;
                    }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("message_id", "message_id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"me…d\", \"message_id\", reader)");
            throw missingProperty;
        } else if (num != null) {
            int intValue = num.intValue();
            if (str2 == null) {
                JsonDataException missingProperty2 = Util.missingProperty("type", "type", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"type\", \"type\", reader)");
                throw missingProperty2;
            } else if (str3 == null) {
                JsonDataException missingProperty3 = Util.missingProperty(AccessToken.USER_ID_KEY, AccessToken.USER_ID_KEY, jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"user_id\", \"user_id\", reader)");
                throw missingProperty3;
            } else if (map != null) {
                return new ReactionDto(date, str, intValue, str2, date2, userDto, str3, map);
            } else {
                JsonDataException missingProperty4 = Util.missingProperty("extraData", "extraData", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"ex…ta\", \"extraData\", reader)");
                throw missingProperty4;
            }
        } else {
            JsonDataException missingProperty5 = Util.missingProperty(FirebaseAnalytics.Param.SCORE, FirebaseAnalytics.Param.SCORE, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"score\", \"score\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, ReactionDto reactionDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (reactionDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("created_at");
            this.nullableDateAdapter.toJson(jsonWriter, reactionDto.getCreated_at());
            jsonWriter.name("message_id");
            this.stringAdapter.toJson(jsonWriter, reactionDto.getMessage_id());
            jsonWriter.name(FirebaseAnalytics.Param.SCORE);
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(reactionDto.getScore()));
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, reactionDto.getType());
            jsonWriter.name("updated_at");
            this.nullableDateAdapter.toJson(jsonWriter, reactionDto.getUpdated_at());
            jsonWriter.name("user");
            this.nullableUserDtoAdapter.toJson(jsonWriter, reactionDto.getUser());
            jsonWriter.name(AccessToken.USER_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, reactionDto.getUser_id());
            jsonWriter.name("extraData");
            this.mapOfStringAnyAdapter.toJson(jsonWriter, reactionDto.getExtraData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
