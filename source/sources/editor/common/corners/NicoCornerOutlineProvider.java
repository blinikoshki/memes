package editor.common.corners;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import editor.editor.equipment.core.CoreConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Leditor/common/corners/NicoCornerOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "type", "Leditor/common/corners/NicoCornerType;", "(Leditor/common/corners/NicoCornerType;)V", "applyCircleCorners", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "applyOvalCorners", "applyRoundedCorners", "applySquareCorners", "getOutline", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoCornerOutlineProvider.kt */
public final class NicoCornerOutlineProvider extends ViewOutlineProvider {
    private final NicoCornerType type;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NicoCornerType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[NicoCornerType.SQUARE.ordinal()] = 1;
            iArr[NicoCornerType.ROUNDED.ordinal()] = 2;
            iArr[NicoCornerType.CIRCLE.ordinal()] = 3;
            iArr[NicoCornerType.OVAL.ordinal()] = 4;
        }
    }

    public NicoCornerOutlineProvider(NicoCornerType nicoCornerType) {
        Intrinsics.checkNotNullParameter(nicoCornerType, "type");
        this.type = nicoCornerType;
    }

    public void getOutline(View view, Outline outline) {
        if (view != null && outline != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
            if (i == 1) {
                applySquareCorners(view, outline);
            } else if (i == 2) {
                applyRoundedCorners(view, outline);
            } else if (i == 3) {
                applyCircleCorners(view, outline);
            } else if (i == 4) {
                applyOvalCorners(view, outline);
            }
        }
    }

    private final void applySquareCorners(View view, Outline outline) {
        outline.setRect(0, 0, view.getWidth(), view.getHeight());
    }

    private final void applyRoundedCorners(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), CoreConfig.INSTANCE.getROUNDED_CORNER_RADIUS());
    }

    private final void applyCircleCorners(View view, Outline outline) {
        int i;
        int i2;
        int i3 = 0;
        if (view.getWidth() >= view.getHeight()) {
            i2 = view.getHeight();
            i3 = (view.getWidth() - i2) / 2;
            i = 0;
        } else {
            i2 = view.getWidth();
            i = (view.getHeight() - i2) / 2;
        }
        outline.setRoundRect(i3, i, i3 + i2, i + i2, (float) i2);
    }

    private final void applyOvalCorners(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) view.getWidth());
    }
}
