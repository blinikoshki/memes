package editor.gpu.conflation.filters.deepfry;

import editor.gpu.C4735R;
import editor.gpu.conflation.GlConflatedFilter;
import editor.gpu.conflation.NConflationExtKt;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuimage.filter.GlPhotoFilterGroup;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilterGroup;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, mo26107d2 = {"Leditor/gpu/conflation/filters/deepfry/NDeepFry1ConflatedFilter;", "Leditor/gpu/conflation/GlConflatedFilter;", "()V", "createPhotoFilter", "Leditor/gpu/gpuimage/filter/GlPhotoFilter;", "createVideoFilter", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilter;", "getPhotoPreviewDrawableRes", "", "getVideoPreviewDrawableRes", "isPremium", "", "name", "", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NDeepFry1ConflatedFilter.kt */
public final class NDeepFry1ConflatedFilter implements GlConflatedFilter {
    public boolean isPremium() {
        return false;
    }

    public String name() {
        return "DF1";
    }

    public int getPhotoPreviewDrawableRes() {
        return C4735R.C4737drawable.icon_deep_fry_1;
    }

    public int getVideoPreviewDrawableRes() {
        return C4735R.C4737drawable.icon_deep_fry_1;
    }

    public GlPhotoFilter createPhotoFilter() {
        GlPhotoFilterGroup glPhotoFilterGroup = new GlPhotoFilterGroup();
        NConflationExtKt.contrast(glPhotoFilterGroup, 0.9f);
        NConflationExtKt.brightness(glPhotoFilterGroup, 0.1f);
        NConflationExtKt.saturation(glPhotoFilterGroup, 9.0f);
        NConflationExtKt.sharpness(glPhotoFilterGroup, 7.0f);
        return glPhotoFilterGroup;
    }

    public GlVideoFilter createVideoFilter() {
        GlVideoFilterGroup glVideoFilterGroup = new GlVideoFilterGroup(new GlVideoFilter[0]);
        NConflationExtKt.contrast(glVideoFilterGroup, 0.9f);
        NConflationExtKt.brightness(glVideoFilterGroup, 0.1f);
        NConflationExtKt.saturation(glVideoFilterGroup, 9.0f);
        NConflationExtKt.sharpness(glVideoFilterGroup, 7.0f);
        return glVideoFilterGroup;
    }
}
