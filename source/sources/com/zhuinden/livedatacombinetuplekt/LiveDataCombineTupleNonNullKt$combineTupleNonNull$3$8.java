package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u00032\u0006\u0010\u0007\u001a\u0002H\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, mo26107d2 = {"<anonymous>", "", "T1", "", "T2", "T3", "T4", "t4", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTupleNonNull.kt */
final class LiveDataCombineTupleNonNullKt$combineTupleNonNull$3$8<T> implements Observer<T4> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleNonNullKt$combineTupleNonNull$3$8(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T4 t4) {
        Intrinsics.checkNotNullParameter(t4, "t4");
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple4 tuple4 = (Tuple4) value;
        this.$mediator.setValue(new Tuple4(tuple4.component1(), tuple4.component2(), tuple4.component3(), t4));
    }
}
