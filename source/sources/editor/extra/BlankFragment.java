package editor.extra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.memes.editor.databinding.NBlankFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Leditor/extra/BlankFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/editor/databinding/NBlankFragmentBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BlankFragment.kt */
public class BlankFragment extends Fragment {
    /* access modifiers changed from: private */
    public NBlankFragmentBinding binding;

    public static final /* synthetic */ NBlankFragmentBinding access$getBinding$p(BlankFragment blankFragment) {
        NBlankFragmentBinding nBlankFragmentBinding = blankFragment.binding;
        if (nBlankFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nBlankFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NBlankFragmentBinding inflate = NBlankFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NBlankFragmentBinding.in…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.getRoot().setOnClickListener(new BlankFragment$onCreateView$1(this));
        NBlankFragmentBinding nBlankFragmentBinding = this.binding;
        if (nBlankFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nBlankFragmentBinding.getRoot();
    }
}
