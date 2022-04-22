package com.memes.plus.p040ui.create_post;

import com.memes.commons.media.MediaContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006!"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/CreatePostRequest;", "", "text", "", "tags", "postIdForRepost", "mediaContent", "Lcom/memes/commons/media/MediaContent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/memes/commons/media/MediaContent;)V", "fileHeight", "", "getFileHeight", "()I", "filePath", "getFilePath", "()Ljava/lang/String;", "fileWidth", "getFileWidth", "getMediaContent", "()Lcom/memes/commons/media/MediaContent;", "getPostIdForRepost", "getTags", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.CreatePostRequest */
/* compiled from: CreatePostRequest.kt */
public final class CreatePostRequest {
    private final int fileHeight;
    private final String filePath;
    private final int fileWidth;
    private final MediaContent mediaContent;
    private final String postIdForRepost;
    private final String tags;
    private final String text;

    public static /* synthetic */ CreatePostRequest copy$default(CreatePostRequest createPostRequest, String str, String str2, String str3, MediaContent mediaContent2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createPostRequest.text;
        }
        if ((i & 2) != 0) {
            str2 = createPostRequest.tags;
        }
        if ((i & 4) != 0) {
            str3 = createPostRequest.postIdForRepost;
        }
        if ((i & 8) != 0) {
            mediaContent2 = createPostRequest.mediaContent;
        }
        return createPostRequest.copy(str, str2, str3, mediaContent2);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.tags;
    }

    public final String component3() {
        return this.postIdForRepost;
    }

    public final MediaContent component4() {
        return this.mediaContent;
    }

    public final CreatePostRequest copy(String str, String str2, String str3, MediaContent mediaContent2) {
        Intrinsics.checkNotNullParameter(mediaContent2, "mediaContent");
        return new CreatePostRequest(str, str2, str3, mediaContent2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreatePostRequest)) {
            return false;
        }
        CreatePostRequest createPostRequest = (CreatePostRequest) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) createPostRequest.text) && Intrinsics.areEqual((Object) this.tags, (Object) createPostRequest.tags) && Intrinsics.areEqual((Object) this.postIdForRepost, (Object) createPostRequest.postIdForRepost) && Intrinsics.areEqual((Object) this.mediaContent, (Object) createPostRequest.mediaContent);
    }

    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tags;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.postIdForRepost;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        MediaContent mediaContent2 = this.mediaContent;
        if (mediaContent2 != null) {
            i = mediaContent2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "CreatePostRequest(text=" + this.text + ", tags=" + this.tags + ", postIdForRepost=" + this.postIdForRepost + ", mediaContent=" + this.mediaContent + ")";
    }

    public CreatePostRequest(String str, String str2, String str3, MediaContent mediaContent2) {
        Intrinsics.checkNotNullParameter(mediaContent2, "mediaContent");
        this.text = str;
        this.tags = str2;
        this.postIdForRepost = str3;
        this.mediaContent = mediaContent2;
        this.filePath = mediaContent2.getContentUrl();
        this.fileWidth = mediaContent2.width();
        this.fileHeight = mediaContent2.height();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreatePostRequest(String str, String str2, String str3, MediaContent mediaContent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, str3, mediaContent2);
    }

    public final String getText() {
        return this.text;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getPostIdForRepost() {
        return this.postIdForRepost;
    }

    public final MediaContent getMediaContent() {
        return this.mediaContent;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final int getFileWidth() {
        return this.fileWidth;
    }

    public final int getFileHeight() {
        return this.fileHeight;
    }
}
