package com.memes.plus.base;

import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BaseBottomSheetDialogFragment.kt */
final /* synthetic */ class BaseBottomSheetDialogFragment$hasBinding$1 extends MutablePropertyReference0Impl {
    BaseBottomSheetDialogFragment$hasBinding$1(BaseBottomSheetDialogFragment baseBottomSheetDialogFragment) {
        super(baseBottomSheetDialogFragment, BaseBottomSheetDialogFragment.class, "binding", "getBinding()Landroidx/viewbinding/ViewBinding;", 0);
    }

    public Object get() {
        return ((BaseBottomSheetDialogFragment) this.receiver).getBinding();
    }

    public void set(Object obj) {
        ((BaseBottomSheetDialogFragment) this.receiver).setBinding((ViewBinding) obj);
    }
}
