package com.memes.plus.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/plus/events/PostNotificationsSubscriptionEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "userId", "", "enabled", "", "message", "(Ljava/lang/String;ZLjava/lang/String;)V", "getEnabled", "()Z", "getMessage", "()Ljava/lang/String;", "getUserId", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PostNotificationsSubscriptionEvent.kt */
public final class PostNotificationsSubscriptionEvent extends BaseNotifiableEvent {
    private final boolean enabled;
    private final String message;
    private final String userId;

    public static /* synthetic */ PostNotificationsSubscriptionEvent copy$default(PostNotificationsSubscriptionEvent postNotificationsSubscriptionEvent, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = postNotificationsSubscriptionEvent.userId;
        }
        if ((i & 2) != 0) {
            z = postNotificationsSubscriptionEvent.enabled;
        }
        if ((i & 4) != 0) {
            str2 = postNotificationsSubscriptionEvent.message;
        }
        return postNotificationsSubscriptionEvent.copy(str, z, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final String component3() {
        return this.message;
    }

    public final PostNotificationsSubscriptionEvent copy(String str, boolean z, String str2) {
        return new PostNotificationsSubscriptionEvent(str, z, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostNotificationsSubscriptionEvent)) {
            return false;
        }
        PostNotificationsSubscriptionEvent postNotificationsSubscriptionEvent = (PostNotificationsSubscriptionEvent) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) postNotificationsSubscriptionEvent.userId) && this.enabled == postNotificationsSubscriptionEvent.enabled && Intrinsics.areEqual((Object) this.message, (Object) postNotificationsSubscriptionEvent.message);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.enabled;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "PostNotificationsSubscriptionEvent(userId=" + this.userId + ", enabled=" + this.enabled + ", message=" + this.message + ")";
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getMessage() {
        return this.message;
    }

    public PostNotificationsSubscriptionEvent(String str, boolean z, String str2) {
        this.userId = str;
        this.enabled = z;
        this.message = str2;
    }
}
