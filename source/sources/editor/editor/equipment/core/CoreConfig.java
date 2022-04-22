package editor.editor.equipment.core;

import android.content.res.Resources;
import com.memes.editor.C4175R;
import editor.editor.equipment.text.TextConfig;
import editor.util.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u001a"}, mo26107d2 = {"Leditor/editor/equipment/core/CoreConfig;", "", "()V", "DEFAULT_ANIM_DURATION", "", "ENTITY_TOKEN_PREFIX", "", "MIN_OUTPUT_VIDEO_DURATION_MILLIS", "ROUNDED_CORNER_RADIUS", "", "getROUNDED_CORNER_RADIUS", "()F", "setROUNDED_CORNER_RADIUS", "(F)V", "opacityRange", "Leditor/util/FloatRange;", "getOpacityRange", "()Leditor/util/FloatRange;", "rotationRange", "getRotationRange", "scaleRange", "getScaleRange", "initResources", "", "resources", "Landroid/content/res/Resources;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CoreConfig.kt */
public final class CoreConfig {
    public static final long DEFAULT_ANIM_DURATION = 200;
    public static final String ENTITY_TOKEN_PREFIX = "-";
    public static final CoreConfig INSTANCE = new CoreConfig();
    public static final long MIN_OUTPUT_VIDEO_DURATION_MILLIS = 3500;
    private static float ROUNDED_CORNER_RADIUS = 50.0f;
    private static final FloatRange opacityRange = new FloatRange(1.0f, 0.05f, 1.0f);
    private static final FloatRange rotationRange = new FloatRange(0.0f, -180.0f, 180.0f);
    private static final FloatRange scaleRange = new FloatRange(1.0f, 0.5f, 10.0f);

    private CoreConfig() {
    }

    public final FloatRange getOpacityRange() {
        return opacityRange;
    }

    public final FloatRange getScaleRange() {
        return scaleRange;
    }

    public final FloatRange getRotationRange() {
        return rotationRange;
    }

    public final float getROUNDED_CORNER_RADIUS() {
        return ROUNDED_CORNER_RADIUS;
    }

    public final void setROUNDED_CORNER_RADIUS(float f) {
        ROUNDED_CORNER_RADIUS = f;
    }

    public final void initResources(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        ROUNDED_CORNER_RADIUS = resources.getDimension(C4175R.dimen._16sdp);
        TextConfig.INSTANCE.initResources(resources);
    }
}
