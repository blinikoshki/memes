package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple15;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\t\"\u0004\b\b\u0010\n\"\u0004\b\t\u0010\u000b\"\u0004\b\n\u0010\f\"\u0004\b\u000b\u0010\r\"\u0004\b\f\u0010\u000e\"\u0004\b\r\u0010\u000f\"\u0004\b\u000e\u0010\u00102\b\u0010\u0011\u001a\u0004\u0018\u0001H\nH\n¢\u0006\u0004\b\u0012\u0010\u0013"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15", "t9", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
final class LiveDataCombineTupleKt$combineTuple$14$9<T> implements Observer<T9> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleKt$combineTuple$14$9(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T9 t9) {
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple15 tuple15 = (Tuple15) value;
        Object component1 = tuple15.component1();
        Object component2 = tuple15.component2();
        Object component3 = tuple15.component3();
        Object component4 = tuple15.component4();
        Object component5 = tuple15.component5();
        Object component6 = tuple15.component6();
        Object component7 = tuple15.component7();
        Object component8 = tuple15.component8();
        Object component10 = tuple15.component10();
        Object component11 = tuple15.component11();
        Object component12 = tuple15.component12();
        Object component13 = tuple15.component13();
        Object component14 = tuple15.component14();
        Object component15 = tuple15.component15();
        MediatorLiveData mediatorLiveData = this.$mediator;
        Tuple15 tuple152 = r2;
        Tuple15 tuple153 = new Tuple15(component1, component2, component3, component4, component5, component6, component7, component8, t9, component10, component11, component12, component13, component14, component15);
        mediatorLiveData.setValue(tuple152);
    }
}
