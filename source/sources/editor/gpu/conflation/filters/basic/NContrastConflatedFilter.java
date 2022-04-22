package editor.gpu.conflation.filters.basic;

import androidx.exifinterface.media.ExifInterface;
import editor.gpu.conflation.GlConflatedFilter;
import editor.gpu.gpuimage.filter.GlPhotoContrastFilter;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoContrastFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Leditor/gpu/conflation/filters/basic/NContrastConflatedFilter;", "Leditor/gpu/conflation/GlConflatedFilter;", "contrast", "", "(F)V", "createPhotoFilter", "Leditor/gpu/gpuimage/filter/GlPhotoFilter;", "createVideoFilter", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilter;", "getPhotoPreviewDrawableRes", "", "getVideoPreviewDrawableRes", "name", "", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NContrastConflatedFilter.kt */
public final class NContrastConflatedFilter implements GlConflatedFilter {
    private final float contrast;

    public int getPhotoPreviewDrawableRes() {
        return 0;
    }

    public int getVideoPreviewDrawableRes() {
        return 0;
    }

    public String name() {
        return ExifInterface.TAG_CONTRAST;
    }

    public NContrastConflatedFilter(float f) {
        this.contrast = f;
    }

    public boolean isPremium() {
        return GlConflatedFilter.DefaultImpls.isPremium(this);
    }

    public GlPhotoFilter createPhotoFilter() {
        return new GlPhotoContrastFilter(this.contrast);
    }

    public GlVideoFilter createVideoFilter() {
        return new GlVideoContrastFilter(this.contrast);
    }
}
