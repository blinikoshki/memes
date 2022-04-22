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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010+\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "dateAdapter", "Ljava/util/Date;", "intAdapter", "", "listOfAttachmentDtoAdapter", "", "Lio/getstream/chat/android/client/api2/model/dto/AttachmentDto;", "listOfReactionDtoAdapter", "Lio/getstream/chat/android/client/api2/model/dto/ReactionDto;", "listOfUserDtoAdapter", "Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "mapOfStringAnyAdapter", "", "", "", "mapOfStringIntAdapter", "mapOfStringStringAdapter", "nullableChannelInfoDtoAdapter", "Lio/getstream/chat/android/client/api2/model/dto/ChannelInfoDto;", "nullableDateAdapter", "nullableDownstreamMessageDtoAdapter", "nullableStringAdapter", "nullableUserDtoAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "userDtoAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDtoJsonAdapter */
/* compiled from: DownstreamMessageDtoJsonAdapter.kt */
public final class DownstreamMessageDtoJsonAdapter extends JsonAdapter<DownstreamMessageDto> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Date> dateAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<AttachmentDto>> listOfAttachmentDtoAdapter;
    private final JsonAdapter<List<ReactionDto>> listOfReactionDtoAdapter;
    private final JsonAdapter<List<UserDto>> listOfUserDtoAdapter;
    private final JsonAdapter<Map<String, Object>> mapOfStringAnyAdapter;
    private final JsonAdapter<Map<String, Integer>> mapOfStringIntAdapter;
    private final JsonAdapter<Map<String, String>> mapOfStringStringAdapter;
    private final JsonAdapter<ChannelInfoDto> nullableChannelInfoDtoAdapter;
    private final JsonAdapter<Date> nullableDateAdapter;
    private final JsonAdapter<DownstreamMessageDto> nullableDownstreamMessageDtoAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonAdapter<UserDto> nullableUserDtoAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<UserDto> userDtoAdapter;

    public DownstreamMessageDtoJsonAdapter(Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of = JsonReader.Options.m1002of("attachments", "channel", "cid", "command", "created_at", "deleted_at", "html", "i18n", "id", "latest_reactions", "mentioned_users", "own_reactions", "parent_id", "pin_expires", "pinned", "pinned_at", "pinned_by", "quoted_message", "quoted_message_id", "reaction_counts", "reaction_scores", "reply_count", "shadowed", "show_in_channel", NotificationCompat.GROUP_KEY_SILENT, "text", "thread_participants", "type", "updated_at", "user", "extraData");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a…at\", \"user\", \"extraData\")");
        this.options = of;
        JsonAdapter<List<AttachmentDto>> adapter = moshi2.adapter(Types.newParameterizedType(List.class, AttachmentDto.class), SetsKt.emptySet(), "attachments");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…mptySet(), \"attachments\")");
        this.listOfAttachmentDtoAdapter = adapter;
        JsonAdapter<ChannelInfoDto> adapter2 = moshi2.adapter(ChannelInfoDto.class, SetsKt.emptySet(), "channel");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ChannelInf…a, emptySet(), \"channel\")");
        this.nullableChannelInfoDtoAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi2.adapter(String.class, SetsKt.emptySet(), "cid");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl… emptySet(),\n      \"cid\")");
        this.stringAdapter = adapter3;
        JsonAdapter<String> adapter4 = moshi2.adapter(String.class, SetsKt.emptySet(), "command");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(String::cl…   emptySet(), \"command\")");
        this.nullableStringAdapter = adapter4;
        JsonAdapter<Date> adapter5 = moshi2.adapter(Date.class, SetsKt.emptySet(), "created_at");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Date::clas…et(),\n      \"created_at\")");
        this.dateAdapter = adapter5;
        JsonAdapter<Date> adapter6 = moshi2.adapter(Date.class, SetsKt.emptySet(), "deleted_at");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Date::clas…et(),\n      \"deleted_at\")");
        this.nullableDateAdapter = adapter6;
        JsonAdapter<Map<String, String>> adapter7 = moshi2.adapter(Types.newParameterizedType(Map.class, String.class, String.class), SetsKt.emptySet(), "i18n");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Types.newP…ava), emptySet(), \"i18n\")");
        this.mapOfStringStringAdapter = adapter7;
        JsonAdapter<List<ReactionDto>> adapter8 = moshi2.adapter(Types.newParameterizedType(List.class, ReactionDto.class), SetsKt.emptySet(), "latest_reactions");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Types.newP…et(), \"latest_reactions\")");
        this.listOfReactionDtoAdapter = adapter8;
        JsonAdapter<List<UserDto>> adapter9 = moshi2.adapter(Types.newParameterizedType(List.class, UserDto.class), SetsKt.emptySet(), "mentioned_users");
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(Types.newP…\n      \"mentioned_users\")");
        this.listOfUserDtoAdapter = adapter9;
        JsonAdapter<Boolean> adapter10 = moshi2.adapter(Boolean.TYPE, SetsKt.emptySet(), "pinned");
        Intrinsics.checkNotNullExpressionValue(adapter10, "moshi.adapter(Boolean::c…ptySet(),\n      \"pinned\")");
        this.booleanAdapter = adapter10;
        JsonAdapter<UserDto> adapter11 = moshi2.adapter(UserDto.class, SetsKt.emptySet(), "pinned_by");
        Intrinsics.checkNotNullExpressionValue(adapter11, "moshi.adapter(UserDto::c… emptySet(), \"pinned_by\")");
        this.nullableUserDtoAdapter = adapter11;
        JsonAdapter<DownstreamMessageDto> adapter12 = moshi2.adapter(DownstreamMessageDto.class, SetsKt.emptySet(), "quoted_message");
        Intrinsics.checkNotNullExpressionValue(adapter12, "moshi.adapter(Downstream…ySet(), \"quoted_message\")");
        this.nullableDownstreamMessageDtoAdapter = adapter12;
        JsonAdapter<Map<String, Integer>> adapter13 = moshi2.adapter(Types.newParameterizedType(Map.class, String.class, Integer.class), SetsKt.emptySet(), "reaction_counts");
        Intrinsics.checkNotNullExpressionValue(adapter13, "moshi.adapter(Types.newP…Set(), \"reaction_counts\")");
        this.mapOfStringIntAdapter = adapter13;
        JsonAdapter<Integer> adapter14 = moshi2.adapter(Integer.TYPE, SetsKt.emptySet(), "reply_count");
        Intrinsics.checkNotNullExpressionValue(adapter14, "moshi.adapter(Int::class…t(),\n      \"reply_count\")");
        this.intAdapter = adapter14;
        JsonAdapter<UserDto> adapter15 = moshi2.adapter(UserDto.class, SetsKt.emptySet(), "user");
        Intrinsics.checkNotNullExpressionValue(adapter15, "moshi.adapter(UserDto::c…emptySet(),\n      \"user\")");
        this.userDtoAdapter = adapter15;
        JsonAdapter<Map<String, Object>> adapter16 = moshi2.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), "extraData");
        Intrinsics.checkNotNullExpressionValue(adapter16, "moshi.adapter(Types.newP… emptySet(), \"extraData\")");
        this.mapOfStringAnyAdapter = adapter16;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(42);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DownstreamMessageDto");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0450, code lost:
        r12 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0452, code lost:
        r7 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0454, code lost:
        r5 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0456, code lost:
        r11 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0458, code lost:
        r10 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x045a, code lost:
        r9 = r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x045c, code lost:
        r2 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x045e, code lost:
        r3 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0460, code lost:
        r15 = r42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0462, code lost:
        r14 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0464, code lost:
        r13 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0466, code lost:
        r8 = r45;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0468, code lost:
        r6 = r46;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x046a, code lost:
        r4 = r47;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p015io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto fromJson(com.squareup.moshi.JsonReader r62) {
        /*
            r61 = this;
            r0 = r61
            r1 = r62
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 0
            r3 = r2
            java.util.List r3 = (java.util.List) r3
            r4 = r2
            io.getstream.chat.android.client.api2.model.dto.ChannelInfoDto r4 = (p015io.getstream.chat.android.client.api2.model.dto.ChannelInfoDto) r4
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            r6 = r2
            java.util.Date r6 = (java.util.Date) r6
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7
            r8 = r2
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            r9 = r2
            io.getstream.chat.android.client.api2.model.dto.UserDto r9 = (p015io.getstream.chat.android.client.api2.model.dto.UserDto) r9
            r10 = r2
            io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto r10 = (p015io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto) r10
            java.lang.Integer r2 = (java.lang.Integer) r2
            r62.beginObject()
            r16 = r3
            r17 = r16
            r18 = r17
            r30 = r18
            r13 = r5
            r15 = r13
            r19 = r15
            r24 = r19
            r29 = r24
            r31 = r29
            r12 = r6
            r20 = r12
            r21 = r20
            r32 = r21
            r14 = r7
            r25 = r14
            r26 = r25
            r34 = r26
            r11 = r8
            r22 = r9
            r33 = r22
            r23 = r10
            r7 = r31
            r3 = r11
            r9 = r3
            r10 = r9
            r8 = r32
            r6 = r7
            r5 = r4
            r4 = r30
        L_0x0059:
            boolean r27 = r62.hasNext()
            r28 = r12
            java.lang.String r12 = "user"
            r35 = r7
            java.lang.String r7 = "updated_at"
            r36 = r5
            java.lang.String r5 = "type"
            r37 = r11
            java.lang.String r11 = "thread_participants"
            r38 = r10
            java.lang.String r10 = "text"
            r39 = r9
            java.lang.String r9 = "silent"
            r40 = r2
            java.lang.String r2 = "show_in_channel"
            r41 = r3
            java.lang.String r3 = "shadowed"
            r42 = r15
            java.lang.String r15 = "reply_count"
            r43 = r14
            java.lang.String r14 = "reaction_scores"
            r44 = r13
            java.lang.String r13 = "reaction_counts"
            r45 = r8
            java.lang.String r8 = "pinned"
            r46 = r6
            java.lang.String r6 = "own_reactions"
            r47 = r4
            java.lang.String r4 = "mentioned_users"
            r48 = r4
            java.lang.String r4 = "latest_reactions"
            r49 = r4
            java.lang.String r4 = "id"
            r50 = r4
            java.lang.String r4 = "i18n"
            r51 = r4
            java.lang.String r4 = "html"
            r52 = r4
            java.lang.String r4 = "created_at"
            r53 = r4
            java.lang.String r4 = "cid"
            r54 = r4
            java.lang.String r4 = "attachments"
            if (r27 == 0) goto L_0x046e
            r27 = r4
            com.squareup.moshi.JsonReader$Options r4 = r0.options
            int r4 = r1.selectName(r4)
            switch(r4) {
                case -1: goto L_0x044a;
                case 0: goto L_0x0415;
                case 1: goto L_0x0407;
                case 2: goto L_0x03d4;
                case 3: goto L_0x03c7;
                case 4: goto L_0x0396;
                case 5: goto L_0x038b;
                case 6: goto L_0x035c;
                case 7: goto L_0x032f;
                case 8: goto L_0x0304;
                case 9: goto L_0x02e8;
                case 10: goto L_0x02cc;
                case 11: goto L_0x02b2;
                case 12: goto L_0x02a6;
                case 13: goto L_0x029a;
                case 14: goto L_0x026b;
                case 15: goto L_0x025f;
                case 16: goto L_0x0253;
                case 17: goto L_0x0247;
                case 18: goto L_0x023b;
                case 19: goto L_0x0221;
                case 20: goto L_0x0207;
                case 21: goto L_0x01db;
                case 22: goto L_0x01b0;
                case 23: goto L_0x0187;
                case 24: goto L_0x0160;
                case 25: goto L_0x0146;
                case 26: goto L_0x012c;
                case 27: goto L_0x0112;
                case 28: goto L_0x00f8;
                case 29: goto L_0x00de;
                case 30: goto L_0x00c0;
                default: goto L_0x00be;
            }
        L_0x00be:
            goto L_0x0450
        L_0x00c0:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.Object>> r2 = r0.mapOfStringAnyAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x00ce
            r34 = r2
            goto L_0x0450
        L_0x00ce:
            java.lang.String r2 = "extraData"
            java.lang.String r3 = "extraData"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"ext…ta\", \"extraData\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00de:
            com.squareup.moshi.JsonAdapter<io.getstream.chat.android.client.api2.model.dto.UserDto> r2 = r0.userDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            io.getstream.chat.android.client.api2.model.dto.UserDto r2 = (p015io.getstream.chat.android.client.api2.model.dto.UserDto) r2
            if (r2 == 0) goto L_0x00ec
            r33 = r2
            goto L_0x0450
        L_0x00ec:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"use…ser\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00f8:
            com.squareup.moshi.JsonAdapter<java.util.Date> r2 = r0.dateAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Date r2 = (java.util.Date) r2
            if (r2 == 0) goto L_0x0106
            r32 = r2
            goto L_0x0450
        L_0x0106:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"upd…    \"updated_at\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0112:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0120
            r31 = r2
            goto L_0x0450
        L_0x0120:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r5, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"typ…ype\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x012c:
            com.squareup.moshi.JsonAdapter<java.util.List<io.getstream.chat.android.client.api2.model.dto.UserDto>> r2 = r0.listOfUserDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x013a
            r30 = r2
            goto L_0x0450
        L_0x013a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"thr…ad_participants\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0146:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0154
            r29 = r2
            goto L_0x0450
        L_0x0154:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"tex…ext\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0160:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x017b
            boolean r2 = r2.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r11 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            goto L_0x0458
        L_0x017b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"sil…        \"silent\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0187:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r3 = r0.booleanAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x01a4
            boolean r2 = r3.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r10 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            goto L_0x045a
        L_0x01a4:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"sho…show_in_channel\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01b0:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x01cf
            boolean r2 = r2.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r9 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            goto L_0x045c
        L_0x01cf:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r3, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"sha…      \"shadowed\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01db:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x01fb
            int r2 = r2.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            r9 = r39
            goto L_0x045e
        L_0x01fb:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"rep…   \"reply_count\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0207:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.Integer>> r2 = r0.mapOfStringIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x0215
            r26 = r2
            goto L_0x0450
        L_0x0215:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"rea…reaction_scores\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0221:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.Integer>> r2 = r0.mapOfStringIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x022f
            r25 = r2
            goto L_0x0450
        L_0x022f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"rea…reaction_counts\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x023b:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            r24 = r2
            goto L_0x0450
        L_0x0247:
            com.squareup.moshi.JsonAdapter<io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto> r2 = r0.nullableDownstreamMessageDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto r2 = (p015io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto) r2
            r23 = r2
            goto L_0x0450
        L_0x0253:
            com.squareup.moshi.JsonAdapter<io.getstream.chat.android.client.api2.model.dto.UserDto> r2 = r0.nullableUserDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            io.getstream.chat.android.client.api2.model.dto.UserDto r2 = (p015io.getstream.chat.android.client.api2.model.dto.UserDto) r2
            r22 = r2
            goto L_0x0450
        L_0x025f:
            com.squareup.moshi.JsonAdapter<java.util.Date> r2 = r0.nullableDateAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Date r2 = (java.util.Date) r2
            r21 = r2
            goto L_0x0450
        L_0x026b:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x028e
            boolean r2 = r2.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r3 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            r9 = r39
            r2 = r40
            goto L_0x0460
        L_0x028e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r8, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"pin…        \"pinned\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x029a:
            com.squareup.moshi.JsonAdapter<java.util.Date> r2 = r0.nullableDateAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Date r2 = (java.util.Date) r2
            r20 = r2
            goto L_0x0450
        L_0x02a6:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            r19 = r2
            goto L_0x0450
        L_0x02b2:
            com.squareup.moshi.JsonAdapter<java.util.List<io.getstream.chat.android.client.api2.model.dto.ReactionDto>> r2 = r0.listOfReactionDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x02c0
            r18 = r2
            goto L_0x0450
        L_0x02c0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"own… \"own_reactions\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x02cc:
            com.squareup.moshi.JsonAdapter<java.util.List<io.getstream.chat.android.client.api2.model.dto.UserDto>> r2 = r0.listOfUserDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x02da
            r17 = r2
            goto L_0x0450
        L_0x02da:
            r4 = r48
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"men…mentioned_users\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x02e8:
            com.squareup.moshi.JsonAdapter<java.util.List<io.getstream.chat.android.client.api2.model.dto.ReactionDto>> r2 = r0.listOfReactionDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x02f6
            r16 = r2
            goto L_0x0450
        L_0x02f6:
            r2 = r49
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"lat…atest_reactions\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0304:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0321
            r15 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            r9 = r39
            r2 = r40
            r3 = r41
            goto L_0x0462
        L_0x0321:
            r2 = r50
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x032f:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.String>> r2 = r0.mapOfStringStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x034e
            r14 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            r9 = r39
            r2 = r40
            r3 = r41
            r15 = r42
            goto L_0x0464
        L_0x034e:
            r2 = r51
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"i18…          \"i18n\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x035c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x037d
            r13 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            r9 = r39
            r2 = r40
            r3 = r41
            r15 = r42
            r14 = r43
            goto L_0x0466
        L_0x037d:
            r2 = r52
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"htm…tml\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x038b:
            com.squareup.moshi.JsonAdapter<java.util.Date> r2 = r0.nullableDateAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Date r2 = (java.util.Date) r2
            r12 = r2
            goto L_0x0452
        L_0x0396:
            com.squareup.moshi.JsonAdapter<java.util.Date> r2 = r0.dateAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.Date r2 = (java.util.Date) r2
            if (r2 == 0) goto L_0x03b9
            r8 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            r9 = r39
            r2 = r40
            r3 = r41
            r15 = r42
            r14 = r43
            r13 = r44
            goto L_0x0468
        L_0x03b9:
            r2 = r53
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"cre…    \"created_at\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x03c7:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            r7 = r2
            r12 = r28
            goto L_0x0454
        L_0x03d4:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x03f9
            r6 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            r9 = r39
            r2 = r40
            r3 = r41
            r15 = r42
            r14 = r43
            r13 = r44
            r8 = r45
            goto L_0x046a
        L_0x03f9:
            r2 = r54
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"cid\", \"cid\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0407:
            com.squareup.moshi.JsonAdapter<io.getstream.chat.android.client.api2.model.dto.ChannelInfoDto> r2 = r0.nullableChannelInfoDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            io.getstream.chat.android.client.api2.model.dto.ChannelInfoDto r2 = (p015io.getstream.chat.android.client.api2.model.dto.ChannelInfoDto) r2
            r5 = r2
            r12 = r28
            r7 = r35
            goto L_0x0456
        L_0x0415:
            com.squareup.moshi.JsonAdapter<java.util.List<io.getstream.chat.android.client.api2.model.dto.AttachmentDto>> r2 = r0.listOfAttachmentDtoAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x043c
            r4 = r2
            r12 = r28
            r7 = r35
            r5 = r36
            r11 = r37
            r10 = r38
            r9 = r39
            r2 = r40
            r3 = r41
            r15 = r42
            r14 = r43
            r13 = r44
            r8 = r45
            r6 = r46
            goto L_0x0059
        L_0x043c:
            r2 = r27
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"att…\", \"attachments\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x044a:
            r62.skipName()
            r62.skipValue()
        L_0x0450:
            r12 = r28
        L_0x0452:
            r7 = r35
        L_0x0454:
            r5 = r36
        L_0x0456:
            r11 = r37
        L_0x0458:
            r10 = r38
        L_0x045a:
            r9 = r39
        L_0x045c:
            r2 = r40
        L_0x045e:
            r3 = r41
        L_0x0460:
            r15 = r42
        L_0x0462:
            r14 = r43
        L_0x0464:
            r13 = r44
        L_0x0466:
            r8 = r45
        L_0x0468:
            r6 = r46
        L_0x046a:
            r4 = r47
            goto L_0x0059
        L_0x046e:
            r60 = r4
            r4 = r48
            r0 = r49
            r55 = r50
            r56 = r51
            r57 = r52
            r58 = r53
            r59 = r54
            r62.endObject()
            io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto r48 = new io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto
            if (r47 == 0) goto L_0x0605
            if (r46 == 0) goto L_0x05f7
            if (r45 == 0) goto L_0x05e9
            if (r44 == 0) goto L_0x05db
            if (r43 == 0) goto L_0x05cd
            if (r42 == 0) goto L_0x05bf
            if (r16 == 0) goto L_0x05b3
            if (r17 == 0) goto L_0x05a7
            if (r18 == 0) goto L_0x059b
            if (r41 == 0) goto L_0x058f
            boolean r0 = r41.booleanValue()
            if (r25 == 0) goto L_0x0583
            if (r26 == 0) goto L_0x0577
            if (r40 == 0) goto L_0x056b
            int r27 = r40.intValue()
            if (r39 == 0) goto L_0x055f
            boolean r39 = r39.booleanValue()
            if (r38 == 0) goto L_0x0553
            boolean r2 = r38.booleanValue()
            if (r37 == 0) goto L_0x0547
            boolean r37 = r37.booleanValue()
            if (r29 == 0) goto L_0x053b
            if (r30 == 0) goto L_0x052f
            if (r31 == 0) goto L_0x0523
            if (r32 == 0) goto L_0x0517
            if (r33 == 0) goto L_0x050b
            if (r34 == 0) goto L_0x04fb
            r3 = r48
            r4 = r47
            r5 = r36
            r6 = r46
            r7 = r35
            r8 = r45
            r9 = r28
            r10 = r44
            r11 = r43
            r12 = r42
            r13 = r16
            r14 = r17
            r15 = r18
            r16 = r19
            r17 = r20
            r18 = r0
            r19 = r21
            r20 = r22
            r21 = r23
            r22 = r24
            r23 = r25
            r24 = r26
            r25 = r27
            r26 = r39
            r27 = r2
            r28 = r37
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return r48
        L_0x04fb:
            java.lang.String r0 = "extraData"
            java.lang.String r2 = "extraData"
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r2, r1)
            java.lang.String r1 = "Util.missingProperty(\"ex…ta\", \"extraData\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x050b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r1 = "Util.missingProperty(\"user\", \"user\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0517:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r1 = "Util.missingProperty(\"up…t\", \"updated_at\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0523:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r5, r5, r1)
            java.lang.String r1 = "Util.missingProperty(\"type\", \"type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x052f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r1 = "Util.missingProperty(\"th…ad_participants\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x053b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r1 = "Util.missingProperty(\"text\", \"text\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0547:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r1 = "Util.missingProperty(\"silent\", \"silent\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0553:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r1 = "Util.missingProperty(\"sh…show_in_channel\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x055f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r3, r3, r1)
            java.lang.String r1 = "Util.missingProperty(\"sh…wed\", \"shadowed\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x056b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r1 = "Util.missingProperty(\"re…unt\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0577:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r1 = "Util.missingProperty(\"re…reaction_scores\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0583:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r1 = "Util.missingProperty(\"re…reaction_counts\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x058f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r8, r8, r1)
            java.lang.String r1 = "Util.missingProperty(\"pinned\", \"pinned\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x059b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r1 = "Util.missingProperty(\"ow… \"own_reactions\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x05a7:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r1 = "Util.missingProperty(\"me…mentioned_users\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x05b3:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "Util.missingProperty(\"la…atest_reactions\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x05bf:
            r0 = r55
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "Util.missingProperty(\"id\", \"id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x05cd:
            r0 = r56
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "Util.missingProperty(\"i18n\", \"i18n\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x05db:
            r0 = r57
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "Util.missingProperty(\"html\", \"html\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x05e9:
            r0 = r58
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "Util.missingProperty(\"cr…t\", \"created_at\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x05f7:
            r0 = r59
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "Util.missingProperty(\"cid\", \"cid\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0605:
            r0 = r60
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "Util.missingProperty(\"at…nts\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDtoJsonAdapter.fromJson(com.squareup.moshi.JsonReader):io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto");
    }

    public void toJson(JsonWriter jsonWriter, DownstreamMessageDto downstreamMessageDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (downstreamMessageDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("attachments");
            this.listOfAttachmentDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getAttachments());
            jsonWriter.name("channel");
            this.nullableChannelInfoDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getChannel());
            jsonWriter.name("cid");
            this.stringAdapter.toJson(jsonWriter, downstreamMessageDto.getCid());
            jsonWriter.name("command");
            this.nullableStringAdapter.toJson(jsonWriter, downstreamMessageDto.getCommand());
            jsonWriter.name("created_at");
            this.dateAdapter.toJson(jsonWriter, downstreamMessageDto.getCreated_at());
            jsonWriter.name("deleted_at");
            this.nullableDateAdapter.toJson(jsonWriter, downstreamMessageDto.getDeleted_at());
            jsonWriter.name("html");
            this.stringAdapter.toJson(jsonWriter, downstreamMessageDto.getHtml());
            jsonWriter.name("i18n");
            this.mapOfStringStringAdapter.toJson(jsonWriter, downstreamMessageDto.getI18n());
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, downstreamMessageDto.getId());
            jsonWriter.name("latest_reactions");
            this.listOfReactionDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getLatest_reactions());
            jsonWriter.name("mentioned_users");
            this.listOfUserDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getMentioned_users());
            jsonWriter.name("own_reactions");
            this.listOfReactionDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getOwn_reactions());
            jsonWriter.name("parent_id");
            this.nullableStringAdapter.toJson(jsonWriter, downstreamMessageDto.getParent_id());
            jsonWriter.name("pin_expires");
            this.nullableDateAdapter.toJson(jsonWriter, downstreamMessageDto.getPin_expires());
            jsonWriter.name("pinned");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(downstreamMessageDto.getPinned()));
            jsonWriter.name("pinned_at");
            this.nullableDateAdapter.toJson(jsonWriter, downstreamMessageDto.getPinned_at());
            jsonWriter.name("pinned_by");
            this.nullableUserDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getPinned_by());
            jsonWriter.name("quoted_message");
            this.nullableDownstreamMessageDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getQuoted_message());
            jsonWriter.name("quoted_message_id");
            this.nullableStringAdapter.toJson(jsonWriter, downstreamMessageDto.getQuoted_message_id());
            jsonWriter.name("reaction_counts");
            this.mapOfStringIntAdapter.toJson(jsonWriter, downstreamMessageDto.getReaction_counts());
            jsonWriter.name("reaction_scores");
            this.mapOfStringIntAdapter.toJson(jsonWriter, downstreamMessageDto.getReaction_scores());
            jsonWriter.name("reply_count");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(downstreamMessageDto.getReply_count()));
            jsonWriter.name("shadowed");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(downstreamMessageDto.getShadowed()));
            jsonWriter.name("show_in_channel");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(downstreamMessageDto.getShow_in_channel()));
            jsonWriter.name(NotificationCompat.GROUP_KEY_SILENT);
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(downstreamMessageDto.getSilent()));
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, downstreamMessageDto.getText());
            jsonWriter.name("thread_participants");
            this.listOfUserDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getThread_participants());
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, downstreamMessageDto.getType());
            jsonWriter.name("updated_at");
            this.dateAdapter.toJson(jsonWriter, downstreamMessageDto.getUpdated_at());
            jsonWriter.name("user");
            this.userDtoAdapter.toJson(jsonWriter, downstreamMessageDto.getUser());
            jsonWriter.name("extraData");
            this.mapOfStringAnyAdapter.toJson(jsonWriter, downstreamMessageDto.getExtraData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
