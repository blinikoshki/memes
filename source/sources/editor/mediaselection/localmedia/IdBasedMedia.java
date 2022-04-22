package editor.mediaselection.localmedia;

import com.memes.commons.media.MediaContent;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, mo26107d2 = {"Leditor/mediaselection/localmedia/IdBasedMedia;", "", "id", "", "content", "Lcom/memes/commons/media/MediaContent;", "(Ljava/lang/String;Lcom/memes/commons/media/MediaContent;)V", "getContent", "()Lcom/memes/commons/media/MediaContent;", "getId", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: IdBasedMedia.kt */
public final class IdBasedMedia {
    private final MediaContent content;

    /* renamed from: id */
    private final String f1431id;

    public IdBasedMedia(String str, MediaContent mediaContent) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        this.f1431id = str;
        this.content = mediaContent;
    }

    public final String getId() {
        return this.f1431id;
    }

    public final MediaContent getContent() {
        return this.content;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type editor.mediaselection.localmedia.IdBasedMedia");
        if (!Intrinsics.areEqual((Object) this.f1431id, (Object) ((IdBasedMedia) obj).f1431id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f1431id.hashCode();
    }
}
