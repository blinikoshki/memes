package com.memes.chat.p035db.mutedchannels;

import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelMute;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/chat/db/mutedchannels/MutedChannelEntity;", "", "cid", "", "id", "type", "name", "image", "mutedBy", "mutedAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V", "getCid", "()Ljava/lang/String;", "getId", "getImage", "getMutedAt", "()Ljava/util/Date;", "getMutedBy", "getName", "getType", "toChannelMute", "Lio/getstream/chat/android/client/models/ChannelMute;", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.db.mutedchannels.MutedChannelEntity */
/* compiled from: MutedChannelEntity.kt */
public final class MutedChannelEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String cid;

    /* renamed from: id */
    private final String f935id;
    private final String image;
    private final Date mutedAt;
    private final String mutedBy;
    private final String name;
    private final String type;

    public MutedChannelEntity(String str, String str2, String str3, String str4, String str5, String str6, Date date) {
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "image");
        Intrinsics.checkNotNullParameter(str6, "mutedBy");
        Intrinsics.checkNotNullParameter(date, "mutedAt");
        this.cid = str;
        this.f935id = str2;
        this.type = str3;
        this.name = str4;
        this.image = str5;
        this.mutedBy = str6;
        this.mutedAt = date;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getId() {
        return this.f935id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getMutedBy() {
        return this.mutedBy;
    }

    public final Date getMutedAt() {
        return this.mutedAt;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/db/mutedchannels/MutedChannelEntity$Companion;", "", "()V", "from", "Lcom/memes/chat/db/mutedchannels/MutedChannelEntity;", "mute", "Lio/getstream/chat/android/client/models/ChannelMute;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.db.mutedchannels.MutedChannelEntity$Companion */
    /* compiled from: MutedChannelEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MutedChannelEntity from(ChannelMute channelMute) {
            Intrinsics.checkNotNullParameter(channelMute, "mute");
            return new MutedChannelEntity(channelMute.getChannel().getCid(), channelMute.getChannel().getId(), channelMute.getChannel().getType(), ContentUtils.getName(channelMute.getChannel()), ContentUtils.getImage(channelMute.getChannel()), channelMute.getUser().getId(), channelMute.getCreatedAt());
        }
    }

    public final ChannelMute toChannelMute() {
        User user = r1;
        User user2 = new User(this.mutedBy, (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65534, (DefaultConstructorMarker) null);
        Channel channel = new Channel(this.cid, this.f935id, this.type, 0, false, (Date) null, (Date) null, (Date) null, (Date) null, (SyncStatus) null, 0, (List) null, (List) null, (List) null, (List) null, (Config) null, (User) null, (Integer) null, (String) null, (Map) null, (Boolean) null, (Date) null, 0, (List) null, 16777208, (DefaultConstructorMarker) null);
        channel.getExtraData().put("name", this.name);
        channel.getExtraData().put("image", this.image);
        Unit unit = Unit.INSTANCE;
        return new ChannelMute(user, channel, this.mutedAt);
    }
}
