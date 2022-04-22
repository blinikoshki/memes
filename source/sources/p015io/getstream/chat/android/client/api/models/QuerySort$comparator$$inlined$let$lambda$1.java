package p015io.getstream.chat.android.client.api.models;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.reflect.KProperty1;
import p015io.getstream.chat.android.client.api.models.QuerySort;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, mo26107d2 = {"<anonymous>", "", "T", "", "c0", "kotlin.jvm.PlatformType", "c1", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "io/getstream/chat/android/client/api/models/QuerySort$comparator$2$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.QuerySort$comparator$$inlined$let$lambda$1 */
/* compiled from: QuerySort.kt */
final class QuerySort$comparator$$inlined$let$lambda$1<T> implements Comparator<T> {
    final /* synthetic */ KProperty1 $compareProperty;
    final /* synthetic */ QuerySort.SortDirection $sortDirection$inlined;

    QuerySort$comparator$$inlined$let$lambda$1(KProperty1 kProperty1, QuerySort.SortDirection sortDirection) {
        this.$compareProperty = kProperty1;
        this.$sortDirection$inlined = sortDirection;
    }

    public final int compare(T t, T t2) {
        Object call = this.$compareProperty.getGetter().call(t);
        Integer num = null;
        if (!(call instanceof Comparable)) {
            call = null;
        }
        Comparable comparable = (Comparable) call;
        if (comparable == null) {
            return 0;
        }
        Object call2 = this.$compareProperty.getGetter().call(t2);
        if (!(call2 instanceof Comparable)) {
            call2 = null;
        }
        Comparable comparable2 = (Comparable) call2;
        if (comparable2 != null) {
            num = Integer.valueOf(comparable.compareTo(comparable2) * this.$sortDirection$inlined.getValue());
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
