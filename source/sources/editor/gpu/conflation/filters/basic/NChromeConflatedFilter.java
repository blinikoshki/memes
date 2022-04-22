package editor.gpu.conflation.filters.basic;

import editor.gpu.C4735R;
import editor.gpu.conflation.GlConflatedFilter;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuimage.filter.GlPhotoHazeFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoWhiteBalanceFilter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo26107d2 = {"Leditor/gpu/conflation/filters/basic/NChromeConflatedFilter;", "Leditor/gpu/conflation/GlConflatedFilter;", "()V", "createPhotoFilter", "Leditor/gpu/gpuimage/filter/GlPhotoFilter;", "createVideoFilter", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilter;", "getPhotoPreviewDrawableRes", "", "getVideoPreviewDrawableRes", "name", "", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NChromeConflatedFilter.kt */
public final class NChromeConflatedFilter implements GlConflatedFilter {
    public String name() {
        return "Chrome";
    }

    public boolean isPremium() {
        return GlConflatedFilter.DefaultImpls.isPremium(this);
    }

    public int getPhotoPreviewDrawableRes() {
        return C4735R.C4737drawable.icon_basic_filter_chrome;
    }

    public int getVideoPreviewDrawableRes() {
        return C4735R.C4737drawable.icon_basic_filter_chrome_video;
    }

    public GlPhotoFilter createPhotoFilter() {
        return new GlPhotoHazeFilter(-0.2f, -0.1f);
    }

    public GlVideoFilter createVideoFilter() {
        GlVideoWhiteBalanceFilter glVideoWhiteBalanceFilter = new GlVideoWhiteBalanceFilter();
        glVideoWhiteBalanceFilter.setTemperature(4500.0f);
        return glVideoWhiteBalanceFilter;
    }
}
