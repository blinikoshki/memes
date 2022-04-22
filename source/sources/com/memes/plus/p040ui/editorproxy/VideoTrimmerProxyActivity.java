package com.memes.plus.p040ui.editorproxy;

import android.os.Bundle;
import com.memes.plus.p040ui.subscription.StoreActivity;
import com.memes.plus.p040ui.subscription.promo.PromoTarget;
import com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel;
import editor.editor.plan.EditorPlanRequirement;
import editor.tools.videotrim.VideoTrimActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/editorproxy/VideoTrimmerProxyActivity;", "Leditor/tools/videotrim/VideoTrimActivity;", "()V", "subscriptionStatusViewModel", "Lcom/memes/plus/ui/subscription/validation/SubscriptionStatusViewModel;", "getSubscriptionStatusViewModel", "()Lcom/memes/plus/ui/subscription/validation/SubscriptionStatusViewModel;", "subscriptionStatusViewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "upgradeEditorPlan", "requirement", "Leditor/editor/plan/EditorPlanRequirement;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.editorproxy.VideoTrimmerProxyActivity */
/* compiled from: VideoTrimmerProxyActivity.kt */
public final class VideoTrimmerProxyActivity extends VideoTrimActivity {
    private final Lazy subscriptionStatusViewModel$delegate = LazyKt.lazy(new VideoTrimmerProxyActivity$subscriptionStatusViewModel$2(this));

    private final SubscriptionStatusViewModel getSubscriptionStatusViewModel() {
        return (SubscriptionStatusViewModel) this.subscriptionStatusViewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSubscriptionStatusViewModel().onPremiumVerificationResultAvailable().observe(this, new VideoTrimmerProxyActivity$onCreate$1(this));
        getLifecycle().addObserver(getSubscriptionStatusViewModel().getBillingClientLifecycle());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getSubscriptionStatusViewModel().verifySubscription();
    }

    public void upgradeEditorPlan(EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlanRequirement, "requirement");
        StoreActivity.Companion.start$default(StoreActivity.Companion, this, (PromoTarget) null, 2, (Object) null);
    }
}
