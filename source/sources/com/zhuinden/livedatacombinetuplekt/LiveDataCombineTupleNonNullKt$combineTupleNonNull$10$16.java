package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhuinden.tupleskt.Tuple11;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u0003\"\b\b\u0005\u0010\b*\u00020\u0003\"\b\b\u0006\u0010\t*\u00020\u0003\"\b\b\u0007\u0010\n*\u00020\u0003\"\b\b\b\u0010\u000b*\u00020\u0003\"\b\b\t\u0010\f*\u00020\u0003\"\b\b\n\u0010\r*\u00020\u00032\u0006\u0010\u000e\u001a\u0002H\u0007H\n¢\u0006\u0004\b\u000f\u0010\u0010"}, mo26107d2 = {"<anonymous>", "", "T1", "", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "t5", "onChanged", "(Ljava/lang/Object;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTupleNonNull.kt */
final class LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$16<T> implements Observer<T5> {
    final /* synthetic */ MediatorLiveData $mediator;

    LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$16(MediatorLiveData mediatorLiveData) {
        this.$mediator = mediatorLiveData;
    }

    public final void onChanged(T5 t5) {
        Intrinsics.checkNotNullParameter(t5, "t5");
        Object value = this.$mediator.getValue();
        Intrinsics.checkNotNull(value);
        Tuple11 tuple11 = (Tuple11) value;
        this.$mediator.setValue(new Tuple11(tuple11.component1(), tuple11.component2(), tuple11.component3(), tuple11.component4(), t5, tuple11.component6(), tuple11.component7(), tuple11.component8(), tuple11.component9(), tuple11.component10(), tuple11.component11()));
    }
}
