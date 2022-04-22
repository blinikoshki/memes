package com.memes.plus.p040ui.posts.post_tags_dialog;

import com.facebook.share.internal.ShareConstants;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "postId", "", "(Ljava/lang/String;)V", "getPostId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersRequest */
/* compiled from: PostTaggedUsersRequest.kt */
public final class PostTaggedUsersRequest extends AuthenticatedContentRequest {
    private final String postId;

    public static /* synthetic */ PostTaggedUsersRequest copy$default(PostTaggedUsersRequest postTaggedUsersRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = postTaggedUsersRequest.postId;
        }
        return postTaggedUsersRequest.copy(str);
    }

    public final String component1() {
        return this.postId;
    }

    public final PostTaggedUsersRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
        return new PostTaggedUsersRequest(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PostTaggedUsersRequest) && Intrinsics.areEqual((Object) this.postId, (Object) ((PostTaggedUsersRequest) obj).postId);
        }
        return true;
    }

    public int hashCode() {
        String str = this.postId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "PostTaggedUsersRequest(postId=" + this.postId + ")";
    }

    public final String getPostId() {
        return this.postId;
    }

    public PostTaggedUsersRequest(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
        this.postId = str;
    }
}
