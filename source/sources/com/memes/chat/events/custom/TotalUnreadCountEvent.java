package com.memes.chat.events.custom;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/chat/events/custom/TotalUnreadCountEvent;", "Lcom/memes/chat/events/custom/DeclaredChatEvent;", "count", "", "(I)V", "getCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TotalUnreadCountEvent.kt */
public final class TotalUnreadCountEvent implements DeclaredChatEvent {
    private final int count;

    public static /* synthetic */ TotalUnreadCountEvent copy$default(TotalUnreadCountEvent totalUnreadCountEvent, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = totalUnreadCountEvent.count;
        }
        return totalUnreadCountEvent.copy(i);
    }

    public final int component1() {
        return this.count;
    }

    public final TotalUnreadCountEvent copy(int i) {
        return new TotalUnreadCountEvent(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TotalUnreadCountEvent) && this.count == ((TotalUnreadCountEvent) obj).count;
        }
        return true;
    }

    public int hashCode() {
        return this.count;
    }

    public String toString() {
        return "TotalUnreadCountEvent(count=" + this.count + ")";
    }

    public TotalUnreadCountEvent(int i) {
        this.count = i;
    }

    public final int getCount() {
        return this.count;
    }
}
