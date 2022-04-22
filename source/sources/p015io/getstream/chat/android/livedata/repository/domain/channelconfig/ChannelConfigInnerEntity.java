package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b#\b\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0010HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0010HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001bR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001bR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u00063"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigInnerEntity;", "", "channelType", "", "createdAt", "Ljava/util/Date;", "updatedAt", "isTypingEvents", "", "isReadEvents", "isConnectEvents", "isSearch", "isReactionsEnabled", "isRepliesEnabled", "isMutes", "maxMessageLength", "", "automod", "infinite", "name", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;ZZZZZZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAutomod", "()Ljava/lang/String;", "getChannelType", "getCreatedAt", "()Ljava/util/Date;", "getInfinite", "()Z", "getMaxMessageLength", "()I", "getName", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigInnerEntity */
/* compiled from: ChannelConfigEntity.kt */
public final class ChannelConfigInnerEntity {
    private final String automod;
    private final String channelType;
    private final Date createdAt;
    private final String infinite;
    private final boolean isConnectEvents;
    private final boolean isMutes;
    private final boolean isReactionsEnabled;
    private final boolean isReadEvents;
    private final boolean isRepliesEnabled;
    private final boolean isSearch;
    private final boolean isTypingEvents;
    private final int maxMessageLength;
    private final String name;
    private final Date updatedAt;

    public static /* synthetic */ ChannelConfigInnerEntity copy$default(ChannelConfigInnerEntity channelConfigInnerEntity, String str, Date date, Date date2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, String str2, String str3, String str4, int i2, Object obj) {
        ChannelConfigInnerEntity channelConfigInnerEntity2 = channelConfigInnerEntity;
        int i3 = i2;
        return channelConfigInnerEntity.copy((i3 & 1) != 0 ? channelConfigInnerEntity2.channelType : str, (i3 & 2) != 0 ? channelConfigInnerEntity2.createdAt : date, (i3 & 4) != 0 ? channelConfigInnerEntity2.updatedAt : date2, (i3 & 8) != 0 ? channelConfigInnerEntity2.isTypingEvents : z, (i3 & 16) != 0 ? channelConfigInnerEntity2.isReadEvents : z2, (i3 & 32) != 0 ? channelConfigInnerEntity2.isConnectEvents : z3, (i3 & 64) != 0 ? channelConfigInnerEntity2.isSearch : z4, (i3 & 128) != 0 ? channelConfigInnerEntity2.isReactionsEnabled : z5, (i3 & 256) != 0 ? channelConfigInnerEntity2.isRepliesEnabled : z6, (i3 & 512) != 0 ? channelConfigInnerEntity2.isMutes : z7, (i3 & 1024) != 0 ? channelConfigInnerEntity2.maxMessageLength : i, (i3 & 2048) != 0 ? channelConfigInnerEntity2.automod : str2, (i3 & 4096) != 0 ? channelConfigInnerEntity2.infinite : str3, (i3 & 8192) != 0 ? channelConfigInnerEntity2.name : str4);
    }

    public final String component1() {
        return this.channelType;
    }

    public final boolean component10() {
        return this.isMutes;
    }

    public final int component11() {
        return this.maxMessageLength;
    }

    public final String component12() {
        return this.automod;
    }

    public final String component13() {
        return this.infinite;
    }

    public final String component14() {
        return this.name;
    }

    public final Date component2() {
        return this.createdAt;
    }

    public final Date component3() {
        return this.updatedAt;
    }

    public final boolean component4() {
        return this.isTypingEvents;
    }

    public final boolean component5() {
        return this.isReadEvents;
    }

    public final boolean component6() {
        return this.isConnectEvents;
    }

    public final boolean component7() {
        return this.isSearch;
    }

    public final boolean component8() {
        return this.isReactionsEnabled;
    }

    public final boolean component9() {
        return this.isRepliesEnabled;
    }

    public final ChannelConfigInnerEntity copy(String str, Date date, Date date2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, String str2, String str3, String str4) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "channelType");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, "automod");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "infinite");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "name");
        return new ChannelConfigInnerEntity(str5, date, date2, z, z2, z3, z4, z5, z6, z7, i, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelConfigInnerEntity)) {
            return false;
        }
        ChannelConfigInnerEntity channelConfigInnerEntity = (ChannelConfigInnerEntity) obj;
        return Intrinsics.areEqual((Object) this.channelType, (Object) channelConfigInnerEntity.channelType) && Intrinsics.areEqual((Object) this.createdAt, (Object) channelConfigInnerEntity.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) channelConfigInnerEntity.updatedAt) && this.isTypingEvents == channelConfigInnerEntity.isTypingEvents && this.isReadEvents == channelConfigInnerEntity.isReadEvents && this.isConnectEvents == channelConfigInnerEntity.isConnectEvents && this.isSearch == channelConfigInnerEntity.isSearch && this.isReactionsEnabled == channelConfigInnerEntity.isReactionsEnabled && this.isRepliesEnabled == channelConfigInnerEntity.isRepliesEnabled && this.isMutes == channelConfigInnerEntity.isMutes && this.maxMessageLength == channelConfigInnerEntity.maxMessageLength && Intrinsics.areEqual((Object) this.automod, (Object) channelConfigInnerEntity.automod) && Intrinsics.areEqual((Object) this.infinite, (Object) channelConfigInnerEntity.infinite) && Intrinsics.areEqual((Object) this.name, (Object) channelConfigInnerEntity.name);
    }

    public int hashCode() {
        String str = this.channelType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Date date = this.createdAt;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode3 = (hashCode2 + (date2 != null ? date2.hashCode() : 0)) * 31;
        boolean z = this.isTypingEvents;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z3 = this.isReadEvents;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isConnectEvents;
        if (z4) {
            z4 = true;
        }
        int i4 = (i3 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.isSearch;
        if (z5) {
            z5 = true;
        }
        int i5 = (i4 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.isReactionsEnabled;
        if (z6) {
            z6 = true;
        }
        int i6 = (i5 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.isRepliesEnabled;
        if (z7) {
            z7 = true;
        }
        int i7 = (i6 + (z7 ? 1 : 0)) * 31;
        boolean z8 = this.isMutes;
        if (!z8) {
            z2 = z8;
        }
        int i8 = (((i7 + (z2 ? 1 : 0)) * 31) + this.maxMessageLength) * 31;
        String str2 = this.automod;
        int hashCode4 = (i8 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.infinite;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "ChannelConfigInnerEntity(channelType=" + this.channelType + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isTypingEvents=" + this.isTypingEvents + ", isReadEvents=" + this.isReadEvents + ", isConnectEvents=" + this.isConnectEvents + ", isSearch=" + this.isSearch + ", isReactionsEnabled=" + this.isReactionsEnabled + ", isRepliesEnabled=" + this.isRepliesEnabled + ", isMutes=" + this.isMutes + ", maxMessageLength=" + this.maxMessageLength + ", automod=" + this.automod + ", infinite=" + this.infinite + ", name=" + this.name + ")";
    }

    public ChannelConfigInnerEntity(String str, Date date, Date date2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "automod");
        Intrinsics.checkNotNullParameter(str3, "infinite");
        Intrinsics.checkNotNullParameter(str4, "name");
        this.channelType = str;
        this.createdAt = date;
        this.updatedAt = date2;
        this.isTypingEvents = z;
        this.isReadEvents = z2;
        this.isConnectEvents = z3;
        this.isSearch = z4;
        this.isReactionsEnabled = z5;
        this.isRepliesEnabled = z6;
        this.isMutes = z7;
        this.maxMessageLength = i;
        this.automod = str2;
        this.infinite = str3;
        this.name = str4;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final boolean isTypingEvents() {
        return this.isTypingEvents;
    }

    public final boolean isReadEvents() {
        return this.isReadEvents;
    }

    public final boolean isConnectEvents() {
        return this.isConnectEvents;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public final boolean isReactionsEnabled() {
        return this.isReactionsEnabled;
    }

    public final boolean isRepliesEnabled() {
        return this.isRepliesEnabled;
    }

    public final boolean isMutes() {
        return this.isMutes;
    }

    public final int getMaxMessageLength() {
        return this.maxMessageLength;
    }

    public final String getAutomod() {
        return this.automod;
    }

    public final String getInfinite() {
        return this.infinite;
    }

    public final String getName() {
        return this.name;
    }
}
