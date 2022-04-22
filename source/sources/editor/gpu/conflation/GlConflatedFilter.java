package editor.gpu.conflation;

import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H'J\b\u0010\b\u001a\u00020\u0007H'J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, mo26107d2 = {"Leditor/gpu/conflation/GlConflatedFilter;", "Leditor/gpu/conflation/GFilter;", "createPhotoFilter", "Leditor/gpu/gpuimage/filter/GlPhotoFilter;", "createVideoFilter", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilter;", "getPhotoPreviewDrawableRes", "", "getVideoPreviewDrawableRes", "isPremium", "", "name", "", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GlConflatedFilter.kt */
public interface GlConflatedFilter extends GFilter {

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: GlConflatedFilter.kt */
    public static final class DefaultImpls {
        public static boolean isPremium(GlConflatedFilter glConflatedFilter) {
            return false;
        }
    }

    GlPhotoFilter createPhotoFilter();

    GlVideoFilter createVideoFilter();

    int getPhotoPreviewDrawableRes();

    int getVideoPreviewDrawableRes();

    boolean isPremium();

    String name();
}
