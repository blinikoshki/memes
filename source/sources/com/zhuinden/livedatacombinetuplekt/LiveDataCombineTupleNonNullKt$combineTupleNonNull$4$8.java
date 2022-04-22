package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple5;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u00032\u0006\u0010\b\u001a\u0002H\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, mo26107d2 = {"<anonymous>", "", "T1", "", "T2", "T3", "T4", "T5", "t3", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTupleNonNull.kt */
final class LiveDataCombineTupleNonNullKt$combineTupleNonNull$4$8<T> implements Observer<T3> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleNonNullKt$combineTupleNonNull$4$8(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T3 t3) {
        Intrinsics.checkNotNullParameter(t3, "t3");
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple5 tuple5 = (Tuple5) value;
        this.$mediator.setValue(new Tuple5(tuple5.component1(), tuple5.component2(), t3, tuple5.component4(), tuple5.component5()));
    }
}
