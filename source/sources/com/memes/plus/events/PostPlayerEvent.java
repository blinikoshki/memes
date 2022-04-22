package com.memes.plus.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/events/PostPlayerEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "state", "Lcom/memes/plus/events/PlayerState;", "(Lcom/memes/plus/events/PlayerState;)V", "getState", "()Lcom/memes/plus/events/PlayerState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PostPlayerEvent.kt */
public final class PostPlayerEvent extends BaseNotifiableEvent {
    private final PlayerState state;

    public static /* synthetic */ PostPlayerEvent copy$default(PostPlayerEvent postPlayerEvent, PlayerState playerState, int i, Object obj) {
        if ((i & 1) != 0) {
            playerState = postPlayerEvent.state;
        }
        return postPlayerEvent.copy(playerState);
    }

    public final PlayerState component1() {
        return this.state;
    }

    public final PostPlayerEvent copy(PlayerState playerState) {
        Intrinsics.checkNotNullParameter(playerState, "state");
        return new PostPlayerEvent(playerState);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PostPlayerEvent) && Intrinsics.areEqual((Object) this.state, (Object) ((PostPlayerEvent) obj).state);
        }
        return true;
    }

    public int hashCode() {
        PlayerState playerState = this.state;
        if (playerState != null) {
            return playerState.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "PostPlayerEvent(state=" + this.state + ")";
    }

    public final PlayerState getState() {
        return this.state;
    }

    public PostPlayerEvent(PlayerState playerState) {
        Intrinsics.checkNotNullParameter(playerState, "state");
        this.state = playerState;
    }
}
