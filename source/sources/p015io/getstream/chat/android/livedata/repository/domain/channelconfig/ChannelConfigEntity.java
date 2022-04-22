package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigEntity;", "", "channelConfigInnerEntity", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigInnerEntity;", "commands", "", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/CommandInnerEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigInnerEntity;Ljava/util/List;)V", "getChannelConfigInnerEntity", "()Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigInnerEntity;", "getCommands", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity */
/* compiled from: ChannelConfigEntity.kt */
public final class ChannelConfigEntity {
    private final ChannelConfigInnerEntity channelConfigInnerEntity;
    private final List<CommandInnerEntity> commands;

    public static /* synthetic */ ChannelConfigEntity copy$default(ChannelConfigEntity channelConfigEntity, ChannelConfigInnerEntity channelConfigInnerEntity2, List<CommandInnerEntity> list, int i, Object obj) {
        if ((i & 1) != 0) {
            channelConfigInnerEntity2 = channelConfigEntity.channelConfigInnerEntity;
        }
        if ((i & 2) != 0) {
            list = channelConfigEntity.commands;
        }
        return channelConfigEntity.copy(channelConfigInnerEntity2, list);
    }

    public final ChannelConfigInnerEntity component1() {
        return this.channelConfigInnerEntity;
    }

    public final List<CommandInnerEntity> component2() {
        return this.commands;
    }

    public final ChannelConfigEntity copy(ChannelConfigInnerEntity channelConfigInnerEntity2, List<CommandInnerEntity> list) {
        Intrinsics.checkNotNullParameter(channelConfigInnerEntity2, "channelConfigInnerEntity");
        Intrinsics.checkNotNullParameter(list, "commands");
        return new ChannelConfigEntity(channelConfigInnerEntity2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelConfigEntity)) {
            return false;
        }
        ChannelConfigEntity channelConfigEntity = (ChannelConfigEntity) obj;
        return Intrinsics.areEqual((Object) this.channelConfigInnerEntity, (Object) channelConfigEntity.channelConfigInnerEntity) && Intrinsics.areEqual((Object) this.commands, (Object) channelConfigEntity.commands);
    }

    public int hashCode() {
        ChannelConfigInnerEntity channelConfigInnerEntity2 = this.channelConfigInnerEntity;
        int i = 0;
        int hashCode = (channelConfigInnerEntity2 != null ? channelConfigInnerEntity2.hashCode() : 0) * 31;
        List<CommandInnerEntity> list = this.commands;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChannelConfigEntity(channelConfigInnerEntity=" + this.channelConfigInnerEntity + ", commands=" + this.commands + ")";
    }

    public ChannelConfigEntity(ChannelConfigInnerEntity channelConfigInnerEntity2, List<CommandInnerEntity> list) {
        Intrinsics.checkNotNullParameter(channelConfigInnerEntity2, "channelConfigInnerEntity");
        Intrinsics.checkNotNullParameter(list, "commands");
        this.channelConfigInnerEntity = channelConfigInnerEntity2;
        this.commands = list;
    }

    public final ChannelConfigInnerEntity getChannelConfigInnerEntity() {
        return this.channelConfigInnerEntity;
    }

    public final List<CommandInnerEntity> getCommands() {
        return this.commands;
    }
}
