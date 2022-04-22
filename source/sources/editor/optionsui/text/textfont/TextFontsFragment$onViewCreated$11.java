package editor.optionsui.text.textfont;

import androidx.lifecycle.Observer;
import editor.editor.equipment.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "style", "Leditor/editor/equipment/text/TextStyle;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
final class TextFontsFragment$onViewCreated$11<T> implements Observer<TextStyle> {
    final /* synthetic */ TextFontsFragment this$0;

    TextFontsFragment$onViewCreated$11(TextFontsFragment textFontsFragment) {
        this.this$0 = textFontsFragment;
    }

    public final void onChanged(TextStyle textStyle) {
        TextFontsViewModel access$getTextFontsViewModel$p = this.this$0.getTextFontsViewModel();
        Intrinsics.checkNotNullExpressionValue(textStyle, "style");
        access$getTextFontsViewModel$p.setStyle(textStyle);
    }
}
