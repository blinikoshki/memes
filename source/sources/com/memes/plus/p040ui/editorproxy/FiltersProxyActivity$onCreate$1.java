package com.memes.plus.p040ui.editorproxy;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.subscription.validation.SubscriptionCheckResult;
import editor.core.NEditorPlanAwareActivity;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import editor.editor.plan.EditorPlanType;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "Lcom/memes/plus/ui/subscription/validation/SubscriptionCheckResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.editorproxy.FiltersProxyActivity$onCreate$1 */
/* compiled from: FiltersProxyActivity.kt */
final class FiltersProxyActivity$onCreate$1<T> implements Observer<SubscriptionCheckResult> {
    final /* synthetic */ FiltersProxyActivity this$0;

    FiltersProxyActivity$onCreate$1(FiltersProxyActivity filtersProxyActivity) {
        this.this$0 = filtersProxyActivity;
    }

    public final void onChanged(SubscriptionCheckResult subscriptionCheckResult) {
        EditorPlan rookie = EditorPlan.Companion.rookie();
        if (subscriptionCheckResult == SubscriptionCheckResult.ACTIVE) {
            rookie.changePlan(EditorPlanType.Premium);
        }
        NEditorPlanAwareActivity.updateEditorPlan$default(this.this$0, rookie, (EditorPlanRequirement) null, 2, (Object) null);
    }
}
