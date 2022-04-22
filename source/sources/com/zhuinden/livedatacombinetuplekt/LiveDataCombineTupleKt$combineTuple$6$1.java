package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b2\b\u0010\t\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\n\u0010\u000b"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "t1", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$6$1<T> implements Observer<T1> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$6$1(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T1 t1) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple7 tuple7 = (Tuple7) value;
        this.$mediator.setValue(new Tuple7(t1, tuple7.component2(), tuple7.component3(), tuple7.component4(), tuple7.component5(), tuple7.component6(), tuple7.component7()));
    }
}
