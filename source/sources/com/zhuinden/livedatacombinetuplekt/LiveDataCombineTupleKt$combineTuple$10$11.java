package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple11;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\t\"\u0004\b\b\u0010\n\"\u0004\b\t\u0010\u000b\"\u0004\b\n\u0010\f2\b\u0010\r\u001a\u0004\u0018\u0001H\fH\n¢\u0006\u0004\b\u000e\u0010\u000f"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "t11", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$10$11<T> implements Observer<T11> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$10$11(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T11 t11) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple11 tuple11 = (Tuple11) value;
        this.$mediator.setValue(new Tuple11(tuple11.component1(), tuple11.component2(), tuple11.component3(), tuple11.component4(), tuple11.component5(), tuple11.component6(), tuple11.component7(), tuple11.component8(), tuple11.component9(), tuple11.component10(), t11));
    }
}
