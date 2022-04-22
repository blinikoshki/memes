package editor.mediaselection.items;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.RequestManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NMediaSelectionItemPreviewBottomSheetBinding;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u001a\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006!"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItemPreviewBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "actionCallback", "Lkotlin/Function0;", "", "binding", "Lcom/memes/editor/databinding/NMediaSelectionItemPreviewBottomSheetBinding;", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "getGlideRequestManager", "()Lcom/bumptech/glide/RequestManager;", "glideRequestManager$delegate", "Lkotlin/Lazy;", "mediaSelectionItem", "Leditor/mediaselection/items/MediaSelectionItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPause", "onViewCreated", "view", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionItemPreviewBottomSheet.kt */
public final class MediaSelectionItemPreviewBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "MediaSelectionItemPreview";
    /* access modifiers changed from: private */
    public Function0<Unit> actionCallback;
    private NMediaSelectionItemPreviewBottomSheetBinding binding;
    private final Lazy glideRequestManager$delegate = LazyKt.lazy(new MediaSelectionItemPreviewBottomSheet$glideRequestManager$2(this));
    private MediaSelectionItem mediaSelectionItem;

    private final RequestManager getGlideRequestManager() {
        return (RequestManager) this.glideRequestManager$delegate.getValue();
    }

    public static final /* synthetic */ Function0 access$getActionCallback$p(MediaSelectionItemPreviewBottomSheet mediaSelectionItemPreviewBottomSheet) {
        Function0<Unit> function0 = mediaSelectionItemPreviewBottomSheet.actionCallback;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionCallback");
        }
        return function0;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItemPreviewBottomSheet$Companion;", "", "()V", "TAG", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionItemPreviewBottomSheet.kt */
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
        NMediaSelectionItemPreviewBottomSheetBinding inflate = NMediaSelectionItemPreviewBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaSelectionItemPrevi…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.positiveButton.setOnClickListener(new MediaSelectionItemPreviewBottomSheet$onCreateView$1(this));
        NMediaSelectionItemPreviewBottomSheetBinding nMediaSelectionItemPreviewBottomSheetBinding = this.binding;
        if (nMediaSelectionItemPreviewBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaSelectionItemPreviewBottomSheetBinding.negativeButton.setOnClickListener(new MediaSelectionItemPreviewBottomSheet$onCreateView$2(this));
        NMediaSelectionItemPreviewBottomSheetBinding nMediaSelectionItemPreviewBottomSheetBinding2 = this.binding;
        if (nMediaSelectionItemPreviewBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaSelectionItemPreviewBottomSheetBinding2.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        NMediaSelectionItemPreviewBottomSheetBinding nMediaSelectionItemPreviewBottomSheetBinding = this.binding;
        if (nMediaSelectionItemPreviewBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MediaSelectionItemView mediaSelectionItemView = nMediaSelectionItemPreviewBottomSheetBinding.mediaSelectionItemView;
        MediaSelectionItem mediaSelectionItem2 = this.mediaSelectionItem;
        if (mediaSelectionItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionItem");
        }
        RequestManager glideRequestManager = getGlideRequestManager();
        Intrinsics.checkNotNullExpressionValue(glideRequestManager, "glideRequestManager");
        mediaSelectionItemView.load(mediaSelectionItem2, glideRequestManager);
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    public final void show(FragmentManager fragmentManager, MediaSelectionItem mediaSelectionItem2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(mediaSelectionItem2, "mediaSelectionItem");
        Intrinsics.checkNotNullParameter(function0, "actionCallback");
        if (!ExtKt.fragmentTagExists(fragmentManager, TAG)) {
            this.mediaSelectionItem = mediaSelectionItem2;
            this.actionCallback = function0;
            show(fragmentManager, TAG);
        }
    }

    public void onDestroyView() {
        NMediaSelectionItemPreviewBottomSheetBinding nMediaSelectionItemPreviewBottomSheetBinding = this.binding;
        if (nMediaSelectionItemPreviewBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MediaSelectionItemView mediaSelectionItemView = nMediaSelectionItemPreviewBottomSheetBinding.mediaSelectionItemView;
        RequestManager glideRequestManager = getGlideRequestManager();
        Intrinsics.checkNotNullExpressionValue(glideRequestManager, "glideRequestManager");
        mediaSelectionItemView.cleanup(glideRequestManager);
        super.onDestroyView();
    }
}
