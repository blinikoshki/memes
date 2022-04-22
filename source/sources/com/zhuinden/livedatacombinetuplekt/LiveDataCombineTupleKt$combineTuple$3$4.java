package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "t4", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$3$4<T> implements Observer<T4> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$3$4(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T4 t4) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple4 tuple4 = (Tuple4) value;
        this.$mediator.setValue(new Tuple4(tuple4.component1(), tuple4.component2(), tuple4.component3(), t4));
    }
}
