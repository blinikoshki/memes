package com.memes.plus.p040ui.profile.self_profile;

import androidx.lifecycle.Observer;
import com.facebook.internal.NativeProtocol;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.contentlayout.NestedContentLayout;
import com.memes.plus.databinding.SelfProfileFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "action", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileFragment$onObserversRequested$4 */
/* compiled from: SelfProfileFragment.kt */
final class SelfProfileFragment$onObserversRequested$4<T> implements Observer<ContentVisibilityAction> {
    final /* synthetic */ SelfProfileFragment this$0;

    SelfProfileFragment$onObserversRequested$4(SelfProfileFragment selfProfileFragment) {
        this.this$0 = selfProfileFragment;
    }

    public final void onChanged(ContentVisibilityAction contentVisibilityAction) {
        NestedContentLayout nestedContentLayout = ((SelfProfileFragmentBinding) this.this$0.getBinding()).postsContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentVisibilityAction, NativeProtocol.WEB_DIALOG_ACTION);
        nestedContentLayout.apply(contentVisibilityAction);
    }
}
