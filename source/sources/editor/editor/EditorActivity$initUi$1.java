package editor.editor;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "onBackStackChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$initUi$1 implements FragmentManager.OnBackStackChangedListener {
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$initUi$1(EditorActivity editorActivity) {
        this.this$0 = editorActivity;
    }

    public final void onBackStackChanged() {
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            ConstraintLayout constraintLayout = EditorActivity.access$getBinding$p(this.this$0).generatorToolbar;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.generatorToolbar");
            constraintLayout.setVisibility(8);
        } else {
            ConstraintLayout constraintLayout2 = EditorActivity.access$getBinding$p(this.this$0).generatorToolbar;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.generatorToolbar");
            constraintLayout2.setVisibility(0);
            EditorActivity.access$getBinding$p(this.this$0).selectionView.resetSelectedView();
        }
        this.this$0.getFrame().notifyVisiblePanelCountChanged(backStackEntryCount);
    }
}
