package p015io.getstream.chat.android.client.api2.model.requests;

import com.facebook.share.internal.ShareConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/requests/MessageRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lio/getstream/chat/android/client/api2/model/requests/MessageRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "upstreamMessageDtoAdapter", "Lio/getstream/chat/android/client/api2/model/dto/UpstreamMessageDto;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.requests.MessageRequestJsonAdapter */
/* compiled from: MessageRequestJsonAdapter.kt */
public final class MessageRequestJsonAdapter extends JsonAdapter<MessageRequest> {
    private final JsonReader.Options options;
    private final JsonAdapter<UpstreamMessageDto> upstreamMessageDtoAdapter;

    public MessageRequestJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.m1002of(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"message\")");
        this.options = of;
        JsonAdapter<UpstreamMessageDto> adapter = moshi.adapter(UpstreamMessageDto.class, SetsKt.emptySet(), ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(UpstreamMe…a, emptySet(), \"message\")");
        this.upstreamMessageDtoAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(");
        sb.append("MessageRequest");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageRequest fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        UpstreamMessageDto upstreamMessageDto = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (upstreamMessageDto = this.upstreamMessageDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ShareConstants.WEB_DIALOG_PARAM_MESSAGE, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"message\", \"message\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (upstreamMessageDto != null) {
            return new MessageRequest(upstreamMessageDto);
        }
        JsonDataException missingProperty = Util.missingProperty(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ShareConstants.WEB_DIALOG_PARAM_MESSAGE, jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"message\", \"message\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, MessageRequest messageRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messageRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            this.upstreamMessageDtoAdapter.toJson(jsonWriter, messageRequest.getMessage());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
