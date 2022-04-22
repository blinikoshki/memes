package editor.optionsui.text.textfont;

import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo26107d2 = {"editor/optionsui/text/textfont/TextFontsFragment$onViewCreated$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
public final class TextFontsFragment$onViewCreated$1 extends GridLayoutManager.SpanSizeLookup {
    final /* synthetic */ TextFontsAdapter $adapter;

    TextFontsFragment$onViewCreated$1(TextFontsAdapter textFontsAdapter) {
        this.$adapter = textFontsAdapter;
    }

    public int getSpanSize(int i) {
        return this.$adapter.getSpanSizeForPosition(i);
    }
}
