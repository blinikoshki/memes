package com.memes.commons.bottomsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.memes.commons.viewmodel.ViewModelRegistrar;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u001f\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J!\u0010\u001a\u001a\u00020\u00122\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001dH\u0016¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/commons/bottomsheet/BaseBottomSheetDialogFragment;", "BINDING", "Landroidx/viewbinding/ViewBinding;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/memes/commons/viewmodel/ViewModelRegistrar;", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "onBindingComplete", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "onDestroy", "onViewCreated", "view", "registerViewModels", "viewModels", "", "Landroidx/lifecycle/ViewModel;", "([Landroidx/lifecycle/ViewModel;)V", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseBottomSheetDialogFragment.kt */
public abstract class BaseBottomSheetDialogFragment<BINDING extends ViewBinding> extends BottomSheetDialogFragment implements ViewModelRegistrar {
    private BINDING _binding;

    public abstract BINDING createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void onBindingComplete(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public final BINDING getBinding() {
        BINDING binding = this._binding;
        if (binding != null) {
            return binding;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = createBinding(layoutInflater, viewGroup);
        return getBinding().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        onBindingComplete(bundle);
    }

    public void onDestroy() {
        this._binding = (ViewBinding) null;
        super.onDestroy();
    }

    public void registerViewModels(ViewModel... viewModelArr) {
        Intrinsics.checkNotNullParameter(viewModelArr, "viewModels");
        FragmentActivity requireActivity = requireActivity();
        if (!(requireActivity instanceof ViewModelRegistrar)) {
            requireActivity = null;
        }
        ViewModelRegistrar viewModelRegistrar = (ViewModelRegistrar) requireActivity;
        if (viewModelRegistrar != null) {
            viewModelRegistrar.registerViewModels((ViewModel[]) Arrays.copyOf(viewModelArr, viewModelArr.length));
        }
    }
}
