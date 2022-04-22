package editor.gpu.util;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Leditor/gpu/util/ImageFilterRange;", "", "()V", "BRIGHTNESS", "Leditor/gpu/util/FloatRange;", "getBRIGHTNESS", "()Leditor/gpu/util/FloatRange;", "CONTRAST", "getCONTRAST", "PIXELATION", "getPIXELATION", "SATURATION", "getSATURATION", "SHARPNESS", "getSHARPNESS", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GpuFilterRange.kt */
public final class ImageFilterRange {
    private static final FloatRange BRIGHTNESS = new FloatRange(0.0f, -1.0f, 1.0f);
    private static final FloatRange CONTRAST = new FloatRange(1.0f, 0.0f, 4.0f);
    public static final ImageFilterRange INSTANCE = new ImageFilterRange();
    private static final FloatRange PIXELATION = new FloatRange(1.0f, 1.0f, 100.0f);
    private static final FloatRange SATURATION = new FloatRange(1.0f, 0.0f, 2.0f);
    private static final FloatRange SHARPNESS = new FloatRange(0.0f, -4.0f, 4.0f);

    private ImageFilterRange() {
    }

    public final FloatRange getBRIGHTNESS() {
        return BRIGHTNESS;
    }

    public final FloatRange getCONTRAST() {
        return CONTRAST;
    }

    public final FloatRange getSATURATION() {
        return SATURATION;
    }

    public final FloatRange getPIXELATION() {
        return PIXELATION;
    }

    public final FloatRange getSHARPNESS() {
        return SHARPNESS;
    }
}
