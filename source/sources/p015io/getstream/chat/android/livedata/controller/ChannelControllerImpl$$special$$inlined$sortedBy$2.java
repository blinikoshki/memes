package p015io.getstream.chat.android.livedata.controller;

import java.util.Comparator;
import java.util.Date;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo26107d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$sortedBy$2 */
/* compiled from: Comparisons.kt */
public final class ChannelControllerImpl$$special$$inlined$sortedBy$2<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        Message message = (Message) t;
        Date createdAt = message.getCreatedAt();
        if (createdAt == null) {
            createdAt = message.getCreatedLocallyAt();
        }
        Comparable comparable = createdAt;
        Message message2 = (Message) t2;
        Date createdAt2 = message2.getCreatedAt();
        if (createdAt2 == null) {
            createdAt2 = message2.getCreatedLocallyAt();
        }
        return ComparisonsKt.compareValues(comparable, createdAt2);
    }
}
