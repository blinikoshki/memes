package editor.tools.signature;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import com.memes.commons.media.MediaContent;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NSignatureActivityBinding;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.color.ColorsViewModel;
import editor.signature.views.SignaturePad;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, mo26107d2 = {"Leditor/tools/signature/SignatureActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Leditor/signature/views/SignaturePad$OnSignedListener;", "()V", "binding", "Lcom/memes/editor/databinding/NSignatureActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NSignatureActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "colorsViewModel", "Leditor/optionsui/layerpaint/color/ColorsViewModel;", "getColorsViewModel", "()Leditor/optionsui/layerpaint/color/ColorsViewModel;", "colorsViewModel$delegate", "isSignatureErased", "", "signatureViewModel", "Leditor/tools/signature/SignatureViewModel;", "getSignatureViewModel", "()Leditor/tools/signature/SignatureViewModel;", "signatureViewModel$delegate", "onCancelButtonTapped", "", "onClear", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSigned", "onStartSigning", "setSignatureHintEnabled", "enabled", "submitSignatureContent", "content", "Lcom/memes/commons/media/MediaContent;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SignatureActivity.kt */
public final class SignatureActivity extends AppCompatActivity implements SignaturePad.OnSignedListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_MEDIA_CONTENT = "intent_extra_media_content";
    public static final String EXTRA_OUTPUT_PATH = "intent_extra_output_path";
    private final Lazy binding$delegate = LazyKt.lazy(new SignatureActivity$binding$2(this));
    private final Lazy colorsViewModel$delegate = LazyKt.lazy(new SignatureActivity$colorsViewModel$2(this));
    /* access modifiers changed from: private */
    public boolean isSignatureErased = true;
    private final Lazy signatureViewModel$delegate = LazyKt.lazy(new SignatureActivity$signatureViewModel$2(this));

    /* access modifiers changed from: private */
    public final NSignatureActivityBinding getBinding() {
        return (NSignatureActivityBinding) this.binding$delegate.getValue();
    }

    private final ColorsViewModel getColorsViewModel() {
        return (ColorsViewModel) this.colorsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SignatureViewModel getSignatureViewModel() {
        return (SignatureViewModel) this.signatureViewModel$delegate.getValue();
    }

    public void onSigned() {
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Leditor/tools/signature/SignatureActivity$Companion;", "", "()V", "EXTRA_MEDIA_CONTENT", "", "EXTRA_OUTPUT_PATH", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: SignatureActivity.kt */
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
        NSignatureActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        getBinding().brushThicknessValueSlider.setMinValue(1.0f);
        getBinding().brushThicknessValueSlider.setMaxValue(100.0f);
        getBinding().brushThicknessValueSlider.setValue(5.0f);
        getBinding().signaturePad.setMinWidth(4.0f);
        getBinding().signaturePad.setMaxWidth(6.0f);
        getBinding().signaturePad.setOnSignedListener(this);
        setSignatureHintEnabled(true);
        getBinding().brushThicknessValueSlider.setOnChangeListener(new SignatureActivity$onCreate$1(this));
        getBinding().clearSignatureView.setOnClickListener(new SignatureActivity$onCreate$2(this));
        getBinding().clearSignatureView.setOnLongClickListener(new SignatureActivity$onCreate$3(this));
        getBinding().footer.setOnCancelButtonClickListener(new SignatureActivity$onCreate$4(this));
        getBinding().footer.setOnDoneButtonClickListener(new SignatureActivity$onCreate$5(this));
        LifecycleOwner lifecycleOwner = this;
        getSignatureViewModel().onSignatureCreated().observe(lifecycleOwner, new SignatureActivity$onCreate$6(this));
        getColorsViewModel().onSelectedColorChanged().observe(lifecycleOwner, new SignatureActivity$onCreate$7(this));
        LayerPaint.Color color = new LayerPaint.Color("#000000");
        getBinding().signaturePad.setPenColor(color.colorInt());
        getColorsViewModel().changeSelectedColorPaint(color);
    }

    /* access modifiers changed from: private */
    public final void onCancelButtonTapped() {
        finish();
    }

    /* access modifiers changed from: private */
    public final void submitSignatureContent(MediaContent mediaContent) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_MEDIA_CONTENT, mediaContent);
        setResult(-1, intent);
        finish();
    }

    private final void setSignatureHintEnabled(boolean z) {
        if (z) {
            TextView textView = getBinding().signatureHintView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.signatureHintView");
            textView.setVisibility(0);
            getBinding().signatureHintView.startAnimation(AnimationUtils.loadAnimation(this, C4175R.anim.anim_signature_hint));
            return;
        }
        getBinding().signatureHintView.clearAnimation();
        TextView textView2 = getBinding().signatureHintView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.signatureHintView");
        textView2.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        setSignatureHintEnabled(false);
        super.onDestroy();
    }

    public void onStartSigning() {
        this.isSignatureErased = false;
        setSignatureHintEnabled(false);
    }

    public void onClear() {
        this.isSignatureErased = true;
        setSignatureHintEnabled(true);
    }
}
