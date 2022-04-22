package com.memes.chat.p036ui.channel.members.options;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0010\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0018\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/options/UserActionState;", "", "user", "Lio/getstream/chat/android/client/models/User;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "canSendMessage", "", "canMute", "isMuted", "canBan", "isBanned", "canReport", "isReported", "(Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/models/Channel;ZZZZZZZ)V", "getCanBan", "()Z", "getCanMute", "getCanReport", "getCanSendMessage", "getChannel", "()Lio/getstream/chat/android/client/models/Channel;", "setBanned", "(Z)V", "setMuted", "setReported", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionState */
/* compiled from: UserActionState.kt */
public final class UserActionState {
    private final boolean canBan;
    private final boolean canMute;
    private final boolean canReport;
    private final boolean canSendMessage;
    private final Channel channel;
    private boolean isBanned;
    private boolean isMuted;
    private boolean isReported;
    private final User user;

    public static /* synthetic */ UserActionState copy$default(UserActionState userActionState, User user2, Channel channel2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        UserActionState userActionState2 = userActionState;
        int i2 = i;
        return userActionState.copy((i2 & 1) != 0 ? userActionState2.user : user2, (i2 & 2) != 0 ? userActionState2.channel : channel2, (i2 & 4) != 0 ? userActionState2.canSendMessage : z, (i2 & 8) != 0 ? userActionState2.canMute : z2, (i2 & 16) != 0 ? userActionState2.isMuted : z3, (i2 & 32) != 0 ? userActionState2.canBan : z4, (i2 & 64) != 0 ? userActionState2.isBanned : z5, (i2 & 128) != 0 ? userActionState2.canReport : z6, (i2 & 256) != 0 ? userActionState2.isReported : z7);
    }

    public final User component1() {
        return this.user;
    }

    public final Channel component2() {
        return this.channel;
    }

    public final boolean component3() {
        return this.canSendMessage;
    }

    public final boolean component4() {
        return this.canMute;
    }

    public final boolean component5() {
        return this.isMuted;
    }

    public final boolean component6() {
        return this.canBan;
    }

    public final boolean component7() {
        return this.isBanned;
    }

    public final boolean component8() {
        return this.canReport;
    }

    public final boolean component9() {
        return this.isReported;
    }

    public final UserActionState copy(User user2, Channel channel2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        return new UserActionState(user2, channel2, z, z2, z3, z4, z5, z6, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserActionState)) {
            return false;
        }
        UserActionState userActionState = (UserActionState) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) userActionState.user) && Intrinsics.areEqual((Object) this.channel, (Object) userActionState.channel) && this.canSendMessage == userActionState.canSendMessage && this.canMute == userActionState.canMute && this.isMuted == userActionState.isMuted && this.canBan == userActionState.canBan && this.isBanned == userActionState.isBanned && this.canReport == userActionState.canReport && this.isReported == userActionState.isReported;
    }

    public int hashCode() {
        User user2 = this.user;
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        Channel channel2 = this.channel;
        if (channel2 != null) {
            i = channel2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.canSendMessage;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.canMute;
        if (z3) {
            z3 = true;
        }
        int i4 = (i3 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isMuted;
        if (z4) {
            z4 = true;
        }
        int i5 = (i4 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.canBan;
        if (z5) {
            z5 = true;
        }
        int i6 = (i5 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.isBanned;
        if (z6) {
            z6 = true;
        }
        int i7 = (i6 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.canReport;
        if (z7) {
            z7 = true;
        }
        int i8 = (i7 + (z7 ? 1 : 0)) * 31;
        boolean z8 = this.isReported;
        if (!z8) {
            z2 = z8;
        }
        return i8 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "UserActionState(user=" + this.user + ", channel=" + this.channel + ", canSendMessage=" + this.canSendMessage + ", canMute=" + this.canMute + ", isMuted=" + this.isMuted + ", canBan=" + this.canBan + ", isBanned=" + this.isBanned + ", canReport=" + this.canReport + ", isReported=" + this.isReported + ")";
    }

    public UserActionState(User user2, Channel channel2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.user = user2;
        this.channel = channel2;
        this.canSendMessage = z;
        this.canMute = z2;
        this.isMuted = z3;
        this.canBan = z4;
        this.isBanned = z5;
        this.canReport = z6;
        this.isReported = z7;
    }

    public final User getUser() {
        return this.user;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getCanSendMessage() {
        return this.canSendMessage;
    }

    public final boolean getCanMute() {
        return this.canMute;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final void setMuted(boolean z) {
        this.isMuted = z;
    }

    public final boolean getCanBan() {
        return this.canBan;
    }

    public final boolean isBanned() {
        return this.isBanned;
    }

    public final void setBanned(boolean z) {
        this.isBanned = z;
    }

    public final boolean getCanReport() {
        return this.canReport;
    }

    public final boolean isReported() {
        return this.isReported;
    }

    public final void setReported(boolean z) {
        this.isReported = z;
    }
}
