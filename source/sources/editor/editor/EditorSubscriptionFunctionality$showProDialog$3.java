package editor.editor;

import android.content.DialogInterface;
import editor.editor.plan.EditorPlan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorSubscriptionFunctionality.kt */
final class EditorSubscriptionFunctionality$showProDialog$3 implements DialogInterface.OnDismissListener {
    final /* synthetic */ Function1 $resultCallback;
    final /* synthetic */ EditorSubscriptionFunctionality this$0;

    EditorSubscriptionFunctionality$showProDialog$3(EditorSubscriptionFunctionality editorSubscriptionFunctionality, Function1 function1) {
        this.this$0 = editorSubscriptionFunctionality;
        this.$resultCallback = function1;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        EditorPlan access$getPlan = this.this$0.getPlan();
        Function1 function1 = this.$resultCallback;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(access$getPlan);
        }
    }
}
