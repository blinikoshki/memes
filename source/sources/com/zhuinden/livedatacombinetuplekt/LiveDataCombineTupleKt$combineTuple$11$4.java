package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple12;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\t\"\u0004\b\b\u0010\n\"\u0004\b\t\u0010\u000b\"\u0004\b\n\u0010\f\"\u0004\b\u000b\u0010\r2\b\u0010\u000e\u001a\u0004\u0018\u0001H\u0005H\n¢\u0006\u0004\b\u000f\u0010\u0010"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "t4", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$11$4<T> implements Observer<T4> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$11$4(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T4 t4) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple12 tuple12 = (Tuple12) value;
        this.$mediator.setValue(new Tuple12(tuple12.component1(), tuple12.component2(), tuple12.component3(), t4, tuple12.component5(), tuple12.component6(), tuple12.component7(), tuple12.component8(), tuple12.component9(), tuple12.component10(), tuple12.component11(), tuple12.component12()));
    }
}
