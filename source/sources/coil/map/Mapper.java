package coil.map;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, mo26107d2 = {"Lcoil/map/Mapper;", "T", "", "V", "handles", "", "data", "(Ljava/lang/Object;)Z", "map", "(Ljava/lang/Object;)Ljava/lang/Object;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: Mapper.kt */
public interface Mapper<T, V> {

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
    /* compiled from: Mapper.kt */
    public static final class DefaultImpls {
        public static <T, V> boolean handles(Mapper<T, V> mapper, T t) {
            Intrinsics.checkNotNullParameter(t, "data");
            return true;
        }
    }

    boolean handles(T t);

    V map(T t);
}
