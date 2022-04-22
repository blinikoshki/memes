package editor.optionsui.frame.frameresize.customframesizeinput;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NCustomFrameSizeBottomSheetBinding;
import editor.extra.NicoRatioFrameLayout;
import editor.optionsui.frame.frameresize.FrameSize;
import editor.optionsui.frame.frameresize.FrameSizeType;
import editor.optionsui.frame.frameresize.customframesizeinput.CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2;
import editor.util.ExtKt;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\b\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0011H\u0016J\u001a\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J9\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00110\u000eJ\b\u0010)\u001a\u00020\u0011H\u0002J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00110\u000eX.¢\u0006\u0002\n\u0000¨\u00060"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeInputBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NCustomFrameSizeBottomSheetBinding;", "frameSize", "Leditor/optionsui/frame/frameresize/FrameSize;", "frameSizeTextChangeListener", "editor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2$1", "getFrameSizeTextChangeListener", "()Leditor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2$1;", "frameSizeTextChangeListener$delegate", "Lkotlin/Lazy;", "positiveCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getInput", "", "editText", "Landroid/widget/EditText;", "getInputHeight", "getInputWidth", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDoneButtonTapped", "onPause", "onViewCreated", "view", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "updateFrameSizePreview", "validateChosenFrameSize", "", "width", "", "height", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CustomFrameSizeInputBottomSheet.kt */
public final class CustomFrameSizeInputBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "frame-size-input-sheet";
    private NCustomFrameSizeBottomSheetBinding binding;
    private FrameSize frameSize;
    private final Lazy frameSizeTextChangeListener$delegate = LazyKt.lazy(new CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2(this));
    private Function1<? super FrameSize, Unit> positiveCallback;

    private final CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2.C48481 getFrameSizeTextChangeListener() {
        return (CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2.C48481) this.frameSizeTextChangeListener$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeInputBottomSheet$Companion;", "", "()V", "TAG", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CustomFrameSizeInputBottomSheet.kt */
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
        NCustomFrameSizeBottomSheetBinding inflate = NCustomFrameSizeBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NCustomFrameSizeBottomSh…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.widthEditText.addTextChangedListener(getFrameSizeTextChangeListener());
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding = this.binding;
        if (nCustomFrameSizeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCustomFrameSizeBottomSheetBinding.heightEditText.addTextChangedListener(getFrameSizeTextChangeListener());
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding2 = this.binding;
        if (nCustomFrameSizeBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = nCustomFrameSizeBottomSheetBinding2.frameSizePreviewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frameSizePreviewContainer");
        ExtKt.enableChangingTransitionType(frameLayout);
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding3 = this.binding;
        if (nCustomFrameSizeBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCustomFrameSizeBottomSheetBinding3.doneButton.setOnClickListener(new CustomFrameSizeInputBottomSheet$onCreateView$1(this));
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding4 = this.binding;
        if (nCustomFrameSizeBottomSheetBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCustomFrameSizeBottomSheetBinding4.cancelButton.setOnClickListener(new CustomFrameSizeInputBottomSheet$onCreateView$2(this));
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding5 = this.binding;
        if (nCustomFrameSizeBottomSheetBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nCustomFrameSizeBottomSheetBinding5.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding = this.binding;
        if (nCustomFrameSizeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = nCustomFrameSizeBottomSheetBinding.widthEditText;
        FrameSize frameSize2 = this.frameSize;
        if (frameSize2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameSize");
        }
        textInputEditText.setText(String.valueOf(MathKt.roundToInt(frameSize2.getWidth())));
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding2 = this.binding;
        if (nCustomFrameSizeBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText2 = nCustomFrameSizeBottomSheetBinding2.heightEditText;
        FrameSize frameSize3 = this.frameSize;
        if (frameSize3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameSize");
        }
        textInputEditText2.setText(String.valueOf(MathKt.roundToInt(frameSize3.getHeight())));
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    public void onDestroyView() {
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding = this.binding;
        if (nCustomFrameSizeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCustomFrameSizeBottomSheetBinding.widthEditText.removeTextChangedListener(getFrameSizeTextChangeListener());
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding2 = this.binding;
        if (nCustomFrameSizeBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCustomFrameSizeBottomSheetBinding2.heightEditText.removeTextChangedListener(getFrameSizeTextChangeListener());
        super.onDestroyView();
    }

    public final void show(FragmentManager fragmentManager, FrameSize frameSize2, Function1<? super FrameSize, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(frameSize2, "frameSize");
        Intrinsics.checkNotNullParameter(function1, "positiveCallback");
        if (!ExtKt.fragmentTagExists(fragmentManager, TAG)) {
            this.frameSize = frameSize2;
            this.positiveCallback = function1;
            show(fragmentManager, TAG);
        }
    }

    private final int getInputWidth() {
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding = this.binding;
        if (nCustomFrameSizeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = nCustomFrameSizeBottomSheetBinding.widthEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.widthEditText");
        return getInput(textInputEditText);
    }

    private final int getInputHeight() {
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding = this.binding;
        if (nCustomFrameSizeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = nCustomFrameSizeBottomSheetBinding.heightEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.heightEditText");
        return getInput(textInputEditText);
    }

    private final int getInput(EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return -1;
        }
        String obj = text.toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim((CharSequence) obj).toString());
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final void updateFrameSizePreview() {
        float inputWidth = (float) getInputWidth();
        float inputHeight = (float) getInputHeight();
        float f = inputWidth / inputHeight;
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding = this.binding;
        if (nCustomFrameSizeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCustomFrameSizeBottomSheetBinding.frameSizePreviewView.setAspectRatio(f);
        if (validateChosenFrameSize(inputWidth, inputHeight)) {
            NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding2 = this.binding;
            if (nCustomFrameSizeBottomSheetBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            NicoRatioFrameLayout nicoRatioFrameLayout = nCustomFrameSizeBottomSheetBinding2.frameSizePreviewView;
            Intrinsics.checkNotNullExpressionValue(nicoRatioFrameLayout, "binding.frameSizePreviewView");
            nicoRatioFrameLayout.setAlpha(1.0f);
            return;
        }
        NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding3 = this.binding;
        if (nCustomFrameSizeBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        NicoRatioFrameLayout nicoRatioFrameLayout2 = nCustomFrameSizeBottomSheetBinding3.frameSizePreviewView;
        Intrinsics.checkNotNullExpressionValue(nicoRatioFrameLayout2, "binding.frameSizePreviewView");
        nicoRatioFrameLayout2.setAlpha(0.2f);
    }

    private final boolean validateChosenFrameSize(float f, float f2) {
        if (CustomFrameSizeValidation.INSTANCE.forDimension(f) == 1) {
            NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding = this.binding;
            if (nCustomFrameSizeBottomSheetBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nCustomFrameSizeBottomSheetBinding.sizeErrorTextView.setText(C4175R.string.error_invalid_frame_dimensions);
            return false;
        } else if (CustomFrameSizeValidation.INSTANCE.forDimension(f2) == 1) {
            NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding2 = this.binding;
            if (nCustomFrameSizeBottomSheetBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nCustomFrameSizeBottomSheetBinding2.sizeErrorTextView.setText(C4175R.string.error_invalid_frame_dimensions);
            return false;
        } else {
            if (CustomFrameSizeValidation.INSTANCE.forRatio(f / f2) == 1) {
                NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding3 = this.binding;
                if (nCustomFrameSizeBottomSheetBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                nCustomFrameSizeBottomSheetBinding3.sizeErrorTextView.setText(C4175R.string.error_invalid_frame_ratio);
                return false;
            }
            NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding4 = this.binding;
            if (nCustomFrameSizeBottomSheetBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = nCustomFrameSizeBottomSheetBinding4.sizeErrorTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.sizeErrorTextView");
            textView.setText((CharSequence) null);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final void onDoneButtonTapped() {
        float inputWidth = (float) getInputWidth();
        float inputHeight = (float) getInputHeight();
        if (!validateChosenFrameSize(inputWidth, inputHeight)) {
            NCustomFrameSizeBottomSheetBinding nCustomFrameSizeBottomSheetBinding = this.binding;
            if (nCustomFrameSizeBottomSheetBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            NicoRatioFrameLayout nicoRatioFrameLayout = nCustomFrameSizeBottomSheetBinding.frameSizePreviewView;
            Intrinsics.checkNotNullExpressionValue(nicoRatioFrameLayout, "binding.frameSizePreviewView");
            nicoRatioFrameLayout.setAlpha(0.3f);
            return;
        }
        FrameSize frameSize2 = this.frameSize;
        if (frameSize2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameSize");
        }
        FrameSize copy$default = FrameSize.copy$default(frameSize2, (String) null, inputWidth, inputHeight, (FrameSizeType) null, (String) null, 25, (Object) null);
        Function1<? super FrameSize, Unit> function1 = this.positiveCallback;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("positiveCallback");
        }
        function1.invoke(copy$default);
        dismiss();
    }
}
