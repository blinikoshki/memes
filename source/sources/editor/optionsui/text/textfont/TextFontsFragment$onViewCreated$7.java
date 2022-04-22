package editor.optionsui.text.textfont;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "item", "Leditor/optionsui/text/textfont/FontItem;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
final class TextFontsFragment$onViewCreated$7 extends Lambda implements Function1<FontItem, Unit> {
    final /* synthetic */ TextFontsAdapter $adapter;
    final /* synthetic */ TextFontsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFontsFragment$onViewCreated$7(TextFontsFragment textFontsFragment, TextFontsAdapter textFontsAdapter) {
        super(1);
        this.this$0 = textFontsFragment;
        this.$adapter = textFontsAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FontItem) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final FontItem fontItem) {
        Intrinsics.checkNotNullParameter(fontItem, "item");
        TextFontsFragment.access$getBinding$p(this.this$0).fontsRecyclerView.post(new Runnable(this) {
            final /* synthetic */ TextFontsFragment$onViewCreated$7 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.$adapter.addItemAt(0, fontItem);
            }
        });
    }
}
