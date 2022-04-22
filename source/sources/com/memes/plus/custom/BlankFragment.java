package com.memes.plus.custom;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.databinding.BlankFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/custom/BlankFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/BlankFragmentBinding;", "()V", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BlankFragment.kt */
public final class BlankFragment extends BaseFragment<BlankFragmentBinding> {
    public BlankFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BlankFragmentBinding inflate = BlankFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "BlankFragmentBinding.inf…flater, container, false)");
        return inflate;
    }
}
