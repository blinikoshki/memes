package editor.optionsui.text.textfont;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, mo26107d2 = {"editor/optionsui/text/textfont/TextFontsFragment$onViewCreated$2", "Leditor/optionsui/text/textfont/TextFontsVisibilityScrollListener;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
public final class TextFontsFragment$onViewCreated$2 extends TextFontsVisibilityScrollListener {
    final /* synthetic */ GridLayoutManager $layoutManager;
    final /* synthetic */ TextFontsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFontsFragment$onViewCreated$2(TextFontsFragment textFontsFragment, GridLayoutManager gridLayoutManager, LinearLayoutManager linearLayoutManager, Function1 function1) {
        super(linearLayoutManager, function1);
        this.this$0 = textFontsFragment;
        this.$layoutManager = gridLayoutManager;
    }
}
