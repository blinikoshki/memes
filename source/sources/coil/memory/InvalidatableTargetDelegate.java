package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.bitmap.BitmapReferenceCounter;
import coil.target.Target;
import coil.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0019\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, mo26107d2 = {"Lcoil/memory/InvalidatableTargetDelegate;", "Lcoil/memory/TargetDelegate;", "target", "Lcoil/target/Target;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "eventListener", "Lcoil/EventListener;", "logger", "Lcoil/util/Logger;", "(Lcoil/target/Target;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/EventListener;Lcoil/util/Logger;)V", "getTarget", "()Lcoil/target/Target;", "error", "", "result", "Lcoil/request/ErrorResult;", "(Lcoil/request/ErrorResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "placeholder", "Landroid/graphics/drawable/Drawable;", "cached", "Landroid/graphics/Bitmap;", "success", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: TargetDelegate.kt */
public final class InvalidatableTargetDelegate extends TargetDelegate {
    private final EventListener eventListener;
    private final Logger logger;
    private final BitmapReferenceCounter referenceCounter;
    private final Target target;

    public Target getTarget() {
        return this.target;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidatableTargetDelegate(Target target2, BitmapReferenceCounter bitmapReferenceCounter, EventListener eventListener2, Logger logger2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(target2, "target");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.target = target2;
        this.referenceCounter = bitmapReferenceCounter;
        this.eventListener = eventListener2;
        this.logger = logger2;
    }

    public void start(Drawable drawable, Bitmap bitmap) {
        BitmapReferenceCounter bitmapReferenceCounter = this.referenceCounter;
        if (bitmap != null) {
            bitmapReferenceCounter.setValid(bitmap, false);
        }
        getTarget().onStart(drawable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object success(coil.request.SuccessResult r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof coil.memory.InvalidatableTargetDelegate$success$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            coil.memory.InvalidatableTargetDelegate$success$1 r0 = (coil.memory.InvalidatableTargetDelegate$success$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            coil.memory.InvalidatableTargetDelegate$success$1 r0 = new coil.memory.InvalidatableTargetDelegate$success$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r9 = r0.L$1
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r0 = r0.L$0
            coil.request.SuccessResult r0 = (coil.request.SuccessResult) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00c8
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r10)
            coil.bitmap.BitmapReferenceCounter r10 = r8.referenceCounter
            r2 = r9
            coil.request.ImageResult r2 = (coil.request.ImageResult) r2
            android.graphics.Bitmap r4 = coil.memory.TargetDelegateKt.getBitmap(r2)
            if (r4 == 0) goto L_0x004d
            r5 = 0
            r10.setValid(r4, r5)
        L_0x004d:
            coil.target.Target r10 = r8.getTarget()
            coil.EventListener r4 = r8.eventListener
            coil.util.Logger r5 = r8.logger
            coil.request.ImageRequest r6 = r9.getRequest()
            coil.transition.Transition r6 = r6.getTransition()
            coil.transition.Transition r7 = coil.transition.Transition.NONE
            if (r6 != r7) goto L_0x0069
            android.graphics.drawable.Drawable r9 = r9.getDrawable()
            r10.onSuccess(r9)
            goto L_0x00cf
        L_0x0069:
            boolean r7 = r10 instanceof coil.transition.TransitionTarget
            if (r7 != 0) goto L_0x00b0
            coil.request.ImageRequest r0 = r9.getRequest()
            coil.request.DefinedRequestOptions r0 = r0.getDefined()
            coil.transition.Transition r0 = r0.getTransition()
            if (r0 == 0) goto L_0x00a8
            if (r5 == 0) goto L_0x00a8
            r0 = 3
            int r1 = r5.getLevel()
            if (r1 > r0) goto L_0x00a8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Ignoring '"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = "' as '"
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = "' does not implement coil.transition.TransitionTarget."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.String r3 = "TargetDelegate"
            r5.log(r3, r0, r1, r2)
        L_0x00a8:
            android.graphics.drawable.Drawable r9 = r9.getDrawable()
            r10.onSuccess(r9)
            goto L_0x00cf
        L_0x00b0:
            coil.request.ImageRequest r5 = r9.getRequest()
            r4.transitionStart(r5)
            coil.transition.TransitionTarget r10 = (coil.transition.TransitionTarget) r10
            r0.L$0 = r9
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r10 = r6.transition(r10, r2, r0)
            if (r10 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            r0 = r9
            r9 = r4
        L_0x00c8:
            coil.request.ImageRequest r10 = r0.getRequest()
            r9.transitionEnd(r10)
        L_0x00cf:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.InvalidatableTargetDelegate.success(coil.request.SuccessResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object error(coil.request.ErrorResult r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof coil.memory.InvalidatableTargetDelegate$error$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            coil.memory.InvalidatableTargetDelegate$error$1 r0 = (coil.memory.InvalidatableTargetDelegate$error$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            coil.memory.InvalidatableTargetDelegate$error$1 r0 = new coil.memory.InvalidatableTargetDelegate$error$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r8 = r0.L$1
            coil.EventListener r8 = (coil.EventListener) r8
            java.lang.Object r0 = r0.L$0
            coil.request.ErrorResult r0 = (coil.request.ErrorResult) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00bc
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r9)
            coil.target.Target r9 = r7.getTarget()
            coil.EventListener r2 = r7.eventListener
            coil.util.Logger r4 = r7.logger
            coil.request.ImageRequest r5 = r8.getRequest()
            coil.transition.Transition r5 = r5.getTransition()
            coil.transition.Transition r6 = coil.transition.Transition.NONE
            if (r5 != r6) goto L_0x005a
            android.graphics.drawable.Drawable r8 = r8.getDrawable()
            r9.onError(r8)
            goto L_0x00c3
        L_0x005a:
            boolean r6 = r9 instanceof coil.transition.TransitionTarget
            if (r6 != 0) goto L_0x00a1
            coil.request.ImageRequest r0 = r8.getRequest()
            coil.request.DefinedRequestOptions r0 = r0.getDefined()
            coil.transition.Transition r0 = r0.getTransition()
            if (r0 == 0) goto L_0x0099
            if (r4 == 0) goto L_0x0099
            r0 = 3
            int r1 = r4.getLevel()
            if (r1 > r0) goto L_0x0099
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Ignoring '"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = "' as '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "' does not implement coil.transition.TransitionTarget."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.String r3 = "TargetDelegate"
            r4.log(r3, r0, r1, r2)
        L_0x0099:
            android.graphics.drawable.Drawable r8 = r8.getDrawable()
            r9.onError(r8)
            goto L_0x00c3
        L_0x00a1:
            coil.request.ImageRequest r4 = r8.getRequest()
            r2.transitionStart(r4)
            coil.transition.TransitionTarget r9 = (coil.transition.TransitionTarget) r9
            r4 = r8
            coil.request.ImageResult r4 = (coil.request.ImageResult) r4
            r0.L$0 = r8
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r9 = r5.transition(r9, r4, r0)
            if (r9 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            r0 = r8
            r8 = r2
        L_0x00bc:
            coil.request.ImageRequest r9 = r0.getRequest()
            r8.transitionEnd(r9)
        L_0x00c3:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.InvalidatableTargetDelegate.error(coil.request.ErrorResult, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
