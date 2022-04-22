package editor.tools.filters.helpers;

import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilterGroup;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilterGroup;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaVideoFilterManager.kt */
final class MediaVideoFilterManager$videoFilterGroup$2 extends Lambda implements Function0<GlVideoFilterGroup> {
    final /* synthetic */ MediaVideoFilterManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaVideoFilterManager$videoFilterGroup$2(MediaVideoFilterManager mediaVideoFilterManager) {
        super(0);
        this.this$0 = mediaVideoFilterManager;
    }

    public final GlVideoFilterGroup invoke() {
        return new GlVideoFilterGroup((Collection<GlVideoFilter>) this.this$0.getVideoFiltersMap().values());
    }
}
