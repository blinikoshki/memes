package editor.optionsui.watermark.importpreview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.memes.commons.util.ExtensionsKt;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NWatermarkImportBottomSheetBinding;
import editor.optionsui.watermark.Watermark;
import editor.util.ExtKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Leditor/optionsui/watermark/importpreview/ImportWatermarkBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NWatermarkImportBottomSheetBinding;", "positiveCallback", "Lkotlin/Function0;", "", "watermark", "Leditor/optionsui/watermark/Watermark;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "onViewCreated", "view", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ImportWatermarkBottomSheet.kt */
public final class ImportWatermarkBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "import-watermark-bottom-sheet";
    private NWatermarkImportBottomSheetBinding binding;
    /* access modifiers changed from: private */
    public Function0<Unit> positiveCallback;
    private Watermark watermark;

    public static final /* synthetic */ Function0 access$getPositiveCallback$p(ImportWatermarkBottomSheet importWatermarkBottomSheet) {
        Function0<Unit> function0 = importWatermarkBottomSheet.positiveCallback;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("positiveCallback");
        }
        return function0;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/watermark/importpreview/ImportWatermarkBottomSheet$Companion;", "", "()V", "TAG", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImportWatermarkBottomSheet.kt */
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
        NWatermarkImportBottomSheetBinding inflate = NWatermarkImportBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NWatermarkImportBottomSh…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.importButton.setOnClickListener(new ImportWatermarkBottomSheet$onCreateView$1(this));
        NWatermarkImportBottomSheetBinding nWatermarkImportBottomSheetBinding = this.binding;
        if (nWatermarkImportBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nWatermarkImportBottomSheetBinding.cancelButton.setOnClickListener(new ImportWatermarkBottomSheet$onCreateView$2(this));
        NWatermarkImportBottomSheetBinding nWatermarkImportBottomSheetBinding2 = this.binding;
        if (nWatermarkImportBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nWatermarkImportBottomSheetBinding2.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Watermark watermark2 = this.watermark;
        if (watermark2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watermark");
        }
        String thumbnailPath = watermark2.getThumbnailPath();
        CharSequence charSequence = thumbnailPath;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            ExtensionsKt.toast(requireContext(), "Watermark thumbnail path isn't available.");
            dismiss();
            return;
        }
        File file = new File(thumbnailPath);
        if (!file.exists()) {
            ExtensionsKt.toast(requireContext(), "Watermark thumbnail file doesn't exist.");
            dismiss();
            return;
        }
        RequestBuilder requestBuilder = (RequestBuilder) ((RequestBuilder) Glide.with((Fragment) this).load(file).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true);
        NWatermarkImportBottomSheetBinding nWatermarkImportBottomSheetBinding = this.binding;
        if (nWatermarkImportBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        requestBuilder.into(nWatermarkImportBottomSheetBinding.watermarkThumbnailView);
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    public final void show(FragmentManager fragmentManager, Watermark watermark2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(watermark2, "watermark");
        Intrinsics.checkNotNullParameter(function0, "positiveCallback");
        if (!ExtKt.fragmentTagExists(fragmentManager, TAG)) {
            this.watermark = watermark2;
            this.positiveCallback = function0;
            show(fragmentManager, TAG);
        }
    }
}
