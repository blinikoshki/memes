package com.memes.plus.events;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/plus/events/PostLikedEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "postId", "", "liked", "", "count", "", "(Ljava/lang/String;ZJ)V", "getCount", "()J", "getLiked", "()Z", "getPostId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PostLikedEvent.kt */
public final class PostLikedEvent extends BaseNotifiableEvent {
    private final long count;
    private final boolean liked;
    private final String postId;

    public static /* synthetic */ PostLikedEvent copy$default(PostLikedEvent postLikedEvent, String str, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = postLikedEvent.postId;
        }
        if ((i & 2) != 0) {
            z = postLikedEvent.liked;
        }
        if ((i & 4) != 0) {
            j = postLikedEvent.count;
        }
        return postLikedEvent.copy(str, z, j);
    }

    public final String component1() {
        return this.postId;
    }

    public final boolean component2() {
        return this.liked;
    }

    public final long component3() {
        return this.count;
    }

    public final PostLikedEvent copy(String str, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
        return new PostLikedEvent(str, z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostLikedEvent)) {
            return false;
        }
        PostLikedEvent postLikedEvent = (PostLikedEvent) obj;
        return Intrinsics.areEqual((Object) this.postId, (Object) postLikedEvent.postId) && this.liked == postLikedEvent.liked && this.count == postLikedEvent.count;
    }

    public int hashCode() {
        String str = this.postId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.liked;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.count);
    }

    public String toString() {
        return "PostLikedEvent(postId=" + this.postId + ", liked=" + this.liked + ", count=" + this.count + ")";
    }

    public final String getPostId() {
        return this.postId;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final long getCount() {
        return this.count;
    }

    public PostLikedEvent(String str, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
        this.postId = str;
        this.liked = z;
        this.count = j;
    }
}
