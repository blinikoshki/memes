package editor.mediaselection.stockmemes;

import android.view.View;
import android.widget.EditText;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: StockMemesFragment.kt */
final class StockMemesFragment$onViewCreated$7 implements View.OnClickListener {
    final /* synthetic */ StockMemesFragment this$0;

    StockMemesFragment$onViewCreated$7(StockMemesFragment stockMemesFragment) {
        this.this$0 = stockMemesFragment;
    }

    public final void onClick(View view) {
        EditText editText = StockMemesFragment.access$getBinding$p(this.this$0).includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.includedSearchLayout.searchEditText");
        ExtensionsKt.clearText(editText);
        this.this$0.performSearch();
    }
}
