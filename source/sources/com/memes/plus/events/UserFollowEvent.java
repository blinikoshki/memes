package com.memes.plus.events;

import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/plus/events/UserFollowEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "userId", "", "followed", "", "followerCount", "", "(Ljava/lang/String;ZJ)V", "getFollowed", "()Z", "getFollowerCount", "()J", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UserFollowEvent.kt */
public final class UserFollowEvent extends BaseNotifiableEvent {
    private final boolean followed;
    private final long followerCount;
    private final String userId;

    public static /* synthetic */ UserFollowEvent copy$default(UserFollowEvent userFollowEvent, String str, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userFollowEvent.userId;
        }
        if ((i & 2) != 0) {
            z = userFollowEvent.followed;
        }
        if ((i & 4) != 0) {
            j = userFollowEvent.followerCount;
        }
        return userFollowEvent.copy(str, z, j);
    }

    public final String component1() {
        return this.userId;
    }

    public final boolean component2() {
        return this.followed;
    }

    public final long component3() {
        return this.followerCount;
    }

    public final UserFollowEvent copy(String str, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return new UserFollowEvent(str, z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserFollowEvent)) {
            return false;
        }
        UserFollowEvent userFollowEvent = (UserFollowEvent) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) userFollowEvent.userId) && this.followed == userFollowEvent.followed && this.followerCount == userFollowEvent.followerCount;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.followed;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.followerCount);
    }

    public String toString() {
        return "UserFollowEvent(userId=" + this.userId + ", followed=" + this.followed + ", followerCount=" + this.followerCount + ")";
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean getFollowed() {
        return this.followed;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserFollowEvent(String str, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? 0 : j);
    }

    public final long getFollowerCount() {
        return this.followerCount;
    }

    public UserFollowEvent(String str, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        this.userId = str;
        this.followed = z;
        this.followerCount = j;
    }
}
