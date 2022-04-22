package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple10;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\t\"\u0004\b\b\u0010\n\"\u0004\b\t\u0010\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\u0006H\n¢\u0006\u0004\b\r\u0010\u000e"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "t5", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$9$5<T> implements Observer<T5> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$9$5(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T5 t5) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple10 tuple10 = (Tuple10) value;
        this.$mediator.setValue(new Tuple10(tuple10.component1(), tuple10.component2(), tuple10.component3(), tuple10.component4(), t5, tuple10.component6(), tuple10.component7(), tuple10.component8(), tuple10.component9(), tuple10.component10()));
    }
}
