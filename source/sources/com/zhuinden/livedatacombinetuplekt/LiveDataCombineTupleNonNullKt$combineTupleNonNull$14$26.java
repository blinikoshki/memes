package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple15;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u0003\"\b\b\u0005\u0010\b*\u00020\u0003\"\b\b\u0006\u0010\t*\u00020\u0003\"\b\b\u0007\u0010\n*\u00020\u0003\"\b\b\b\u0010\u000b*\u00020\u0003\"\b\b\t\u0010\f*\u00020\u0003\"\b\b\n\u0010\r*\u00020\u0003\"\b\b\u000b\u0010\u000e*\u00020\u0003\"\b\b\f\u0010\u000f*\u00020\u0003\"\b\b\r\u0010\u0010*\u00020\u0003\"\b\b\u000e\u0010\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\rH\n¢\u0006\u0004\b\u0013\u0010\u0014"}, mo26107d2 = {"<anonymous>", "", "T1", "", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15", "t11", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTupleNonNull.kt */
final class LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$26<T> implements Observer<T11> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$26(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T11 t11) {
        T11 t112 = t11;
        Intrinsics.checkNotNullParameter(t112, "t11");
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple15 tuple15 = (Tuple15) value;
        Object component1 = tuple15.component1();
        Object component2 = tuple15.component2();
        Object component3 = tuple15.component3();
        Object component4 = tuple15.component4();
        Object component5 = tuple15.component5();
        Object component6 = tuple15.component6();
        Object component7 = tuple15.component7();
        Object component8 = tuple15.component8();
        Object component9 = tuple15.component9();
        Object component10 = tuple15.component10();
        Object component12 = tuple15.component12();
        Object component13 = tuple15.component13();
        Object component14 = tuple15.component14();
        Object component15 = tuple15.component15();
        MediatorLiveData mediatorLiveData = this.$mediator;
        Tuple15 tuple152 = r2;
        Tuple15 tuple153 = new Tuple15(component1, component2, component3, component4, component5, component6, component7, component8, component9, component10, t112, component12, component13, component14, component15);
        mediatorLiveData.setValue(tuple153);
    }
}
