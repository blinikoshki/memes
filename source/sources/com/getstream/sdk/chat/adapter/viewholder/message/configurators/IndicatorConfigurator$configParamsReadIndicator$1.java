package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import androidx.constraintlayout.widget.ConstraintSet;
import com.getstream.sdk.chat.C1673R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "Landroidx/constraintlayout/widget/ConstraintSet;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: IndicatorConfigurator.kt */
final class IndicatorConfigurator$configParamsReadIndicator$1 extends Lambda implements Function1<ConstraintSet, Unit> {
    public static final IndicatorConfigurator$configParamsReadIndicator$1 INSTANCE = new IndicatorConfigurator$configParamsReadIndicator$1();

    IndicatorConfigurator$configParamsReadIndicator$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstraintSet) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ConstraintSet constraintSet) {
        Intrinsics.checkNotNullParameter(constraintSet, "$receiver");
        constraintSet.clear(C1673R.C1677id.read_state, 6);
        constraintSet.clear(C1673R.C1677id.read_state, 7);
        constraintSet.clear(C1673R.C1677id.read_state, 4);
    }
}
