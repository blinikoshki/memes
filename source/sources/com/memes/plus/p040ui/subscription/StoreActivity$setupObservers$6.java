package com.memes.plus.p040ui.subscription;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$setupObservers$6 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$setupObservers$6<T> implements Observer<String> {
    final /* synthetic */ StoreActivity this$0;

    StoreActivity$setupObservers$6(StoreActivity storeActivity) {
        this.this$0 = storeActivity;
    }

    public final void onChanged(String str) {
        StoreActivity storeActivity = this.this$0;
        ExtensionsKt.toast((Context) storeActivity, "Unable to initialize billing information.\n(cause: " + str + ')');
        this.this$0.finish();
    }
}
