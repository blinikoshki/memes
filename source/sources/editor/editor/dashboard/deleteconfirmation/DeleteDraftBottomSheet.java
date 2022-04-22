package editor.editor.dashboard.deleteconfirmation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NDraftDeleteBottomSheetBinding;
import editor.util.ExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u001c\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Leditor/editor/dashboard/deleteconfirmation/DeleteDraftBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NDraftDeleteBottomSheetBinding;", "positiveCallback", "Lkotlin/Function0;", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DeleteDraftBottomSheet.kt */
public final class DeleteDraftBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "delete-draft-bottom-sheet";
    private NDraftDeleteBottomSheetBinding binding;
    /* access modifiers changed from: private */
    public Function0<Unit> positiveCallback;

    public static final /* synthetic */ Function0 access$getPositiveCallback$p(DeleteDraftBottomSheet deleteDraftBottomSheet) {
        Function0<Unit> function0 = deleteDraftBottomSheet.positiveCallback;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("positiveCallback");
        }
        return function0;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/editor/dashboard/deleteconfirmation/DeleteDraftBottomSheet$Companion;", "", "()V", "TAG", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DeleteDraftBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, C4175R.C4183style.TransparentBottomSheet);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NDraftDeleteBottomSheetBinding inflate = NDraftDeleteBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NDraftDeleteBottomSheetB…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.deleteButton.setOnClickListener(new DeleteDraftBottomSheet$onCreateView$1(this));
        NDraftDeleteBottomSheetBinding nDraftDeleteBottomSheetBinding = this.binding;
        if (nDraftDeleteBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nDraftDeleteBottomSheetBinding.cancelButton.setOnClickListener(new DeleteDraftBottomSheet$onCreateView$2(this));
        NDraftDeleteBottomSheetBinding nDraftDeleteBottomSheetBinding2 = this.binding;
        if (nDraftDeleteBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nDraftDeleteBottomSheetBinding2.getRoot();
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    public final void show(FragmentManager fragmentManager, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(function0, "positiveCallback");
        if (!ExtKt.fragmentTagExists(fragmentManager, TAG)) {
            this.positiveCallback = function0;
            show(fragmentManager, TAG);
        }
    }
}
