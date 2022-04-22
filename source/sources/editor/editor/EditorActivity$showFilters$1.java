package editor.editor;

import androidx.activity.result.ActivityResultCallback;
import editor.editor.equipment.media.content.FilterSpec;
import editor.editor.equipment.property.MediaProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.tools.filters.conflation.FilterResult;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "result", "Leditor/tools/filters/conflation/FilterResult;", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$showFilters$1<O> implements ActivityResultCallback<FilterResult> {
    final /* synthetic */ String $token;
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$showFilters$1(EditorActivity editorActivity, String str) {
        this.this$0 = editorActivity;
        this.$token = str;
    }

    public final void onActivityResult(FilterResult filterResult) {
        if (filterResult != null) {
            MediaProperty.Filter filter = new MediaProperty.Filter(new FilterSpec(filterResult.getContent(), filterResult.getFilter()));
            this.this$0.getFrame().updateEntity(NicoPropertyBundle.Companion.from(this.$token, filter));
        }
    }
}
