package editor.tools.filters.helpers;

import editor.gpu.gpuvideo.egl.filter.GlVideoBrightnessFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoContrastFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilterGroup;
import editor.gpu.gpuvideo.egl.filter.GlVideoPixelationFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoSaturationFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoSharpenFilter;
import editor.gpu.util.VideoFilterRange;
import editor.tools.filters.MediaFilterType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo26107d2 = {"Leditor/tools/filters/helpers/MediaVideoFilterManager;", "", "()V", "videoFilterGroup", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilterGroup;", "getVideoFilterGroup", "()Leditor/gpu/gpuvideo/egl/filter/GlVideoFilterGroup;", "videoFilterGroup$delegate", "Lkotlin/Lazy;", "videoFiltersMap", "", "Leditor/tools/filters/MediaFilterType;", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilter;", "getVideoFiltersMap", "()Ljava/util/Map;", "videoFiltersMap$delegate", "clearFilter", "", "getFilterGroup", "updateFilter", "mediaFilterType", "filterPercent", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaVideoFilterManager.kt */
public final class MediaVideoFilterManager {
    private final Lazy videoFilterGroup$delegate = LazyKt.lazy(new MediaVideoFilterManager$videoFilterGroup$2(this));
    private final Lazy videoFiltersMap$delegate = LazyKt.lazy(MediaVideoFilterManager$videoFiltersMap$2.INSTANCE);

    private final GlVideoFilterGroup getVideoFilterGroup() {
        return (GlVideoFilterGroup) this.videoFilterGroup$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Map<MediaFilterType, GlVideoFilter> getVideoFiltersMap() {
        return (Map) this.videoFiltersMap$delegate.getValue();
    }

    public final GlVideoFilterGroup getFilterGroup() {
        return getVideoFilterGroup();
    }

    public final GlVideoFilterGroup updateFilter(MediaFilterType mediaFilterType, int i) {
        Intrinsics.checkNotNullParameter(mediaFilterType, "mediaFilterType");
        GlVideoFilter glVideoFilter = getVideoFiltersMap().get(mediaFilterType);
        if (glVideoFilter == null) {
            return getVideoFilterGroup();
        }
        if (glVideoFilter instanceof GlVideoBrightnessFilter) {
            ((GlVideoBrightnessFilter) glVideoFilter).setBrightness(VideoFilterRange.INSTANCE.getBRIGHTNESS().toValue(i));
        } else if (glVideoFilter instanceof GlVideoContrastFilter) {
            ((GlVideoContrastFilter) glVideoFilter).setContrast(VideoFilterRange.INSTANCE.getCONTRAST().toValue(i));
        } else if (glVideoFilter instanceof GlVideoSaturationFilter) {
            ((GlVideoSaturationFilter) glVideoFilter).setSaturation(VideoFilterRange.INSTANCE.getSATURATION().toValue(i));
        } else if (glVideoFilter instanceof GlVideoPixelationFilter) {
            ((GlVideoPixelationFilter) glVideoFilter).setPixel(VideoFilterRange.INSTANCE.getPIXELATION().toValue(i));
        } else if (glVideoFilter instanceof GlVideoSharpenFilter) {
            ((GlVideoSharpenFilter) glVideoFilter).setSharpness(VideoFilterRange.INSTANCE.getSHARPNESS().toValue(i));
        }
        return getVideoFilterGroup();
    }

    public final void clearFilter() {
        for (Map.Entry<MediaFilterType, GlVideoFilter> value : getVideoFiltersMap().entrySet()) {
            GlVideoFilter glVideoFilter = (GlVideoFilter) value.getValue();
            if (glVideoFilter instanceof GlVideoBrightnessFilter) {
                ((GlVideoBrightnessFilter) glVideoFilter).setBrightness(VideoFilterRange.INSTANCE.getBRIGHTNESS().getDefault());
            } else if (glVideoFilter instanceof GlVideoContrastFilter) {
                ((GlVideoContrastFilter) glVideoFilter).setContrast(VideoFilterRange.INSTANCE.getCONTRAST().getDefault());
            } else if (glVideoFilter instanceof GlVideoSaturationFilter) {
                ((GlVideoSaturationFilter) glVideoFilter).setSaturation(VideoFilterRange.INSTANCE.getSATURATION().getDefault());
            } else if (glVideoFilter instanceof GlVideoPixelationFilter) {
                ((GlVideoPixelationFilter) glVideoFilter).setPixel(VideoFilterRange.INSTANCE.getPIXELATION().getDefault());
            } else if (glVideoFilter instanceof GlVideoSharpenFilter) {
                ((GlVideoSharpenFilter) glVideoFilter).setSharpness(VideoFilterRange.INSTANCE.getSHARPNESS().getDefault());
            }
        }
    }
}
