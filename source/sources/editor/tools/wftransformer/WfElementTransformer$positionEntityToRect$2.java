package editor.tools.wftransformer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import kotlin.Metadata;
import wireframe.language.elements.WfElement;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"editor/tools/wftransformer/WfElementTransformer$positionEntityToRect$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfElementTransformer.kt */
public final class WfElementTransformer$positionEntityToRect$2 extends AnimatorListenerAdapter {
    final /* synthetic */ WfElement $element;
    final /* synthetic */ Rect $elementRect;
    final /* synthetic */ int $elementRectHeight;
    final /* synthetic */ int $elementRectWidth;
    final /* synthetic */ View $elementView;
    final /* synthetic */ CoreEntity $entity;
    final /* synthetic */ WfElementTransformer this$0;

    WfElementTransformer$positionEntityToRect$2(WfElementTransformer wfElementTransformer, View view, int i, int i2, CoreEntity coreEntity, Rect rect, WfElement wfElement) {
        this.this$0 = wfElementTransformer;
        this.$elementView = view;
        this.$elementRectWidth = i;
        this.$elementRectHeight = i2;
        this.$entity = coreEntity;
        this.$elementRect = rect;
        this.$element = wfElement;
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.changeViewWidthHeight(this.$elementView, this.$elementRectWidth, this.$elementRectHeight);
        this.$entity.applyPropertyBundle(NicoPropertyBundle.Companion.from(this.$entity.getToken(), new NicoProperty.Placement(this.$elementRect), new NicoProperty.Rotation(this.$element.getRotation()), new NicoProperty.Scale(this.$element.getScale())));
    }
}
