package editor.optionsui.text.textfont;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "p1", "Leditor/optionsui/text/textfont/TextFontCategory;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
final /* synthetic */ class TextFontsFragment$onViewCreated$3 extends FunctionReferenceImpl implements Function1<TextFontCategory, Unit> {
    TextFontsFragment$onViewCreated$3(TextFontsFragment textFontsFragment) {
        super(1, textFontsFragment, TextFontsFragment.class, "showSelectedTabByFontCategory", "showSelectedTabByFontCategory(Leditor/optionsui/text/textfont/TextFontCategory;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFontCategory) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFontCategory textFontCategory) {
        Intrinsics.checkNotNullParameter(textFontCategory, "p1");
        ((TextFontsFragment) this.receiver).showSelectedTabByFontCategory(textFontCategory);
    }
}
