package com.getstream.sdk.chat.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0011\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/ChannelItemPayloadDiff;", "", "name", "", "avatarView", "lastMessage", "lastMessageDate", "readState", "unreadCount", "(ZZZZZZ)V", "getAvatarView", "()Z", "getLastMessage", "getLastMessageDate", "getName", "getReadState", "getUnreadCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "plus", "toString", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelItemPayloadDiff.kt */
public final class ChannelItemPayloadDiff {
    private final boolean avatarView;
    private final boolean lastMessage;
    private final boolean lastMessageDate;
    private final boolean name;
    private final boolean readState;
    private final boolean unreadCount;

    public static /* synthetic */ ChannelItemPayloadDiff copy$default(ChannelItemPayloadDiff channelItemPayloadDiff, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 1) != 0) {
            z = channelItemPayloadDiff.name;
        }
        if ((i & 2) != 0) {
            z2 = channelItemPayloadDiff.avatarView;
        }
        boolean z7 = z2;
        if ((i & 4) != 0) {
            z3 = channelItemPayloadDiff.lastMessage;
        }
        boolean z8 = z3;
        if ((i & 8) != 0) {
            z4 = channelItemPayloadDiff.lastMessageDate;
        }
        boolean z9 = z4;
        if ((i & 16) != 0) {
            z5 = channelItemPayloadDiff.readState;
        }
        boolean z10 = z5;
        if ((i & 32) != 0) {
            z6 = channelItemPayloadDiff.unreadCount;
        }
        return channelItemPayloadDiff.copy(z, z7, z8, z9, z10, z6);
    }

    public final boolean component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.avatarView;
    }

    public final boolean component3() {
        return this.lastMessage;
    }

    public final boolean component4() {
        return this.lastMessageDate;
    }

    public final boolean component5() {
        return this.readState;
    }

    public final boolean component6() {
        return this.unreadCount;
    }

    public final ChannelItemPayloadDiff copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return new ChannelItemPayloadDiff(z, z2, z3, z4, z5, z6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelItemPayloadDiff)) {
            return false;
        }
        ChannelItemPayloadDiff channelItemPayloadDiff = (ChannelItemPayloadDiff) obj;
        return this.name == channelItemPayloadDiff.name && this.avatarView == channelItemPayloadDiff.avatarView && this.lastMessage == channelItemPayloadDiff.lastMessage && this.lastMessageDate == channelItemPayloadDiff.lastMessageDate && this.readState == channelItemPayloadDiff.readState && this.unreadCount == channelItemPayloadDiff.unreadCount;
    }

    public int hashCode() {
        boolean z = this.name;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.avatarView;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.lastMessage;
        if (z4) {
            z4 = true;
        }
        int i3 = (i2 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.lastMessageDate;
        if (z5) {
            z5 = true;
        }
        int i4 = (i3 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.readState;
        if (z6) {
            z6 = true;
        }
        int i5 = (i4 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.unreadCount;
        if (!z7) {
            z2 = z7;
        }
        return i5 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "ChannelItemPayloadDiff(name=" + this.name + ", avatarView=" + this.avatarView + ", lastMessage=" + this.lastMessage + ", lastMessageDate=" + this.lastMessageDate + ", readState=" + this.readState + ", unreadCount=" + this.unreadCount + ")";
    }

    public ChannelItemPayloadDiff(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.name = z;
        this.avatarView = z2;
        this.lastMessage = z3;
        this.lastMessageDate = z4;
        this.readState = z5;
        this.unreadCount = z6;
    }

    public final boolean getName() {
        return this.name;
    }

    public final boolean getAvatarView() {
        return this.avatarView;
    }

    public final boolean getLastMessage() {
        return this.lastMessage;
    }

    public final boolean getLastMessageDate() {
        return this.lastMessageDate;
    }

    public final boolean getReadState() {
        return this.readState;
    }

    public final boolean getUnreadCount() {
        return this.unreadCount;
    }

    public final ChannelItemPayloadDiff plus(ChannelItemPayloadDiff channelItemPayloadDiff) {
        Intrinsics.checkNotNullParameter(channelItemPayloadDiff, "other");
        return new ChannelItemPayloadDiff(this.name || channelItemPayloadDiff.name, this.avatarView || channelItemPayloadDiff.avatarView, this.lastMessage || channelItemPayloadDiff.lastMessage, this.lastMessageDate || channelItemPayloadDiff.lastMessageDate, this.readState || channelItemPayloadDiff.readState, this.unreadCount || channelItemPayloadDiff.unreadCount);
    }
}
