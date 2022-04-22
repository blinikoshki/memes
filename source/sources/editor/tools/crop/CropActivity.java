package editor.tools.crop;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NCropActivityBinding;
import editor.core.NicoActivity;
import editor.editor.equipment.media.content.CropSpec;
import editor.tools.crop.CropOption;
import editor.tools.crop.lib.CropImageView;
import editor.util.StyledAlertDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J,\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u000e\u0010!\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, mo26107d2 = {"Leditor/tools/crop/CropActivity;", "Leditor/core/NicoActivity;", "Leditor/tools/crop/lib/CropImageView$OnSetImageUriCompleteListener;", "()V", "binding", "Lcom/memes/editor/databinding/NCropActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NCropActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "cropOptionsAdapter", "Leditor/tools/crop/CropOptionsAdapter;", "getCropOptionsAdapter", "()Leditor/tools/crop/CropOptionsAdapter;", "cropOptionsAdapter$delegate", "cropViewModel", "Leditor/tools/crop/CropViewModel;", "getCropViewModel", "()Leditor/tools/crop/CropViewModel;", "cropViewModel$delegate", "onApplyButtonTapped", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCropOptionSelected", "cropOption", "Leditor/tools/crop/CropOption;", "onSetImageUriComplete", "view", "Leditor/tools/crop/lib/CropImageView;", "uri", "Landroid/net/Uri;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "showErrorDialog", "message", "", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CropActivity.kt */
public final class CropActivity extends NicoActivity implements CropImageView.OnSetImageUriCompleteListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_CROP_SPEC = "intent_extra_crop_spec";
    private final Lazy binding$delegate = LazyKt.lazy(new CropActivity$binding$2(this));
    private final Lazy cropOptionsAdapter$delegate = LazyKt.lazy(new CropActivity$cropOptionsAdapter$2(this));
    private final Lazy cropViewModel$delegate = LazyKt.lazy(new CropActivity$cropViewModel$2(this));

    /* access modifiers changed from: private */
    public final NCropActivityBinding getBinding() {
        return (NCropActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CropOptionsAdapter getCropOptionsAdapter() {
        return (CropOptionsAdapter) this.cropOptionsAdapter$delegate.getValue();
    }

    private final CropViewModel getCropViewModel() {
        return (CropViewModel) this.cropViewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/tools/crop/CropActivity$Companion;", "", "()V", "EXTRA_CROP_SPEC", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CropActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NCropActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getCropViewModel());
        getBinding().cropImageView.setFixedAspectRatio(true);
        getBinding().cropImageView.setOnSetImageUriCompleteListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        RecyclerView recyclerView = getBinding().cropOptionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.cropOptionsRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = getBinding().cropOptionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.cropOptionsRecyclerView");
        recyclerView2.setAdapter(getCropOptionsAdapter());
        getBinding().resetSelectionView.setOnClickListener(new CropActivity$onCreate$1(this));
        getBinding().footer.setOnCancelButtonClickListener(new CropActivity$onCreate$2(this));
        getBinding().footer.setOnDoneButtonClickListener(new CropActivity$onCreate$3(this));
        LifecycleOwner lifecycleOwner = this;
        getCropViewModel().onImageSourceChanged().observe(lifecycleOwner, new CropActivity$onCreate$4(this));
        getCropViewModel().cropOptions().observe(lifecycleOwner, new CropActivity$onCreate$5(this));
        getCropViewModel().cropOutput().observe(lifecycleOwner, new CropActivity$onCreate$6(this));
        getCropViewModel().cropError().observe(lifecycleOwner, new CropActivity$onCreate$7(this));
        CropSpec cropSpec = (CropSpec) getIntent().getParcelableExtra(EXTRA_CROP_SPEC);
        if (cropSpec != null) {
            getCropViewModel().submitCropSpec(cropSpec);
        }
    }

    /* access modifiers changed from: private */
    public final void onCropOptionSelected(CropOption cropOption) {
        if (cropOption instanceof CropOption.FreestylePreview) {
            getBinding().cropImageView.clearAspectRatio();
        } else if (cropOption instanceof CropOption.Preview) {
            CropOption.Preview preview = (CropOption.Preview) cropOption;
            getBinding().cropImageView.setAspectRatio(preview.getAspectX(), preview.getAspectY());
        }
    }

    /* access modifiers changed from: private */
    public final void onApplyButtonTapped() {
        Rect rect;
        try {
            CropImageView cropImageView = getBinding().cropImageView;
            Intrinsics.checkNotNullExpressionValue(cropImageView, "binding.cropImageView");
            rect = cropImageView.getCropRect();
        } catch (Exception unused) {
            rect = null;
        }
        if (rect == null) {
            showErrorDialog("Failed to determine crop boundaries. Please try again.");
            return;
        }
        CropViewModel cropViewModel = getCropViewModel();
        CropImageView cropImageView2 = getBinding().cropImageView;
        Intrinsics.checkNotNullExpressionValue(cropImageView2, "binding.cropImageView");
        cropViewModel.crop(rect, cropImageView2.getRotatedDegrees());
    }

    /* access modifiers changed from: private */
    public final void showErrorDialog(String str) {
        StyledAlertDialog.INSTANCE.builder(this).setTitle((CharSequence) "Error").setMessage((CharSequence) str).setCancelable(false).setPositiveButton(C4175R.string.f963ok, (DialogInterface.OnClickListener) new CropActivity$showErrorDialog$1(this)).show();
    }

    public void onSetImageUriComplete(CropImageView cropImageView, Uri uri, Exception exc) {
        if (exc != null) {
            String string = getString(C4175R.string.error_cant_load_media_msg);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error_cant_load_media_msg)");
            showErrorDialog(string);
        }
    }
}
