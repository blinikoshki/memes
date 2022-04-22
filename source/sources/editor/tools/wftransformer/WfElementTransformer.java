package editor.tools.wftransformer;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import editor.editor.equipment.core.CoreEntity;
import editor.util.ExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.elements.WfElement;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, mo26107d2 = {"Leditor/tools/wftransformer/WfElementTransformer;", "", "()V", "changeViewWidthHeight", "", "view", "Landroid/view/View;", "width", "", "height", "changeViewWidthHeightBy", "positionEntityToRect", "element", "Lwireframe/language/elements/WfElement;", "entity", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "elementRect", "Landroid/graphics/Rect;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfElementTransformer.kt */
public class WfElementTransformer {
    public final void positionEntityToRect(WfElement wfElement, CoreEntity<?, ?> coreEntity, Rect rect) {
        Intrinsics.checkNotNullParameter(wfElement, "element");
        Intrinsics.checkNotNullParameter(coreEntity, "entity");
        Intrinsics.checkNotNullParameter(rect, "elementRect");
        View view = coreEntity.getView();
        int width = rect.width();
        int height = rect.height();
        view.bringToFront();
        ExtKt.animator$default(view, 0, 1, (Object) null).setUpdateListener(new WfElementTransformer$positionEntityToRect$1(this, width, view, height)).setListener(new WfElementTransformer$positionEntityToRect$2(this, view, width, height, coreEntity, rect, wfElement)).translationX((float) rect.left).translationY((float) rect.top).rotation(wfElement.getRotation()).scaleX(wfElement.getScale()).scaleY(wfElement.getScale());
    }

    /* access modifiers changed from: private */
    public final void changeViewWidthHeight(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public final void changeViewWidthHeightBy(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width += i;
        layoutParams.height += i2;
        view.setLayoutParams(layoutParams);
    }
}
