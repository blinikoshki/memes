package editor.editor.dashboard.drafts;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "drafts", "", "Leditor/editor/dashboard/drafts/EditorDraft;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftsFragment.kt */
final class EditorDraftsFragment$onViewCreated$2<T> implements Observer<List<? extends EditorDraft>> {
    final /* synthetic */ EditorDraftsFragment this$0;

    EditorDraftsFragment$onViewCreated$2(EditorDraftsFragment editorDraftsFragment) {
        this.this$0 = editorDraftsFragment;
    }

    public final void onChanged(List<EditorDraft> list) {
        if (list.isEmpty()) {
            TextView textView = EditorDraftsFragment.access$getBinding$p(this.this$0).noDraftsView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.noDraftsView");
            textView.setVisibility(0);
            this.this$0.getDraftsAdapter().clear(true);
            return;
        }
        TextView textView2 = EditorDraftsFragment.access$getBinding$p(this.this$0).noDraftsView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.noDraftsView");
        textView2.setVisibility(8);
        this.this$0.getDraftsAdapter().setItems(list);
    }
}
