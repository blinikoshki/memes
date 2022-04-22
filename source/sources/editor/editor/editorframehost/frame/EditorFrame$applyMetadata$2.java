package editor.editor.editorframehost.frame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import editor.editor.equipment.core.CoreLayer;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"editor/editor/editorframehost/frame/EditorFrame$applyMetadata$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
public final class EditorFrame$applyMetadata$2 extends AnimatorListenerAdapter {
    final /* synthetic */ int $absoluteHeight;
    final /* synthetic */ int $absoluteWidth;
    final /* synthetic */ CoreLayer $layer;

    EditorFrame$applyMetadata$2(CoreLayer coreLayer, int i, int i2) {
        this.$layer = coreLayer;
        this.$absoluteWidth = i;
        this.$absoluteHeight = i2;
    }

    public void onAnimationEnd(Animator animator) {
        this.$layer.changeWidthHeight(this.$absoluteWidth, this.$absoluteHeight);
    }
}
