package editor.editor.showcase;

import editor.custom.valueslider.ValueSlider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, mo26107d2 = {"<anonymous>", "", "Leditor/custom/valueslider/ValueSlider;", "invoke", "editor/editor/showcase/ShowcaseActivity$initColorAdjustSliderSheet$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: editor.editor.showcase.ShowcaseActivity$initColorAdjustSliderSheet$$inlined$apply$lambda$1 */
/* compiled from: ShowcaseActivity.kt */
final class C4720x6bc8de07 extends Lambda implements Function1<ValueSlider, Unit> {
    final /* synthetic */ ShowcaseActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C4720x6bc8de07(ShowcaseActivity showcaseActivity) {
        super(1);
        this.this$0 = showcaseActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ValueSlider) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ValueSlider valueSlider) {
        Intrinsics.checkNotNullParameter(valueSlider, "$receiver");
        valueSlider.setMinValue(0.0f);
        valueSlider.setMaxValue(100.0f);
        valueSlider.setValue(50.0f);
        valueSlider.setOnChangeListener(new Function2<Float, Boolean, Unit>(this) {
            final /* synthetic */ C4720x6bc8de07 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).floatValue(), ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f, boolean z) {
                ShowcaseActivity showcaseActivity = this.this$0.this$0;
                showcaseActivity.showMessage("Value Changed: " + f);
            }
        });
    }
}
