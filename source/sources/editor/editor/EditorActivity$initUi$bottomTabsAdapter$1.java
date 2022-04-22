package editor.editor;

import editor.optionsui.optiontabs.BottomOptionTab;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "p1", "Leditor/optionsui/optiontabs/BottomOptionTab;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final /* synthetic */ class EditorActivity$initUi$bottomTabsAdapter$1 extends FunctionReferenceImpl implements Function1<BottomOptionTab, Unit> {
    EditorActivity$initUi$bottomTabsAdapter$1(EditorActivity editorActivity) {
        super(1, editorActivity, EditorActivity.class, "onBottomOptionTabTapped", "onBottomOptionTabTapped(Leditor/optionsui/optiontabs/BottomOptionTab;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BottomOptionTab) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BottomOptionTab bottomOptionTab) {
        Intrinsics.checkNotNullParameter(bottomOptionTab, "p1");
        ((EditorActivity) this.receiver).onBottomOptionTabTapped(bottomOptionTab);
    }
}
