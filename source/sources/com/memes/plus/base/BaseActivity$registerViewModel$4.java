package com.memes.plus.base;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BaseActivity.kt */
final class BaseActivity$registerViewModel$4<T> implements Observer<String> {
    final /* synthetic */ BaseActivity this$0;

    BaseActivity$registerViewModel$4(BaseActivity baseActivity) {
        this.this$0 = baseActivity;
    }

    public final void onChanged(String str) {
        if (this.this$0.kProgressHUD != null) {
            BaseActivity.access$getKProgressHUD$p(this.this$0).setLabel(str);
        }
    }
}
