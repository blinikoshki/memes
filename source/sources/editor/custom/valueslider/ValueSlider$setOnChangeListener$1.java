package editor.custom.valueslider;

import com.google.android.material.slider.Slider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/google/android/material/slider/Slider;", "value", "", "fromUser", "", "onValueChange"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ValueSlider.kt */
final class ValueSlider$setOnChangeListener$1 implements Slider.OnChangeListener {
    final /* synthetic */ Function2 $listener;

    ValueSlider$setOnChangeListener$1(Function2 function2) {
        this.$listener = function2;
    }

    public final void onValueChange(Slider slider, float f, boolean z) {
        Intrinsics.checkNotNullParameter(slider, "<anonymous parameter 0>");
        this.$listener.invoke(Float.valueOf(f), Boolean.valueOf(z));
    }
}
