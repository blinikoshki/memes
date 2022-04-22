package editor.custom.valueslider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.slider.Slider;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NCustomValueSliderBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001cJ>\u0010\u001f\u001a\u00020\u001626\u0010 \u001a2\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00160!J\u0010\u0010&\u001a\u00020\u00162\b\b\u0001\u0010'\u001a\u00020(J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001cR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo26107d2 = {"Leditor/custom/valueslider/ValueSlider;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NCustomValueSliderBinding;", "getBinding", "()Lcom/memes/editor/databinding/NCustomValueSliderBinding;", "binding$delegate", "Lkotlin/Lazy;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "title", "", "onFinishInflate", "", "setEnabled", "enabled", "", "setMaxValue", "maxValue", "", "setMinValue", "minValue", "setOnChangeListener", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "fromUser", "setTitle", "titleRes", "", "setValue", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ValueSlider.kt */
public final class ValueSlider extends FrameLayout {
    private final Lazy binding$delegate = LazyKt.lazy(new ValueSlider$binding$2(this));
    private final Lazy layoutInflater$delegate;
    private String title = "";

    private final NCustomValueSliderBinding getBinding() {
        return (NCustomValueSliderBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValueSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutInflater$delegate = LazyKt.lazy(new ValueSlider$layoutInflater$2(context));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.ValueSlider, 0, 0);
            try {
                String string = obtainStyledAttributes.getString(C4175R.styleable.ValueSlider_vs_title);
                if (string == null) {
                    string = this.title;
                }
                this.title = string;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        setTitle(this.title);
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        CharSequence charSequence = str;
        if (StringsKt.isBlank(charSequence)) {
            TextView textView = getBinding().titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = getBinding().titleTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleTextView");
        textView2.setText(charSequence);
        TextView textView3 = getBinding().titleTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleTextView");
        textView3.setVisibility(0);
    }

    public final void setTitle(int i) {
        getBinding().titleTextView.setText(i);
    }

    public final void setValue(float f) {
        Slider slider = getBinding().slider;
        Intrinsics.checkNotNullExpressionValue(slider, "binding.slider");
        slider.setValue(f);
    }

    public final void setMinValue(float f) {
        Slider slider = getBinding().slider;
        Intrinsics.checkNotNullExpressionValue(slider, "binding.slider");
        slider.setValueFrom(f);
    }

    public final void setMaxValue(float f) {
        Slider slider = getBinding().slider;
        Intrinsics.checkNotNullExpressionValue(slider, "binding.slider");
        slider.setValueTo(f);
    }

    public final void setOnChangeListener(Function2<? super Float, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getBinding().slider.addOnChangeListener(new ValueSlider$setOnChangeListener$1(function2));
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        Slider slider = getBinding().slider;
        Intrinsics.checkNotNullExpressionValue(slider, "binding.slider");
        slider.setEnabled(z);
        float f = z ? 1.0f : 0.2f;
        NCustomValueSliderBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        binding.getRoot().animate().alpha(f);
    }
}
