package editor.optionsui.text.textfont;

import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "category", "Leditor/optionsui/text/textfont/TextFontCategory;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
final class TextFontsFragment$onViewCreated$9 extends Lambda implements Function1<TextFontCategory, Unit> {
    final /* synthetic */ TextFontsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFontsFragment$onViewCreated$9(TextFontsFragment textFontsFragment) {
        super(1);
        this.this$0 = textFontsFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFontCategory) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFontCategory textFontCategory) {
        Intrinsics.checkNotNullParameter(textFontCategory, MonitorLogServerProtocol.PARAM_CATEGORY);
        TextFontsFragment.access$getBinding$p(this.this$0).tabLayout.addTab(TextFontsFragment.access$getBinding$p(this.this$0).tabLayout.newTab().setText((CharSequence) textFontCategory.getDisplayName()), 0);
    }
}
