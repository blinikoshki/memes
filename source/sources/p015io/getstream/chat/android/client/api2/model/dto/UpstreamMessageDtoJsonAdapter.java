package p015io.getstream.chat.android.client.api2.model.dto;

import androidx.core.app.NotificationCompat;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010#\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/UpstreamMessageDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lio/getstream/chat/android/client/api2/model/dto/UpstreamMessageDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "listOfAttachmentDtoAdapter", "", "Lio/getstream/chat/android/client/api2/model/dto/AttachmentDto;", "listOfStringAdapter", "", "listOfUserDtoAdapter", "Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "mapOfStringAnyAdapter", "", "", "nullableDateAdapter", "Ljava/util/Date;", "nullableStringAdapter", "nullableUpstreamMessageDtoAdapter", "nullableUserDtoAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "userDtoAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDtoJsonAdapter */
/* compiled from: UpstreamMessageDtoJsonAdapter.kt */
public final class UpstreamMessageDtoJsonAdapter extends JsonAdapter<UpstreamMessageDto> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<List<AttachmentDto>> listOfAttachmentDtoAdapter;
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonAdapter<List<UserDto>> listOfUserDtoAdapter;
    private final JsonAdapter<Map<String, Object>> mapOfStringAnyAdapter;
    private final JsonAdapter<Date> nullableDateAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonAdapter<UpstreamMessageDto> nullableUpstreamMessageDtoAdapter;
    private final JsonAdapter<UserDto> nullableUserDtoAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<UserDto> userDtoAdapter;

    public UpstreamMessageDtoJsonAdapter(Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of = JsonReader.Options.m1002of("attachments", "cid", "command", "html", "id", "mentioned_users", "parent_id", "pin_expires", "pinned", "pinned_at", "pinned_by", "quoted_message", "quoted_message_id", "shadowed", "show_in_channel", NotificationCompat.GROUP_KEY_SILENT, "text", "thread_participants", "user", "extraData");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a…ts\", \"user\", \"extraData\")");
        this.options = of;
        JsonAdapter<List<AttachmentDto>> adapter = moshi2.adapter(Types.newParameterizedType(List.class, AttachmentDto.class), SetsKt.emptySet(), "attachments");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…mptySet(), \"attachments\")");
        this.listOfAttachmentDtoAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi2.adapter(String.class, SetsKt.emptySet(), "cid");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl… emptySet(),\n      \"cid\")");
        this.stringAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi2.adapter(String.class, SetsKt.emptySet(), "command");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl…   emptySet(), \"command\")");
        this.nullableStringAdapter = adapter3;
        JsonAdapter<List<String>> adapter4 = moshi2.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "mentioned_users");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…\n      \"mentioned_users\")");
        this.listOfStringAdapter = adapter4;
        JsonAdapter<Date> adapter5 = moshi2.adapter(Date.class, SetsKt.emptySet(), "pin_expires");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Date::clas…t(),\n      \"pin_expires\")");
        this.nullableDateAdapter = adapter5;
        JsonAdapter<Boolean> adapter6 = moshi2.adapter(Boolean.TYPE, SetsKt.emptySet(), "pinned");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Boolean::c…ptySet(),\n      \"pinned\")");
        this.booleanAdapter = adapter6;
        JsonAdapter<UserDto> adapter7 = moshi2.adapter(UserDto.class, SetsKt.emptySet(), "pinned_by");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(UserDto::c… emptySet(), \"pinned_by\")");
        this.nullableUserDtoAdapter = adapter7;
        JsonAdapter<UpstreamMessageDto> adapter8 = moshi2.adapter(UpstreamMessageDto.class, SetsKt.emptySet(), "quoted_message");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(UpstreamMe…ySet(), \"quoted_message\")");
        this.nullableUpstreamMessageDtoAdapter = adapter8;
        JsonAdapter<List<UserDto>> adapter9 = moshi2.adapter(Types.newParameterizedType(List.class, UserDto.class), SetsKt.emptySet(), "thread_participants");
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(Types.newP…   \"thread_participants\")");
        this.listOfUserDtoAdapter = adapter9;
        JsonAdapter<UserDto> adapter10 = moshi2.adapter(UserDto.class, SetsKt.emptySet(), "user");
        Intrinsics.checkNotNullExpressionValue(adapter10, "moshi.adapter(UserDto::c…emptySet(),\n      \"user\")");
        this.userDtoAdapter = adapter10;
        JsonAdapter<Map<String, Object>> adapter11 = moshi2.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), "extraData");
        Intrinsics.checkNotNullExpressionValue(adapter11, "moshi.adapter(Types.newP… emptySet(), \"extraData\")");
        this.mapOfStringAnyAdapter = adapter11;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("GeneratedJsonAdapter(");
        sb.append("UpstreamMessageDto");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0296, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0298, code lost:
        r4 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x029a, code lost:
        r3 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x029c, code lost:
        r2 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x029e, code lost:
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02a0, code lost:
        r15 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02a2, code lost:
        r14 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a4, code lost:
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02a6, code lost:
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02a8, code lost:
        r10 = r35;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p015io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto fromJson(com.squareup.moshi.JsonReader r37) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 0
            r3 = r2
            java.util.List r3 = (java.util.List) r3
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            r5 = r2
            java.util.Date r5 = (java.util.Date) r5
            r6 = r2
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            r7 = r2
            io.getstream.chat.android.client.api2.model.dto.UserDto r7 = (p015io.getstream.chat.android.client.api2.model.dto.UserDto) r7
            r8 = r2
            io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto r8 = (p015io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto) r8
            java.util.Map r2 = (java.util.Map) r2
            r37.beginObject()
            r29 = r2
            r10 = r3
            r15 = r10
            r27 = r15
            r11 = r4
            r12 = r11
            r13 = r12
            r14 = r13
            r16 = r14
            r22 = r16
            r26 = r22
            r17 = r5
            r19 = r17
            r2 = r6
            r3 = r2
            r4 = r3
            r20 = r7
            r28 = r20
            r21 = r8
        L_0x003e:
            boolean r5 = r37.hasNext()
            java.lang.String r7 = "extraData"
            java.lang.String r8 = "user"
            java.lang.String r9 = "thread_participants"
            r18 = r12
            java.lang.String r12 = "text"
            r23 = r4
            java.lang.String r4 = "silent"
            r24 = r3
            java.lang.String r3 = "show_in_channel"
            r25 = r2
            java.lang.String r2 = "shadowed"
            r30 = r6
            java.lang.String r6 = "pinned"
            r31 = r15
            java.lang.String r15 = "mentioned_users"
            r32 = r14
            java.lang.String r14 = "id"
            r33 = r13
            java.lang.String r13 = "html"
            r34 = r11
            java.lang.String r11 = "cid"
            r35 = r10
            java.lang.String r10 = "attachments"
            if (r5 == 0) goto L_0x02ac
            com.squareup.moshi.JsonReader$Options r5 = r0.options
            int r5 = r1.selectName(r5)
            switch(r5) {
                case -1: goto L_0x0290;
                case 0: goto L_0x0265;
                case 1: goto L_0x023d;
                case 2: goto L_0x0233;
                case 3: goto L_0x020c;
                case 4: goto L_0x01e7;
                case 5: goto L_0x01c4;
                case 6: goto L_0x01b8;
                case 7: goto L_0x01ac;
                case 8: goto L_0x0183;
                case 9: goto L_0x0177;
                case 10: goto L_0x016b;
                case 11: goto L_0x015f;
                case 12: goto L_0x0153;
                case 13: goto L_0x012d;
                case 14: goto L_0x0108;
                case 15: goto L_0x00e5;
                case 16: goto L_0x00cb;
                case 17: goto L_0x00b1;
                case 18: goto L_0x0097;
                case 19: goto L_0x007d;
                default: goto L_0x007b;
            }
        L_0x007b:
            goto L_0x0296
        L_0x007d:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.Object>> r2 = r0.mapOfStringAnyAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x008b
            r29 = r2
            goto L_0x0296
        L_0x008b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"ext…ta\", \"extraData\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0097:
            com.squareup.moshi.JsonAdapter<io.getstream.chat.android.client.api2.model.dto.UserDto> r2 = r0.userDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            io.getstream.chat.android.client.api2.model.dto.UserDto r2 = (p015io.getstream.chat.android.client.api2.model.dto.UserDto) r2
            if (r2 == 0) goto L_0x00a5
            r28 = r2
            goto L_0x0296
        L_0x00a5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r8, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"use…ser\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00b1:
            com.squareup.moshi.JsonAdapter<java.util.List<io.getstream.chat.android.client.api2.model.dto.UserDto>> r2 = r0.listOfUserDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00bf
            r27 = r2
            goto L_0x0296
        L_0x00bf:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"thr…ad_participants\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00cb:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00d9
            r26 = r2
            goto L_0x0296
        L_0x00d9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"tex…ext\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00e5:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x00fc
            boolean r2 = r2.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4 = r2
            r12 = r18
            goto L_0x029a
        L_0x00fc:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"sil…        \"silent\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0108:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x0121
            boolean r2 = r2.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r3 = r2
            r12 = r18
            r4 = r23
            goto L_0x029c
        L_0x0121:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r3, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"sho…show_in_channel\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x012d:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r3 = r0.booleanAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x0147
            boolean r2 = r3.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r12 = r18
            r4 = r23
            r3 = r24
            goto L_0x029e
        L_0x0147:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"sha…      \"shadowed\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0153:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            r22 = r2
            goto L_0x0296
        L_0x015f:
            com.squareup.moshi.JsonAdapter<io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto> r2 = r0.nullableUpstreamMessageDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto r2 = (p015io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto) r2
            r21 = r2
            goto L_0x0296
        L_0x016b:
            com.squareup.moshi.JsonAdapter<io.getstream.chat.android.client.api2.model.dto.UserDto> r2 = r0.nullableUserDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            io.getstream.chat.android.client.api2.model.dto.UserDto r2 = (p015io.getstream.chat.android.client.api2.model.dto.UserDto) r2
            r20 = r2
            goto L_0x0296
        L_0x0177:
            com.squareup.moshi.JsonAdapter<java.util.Date> r2 = r0.nullableDateAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Date r2 = (java.util.Date) r2
            r19 = r2
            goto L_0x0296
        L_0x0183:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x01a0
            boolean r2 = r2.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6 = r2
            r12 = r18
            r4 = r23
            r3 = r24
            r2 = r25
            goto L_0x02a0
        L_0x01a0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"pin…        \"pinned\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01ac:
            com.squareup.moshi.JsonAdapter<java.util.Date> r2 = r0.nullableDateAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Date r2 = (java.util.Date) r2
            r17 = r2
            goto L_0x0296
        L_0x01b8:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            r16 = r2
            goto L_0x0296
        L_0x01c4:
            com.squareup.moshi.JsonAdapter<java.util.List<java.lang.String>> r2 = r0.listOfStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x01db
            r15 = r2
            r12 = r18
            r4 = r23
            r3 = r24
            r2 = r25
            r6 = r30
            goto L_0x02a2
        L_0x01db:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"men…mentioned_users\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01e7:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0200
            r14 = r2
            r12 = r18
            r4 = r23
            r3 = r24
            r2 = r25
            r6 = r30
            r15 = r31
            goto L_0x02a4
        L_0x0200:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x020c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0227
            r13 = r2
            r12 = r18
            r4 = r23
            r3 = r24
            r2 = r25
            r6 = r30
            r15 = r31
            r14 = r32
            goto L_0x02a6
        L_0x0227:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"htm…tml\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0233:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            r12 = r2
            goto L_0x0298
        L_0x023d:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0259
            r11 = r2
            r12 = r18
            r4 = r23
            r3 = r24
            r2 = r25
            r6 = r30
            r15 = r31
            r14 = r32
            r13 = r33
            goto L_0x02a8
        L_0x0259:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"cid\", \"cid\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0265:
            com.squareup.moshi.JsonAdapter<java.util.List<io.getstream.chat.android.client.api2.model.dto.AttachmentDto>> r2 = r0.listOfAttachmentDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0284
            r10 = r2
            r12 = r18
            r4 = r23
            r3 = r24
            r2 = r25
            r6 = r30
            r15 = r31
            r14 = r32
            r13 = r33
            r11 = r34
            goto L_0x003e
        L_0x0284:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"att…\", \"attachments\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0290:
            r37.skipName()
            r37.skipValue()
        L_0x0296:
            r12 = r18
        L_0x0298:
            r4 = r23
        L_0x029a:
            r3 = r24
        L_0x029c:
            r2 = r25
        L_0x029e:
            r6 = r30
        L_0x02a0:
            r15 = r31
        L_0x02a2:
            r14 = r32
        L_0x02a4:
            r13 = r33
        L_0x02a6:
            r11 = r34
        L_0x02a8:
            r10 = r35
            goto L_0x003e
        L_0x02ac:
            r37.endObject()
            io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto r5 = new io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto
            if (r35 == 0) goto L_0x0380
            if (r34 == 0) goto L_0x0374
            if (r33 == 0) goto L_0x0368
            if (r32 == 0) goto L_0x035c
            if (r31 == 0) goto L_0x0350
            if (r30 == 0) goto L_0x0344
            boolean r6 = r30.booleanValue()
            if (r25 == 0) goto L_0x0338
            boolean r2 = r25.booleanValue()
            if (r24 == 0) goto L_0x032c
            boolean r24 = r24.booleanValue()
            if (r23 == 0) goto L_0x0320
            boolean r25 = r23.booleanValue()
            if (r26 == 0) goto L_0x0314
            if (r27 == 0) goto L_0x0308
            if (r28 == 0) goto L_0x02fc
            if (r29 == 0) goto L_0x02f0
            r9 = r5
            r10 = r35
            r11 = r34
            r12 = r18
            r13 = r33
            r14 = r32
            r15 = r31
            r18 = r6
            r23 = r2
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r5
        L_0x02f0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "Util.missingProperty(\"ex…ta\", \"extraData\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x02fc:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r8, r8, r1)
            java.lang.String r2 = "Util.missingProperty(\"user\", \"user\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0308:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "Util.missingProperty(\"th…ad_participants\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0314:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "Util.missingProperty(\"text\", \"text\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0320:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r2 = "Util.missingProperty(\"silent\", \"silent\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x032c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r3, r1)
            java.lang.String r2 = "Util.missingProperty(\"sh…show_in_channel\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0338:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "Util.missingProperty(\"sh…wed\", \"shadowed\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0344:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r2 = "Util.missingProperty(\"pinned\", \"pinned\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0350:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r2 = "Util.missingProperty(\"me…mentioned_users\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x035c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r2 = "Util.missingProperty(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0368:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "Util.missingProperty(\"html\", \"html\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0374:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "Util.missingProperty(\"cid\", \"cid\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0380:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "Util.missingProperty(\"at…nts\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDtoJsonAdapter.fromJson(com.squareup.moshi.JsonReader):io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto");
    }

    public void toJson(JsonWriter jsonWriter, UpstreamMessageDto upstreamMessageDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (upstreamMessageDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("attachments");
            this.listOfAttachmentDtoAdapter.toJson(jsonWriter, upstreamMessageDto.getAttachments());
            jsonWriter.name("cid");
            this.stringAdapter.toJson(jsonWriter, upstreamMessageDto.getCid());
            jsonWriter.name("command");
            this.nullableStringAdapter.toJson(jsonWriter, upstreamMessageDto.getCommand());
            jsonWriter.name("html");
            this.stringAdapter.toJson(jsonWriter, upstreamMessageDto.getHtml());
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, upstreamMessageDto.getId());
            jsonWriter.name("mentioned_users");
            this.listOfStringAdapter.toJson(jsonWriter, upstreamMessageDto.getMentioned_users());
            jsonWriter.name("parent_id");
            this.nullableStringAdapter.toJson(jsonWriter, upstreamMessageDto.getParent_id());
            jsonWriter.name("pin_expires");
            this.nullableDateAdapter.toJson(jsonWriter, upstreamMessageDto.getPin_expires());
            jsonWriter.name("pinned");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(upstreamMessageDto.getPinned()));
            jsonWriter.name("pinned_at");
            this.nullableDateAdapter.toJson(jsonWriter, upstreamMessageDto.getPinned_at());
            jsonWriter.name("pinned_by");
            this.nullableUserDtoAdapter.toJson(jsonWriter, upstreamMessageDto.getPinned_by());
            jsonWriter.name("quoted_message");
            this.nullableUpstreamMessageDtoAdapter.toJson(jsonWriter, upstreamMessageDto.getQuoted_message());
            jsonWriter.name("quoted_message_id");
            this.nullableStringAdapter.toJson(jsonWriter, upstreamMessageDto.getQuoted_message_id());
            jsonWriter.name("shadowed");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(upstreamMessageDto.getShadowed()));
            jsonWriter.name("show_in_channel");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(upstreamMessageDto.getShow_in_channel()));
            jsonWriter.name(NotificationCompat.GROUP_KEY_SILENT);
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(upstreamMessageDto.getSilent()));
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, upstreamMessageDto.getText());
            jsonWriter.name("thread_participants");
            this.listOfUserDtoAdapter.toJson(jsonWriter, upstreamMessageDto.getThread_participants());
            jsonWriter.name("user");
            this.userDtoAdapter.toJson(jsonWriter, upstreamMessageDto.getUser());
            jsonWriter.name("extraData");
            this.mapOfStringAnyAdapter.toJson(jsonWriter, upstreamMessageDto.getExtraData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
