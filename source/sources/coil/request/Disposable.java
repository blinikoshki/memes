package coil.request;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, mo26107d2 = {"Lcoil/request/Disposable;", "", "isDisposed", "", "()Z", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: Disposable.kt */
public interface Disposable {
    Object await(Continuation<? super Unit> continuation);

    void dispose();

    boolean isDisposed();
}
