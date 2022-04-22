package editor.tools.filters.helpers;

import editor.gpu.gpuimage.filter.GlPhotoBrightnessFilter;
import editor.gpu.gpuimage.filter.GlPhotoContrastFilter;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuimage.filter.GlPhotoFilterGroup;
import editor.gpu.gpuimage.filter.GlPhotoPixelationFilter;
import editor.gpu.gpuimage.filter.GlPhotoSaturationFilter;
import editor.gpu.gpuimage.filter.GlPhotoSharpenFilter;
import editor.gpu.util.ImageFilterRange;
import editor.tools.filters.MediaFilterType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo26107d2 = {"Leditor/tools/filters/helpers/MediaImageFilterManager;", "", "()V", "imageFilterGroup", "Leditor/gpu/gpuimage/filter/GlPhotoFilterGroup;", "getImageFilterGroup", "()Leditor/gpu/gpuimage/filter/GlPhotoFilterGroup;", "imageFilterGroup$delegate", "Lkotlin/Lazy;", "imageFiltersMap", "", "Leditor/tools/filters/MediaFilterType;", "Leditor/gpu/gpuimage/filter/GlPhotoFilter;", "getImageFiltersMap", "()Ljava/util/Map;", "imageFiltersMap$delegate", "clearFilter", "", "getFilterGroup", "updateFilter", "mediaFilterType", "filterPercent", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaImageFilterManager.kt */
public final class MediaImageFilterManager {
    private final Lazy imageFilterGroup$delegate = LazyKt.lazy(new MediaImageFilterManager$imageFilterGroup$2(this));
    private final Lazy imageFiltersMap$delegate = LazyKt.lazy(MediaImageFilterManager$imageFiltersMap$2.INSTANCE);

    private final GlPhotoFilterGroup getImageFilterGroup() {
        return (GlPhotoFilterGroup) this.imageFilterGroup$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Map<MediaFilterType, GlPhotoFilter> getImageFiltersMap() {
        return (Map) this.imageFiltersMap$delegate.getValue();
    }

    public final GlPhotoFilterGroup getFilterGroup() {
        return getImageFilterGroup();
    }

    public final GlPhotoFilterGroup updateFilter(MediaFilterType mediaFilterType, int i) {
        Intrinsics.checkNotNullParameter(mediaFilterType, "mediaFilterType");
        GlPhotoFilter glPhotoFilter = getImageFiltersMap().get(mediaFilterType);
        if (glPhotoFilter == null) {
            return getImageFilterGroup();
        }
        if (glPhotoFilter instanceof GlPhotoBrightnessFilter) {
            ((GlPhotoBrightnessFilter) glPhotoFilter).setBrightness(ImageFilterRange.INSTANCE.getBRIGHTNESS().toValue(i));
        } else if (glPhotoFilter instanceof GlPhotoContrastFilter) {
            ((GlPhotoContrastFilter) glPhotoFilter).setContrast(ImageFilterRange.INSTANCE.getCONTRAST().toValue(i));
        } else if (glPhotoFilter instanceof GlPhotoSaturationFilter) {
            ((GlPhotoSaturationFilter) glPhotoFilter).setSaturation(ImageFilterRange.INSTANCE.getSATURATION().toValue(i));
        } else if (glPhotoFilter instanceof GlPhotoPixelationFilter) {
            ((GlPhotoPixelationFilter) glPhotoFilter).setPixel(ImageFilterRange.INSTANCE.getPIXELATION().toValue(i));
        } else if (glPhotoFilter instanceof GlPhotoSharpenFilter) {
            ((GlPhotoSharpenFilter) glPhotoFilter).setSharpness(ImageFilterRange.INSTANCE.getSHARPNESS().toValue(i));
        }
        return getImageFilterGroup();
    }

    public final void clearFilter() {
        for (GlPhotoFilter next : getImageFilterGroup().getFilters()) {
            if (next instanceof GlPhotoBrightnessFilter) {
                ((GlPhotoBrightnessFilter) next).setBrightness(ImageFilterRange.INSTANCE.getBRIGHTNESS().getDefault());
            } else if (next instanceof GlPhotoContrastFilter) {
                ((GlPhotoContrastFilter) next).setContrast(ImageFilterRange.INSTANCE.getCONTRAST().getDefault());
            } else if (next instanceof GlPhotoSaturationFilter) {
                ((GlPhotoSaturationFilter) next).setSaturation(ImageFilterRange.INSTANCE.getSATURATION().getDefault());
            } else if (next instanceof GlPhotoPixelationFilter) {
                ((GlPhotoPixelationFilter) next).setPixel(ImageFilterRange.INSTANCE.getPIXELATION().getDefault());
            } else if (next instanceof GlPhotoSharpenFilter) {
                ((GlPhotoSharpenFilter) next).setSharpness(ImageFilterRange.INSTANCE.getSHARPNESS().getDefault());
            }
        }
    }
}
