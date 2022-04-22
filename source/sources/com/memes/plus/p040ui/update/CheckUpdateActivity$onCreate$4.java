package com.memes.plus.p040ui.update;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.memes.plus.databinding.CheckUpdateActivityBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.update.CheckUpdateActivity$onCreate$4 */
/* compiled from: CheckUpdateActivity.kt */
final class CheckUpdateActivity$onCreate$4<T> implements Observer<Boolean> {
    final /* synthetic */ CheckUpdateActivity this$0;

    CheckUpdateActivity$onCreate$4(CheckUpdateActivity checkUpdateActivity) {
        this.this$0 = checkUpdateActivity;
    }

    public final void onChanged(Boolean bool) {
        CheckUpdateActivityBinding access$getBinding$p = this.this$0.getBinding();
        Intrinsics.checkNotNullExpressionValue(access$getBinding$p, "binding");
        ConstraintLayout root = access$getBinding$p.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        root.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
