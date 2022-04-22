package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "t1", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$2$1<T> implements Observer<T1> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$2$1(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T1 t1) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Triple triple = (Triple) value;
        this.$mediator.setValue(new Triple(t1, triple.component2(), triple.component3()));
    }
}
