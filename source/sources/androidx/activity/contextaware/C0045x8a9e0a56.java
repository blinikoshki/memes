package androidx.activity.contextaware;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "R", "it", "", "invoke", "androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$1"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* renamed from: androidx.activity.contextaware.ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2 */
/* compiled from: ContextAware.kt */
public final class C0045x8a9e0a56 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ C0044x8a9e0a55 $listener;
    final /* synthetic */ Function1 $onContextAvailable$inlined;
    final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0045x8a9e0a56(C0044x8a9e0a55 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, ContextAware contextAware, Function1 function1) {
        super(1);
        this.$listener = contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        this.$this_withContextAvailable$inlined.removeOnContextAvailableListener(this.$listener);
    }
}
