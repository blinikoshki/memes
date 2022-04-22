package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u000eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n¨\u0006 "}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channelconfig/CommandInnerEntity;", "", "name", "", "description", "args", "set", "channelType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArgs", "()Ljava/lang/String;", "getChannelType", "getDescription", "id", "", "getId", "()I", "setId", "(I)V", "getName", "getSet", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.CommandInnerEntity */
/* compiled from: ChannelConfigEntity.kt */
public final class CommandInnerEntity {
    private final String args;
    private final String channelType;
    private final String description;

    /* renamed from: id */
    private int f1466id = hashCode();
    private final String name;
    private final String set;

    public static /* synthetic */ CommandInnerEntity copy$default(CommandInnerEntity commandInnerEntity, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commandInnerEntity.name;
        }
        if ((i & 2) != 0) {
            str2 = commandInnerEntity.description;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = commandInnerEntity.args;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = commandInnerEntity.set;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = commandInnerEntity.channelType;
        }
        return commandInnerEntity.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.args;
    }

    public final String component4() {
        return this.set;
    }

    public final String component5() {
        return this.channelType;
    }

    public final CommandInnerEntity copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "args");
        Intrinsics.checkNotNullParameter(str4, "set");
        Intrinsics.checkNotNullParameter(str5, "channelType");
        return new CommandInnerEntity(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandInnerEntity)) {
            return false;
        }
        CommandInnerEntity commandInnerEntity = (CommandInnerEntity) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) commandInnerEntity.name) && Intrinsics.areEqual((Object) this.description, (Object) commandInnerEntity.description) && Intrinsics.areEqual((Object) this.args, (Object) commandInnerEntity.args) && Intrinsics.areEqual((Object) this.set, (Object) commandInnerEntity.set) && Intrinsics.areEqual((Object) this.channelType, (Object) commandInnerEntity.channelType);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.args;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.set;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.channelType;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "CommandInnerEntity(name=" + this.name + ", description=" + this.description + ", args=" + this.args + ", set=" + this.set + ", channelType=" + this.channelType + ")";
    }

    public CommandInnerEntity(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "args");
        Intrinsics.checkNotNullParameter(str4, "set");
        Intrinsics.checkNotNullParameter(str5, "channelType");
        this.name = str;
        this.description = str2;
        this.args = str3;
        this.set = str4;
        this.channelType = str5;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getArgs() {
        return this.args;
    }

    public final String getSet() {
        return this.set;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final int getId() {
        return this.f1466id;
    }

    public final void setId(int i) {
        this.f1466id = i;
    }
}
