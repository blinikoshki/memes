package editor.tools.filters.helpers;

import editor.gpu.gpuimage.filter.GlPhotoBrightnessFilter;
import editor.gpu.gpuimage.filter.GlPhotoContrastFilter;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuimage.filter.GlPhotoPixelationFilter;
import editor.gpu.gpuimage.filter.GlPhotoSaturationFilter;
import editor.gpu.gpuimage.filter.GlPhotoSharpenFilter;
import editor.tools.filters.MediaFilterType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "Leditor/tools/filters/MediaFilterType;", "Leditor/gpu/gpuimage/filter/GlPhotoFilter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaImageFilterManager.kt */
final class MediaImageFilterManager$imageFiltersMap$2 extends Lambda implements Function0<Map<MediaFilterType, ? extends GlPhotoFilter>> {
    public static final MediaImageFilterManager$imageFiltersMap$2 INSTANCE = new MediaImageFilterManager$imageFiltersMap$2();

    MediaImageFilterManager$imageFiltersMap$2() {
        super(0);
    }

    public final Map<MediaFilterType, GlPhotoFilter> invoke() {
        return MapsKt.mapOf(TuplesKt.m181to(MediaFilterType.BRIGHTNESS, new GlPhotoBrightnessFilter()), TuplesKt.m181to(MediaFilterType.CONTRAST, new GlPhotoContrastFilter()), TuplesKt.m181to(MediaFilterType.SATURATION, new GlPhotoSaturationFilter()), TuplesKt.m181to(MediaFilterType.PIXELATION, new GlPhotoPixelationFilter()), TuplesKt.m181to(MediaFilterType.SHARPNESS, new GlPhotoSharpenFilter()));
    }
}
