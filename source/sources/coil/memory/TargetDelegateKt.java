package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.target.Target;
import coil.transition.Transition;
import coil.transition.TransitionTarget;
import coil.util.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHHø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a/\u0010\u0011\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHHø\u0001\u0000¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo26107d2 = {"TAG", "", "bitmap", "Landroid/graphics/Bitmap;", "Lcoil/request/ImageResult;", "getBitmap", "(Lcoil/request/ImageResult;)Landroid/graphics/Bitmap;", "onError", "", "Lcoil/target/Target;", "result", "Lcoil/request/ErrorResult;", "eventListener", "Lcoil/EventListener;", "logger", "Lcoil/util/Logger;", "(Lcoil/target/Target;Lcoil/request/ErrorResult;Lcoil/EventListener;Lcoil/util/Logger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSuccess", "Lcoil/request/SuccessResult;", "(Lcoil/target/Target;Lcoil/request/SuccessResult;Lcoil/EventListener;Lcoil/util/Logger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: TargetDelegate.kt */
public final class TargetDelegateKt {
    private static final String TAG = "TargetDelegate";

    /* access modifiers changed from: private */
    public static final Bitmap getBitmap(ImageResult imageResult) {
        Drawable drawable = imageResult.getDrawable();
        if (!(drawable instanceof BitmapDrawable)) {
            drawable = null;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getBitmap();
        }
        return null;
    }

    private static final /* synthetic */ Object onSuccess(Target target, SuccessResult successResult, EventListener eventListener, Logger logger, Continuation<? super Unit> continuation) {
        Transition transition = successResult.getRequest().getTransition();
        if (transition == Transition.NONE) {
            target.onSuccess(successResult.getDrawable());
            return Unit.INSTANCE;
        } else if (!(target instanceof TransitionTarget)) {
            if (!(successResult.getRequest().getDefined().getTransition() == null || logger == null || logger.getLevel() > 3)) {
                logger.log(TAG, 3, "Ignoring '" + transition + "' as '" + target + "' does not implement coil.transition.TransitionTarget.", (Throwable) null);
            }
            target.onSuccess(successResult.getDrawable());
            return Unit.INSTANCE;
        } else {
            eventListener.transitionStart(successResult.getRequest());
            InlineMarker.mark(0);
            transition.transition((TransitionTarget) target, successResult, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            eventListener.transitionEnd(successResult.getRequest());
            return Unit.INSTANCE;
        }
    }

    private static final /* synthetic */ Object onError(Target target, ErrorResult errorResult, EventListener eventListener, Logger logger, Continuation<? super Unit> continuation) {
        Transition transition = errorResult.getRequest().getTransition();
        if (transition == Transition.NONE) {
            target.onError(errorResult.getDrawable());
            return Unit.INSTANCE;
        } else if (!(target instanceof TransitionTarget)) {
            if (!(errorResult.getRequest().getDefined().getTransition() == null || logger == null || logger.getLevel() > 3)) {
                logger.log(TAG, 3, "Ignoring '" + transition + "' as '" + target + "' does not implement coil.transition.TransitionTarget.", (Throwable) null);
            }
            target.onError(errorResult.getDrawable());
            return Unit.INSTANCE;
        } else {
            eventListener.transitionStart(errorResult.getRequest());
            InlineMarker.mark(0);
            transition.transition((TransitionTarget) target, errorResult, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            eventListener.transitionEnd(errorResult.getRequest());
            return Unit.INSTANCE;
        }
    }
}
