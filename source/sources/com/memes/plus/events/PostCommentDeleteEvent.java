package com.memes.plus.events;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/events/PostCommentDeleteEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "postId", "", "commentsToDeleteCount", "", "(Ljava/lang/String;I)V", "getCommentsToDeleteCount", "()I", "setCommentsToDeleteCount", "(I)V", "getPostId", "()Ljava/lang/String;", "setPostId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PostCommentDeleteEvent.kt */
public final class PostCommentDeleteEvent extends BaseNotifiableEvent {
    private int commentsToDeleteCount;
    private String postId;

    public static /* synthetic */ PostCommentDeleteEvent copy$default(PostCommentDeleteEvent postCommentDeleteEvent, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = postCommentDeleteEvent.postId;
        }
        if ((i2 & 2) != 0) {
            i = postCommentDeleteEvent.commentsToDeleteCount;
        }
        return postCommentDeleteEvent.copy(str, i);
    }

    public final String component1() {
        return this.postId;
    }

    public final int component2() {
        return this.commentsToDeleteCount;
    }

    public final PostCommentDeleteEvent copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
        return new PostCommentDeleteEvent(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostCommentDeleteEvent)) {
            return false;
        }
        PostCommentDeleteEvent postCommentDeleteEvent = (PostCommentDeleteEvent) obj;
        return Intrinsics.areEqual((Object) this.postId, (Object) postCommentDeleteEvent.postId) && this.commentsToDeleteCount == postCommentDeleteEvent.commentsToDeleteCount;
    }

    public int hashCode() {
        String str = this.postId;
        return ((str != null ? str.hashCode() : 0) * 31) + this.commentsToDeleteCount;
    }

    public String toString() {
        return "PostCommentDeleteEvent(postId=" + this.postId + ", commentsToDeleteCount=" + this.commentsToDeleteCount + ")";
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.postId = str;
    }

    public final int getCommentsToDeleteCount() {
        return this.commentsToDeleteCount;
    }

    public final void setCommentsToDeleteCount(int i) {
        this.commentsToDeleteCount = i;
    }

    public PostCommentDeleteEvent(String str, int i) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
        this.postId = str;
        this.commentsToDeleteCount = i;
    }
}
