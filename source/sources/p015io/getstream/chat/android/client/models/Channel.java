package p015io.getstream.chat.android.client.models;

import androidx.core.view.ViewCompat;
import com.getstream.sdk.chat.model.ModelType;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.CustomObject;
import p015io.getstream.chat.android.client.parser.IgnoreDeserialisation;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\bk\b\b\u0018\u00002\u00020\u0001B­\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010'J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0010HÆ\u0003J\t\u0010q\u001a\u00020\u0007HÆ\u0003J\u000f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u000f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013HÆ\u0003J\u000f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013HÆ\u0003J\u000f\u0010u\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013HÆ\u0003J\t\u0010v\u001a\u00020\u001cHÆ\u0003J\t\u0010w\u001a\u00020\u0018HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010dJ\t\u0010y\u001a\u00020\u0003HÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003J\u0015\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!HÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010EJ\u000b\u0010}\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010~\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0001\u001a\u00020\tHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J¸\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00032\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010%\u001a\u00020\u00072\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020\t2\t\u0010\u0001\u001a\u0004\u0018\u00010\"HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u0010%\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R \u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u00105R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010)\"\u0004\bL\u0010+R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00103\"\u0004\bN\u00105R\u0013\u0010O\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\bP\u00103R\u0016\u0010\u0011\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u00101R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010S\"\u0004\bW\u0010UR$\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010S\"\u0004\bY\u0010UR \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010S\"\u0004\b[\u0010UR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010)R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010)\"\u0004\bb\u0010+R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010g\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR \u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00103\"\u0004\bi\u00105R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u00101\"\u0004\bk\u0010lR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010S\"\u0004\bn\u0010U¨\u0006\u0001"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Channel;", "Lio/getstream/chat/android/client/models/CustomObject;", "cid", "", "id", "type", "watcherCount", "", "frozen", "", "lastMessageAt", "Ljava/util/Date;", "createdAt", "deletedAt", "updatedAt", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "memberCount", "messages", "", "Lio/getstream/chat/android/client/models/Message;", "members", "Lio/getstream/chat/android/client/models/Member;", "watchers", "Lio/getstream/chat/android/client/models/User;", "read", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "config", "Lio/getstream/chat/android/client/models/Config;", "createdBy", "unreadCount", "team", "extraData", "", "", "hidden", "hiddenMessagesBefore", "cooldown", "pinnedMessages", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lio/getstream/chat/android/client/utils/SyncStatus;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lio/getstream/chat/android/client/models/Config;Lio/getstream/chat/android/client/models/User;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Date;ILjava/util/List;)V", "getCid", "()Ljava/lang/String;", "setCid", "(Ljava/lang/String;)V", "getConfig", "()Lio/getstream/chat/android/client/models/Config;", "setConfig", "(Lio/getstream/chat/android/client/models/Config;)V", "getCooldown", "()I", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getCreatedBy", "()Lio/getstream/chat/android/client/models/User;", "setCreatedBy", "(Lio/getstream/chat/android/client/models/User;)V", "getDeletedAt", "setDeletedAt", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "getFrozen", "()Z", "setFrozen", "(Z)V", "getHidden", "()Ljava/lang/Boolean;", "setHidden", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHiddenMessagesBefore", "setHiddenMessagesBefore", "getId", "setId", "getLastMessageAt", "setLastMessageAt", "lastUpdated", "getLastUpdated", "getMemberCount", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "getMessages", "setMessages", "getPinnedMessages", "setPinnedMessages", "getRead", "setRead", "getSyncStatus", "()Lio/getstream/chat/android/client/utils/SyncStatus;", "setSyncStatus", "(Lio/getstream/chat/android/client/utils/SyncStatus;)V", "getTeam", "getType", "setType", "getUnreadCount", "()Ljava/lang/Integer;", "setUnreadCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUpdatedAt", "setUpdatedAt", "getWatcherCount", "setWatcherCount", "(I)V", "getWatchers", "setWatchers", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lio/getstream/chat/android/client/utils/SyncStatus;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lio/getstream/chat/android/client/models/Config;Lio/getstream/chat/android/client/models/User;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Date;ILjava/util/List;)Lio/getstream/chat/android/client/models/Channel;", "equals", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Channel */
/* compiled from: Channel.kt */
public final class Channel implements CustomObject {
    private String cid;
    private Config config;
    private final int cooldown;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("created_by")
    private User createdBy;
    @SerializedName("deleted_at")
    private Date deletedAt;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Map<String, Object> extraData;
    private boolean frozen;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Boolean hidden;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Date hiddenMessagesBefore;

    /* renamed from: id */
    private String f1456id;
    @SerializedName("last_message_at")
    private Date lastMessageAt;
    @SerializedName("member_count")
    private final int memberCount;
    private List<Member> members;
    private List<Message> messages;
    @SerializedName("pinned_messages")
    private List<Message> pinnedMessages;
    private List<ChannelUserRead> read;
    @IgnoreSerialisation
    private SyncStatus syncStatus;
    private final String team;
    private String type;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Integer unreadCount;
    @SerializedName("updated_at")
    private Date updatedAt;
    private int watcherCount;
    private List<User> watchers;

    public Channel() {
        this((String) null, (String) null, (String) null, 0, false, (Date) null, (Date) null, (Date) null, (Date) null, (SyncStatus) null, 0, (List) null, (List) null, (List) null, (List) null, (Config) null, (User) null, (Integer) null, (String) null, (Map) null, (Boolean) null, (Date) null, 0, (List) null, ViewCompat.MEASURED_SIZE_MASK, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, String str3, int i, boolean z, Date date, Date date2, Date date3, Date date4, SyncStatus syncStatus2, int i2, List list, List list2, List list3, List list4, Config config2, User user, Integer num, String str4, Map map, Boolean bool, Date date5, int i3, List list5, int i4, Object obj) {
        Channel channel2 = channel;
        int i5 = i4;
        return channel.copy((i5 & 1) != 0 ? channel2.cid : str, (i5 & 2) != 0 ? channel2.f1456id : str2, (i5 & 4) != 0 ? channel2.type : str3, (i5 & 8) != 0 ? channel2.watcherCount : i, (i5 & 16) != 0 ? channel2.frozen : z, (i5 & 32) != 0 ? channel2.lastMessageAt : date, (i5 & 64) != 0 ? channel2.createdAt : date2, (i5 & 128) != 0 ? channel2.deletedAt : date3, (i5 & 256) != 0 ? channel2.updatedAt : date4, (i5 & 512) != 0 ? channel2.syncStatus : syncStatus2, (i5 & 1024) != 0 ? channel2.memberCount : i2, (i5 & 2048) != 0 ? channel2.messages : list, (i5 & 4096) != 0 ? channel2.members : list2, (i5 & 8192) != 0 ? channel2.watchers : list3, (i5 & 16384) != 0 ? channel2.read : list4, (i5 & 32768) != 0 ? channel2.config : config2, (i5 & 65536) != 0 ? channel2.createdBy : user, (i5 & 131072) != 0 ? channel2.unreadCount : num, (i5 & 262144) != 0 ? channel2.team : str4, (i5 & 524288) != 0 ? channel.getExtraData() : map, (i5 & 1048576) != 0 ? channel2.hidden : bool, (i5 & 2097152) != 0 ? channel2.hiddenMessagesBefore : date5, (i5 & 4194304) != 0 ? channel2.cooldown : i3, (i5 & 8388608) != 0 ? channel2.pinnedMessages : list5);
    }

    public final String component1() {
        return this.cid;
    }

    public final SyncStatus component10() {
        return this.syncStatus;
    }

    public final int component11() {
        return this.memberCount;
    }

    public final List<Message> component12() {
        return this.messages;
    }

    public final List<Member> component13() {
        return this.members;
    }

    public final List<User> component14() {
        return this.watchers;
    }

    public final List<ChannelUserRead> component15() {
        return this.read;
    }

    public final Config component16() {
        return this.config;
    }

    public final User component17() {
        return this.createdBy;
    }

    public final Integer component18() {
        return this.unreadCount;
    }

    public final String component19() {
        return this.team;
    }

    public final String component2() {
        return this.f1456id;
    }

    public final Map<String, Object> component20() {
        return getExtraData();
    }

    public final Boolean component21() {
        return this.hidden;
    }

    public final Date component22() {
        return this.hiddenMessagesBefore;
    }

    public final int component23() {
        return this.cooldown;
    }

    public final List<Message> component24() {
        return this.pinnedMessages;
    }

    public final String component3() {
        return this.type;
    }

    public final int component4() {
        return this.watcherCount;
    }

    public final boolean component5() {
        return this.frozen;
    }

    public final Date component6() {
        return this.lastMessageAt;
    }

    public final Date component7() {
        return this.createdAt;
    }

    public final Date component8() {
        return this.deletedAt;
    }

    public final Date component9() {
        return this.updatedAt;
    }

    public final Channel copy(String str, String str2, String str3, int i, boolean z, Date date, Date date2, Date date3, Date date4, SyncStatus syncStatus2, int i2, List<Message> list, List<Member> list2, List<User> list3, List<ChannelUserRead> list4, Config config2, User user, Integer num, String str4, Map<String, Object> map, Boolean bool, Date date5, int i3, List<Message> list5) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "cid");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(syncStatus2, "syncStatus");
        Intrinsics.checkNotNullParameter(list, "messages");
        Intrinsics.checkNotNullParameter(list2, ModelFields.MEMBERS);
        Intrinsics.checkNotNullParameter(list3, "watchers");
        Intrinsics.checkNotNullParameter(list4, "read");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(user, "createdBy");
        Intrinsics.checkNotNullParameter(str4, ModelType.channel_team);
        Intrinsics.checkNotNullParameter(map, "extraData");
        Intrinsics.checkNotNullParameter(list5, "pinnedMessages");
        return new Channel(str5, str2, str3, i, z, date, date2, date3, date4, syncStatus2, i2, list, list2, list3, list4, config2, user, num, str4, map, bool, date5, i3, list5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return Intrinsics.areEqual((Object) this.cid, (Object) channel.cid) && Intrinsics.areEqual((Object) this.f1456id, (Object) channel.f1456id) && Intrinsics.areEqual((Object) this.type, (Object) channel.type) && this.watcherCount == channel.watcherCount && this.frozen == channel.frozen && Intrinsics.areEqual((Object) this.lastMessageAt, (Object) channel.lastMessageAt) && Intrinsics.areEqual((Object) this.createdAt, (Object) channel.createdAt) && Intrinsics.areEqual((Object) this.deletedAt, (Object) channel.deletedAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) channel.updatedAt) && Intrinsics.areEqual((Object) this.syncStatus, (Object) channel.syncStatus) && this.memberCount == channel.memberCount && Intrinsics.areEqual((Object) this.messages, (Object) channel.messages) && Intrinsics.areEqual((Object) this.members, (Object) channel.members) && Intrinsics.areEqual((Object) this.watchers, (Object) channel.watchers) && Intrinsics.areEqual((Object) this.read, (Object) channel.read) && Intrinsics.areEqual((Object) this.config, (Object) channel.config) && Intrinsics.areEqual((Object) this.createdBy, (Object) channel.createdBy) && Intrinsics.areEqual((Object) this.unreadCount, (Object) channel.unreadCount) && Intrinsics.areEqual((Object) this.team, (Object) channel.team) && Intrinsics.areEqual((Object) getExtraData(), (Object) channel.getExtraData()) && Intrinsics.areEqual((Object) this.hidden, (Object) channel.hidden) && Intrinsics.areEqual((Object) this.hiddenMessagesBefore, (Object) channel.hiddenMessagesBefore) && this.cooldown == channel.cooldown && Intrinsics.areEqual((Object) this.pinnedMessages, (Object) channel.pinnedMessages);
    }

    public int hashCode() {
        String str = this.cid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1456id;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.watcherCount) * 31;
        boolean z = this.frozen;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        Date date = this.lastMessageAt;
        int hashCode4 = (i2 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.createdAt;
        int hashCode5 = (hashCode4 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.deletedAt;
        int hashCode6 = (hashCode5 + (date3 != null ? date3.hashCode() : 0)) * 31;
        Date date4 = this.updatedAt;
        int hashCode7 = (hashCode6 + (date4 != null ? date4.hashCode() : 0)) * 31;
        SyncStatus syncStatus2 = this.syncStatus;
        int hashCode8 = (((hashCode7 + (syncStatus2 != null ? syncStatus2.hashCode() : 0)) * 31) + this.memberCount) * 31;
        List<Message> list = this.messages;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        List<Member> list2 = this.members;
        int hashCode10 = (hashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<User> list3 = this.watchers;
        int hashCode11 = (hashCode10 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<ChannelUserRead> list4 = this.read;
        int hashCode12 = (hashCode11 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Config config2 = this.config;
        int hashCode13 = (hashCode12 + (config2 != null ? config2.hashCode() : 0)) * 31;
        User user = this.createdBy;
        int hashCode14 = (hashCode13 + (user != null ? user.hashCode() : 0)) * 31;
        Integer num = this.unreadCount;
        int hashCode15 = (hashCode14 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.team;
        int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Map<String, Object> extraData2 = getExtraData();
        int hashCode17 = (hashCode16 + (extraData2 != null ? extraData2.hashCode() : 0)) * 31;
        Boolean bool = this.hidden;
        int hashCode18 = (hashCode17 + (bool != null ? bool.hashCode() : 0)) * 31;
        Date date5 = this.hiddenMessagesBefore;
        int hashCode19 = (((hashCode18 + (date5 != null ? date5.hashCode() : 0)) * 31) + this.cooldown) * 31;
        List<Message> list5 = this.pinnedMessages;
        if (list5 != null) {
            i = list5.hashCode();
        }
        return hashCode19 + i;
    }

    public String toString() {
        return "Channel(cid=" + this.cid + ", id=" + this.f1456id + ", type=" + this.type + ", watcherCount=" + this.watcherCount + ", frozen=" + this.frozen + ", lastMessageAt=" + this.lastMessageAt + ", createdAt=" + this.createdAt + ", deletedAt=" + this.deletedAt + ", updatedAt=" + this.updatedAt + ", syncStatus=" + this.syncStatus + ", memberCount=" + this.memberCount + ", messages=" + this.messages + ", members=" + this.members + ", watchers=" + this.watchers + ", read=" + this.read + ", config=" + this.config + ", createdBy=" + this.createdBy + ", unreadCount=" + this.unreadCount + ", team=" + this.team + ", extraData=" + getExtraData() + ", hidden=" + this.hidden + ", hiddenMessagesBefore=" + this.hiddenMessagesBefore + ", cooldown=" + this.cooldown + ", pinnedMessages=" + this.pinnedMessages + ")";
    }

    public Channel(String str, String str2, String str3, int i, boolean z, Date date, Date date2, Date date3, Date date4, SyncStatus syncStatus2, int i2, List<Message> list, List<Member> list2, List<User> list3, List<ChannelUserRead> list4, Config config2, User user, Integer num, String str4, Map<String, Object> map, Boolean bool, Date date5, int i3, List<Message> list5) {
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        SyncStatus syncStatus3 = syncStatus2;
        List<Message> list6 = list;
        List<Member> list7 = list2;
        List<User> list8 = list3;
        List<ChannelUserRead> list9 = list4;
        Config config3 = config2;
        User user2 = user;
        String str8 = str4;
        Map<String, Object> map2 = map;
        List<Message> list10 = list5;
        Intrinsics.checkNotNullParameter(str5, "cid");
        Intrinsics.checkNotNullParameter(str6, "id");
        Intrinsics.checkNotNullParameter(str7, "type");
        Intrinsics.checkNotNullParameter(syncStatus3, "syncStatus");
        Intrinsics.checkNotNullParameter(list6, "messages");
        Intrinsics.checkNotNullParameter(list7, ModelFields.MEMBERS);
        Intrinsics.checkNotNullParameter(list8, "watchers");
        Intrinsics.checkNotNullParameter(list9, "read");
        Intrinsics.checkNotNullParameter(config3, "config");
        Intrinsics.checkNotNullParameter(user2, "createdBy");
        Intrinsics.checkNotNullParameter(str8, ModelType.channel_team);
        Intrinsics.checkNotNullParameter(map2, "extraData");
        Intrinsics.checkNotNullParameter(list10, "pinnedMessages");
        this.cid = str5;
        this.f1456id = str6;
        this.type = str7;
        this.watcherCount = i;
        this.frozen = z;
        this.lastMessageAt = date;
        this.createdAt = date2;
        this.deletedAt = date3;
        this.updatedAt = date4;
        this.syncStatus = syncStatus3;
        this.memberCount = i2;
        this.messages = list6;
        this.members = list7;
        this.watchers = list8;
        this.read = list9;
        this.config = config3;
        this.createdBy = user2;
        this.unreadCount = num;
        this.team = str8;
        this.extraData = map2;
        this.hidden = bool;
        this.hiddenMessagesBefore = date5;
        this.cooldown = i3;
        this.pinnedMessages = list10;
    }

    public <T> T getExtraValue(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        return CustomObject.DefaultImpls.getExtraValue(this, str, t);
    }

    public void putExtraValue(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        CustomObject.DefaultImpls.putExtraValue(this, str, obj);
    }

    public final String getCid() {
        return this.cid;
    }

    public final void setCid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cid = str;
    }

    public final String getId() {
        return this.f1456id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1456id = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final int getWatcherCount() {
        return this.watcherCount;
    }

    public final void setWatcherCount(int i) {
        this.watcherCount = i;
    }

    public final boolean getFrozen() {
        return this.frozen;
    }

    public final void setFrozen(boolean z) {
        this.frozen = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Channel(java.lang.String r38, java.lang.String r39, java.lang.String r40, int r41, boolean r42, java.util.Date r43, java.util.Date r44, java.util.Date r45, java.util.Date r46, p015io.getstream.chat.android.client.utils.SyncStatus r47, int r48, java.util.List r49, java.util.List r50, java.util.List r51, java.util.List r52, p015io.getstream.chat.android.client.models.Config r53, p015io.getstream.chat.android.client.models.User r54, java.lang.Integer r55, java.lang.String r56, java.util.Map r57, java.lang.Boolean r58, java.util.Date r59, int r60, java.util.List r61, int r62, kotlin.jvm.internal.DefaultConstructorMarker r63) {
        /*
            r37 = this;
            r0 = r62
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r38
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r39
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r40
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r41
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r42
        L_0x002c:
            r8 = r0 & 32
            r9 = 0
            if (r8 == 0) goto L_0x0035
            r8 = r9
            java.util.Date r8 = (java.util.Date) r8
            goto L_0x0037
        L_0x0035:
            r8 = r43
        L_0x0037:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003f
            r10 = r9
            java.util.Date r10 = (java.util.Date) r10
            goto L_0x0041
        L_0x003f:
            r10 = r44
        L_0x0041:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0049
            r11 = r9
            java.util.Date r11 = (java.util.Date) r11
            goto L_0x004b
        L_0x0049:
            r11 = r45
        L_0x004b:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0053
            r12 = r9
            java.util.Date r12 = (java.util.Date) r12
            goto L_0x0055
        L_0x0053:
            r12 = r46
        L_0x0055:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x005c
            io.getstream.chat.android.client.utils.SyncStatus r13 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            goto L_0x005e
        L_0x005c:
            r13 = r47
        L_0x005e:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0064
            r14 = 0
            goto L_0x0066
        L_0x0064:
            r14 = r48
        L_0x0066:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0072
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.List r15 = (java.util.List) r15
            goto L_0x0074
        L_0x0072:
            r15 = r49
        L_0x0074:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0080
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            goto L_0x0082
        L_0x0080:
            r6 = r50
        L_0x0082:
            r9 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x008e
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r9 = (java.util.List) r9
            goto L_0x0090
        L_0x008e:
            r9 = r51
        L_0x0090:
            r63 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x009e
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            goto L_0x00a0
        L_0x009e:
            r2 = r52
        L_0x00a0:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00cf
            io.getstream.chat.android.client.models.Config r16 = new io.getstream.chat.android.client.models.Config
            r17 = r16
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 16383(0x3fff, float:2.2957E-41)
            r33 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            goto L_0x00d1
        L_0x00cf:
            r16 = r53
        L_0x00d1:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0104
            io.getstream.chat.android.client.models.User r17 = new io.getstream.chat.android.client.models.User
            r18 = r17
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 65535(0xffff, float:9.1834E-41)
            r36 = 0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            goto L_0x0106
        L_0x0104:
            r17 = r54
        L_0x0106:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x0113
            r18 = 0
            r19 = r18
            java.lang.Integer r19 = (java.lang.Integer) r19
            goto L_0x0115
        L_0x0113:
            r19 = r55
        L_0x0115:
            r18 = 262144(0x40000, float:3.67342E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x011e
            r18 = r63
            goto L_0x0120
        L_0x011e:
            r18 = r56
        L_0x0120:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x012e
            java.util.LinkedHashMap r20 = new java.util.LinkedHashMap
            r20.<init>()
            java.util.Map r20 = (java.util.Map) r20
            goto L_0x0130
        L_0x012e:
            r20 = r57
        L_0x0130:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x013d
            r21 = 0
            r22 = r21
            java.lang.Boolean r22 = (java.lang.Boolean) r22
            goto L_0x0141
        L_0x013d:
            r21 = 0
            r22 = r58
        L_0x0141:
            r23 = 2097152(0x200000, float:2.938736E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x014a
            java.util.Date r21 = (java.util.Date) r21
            goto L_0x014c
        L_0x014a:
            r21 = r59
        L_0x014c:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x0155
            r23 = 0
            goto L_0x0157
        L_0x0155:
            r23 = r60
        L_0x0157:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r24
            if (r0 == 0) goto L_0x0165
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            goto L_0x0167
        L_0x0165:
            r0 = r61
        L_0x0167:
            r38 = r37
            r39 = r1
            r40 = r3
            r41 = r4
            r42 = r5
            r43 = r7
            r44 = r8
            r45 = r10
            r46 = r11
            r47 = r12
            r48 = r13
            r49 = r14
            r50 = r15
            r51 = r6
            r52 = r9
            r53 = r2
            r54 = r16
            r55 = r17
            r56 = r19
            r57 = r18
            r58 = r20
            r59 = r22
            r60 = r21
            r61 = r23
            r62 = r0
            r38.<init>(r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.Channel.<init>(java.lang.String, java.lang.String, java.lang.String, int, boolean, java.util.Date, java.util.Date, java.util.Date, java.util.Date, io.getstream.chat.android.client.utils.SyncStatus, int, java.util.List, java.util.List, java.util.List, java.util.List, io.getstream.chat.android.client.models.Config, io.getstream.chat.android.client.models.User, java.lang.Integer, java.lang.String, java.util.Map, java.lang.Boolean, java.util.Date, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Date getLastMessageAt() {
        return this.lastMessageAt;
    }

    public final void setLastMessageAt(Date date) {
        this.lastMessageAt = date;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public final Date getDeletedAt() {
        return this.deletedAt;
    }

    public final void setDeletedAt(Date date) {
        this.deletedAt = date;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public final SyncStatus getSyncStatus() {
        return this.syncStatus;
    }

    public final void setSyncStatus(SyncStatus syncStatus2) {
        Intrinsics.checkNotNullParameter(syncStatus2, "<set-?>");
        this.syncStatus = syncStatus2;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final void setMessages(List<Message> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.messages = list;
    }

    public final List<Member> getMembers() {
        return this.members;
    }

    public final void setMembers(List<Member> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.members = list;
    }

    public final List<User> getWatchers() {
        return this.watchers;
    }

    public final void setWatchers(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.watchers = list;
    }

    public final List<ChannelUserRead> getRead() {
        return this.read;
    }

    public final void setRead(List<ChannelUserRead> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.read = list;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final void setConfig(Config config2) {
        Intrinsics.checkNotNullParameter(config2, "<set-?>");
        this.config = config2;
    }

    public final User getCreatedBy() {
        return this.createdBy;
    }

    public final void setCreatedBy(User user) {
        Intrinsics.checkNotNullParameter(user, "<set-?>");
        this.createdBy = user;
    }

    public final Integer getUnreadCount() {
        return this.unreadCount;
    }

    public final void setUnreadCount(Integer num) {
        this.unreadCount = num;
    }

    public final String getTeam() {
        return this.team;
    }

    public Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public void setExtraData(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraData = map;
    }

    public final Boolean getHidden() {
        return this.hidden;
    }

    public final void setHidden(Boolean bool) {
        this.hidden = bool;
    }

    public final Date getHiddenMessagesBefore() {
        return this.hiddenMessagesBefore;
    }

    public final void setHiddenMessagesBefore(Date date) {
        this.hiddenMessagesBefore = date;
    }

    public final int getCooldown() {
        return this.cooldown;
    }

    public final List<Message> getPinnedMessages() {
        return this.pinnedMessages;
    }

    public final void setPinnedMessages(List<Message> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.pinnedMessages = list;
    }

    public final Date getLastUpdated() {
        Date date = this.lastMessageAt;
        if (date != null) {
            Date date2 = this.createdAt;
            if (!(date2 == null || date.after(date2))) {
                date = null;
            }
            if (date != null) {
                return date;
            }
        }
        return this.createdAt;
    }
}
