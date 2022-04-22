package editor.optionsui.frame.frameresize.customframesizeinput;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeValidation;", "", "()V", "MAX_FRAME_ASPECT_RATIO", "", "MAX_FRAME_DIMENSION", "MIN_FRAME_ASPECT_RATIO", "MIN_FRAME_DIMENSION", "RESULT_INVALID", "", "RESULT_OK", "forDimension", "suspectedDimension", "forRatio", "suspectedRatio", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CustomFrameSizeValidation.kt */
public final class CustomFrameSizeValidation {
    public static final CustomFrameSizeValidation INSTANCE = new CustomFrameSizeValidation();
    private static final float MAX_FRAME_ASPECT_RATIO = 2.5f;
    private static final float MAX_FRAME_DIMENSION = 5000.0f;
    private static final float MIN_FRAME_ASPECT_RATIO = 0.4f;
    private static final float MIN_FRAME_DIMENSION = 512.0f;
    public static final int RESULT_INVALID = 1;
    public static final int RESULT_OK = 2;

    public final int forDimension(float f) {
        return (f < MIN_FRAME_DIMENSION || f > MAX_FRAME_DIMENSION) ? 1 : 2;
    }

    public final int forRatio(float f) {
        return (f < MIN_FRAME_ASPECT_RATIO || f > MAX_FRAME_ASPECT_RATIO) ? 1 : 2;
    }

    private CustomFrameSizeValidation() {
    }
}
