package p015io.getstream.chat.android.client.events;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ReactionUpdateEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "user", "Lio/getstream/chat/android/client/models/User;", "cid", "channelType", "channelId", "message", "Lio/getstream/chat/android/client/models/Message;", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/Message;Lio/getstream/chat/android/client/models/Reaction;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "getReaction", "()Lio/getstream/chat/android/client/models/Reaction;", "getType", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ReactionUpdateEvent */
/* compiled from: ChatEvent.kt */
public final class ReactionUpdateEvent extends CidEvent implements UserEvent {
    @SerializedName("channel_id")
    private final String channelId;
    @SerializedName("channel_type")
    private final String channelType;
    private final String cid;
    @SerializedName("created_at")
    private final Date createdAt;
    private final Message message;
    private final Reaction reaction;
    private final String type;
    private final User user;

    public static /* synthetic */ ReactionUpdateEvent copy$default(ReactionUpdateEvent reactionUpdateEvent, String str, Date date, User user2, String str2, String str3, String str4, Message message2, Reaction reaction2, int i, Object obj) {
        ReactionUpdateEvent reactionUpdateEvent2 = reactionUpdateEvent;
        int i2 = i;
        return reactionUpdateEvent.copy((i2 & 1) != 0 ? reactionUpdateEvent.getType() : str, (i2 & 2) != 0 ? reactionUpdateEvent.getCreatedAt() : date, (i2 & 4) != 0 ? reactionUpdateEvent.getUser() : user2, (i2 & 8) != 0 ? reactionUpdateEvent.getCid() : str2, (i2 & 16) != 0 ? reactionUpdateEvent2.channelType : str3, (i2 & 32) != 0 ? reactionUpdateEvent2.channelId : str4, (i2 & 64) != 0 ? reactionUpdateEvent2.message : message2, (i2 & 128) != 0 ? reactionUpdateEvent2.reaction : reaction2);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final User component3() {
        return getUser();
    }

    public final String component4() {
        return getCid();
    }

    public final String component5() {
        return this.channelType;
    }

    public final String component6() {
        return this.channelId;
    }

    public final Message component7() {
        return this.message;
    }

    public final Reaction component8() {
        return this.reaction;
    }

    public final ReactionUpdateEvent copy(String str, Date date, User user2, String str2, String str3, String str4, Message message2, Reaction reaction2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "channelId");
        Message message3 = message2;
        Intrinsics.checkNotNullParameter(message3, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Reaction reaction3 = reaction2;
        Intrinsics.checkNotNullParameter(reaction3, "reaction");
        return new ReactionUpdateEvent(str, date, user2, str2, str3, str5, message3, reaction3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactionUpdateEvent)) {
            return false;
        }
        ReactionUpdateEvent reactionUpdateEvent = (ReactionUpdateEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) reactionUpdateEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) reactionUpdateEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getUser(), (Object) reactionUpdateEvent.getUser()) && Intrinsics.areEqual((Object) getCid(), (Object) reactionUpdateEvent.getCid()) && Intrinsics.areEqual((Object) this.channelType, (Object) reactionUpdateEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) reactionUpdateEvent.channelId) && Intrinsics.areEqual((Object) this.message, (Object) reactionUpdateEvent.message) && Intrinsics.areEqual((Object) this.reaction, (Object) reactionUpdateEvent.reaction);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        User user2 = getUser();
        int hashCode3 = (hashCode2 + (user2 != null ? user2.hashCode() : 0)) * 31;
        String cid2 = getCid();
        int hashCode4 = (hashCode3 + (cid2 != null ? cid2.hashCode() : 0)) * 31;
        String str = this.channelType;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channelId;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Message message2 = this.message;
        int hashCode7 = (hashCode6 + (message2 != null ? message2.hashCode() : 0)) * 31;
        Reaction reaction2 = this.reaction;
        if (reaction2 != null) {
            i = reaction2.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "ReactionUpdateEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", user=" + getUser() + ", cid=" + getCid() + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", message=" + this.message + ", reaction=" + this.reaction + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public User getUser() {
        return this.user;
    }

    public String getCid() {
        return this.cid;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final Reaction getReaction() {
        return this.reaction;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactionUpdateEvent(String str, Date date, User user2, String str2, String str3, String str4, Message message2, Reaction reaction2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(reaction2, "reaction");
        this.type = str;
        this.createdAt = date;
        this.user = user2;
        this.cid = str2;
        this.channelType = str3;
        this.channelId = str4;
        this.message = message2;
        this.reaction = reaction2;
    }
}
