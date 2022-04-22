package com.memes.plus.p040ui.subscription;

import androidx.lifecycle.Observer;
import com.facebook.internal.NativeProtocol;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "action", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$setupObservers$2 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$setupObservers$2<T> implements Observer<ContentVisibilityAction> {
    final /* synthetic */ StoreActivity this$0;

    StoreActivity$setupObservers$2(StoreActivity storeActivity) {
        this.this$0 = storeActivity;
    }

    public final void onChanged(ContentVisibilityAction contentVisibilityAction) {
        ContentLayout contentLayout = this.this$0.getBinding().storeInfoContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentVisibilityAction, NativeProtocol.WEB_DIALOG_ACTION);
        contentLayout.apply(contentVisibilityAction);
    }
}
