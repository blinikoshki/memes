package p015io.getstream.chat.android.client.api2.model.dto;

import com.facebook.share.internal.MessengerShareContentUtility;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/AttachmentDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lio/getstream/chat/android/client/api2/model/dto/AttachmentDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "mapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.AttachmentDtoJsonAdapter */
/* compiled from: AttachmentDtoJsonAdapter.kt */
public final class AttachmentDtoJsonAdapter extends JsonAdapter<AttachmentDto> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Map<String, Object>> mapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public AttachmentDtoJsonAdapter(Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of = JsonReader.Options.m1002of("asset_url", "author_name", "fallback", "file_size", "image", MessengerShareContentUtility.IMAGE_URL, "mime_type", "name", "og_scrape_url", "text", "thumb_url", "title", "title_link", "type", "url", "extraData");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a…ype\", \"url\", \"extraData\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi2.adapter(String.class, SetsKt.emptySet(), "asset_url");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl… emptySet(), \"asset_url\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi2.adapter(Integer.TYPE, SetsKt.emptySet(), "file_size");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class… emptySet(), \"file_size\")");
        this.intAdapter = adapter2;
        JsonAdapter<Map<String, Object>> adapter3 = moshi2.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), "extraData");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP… emptySet(), \"extraData\")");
        this.mapOfStringAnyAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(");
        sb.append("AttachmentDto");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public AttachmentDto fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        Integer num = null;
        jsonReader.beginObject();
        Map map = null;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        String str13 = str12;
        String str14 = str13;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 1:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 2:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 3:
                    Integer fromJson = this.intAdapter.fromJson(jsonReader2);
                    if (fromJson != null) {
                        num = Integer.valueOf(fromJson.intValue());
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("file_size", "file_size", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"fil…     \"file_size\", reader)");
                        throw unexpectedNull;
                    }
                case 4:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 5:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 6:
                    str6 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 7:
                    str7 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 8:
                    str8 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 9:
                    str9 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 10:
                    str10 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 11:
                    str11 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 12:
                    str12 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 13:
                    str13 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 14:
                    str14 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 15:
                    Map fromJson2 = this.mapOfStringAnyAdapter.fromJson(jsonReader2);
                    if (fromJson2 != null) {
                        map = fromJson2;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("extraData", "extraData", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"ext…ta\", \"extraData\", reader)");
                        throw unexpectedNull2;
                    }
            }
        }
        jsonReader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (map != null) {
                return new AttachmentDto(str, str2, str3, intValue, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, map);
            }
            JsonDataException missingProperty = Util.missingProperty("extraData", "extraData", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"ex…ta\", \"extraData\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("file_size", "file_size", jsonReader2);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"fi…ze\", \"file_size\", reader)");
        throw missingProperty2;
    }

    public void toJson(JsonWriter jsonWriter, AttachmentDto attachmentDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (attachmentDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("asset_url");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getAsset_url());
            jsonWriter.name("author_name");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getAuthor_name());
            jsonWriter.name("fallback");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getFallback());
            jsonWriter.name("file_size");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(attachmentDto.getFile_size()));
            jsonWriter.name("image");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getImage());
            jsonWriter.name(MessengerShareContentUtility.IMAGE_URL);
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getImage_url());
            jsonWriter.name("mime_type");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getMime_type());
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getName());
            jsonWriter.name("og_scrape_url");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getOg_scrape_url());
            jsonWriter.name("text");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getText());
            jsonWriter.name("thumb_url");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getThumb_url());
            jsonWriter.name("title");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getTitle());
            jsonWriter.name("title_link");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getTitle_link());
            jsonWriter.name("type");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getType());
            jsonWriter.name("url");
            this.nullableStringAdapter.toJson(jsonWriter, attachmentDto.getUrl());
            jsonWriter.name("extraData");
            this.mapOfStringAnyAdapter.toJson(jsonWriter, attachmentDto.getExtraData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
