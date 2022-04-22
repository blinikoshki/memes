package editor.editor;

import androidx.activity.result.ActivityResultCallback;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.property.TextProperty;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "updatedText", "", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$showEditTextPage$1<O> implements ActivityResultCallback<String> {
    final /* synthetic */ boolean $isWatermark;
    final /* synthetic */ String $token;
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$showEditTextPage$1(EditorActivity editorActivity, String str, boolean z) {
        this.this$0 = editorActivity;
        this.$token = str;
        this.$isWatermark = z;
    }

    public final void onActivityResult(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            this.this$0.getFrame().updateTextEntity(NicoPropertyBundle.Companion.from(this.$token, new TextProperty.Text(str), new TextProperty.Watermark(this.$isWatermark)));
        }
    }
}
