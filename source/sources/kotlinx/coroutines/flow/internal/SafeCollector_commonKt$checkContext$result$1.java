package kotlinx.coroutines.flow.internal;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {
    final /* synthetic */ SafeCollector $this_checkContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeCollector_commonKt$checkContext$result$1(SafeCollector safeCollector) {
        super(2);
        this.$this_checkContext = safeCollector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke(((Number) obj).intValue(), (CoroutineContext.Element) obj2));
    }

    public final int invoke(int i, CoroutineContext.Element element) {
        CoroutineContext.Key key = element.getKey();
        CoroutineContext.Element element2 = this.$this_checkContext.collectContext.get(key);
        if (key == Job.Key) {
            Job job = (Job) element2;
            Objects.requireNonNull(element, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            Job transitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((Job) element, job);
            if (transitiveCoroutineParent == job) {
                return job == null ? i : i + 1;
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n" + "\t\tChild of " + transitiveCoroutineParent + ", expected child of " + job + ".\n" + "\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n" + "\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        } else if (element != element2) {
            return Integer.MIN_VALUE;
        } else {
            return i + 1;
        }
    }
}
