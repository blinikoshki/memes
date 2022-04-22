package com.memes.plus.events;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/events/InviteClosedEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "isClosed", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: InviteClosedEvent.kt */
public final class InviteClosedEvent extends BaseNotifiableEvent {
    private final boolean isClosed;

    public static /* synthetic */ InviteClosedEvent copy$default(InviteClosedEvent inviteClosedEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = inviteClosedEvent.isClosed;
        }
        return inviteClosedEvent.copy(z);
    }

    public final boolean component1() {
        return this.isClosed;
    }

    public final InviteClosedEvent copy(boolean z) {
        return new InviteClosedEvent(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof InviteClosedEvent) && this.isClosed == ((InviteClosedEvent) obj).isClosed;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.isClosed;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "InviteClosedEvent(isClosed=" + this.isClosed + ")";
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public InviteClosedEvent(boolean z) {
        this.isClosed = z;
    }
}
