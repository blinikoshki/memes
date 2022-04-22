package com.memes.plus.events;

import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/events/PostPreviewCommentEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "comment", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "(Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;)V", "getComment", "()Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PostPreviewCommentEvent.kt */
public final class PostPreviewCommentEvent extends BaseNotifiableEvent {
    private final PostPreviewComment comment;

    public static /* synthetic */ PostPreviewCommentEvent copy$default(PostPreviewCommentEvent postPreviewCommentEvent, PostPreviewComment postPreviewComment, int i, Object obj) {
        if ((i & 1) != 0) {
            postPreviewComment = postPreviewCommentEvent.comment;
        }
        return postPreviewCommentEvent.copy(postPreviewComment);
    }

    public final PostPreviewComment component1() {
        return this.comment;
    }

    public final PostPreviewCommentEvent copy(PostPreviewComment postPreviewComment) {
        Intrinsics.checkNotNullParameter(postPreviewComment, "comment");
        return new PostPreviewCommentEvent(postPreviewComment);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PostPreviewCommentEvent) && Intrinsics.areEqual((Object) this.comment, (Object) ((PostPreviewCommentEvent) obj).comment);
        }
        return true;
    }

    public int hashCode() {
        PostPreviewComment postPreviewComment = this.comment;
        if (postPreviewComment != null) {
            return postPreviewComment.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "PostPreviewCommentEvent(comment=" + this.comment + ")";
    }

    public final PostPreviewComment getComment() {
        return this.comment;
    }

    public PostPreviewCommentEvent(PostPreviewComment postPreviewComment) {
        Intrinsics.checkNotNullParameter(postPreviewComment, "comment");
        this.comment = postPreviewComment;
    }
}
