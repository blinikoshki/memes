package editor.tools.wftransformer;

import android.graphics.Rect;
import editor.common.corners.NicoCornerType;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.property.NicoProperty;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.elements.WfLayoutElement;
import wireframe.language.elements.WfMediaElement;
import wireframe.language.properties.WfCornerType;
import wireframe.language.properties.WfMargin;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/tools/wftransformer/WfMediaTransformer;", "Leditor/tools/wftransformer/WfElementTransformer;", "()V", "element", "Lwireframe/language/elements/WfMediaElement;", "elementRect", "Landroid/graphics/Rect;", "parent", "Lwireframe/language/elements/WfLayoutElement;", "parentRect", "transform", "", "entity", "Leditor/editor/equipment/media/MediaEntity;", "with", "parentElement", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfMediaTransformer.kt */
public final class WfMediaTransformer extends WfElementTransformer {
    private WfMediaElement element;
    private Rect elementRect;
    private WfLayoutElement parent;
    private Rect parentRect;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WfCornerType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WfCornerType.ROUNDED.ordinal()] = 1;
            iArr[WfCornerType.CIRCLE.ordinal()] = 2;
            iArr[WfCornerType.OVAL.ordinal()] = 3;
            iArr[WfCornerType.SQUARE.ordinal()] = 4;
        }
    }

    public static /* synthetic */ WfMediaTransformer with$default(WfMediaTransformer wfMediaTransformer, WfMediaElement wfMediaElement, Rect rect, WfLayoutElement wfLayoutElement, Rect rect2, int i, Object obj) {
        if ((i & 4) != 0) {
            wfLayoutElement = null;
        }
        if ((i & 8) != 0) {
            rect2 = null;
        }
        return wfMediaTransformer.with(wfMediaElement, rect, wfLayoutElement, rect2);
    }

    public final WfMediaTransformer with(WfMediaElement wfMediaElement, Rect rect, WfLayoutElement wfLayoutElement, Rect rect2) {
        Intrinsics.checkNotNullParameter(wfMediaElement, "element");
        Intrinsics.checkNotNullParameter(rect, "elementRect");
        this.element = wfMediaElement;
        this.elementRect = rect;
        this.parent = wfLayoutElement;
        this.parentRect = rect2;
        return this;
    }

    public final void transform(MediaEntity mediaEntity) {
        NicoCornerType nicoCornerType;
        Intrinsics.checkNotNullParameter(mediaEntity, "entity");
        WfMediaElement wfMediaElement = this.element;
        if (wfMediaElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        WfMargin margin = wfMediaElement.getMargin();
        Rect rect = this.elementRect;
        if (rect == null) {
            Intrinsics.throwUninitializedPropertyAccessException("elementRect");
        }
        int left = rect.left + margin.getLeft();
        Rect rect2 = this.elementRect;
        if (rect2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("elementRect");
        }
        int top2 = rect2.top + margin.getTop();
        Rect rect3 = this.elementRect;
        if (rect3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("elementRect");
        }
        int right = rect3.right - margin.getRight();
        Rect rect4 = this.elementRect;
        if (rect4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("elementRect");
        }
        Rect rect5 = new Rect(left, top2, right, rect4.bottom - margin.getBottom());
        WfMediaElement wfMediaElement2 = this.element;
        if (wfMediaElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[wfMediaElement2.getCorner().getType().ordinal()];
        if (i == 1) {
            nicoCornerType = NicoCornerType.ROUNDED;
        } else if (i == 2) {
            nicoCornerType = NicoCornerType.CIRCLE;
        } else if (i == 3) {
            nicoCornerType = NicoCornerType.OVAL;
        } else if (i == 4) {
            nicoCornerType = NicoCornerType.SQUARE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        mediaEntity.applyProperty(new NicoProperty.Corner(nicoCornerType));
        mediaEntity.setAspectsFixed(true);
        WfMediaElement wfMediaElement3 = this.element;
        if (wfMediaElement3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        positionEntityToRect(wfMediaElement3, mediaEntity, rect5);
    }
}
