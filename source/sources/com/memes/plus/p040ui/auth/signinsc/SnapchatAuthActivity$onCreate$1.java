package com.memes.plus.p040ui.auth.signinsc;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "success", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinsc.SnapchatAuthActivity$onCreate$1 */
/* compiled from: SnapchatAuthActivity.kt */
final class SnapchatAuthActivity$onCreate$1<T> implements Observer<Boolean> {
    final /* synthetic */ SnapchatAuthActivity this$0;

    SnapchatAuthActivity$onCreate$1(SnapchatAuthActivity snapchatAuthActivity) {
        this.this$0 = snapchatAuthActivity;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "success");
        this.this$0.setResult(bool.booleanValue() ? -1 : 0);
        this.this$0.finish();
    }
}
