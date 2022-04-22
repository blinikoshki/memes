package editor.optionsui.text.textfont;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "fontId", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
final class TextFontsFragment$onViewCreated$6<T> implements Observer<String> {
    final /* synthetic */ TextFontsAdapter $adapter;
    final /* synthetic */ TextFontsFragment this$0;

    TextFontsFragment$onViewCreated$6(TextFontsFragment textFontsFragment, TextFontsAdapter textFontsAdapter) {
        this.this$0 = textFontsFragment;
        this.$adapter = textFontsAdapter;
    }

    public final void onChanged(final String str) {
        TextFontsFragment.access$getBinding$p(this.this$0).fontsRecyclerView.post(new Runnable(this) {
            final /* synthetic */ TextFontsFragment$onViewCreated$6 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                TextFontsAdapter textFontsAdapter = this.this$0.$adapter;
                String str = str;
                Intrinsics.checkNotNullExpressionValue(str, "fontId");
                textFontsAdapter.setSelectedFontId(str);
            }
        });
    }
}
