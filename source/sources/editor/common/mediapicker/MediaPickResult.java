package editor.common.mediapicker;

import com.memes.commons.media.MediaContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Leditor/common/mediapicker/MediaPickResult;", "", "content", "Lcom/memes/commons/media/MediaContent;", "message", "", "(Lcom/memes/commons/media/MediaContent;Ljava/lang/String;)V", "getContent", "()Lcom/memes/commons/media/MediaContent;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaPickResult.kt */
public final class MediaPickResult {
    private final MediaContent content;
    private final String message;

    public static /* synthetic */ MediaPickResult copy$default(MediaPickResult mediaPickResult, MediaContent mediaContent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            mediaContent = mediaPickResult.content;
        }
        if ((i & 2) != 0) {
            str = mediaPickResult.message;
        }
        return mediaPickResult.copy(mediaContent, str);
    }

    public final MediaContent component1() {
        return this.content;
    }

    public final String component2() {
        return this.message;
    }

    public final MediaPickResult copy(MediaContent mediaContent, String str) {
        return new MediaPickResult(mediaContent, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaPickResult)) {
            return false;
        }
        MediaPickResult mediaPickResult = (MediaPickResult) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) mediaPickResult.content) && Intrinsics.areEqual((Object) this.message, (Object) mediaPickResult.message);
    }

    public int hashCode() {
        MediaContent mediaContent = this.content;
        int i = 0;
        int hashCode = (mediaContent != null ? mediaContent.hashCode() : 0) * 31;
        String str = this.message;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MediaPickResult(content=" + this.content + ", message=" + this.message + ")";
    }

    public MediaPickResult(MediaContent mediaContent, String str) {
        this.content = mediaContent;
        this.message = str;
    }

    public final MediaContent getContent() {
        return this.content;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaPickResult(MediaContent mediaContent, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaContent, (i & 2) != 0 ? null : str);
    }

    public final String getMessage() {
        return this.message;
    }
}
