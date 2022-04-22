package coil.size;

import android.view.ViewTreeObserver;
import coil.size.ViewSizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, mo26107d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "it", "", "invoke", "coil/size/ViewSizeResolver$size$3$1"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* renamed from: coil.size.ViewSizeResolver$size$$inlined$suspendCancellableCoroutine$lambda$2 */
/* compiled from: ViewSizeResolver.kt */
final class C0940xc6aa5ea3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ C0939xc6aa5ea2 $preDrawListener;
    final /* synthetic */ ViewTreeObserver $viewTreeObserver;
    final /* synthetic */ ViewSizeResolver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0940xc6aa5ea3(ViewTreeObserver viewTreeObserver, C0939xc6aa5ea2 viewSizeResolver$size$$inlined$suspendCancellableCoroutine$lambda$1, ViewSizeResolver viewSizeResolver) {
        super(1);
        this.$viewTreeObserver = viewTreeObserver;
        this.$preDrawListener = viewSizeResolver$size$$inlined$suspendCancellableCoroutine$lambda$1;
        this.this$0 = viewSizeResolver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        ViewSizeResolver viewSizeResolver = this.this$0;
        ViewTreeObserver viewTreeObserver = this.$viewTreeObserver;
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
        ViewSizeResolver.DefaultImpls.removePreDrawListenerSafe(viewSizeResolver, viewTreeObserver, this.$preDrawListener);
    }
}
