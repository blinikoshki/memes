package com.getstream.sdk.chat.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\u0011\u0010\"\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0002J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItemPayloadDiff;", "", "text", "", "reactions", "attachments", "replies", "syncStatus", "deleted", "positions", "readBy", "(ZZZZZZZZ)V", "getAttachments", "()Z", "getDeleted", "getPositions", "getReactions", "getReadBy", "getReplies", "getSyncStatus", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "plus", "toString", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemPayloadDiff.kt */
public final class MessageListItemPayloadDiff {
    private final boolean attachments;
    private final boolean deleted;
    private final boolean positions;
    private final boolean reactions;
    private final boolean readBy;
    private final boolean replies;
    private final boolean syncStatus;
    private final boolean text;

    public static /* synthetic */ MessageListItemPayloadDiff copy$default(MessageListItemPayloadDiff messageListItemPayloadDiff, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Object obj) {
        MessageListItemPayloadDiff messageListItemPayloadDiff2 = messageListItemPayloadDiff;
        int i2 = i;
        return messageListItemPayloadDiff.copy((i2 & 1) != 0 ? messageListItemPayloadDiff2.text : z, (i2 & 2) != 0 ? messageListItemPayloadDiff2.reactions : z2, (i2 & 4) != 0 ? messageListItemPayloadDiff2.attachments : z3, (i2 & 8) != 0 ? messageListItemPayloadDiff2.replies : z4, (i2 & 16) != 0 ? messageListItemPayloadDiff2.syncStatus : z5, (i2 & 32) != 0 ? messageListItemPayloadDiff2.deleted : z6, (i2 & 64) != 0 ? messageListItemPayloadDiff2.positions : z7, (i2 & 128) != 0 ? messageListItemPayloadDiff2.readBy : z8);
    }

    public final boolean component1() {
        return this.text;
    }

    public final boolean component2() {
        return this.reactions;
    }

    public final boolean component3() {
        return this.attachments;
    }

    public final boolean component4() {
        return this.replies;
    }

    public final boolean component5() {
        return this.syncStatus;
    }

    public final boolean component6() {
        return this.deleted;
    }

    public final boolean component7() {
        return this.positions;
    }

    public final boolean component8() {
        return this.readBy;
    }

    public final MessageListItemPayloadDiff copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        return new MessageListItemPayloadDiff(z, z2, z3, z4, z5, z6, z7, z8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageListItemPayloadDiff)) {
            return false;
        }
        MessageListItemPayloadDiff messageListItemPayloadDiff = (MessageListItemPayloadDiff) obj;
        return this.text == messageListItemPayloadDiff.text && this.reactions == messageListItemPayloadDiff.reactions && this.attachments == messageListItemPayloadDiff.attachments && this.replies == messageListItemPayloadDiff.replies && this.syncStatus == messageListItemPayloadDiff.syncStatus && this.deleted == messageListItemPayloadDiff.deleted && this.positions == messageListItemPayloadDiff.positions && this.readBy == messageListItemPayloadDiff.readBy;
    }

    public int hashCode() {
        boolean z = this.text;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.reactions;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.attachments;
        if (z4) {
            z4 = true;
        }
        int i3 = (i2 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.replies;
        if (z5) {
            z5 = true;
        }
        int i4 = (i3 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.syncStatus;
        if (z6) {
            z6 = true;
        }
        int i5 = (i4 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.deleted;
        if (z7) {
            z7 = true;
        }
        int i6 = (i5 + (z7 ? 1 : 0)) * 31;
        boolean z8 = this.positions;
        if (z8) {
            z8 = true;
        }
        int i7 = (i6 + (z8 ? 1 : 0)) * 31;
        boolean z9 = this.readBy;
        if (!z9) {
            z2 = z9;
        }
        return i7 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "MessageListItemPayloadDiff(text=" + this.text + ", reactions=" + this.reactions + ", attachments=" + this.attachments + ", replies=" + this.replies + ", syncStatus=" + this.syncStatus + ", deleted=" + this.deleted + ", positions=" + this.positions + ", readBy=" + this.readBy + ")";
    }

    public MessageListItemPayloadDiff(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.text = z;
        this.reactions = z2;
        this.attachments = z3;
        this.replies = z4;
        this.syncStatus = z5;
        this.deleted = z6;
        this.positions = z7;
        this.readBy = z8;
    }

    public final boolean getText() {
        return this.text;
    }

    public final boolean getReactions() {
        return this.reactions;
    }

    public final boolean getAttachments() {
        return this.attachments;
    }

    public final boolean getReplies() {
        return this.replies;
    }

    public final boolean getSyncStatus() {
        return this.syncStatus;
    }

    public final boolean getDeleted() {
        return this.deleted;
    }

    public final boolean getPositions() {
        return this.positions;
    }

    public final boolean getReadBy() {
        return this.readBy;
    }

    public final MessageListItemPayloadDiff plus(MessageListItemPayloadDiff messageListItemPayloadDiff) {
        Intrinsics.checkNotNullParameter(messageListItemPayloadDiff, "other");
        return copy(this.text || messageListItemPayloadDiff.text, this.reactions || messageListItemPayloadDiff.reactions, this.attachments || messageListItemPayloadDiff.attachments, this.replies || messageListItemPayloadDiff.replies, this.syncStatus || messageListItemPayloadDiff.syncStatus, this.deleted || messageListItemPayloadDiff.deleted, this.positions || messageListItemPayloadDiff.positions, this.readBy || messageListItemPayloadDiff.readBy);
    }
}
