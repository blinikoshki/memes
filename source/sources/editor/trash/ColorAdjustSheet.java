package editor.trash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.memes.editor.databinding.NCompColorAdjustBinding;
import editor.common.colorshadeselector.ColorShadeSelector;
import editor.custom.valueslider.ValueSlider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u001f\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017¢\u0006\u0002\b\u0019J\u001f\u0010\u001a\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u0017¢\u0006\u0002\b\u0019R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, mo26107d2 = {"Leditor/trash/ColorAdjustSheet;", "Leditor/trash/HeaderFooterSheet;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NCompColorAdjustBinding;", "getBinding", "()Lcom/memes/editor/databinding/NCompColorAdjustBinding;", "binding$delegate", "Lkotlin/Lazy;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "onFinishInflate", "", "updateOpacitySlider", "block", "Lkotlin/Function1;", "Leditor/custom/valueslider/ValueSlider;", "Lkotlin/ExtensionFunctionType;", "updateShadeSelector", "Leditor/common/colorshadeselector/ColorShadeSelector;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ColorAdjustSheet.kt */
public final class ColorAdjustSheet extends HeaderFooterSheet {
    private final Lazy binding$delegate = LazyKt.lazy(new ColorAdjustSheet$binding$2(this));
    private final Lazy layoutInflater$delegate;

    private final NCompColorAdjustBinding getBinding() {
        return (NCompColorAdjustBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ColorAdjustSheet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutInflater$delegate = LazyKt.lazy(new ColorAdjustSheet$layoutInflater$2(context));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
    }

    public final void updateOpacitySlider(Function1<? super ValueSlider, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ValueSlider valueSlider = getBinding().opacitySlider;
        Intrinsics.checkNotNullExpressionValue(valueSlider, "binding.opacitySlider");
        function1.invoke(valueSlider);
    }

    public final void updateShadeSelector(Function1<? super ColorShadeSelector, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ColorShadeSelector colorShadeSelector = getBinding().shadeSelector;
        Intrinsics.checkNotNullExpressionValue(colorShadeSelector, "binding.shadeSelector");
        function1.invoke(colorShadeSelector);
    }
}
