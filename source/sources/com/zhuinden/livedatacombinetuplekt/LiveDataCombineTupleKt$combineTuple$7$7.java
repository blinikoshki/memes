package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\t2\b\u0010\n\u001a\u0004\u0018\u0001H\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "t7", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$7$7<T> implements Observer<T7> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$7$7(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T7 t7) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple8 tuple8 = (Tuple8) value;
        this.$mediator.setValue(new Tuple8(tuple8.component1(), tuple8.component2(), tuple8.component3(), tuple8.component4(), tuple8.component5(), tuple8.component6(), t7, tuple8.component8()));
    }
}
