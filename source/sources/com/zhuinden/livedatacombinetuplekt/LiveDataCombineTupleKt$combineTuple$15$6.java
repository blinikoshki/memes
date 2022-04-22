package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple16;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\t\"\u0004\b\b\u0010\n\"\u0004\b\t\u0010\u000b\"\u0004\b\n\u0010\f\"\u0004\b\u000b\u0010\r\"\u0004\b\f\u0010\u000e\"\u0004\b\r\u0010\u000f\"\u0004\b\u000e\u0010\u0010\"\u0004\b\u000f\u0010\u00112\b\u0010\u0012\u001a\u0004\u0018\u0001H\u0007H\n¢\u0006\u0004\b\u0013\u0010\u0014"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15", "T16", "t6", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$15$6<T> implements Observer<T6> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$15$6(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T6 t6) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple16 tuple16 = (Tuple16) value;
        Object component1 = tuple16.component1();
        Object component2 = tuple16.component2();
        Object component3 = tuple16.component3();
        Object component4 = tuple16.component4();
        Object component5 = tuple16.component5();
        Object component7 = tuple16.component7();
        Object component8 = tuple16.component8();
        Object component9 = tuple16.component9();
        Object component10 = tuple16.component10();
        Object component11 = tuple16.component11();
        Object component12 = tuple16.component12();
        Object component13 = tuple16.component13();
        Object component14 = tuple16.component14();
        Object component15 = tuple16.component15();
        Object component16 = tuple16.component16();
        this.$mediator.setValue(new Tuple16(component1, component2, component3, component4, component5, t6, component7, component8, component9, component10, component11, component12, component13, component14, component15, component16));
    }
}
