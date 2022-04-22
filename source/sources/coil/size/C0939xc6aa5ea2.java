package coil.size;

import android.view.ViewTreeObserver;
import coil.size.ViewSizeResolver;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005¸\u0006\u0000"}, mo26107d2 = {"coil/size/ViewSizeResolver$size$3$preDrawListener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "isResumed", "", "onPreDraw", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* renamed from: coil.size.ViewSizeResolver$size$$inlined$suspendCancellableCoroutine$lambda$1 */
/* compiled from: ViewSizeResolver.kt */
public final class C0939xc6aa5ea2 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ CancellableContinuation $continuation;
    final /* synthetic */ ViewTreeObserver $viewTreeObserver;
    private boolean isResumed;
    final /* synthetic */ ViewSizeResolver this$0;

    C0939xc6aa5ea2(ViewTreeObserver viewTreeObserver, CancellableContinuation cancellableContinuation, ViewSizeResolver viewSizeResolver) {
        this.$viewTreeObserver = viewTreeObserver;
        this.$continuation = cancellableContinuation;
        this.this$0 = viewSizeResolver;
    }

    public boolean onPreDraw() {
        PixelSize access$getSize = ViewSizeResolver.DefaultImpls.getSize(this.this$0);
        if (access$getSize != null) {
            ViewSizeResolver viewSizeResolver = this.this$0;
            ViewTreeObserver viewTreeObserver = this.$viewTreeObserver;
            Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
            ViewSizeResolver.DefaultImpls.removePreDrawListenerSafe(viewSizeResolver, viewTreeObserver, this);
            if (!this.isResumed) {
                this.isResumed = true;
                Result.Companion companion = Result.Companion;
                this.$continuation.resumeWith(Result.m1029constructorimpl(access$getSize));
            }
        }
        return true;
    }
}
