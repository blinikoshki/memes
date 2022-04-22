package editor.gpu.conflation;

import com.facebook.internal.NativeProtocol;
import editor.gpu.gpuimage.filter.GlPhotoBrightnessFilter;
import editor.gpu.gpuimage.filter.GlPhotoContrastFilter;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuimage.filter.GlPhotoFilterGroup;
import editor.gpu.gpuimage.filter.GlPhotoPixelationFilter;
import editor.gpu.gpuimage.filter.GlPhotoRGBFilter;
import editor.gpu.gpuimage.filter.GlPhotoSaturationFilter;
import editor.gpu.gpuimage.filter.GlPhotoSharpenFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoBrightnessFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoContrastFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilterGroup;
import editor.gpu.gpuvideo.egl.filter.GlVideoPixelationFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoRGBFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoSaturationFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoSharpenFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u001a%\u0010\u0007\u001a\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u001a\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\n\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\r\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\u000e\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\f\u001a\"\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f\u001a\"\u0010\u000f\u001a\u00020\t*\u00020\t2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f\u001a\u0012\u0010\u0013\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\u0013\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\u0014\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\u0014\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\f\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0015"}, mo26107d2 = {"buildPhotoFilter", "Leditor/gpu/gpuimage/filter/GlPhotoFilter;", "action", "Lkotlin/Function1;", "Leditor/gpu/gpuimage/filter/GlPhotoFilterGroup;", "", "Lkotlin/ExtensionFunctionType;", "buildVideoFilter", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilter;", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilterGroup;", "brightness", "value", "", "contrast", "pixelation", "rgb", "r", "g", "b", "saturation", "sharpness", "gputool_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: NConflationExt.kt */
public final class NConflationExtKt {
    public static final GlPhotoFilter buildPhotoFilter(Function1<? super GlPhotoFilterGroup, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        GlPhotoFilterGroup glPhotoFilterGroup = new GlPhotoFilterGroup();
        function1.invoke(glPhotoFilterGroup);
        return glPhotoFilterGroup;
    }

    public static final GlPhotoFilterGroup contrast(GlPhotoFilterGroup glPhotoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glPhotoFilterGroup, "$this$contrast");
        glPhotoFilterGroup.addFilter(new GlPhotoContrastFilter(f));
        return glPhotoFilterGroup;
    }

    public static final GlPhotoFilterGroup brightness(GlPhotoFilterGroup glPhotoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glPhotoFilterGroup, "$this$brightness");
        glPhotoFilterGroup.addFilter(new GlPhotoBrightnessFilter(f));
        return glPhotoFilterGroup;
    }

    public static final GlPhotoFilterGroup saturation(GlPhotoFilterGroup glPhotoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glPhotoFilterGroup, "$this$saturation");
        glPhotoFilterGroup.addFilter(new GlPhotoSaturationFilter(f));
        return glPhotoFilterGroup;
    }

    public static final GlPhotoFilterGroup pixelation(GlPhotoFilterGroup glPhotoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glPhotoFilterGroup, "$this$pixelation");
        glPhotoFilterGroup.addFilter(new GlPhotoPixelationFilter(f));
        return glPhotoFilterGroup;
    }

    public static final GlPhotoFilterGroup sharpness(GlPhotoFilterGroup glPhotoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glPhotoFilterGroup, "$this$sharpness");
        glPhotoFilterGroup.addFilter(new GlPhotoSharpenFilter(f));
        return glPhotoFilterGroup;
    }

    public static final GlPhotoFilterGroup rgb(GlPhotoFilterGroup glPhotoFilterGroup, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(glPhotoFilterGroup, "$this$rgb");
        glPhotoFilterGroup.addFilter(new GlPhotoRGBFilter(f, f2, f3));
        return glPhotoFilterGroup;
    }

    public static final GlVideoFilter buildVideoFilter(Function1<? super GlVideoFilterGroup, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        GlVideoFilterGroup glVideoFilterGroup = new GlVideoFilterGroup(new GlVideoFilter[0]);
        function1.invoke(glVideoFilterGroup);
        return glVideoFilterGroup;
    }

    public static final GlVideoFilterGroup contrast(GlVideoFilterGroup glVideoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glVideoFilterGroup, "$this$contrast");
        glVideoFilterGroup.addFilter(new GlVideoContrastFilter(f));
        return glVideoFilterGroup;
    }

    public static final GlVideoFilterGroup brightness(GlVideoFilterGroup glVideoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glVideoFilterGroup, "$this$brightness");
        glVideoFilterGroup.addFilter(new GlVideoBrightnessFilter(f));
        return glVideoFilterGroup;
    }

    public static final GlVideoFilterGroup saturation(GlVideoFilterGroup glVideoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glVideoFilterGroup, "$this$saturation");
        glVideoFilterGroup.addFilter(new GlVideoSaturationFilter(f));
        return glVideoFilterGroup;
    }

    public static final GlVideoFilterGroup pixelation(GlVideoFilterGroup glVideoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glVideoFilterGroup, "$this$pixelation");
        glVideoFilterGroup.addFilter(new GlVideoPixelationFilter(f));
        return glVideoFilterGroup;
    }

    public static final GlVideoFilterGroup sharpness(GlVideoFilterGroup glVideoFilterGroup, float f) {
        Intrinsics.checkNotNullParameter(glVideoFilterGroup, "$this$sharpness");
        glVideoFilterGroup.addFilter(new GlVideoSharpenFilter(f));
        return glVideoFilterGroup;
    }

    public static final GlVideoFilterGroup rgb(GlVideoFilterGroup glVideoFilterGroup, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(glVideoFilterGroup, "$this$rgb");
        glVideoFilterGroup.addFilter(new GlVideoRGBFilter(f, f2, f3));
        return glVideoFilterGroup;
    }
}
