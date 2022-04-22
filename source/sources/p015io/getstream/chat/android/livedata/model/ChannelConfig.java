package p015io.getstream.chat.android.livedata.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Config;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/model/ChannelConfig;", "", "type", "", "config", "Lio/getstream/chat/android/client/models/Config;", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/Config;)V", "getConfig", "()Lio/getstream/chat/android/client/models/Config;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.model.ChannelConfig */
/* compiled from: ChannelConfig.kt */
public final class ChannelConfig {
    private final Config config;
    private final String type;

    public static /* synthetic */ ChannelConfig copy$default(ChannelConfig channelConfig, String str, Config config2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelConfig.type;
        }
        if ((i & 2) != 0) {
            config2 = channelConfig.config;
        }
        return channelConfig.copy(str, config2);
    }

    public final String component1() {
        return this.type;
    }

    public final Config component2() {
        return this.config;
    }

    public final ChannelConfig copy(String str, Config config2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(config2, "config");
        return new ChannelConfig(str, config2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelConfig)) {
            return false;
        }
        ChannelConfig channelConfig = (ChannelConfig) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) channelConfig.type) && Intrinsics.areEqual((Object) this.config, (Object) channelConfig.config);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Config config2 = this.config;
        if (config2 != null) {
            i = config2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChannelConfig(type=" + this.type + ", config=" + this.config + ")";
    }

    public ChannelConfig(String str, Config config2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(config2, "config");
        this.type = str;
        this.config = config2;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final String getType() {
        return this.type;
    }
}
