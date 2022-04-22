package com.memes.plus.base;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BaseActivity.kt */
final class BaseActivity$registerViewModel$3<T> implements Observer<Boolean> {
    final /* synthetic */ BaseActivity this$0;

    BaseActivity$registerViewModel$3(BaseActivity baseActivity) {
        this.this$0 = baseActivity;
    }

    public final void onChanged(Boolean bool) {
        BaseActivity baseActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        BaseActivity.showBlockingProgressDialog$default(baseActivity, bool.booleanValue(), (String) null, false, 6, (Object) null);
    }
}
