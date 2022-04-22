package editor.tools.filters.helpers;

import editor.gpu.gpuvideo.egl.filter.GlVideoBrightnessFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoContrastFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoPixelationFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoSaturationFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoSharpenFilter;
import editor.tools.filters.MediaFilterType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "Leditor/tools/filters/MediaFilterType;", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaVideoFilterManager.kt */
final class MediaVideoFilterManager$videoFiltersMap$2 extends Lambda implements Function0<Map<MediaFilterType, ? extends GlVideoFilter>> {
    public static final MediaVideoFilterManager$videoFiltersMap$2 INSTANCE = new MediaVideoFilterManager$videoFiltersMap$2();

    MediaVideoFilterManager$videoFiltersMap$2() {
        super(0);
    }

    public final Map<MediaFilterType, GlVideoFilter> invoke() {
        return MapsKt.mapOf(TuplesKt.m181to(MediaFilterType.BRIGHTNESS, new GlVideoBrightnessFilter()), TuplesKt.m181to(MediaFilterType.CONTRAST, new GlVideoContrastFilter()), TuplesKt.m181to(MediaFilterType.SATURATION, new GlVideoSaturationFilter()), TuplesKt.m181to(MediaFilterType.PIXELATION, new GlVideoPixelationFilter()), TuplesKt.m181to(MediaFilterType.SHARPNESS, new GlVideoSharpenFilter()));
    }
}
