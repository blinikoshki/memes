package com.memes.commons.fragment;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.memes.commons.viewmodel.ViewModelRegistrar;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u00020\n2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/commons/fragment/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/memes/commons/viewmodel/ViewModelRegistrar;", "()V", "assignedFragmentTag", "", "getAssignedFragmentTag", "()Ljava/lang/String;", "viewModelRegistrar", "onAttach", "", "context", "Landroid/content/Context;", "registerViewModels", "viewModels", "", "Landroidx/lifecycle/ViewModel;", "([Landroidx/lifecycle/ViewModel;)V", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment extends Fragment implements ViewModelRegistrar {
    private ViewModelRegistrar viewModelRegistrar;

    public abstract String getAssignedFragmentTag();

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof ViewModelRegistrar)) {
            context = null;
        }
        this.viewModelRegistrar = (ViewModelRegistrar) context;
    }

    public void registerViewModels(ViewModel... viewModelArr) {
        Intrinsics.checkNotNullParameter(viewModelArr, "viewModels");
        ViewModelRegistrar viewModelRegistrar2 = this.viewModelRegistrar;
        if (viewModelRegistrar2 != null) {
            viewModelRegistrar2.registerViewModels((ViewModel[]) Arrays.copyOf(viewModelArr, viewModelArr.length));
        }
    }
}
