package editor.tools.filters.helpers;

import editor.gpu.gpuimage.filter.GlPhotoFilterGroup;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/gpu/gpuimage/filter/GlPhotoFilterGroup;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaImageFilterManager.kt */
final class MediaImageFilterManager$imageFilterGroup$2 extends Lambda implements Function0<GlPhotoFilterGroup> {
    final /* synthetic */ MediaImageFilterManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaImageFilterManager$imageFilterGroup$2(MediaImageFilterManager mediaImageFilterManager) {
        super(0);
        this.this$0 = mediaImageFilterManager;
    }

    public final GlPhotoFilterGroup invoke() {
        return new GlPhotoFilterGroup(CollectionsKt.toMutableList(this.this$0.getImageFiltersMap().values()));
    }
}
