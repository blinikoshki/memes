package editor.editor;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.memes.editor.C4175R;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/EditorSubscriptionFunctionality;", "", "()V", "isPro", "", "getPlan", "Leditor/editor/plan/EditorPlan;", "showProDialog", "", "context", "Landroid/content/Context;", "resultCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "plan", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorSubscriptionFunctionality.kt */
public final class EditorSubscriptionFunctionality {
    /* access modifiers changed from: private */
    public boolean isPro;

    public static /* synthetic */ void showProDialog$default(EditorSubscriptionFunctionality editorSubscriptionFunctionality, Context context, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        editorSubscriptionFunctionality.showProDialog(context, function1);
    }

    public final void showProDialog(Context context, Function1<? super EditorPlan, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        new AlertDialog.Builder(context).setTitle(C4175R.string.pro_required_title).setMessage(C4175R.string.pro_required_message).setPositiveButton(C4175R.string.pro_required_positive_action, (DialogInterface.OnClickListener) new EditorSubscriptionFunctionality$showProDialog$1(this)).setNegativeButton(C4175R.string.pro_required_negative_action, (DialogInterface.OnClickListener) new EditorSubscriptionFunctionality$showProDialog$2(this)).setOnDismissListener(new EditorSubscriptionFunctionality$showProDialog$3(this, function1)).show();
    }

    /* access modifiers changed from: private */
    public final EditorPlan getPlan() {
        EditorPlan rookie = EditorPlan.Companion.rookie();
        if (this.isPro) {
            rookie.changePlan(EditorPlanType.Premium);
        }
        return rookie;
    }
}
