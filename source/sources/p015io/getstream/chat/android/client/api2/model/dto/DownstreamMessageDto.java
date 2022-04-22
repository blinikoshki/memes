package p015io.getstream.chat.android.client.api2.model.dto;

import com.squareup.moshi.JsonClass;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bY\b\b\u0018\u00002\u00020\u0001BÝ\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0\u000f\u0012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0\u000f\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020\u0019\u0012\u0006\u0010%\u001a\u00020\b\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020\u000b\u0012\u0006\u0010)\u001a\u00020\u0014\u0012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0010+J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003HÆ\u0003J\u000f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u0019HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0015\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0\u000fHÆ\u0003J\u0015\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0\u000fHÆ\u0003J\t\u0010b\u001a\u00020\u001fHÆ\u0003J\t\u0010c\u001a\u00020\u0019HÆ\u0003J\t\u0010d\u001a\u00020\u0019HÆ\u0003J\t\u0010e\u001a\u00020\u0019HÆ\u0003J\t\u0010f\u001a\u00020\bHÆ\u0003J\u000f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0003J\t\u0010h\u001a\u00020\bHÆ\u0003J\t\u0010i\u001a\u00020\u000bHÆ\u0003J\t\u0010j\u001a\u00020\bHÆ\u0003J\t\u0010k\u001a\u00020\u0014HÆ\u0003J\u0015\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000fHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010n\u001a\u00020\u000bHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010p\u001a\u00020\bHÆ\u0003J\u0015\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000fHÆ\u0003J\t\u0010r\u001a\u00020\bHÆ\u0003J\u0003\u0010s\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0\u000f2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0\u000f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\b2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u00142\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000fHÆ\u0001J\u0013\u0010t\u001a\u00020\u00192\b\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020\u001fHÖ\u0001J\t\u0010w\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b8\u00101R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b9\u00107R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b>\u00101R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b?\u00104R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bB\u00104R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bG\u00101R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0\u000f¢\u0006\b\n\u0000\u001a\u0004\bH\u00107R\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0\u000f¢\u0006\b\n\u0000\u001a\u0004\bI\u00107R\u0011\u0010!\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\"\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bL\u0010AR\u0011\u0010#\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bM\u0010AR\u0011\u0010$\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bN\u0010AR\u0011\u0010%\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bO\u00101R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010-R\u0011\u0010'\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bQ\u00101R\u0011\u0010(\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bR\u00104R\u0011\u0010)\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bS\u0010D¨\u0006x"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;", "", "attachments", "", "Lio/getstream/chat/android/client/api2/model/dto/AttachmentDto;", "channel", "Lio/getstream/chat/android/client/api2/model/dto/ChannelInfoDto;", "cid", "", "command", "created_at", "Ljava/util/Date;", "deleted_at", "html", "i18n", "", "id", "latest_reactions", "Lio/getstream/chat/android/client/api2/model/dto/ReactionDto;", "mentioned_users", "Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "own_reactions", "parent_id", "pin_expires", "pinned", "", "pinned_at", "pinned_by", "quoted_message", "quoted_message_id", "reaction_counts", "", "reaction_scores", "reply_count", "shadowed", "show_in_channel", "silent", "text", "thread_participants", "type", "updated_at", "user", "extraData", "(Ljava/util/List;Lio/getstream/chat/android/client/api2/model/dto/ChannelInfoDto;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;ZLjava/util/Date;Lio/getstream/chat/android/client/api2/model/dto/UserDto;Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;IZZZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/api2/model/dto/UserDto;Ljava/util/Map;)V", "getAttachments", "()Ljava/util/List;", "getChannel", "()Lio/getstream/chat/android/client/api2/model/dto/ChannelInfoDto;", "getCid", "()Ljava/lang/String;", "getCommand", "getCreated_at", "()Ljava/util/Date;", "getDeleted_at", "getExtraData", "()Ljava/util/Map;", "getHtml", "getI18n", "getId", "getLatest_reactions", "getMentioned_users", "getOwn_reactions", "getParent_id", "getPin_expires", "getPinned", "()Z", "getPinned_at", "getPinned_by", "()Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "getQuoted_message", "()Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;", "getQuoted_message_id", "getReaction_counts", "getReaction_scores", "getReply_count", "()I", "getShadowed", "getShow_in_channel", "getSilent", "getText", "getThread_participants", "getType", "getUpdated_at", "getUser", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto */
/* compiled from: DownstreamMessageDto.kt */
public final class DownstreamMessageDto {
    private final List<AttachmentDto> attachments;
    private final ChannelInfoDto channel;
    private final String cid;
    private final String command;
    private final Date created_at;
    private final Date deleted_at;
    private final Map<String, Object> extraData;
    private final String html;
    private final Map<String, String> i18n;

    /* renamed from: id */
    private final String f1449id;
    private final List<ReactionDto> latest_reactions;
    private final List<UserDto> mentioned_users;
    private final List<ReactionDto> own_reactions;
    private final String parent_id;
    private final Date pin_expires;
    private final boolean pinned;
    private final Date pinned_at;
    private final UserDto pinned_by;
    private final DownstreamMessageDto quoted_message;
    private final String quoted_message_id;
    private final Map<String, Integer> reaction_counts;
    private final Map<String, Integer> reaction_scores;
    private final int reply_count;
    private final boolean shadowed;
    private final boolean show_in_channel;
    private final boolean silent;
    private final String text;
    private final List<UserDto> thread_participants;
    private final String type;
    private final Date updated_at;
    private final UserDto user;

    public static /* synthetic */ DownstreamMessageDto copy$default(DownstreamMessageDto downstreamMessageDto, List list, ChannelInfoDto channelInfoDto, String str, String str2, Date date, Date date2, String str3, Map map, String str4, List list2, List list3, List list4, String str5, Date date3, boolean z, Date date4, UserDto userDto, DownstreamMessageDto downstreamMessageDto2, String str6, Map map2, Map map3, int i, boolean z2, boolean z3, boolean z4, String str7, List list5, String str8, Date date5, UserDto userDto2, Map map4, int i2, Object obj) {
        DownstreamMessageDto downstreamMessageDto3 = downstreamMessageDto;
        int i3 = i2;
        return downstreamMessageDto.copy((i3 & 1) != 0 ? downstreamMessageDto3.attachments : list, (i3 & 2) != 0 ? downstreamMessageDto3.channel : channelInfoDto, (i3 & 4) != 0 ? downstreamMessageDto3.cid : str, (i3 & 8) != 0 ? downstreamMessageDto3.command : str2, (i3 & 16) != 0 ? downstreamMessageDto3.created_at : date, (i3 & 32) != 0 ? downstreamMessageDto3.deleted_at : date2, (i3 & 64) != 0 ? downstreamMessageDto3.html : str3, (i3 & 128) != 0 ? downstreamMessageDto3.i18n : map, (i3 & 256) != 0 ? downstreamMessageDto3.f1449id : str4, (i3 & 512) != 0 ? downstreamMessageDto3.latest_reactions : list2, (i3 & 1024) != 0 ? downstreamMessageDto3.mentioned_users : list3, (i3 & 2048) != 0 ? downstreamMessageDto3.own_reactions : list4, (i3 & 4096) != 0 ? downstreamMessageDto3.parent_id : str5, (i3 & 8192) != 0 ? downstreamMessageDto3.pin_expires : date3, (i3 & 16384) != 0 ? downstreamMessageDto3.pinned : z, (i3 & 32768) != 0 ? downstreamMessageDto3.pinned_at : date4, (i3 & 65536) != 0 ? downstreamMessageDto3.pinned_by : userDto, (i3 & 131072) != 0 ? downstreamMessageDto3.quoted_message : downstreamMessageDto2, (i3 & 262144) != 0 ? downstreamMessageDto3.quoted_message_id : str6, (i3 & 524288) != 0 ? downstreamMessageDto3.reaction_counts : map2, (i3 & 1048576) != 0 ? downstreamMessageDto3.reaction_scores : map3, (i3 & 2097152) != 0 ? downstreamMessageDto3.reply_count : i, (i3 & 4194304) != 0 ? downstreamMessageDto3.shadowed : z2, (i3 & 8388608) != 0 ? downstreamMessageDto3.show_in_channel : z3, (i3 & 16777216) != 0 ? downstreamMessageDto3.silent : z4, (i3 & 33554432) != 0 ? downstreamMessageDto3.text : str7, (i3 & 67108864) != 0 ? downstreamMessageDto3.thread_participants : list5, (i3 & 134217728) != 0 ? downstreamMessageDto3.type : str8, (i3 & 268435456) != 0 ? downstreamMessageDto3.updated_at : date5, (i3 & 536870912) != 0 ? downstreamMessageDto3.user : userDto2, (i3 & 1073741824) != 0 ? downstreamMessageDto3.extraData : map4);
    }

    public final List<AttachmentDto> component1() {
        return this.attachments;
    }

    public final List<ReactionDto> component10() {
        return this.latest_reactions;
    }

    public final List<UserDto> component11() {
        return this.mentioned_users;
    }

    public final List<ReactionDto> component12() {
        return this.own_reactions;
    }

    public final String component13() {
        return this.parent_id;
    }

    public final Date component14() {
        return this.pin_expires;
    }

    public final boolean component15() {
        return this.pinned;
    }

    public final Date component16() {
        return this.pinned_at;
    }

    public final UserDto component17() {
        return this.pinned_by;
    }

    public final DownstreamMessageDto component18() {
        return this.quoted_message;
    }

    public final String component19() {
        return this.quoted_message_id;
    }

    public final ChannelInfoDto component2() {
        return this.channel;
    }

    public final Map<String, Integer> component20() {
        return this.reaction_counts;
    }

    public final Map<String, Integer> component21() {
        return this.reaction_scores;
    }

    public final int component22() {
        return this.reply_count;
    }

    public final boolean component23() {
        return this.shadowed;
    }

    public final boolean component24() {
        return this.show_in_channel;
    }

    public final boolean component25() {
        return this.silent;
    }

    public final String component26() {
        return this.text;
    }

    public final List<UserDto> component27() {
        return this.thread_participants;
    }

    public final String component28() {
        return this.type;
    }

    public final Date component29() {
        return this.updated_at;
    }

    public final String component3() {
        return this.cid;
    }

    public final UserDto component30() {
        return this.user;
    }

    public final Map<String, Object> component31() {
        return this.extraData;
    }

    public final String component4() {
        return this.command;
    }

    public final Date component5() {
        return this.created_at;
    }

    public final Date component6() {
        return this.deleted_at;
    }

    public final String component7() {
        return this.html;
    }

    public final Map<String, String> component8() {
        return this.i18n;
    }

    public final String component9() {
        return this.f1449id;
    }

    public final DownstreamMessageDto copy(List<AttachmentDto> list, ChannelInfoDto channelInfoDto, String str, String str2, Date date, Date date2, String str3, Map<String, String> map, String str4, List<ReactionDto> list2, List<UserDto> list3, List<ReactionDto> list4, String str5, Date date3, boolean z, Date date4, UserDto userDto, DownstreamMessageDto downstreamMessageDto, String str6, Map<String, Integer> map2, Map<String, Integer> map3, int i, boolean z2, boolean z3, boolean z4, String str7, List<UserDto> list5, String str8, Date date5, UserDto userDto2, Map<String, ? extends Object> map4) {
        List<AttachmentDto> list6 = list;
        Intrinsics.checkNotNullParameter(list6, "attachments");
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(date, "created_at");
        Intrinsics.checkNotNullParameter(str3, "html");
        Intrinsics.checkNotNullParameter(map, "i18n");
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(list2, "latest_reactions");
        Intrinsics.checkNotNullParameter(list3, "mentioned_users");
        Intrinsics.checkNotNullParameter(list4, "own_reactions");
        Intrinsics.checkNotNullParameter(map2, "reaction_counts");
        Intrinsics.checkNotNullParameter(map3, "reaction_scores");
        Intrinsics.checkNotNullParameter(str7, "text");
        Intrinsics.checkNotNullParameter(list5, "thread_participants");
        Intrinsics.checkNotNullParameter(str8, "type");
        Intrinsics.checkNotNullParameter(date5, "updated_at");
        Intrinsics.checkNotNullParameter(userDto2, "user");
        Intrinsics.checkNotNullParameter(map4, "extraData");
        return new DownstreamMessageDto(list6, channelInfoDto, str, str2, date, date2, str3, map, str4, list2, list3, list4, str5, date3, z, date4, userDto, downstreamMessageDto, str6, map2, map3, i, z2, z3, z4, str7, list5, str8, date5, userDto2, map4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownstreamMessageDto)) {
            return false;
        }
        DownstreamMessageDto downstreamMessageDto = (DownstreamMessageDto) obj;
        return Intrinsics.areEqual((Object) this.attachments, (Object) downstreamMessageDto.attachments) && Intrinsics.areEqual((Object) this.channel, (Object) downstreamMessageDto.channel) && Intrinsics.areEqual((Object) this.cid, (Object) downstreamMessageDto.cid) && Intrinsics.areEqual((Object) this.command, (Object) downstreamMessageDto.command) && Intrinsics.areEqual((Object) this.created_at, (Object) downstreamMessageDto.created_at) && Intrinsics.areEqual((Object) this.deleted_at, (Object) downstreamMessageDto.deleted_at) && Intrinsics.areEqual((Object) this.html, (Object) downstreamMessageDto.html) && Intrinsics.areEqual((Object) this.i18n, (Object) downstreamMessageDto.i18n) && Intrinsics.areEqual((Object) this.f1449id, (Object) downstreamMessageDto.f1449id) && Intrinsics.areEqual((Object) this.latest_reactions, (Object) downstreamMessageDto.latest_reactions) && Intrinsics.areEqual((Object) this.mentioned_users, (Object) downstreamMessageDto.mentioned_users) && Intrinsics.areEqual((Object) this.own_reactions, (Object) downstreamMessageDto.own_reactions) && Intrinsics.areEqual((Object) this.parent_id, (Object) downstreamMessageDto.parent_id) && Intrinsics.areEqual((Object) this.pin_expires, (Object) downstreamMessageDto.pin_expires) && this.pinned == downstreamMessageDto.pinned && Intrinsics.areEqual((Object) this.pinned_at, (Object) downstreamMessageDto.pinned_at) && Intrinsics.areEqual((Object) this.pinned_by, (Object) downstreamMessageDto.pinned_by) && Intrinsics.areEqual((Object) this.quoted_message, (Object) downstreamMessageDto.quoted_message) && Intrinsics.areEqual((Object) this.quoted_message_id, (Object) downstreamMessageDto.quoted_message_id) && Intrinsics.areEqual((Object) this.reaction_counts, (Object) downstreamMessageDto.reaction_counts) && Intrinsics.areEqual((Object) this.reaction_scores, (Object) downstreamMessageDto.reaction_scores) && this.reply_count == downstreamMessageDto.reply_count && this.shadowed == downstreamMessageDto.shadowed && this.show_in_channel == downstreamMessageDto.show_in_channel && this.silent == downstreamMessageDto.silent && Intrinsics.areEqual((Object) this.text, (Object) downstreamMessageDto.text) && Intrinsics.areEqual((Object) this.thread_participants, (Object) downstreamMessageDto.thread_participants) && Intrinsics.areEqual((Object) this.type, (Object) downstreamMessageDto.type) && Intrinsics.areEqual((Object) this.updated_at, (Object) downstreamMessageDto.updated_at) && Intrinsics.areEqual((Object) this.user, (Object) downstreamMessageDto.user) && Intrinsics.areEqual((Object) this.extraData, (Object) downstreamMessageDto.extraData);
    }

    public int hashCode() {
        List<AttachmentDto> list = this.attachments;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        ChannelInfoDto channelInfoDto = this.channel;
        int hashCode2 = (hashCode + (channelInfoDto != null ? channelInfoDto.hashCode() : 0)) * 31;
        String str = this.cid;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.command;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Date date = this.created_at;
        int hashCode5 = (hashCode4 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.deleted_at;
        int hashCode6 = (hashCode5 + (date2 != null ? date2.hashCode() : 0)) * 31;
        String str3 = this.html;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Map<String, String> map = this.i18n;
        int hashCode8 = (hashCode7 + (map != null ? map.hashCode() : 0)) * 31;
        String str4 = this.f1449id;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<ReactionDto> list2 = this.latest_reactions;
        int hashCode10 = (hashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<UserDto> list3 = this.mentioned_users;
        int hashCode11 = (hashCode10 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<ReactionDto> list4 = this.own_reactions;
        int hashCode12 = (hashCode11 + (list4 != null ? list4.hashCode() : 0)) * 31;
        String str5 = this.parent_id;
        int hashCode13 = (hashCode12 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Date date3 = this.pin_expires;
        int hashCode14 = (hashCode13 + (date3 != null ? date3.hashCode() : 0)) * 31;
        boolean z = this.pinned;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode14 + (z ? 1 : 0)) * 31;
        Date date4 = this.pinned_at;
        int hashCode15 = (i2 + (date4 != null ? date4.hashCode() : 0)) * 31;
        UserDto userDto = this.pinned_by;
        int hashCode16 = (hashCode15 + (userDto != null ? userDto.hashCode() : 0)) * 31;
        DownstreamMessageDto downstreamMessageDto = this.quoted_message;
        int hashCode17 = (hashCode16 + (downstreamMessageDto != null ? downstreamMessageDto.hashCode() : 0)) * 31;
        String str6 = this.quoted_message_id;
        int hashCode18 = (hashCode17 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Map<String, Integer> map2 = this.reaction_counts;
        int hashCode19 = (hashCode18 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, Integer> map3 = this.reaction_scores;
        int hashCode20 = (((hashCode19 + (map3 != null ? map3.hashCode() : 0)) * 31) + this.reply_count) * 31;
        boolean z3 = this.shadowed;
        if (z3) {
            z3 = true;
        }
        int i3 = (hashCode20 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.show_in_channel;
        if (z4) {
            z4 = true;
        }
        int i4 = (i3 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.silent;
        if (!z5) {
            z2 = z5;
        }
        int i5 = (i4 + (z2 ? 1 : 0)) * 31;
        String str7 = this.text;
        int hashCode21 = (i5 + (str7 != null ? str7.hashCode() : 0)) * 31;
        List<UserDto> list5 = this.thread_participants;
        int hashCode22 = (hashCode21 + (list5 != null ? list5.hashCode() : 0)) * 31;
        String str8 = this.type;
        int hashCode23 = (hashCode22 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Date date5 = this.updated_at;
        int hashCode24 = (hashCode23 + (date5 != null ? date5.hashCode() : 0)) * 31;
        UserDto userDto2 = this.user;
        int hashCode25 = (hashCode24 + (userDto2 != null ? userDto2.hashCode() : 0)) * 31;
        Map<String, Object> map4 = this.extraData;
        if (map4 != null) {
            i = map4.hashCode();
        }
        return hashCode25 + i;
    }

    public String toString() {
        return "DownstreamMessageDto(attachments=" + this.attachments + ", channel=" + this.channel + ", cid=" + this.cid + ", command=" + this.command + ", created_at=" + this.created_at + ", deleted_at=" + this.deleted_at + ", html=" + this.html + ", i18n=" + this.i18n + ", id=" + this.f1449id + ", latest_reactions=" + this.latest_reactions + ", mentioned_users=" + this.mentioned_users + ", own_reactions=" + this.own_reactions + ", parent_id=" + this.parent_id + ", pin_expires=" + this.pin_expires + ", pinned=" + this.pinned + ", pinned_at=" + this.pinned_at + ", pinned_by=" + this.pinned_by + ", quoted_message=" + this.quoted_message + ", quoted_message_id=" + this.quoted_message_id + ", reaction_counts=" + this.reaction_counts + ", reaction_scores=" + this.reaction_scores + ", reply_count=" + this.reply_count + ", shadowed=" + this.shadowed + ", show_in_channel=" + this.show_in_channel + ", silent=" + this.silent + ", text=" + this.text + ", thread_participants=" + this.thread_participants + ", type=" + this.type + ", updated_at=" + this.updated_at + ", user=" + this.user + ", extraData=" + this.extraData + ")";
    }

    public DownstreamMessageDto(List<AttachmentDto> list, ChannelInfoDto channelInfoDto, String str, String str2, Date date, Date date2, String str3, Map<String, String> map, String str4, List<ReactionDto> list2, List<UserDto> list3, List<ReactionDto> list4, String str5, Date date3, boolean z, Date date4, UserDto userDto, DownstreamMessageDto downstreamMessageDto, String str6, Map<String, Integer> map2, Map<String, Integer> map3, int i, boolean z2, boolean z3, boolean z4, String str7, List<UserDto> list5, String str8, Date date5, UserDto userDto2, Map<String, ? extends Object> map4) {
        List<AttachmentDto> list6 = list;
        String str9 = str;
        Date date6 = date;
        String str10 = str3;
        Map<String, String> map5 = map;
        String str11 = str4;
        List<ReactionDto> list7 = list2;
        List<UserDto> list8 = list3;
        List<ReactionDto> list9 = list4;
        Map<String, Integer> map6 = map2;
        Map<String, Integer> map7 = map3;
        String str12 = str7;
        List<UserDto> list10 = list5;
        String str13 = str8;
        UserDto userDto3 = userDto2;
        Intrinsics.checkNotNullParameter(list6, "attachments");
        Intrinsics.checkNotNullParameter(str9, "cid");
        Intrinsics.checkNotNullParameter(date6, "created_at");
        Intrinsics.checkNotNullParameter(str10, "html");
        Intrinsics.checkNotNullParameter(map5, "i18n");
        Intrinsics.checkNotNullParameter(str11, "id");
        Intrinsics.checkNotNullParameter(list7, "latest_reactions");
        Intrinsics.checkNotNullParameter(list8, "mentioned_users");
        Intrinsics.checkNotNullParameter(list9, "own_reactions");
        Intrinsics.checkNotNullParameter(map6, "reaction_counts");
        Intrinsics.checkNotNullParameter(map7, "reaction_scores");
        Intrinsics.checkNotNullParameter(str12, "text");
        Intrinsics.checkNotNullParameter(list10, "thread_participants");
        Intrinsics.checkNotNullParameter(str13, "type");
        Intrinsics.checkNotNullParameter(date5, "updated_at");
        Intrinsics.checkNotNullParameter(userDto2, "user");
        Intrinsics.checkNotNullParameter(map4, "extraData");
        this.attachments = list6;
        this.channel = channelInfoDto;
        this.cid = str9;
        this.command = str2;
        this.created_at = date6;
        this.deleted_at = date2;
        this.html = str10;
        this.i18n = map5;
        this.f1449id = str11;
        this.latest_reactions = list7;
        this.mentioned_users = list8;
        this.own_reactions = list9;
        this.parent_id = str5;
        this.pin_expires = date3;
        this.pinned = z;
        this.pinned_at = date4;
        this.pinned_by = userDto;
        this.quoted_message = downstreamMessageDto;
        this.quoted_message_id = str6;
        this.reaction_counts = map6;
        this.reaction_scores = map7;
        this.reply_count = i;
        this.shadowed = z2;
        this.show_in_channel = z3;
        this.silent = z4;
        this.text = str12;
        this.thread_participants = list10;
        this.type = str13;
        this.updated_at = date5;
        this.user = userDto2;
        this.extraData = map4;
    }

    public final List<AttachmentDto> getAttachments() {
        return this.attachments;
    }

    public final ChannelInfoDto getChannel() {
        return this.channel;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getCommand() {
        return this.command;
    }

    public final Date getCreated_at() {
        return this.created_at;
    }

    public final Date getDeleted_at() {
        return this.deleted_at;
    }

    public final String getHtml() {
        return this.html;
    }

    public final Map<String, String> getI18n() {
        return this.i18n;
    }

    public final String getId() {
        return this.f1449id;
    }

    public final List<ReactionDto> getLatest_reactions() {
        return this.latest_reactions;
    }

    public final List<UserDto> getMentioned_users() {
        return this.mentioned_users;
    }

    public final List<ReactionDto> getOwn_reactions() {
        return this.own_reactions;
    }

    public final String getParent_id() {
        return this.parent_id;
    }

    public final Date getPin_expires() {
        return this.pin_expires;
    }

    public final boolean getPinned() {
        return this.pinned;
    }

    public final Date getPinned_at() {
        return this.pinned_at;
    }

    public final UserDto getPinned_by() {
        return this.pinned_by;
    }

    public final DownstreamMessageDto getQuoted_message() {
        return this.quoted_message;
    }

    public final String getQuoted_message_id() {
        return this.quoted_message_id;
    }

    public final Map<String, Integer> getReaction_counts() {
        return this.reaction_counts;
    }

    public final Map<String, Integer> getReaction_scores() {
        return this.reaction_scores;
    }

    public final int getReply_count() {
        return this.reply_count;
    }

    public final boolean getShadowed() {
        return this.shadowed;
    }

    public final boolean getShow_in_channel() {
        return this.show_in_channel;
    }

    public final boolean getSilent() {
        return this.silent;
    }

    public final String getText() {
        return this.text;
    }

    public final List<UserDto> getThread_participants() {
        return this.thread_participants;
    }

    public final String getType() {
        return this.type;
    }

    public final Date getUpdated_at() {
        return this.updated_at;
    }

    public final UserDto getUser() {
        return this.user;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }
}
