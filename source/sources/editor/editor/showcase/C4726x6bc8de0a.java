package editor.editor.showcase;

import editor.common.sheetfooter.CancelDoneFooter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, mo26107d2 = {"<anonymous>", "", "Leditor/common/sheetfooter/CancelDoneFooter;", "invoke", "editor/editor/showcase/ShowcaseActivity$initColorAdjustSliderSheet$1$4"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: editor.editor.showcase.ShowcaseActivity$initColorAdjustSliderSheet$$inlined$apply$lambda$4 */
/* compiled from: ShowcaseActivity.kt */
final class C4726x6bc8de0a extends Lambda implements Function1<CancelDoneFooter, Unit> {
    final /* synthetic */ ShowcaseActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C4726x6bc8de0a(ShowcaseActivity showcaseActivity) {
        super(1);
        this.this$0 = showcaseActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CancelDoneFooter) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CancelDoneFooter cancelDoneFooter) {
        Intrinsics.checkNotNullParameter(cancelDoneFooter, "$receiver");
        cancelDoneFooter.setOnDoneButtonClickListener(new Function0<Unit>(this) {
            final /* synthetic */ C4726x6bc8de0a this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.showMessage("Done");
            }
        });
        cancelDoneFooter.setOnCancelButtonClickListener(new Function0<Unit>(this) {
            final /* synthetic */ C4726x6bc8de0a this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.showMessage("Cancel");
            }
        });
    }
}
