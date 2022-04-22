package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u001f\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Landroidx/lifecycle/PairObserver;", "T", "R", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "onPairValueChanged", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;)V", "onChanged", "pair", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PairObserver.kt */
public final class PairObserver<T, R> implements Observer<Pair<? extends T, ? extends R>> {
    private final Function2<T, R, Unit> onPairValueChanged;

    public PairObserver(Function2<? super T, ? super R, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onPairValueChanged");
        this.onPairValueChanged = function2;
    }

    public void onChanged(Pair<? extends T, ? extends R> pair) {
        if (pair != null) {
            this.onPairValueChanged.invoke(pair.getFirst(), pair.getSecond());
        }
    }
}
