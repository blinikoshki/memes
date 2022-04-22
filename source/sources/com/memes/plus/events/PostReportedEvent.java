package com.memes.plus.events;

import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/events/PostReportedEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PostReportedEvent.kt */
public final class PostReportedEvent extends BaseNotifiableEvent {
    private final Post post;

    public static /* synthetic */ PostReportedEvent copy$default(PostReportedEvent postReportedEvent, Post post2, int i, Object obj) {
        if ((i & 1) != 0) {
            post2 = postReportedEvent.post;
        }
        return postReportedEvent.copy(post2);
    }

    public final Post component1() {
        return this.post;
    }

    public final PostReportedEvent copy(Post post2) {
        Intrinsics.checkNotNullParameter(post2, "post");
        return new PostReportedEvent(post2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PostReportedEvent) && Intrinsics.areEqual((Object) this.post, (Object) ((PostReportedEvent) obj).post);
        }
        return true;
    }

    public int hashCode() {
        Post post2 = this.post;
        if (post2 != null) {
            return post2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "PostReportedEvent(post=" + this.post + ")";
    }

    public final Post getPost() {
        return this.post;
    }

    public PostReportedEvent(Post post2) {
        Intrinsics.checkNotNullParameter(post2, "post");
        this.post = post2;
    }
}
