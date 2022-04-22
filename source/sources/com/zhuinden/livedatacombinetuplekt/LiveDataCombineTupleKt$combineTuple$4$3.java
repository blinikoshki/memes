package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple5;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "T5", "t3", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$4$3<T> implements Observer<T3> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$4$3(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T3 t3) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple5 tuple5 = (Tuple5) value;
        this.$mediator.setValue(new Tuple5(tuple5.component1(), tuple5.component2(), t3, tuple5.component4(), tuple5.component5()));
    }
}
