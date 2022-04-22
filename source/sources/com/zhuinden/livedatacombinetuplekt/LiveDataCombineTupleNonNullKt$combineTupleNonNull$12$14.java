package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple13;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000f\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u0003\"\b\b\u0005\u0010\b*\u00020\u0003\"\b\b\u0006\u0010\t*\u00020\u0003\"\b\b\u0007\u0010\n*\u00020\u0003\"\b\b\b\u0010\u000b*\u00020\u0003\"\b\b\t\u0010\f*\u00020\u0003\"\b\b\n\u0010\r*\u00020\u0003\"\b\b\u000b\u0010\u000e*\u00020\u0003\"\b\b\f\u0010\u000f*\u00020\u00032\u0006\u0010\u0010\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0011\u0010\u0012"}, mo26107d2 = {"<anonymous>", "", "T1", "", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "t1", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTupleNonNull.kt */
final class LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$14<T> implements Observer<T1> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$14(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T1 t1) {
        T1 t12 = t1;
        Intrinsics.checkNotNullParameter(t12, "t1");
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple13 tuple13 = (Tuple13) value;
        Object component2 = tuple13.component2();
        Object component3 = tuple13.component3();
        Object component4 = tuple13.component4();
        Object component5 = tuple13.component5();
        Object component6 = tuple13.component6();
        Object component7 = tuple13.component7();
        Object component8 = tuple13.component8();
        Object component9 = tuple13.component9();
        Object component10 = tuple13.component10();
        Object component11 = tuple13.component11();
        Object component12 = tuple13.component12();
        Object component13 = tuple13.component13();
        MediatorLiveData mediatorLiveData = this.$mediator;
        Tuple13 tuple132 = r2;
        Tuple13 tuple133 = new Tuple13(t12, component2, component3, component4, component5, component6, component7, component8, component9, component10, component11, component12, component13);
        mediatorLiveData.setValue(tuple133);
    }
}
