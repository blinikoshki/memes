package editor.editor.equipment.media.content;

import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentKt;
import editor.tools.filters.MediaFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0000J\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u000b\u001a\u00020\u0005R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/editor/equipment/media/content/FilterSpec;", "", "content", "Lcom/memes/commons/media/MediaContent;", "filter", "Leditor/tools/filters/MediaFilter;", "(Lcom/memes/commons/media/MediaContent;Leditor/tools/filters/MediaFilter;)V", "contentExists", "", "copy", "getContent", "getFilter", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FilterSpec.kt */
public final class FilterSpec {
    private final MediaContent content;
    private final MediaFilter filter;

    public FilterSpec(MediaContent mediaContent, MediaFilter mediaFilter) {
        Intrinsics.checkNotNullParameter(mediaFilter, "filter");
        this.content = mediaContent;
        this.filter = mediaFilter;
    }

    public final MediaContent getContent() {
        return this.content;
    }

    public final MediaFilter getFilter() {
        return this.filter;
    }

    public final boolean contentExists() {
        return MediaContentKt.exists(this.content);
    }

    public final FilterSpec copy() {
        MediaContent mediaContent = this.content;
        return new FilterSpec(mediaContent != null ? MediaContent.copy$default(mediaContent, 0, (String) null, (Integer) null, (Integer) null, 15, (Object) null) : null, this.filter.copy());
    }
}
